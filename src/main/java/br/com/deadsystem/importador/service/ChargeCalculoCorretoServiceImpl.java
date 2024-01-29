package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.Charge;
import br.com.deadsystem.importador.model.ChargeCalculoCorreto;
import br.com.deadsystem.importador.model.HeaderDataTextCorreto;
import br.com.deadsystem.importador.repository.ChargeCalculoCorretoRepository;
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
public class ChargeCalculoCorretoServiceImpl implements ChargeCalculoCorretoService {

    private static final Logger logger = LoggerFactory.getLogger(ChargeCalculoCorretoServiceImpl.class);

    @Autowired
    private ChargeCalculoCorretoRepository chargeCalculoCorretoRepository;


    @Override
    public ChargeCalculoCorreto save(ChargeCalculoCorreto chargeCalculoCorreto) {
        return null;
    }

    @Override
    public ChargeCalculoCorreto edit(ChargeCalculoCorreto chargeCalculoCorreto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ChargeCalculoCorreto findById(Long id) {
        return null;
    }

    @Override
    public List<ChargeCalculoCorreto> findAll() {
        return this.chargeCalculoCorretoRepository.findAll();
    }

    @Override
    public List<ChargeCalculoCorreto> saveAll(List<ChargeCalculoCorreto> itemDataList) {
        if (!itemDataList.isEmpty()) {
            List<ChargeCalculoCorreto> dataList = this.chargeCalculoCorretoRepository.saveAll(itemDataList);
            return dataList;
        } else {
            throw new RuntimeException("Object list is empty in method saveAll");
        }
    }

    public List<ChargeCalculoCorreto> fromStringChargeCalculoDataopenCV(MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            // Lê todas as linhas do arquivo e as junta em uma única string
            String fileContent = reader.lines().collect(Collectors.joining(System.lineSeparator()));

            // Usa CSVReaderBuilder com um CSVParser personalizado para definir o delimitador
            try (CSVReader csvReader = new CSVReaderBuilder(new StringReader(fileContent))
                    .withCSVParser(new CSVParserBuilder().withSeparator('|').build())
                    .build()) {

                String[] nextLine;
                csvReader.readNext(); // Se o arquivo CSV contiver cabeçalhos, pule a primeira linha
                ChargeCalculoCorreto chargeCalculoCorreto;
                List<ChargeCalculoCorreto> chargeCalculoCorretoArrayList = new ArrayList<>();
                while ((nextLine = csvReader.readNext()) != null) {
                    chargeCalculoCorreto = new ChargeCalculoCorreto();
                    chargeCalculoCorreto.setCalculationBaseRule(nextLine[0]);
                    chargeCalculoCorreto.setCalculationBaseUnit(nextLine[1]);
                    chargeCalculoCorreto.setAmountRdNet(Double.parseDouble(nextLine[2]));
                    chargeCalculoCorreto.setAmountRdInclVat(Double.parseDouble(nextLine[3]));
                    chargeCalculoCorreto.setAmountEur(Double.parseDouble(nextLine[4]));
                    chargeCalculoCorreto.setAmountAcc(Double.parseDouble(nextLine[5]));
                    chargeCalculoCorreto.setAmountTrf(Double.parseDouble(nextLine[6]));
                    chargeCalculoCorreto.setAmountInv(Double.parseDouble(nextLine[7]));
                    chargeCalculoCorreto.setCurrencyRd(nextLine[8]);
                    chargeCalculoCorreto.setExchangeRateRdInv(Double.parseDouble(nextLine[9]));
                    chargeCalculoCorreto.setExchangeRateRdAcc(Double.parseDouble(nextLine[10]));
                    chargeCalculoCorreto.setBoletoNo(nextLine[11]);
                    chargeCalculoCorreto.setCreationTimestamp(nextLine[12]);
                    chargeCalculoCorreto.setPlacePayUnlocode(nextLine[13]);
                    chargeCalculoCorreto.setUbli13(nextLine[14]);
                    chargeCalculoCorreto.setVersion(nextLine[15]);
                    chargeCalculoCorretoArrayList.add(chargeCalculoCorreto);
                }
                List<ChargeCalculoCorreto> chargeCalculoCorretoList = this.chargeCalculoCorretoRepository.saveAll(chargeCalculoCorretoArrayList);
                return chargeCalculoCorretoList;
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

    public List<ChargeCalculoCorreto> findAllByUbli13(String ubli3){
        return this.chargeCalculoCorretoRepository.findByUbli13(ubli3);
    }

}
