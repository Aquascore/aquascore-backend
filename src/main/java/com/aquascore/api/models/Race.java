package com.aquascore.api.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "race")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private Date date;

    public Race(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public long getId() {
        return id;
    }
}