package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Hay que crear una clase/entidad para cada una de las tablas de la BD
 * sobre las que queremos trabajar. Esta clase es muy similar a las que hemos
 * visto en programación, simplemente tenemos que tener en cuenta que le tenemos
 * que indicar a qué tabla de la BD pertenece esta clase, y asignar cada uno de 
 * sus atributos a una columna de esa misma tabla.
 */
@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {
	// Esta línea tiene que estar pero no nos interesa, se autogenera cuando
	// implementamos Serializable
    private static final long serialVersionUID = 3233149207833106460L;
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    
    @Column(name = "nombre")    
    private String nombre;
    
    @Column(name = "password")
    private String password;
    
    public Alumno() {
    	
    }
    
    public Alumno(int id, String nombre, String password) {
    	this.id = id;
    	this.nombre = nombre;
    	this.password = password;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
