package com.megacenter.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.megacenter.Model.Leyenda;
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

import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.service.ILeyendaService;

@RestController
@RequestMapping(value = "/api/leyendas")
public class LeyendaController {
	
	@Autowired
	private ILeyendaService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Leyenda>> listar() {
		List<Leyenda> Leyendas = new ArrayList<>();
		try {
			Leyendas = service.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<Leyenda>>(Leyendas, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<Leyenda>>(Leyendas, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<Leyenda> listarId(@PathVariable("id") Integer id) {
		Leyenda Leyenda = new Leyenda();
		Leyenda = service.listarId(id);
		if (Leyenda == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		Resource<Leyenda> resource = new Resource<Leyenda>(Leyenda);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
		resource.add(linkTo.withRel("all_Leyendas"));
		return resource;
	}

	@PostMapping(value="/registrar",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody Leyenda Leyenda) {
		service.registrar(Leyenda);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(Leyenda.getIdLeyenda()).toUri();
		return ResponseEntity.created(location).build();

	}
	
	@PutMapping(value="/actualizar",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody Leyenda Leyenda) {
		service.modificar(Leyenda);
		return new ResponseEntity<Object>(HttpStatus.OK);
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
