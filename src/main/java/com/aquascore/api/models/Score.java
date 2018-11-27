package com.aquascore.api.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_score")
public class Score {
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

    @Column
    private Long score;

    public Score() {
    }

    public Score(User user, Pool pool, long score) {
        this.user = user;
        this.pool = pool;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Long getScore() {
        return score;
    }
}
