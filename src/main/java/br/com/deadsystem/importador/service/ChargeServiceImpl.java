package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.Charge;
import br.com.deadsystem.importador.repository.ChargeRepository;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChargeServiceImpl implements ChargeService{

    private static final Logger logger = LoggerFactory.getLogger(Charge.class);

    @Autowired
    private ChargeRepository chargeRepository;

    @Override
    public Charge save(Charge charge) {
        if(charge != null){
            Charge save = this.chargeRepository.save(charge);
            return save;
        }  else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public Charge edit(Charge charge) {
        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Charge> chargeOptional = this.chargeRepository.findById(id);
        if(chargeOptional.isPresent()){
            this.chargeRepository.delete(chargeOptional.get());
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public Charge findById(Long id) {
        Optional<Charge> chargeOptional = this.chargeRepository.findById(id);
        if(chargeOptional.isPresent()){
            return chargeOptional.get();
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public List<Charge> findAll() {
        return this.chargeRepository.findAll();
    }

    @Override
    public List<Charge> saveAll(List<Charge> chargeList) {
        if(!chargeList.isEmpty()){
            List<Charge> dataList = this.chargeRepository.saveAll(chargeList);
            return dataList;
        } else {
            throw new RuntimeException("Object list is empty in method saveAll");
        }
    }

    private static String getValue(String[] array, int index) {
        return (index >= 0 && index < array.length && !array[index].isEmpty()) ? array[index] : null;
    }

    /*public static Charge fromStringChargeData(String line) {
        Charge itemData = new Charge();
        String[] parts = line.split("\\|");

        itemData.setUbli(getValue(parts, 0));

        if (getValue(parts, 1) != null) {
            try {
                itemData.setItemNr(Integer.parseInt(getValue(parts, 1)));
            } catch (NumberFormatException e) {
                // Lidar com a exceção de conversão de string para inteiro, se necessário
            }
        }

        if (getValue(parts, 2) != null) {
            try {
                itemData.setItemOrder(Integer.parseInt(getValue(parts, 2)));
            } catch (NumberFormatException e) {
                // Lidar com a exceção de conversão de string para inteiro, se necessário
            }
        }
        itemData.setUbli(getValue(parts, 0));
        itemData.setItemNr(getValue(parts, 1));
        itemData.setItemOrder(getValue(parts, 2));
        itemData.setChargeCode(getValue(parts, 3));
        itemData.setChargeNameShort(getValue(parts, 4));
        itemData.setChargePayMode(getValue(parts, 5));
        itemData.setInvoiceDate(getValue(parts, 6) != null ? getValue(parts, 6) : null);
        itemData.setInvoiceNo(getValue(parts, 7));
        itemData.setCreditDate(getValue(parts, 8) != null && getValue(parts, 8).length() > 1 ? Util.convertDate(getValue(parts, 8)) : null);
        itemData.setCreditNo(getValue(parts, 9));
        itemData.setAccountingCompany(getValue(parts, 10));
        itemData.setAgencyCode(getValue(parts, 11));
        itemData.setCustomer(getValue(parts, 12));
        itemData.setPlacePayCode(getValue(parts, 13));
        itemData.setYmcMain(getValue(parts, 14));
        itemData.setCalculationRate(getValue(parts, 15) != null ? Double.parseDouble(getValue(parts, 15).replace(",", ".")) : 0);
        itemData.setCalculationFactor(getValue(parts, 16) != null ? Double.parseDouble(getValue(parts, 16).replace(",", ".")) : 0);
        itemData.setCalculationBaseRule(getValue(parts, 17));
        itemData.setCalculationBaseUnit(getValue(parts, 18));
        itemData.setAmountRdNet(getValue(parts, 19) != null ? Double.parseDouble(getValue(parts, 19).replace(",",".")) : null);
        itemData.setAmountRdInclVat(getValue(parts, 20) != null ? Double.parseDouble(getValue(parts, 20).replace(",",".")) : null);
        itemData.setAmountEur(getValue(parts, 21) != null ? Double.parseDouble(getValue(parts, 21).replace(",",".")) : null);
        itemData.setAmountAcc(getValue(parts, 22) != null ? Double.parseDouble(getValue(parts, 22).replace(",",".")) : null);
        itemData.setAmountTrf(getValue(parts, 23) != null ? Double.parseDouble(getValue(parts, 23).replace(",",".")) : null);
        itemData.setAmountInv(getValue(parts, 24) != null ? Double.parseDouble(getValue(parts, 24).replace(",",".")) : null);
        itemData.setCurrencyRd(getValue(parts, 25));
        itemData.setExchangeRateRdInv(getValue(parts, 26) != null ? Double.parseDouble(getValue(parts, 26).replace(",",".")) : null);
        itemData.setExchangeRateRdTrf(getValue(parts, 27) != null ? Double.parseDouble(getValue(parts, 27).replace(",",".")) : null);
        itemData.setExchangeRateRdAcc(getValue(parts, 28) != null ? Double.parseDouble(getValue(parts, 28).replace(",",".")) : null);
        itemData.setBoletoNo(getValue(parts, 29));
        itemData.setCreationTimestamp(getValue(parts, 30) != null ? Util.convertDateTime(getValue(parts, 30)) : null);
        itemData.setPlacePayUnlocode(getValue(parts, 31));
        itemData.setUbli13(getValue(parts, 32));
        itemData.setVersion(getValue(parts, 33) != null ? Integer.parseInt(getValue(parts, 33)) : null);

        return itemData;
    }*/
    public List<Charge> fromStringChargeDataopenCV(MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            // Lê todas as linhas do arquivo e as junta em uma única string
            String fileContent = reader.lines().collect(Collectors.joining(System.lineSeparator()));

            // Usa CSVReaderBuilder com um CSVParser personalizado para definir o delimitador
            try (CSVReader csvReader = new CSVReaderBuilder(new StringReader(fileContent))
                    .withCSVParser(new CSVParserBuilder().withSeparator('|').build())
                    .build()) {

                String[] nextLine;
                csvReader.readNext(); // Se o arquivo CSV contiver cabeçalhos, pule a primeira linha
                Charge charge;
                List<Charge> chargeList = new ArrayList<>();
                while ((nextLine = csvReader.readNext()) != null) {
                    charge = new Charge();
                    charge.setUbli(nextLine[0]);
                    charge.setItemNr(nextLine[1]);
                    charge.setItemOrder(nextLine[2]);
                    charge.setChargeCode(nextLine[3]);
                    charge.setChargeNameShort(nextLine[4]);
                    charge.setChargePayMode(nextLine[5]);
                    charge.setInvoiceDate(nextLine[6]);
                    charge.setInvoiceNo(nextLine[7]);
                    charge.setCreditDate(nextLine[8]);
                    charge.setCreditNo(nextLine[9]);
                    charge.setAccountingCompany(nextLine[10]);
                    charge.setAgencyCode(nextLine[11]);
                    charge.setCustomer(nextLine[12]);
                    charge.setPlacePayCode(nextLine[13]);
                    charge.setYmcMain(nextLine[14]);
                    charge.setCalculationRate(nextLine[15]);
                    charge.setCalculationFactor(nextLine[16]);
                    charge.setCalculationBaseRule(nextLine[17]);
                    charge.setCalculationBaseUnit(nextLine[18]);
                    charge.setAmountRdNet(nextLine[19]);
                    charge.setAmountRdInclVat(nextLine[20]);
                    charge.setAmountEur(nextLine[21]);
                    charge.setAmountAcc(nextLine[22]);
                    charge.setAmountTrf(nextLine[23]);
                    charge.setAmountInv(nextLine[24]);
                    charge.setCurrencyRd(nextLine[25]);
                    charge.setExchangeRateRdInv(nextLine[26]);
                    charge.setExchangeRateRdTrf(nextLine[27]);
                    charge.setExchangeRateRdAcc(nextLine[28]);
                    charge.setBoletoNo(nextLine[29]);
                    charge.setCreationTimestamp(nextLine[30]);
                    charge.setPlacePayUnlocode(nextLine[31]);
                    charge.setUbli13(nextLine[32]);
                    charge.setVersion(nextLine[33]);
                    chargeList.add(charge);
                }
                List<Charge> headerDataTextListSave = this.chargeRepository.saveAll(chargeList);
                return headerDataTextListSave;
            } catch (CsvValidationException e) {
                logger.error("Erro durante a validação CSV", e);
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            logger.error("Erro ao ler o arquivo CSV", e);
            throw new RuntimeException(e);
        }
    }



    /*public static Charge fromStringChargeData(String line){
        Charge itemData = new Charge();
        String[] parts = line.split("\\|");
        itemData.setUbli(parts[0]);
        itemData.setItemNr(Integer.parseInt(parts[1]));
        itemData.setItemOrder(Integer.parseInt(parts[2]));
        itemData.setChargeCode(parts[3]);
        itemData.setChargeNameShort(parts[4]);
        itemData.setChargePayMode(parts[5]);
        itemData.setInvoiceDate(Util.convertDate(parts[6]));
        itemData.setInvoiceNo(parts[7]);
        itemData.setCreditDate(parts[8] != null && parts[8].length() > 1 ? Util.convertDate(parts[8]) : null);
        itemData.setCreditNo(parts[9]);
        itemData.setAccountingCompany(parts[10]);
        itemData.setAgencyCode(parts[11]);
        itemData.setCustomer(parts[12]);
        itemData.setPlacePayCode(parts[13]);
        itemData.setYmcMain(parts[14]);
        itemData.setCalculationBaseRule(parts[15]);
        itemData.setCalculationBaseUnit(parts[16]);
        itemData.setAmountRdNet(Double.parseDouble(parts[17]));
        itemData.setAmountRdInclVat(Double.parseDouble(parts[18]));
        itemData.setAmountEur(Double.parseDouble(parts[19]));
        itemData.setAmountAcc(Double.parseDouble(parts[20]));
        itemData.setAmountTrf(Double.parseDouble(parts[21]));
        itemData.setAmountInv(Double.parseDouble(parts[22]));
        itemData.setCurrencyRd(parts[23]);
        itemData.setExchangeRateRdInv(Double.parseDouble(parts[24]));
        itemData.setExchangeRateRdTrf(Double.parseDouble(parts[25]));
        itemData.setExchangeRateRdAcc(Double.parseDouble(parts[26]));
        itemData.setBoletoNo(parts[27]);
        itemData.setCreationTimestamp(Util.convertDateTime(parts[28]));
        itemData.setPlacePayUnlocode(parts[29]);
        itemData.setUbli13(parts[30]);
        itemData.setVersion(Integer.parseInt(parts[31]));
        return itemData;
    }*/

}
