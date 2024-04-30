package com.Ej63.xml63.repositories;

import com.Ej63.xml63.classes.TipoDeGasto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoDeGastoRepository extends CrudRepository<TipoDeGasto, Long> {

    @Override
    List<TipoDeGasto> findAll();
}
