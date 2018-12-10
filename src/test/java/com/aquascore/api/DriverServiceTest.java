package com.aquascore.api;

import com.aquascore.api.models.Driver;
import com.aquascore.api.repositories.DriverRepository;
import com.aquascore.api.repositories.TeamRepository;
import com.aquascore.api.services.DriverService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DriverServiceTest {
    @Mock
    private DriverRepository driverRepository;

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private DriverService driverService;

    private Driver dummyDriver;
    private List<Driver> dummyDrivers;

    @Before
    public void setUp() {
        dummyDriver = new Driver("Mario", "Mario", 30000000);
        dummyDrivers = new ArrayList<>();
        dummyDrivers.add(dummyDriver);

        when(driverService.getAll()).thenReturn(dummyDrivers);
        when(driverService.getById(anyLong())).thenReturn(dummyDriver);
        when(driverRepository.findAllByFirstnameContainingOrLastnameContaining(eq("Mario"), eq("Mario"))).thenReturn(dummyDrivers);
    }

    @Test
    public void testGetAll() {
        List<Driver> result = driverService.getAll();

        Assert.assertThat(result, equalTo(dummyDrivers));
        Assert.assertThat(result, hasSize(1));
    }

    @Test
    public void testById() {
        Driver result = driverService.getById(1);

        Assert.assertThat(result, equalTo(dummyDriver));
        Assert.assertEquals("Mario", result.getFirstname());
        Assert.assertEquals("Mario", result.getLastname());
        Assert.assertEquals(30000000, result.getSalary(), 1);
    }

    @Test
    public void testFindByName() {
        List<Driver> result = driverService.findByName("Mario");

        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void testFindByBadName() {
        List<Driver> result = driverService.findByName(null);

        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testFindByNameNotFound() {
        List<Driver> result = driverService.findByName("Luigi");

        Assert.assertTrue(result.isEmpty());

        result = driverService.findByName("Wario");

        Assert.assertTrue(result.isEmpty());
    }

    @Test(expected = Exception.class)
    public void testRemoveBadId() {
        driverService.remove(-1298252);
    }
}
