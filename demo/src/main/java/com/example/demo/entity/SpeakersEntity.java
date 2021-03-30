package com.example.demo.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpeakersEntity extends EntityBase {
    private Long id;
    private Integer rating;
    private Long userId;

    public SpeakersEntity() {}

    @Override
    public Long getId() {
        return id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public SpeakersEntity(Long id, Integer rating, Long userId) {
        this.id = id;
        this.rating = rating;
        this.userId = userId;
    }

    @Override
    public String getTableName() {
        return "Speakers";
    }

    @Override
    public String getInsertQuery() {
        return "INSERT INTO " + getTableName() +
                " (rating, user) VALUES(?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE " + getTableName() + " SET rating=?, " +
                "user=? WHERE " + getId() + "=?";
    }

    @Override
    public String getIdName() {
        return "id";
    }

    @Override
    public void parse(ResultSet resultSet) throws SQLException {
        id = resultSet.getLong("id");
        rating = resultSet.getInt("rating");
        userId = resultSet.getLong("user");
    }

    @Override
    public void serialize(PreparedStatement statement, boolean withId) throws SQLException {
        statement.setInt(1, rating);
        statement.setLong(2, userId);
        if (withId) {
            statement.setLong(3, id);
        }
    }
}
