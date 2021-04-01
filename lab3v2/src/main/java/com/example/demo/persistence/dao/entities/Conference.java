package com.example.demo.persistence.dao.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Conference {
    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime date;
    private String place;
    private Integer quantityExpectedVisitors;
    private Integer quantityVisited;
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> users;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn()
    private User moderator;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn()
    private Speaker speaker;

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getQuantityExpectedVisitors() {
        return quantityExpectedVisitors;
    }

    public void setQuantityExpectedVisitors(Integer quantityExpectedVisitors) {
        this.quantityExpectedVisitors = quantityExpectedVisitors;
    }

    public Integer getQuantityVisited() {
        return quantityVisited;
    }

    public void setQuantityVisited(Integer quantityVisited) {
        this.quantityVisited = quantityVisited;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
