package com.example.demo.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersEntity  extends EntityBase{
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    public UsersEntity() {

    }

    @Override
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsersEntity(Long id, String firstName, String lastName, String userName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String getTableName() {
        return "Users";
    }

    @Override
    public String getInsertQuery() {
        return "INSERT INTO " + getTableName() +
                " (first_name, last_name, user_name, password) VALUES(?,?,?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE " + getTableName() + " SET first_name=?, lastname=?, username=?," +
                "password=? WHERE " + getId() + "=?";
    }

    @Override
    public String getIdName() {
        return "id";
    }

    @Override
    public void parse(ResultSet resultSet) throws SQLException {
        id = resultSet.getLong("id");
        firstName = resultSet.getString("first_name");
        lastName = resultSet.getString("last_name");
        userName = resultSet.getString("user_name");
        password = resultSet.getString("password");
    }

    @Override
    public void serialize(PreparedStatement statement, boolean withId) throws SQLException {
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.setString(3, userName);
        statement.setString(4, password);
        if (withId) {
            statement.setLong(5, id);
        }
    }

}
