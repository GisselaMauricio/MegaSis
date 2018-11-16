package com.megacenter.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.megacenter.Model.Proforma;
import com.megacenter.dao.IProformaDAO;
import com.megacenter.representation.ConsultaListProforma;
import com.megacenter.service.IProformaService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ProformaServiceImpl implements IProformaService {

	@Autowired
	private IProformaDAO dao;

	@Override
	public Proforma registrar(Proforma proforma) {
		proforma.getDetalleProforma().forEach(x -> x.setProforma(proforma));
		return dao.save(proforma);
	}

	@Override
	public void modificar(Proforma proforma) {
		dao.save(proforma);

	}

	@Override
	public void eliminar(int idProforma) {
		dao.deleteById(idProforma);

	}

	@Override
	public Proforma listarId(int idProforma) {
		return dao.findById(idProforma).get();
	}

	@Override
	public List<Proforma> listar() {
		return dao.findAll();
	}

	@Override
	public Proforma getLastProforma() {
		return dao.getLastProforma();
	}

	@Override
	public List<ConsultaListProforma> listarResumen() {
		List<ConsultaListProforma> consulta = new ArrayList<>();
		dao.listarResumen().forEach(x -> {
			ConsultaListProforma cl = new ConsultaListProforma();
			cl.setId_proforma(Integer.parseInt(String.valueOf(x[0])));
			cl.setAcuenta(BigDecimal.valueOf(Double.parseDouble(String.valueOf(x[1]))));
			cl.setEstado_proforma(String.valueOf(x[2]));
			cl.setNumero_proforma(String.valueOf(x[3]));
//			cl.setSaldo(Double.parseDouble(String.valueOf(x[4])));
//			cl.setTotal(Double.parseDouble(String.valueOf(x[5])));
			consulta.add(cl);
		});
		return consulta;
	}

	public byte[] generarReporte() {
		byte[] data = null;
		try {
			File file = new ClassPathResource("/reports/reportListP.jasper").getFile();
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), null,
					new JRBeanCollectionDataSource(this.listarResumen()));
			data = JasperExportManager.exportReportToPdf(print);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
