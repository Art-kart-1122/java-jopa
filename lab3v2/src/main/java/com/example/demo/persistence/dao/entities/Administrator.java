package com.example.demo.persistence.dao.entities;

import javax.persistence.*;

@Entity
public class Administrator {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn()
    private User userId;

    public Administrator(User userId) {
        this.userId = userId;
    }

    public Administrator() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
