package com.example.demo.dao.impl;

import com.example.demo.dao.UsersDao;
import com.example.demo.entity.UsersEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCUsersDao extends DaoBase<UsersEntity> implements UsersDao {

    JDBCUsersDao(Connection connection) {
        super(connection);
    }

    @Override
    public UsersEntity findById(Long id) {
        try {
            UsersEntity entity = new UsersEntity();
            String queryString = "SELECT * FROM " + entity.getTableName() +
                    " WHERE " + entity.getIdName() + "=?";
            System.out.println(queryString);
            ptmt = connection.prepareStatement(queryString);
            ptmt.setLong(1, id);
            resultSet = ptmt.executeQuery();
            if (resultSet.next()) {
                entity.parse(resultSet);
                return entity;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }


    @Override
    public List<UsersEntity> findAll() {
        List<UsersEntity> users = new ArrayList<>();
        try {
            UsersEntity usersData = new UsersEntity();
            String queryString = "SELECT * FROM " + usersData.getTableName();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                UsersEntity user = new UsersEntity();
                user.parse(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return users;
    }

    @Override
    public List<UsersEntity> findByName(String firstName, String lastName) {
        List<UsersEntity> users = new ArrayList<>();
        try {
            UsersEntity usersData = new UsersEntity();
            String queryString = "SELECT * FROM " + usersData.getTableName() +
                    " WHERE " + "first_name" + "=?" + " AND "  + "last_name" + "=?";
            System.out.println(queryString);
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, firstName);
            ptmt.setString(2, lastName);
            resultSet = ptmt.executeQuery();
            if (resultSet.next()) {
                UsersEntity user = new UsersEntity();
                user.parse(resultSet);
                users.add(user);
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    @Override
    public List<UsersEntity> findByName(String userName) {
        return null;
    }

    @Override
    public Optional<UsersEntity> findByUsername(String username) {
        try {
            UsersEntity usersData = new UsersEntity();
            String queryString = "SELECT * FROM " + usersData.getTableName() +
                    " WHERE " + "user_name" + "=?";
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, username);
            resultSet = ptmt.executeQuery();
            if (resultSet.next()) {
                UsersEntity user = new UsersEntity();
                user.parse(resultSet);
                return Optional.ofNullable(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

}
