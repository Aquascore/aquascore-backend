package com.aquascore.api.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "race_budget")
public class RaceBudget {
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
    private Pool pool;

    @ManyToOne
    @PrimaryKeyJoinColumn
    @NotNull
    private Race race;

    @Column
    private long budget;

    public RaceBudget(User user, Pool pool, Race race, long budget) {
        this.user = user;
        this.pool = pool;
        this.race = race;
        this.budget = budget;
    }
}
