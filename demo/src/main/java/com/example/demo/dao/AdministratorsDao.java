package com.example.demo.dao;

import com.example.demo.entity.AdministratorsEntity;

public interface AdministratorsDao extends GenericDao<AdministratorsEntity> {
    AdministratorsEntity findById(Long id);
    
}
