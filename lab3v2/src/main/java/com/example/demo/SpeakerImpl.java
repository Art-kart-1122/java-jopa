package com.example.demo;

import com.example.demo.persistence.dao.ISpeaker;
import com.example.demo.persistence.dao.entities.Speaker;
import com.example.demo.persistence.dao.repositories.SpeakerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SpeakerImpl implements ISpeaker {
    private final SpeakerRepository repository;

    public Speaker add(Speaker entity) {
        return repository.save(entity);
    }

    public Speaker update(Speaker entity) {
        return repository.save(entity);
    }

    public void delete(Speaker entity) {
        repository.delete(entity);
    }

    public List<Speaker> findAll() {
        return repository.findAll();
    }

    public Optional<Speaker> findById(Long id) {
        return repository.findById(id);
    }
}
