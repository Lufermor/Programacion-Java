package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Alumno;

/**
 * interfaz que va a usar el servico. Debe contener los métodos que ejecutan las
 * consultas en la BD.
 */
public interface IAlumnoService {
	// Devuelve una lista con todos los alumnos de la BD
	public List<Alumno> findAll();
	// Añade un nuevo alumno en la BD
	public boolean addAlumno(Alumno alumno);
}