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

import com.megacenter.Model.ValSalida;
import com.megacenter.service.IValSalidaService;

@RestController
@RequestMapping(value = "/api/valsalidas")
public class ValSalidaController {

	@Autowired
	private IValSalidaService service;

	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ValSalida>> listar() {
		List<ValSalida> valSalidas = new ArrayList<>();
		try {
			valSalidas = service.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<ValSalida>>(valSalidas, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<ValSalida>>(valSalidas, HttpStatus.OK);
	}

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ValSalida> registrar(@RequestBody ValSalida valSalidas) {
		ValSalida salida = new ValSalida();
		try {

			salida = service.registrar(valSalidas);

		} catch (Exception e) {
			return new ResponseEntity<ValSalida>(salida, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ValSalida>(salida, HttpStatus.OK);
	}

}
