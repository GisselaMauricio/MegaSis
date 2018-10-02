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


import com.megacenter.Model.TipoCambio;
import com.megacenter.Model.TipoPago;
import com.megacenter.service.ITipoCambioService;
import com.megacenter.service.ITipoPagoService;

@RestController
@RequestMapping("/api/tipopagos")
public class TipoPagoController {

	@Autowired
	private ITipoPagoService service;
	@Autowired
	private ITipoCambioService ser;
	
	@GetMapping( value ="/listar",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoPago>> listar(){
		List<TipoPago> tipoPagos=new ArrayList<>();
		try {
			tipoPagos=service.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<TipoPago>>(tipoPagos, HttpStatus.OK);			
		}		
		return new ResponseEntity<List<TipoPago>>(tipoPagos, HttpStatus.OK);
			
	}
	
	@PostMapping(value ="/registrarPago", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoPago> registrar(@RequestBody TipoPago tipoPago) {
		TipoPago pa=new TipoPago();
		try {
			pa=service.registrar(tipoPago);			
		} catch (Exception e) {
			return new ResponseEntity<TipoPago>(pa, HttpStatus.INTERNAL_SERVER_ERROR);
		}return new ResponseEntity<TipoPago>(pa, HttpStatus.OK);
	}
	
	@PostMapping(value ="/registrarCmbio", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoCambio> registrar(@RequestBody TipoCambio tipoCambio) {
		TipoCambio det=new TipoCambio();
		try {
			det=ser.registrar(tipoCambio);			
		} catch (Exception e) {
			return new ResponseEntity<TipoCambio>(det, HttpStatus.INTERNAL_SERVER_ERROR);
		}return new ResponseEntity<TipoCambio>(det, HttpStatus.OK);
	}
}
