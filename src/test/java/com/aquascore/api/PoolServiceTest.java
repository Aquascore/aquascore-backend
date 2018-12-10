package com.aquascore.api;

import com.aquascore.api.models.Pool;
import com.aquascore.api.models.User;
import com.aquascore.api.repositories.PoolRepository;
import com.aquascore.api.repositories.ScoreRepository;
import com.aquascore.api.services.PoolService;
import com.aquascore.api.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PoolServiceTest {
    @Mock
    private PoolRepository poolRepository;

    @Mock
    private ScoreRepository scoreRepository;

    @Mock
    private UserService userService;

    @InjectMocks
    private PoolService poolService;

    private List<User> dummyUsers;
    private User poolOwner;
    private Pool dummyPool;
    private List<Pool> dummyPools;

    HttpServletRequest req;

    @Before
    public void setUp() {
        req = mock(HttpServletRequest.class);

        dummyUsers = new ArrayList<>();
        dummyUsers.add(new User("jmalkovich@gmail.com", "123", "John",
            "Malkovich"));
        dummyUsers.add(new User("wanderson@gmail.com", "123", "Wes",
            "Anderson"));
        poolOwner = dummyUsers.get(0);

        dummyPool = new Pool("Test Pool");
        dummyPool.setOwner(poolOwner);
        dummyPool.setUsers(dummyUsers);

        dummyPools = new ArrayList<>();
        dummyPools.add(dummyPool);

        when(poolRepository.findById(anyLong())).thenReturn(dummyPool);
        when(poolRepository.findByOwner(any())).thenReturn(dummyPools);
        when(poolService.getFromUser(any())).thenReturn(dummyPools);
    }

    @Test
    public void testFindPoolById() {
        Pool result = poolService.getById(1);

        Assert.assertTrue(result.isOwner(poolOwner));
        Assert.assertThat(result.getOwner(), is(poolOwner));
        Assert.assertThat(result.getUsers().size(), is(not(0)));
        Assert.assertThat(result.getUsers(), hasItems(dummyUsers.get(0), dummyUsers.get(1)));
    }

    @Test
    public void testPoolsFromUser() {
        Pool anotherDummyPool = new Pool("Pool For Dummies");
        anotherDummyPool.setOwner(poolOwner);
        anotherDummyPool.setUsers(dummyUsers);
        dummyPools.add(anotherDummyPool);

        List<Pool> result = poolService.getFromUser(req);

        Assert.assertThat(result, equalTo(dummyPools));
    }

    @Test
    public void testCreatePool() {
        Pool newPool = poolService.create(new Pool("Besties"), req);

        Assert.assertNotSame(dummyPool, newPool);
        Assert.assertThat(newPool.getUsers(), hasSize(1));
        Assert.assertThat(newPool.getName(), equalToIgnoringCase("besties"));
    }

    @Test
    public void testAddUser() {
        User newUser = new User("joe@gmail.com", "321", "Jan", "Kan");
        int oldSize = dummyPool.getUsers().size();
        dummyPool.addMember(newUser);
        int newSize = dummyPool.getUsers().size();

        Assert.assertThat(dummyPool.getUsers(), hasItem(newUser));
        Assert.assertThat(newSize, is(greaterThan(oldSize)));
    }

    @Test
    public void testRemoveUser() {
        int oldSize = dummyPool.getUsers().size();
        dummyPool.removeMember(dummyUsers.get(1));
        int newSize = dummyPool.getUsers().size();

        Assert.assertThat(newSize, is(lessThan(oldSize)));
        Assert.assertThat(newSize, is(not(0)));
    }

    @Test(expected = Exception.class)
    public void testAddUserNotOwner() {
        User newUser = new User("joe@gmail.com", "321", "Jan", "Kan");
        poolService.addUser(dummyPool.getId(), newUser.getId(), req);
    }

    @Test(expected = Exception.class)
    public void testRemoveUserNotOwner() {
        poolService.removeUser(dummyPool.getId(), dummyUsers.get(1).getId(), req);
    }
}
