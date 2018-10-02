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

import com.megacenter.Model.Categoria;
import com.megacenter.service.ICategoriaService;

@RestController
@RequestMapping(value = "/api/categorias")
public class CategoriaController {

	@Autowired
	private ICategoriaService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Categoria>> listar() {
		List<Categoria> categorias = new ArrayList<>();
		try {
			categorias = service.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> listarId(@PathVariable("id") Integer id) {
		Categoria categoria = new Categoria();
		try {

			categoria = service.listarId(id);

		} catch (Exception e) {
			return new ResponseEntity<Categoria>(categoria, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
	}

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registrar(@RequestBody Categoria categoria) {
		int resulatado = 0;
		try {

			service.registrar(categoria);
			resulatado = 1;

		} catch (Exception e) {
			return new ResponseEntity<Integer>(resulatado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(resulatado, HttpStatus.OK);
	}
	
	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody Categoria categoria) {
		int resultado = 0;
		try {
			service.actualizar(categoria);
			resultado = 1;
		} catch (Exception e) {
			resultado = 0;
		}
		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}

	@DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> eliminar(@PathVariable Integer id) {
		int resultado = 0;
		try {
			service.eliminar(id);
			resultado = 1;
		} catch (Exception e) {
			return new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}

}
