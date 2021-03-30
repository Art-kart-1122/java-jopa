package com.example.demo.dao.impl;

import com.example.demo.dao.SpeakersDao;
import com.example.demo.entity.SpeakersEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCSpeakersDao extends DaoBase<SpeakersEntity> implements SpeakersDao {

    JDBCSpeakersDao(Connection connection) {
        super(connection);
    }

    @Override
    public SpeakersEntity findById(Long id) {
        try {
            SpeakersEntity entity = new SpeakersEntity();
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
    public List<SpeakersEntity> findAll() {
        List<SpeakersEntity> moderators = new ArrayList<>();
        try {
            SpeakersEntity moderatorsData = new SpeakersEntity();
            String queryString = "SELECT * FROM " + moderatorsData.getTableName();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                SpeakersEntity moderator = new SpeakersEntity();
                moderator.parse(resultSet);
                moderators.add(moderator);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return moderators;
    }
}
