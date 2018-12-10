package com.aquascore.api.models;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pool")
public class Pool {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotBlank
    private String name;

    @ManyToOne
    @PrimaryKeyJoinColumn
    @NotNull
    private User owner;

    @ManyToOne
    @PrimaryKeyJoinColumn
    @Nullable
    private Pool parent;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "pool_user",
        joinColumns = {@JoinColumn(name = "pool_id")}
    )
    private List<User> users;

    public Pool() {
    }

    public Pool(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public boolean isOwner(User user) {
        return user.equals(owner);
    }

    public void addMember(User user) {
        if (users == null) {
            users = new ArrayList<>();
        }

        users.add(user);
    }

    public void removeMember(User user) {
        if (users == null) {
            return;
        }

        users.remove(user);
    }
}
