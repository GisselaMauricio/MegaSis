package com.megacenter.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.megacenter.Model.Compra;
import com.megacenter.Model.DetalleProforma;
import com.megacenter.Model.Proforma;
import com.megacenter.exception.ModeloNotFoundException;
import com.megacenter.service.IProformaService;

@RestController
@RequestMapping(value = "/api/proformas")
public class ProformaController {

	@Autowired
	private IProformaService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Proforma>> listar() {
		List<Proforma> proformas = new ArrayList<>();
		try {
			proformas = service.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<Proforma>>(proformas, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<Proforma>>(proformas, HttpStatus.OK);
	}
	

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<Proforma> listarId(@PathVariable("id") Integer id) {
		Proforma proformas = new Proforma();
		proformas = service.listarId(id);
		if (proformas == null) {
			throw new ModeloNotFoundException("ID: " + id);
		}
		Resource<Proforma> resource = new Resource<Proforma>(proformas);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listar());
		resource.add(linkTo.withRel("all_Proformas"));
		return resource;
	}

	@GetMapping(value = "/proforma-detalle/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DetalleProforma>> detlles(@PathVariable("id") Integer id) {
		Proforma proforma = service.listarId(id);
		List<DetalleProforma> detalleProforma = proforma.getDetalleProforma();
		return new ResponseEntity<List<DetalleProforma>>(detalleProforma, HttpStatus.OK);
	}

	@GetMapping(value = "/numero-proforma", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Proforma> NumeroProforma() {
		try {
			Proforma p = service.getLastProforma();
			int numero = 1;
			if (p != null && p.getNumeroProforma() != null) {
				numero = Integer.parseInt(p.getNumeroProforma());
				numero = numero + 1;
			}
			Formatter fmt = new Formatter();
			fmt.format("%07d", numero);
			p.setNumeroProforma(String.valueOf(fmt));
			return new ResponseEntity<Proforma>(p, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Proforma>((Proforma) null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Proforma> registrar(@RequestBody Proforma proformas) {
		Proforma pro = new Proforma();
		try {
			if (proformas.getEstadoProforma() == null) {
				String estado = "COTIZADO";
				proformas.setEstadoProforma(estado);
			}
			if (proformas.getNumeroProforma() == null || proformas.getNumeroProforma() != null) {
				Proforma p = service.getLastProforma();
				int numero = 1;
				if (p != null && p.getNumeroProforma() != null) {
					numero = Integer.parseInt(p.getNumeroProforma());
					numero = numero + 1;
				}
				Formatter fmt = new Formatter();
				fmt.format("%07d", numero);
				proformas.setNumeroProforma(String.valueOf(fmt));
			}
			pro = service.registrar(proformas);
			// generar(pro.getIdProforma());

		} catch (Exception e) {
			return new ResponseEntity<Proforma>(pro, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Proforma>(pro, HttpStatus.OK);

	}

	@GetMapping(value = "/generarReporte", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> generarReporte() {
		byte[] data = null;
		data = service.generarReporte();
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}

	@GetMapping(value = "/generarReporteImprimir", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> generarReporteImprimir() {
		byte[] data = null;
		data = service.generarReporteImprimir();
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}

}
