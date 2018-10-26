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

import com.megacenter.Model.Cliente;
import com.megacenter.Model.Persona;
import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.representation.ClienteRepresentation;
import com.megacenter.service.IClienteService;
import com.megacenter.service.IPersonaService;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

	@Autowired
	private IClienteService service;
	@Autowired
	private IPersonaService personaService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> listar() {
		List<Cliente> clientes = new ArrayList<>();
		try {
			clientes = service.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<Cliente> listarId(@PathVariable("id") Integer id) {
		Cliente clientes = new Cliente();
		clientes = service.listarId(id);
		if (clientes == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		Resource<Cliente> resource = new Resource<Cliente>(clientes);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
		resource.add(linkTo.withRel("all_Clientes"));
		return resource;
	}

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody ClienteRepresentation rep) {
		Persona persona = personaService.registrar(rep.getPersona());
		rep.getCliente().setPersona(persona);
		Cliente cliente = service.registrar(rep.getCliente());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cliente.getIdCliente()).toUri();
		return ResponseEntity.created(location).build();

	}

	@PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody ClienteRepresentation rep) {
		Persona persona = personaService.modificar(rep.getPersona());
		rep.getCliente().setPersona(persona);
		Cliente cliente=service.modificar(rep.getCliente());
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Cliente clientes = service.listarId(id);
		if (clientes == null) {
			throw new ModeloNotFoundException("ID: " + id);
		} else {
			service.eliminar(id);
		}
	}

}
