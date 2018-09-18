package com.megacenter.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megacenter.Model.Almacen;
import com.megacenter.service.IAlmacenService;

@RestController
@RequestMapping(value = "/api/almacenes")
public class AlmacenController {

	@Autowired
	private IAlmacenService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Almacen>> listar() {
		List<Almacen> almacenes = new ArrayList<>();
		almacenes = service.listar();
		return new ResponseEntity<List<Almacen>>(almacenes, HttpStatus.OK);

	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Almacen> listarId(@PathVariable("id") Integer id) {
		Almacen almacenes = new Almacen();
		almacenes = service.listar(id);
		return new ResponseEntity<Almacen>(almacenes, HttpStatus.OK);
	}

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registrar(@RequestBody Almacen almacenes) {
		int resultado = 0;
		try {
			service.registrar(almacenes);
			resultado = 1;
		} catch (Exception e) {
			resultado = 0;
		}
		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}

	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody Almacen almacenes) {
		int resultado = 0;
		try {
			service.modificar(almacenes);
			resultado = 1;
		} catch (Exception e) {
			resultado = 0;
		}
		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}

	@DeleteMapping(value = "/eliminar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> eliminar(@PathVariable Integer id) {
		int resultado = 0;
		try {
			service.eliminar(id);
			resultado = 1;
		} catch (Exception e) {
			resultado = 0;
		}
		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}
}
