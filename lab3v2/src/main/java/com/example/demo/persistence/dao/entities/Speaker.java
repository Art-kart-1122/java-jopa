package com.example.demo.persistence.dao.entities;

import javax.persistence.*;

@Entity
public class Speaker {
    @Id
    @GeneratedValue
    private Long id;

    private Integer rating;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    public Speaker(Integer rating, User user) {
        this.rating = rating;
        this.user = user;
    }

    public Speaker() {}

}
