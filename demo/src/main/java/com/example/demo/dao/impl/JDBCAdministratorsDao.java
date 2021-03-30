package com.example.demo.dao.impl;

import com.example.demo.dao.AdministratorsDao;
import com.example.demo.entity.AdministratorsEntity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCAdministratorsDao extends DaoBase<AdministratorsEntity> implements AdministratorsDao {

    JDBCAdministratorsDao(Connection connection) {
       super(connection);
    }

    @Override
    public AdministratorsEntity findById(Long id) {
        try {
            AdministratorsEntity entity = new AdministratorsEntity();
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
    public List<AdministratorsEntity> findAll() {
        List<AdministratorsEntity> administrators = new ArrayList<>();;
        try {
            AdministratorsEntity administratorsData = new AdministratorsEntity();
            String queryString = "SELECT * FROM " + administratorsData.getTableName();
            ptmt = connection.prepareStatement(queryString);
            resultSet = ptmt.executeQuery();
            while (resultSet.next()) {
                AdministratorsEntity admin = new AdministratorsEntity();
                admin.parse(resultSet);
                administrators.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return administrators;
    }


}
