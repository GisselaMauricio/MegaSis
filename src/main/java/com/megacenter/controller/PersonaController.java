package com.megacenter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megacenter.Model.Persona;
import com.megacenter.service.IPersonaService;

@RestController
@RequestMapping(value = "/api/personas")
public class PersonaController {

	@Autowired
	private IPersonaService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> listar() {
		List<Persona> personas = new ArrayList<>();
		personas = service.listar();
		return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);

	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> listarId(@PathVariable("id") Integer id) {
		Persona persona = new Persona();
		persona = service.listarId(id);
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
	

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> registrar(@RequestBody Persona personas) {
		Persona p = new Persona();
		try {

			p = service.registrar(personas);

		} catch (Exception e) {
			return new ResponseEntity<Persona>(p, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Persona>(p, HttpStatus.OK);
	}

}
