package com.example.demo.persistence.dao.entities;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @NotNull
    @Column(unique=true)
    private String userName;

    @Column
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Conference> conferences;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setConferences(List<Conference> conferences) {
        this.conferences = conferences;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
