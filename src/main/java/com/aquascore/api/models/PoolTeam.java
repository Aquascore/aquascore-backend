package com.aquascore.api.models;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user_teams")
public class PoolTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @PrimaryKeyJoinColumn
    @NotNull
    private User user;

    @ManyToOne
    @PrimaryKeyJoinColumn
    @NotNull
    private Race race;

    @ManyToOne
    @PrimaryKeyJoinColumn
    @NotNull
    private Pool pool;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "poolTeam_drivers",
        joinColumns = {@JoinColumn(name="poolTeam_id")}
    )
    private List<Driver> drivers;

    public Long getId(){
        return this.id;
    }

    public Long getUserid(){
        return this.user.getId();
    }

    public Long getPoolid(){
        return this.pool.getId();
    }

    public Long getRaceid(){
        return this.race.getId();
    }

    public List<Driver> getDrivers(){
        return drivers;
    }

    public void setDrivers(List<Driver> drivers){
        this.drivers = drivers;
    }
 }

