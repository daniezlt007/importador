package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.Charge;
import br.com.deadsystem.importador.model.ItemData;
import br.com.deadsystem.importador.model.UsedSfc;
import br.com.deadsystem.importador.repository.UsedSfcRepository;
import br.com.deadsystem.importador.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsedSfcServiceImpl implements UsedSfcService {

    @Autowired
    private UsedSfcRepository usedSfcRepository;

    @Override
    public UsedSfc save(UsedSfc usedSfc) {
        if(usedSfc != null){
            UsedSfc save = this.usedSfcRepository.save(usedSfc);
            return save;
        }  else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public UsedSfc edit(UsedSfc usedSfcEdit) {
        Optional<UsedSfc> usedSfcOptional = this.usedSfcRepository.findById(usedSfcEdit.getId());
        if(usedSfcOptional.isPresent()){
            UsedSfc usedSfc = usedSfcOptional.get();
            usedSfc.setSfcIntNo(usedSfcEdit.getSfcIntNo());
            usedSfc.setTerritoryNo(usedSfcEdit.getTerritoryNo());
            usedSfc.setAccountCurrent(usedSfcEdit.getAccountCurrent());
            usedSfc.setSfcName(usedSfcEdit.getSfcName());
            usedSfc.setSfcName2(usedSfcEdit.getSfcName2());
            usedSfc.setUpdateUserIntNo(usedSfcEdit.getUpdateUserIntNo());
            usedSfc.setUpdateTimestamp(usedSfcEdit.getUpdateTimestamp());
            usedSfc.setAccountType(usedSfcEdit.getAccountType());
            usedSfc.setImExport(usedSfcEdit.getImExport());
            usedSfc.setCifFob(usedSfcEdit.getCifFob());
            usedSfc.setReorgYn(usedSfcEdit.getReorgYn());
            usedSfc.setCarrierMerchant(usedSfcEdit.getCarrierMerchant());
            usedSfc.setCaresYn(usedSfcEdit.getCaresYn());
            usedSfc.setTopShipperYn(usedSfcEdit.getTopShipperYn());
            usedSfc.setBranchId(usedSfcEdit.getBranchId());
            usedSfc.setStreet(usedSfcEdit.getStreet());
            usedSfc.setCityName(usedSfcEdit.getCityName());
            usedSfc.setCountryNo(usedSfcEdit.getCountryNo());
            usedSfc.setStateNo(usedSfcEdit.getStateNo());
            usedSfc.setZipNo(usedSfcEdit.getZipNo());
            usedSfc.setPhoneNo(usedSfcEdit.getPhoneNo());
            usedSfc.setFaxNo(usedSfcEdit.getFaxNo());
            usedSfc.setEmailAddress(usedSfcEdit.getEmailAddress());
            usedSfc.setHomepageAddress(usedSfcEdit.getHomepageAddress());
            usedSfc.setTaxNo(usedSfcEdit.getTaxNo());
            usedSfc.setAreaRegionLbu(usedSfcEdit.getAreaRegionLbu());
            usedSfc.setInttraCode(usedSfcEdit.getInttraCode());
            usedSfc.setMatrix(usedSfcEdit.getMatrix());
            usedSfc.setCurrencyNo(usedSfcEdit.getCurrencyNo());
            usedSfc.setRemark(usedSfcEdit.getRemark());
            usedSfc.setAccessorOffice(usedSfcEdit.getAccessorOffice());
            usedSfc.setSiteInfo(usedSfcEdit.getSiteInfo());
            usedSfc.setSfcTypes(usedSfcEdit.getSfcTypes());
            usedSfc.setCityCode(usedSfcEdit.getCityCode());
            usedSfc.setSupplement(usedSfcEdit.getSupplement());
            usedSfc.setNeighborhood(usedSfcEdit.getNeighborhood());
            usedSfc.setStreetNumber(usedSfcEdit.getStreetNumber());
            usedSfc.setPoBox(usedSfcEdit.getPoBox());
            return this.usedSfcRepository.save(usedSfc);
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<UsedSfc> usedSfcOptional = this.usedSfcRepository.findById(id);
        if(usedSfcOptional.isPresent()){
            this.usedSfcRepository.delete(usedSfcOptional.get());
        } else {
            throw new RuntimeException("Object not found.");
        }

    }

    @Override
    public UsedSfc findById(Long id) {
        Optional<UsedSfc> usedSfc = this.usedSfcRepository.findById(id);
        if(usedSfc.isPresent()){
            return usedSfc.get();
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public List<UsedSfc> findAll() {
        return this.usedSfcRepository.findAll();
    }

    @Override
    public List<UsedSfc> saveAll(List<UsedSfc> itemDataList) {
        if(!itemDataList.isEmpty()){
            List<UsedSfc> dataList = this.usedSfcRepository.saveAll(itemDataList);
            return dataList;
        } else {
            throw new RuntimeException("Object list is empty in method saveAll");
        }
    }

    public static UsedSfc fromStringUsedSfc(String line) {
        UsedSfc itemData = new UsedSfc();
        String[] parts = line.split("\\|");

        itemData.setSfcIntNo(getValue(parts, 0));
        itemData.setTerritoryNo(getValue(parts, 1));
        itemData.setAccountCurrent(getValue(parts, 2));
        itemData.setSfcName(getValue(parts, 3));
        itemData.setSfcName2(getValue(parts, 4));
        itemData.setUpdateUserIntNo(getValue(parts, 5));
        itemData.setUpdateTimestamp(Util.convertDateTime(getValue(parts, 6)));
        itemData.setAccountType(getValue(parts, 7));
        itemData.setImExport(getValue(parts, 8));
        itemData.setCifFob(getValue(parts, 9));
        itemData.setReorgYn(getValue(parts, 10));
        itemData.setCarrierMerchant(getValue(parts, 11));
        itemData.setCaresYn(getValue(parts, 12));
        itemData.setTopShipperYn(getValue(parts, 13));
        itemData.setBranchId(getValue(parts, 14));
        itemData.setStreet(getValue(parts, 15));
        itemData.setCityName(getValue(parts, 16));
        itemData.setCountryNo(getValue(parts, 17));
        itemData.setStateNo(getValue(parts, 18));
        itemData.setZipNo(getValue(parts, 19));
        itemData.setPhoneNo(getValue(parts, 20));
        itemData.setFaxNo(getValue(parts, 21));
        itemData.setEmailAddress(getValue(parts, 22));
        itemData.setHomepageAddress(getValue(parts, 23));
        itemData.setTaxNo(getValue(parts, 24));
        itemData.setAreaRegionLbu(getValue(parts, 25));
        itemData.setInttraCode(getValue(parts, 26));
        itemData.setMatrix(getValue(parts, 27));
        itemData.setCurrencyNo(getValue(parts, 28));
        itemData.setRemark(getValue(parts, 29));
        itemData.setAccessorOffice(getValue(parts, 30));
        itemData.setSiteInfo(getValue(parts, 31));
        itemData.setSfcTypes(getValue(parts, 32));
        itemData.setCityCode(getValue(parts, 33));
        itemData.setSupplement(getValue(parts, 34));
        itemData.setNeighborhood(getValue(parts, 35));
        itemData.setStreetNumber(getValue(parts, 36));
        itemData.setPoBox(getValue(parts, 37));

        return itemData;
    }

    private static String getValue(String[] array, int index) {
        return (index >= 0 && index < array.length && !array[index].isEmpty()) ? array[index] : null;
    }

    /*public static UsedSfc fromStringUsedSfc(String line){
        UsedSfc itemData = new UsedSfc();
        String[] parts = line.split("\\|");
        itemData.setSfcIntNo(parts[0]);
        itemData.setTerritoryNo(parts[1]);
        itemData.setAccountCurrent(parts[2]);
        itemData.setSfcName(parts[3]);
        itemData.setSfcName2(parts[4]);
        itemData.setUpdateUserIntNo(parts[5]);
        itemData.setUpdateTimestamp(Util.convertDateTime(parts[6]));
        itemData.setAccountType(parts[7]);
        itemData.setImExport(parts[8]);
        itemData.setCifFob(parts[9]);
        itemData.setReorgYn(parts[10]);
        itemData.setCarrierMerchant(parts[11]);
        itemData.setCaresYn(parts[12]);
        itemData.setTopShipperYn(parts[13]);
        itemData.setBranchId(parts[14]);
        itemData.setStreet(parts[15]);
        itemData.setCityName(parts[16]);
        itemData.setCountryNo(parts[17]);
        itemData.setStateNo(parts[18]);
        itemData.setZipNo(parts[19]);
        itemData.setPhoneNo(parts[20]);
        itemData.setFaxNo(parts[21]);
        itemData.setEmailAddress(parts[22]);
        itemData.setHomepageAddress(parts[23]);
        itemData.setTaxNo(parts[24]);
        itemData.setAreaRegionLbu(parts[25]);
        itemData.setInttraCode(parts[26]);
        itemData.setMatrix(parts[27]);
        itemData.setCurrencyNo(parts[28]);
        itemData.setRemark(parts[29]);
        itemData.setAccessorOffice(parts[30]);
        itemData.setSiteInfo(parts[31]);
        itemData.setSfcTypes(parts[32]);
        itemData.setCityCode(parts[33]);
        itemData.setSupplement(parts[34]);
        itemData.setNeighborhood(parts[35]);
        itemData.setStreetNumber(parts[36]);
        itemData.setPoBox(parts[37]);
        return itemData;
    }*/

}
