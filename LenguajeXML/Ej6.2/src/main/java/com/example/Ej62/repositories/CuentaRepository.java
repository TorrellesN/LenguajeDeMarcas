package com.example.Ej62.repositories;


import com.example.Ej62.classes.Cuenta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CuentaRepository extends CrudRepository<Cuenta, Long> {

    @Override
    List<Cuenta> findAll();
}
