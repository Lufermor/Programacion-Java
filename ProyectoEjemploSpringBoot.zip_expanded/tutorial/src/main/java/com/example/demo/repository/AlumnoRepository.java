package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alumno;

/**
 * Esta interfaz vacía se utiliza para extender CrudRepository, 
 * que al heredarlo nos permite realizar consultas sobre la BD
 * utilizando la entidad alumno. Por ejemplo, devuelveme todos
 * los alumnos, insertame un nuevo alumno...
 */
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {


}