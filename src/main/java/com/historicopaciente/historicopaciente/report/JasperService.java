package com.historicopaciente.historicopaciente.report;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class JasperService {

    public byte[] reportGenerate(String jrxmlPath, Map<String, Object> params, Map<String, Object> collections) throws FileNotFoundException {

        Iterator it = collections.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            JRDataSource dataSourceCollection = createCollectionDataSource((List<Object>) pairs.getValue());
            params.put("Collection" + pairs.getKey(), dataSourceCollection);
            it.remove();
        }

        JasperReport report = compileJrxml(jrxmlPath);

        try {
            JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());

            return JasperExportManager.exportReportToPdf(print);
        } catch (JRException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public JRDataSource createCollectionDataSource(List<Object> elements) {
        if (!elements.isEmpty()) {
            return new JRBeanCollectionDataSource(elements);
        }
        return null;
    }

    private JasperReport compileJrxml(String jrxmlPath) throws FileNotFoundException {
        InputStream is = getClass().getClassLoader().getResourceAsStream(jrxmlPath);
        if (is == null) {
            throw new FileNotFoundException("Arquivo de relatório não encontrado: reports/patient_report.jrxml");
        }

        try {
            return JasperCompileManager.compileReport(is);
        } catch (JRException exception) {
            exception.printStackTrace();
        }

        return null;
    }
}
