package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.Charge;
import br.com.deadsystem.importador.model.SfcData;
import br.com.deadsystem.importador.repository.SfcDataRepository;
import br.com.deadsystem.importador.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SfcServiceImpl implements SfcService{

    @Autowired
    private SfcDataRepository repository;

    @Override
    public SfcData save(SfcData sfcData) {
        if(sfcData != null){
            SfcData save = this.repository.save(sfcData);
            return save;
        }  else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public SfcData edit(SfcData sfcData) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public SfcData findById(String id) {
        if(!id.isEmpty()){
            Optional<SfcData> sfcDataOptional = this.repository.findById(id);
            if(sfcDataOptional.isPresent()){
                SfcData sfcData = sfcDataOptional.get();
                return sfcData;
            } else {
                return null;
            }
        } else {
            throw new RuntimeException("Id is empty in method findById");
        }
    }

    @Override
    public List<SfcData> findAll() {
        return null;
    }

    @Override
    public List<SfcData> saveAll(List<SfcData> itemDataList) {
        if(!itemDataList.isEmpty()){
            List<SfcData> dataList = this.repository.saveAll(itemDataList);
            return dataList;
        } else {
            throw new RuntimeException("Object list is empty in method saveAll");
        }
    }

    private static String getValue(String[] array, int index) {
        return (index >= 0 && index < array.length && !array[index].isEmpty()) ? array[index] : null;
    }

    public static SfcData fromStringChargeData(String line) {
        SfcData itemData = new SfcData();
        String[] parts = line.split("\\|");

        itemData.setSfcIntNo(getValue(parts, 0));
        itemData.setSfcName(getValue(parts, 1));
        itemData.setSfcName2(getValue(parts, 2));
        itemData.setStreet(getValue(parts, 3));
        itemData.setCityName(getValue(parts, 4));
        itemData.setCountryNo(getValue(parts, 5));
        itemData.setStateNo(getValue(parts, 6));
        itemData.setZipNo(getValue(parts, 7));
        itemData.setPhoneNo(getValue(parts, 8));
        itemData.setSupplement(getValue(parts, 9));
        itemData.setStreetNumber(getValue(parts, 10));

        return itemData;
    }

}
