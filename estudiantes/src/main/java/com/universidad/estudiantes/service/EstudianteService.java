package com.universidad.estudiantes.service;

import com.universidad.estudiantes.model.Estudiante;
import com.universidad.estudiantes.repository.EstudianteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EstudianteService {

    private final EstudianteRepository repository;

    // Inyección por constructor (recomendada)
    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    // Listar todos los estudiantes
    public List<Estudiante> listarTodos() {
        return repository.findAll();
    }

    // Buscar por ID (lanza excepción si no existe)
    public Estudiante buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con id: " + id));
    }

    // Guardar o actualizar (transaccional)
    @Transactional
    public Estudiante guardar(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    // Eliminar por ID (transaccional)
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}