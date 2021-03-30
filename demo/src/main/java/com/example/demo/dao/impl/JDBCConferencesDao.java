package com.example.demo.dao.impl;

import com.example.demo.dao.ConferencesDao;
import com.example.demo.entity.AdministratorsEntity;
import com.example.demo.entity.ConferencesEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCConferencesDao extends DaoBase<ConferencesEntity> implements ConferencesDao {

    JDBCConferencesDao(Connection connection) {
        super(connection);
    }

    @Override
    public ConferencesEntity findById(Long id) {
        try {
            ConferencesEntity entity = new ConferencesEntity();
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
    public List<ConferencesEntity> findAll() {
        List<ConferencesEntity> conferences = new ArrayList<>();
        try {
            ConferencesEntity conferencesData = new ConferencesEntity();
            String queryString = "SELECT * FROM " + conferencesData.getTableName();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                ConferencesEntity conference = new ConferencesEntity();
                conference.parse(resultSet);
                conferences.add(conference);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return conferences;
    }
}
