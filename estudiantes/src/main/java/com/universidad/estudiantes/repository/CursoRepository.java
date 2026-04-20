package com.universidad.estudiantes.repository;

import com.universidad.estudiantes.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    // Evita el problema N+1 cargando estudiantes en la misma consulta
    @Query("SELECT c FROM Curso c LEFT JOIN FETCH c.estudiantes")
    List<Curso> findAllConEstudiantes();

    @Query("SELECT c FROM Curso c LEFT JOIN FETCH c.estudiantes WHERE c.id = :id")
    Optional<Curso> findByIdConEstudiantes(Long id);
}