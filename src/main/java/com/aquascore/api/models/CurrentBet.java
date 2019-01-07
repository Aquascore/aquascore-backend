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

    @ManyToOne
    @PrimaryKeyJoinColumn
    @NotNull
    private Bet bet;

    @NotBlank
    @Column
    private String prediction;


    public long getId() {
        return id;
    }

    public Long getUserId() {
        return user.getId();
    }

    public Long getBetId(){
        return bet.getId();
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction){
        this.prediction = prediction;
    }

    public void setUser(User user){
        this.user = user;
    }

    public void setBet(Bet bet){
        this.bet = bet;
    }
}