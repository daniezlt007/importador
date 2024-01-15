package br.com.deadsystem.importador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Teste {

    public static void main(String[] args) {

        String dataString = "13-OCT-23";
        SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd-mmm-yy");
        SimpleDateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date data = formatoEntrada.parse(dataString);
            String dataFormatada = formatoSaida.format(data);
            System.out.println(dataFormatada);
        } catch (ParseException e) {
            System.out.println("Erro ao fazer o parse da data: " + e.getMessage());
        }

    }

}
