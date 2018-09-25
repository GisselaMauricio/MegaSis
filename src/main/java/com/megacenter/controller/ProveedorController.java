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

import com.megacenter.Model.Proveedor;
import com.megacenter.service.IProveedorService;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {
	@Autowired
	private IProveedorService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Proveedor>> listar() {
		List<Proveedor> proveedores = new ArrayList<>();
		proveedores = service.listar();
		return new ResponseEntity<List<Proveedor>>(proveedores, HttpStatus.OK);

	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Proveedor> listarId(@PathVariable Integer id) {
		Proveedor proveedor = new Proveedor();
		proveedor = service.listarId(id);
		return new ResponseEntity<Proveedor>(proveedor, HttpStatus.OK);
	}
	

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registrar(@RequestBody Proveedor proveedor) {
		int resultado = 0;
		try {
			service.registrar(proveedor);
			resultado = 1;
		} catch (Exception e) {
			resultado = 0;
		}
		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}

	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody Proveedor proveedor) {
		int resultado = 0;
		try {
			service.modificar(proveedor);
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
			resultado = 0;
		}
		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}

}
