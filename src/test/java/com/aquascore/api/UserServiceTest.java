package com.aquascore.api;

import com.aquascore.api.models.Role;
import com.aquascore.api.models.User;
import com.aquascore.api.repositories.UserRepository;
import com.aquascore.api.security.JwtTokenProvider;
import com.aquascore.api.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private UserService userService;

    private User dummyUser;
    private final String MOCK_TOKEN = "deadbeefcoffee";

    @Before
    public void setUp() {
        dummyUser = new User("wanderson@hotmail.com", "123", "Wes", "Anderson");
        dummyUser.setRoles(new ArrayList<>(Arrays.asList(Role.ROLE_USER)));

        when(userRepository.findByEmail(eq("wanderson@hotmail.com"))).thenReturn(dummyUser);
        when(userRepository.existsByEmail(eq("wanderson@hotmail.com"))).thenReturn(true);
        when(userRepository.findById(1)).thenReturn(dummyUser);
        when(jwtTokenProvider.createToken(anyString(), any())).thenReturn(MOCK_TOKEN);
    }

    @Test
    public void testFindUserByEmail() {
        User result = userService.findByEmail("wanderson@hotmail.com");

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getFirstName(), dummyUser.getFirstName());
        Assert.assertEquals(result.getLastName(), dummyUser.getLastName());
    }

    @Test
    public void testFindUserById() {
        User result = userService.findById(1);

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getFirstName(), dummyUser.getFirstName());
        Assert.assertEquals(result.getLastName(), dummyUser.getLastName());
    }

    @Test
    public void testSignUp() {
        User newUser = userService.signUp(new User("test@test.com", "123",
            "Tester", "Testington"));

        Assert.assertNotNull(newUser);
        // Ensure password gets hashed
        Assert.assertNotEquals("123", newUser.getPassword());
        Assert.assertNotSame(newUser, dummyUser);
    }

    @Test
    public void testDefaultRole() {
        User newUser = userService.signUp(new User("test@test.com", "123",
            "Tester", "Testington"));
        Assert.assertThat(newUser.getRoles(), hasItems(Role.ROLE_USER));
        Assert.assertThat(dummyUser.getRoles(), hasItems(Role.ROLE_USER));
    }

    @Test(expected = ResponseStatusException.class)
    public void testSignUpExistingEmail() {
        userService.signUp(new User("wanderson@hotmail.com", "123",
            "Tester", "Testington"));
    }

    @Test
    public void testSignIn() {
        Map<String, String> result = userService.signIn("wanderson@hotmail.com",
            "123");

        Assert.assertNotNull(result);
        Assert.assertEquals(MOCK_TOKEN, result.get("token"));
    }

    @Test
    public void testFindByBadId(){
        User result = userService.findById(-500);

        Assert.assertNull(result);
    }

    @Test
    public void testFindByBadEmail(){
        User result = userService.findByEmail("xxxxxxxxxxxxxxxxxx");

        Assert.assertNull(result);
    }

    @Test(expected = ResponseStatusException.class)
    public void testBadSignIn() {
        userService.signIn("ikbestaniet@hotmail.com", "123");
    }
}
