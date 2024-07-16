package com.recetario.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.recetario.model.Receta;

public interface RecetaRepository extends JpaRepository<Receta, Integer> {

	@Query(value = "SELECT * FROM recetas", nativeQuery = true)
	List<Receta> obtenerTodasRecetas();
	
    @Query(value = "SELECT * FROM recetas ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Receta obtenerRecetaAleatoria();
    
    Optional<Receta> findById(Long id);
    void deleteById(Long id);
    
    List<Receta> findByDificultadId(int dificultadId);
    
    List<Receta> findByTipoId(int tipoId);
    
    List<Receta> findByDificultadIdAndTipoId(int dificultadId, int tipoId);
    
    List<Receta> findByIngredientesContainingIgnoreCase(String ingrediente);
    
    List<Receta> findByIngredientesContainingIgnoreCaseAndDificultadId(String ingrediente, int dificultadId);
    
    List<Receta> findByIngredientesContainingIgnoreCaseAndTipoId(String ingrediente, int tipoId);
    
    List<Receta> findByIngredientesContainingIgnoreCaseAndDificultadIdAndTipoId(String ingrediente, int dificultadId, int tipoId);
}
