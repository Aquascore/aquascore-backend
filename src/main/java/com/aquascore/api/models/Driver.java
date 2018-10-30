package com.aquascore.api.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "driver")
public class Driver{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    @Column(name = "first_name")
    private String firstname;

    @NotBlank
    @Column(name = "last_name")
    private String lastname;

    @NotBlank
    @Column
    private float salary;

    @NotBlank
    @Column(name = "team_id")
    private long teamId;

    public Driver(String firstname, String lastname, float salary, long teamId){
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
        this.teamId = teamId;
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }
}