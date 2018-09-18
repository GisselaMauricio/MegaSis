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

import com.megacenter.Model.ValEntrada;
import com.megacenter.service.IValEntradaService;

@RestController
@RequestMapping(value = "/api/valentrada")
public class ValEntradaController {

	@Autowired
	private IValEntradaService service;

	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ValEntrada>> listar() {
		List<ValEntrada> valEntradas = new ArrayList<>();
		try {
			valEntradas = service.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<ValEntrada>>(valEntradas, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<ValEntrada>>(valEntradas, HttpStatus.OK);
	}

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ValEntrada> registrar(@RequestBody ValEntrada valEntradas) {
		ValEntrada entrada = new ValEntrada();
		try {

			entrada = service.registrar(valEntradas);

		} catch (Exception e) {
			return new ResponseEntity<ValEntrada>(entrada, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ValEntrada>(entrada, HttpStatus.OK);
	}
}
