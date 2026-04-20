# Taller Unidad 8 - Relación ManyToMany con Spring Boot y JPA

## Descripción

Implementación de una relación ManyToMany entre las entidades **Curso**
y **Estudiante** usando Spring Boot, Spring Data JPA y MySQL. Se
configura la tabla de unión, relación bidireccional y optimización con
JOIN FETCH.

## Objetivo

-   Implementar relación `@ManyToMany`
-   Configurar `@JoinTable`
-   Manejar relación bidireccional con helper methods
-   Evitar problema N+1 con `JOIN FETCH`

## Tecnologías

-   Java 17+
-   Spring Boot
-   Spring Data JPA
-   Hibernate
-   MySQL
-   Maven
-   Thymeleaf

## Estructura del Proyecto

    src/main/java
     ├── controller
     │     └── CursoController.java
     ├── service
     │     └── CursoService.java
     ├── repository
     │     └── CursoRepository.java
     ├── model
     │     ├── Curso.java
     │     └── Estudiante.java

## Modelo de Datos

Relación ManyToMany bidireccional:

    Estudiante  ---< curso_estudiante >---  Curso

Tabla intermedia generada automáticamente:

    curso_estudiante
    ----------------
    curso_id
    estudiante_id

## Configuración de Base de Datos

application.properties:

    spring.datasource.url=jdbc:mysql://localhost:3306/estudiantes_db
    spring.datasource.username=root
    spring.datasource.password=
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

## Ejecución

    ./mvnw spring-boot:run

Aplicación disponible en:

    http://localhost:8080/cursos

## Funcionalidades

-   Crear cursos
-   Listar cursos
-   Inscribir estudiantes
-   Desinscribir estudiantes
-   Visualizar relación ManyToMany
-   Optimización con JOIN FETCH

## Checkpoints

### Checkpoint 1

Verificar tablas:

    SHOW TABLES;
    DESCRIBE curso_estudiante;

### Checkpoint 2

-   Crear 3 cursos
-   Inscribir estudiantes
-   Verificar datos en MySQL

```{=html}
<!-- -->
```
    SELECT * FROM curso_estudiante;

### Checkpoint 3

-   Desinscribir estudiante
-   Verificar eliminación en tabla intermedia

## Endpoints

    GET /cursos
    GET /cursos/nuevo
    POST /cursos/guardar
    GET /cursos/{id}/inscribir
    POST /cursos/{cursoId}/inscribir/{estudianteId}
    POST /cursos/{cursoId}/desinscribir/{estudianteId}

## Entregables

-   Repositorio GitHub
-   Código fuente
-   README

## Commits mínimos

1.  Entidad Curso
2.  Configuración ManyToMany
3.  Controller y vistas

## Autor

Jair Sanjuan
Ingeniería de Sistemas 
Unidad 8 - Persistencia con JPA/Hibernate
