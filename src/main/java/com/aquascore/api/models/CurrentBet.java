package com.aquascore.api.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "current_bets")
public class CurrentBet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @PrimaryKeyJoinColumn
    @NotNull
    private User user;

    @NotBlank
    @Column
    private String bet;

    @ManyToOne
    @PrimaryKeyJoinColumn
    @NotNull
    private Race race;

    public long getId() {
        return id;
    }

    public Long getUserId() {
        return user.getId();
    }

    public String getBet() {
        return bet;
    }

    public Long getRaceId() {
        return race.getId();
    }

    public void setPoints(String bet) {
        this.bet = bet;
    }
}