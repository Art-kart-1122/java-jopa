package com.example.demo.persistence.dao.daoimpl;

import com.example.demo.persistence.dao.IAdministrator;
import com.example.demo.persistence.dao.entities.Administrator;
import com.example.demo.persistence.dao.entities.User;
import com.example.demo.persistence.dao.repositories.AdministratorRepository;
import com.example.demo.persistence.dao.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AdministratorImpl implements IAdministrator {
    private final AdministratorRepository repository;

    public Administrator add(Administrator entity) {
        return repository.save(entity);
    }

    public Administrator update(Administrator entity) {
        return repository.save(entity);
    }

    public void delete(Administrator entity) {
        repository.delete(entity);
    }

    public List<Administrator> findAll() {
        return repository.findAll();
    }

    public Optional<Administrator> findById(Long id) {
        return repository.findById(id);
    }
}
