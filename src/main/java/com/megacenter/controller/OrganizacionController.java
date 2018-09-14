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

import com.megacenter.Model.Organizacion;
import com.megacenter.Model.Sucursal;
import com.megacenter.service.IOrganizacionService;



@RestController
@RequestMapping("/api/organizaciones")
public class OrganizacionController {
	@Autowired
	private IOrganizacionService service, ser;


	@GetMapping( produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Organizacion>> listar(){
		List<Organizacion> organizacion=new ArrayList<>();
		organizacion=service.listar();
		return new ResponseEntity<List<Organizacion>>(organizacion, HttpStatus.OK);
		
		}
	@GetMapping( value="/listar/{id}" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Organizacion> listarId(@PathVariable("id") Integer id){
		Organizacion organizacion = new Organizacion();
		organizacion = service.listarId(id);
		return new ResponseEntity<Organizacion>(organizacion, HttpStatus.OK);
	}
	@PostMapping(value ="/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registrar(@RequestBody Organizacion organizacion) {
		int resultado=0;
		try {
			service.registrar(organizacion);
			resultado=1;
		} catch (Exception e) {
			resultado=0;
		}return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}
	/**-------------------------------controller-------------------------------------------------------**/
	
	@GetMapping( produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Sucursal>> listarSu(){
		List<Sucursal> sucrusal=new ArrayList<>();
		sucrusal=ser.listarSu();
		return new ResponseEntity<List<Sucursal>>(sucrusal, HttpStatus.OK);
		
		}
	@GetMapping( value="/listar/{id}" ,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sucursal> listarSuId(@PathVariable("id") Integer id){
		Sucursal sucursal = new Sucursal();
		sucursal = ser.listarSuId(id);
		return new ResponseEntity<Sucursal>(sucursal, HttpStatus.OK);
	}
	@PostMapping(value ="/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registrar(@RequestBody Sucursal sucursal) {
		int resultado=0;
		try {
			ser.registrarSu(sucursal);
			resultado=1;
		} catch (Exception e) {
			resultado=0;
		}return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}
	@PutMapping(value ="/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody Sucursal sucursal) {
		int resultado=0;
		try {
			ser.modificarSu(sucursal);
			resultado=1;
		} catch (Exception e) {
			resultado=0;
		}return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}
	@DeleteMapping(value ="/eliminar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> eliminar(@PathVariable Integer id) {
		int resultado=0;
		try {
			ser.eliminar(id);
			resultado=1;
		} catch (Exception e) {
			resultado=0;
		}return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}
}
