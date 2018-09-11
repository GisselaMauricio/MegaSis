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

import com.megacenter.Model.Producto;
import com.megacenter.service.IProductoService;

@RestController
@RequestMapping(value = "/api/productos")
public class ProductoController {

	@Autowired
	private IProductoService service;

	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producto>> listar() {
		List<Producto> productos = new ArrayList<>();
		try {
			productos = service.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<Producto>>(productos, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
	}

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> registrar(@RequestBody Producto productos) {
		Producto p = new Producto();
		try {

			p = service.registrar(productos);

		} catch (Exception e) {
			return new ResponseEntity<Producto>(p, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Producto>(p, HttpStatus.OK);
	}

}
