package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.dto.RelDto;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.util.*;

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
        //JasperExportManager.exportReportToPdfFile("D:\\HD 2\\PastaPessoal nova\\Documentos\\ProjetosJava\\importador\\relatorioTeste.jrprint");
    }

    public void gerarRelatorios(List<RelDto> relatorios) throws JRException {
        String jasperFilePath = "D:\\HD 2\\PastaPessoal nova\\Documentos\\ProjetosJava\\importador\\bill_rel_copia.jasper";
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(jasperFilePath);

        String pastaPath = "C:\\Users\\danie\\Downloads\\Arquivos BSL PDF\\relatorios\\";

        File pasta = new File(pastaPath);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }


        for (RelDto relatorio : relatorios) {
            List<RelDto> listaDataSource = new ArrayList<>();
            System.out.println(relatorio.getBlNum() + " - " + relatorio.getBookingNum());

            Map<String, Object> params = new HashMap<>();
            params.put("relDtoList", new JRBeanCollectionDataSource(Collections.singletonList(relatorio)));
            listaDataSource.add(relatorio);
            JRDataSource dataSource = new JRBeanCollectionDataSource(listaDataSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

            String nomePasta = relatorio.getBlNum() != null ? relatorio.getBlNum() : relatorio.getBookingNum();
            String relatorioPath = pastaPath + "\\" + nomePasta + ".pdf";

            JasperExportManager.exportReportToPdfFile(jasperPrint, relatorioPath);
        }
    }


    /*public void gerarRelatorios(List<RelDto> relatorios) throws JRException {
        String jasperFilePath = "D:\\HD 2\\PastaPessoal nova\\Documentos\\ProjetosJava\\importador\\bill_rel_copia.jasper";
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(jasperFilePath);

        JRDataSource dataSource = new JRBeanCollectionDataSource(relatorios);

        for (RelDto relatorio : relatorios) {
            System.out.println(relatorio.getBlNum() + " - " + relatorio.getBookingNum());
            Map<String, Object> params = new HashMap<>();
            params.put("relDtoList", dataSource);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

            String nomePasta = (relatorio.getBlNum() != null) ? relatorio.getBlNum() : relatorio.getBookingNum() + ".pdf";
            String pastaPath = "C:\\Users\\danie\\Downloads\\Arquivos BSL PDF\\relatorios\\";

            File pasta = new File(pastaPath);
            if (!pasta.exists()) {
                pasta.mkdirs();
            }

            String relatorioPath = pastaPath + "\\" + nomePasta;
            JasperExportManager.exportReportToPdfFile(jasperPrint, relatorioPath);
        }
        *//*String jasperFilePath = "D:\\HD 2\\PastaPessoal nova\\Documentos\\ProjetosJava\\importador\\bill_rel_copia.jasper";

        for (RelDto relatorioUtil : relatorios) {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(jasperFilePath);
            List<RelDto> lista = new ArrayList<>();
            lista.add(relatorioUtil);
            JRDataSource dataSource = new JRBeanCollectionDataSource(lista);
            Map<String, Object> params = new HashMap<>();
            params.put("relDtoList", dataSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

            // Criar uma pasta para cada relatório usando o nome do relatório
            String nomePasta = relatorioUtil.getBlNum() != null ? relatorioUtil.getBlNum() : relatorioUtil.getBookingNum(); // Substitua com o método correto para obter o nome
            String pastaPath = "C:\\Users\\danie\\Downloads\\Arquivos BSL PDF\\relatorios\\";

            // Criar a pasta se ela não existir
            File pasta = new File(pastaPath);
            if (!pasta.exists()) {
                pasta.mkdirs();
            }

            // Salvar o relatório na pasta específica
            String relatorioPath = pastaPath + "\\" + relatorioUtil.getBlNum() != null ? relatorioUtil.getBlNum() : relatorioUtil.getBookingNum();;
            JasperExportManager.exportReportToPdfFile(jasperPrint, relatorioPath);
        }*//*
    }*/

    private static List<RelDto> criarListaDeRelatorios() {
        // Implemente a lógica para criar a lista de RelDto
        // Exemplo:
        return null;
    }

}
