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

import com.megacenter.Model.Cliente;
import com.megacenter.service.IClienteService;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

	@Autowired
	private IClienteService service;

	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> listar() {
		List<Cliente> clientes = new ArrayList<>();
		try {
			clientes = service.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> registrar(@RequestBody Cliente clientes) {
		Cliente c = new Cliente();
		try {

			c = service.registrar(clientes);

		} catch (Exception e) {
			return new ResponseEntity<Cliente>(c, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Cliente>(c, HttpStatus.OK);
	}

}
