package com.aquascore.api;

import com.aquascore.api.models.Driver;
import com.aquascore.api.models.Team;
import com.aquascore.api.repositories.DriverRepository;
import com.aquascore.api.repositories.TeamRepository;
import com.aquascore.api.services.TeamService;
import org.hibernate.service.spi.InjectService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.AllPermission;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest


public class TeamServiceTest {
    @Mock
    private TeamRepository teamRepository;

    @Mock
    private DriverRepository driverRepository;

    @InjectMocks
    private TeamService teamService;

    private Team dummyTeam;



    @Before
    public void setUp(){
        dummyTeam = new Team("Red Bull");
        Driver dummyDriver1 = new Driver("Max", "Verstappen",3000000);
        Driver dummyDriver2 = new Driver("Sebastian", "Vettal",1100000);
        Driver dummyDriver3 = new Driver("Super", "Racer",2500000);

        when(teamService.getById(anyLong())).thenReturn(dummyTeam);


        teamService.create(dummyTeam);

    }

    @Test
    public void testById(){
        Team result = teamService.getById(1);

        Assert.assertEquals("Red Bull" , result.getName());
    }


    @Test
    public void testEditTeam(){
        Team expectedTeam = new Team("Mercedes");
        Team team = teamService.getById(1);

        teamService.edit(expectedTeam , 1);

        Assert.assertEquals("Mercedes" , teamService.getById(1).getName());
    }

    @Test
    public void testAddDriver(){
        teamService.addDriver(1,1);

        Driver result = teamService.getById(1).getDrivers().get(0);

        Assert.assertNotNull(result);
        Assert.assertEquals("Max",result.getFirstname());
        Assert.assertEquals("Verstappen",result.getLastname());

    }


    @Test
    public void testGetTeamWrongId(){
        Object result = teamService.getById(-200);

        Assert.assertNull(result);
    }









}
