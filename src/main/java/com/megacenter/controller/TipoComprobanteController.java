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

import com.megacenter.Model.TipoComprobante;
import com.megacenter.service.ITipoComprobanteService;

@RestController
@RequestMapping(value = "/api/tipcomprobante")
public class TipoComprobanteController {

	@Autowired
	private ITipoComprobanteService service;

	@GetMapping(value = "/listar", produces = "application/json")
	public ResponseEntity<List<TipoComprobante>> listar() {
		List<TipoComprobante> lista = new ArrayList<>();
		try {

			lista = service.listar();

		} catch (Exception e) {
			return new ResponseEntity<List<TipoComprobante>>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<TipoComprobante>>(lista, HttpStatus.OK);
	}

	@GetMapping(value = "/listar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoComprobante> listarId(@PathVariable("id") Integer id) {
		TipoComprobante tipoComprobante = new TipoComprobante();
		try {

			tipoComprobante = service.listarId(id);

		} catch (Exception e) {
			return new ResponseEntity<TipoComprobante>(tipoComprobante, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<TipoComprobante>(tipoComprobante, HttpStatus.OK);
	}

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registrar(@RequestBody TipoComprobante tipoComprobante) {
		int resulatado = 0;
		try {

			service.registar(tipoComprobante);
			resulatado = 1;

		} catch (Exception e) {
			return new ResponseEntity<Integer>(resulatado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(resulatado, HttpStatus.OK);
	}

	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody TipoComprobante tipoComprobante) {
		int resultado = 0;
		try {

			service.modificar(tipoComprobante);
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
