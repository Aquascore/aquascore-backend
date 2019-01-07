package com.aquascore.api.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "race")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private Date date;

    public void setName(String name){
        this.name = name;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public Date getDate(){
        return this.date;
    }
}
