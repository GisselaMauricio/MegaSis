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

import com.megacenter.Model.UnidadMedida;
import com.megacenter.service.IUnidadMedidaService;

@RestController
@RequestMapping(value = "/unidadMedida")
public class UnidadMedidaController {

	@Autowired
	private IUnidadMedidaService service;

	@GetMapping(value = "/listar", produces = "application/json")
	public ResponseEntity<List<UnidadMedida>> listar() {
		List<UnidadMedida> lista = new ArrayList<>();
		try {

			lista = service.listar();

		} catch (Exception e) {
			return new ResponseEntity<List<UnidadMedida>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<UnidadMedida>>(lista, HttpStatus.OK);
	}

	@GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UnidadMedida> listarId(@PathVariable("id") Integer id) {
		UnidadMedida unidadMedida = new UnidadMedida();
		try {

			unidadMedida = service.listarId(id);

		} catch (Exception e) {
			return new ResponseEntity<UnidadMedida>(unidadMedida, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<UnidadMedida>(unidadMedida, HttpStatus.OK);
	}

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registrar(@RequestBody UnidadMedida unidadMedida) {
		int resulatado = 0;
		try {

			service.registrar(unidadMedida);
			resulatado = 1;

		} catch (Exception e) {
			return new ResponseEntity<Integer>(resulatado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(resulatado, HttpStatus.OK);
	}

	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody UnidadMedida unidadMedida) {
		int resultado = 0;
		try {

			service.modificar(unidadMedida);
			resultado = 1;

		} catch (Exception e) {
			return new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
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
