package com.example.demo.dao.impl;

import com.example.demo.dao.*;
import com.example.demo.entity.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory  extends DaoFactory {
    private ConnectionFactory dataSource = ConnectionFactory.getInstance();

    @Override
    public AdministratorsDao createAdministratorsDao() {
        return new JDBCAdministratorsDao(getConnection());
    }

    @Override
    public ConferencesDao createConferencesDao() {
        return new JDBCConferencesDao(getConnection());
    }

    @Override
    public SpeakersDao createSpeakersDao() {
        return new JDBCSpeakersDao(getConnection());
    }

    @Override
    public UsersDao createUsersDao() {
        return new JDBCUsersDao(getConnection());
    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
