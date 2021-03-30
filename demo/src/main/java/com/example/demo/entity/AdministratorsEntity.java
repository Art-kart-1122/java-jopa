package com.example.demo.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministratorsEntity extends EntityBase{
    private Long id;
    private Long userId;

    public AdministratorsEntity() {

    }

    @Override
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public AdministratorsEntity(Long id, Long userId) {
        this.id = id;
        this.userId = userId;
    }

    @Override
    public String getTableName() {
        return "Administrators";
    }

    @Override
    public String getInsertQuery() {
        return "INSERT INTO " + getTableName() +
                " (user_id) VALUES(?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE " + getTableName() + " SET " +
                "user_id=? WHERE " + getId() + "=?";
    }

    @Override
    public String getIdName() {
        return "id";
    }

    @Override
    public void parse(ResultSet resultSet) throws SQLException {
        id = resultSet.getLong("id");
        userId = resultSet.getLong("userId");
    }

    @Override
    public void serialize(PreparedStatement statement, boolean withId) throws SQLException {
        statement.setLong(1, userId);
        if (withId) {
            statement.setLong(2, id);
        }
    }
}
