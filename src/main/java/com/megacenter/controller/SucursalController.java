package com.megacenter.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.megacenter.Model.Sucursal;
import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.service.ISucursalService;

@RestController
@RequestMapping("/api/sucursales")
public class SucursalController {

	@Autowired
	private ISucursalService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Sucursal>> listar() {
		List<Sucursal> sucrusal = new ArrayList<>();
		try {
			sucrusal = service.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<Sucursal>>(sucrusal, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<Sucursal>>(sucrusal, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<Sucursal> listarId(@PathVariable("id") Integer id) {
		Sucursal sucrusal = new Sucursal();
		sucrusal = service.listarId(id);
		if (sucrusal == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		Resource<Sucursal> resource = new Resource<Sucursal>(sucrusal);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
		resource.add(linkTo.withRel("all_Sucursales"));
		return resource;
	}

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody Sucursal sucrusal) {
		service.registrar(sucrusal);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(sucrusal.getIdSocursal()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody Sucursal sucrusal) {
		service.modificar(sucrusal);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminarSu(@PathVariable Integer id) {
		Sucursal sucrusal = service.listarId(id);
		if (sucrusal == null) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			service.eliminar(id);
		}
	}
}
