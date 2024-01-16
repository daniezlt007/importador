package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.dto.RelDto;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelatorioUtil {

    public void gerarRelatorio(RelDto relatorioUtil) throws JRException {
        String jasperFilePath = "D:\\HD 2\\PastaPessoal nova\\Documentos\\ProjetosJava\\importador\\bill_rel_copia.jasper";
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(jasperFilePath);
        List<RelDto> lista = new ArrayList<>();
        lista.add(relatorioUtil);
        JRDataSource dataSource = new JRBeanCollectionDataSource(lista);
        Map<String, Object> params = new HashMap<>();
        params.put("relDtoList", dataSource);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
        JasperViewer.viewReport(jasperPrint, false);
        JasperExportManager.exportReportToPdfFile("reports/relatorioTeste.jrprint");
    }

}
