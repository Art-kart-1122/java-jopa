package com.example.demo.dao;

import com.example.demo.dao.impl.JDBCDaoFactory;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract AdministratorsDao createAdministratorsDao();
    public abstract ConferencesDao createConferencesDao();
    public abstract UsersDao createUsersDao();
    public abstract SpeakersDao createSpeakersDao();

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    daoFactory =  new JDBCDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
