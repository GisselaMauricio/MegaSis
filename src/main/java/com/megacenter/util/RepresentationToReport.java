package com.megacenter.util;

import com.megacenter.representation.report.FacturaRepresentation;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class RepresentationToReport {

    private static final Logger logger = Logger.getLogger(RepresentationToReport.class);

    public byte[] toReport(FacturaRepresentation representation) {
        try {
            // Add logo
            BufferedImage logoInputStream = null;
            if (representation.getLogo() != null) {
                InputStream is = new ByteArrayInputStream(representation.getLogo());
                logoInputStream = ImageIO.read(is);
            }
            if (logoInputStream == null) {
                InputStream is = getClass().getResourceAsStream("/your-logo-here.png");
                logoInputStream = ImageIO.read(is);
            }
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("LOGO_URL", logoInputStream);

            //create report
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Arrays.asList(representation));
            InputStream inputStream = this.getClass().getResourceAsStream("/reports/factura.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, attributes, dataSource);
            byte[] data = JasperExportManager.exportReportToPdf(print);
            return data;
        } catch (Exception e) {
            logger.error(e);
            return null;
        }
    }
}
