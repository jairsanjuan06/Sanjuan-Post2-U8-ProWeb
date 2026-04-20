package com.universidad.estudiantes.service;

import com.universidad.estudiantes.model.Curso;
import com.universidad.estudiantes.model.Estudiante;
import com.universidad.estudiantes.repository.CursoRepository;
import com.universidad.estudiantes.repository.EstudianteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final EstudianteRepository estudianteRepository;

    public CursoService(CursoRepository cursoRepository, EstudianteRepository estudianteRepository) {
        this.cursoRepository = cursoRepository;
        this.estudianteRepository = estudianteRepository;
    }

    public List<Curso> listarTodos() {
        return cursoRepository.findAllConEstudiantes(); // no findAll()
    }

    public Curso buscarPorId(Long id) {
        return cursoRepository.findByIdConEstudiantes(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado: " + id));
    }

    @Transactional
    public Curso guardar(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Transactional
    public void inscribirEstudiante(Long cursoId, Long estudianteId) {
        Curso curso = buscarPorId(cursoId);
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        curso.agregarEstudiante(estudiante);
        cursoRepository.save(curso); // La relación se persiste por cascada
    }

    @Transactional
    public void desinscribirEstudiante(Long cursoId, Long estudianteId) {
        Curso curso = buscarPorId(cursoId);
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        curso.quitarEstudiante(estudiante);
        cursoRepository.save(curso);
    }
}