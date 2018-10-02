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

import com.megacenter.Model.TipoProducto;
import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.service.ITipoProductoService;

@RestController
@RequestMapping(value = "/api/tipoProductos")
public class TipoProductoController {

	@Autowired
	private ITipoProductoService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoProducto>> listar() {
		List<TipoProducto> tipoProductos = new ArrayList<>();
		try {
			tipoProductos = service.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<TipoProducto>>(tipoProductos, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<TipoProducto>>(tipoProductos, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<TipoProducto> listarId(@PathVariable("id") Integer id) {
		TipoProducto tipoProducto = new TipoProducto();
		tipoProducto = service.listarId(id);
		if (tipoProducto == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		Resource<TipoProducto> resource = new Resource<TipoProducto>(tipoProducto);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
		resource.add(linkTo.withRel("all_TipoProductos"));
		return resource;
	}

	@PostMapping(value="/registrar",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody TipoProducto tipoProducto) {
		service.registrar(tipoProducto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(tipoProducto.getIdTipoproducto()).toUri();
		return ResponseEntity.created(location).build();

	}

	@PutMapping(value="/actualizar",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizar(@RequestBody TipoProducto tipoProducto) {
		service.actualizar(tipoProducto);
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
