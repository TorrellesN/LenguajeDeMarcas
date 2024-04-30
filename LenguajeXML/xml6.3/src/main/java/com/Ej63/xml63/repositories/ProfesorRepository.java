package com.Ej63.xml63.repositories;

import com.Ej63.xml63.classes.Profesor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor, Long> {
    @Override
    List<Profesor> findAll();
}
