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

import com.megacenter.Model.DetalleVenta;
import com.megacenter.Model.Venta;
import com.megacenter.service.IDetalleVentaService;
import com.megacenter.service.IVentaService;



@RestController
@RequestMapping("/api/vantas")
public class VentaController {
	@Autowired
	private IVentaService service;
	@Autowired
	private IDetalleVentaService ser;

	@GetMapping( value ="/listar",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Venta>> listar(){
		List<Venta> ventas=new ArrayList<>();
		try {
			ventas=service.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<Venta>>(ventas, HttpStatus.OK);			
		}		
		return new ResponseEntity<List<Venta>>(ventas, HttpStatus.OK);
			
	}
	@PostMapping(value ="/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Venta> registrar(@RequestBody Venta venta) {
		Venta v=new Venta();
		try {
			v=service.registrar(venta);			
		} catch (Exception e) {
			return new ResponseEntity<Venta>(v, HttpStatus.INTERNAL_SERVER_ERROR);
		}return new ResponseEntity<Venta>(v, HttpStatus.OK);
	}
	
	@PostMapping(value ="/registrarde", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DetalleVenta> registrar(@RequestBody DetalleVenta detalleVenta) {
		DetalleVenta detv=new DetalleVenta();
		try {
			detv=ser.registrar(detalleVenta);			
		} catch (Exception e) {
			return new ResponseEntity<DetalleVenta>(detv, HttpStatus.INTERNAL_SERVER_ERROR);
		}return new ResponseEntity<DetalleVenta>(detv, HttpStatus.OK);
	}
	
}
