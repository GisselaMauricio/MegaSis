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

import com.megacenter.Model.Compra;

import com.megacenter.service.ICompraService;



@RestController
@RequestMapping("/compras")
public class CompraController {
	@Autowired
	private ICompraService service;

	@GetMapping( value ="/listar",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Compra>> listar(){
		List<Compra> compras=new ArrayList<>();
		try {
			compras=service.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<Compra>>(compras, HttpStatus.OK);			
		}		
		return new ResponseEntity<List<Compra>>(compras, HttpStatus.OK);
			
	}
	
	@PostMapping(value ="/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Compra> registrar(@RequestBody Compra compra) {
		Compra c=new Compra();
		try {
			c=service.registrar(compra);			
		} catch (Exception e) {
			return new ResponseEntity<Compra>(c, HttpStatus.INTERNAL_SERVER_ERROR);
		}return new ResponseEntity<Compra>(c, HttpStatus.OK);
	}

}