package com.megacenter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megacenter.Model.Personal;
import com.megacenter.service.IPersonalService;

@RestController
@RequestMapping(value = "/api/personales")
public class PersonalController {

	@Autowired
	private IPersonalService service;
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Personal>> listar() {
		List<Personal> personales = new ArrayList<>();
		try {
			personales = service.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<Personal>>(personales, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<Personal>>(personales, HttpStatus.OK);
	}

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Personal> registrar(@RequestBody Personal personales) {
		Personal p = new Personal();
		try {

			p = service.registrar(personales);

		} catch (Exception e) {
			return new ResponseEntity<Personal>(p, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Personal>(p, HttpStatus.OK);
	}
	
}
