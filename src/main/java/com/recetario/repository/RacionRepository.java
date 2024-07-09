package com.recetario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recetario.model.Racion;

public interface RacionRepository extends JpaRepository<Racion, Integer> {

}
