package com.example.demo.dao.impl;

import com.example.demo.dao.GenericDao;
import com.example.demo.entity.ConnectionFactory;
import com.example.demo.entity.EntityBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DaoBase<T extends EntityBase> implements GenericDao<T> {
    Connection connection;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public DaoBase(Connection connection) {
        this.connection = connection;
    }

    @Override
    public T findById(Long id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public void create(T obj) {
        try {
            String queryString = obj.getInsertQuery();
            ptmt = connection.prepareStatement(queryString);
            obj.serialize(ptmt, false);
            ptmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public void update(T obj) {
        try {
            String queryString = obj.getUpdateQuery();
            ptmt = connection.prepareStatement(queryString);
            obj.serialize(ptmt, true);
            ptmt.executeUpdate();
            System.out.println(queryString);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public void delete(T obj) {
        try {
            String queryString = "DELETE FROM " + obj.getTableName() +
                    " WHERE " + obj.getIdName() + "=?";
            System.out.println(queryString);
            ptmt = connection.prepareStatement(queryString);
            ptmt.setLong(1, obj.getId());
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    @Override
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (ptmt != null) {
                ptmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

