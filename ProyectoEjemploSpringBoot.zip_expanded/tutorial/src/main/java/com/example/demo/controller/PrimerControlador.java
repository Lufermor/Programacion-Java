package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Alumno;
import com.example.demo.service.IAlumnoService;

import java.util.List;

/**
 * El controlador recibe las peticiones y, dependiendo de la URL a la que
 * el usuario ha accedido, ejecuta una funcionalidad u otra del backend
 * de nuestra web.
 *
 */
@Controller
public class PrimerControlador {

	@Autowired
    private IAlumnoService alumnoService;
	
	/**
	 * Las peticiones a la url "/" ejecutan la función operacionDeInicio, que carga
	 * la lista de alumnos y devuelve al usuario el index.html
	 * Recordar que la url "/" significa petición a la raiz, ejemplos:
	 * 			- wwww.google.com/ (carga el index de google)
	 * 			- www.facebook.com/ (carga el index de facebook)
	 */
    @GetMapping("/")
    public String operacionDeInicio(Model model) {
    	// Ejecutamos la query "select * from alumnos" para obtener
    	// todos los alumnos de la BD
        List<Alumno> alumnos = (List<Alumno>) alumnoService.findAll();
        // Muestra por consola todos los alumnos a modo de prueba
        System.out.println("Alumnos size = " + alumnos.size());
        for(int i = 0; i < alumnos.size(); i++) {
        	System.out.println(alumnos.get(i).getId() + " - " + alumnos.get(i).getNombre());
        }
        // Envía los alumnos al html, para poder listarlos
        model.addAttribute("alumnos", alumnos);
        return "index";
    }

    /**
     * Esta petición se ejecuta cuando el usuario presiona sobre el botón "Agregar"
     * del formulario del index.html. 
     * El método agregarAlumno recibe todos los parámetros del formulario y los utiliza
     * para añadir un nuevo alumno a la BD.
     * Por último vuelve a cargar el index.html
     */
    @PostMapping(value = "/alumnos/agregar")
    public String agregarAlumno(@ModelAttribute Alumno alumno, Model model) {
    	// Ejecuta la query "insert alumno"
        alumnoService.addAlumno(alumno);
        /*
         * Como explique en clase, una vez se ha añadido un nuevo alumno queremos
         * volver a cargar el index.html. Ya sabemos que este index necesita de una
         * lista de alumnos para cargarse bien (la lista que mostramos), por lo tanto
         * volvemos a solicitarla haciendo la query "select * from alumnos"
         * y se la volvemos a mandar al index.html
         */
        List<Alumno> alumnos = (List<Alumno>) alumnoService.findAll();
        System.out.println("Alumnos size = " + alumnos.size());
        for(int i = 0; i < alumnos.size(); i++) {
        	System.out.println(alumnos.get(i).getId() + " - " + alumnos.get(i).getNombre());
        }
        model.addAttribute("alumnos", alumnos);
        return "index";
    }
}
