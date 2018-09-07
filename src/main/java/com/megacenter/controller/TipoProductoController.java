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

import com.megacenter.Model.TipoProducto;
import com.megacenter.service.ITipoProductoService;

@RestController
@RequestMapping(value = "/tipoProductos")
public class TipoProductoController {

	@Autowired
	private ITipoProductoService service;

	@GetMapping(value = "/listar", produces = "application/json")
	public ResponseEntity<List<TipoProducto>> listar() {
		List<TipoProducto> lista = new ArrayList<>();
		try {

			lista = service.listar();

		} catch (Exception e) {
			return new ResponseEntity<List<TipoProducto>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<TipoProducto>>(lista, HttpStatus.OK);
	}

	@GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoProducto> listarId(@PathVariable("id") Integer id) {
		TipoProducto tipoProducto = new TipoProducto();
		try {

			tipoProducto = service.listarId(id);

		} catch (Exception e) {
			return new ResponseEntity<TipoProducto>(tipoProducto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<TipoProducto>(tipoProducto, HttpStatus.OK);
	}

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registrar(@RequestBody TipoProducto tipoProducto) {
		int resulatado = 0;
		try {

			service.registrar(tipoProducto);
			resulatado = 1;

		} catch (Exception e) {
			return new ResponseEntity<Integer>(resulatado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(resulatado, HttpStatus.OK);
	}

	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody TipoProducto tipoProducto) {
		int resultado = 0;
		try {

			service.modificar(tipoProducto);
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
