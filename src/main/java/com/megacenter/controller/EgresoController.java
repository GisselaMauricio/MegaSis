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

import com.megacenter.Model.Egreso;
import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.representation.FiltroEgresoDTO;
import com.megacenter.service.IEgresoService;

@RestController
@RequestMapping(value = "/api/egresos")
public class EgresoController {

	@Autowired
	private IEgresoService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Egreso>> listar() {
		List<Egreso> egresos = new ArrayList<>();
		try {
			egresos = service.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<Egreso>>(egresos, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<Egreso>>(egresos, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<Egreso> listarId(@PathVariable("id") Integer id) {
		Egreso egresos = new Egreso();
		egresos = service.listarId(id);
		if (egresos == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		Resource<Egreso> resource = new Resource<Egreso>(egresos);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
		resource.add(linkTo.withRel("all_Egresos"));
		return resource;
	}

//	@PostMapping(value = "/buscar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<Egreso>> buscar(@RequestBody FiltroEgresoDTO filtro) {
//		List<Egreso> consultas = new ArrayList<>();
//
//		if (filtro != null) {
//			if (filtro.getFechaConsulta() != null) {
//				consultas = service.buscarfecha(filtro);
//			} else {
////				consultas = service.buscar(filtro);
//			}
//		}
//
//		return new ResponseEntity<List<Egreso>>(consultas, HttpStatus.OK);
//	}

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody Egreso egresos) {
		service.registrar(egresos);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(egresos.getIdEgreso()).toUri();
		return ResponseEntity.created(location).build();

	}

	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody Egreso egresos) {
		service.modificar(egresos);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Egreso egreso = service.listarId(id);
		if (egreso == null) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			service.eliminar(id);
		}
	}

}
