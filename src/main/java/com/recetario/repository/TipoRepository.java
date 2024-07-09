package com.recetario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recetario.model.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Integer> {

}
