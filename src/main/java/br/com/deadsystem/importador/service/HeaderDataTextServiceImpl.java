package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.HeaderDataTextCorreto;
import br.com.deadsystem.importador.repository.HeaderDataTextRepository;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeaderDataTextServiceImpl implements HeaderDataTextService {

    private static final Logger logger = LoggerFactory.getLogger(HeaderDataTextCorreto.class);

    @Autowired
    private HeaderDataTextRepository dataTextRepository;


    @Override
    public HeaderDataTextCorreto save(HeaderDataTextCorreto headerDataTextCorreto) {
        if (headerDataTextCorreto != null) {
            HeaderDataTextCorreto save = this.dataTextRepository.save(headerDataTextCorreto);
            return save;
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public List<HeaderDataTextCorreto> saveAll(List<HeaderDataTextCorreto> headerDataTextCorretoList) {
        if (!headerDataTextCorretoList.isEmpty()) {
            List<HeaderDataTextCorreto> dataList = this.dataTextRepository.saveAll(headerDataTextCorretoList);
            return dataList;
        } else {
            throw new RuntimeException("Object list is empty in method saveAll");
        }
    }

    public static HeaderDataTextCorreto fromStringHeaderData(String line) {
        HeaderDataTextCorreto headerDataTextCorreto = new HeaderDataTextCorreto();
        String[] parts = line.split("\\|");

        headerDataTextCorreto.setStation(parts[0]);
        headerDataTextCorreto.setUbli(parts[1]);
        headerDataTextCorreto.setScacCode(parts[2]);
        headerDataTextCorreto.setBlRemarks(parts[3]);
        headerDataTextCorreto.setBilateralAgreements(parts[4]);
        headerDataTextCorreto.setDocumentRemarks(parts[5]);
        headerDataTextCorreto.setPrimaryBlMark(parts[6]);

        return headerDataTextCorreto;
    }


    public List<HeaderDataTextCorreto> fromStringHeaderDataopenCV(MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            // Lê todas as linhas do arquivo e as junta em uma única string
            String fileContent = reader.lines().collect(Collectors.joining(System.lineSeparator()));

            // Usa CSVReaderBuilder com um CSVParser personalizado para definir o delimitador
            try (CSVReader csvReader = new CSVReaderBuilder(new StringReader(fileContent))
                    .withCSVParser(new CSVParserBuilder().withSeparator('|').build())
                    .build()) {

                String[] nextLine;
                //csvReader.readNext(); // Se o arquivo CSV contiver cabeçalhos, pule a primeira linha
                HeaderDataTextCorreto headerDataTextCorreto;
                List<HeaderDataTextCorreto> headerDataTextCorretoList = new ArrayList<>();
                while ((nextLine = csvReader.readNext()) != null) {
                    headerDataTextCorreto = new HeaderDataTextCorreto();
                    headerDataTextCorreto.setStation(nextLine[0]);
                    headerDataTextCorreto.setUbli(nextLine[1]);
                    headerDataTextCorreto.setScacCode(nextLine[2]);
                    headerDataTextCorreto.setCreationTimestamp(nextLine[3]);
                    headerDataTextCorreto.setBlRemarks(nextLine[4]);
                    headerDataTextCorreto.setBilateralAgreements(nextLine[5]);
                    headerDataTextCorreto.setDocumentRemarks(nextLine[6]);
                    headerDataTextCorreto.setPrimaryBlMark(nextLine[7]);
                    headerDataTextCorretoList.add(headerDataTextCorreto);
                }
                List<HeaderDataTextCorreto> headerDataTextCorretoListSave = this.dataTextRepository.saveAll(headerDataTextCorretoList);
                return headerDataTextCorretoListSave;
            } catch (CsvValidationException e) {
                logger.error("Erro durante a validação CSV", e);
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            logger.error("Erro ao ler o arquivo CSV", e);
            throw new RuntimeException(e);
        }
    }


    public static File convert(MultipartFile multipartFile) throws IOException {
        File file = File.createTempFile("temp", null);

        try (var inputStream = multipartFile.getInputStream()) {
            Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

        return file;
    }

}
