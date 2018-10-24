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

import com.megacenter.Model.Producto;
import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.service.IProductoService;

@RestController
@RequestMapping(value = "/api/productos")
public class ProductoController {

    @Autowired
    private IProductoService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Producto>> listar() {
        List<Producto> productos = new ArrayList<>();
        try {
            productos = service.listar();
        } catch (Exception e) {
            return new ResponseEntity<List<Producto>>(productos, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<Producto>>(productos, HttpStatus.OK);
    }

    //ACTUALIZADO
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Producto> listarId(@PathVariable("id") Integer id) {
        Producto productos = new Producto();
        productos = service.listarId(id);
        if (productos == null) {
            throw new ModeloNotFoundException("ID: " + id);
        }
        Resource<Producto> resource = new Resource<Producto>(productos);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
        resource.add(linkTo.withRel("all_Productos"));
        return resource;
    }

    @PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@Valid @RequestBody Producto productos) {
        service.registrar(productos);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(productos.getIdProducto()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@RequestBody Producto productos) {
        service.modificar(productos);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id) {
        Producto prod = service.listarId(id);
        if (prod == null) {
            throw new ModeloNotFoundException("ID: " + id);
        } else {
            service.eliminar(id);
        }
    }

    @GetMapping(value = "/buscar/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<Producto> buscar(@PathVariable("codigo") String codigo) {
        Producto productos = service.busar(codigo);
        if (productos == null) {
            throw new ModeloNotFoundException("CODIGO: " + codigo);
        }
        Resource<Producto> resource = new Resource<Producto>(productos);
        return resource;
    }
}
