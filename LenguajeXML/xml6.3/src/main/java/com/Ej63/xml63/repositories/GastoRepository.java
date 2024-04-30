package com.Ej63.xml63.repositories;

import com.Ej63.xml63.classes.Gasto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GastoRepository extends CrudRepository<Gasto, Long> {
    @Override
    List<Gasto> findAll();
}
