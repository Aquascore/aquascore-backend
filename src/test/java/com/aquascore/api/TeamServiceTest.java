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

    private List<Team> dummyTeams;



    @Before
    public void setUp(){
        dummyTeam = new Team("Red Bull");
        teamService.create(dummyTeam);

        dummyTeams = new ArrayList<>();
        dummyTeams.add(dummyTeam);

        when(teamService.getAll()).thenReturn(dummyTeams);
        when(teamService.getById(anyLong())).thenReturn(dummyTeam);

        teamService.create(dummyTeam);

    }

    @Test
    public void testById(){
        Team result = teamService.getById(1);

        Assert.assertThat(result, equalTo(dummyTeam));
    }


    @Test
    public void testEditTeam(){
        Team expectedTeam = new Team("Mercedes");
        Team team = teamService.getById(1);

        teamService.edit(expectedTeam , 1);

        Assert.assertEquals("Mercedes" , teamService.getById(1).getName());
    }

    @Test
    public void testAddDriverToTeam(){
        teamService.addDriver(1,1);

        int result = teamService.getById(1).getDrivers().size();

        Assert.assertEquals(1 , result);

    }


    @Test(expected = Exception.class)
    public void testGetTeamWrongId(){
        teamService.remove(-1919191919);
    }









}
