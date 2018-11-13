package com.aquascore.api.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
public class Team{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    @Column
    private String name;

    @NotBlank
    @Column
    private String teamcol;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "team_drivers",
        joinColumns = {@JoinColumn(name="team_id")}
    )
    private List<Driver> drivers;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamcol() {
        return teamcol;
    }

    public void setTeamcol(String teamcol) {
        this.teamcol = teamcol;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public void addMember(Driver driver){
        if(this.drivers == null) this.drivers = new ArrayList<>();

        this.drivers.add(driver);
    }

    public void removeMember(Driver driver){
        if(this.drivers == null) return;

        this.drivers.remove(driver);
    }
}