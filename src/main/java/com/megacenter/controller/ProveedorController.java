package com.megacenter.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megacenter.Model.Proveedor;
import com.megacenter.service.IProveedorService;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
@Autowired
private IProveedorService service;

@GetMapping(value ="listar", produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<List<Proveedor>> listar(){
	List<Proveedor> proveedores=new ArrayList<>();
	proveedores=service.listar();
	return new ResponseEntity<List<Proveedor>>(proveedores, HttpStatus.OK);
}
}
