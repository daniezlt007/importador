package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.Charge;
import br.com.deadsystem.importador.model.ItemTextData;
import br.com.deadsystem.importador.repository.ChargeRepository;
import br.com.deadsystem.importador.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChargeServiceImpl implements ChargeService{

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

    public static Charge fromStringChargeData(String line){
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
        itemData.setCreditDate(Util.convertDate(parts[8]));
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
    }

}
