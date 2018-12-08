package com.aquascore.api.models;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

public class PoolTeam{
    private long id;

    // foreign keys
    private long userid;
    private long poolid;
    private long raceid;

    // drivers
    private List<Driver> drivers;

    public long getId(){
        return this.id;
    }

    public long getUserid(){
        return this.userid;
    }

    public long getPoolid(){
        return this.poolid;
    }

    public long getRaceid(){
        return this.raceid;
    }

    public List<Driver> getDrivers(){
        return this.drivers;
    }

    public void setUserid(long id){
        this.userid = id;
    }

    public void setPoolid(long id){
        this.poolid = id;
    }

    public void setRaceid(long id){
        this.raceid = id;
    }

    public void setDrivers(List<Driver> drivers){
        this.drivers = drivers;
    }
 }

