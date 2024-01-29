package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.UsedSfcCorreto;
import br.com.deadsystem.importador.repository.UsedSfcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsedSfcServiceImpl implements UsedSfcService {

    @Autowired
    private UsedSfcRepository usedSfcRepository;

    @Override
    public UsedSfcCorreto save(UsedSfcCorreto usedSfcCorreto) {
        if(usedSfcCorreto != null){
            UsedSfcCorreto save = this.usedSfcRepository.save(usedSfcCorreto);
            return save;
        }  else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public UsedSfcCorreto edit(UsedSfcCorreto usedSfcCorretoEdit) {
        Optional<UsedSfcCorreto> usedSfcOptional = this.usedSfcRepository.findById(usedSfcCorretoEdit.getId());
        if(usedSfcOptional.isPresent()){
            UsedSfcCorreto usedSfcCorreto = usedSfcOptional.get();
            usedSfcCorreto.setSfcIntNo(usedSfcCorretoEdit.getSfcIntNo());
            usedSfcCorreto.setTerritoryNo(usedSfcCorretoEdit.getTerritoryNo());
            usedSfcCorreto.setAccountCurrent(usedSfcCorretoEdit.getAccountCurrent());
            usedSfcCorreto.setSfcName(usedSfcCorretoEdit.getSfcName());
            usedSfcCorreto.setSfcName2(usedSfcCorretoEdit.getSfcName2());
            usedSfcCorreto.setUpdateUserIntNo(usedSfcCorretoEdit.getUpdateUserIntNo());
            usedSfcCorreto.setUpdateTimestamp(usedSfcCorretoEdit.getUpdateTimestamp());
            usedSfcCorreto.setAccountType(usedSfcCorretoEdit.getAccountType());
            usedSfcCorreto.setImExport(usedSfcCorretoEdit.getImExport());
            usedSfcCorreto.setCifFob(usedSfcCorretoEdit.getCifFob());
            usedSfcCorreto.setReorgYn(usedSfcCorretoEdit.getReorgYn());
            usedSfcCorreto.setCarrierMerchant(usedSfcCorretoEdit.getCarrierMerchant());
            usedSfcCorreto.setCaresYn(usedSfcCorretoEdit.getCaresYn());
            usedSfcCorreto.setTopShipperYn(usedSfcCorretoEdit.getTopShipperYn());
            usedSfcCorreto.setBranchId(usedSfcCorretoEdit.getBranchId());
            usedSfcCorreto.setStreet(usedSfcCorretoEdit.getStreet());
            usedSfcCorreto.setCityName(usedSfcCorretoEdit.getCityName());
            usedSfcCorreto.setCountryNo(usedSfcCorretoEdit.getCountryNo());
            usedSfcCorreto.setStateNo(usedSfcCorretoEdit.getStateNo());
            usedSfcCorreto.setZipNo(usedSfcCorretoEdit.getZipNo());
            usedSfcCorreto.setPhoneNo(usedSfcCorretoEdit.getPhoneNo());
            usedSfcCorreto.setFaxNo(usedSfcCorretoEdit.getFaxNo());
            usedSfcCorreto.setEmailAddress(usedSfcCorretoEdit.getEmailAddress());
            usedSfcCorreto.setHomepageAddress(usedSfcCorretoEdit.getHomepageAddress());
            usedSfcCorreto.setTaxNo(usedSfcCorretoEdit.getTaxNo());
            usedSfcCorreto.setAreaRegionLbu(usedSfcCorretoEdit.getAreaRegionLbu());
            usedSfcCorreto.setInttraCode(usedSfcCorretoEdit.getInttraCode());
            usedSfcCorreto.setMatrix(usedSfcCorretoEdit.getMatrix());
            usedSfcCorreto.setCurrencyNo(usedSfcCorretoEdit.getCurrencyNo());
            usedSfcCorreto.setRemark(usedSfcCorretoEdit.getRemark());
            usedSfcCorreto.setAccessorOffice(usedSfcCorretoEdit.getAccessorOffice());
            usedSfcCorreto.setSiteInfo(usedSfcCorretoEdit.getSiteInfo());
            usedSfcCorreto.setSfcTypes(usedSfcCorretoEdit.getSfcTypes());
            usedSfcCorreto.setCityCode(usedSfcCorretoEdit.getCityCode());
            usedSfcCorreto.setSupplement(usedSfcCorretoEdit.getSupplement());
            usedSfcCorreto.setNeighborhood(usedSfcCorretoEdit.getNeighborhood());
            usedSfcCorreto.setStreetNumber(usedSfcCorretoEdit.getStreetNumber());
            usedSfcCorreto.setPoBox(usedSfcCorretoEdit.getPoBox());
            return this.usedSfcRepository.save(usedSfcCorreto);
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<UsedSfcCorreto> usedSfcOptional = this.usedSfcRepository.findById(id);
        if(usedSfcOptional.isPresent()){
            this.usedSfcRepository.delete(usedSfcOptional.get());
        } else {
            throw new RuntimeException("Object not found.");
        }

    }

    @Override
    public UsedSfcCorreto findById(Long id) {
        Optional<UsedSfcCorreto> usedSfc = this.usedSfcRepository.findById(id);
        if(usedSfc.isPresent()){
            return usedSfc.get();
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public List<UsedSfcCorreto> findAll() {
        return this.usedSfcRepository.findAll();
    }

    @Override
    public List<UsedSfcCorreto> saveAll(List<UsedSfcCorreto> itemDataList) {
        if(!itemDataList.isEmpty()){
            List<UsedSfcCorreto> dataList = this.usedSfcRepository.saveAll(itemDataList);
            return dataList;
        } else {
            throw new RuntimeException("Object list is empty in method saveAll");
        }
    }

    @Override
    public UsedSfcCorreto findBySfcIdNo(String id) {
        if(!id.isEmpty()){
            UsedSfcCorreto sfcDataOptional = this.usedSfcRepository.findBySfcIntNo(id);
            if(sfcDataOptional != null){
                UsedSfcCorreto sfcData = sfcDataOptional;
                return sfcData;
            } else {
                return null;
            }
        } else {
            return null;
            //throw new RuntimeException("Id is empty in method findById");
        }
    }

    public static UsedSfcCorreto fromStringUsedSfc(String line) {
        UsedSfcCorreto itemData = new UsedSfcCorreto();
        String[] parts = line.split("\\|");

        itemData.setSfcIntNo(getValue(parts, 0));
        itemData.setTerritoryNo(getValue(parts, 1));
        itemData.setAccountCurrent(getValue(parts, 2));
        itemData.setSfcName(getValue(parts, 3));
        itemData.setSfcName2(getValue(parts, 4));
        itemData.setUpdateUserIntNo(getValue(parts, 5));
        itemData.setUpdateTimestamp(getValue(parts, 6));
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
        itemData.setPlaceIntNo(getValue(parts, 20));
        itemData.setPhoneNo(getValue(parts, 21));
        itemData.setFaxNo(getValue(parts, 22));
        itemData.setEmailAddress(getValue(parts, 23));
        itemData.setHomepageAddress(getValue(parts, 24));
        itemData.setTaxNo(getValue(parts, 25));
        itemData.setAreaRegionLbu(getValue(parts, 26));
        itemData.setInttraCode(getValue(parts, 27));
        itemData.setMatrix(getValue(parts, 28));
        itemData.setCurrencyNo(getValue(parts, 29));
        itemData.setRemark(getValue(parts, 30));
        itemData.setAccessorOffice(getValue(parts, 31));
        itemData.setSiteInfo(getValue(parts, 32));
        itemData.setSfcTypes(getValue(parts, 33));
        itemData.setCityCode(getValue(parts, 34));
        itemData.setSupplement(getValue(parts, 35));
        itemData.setNeighborhood(getValue(parts, 36));
        itemData.setStreetNumber(getValue(parts, 37));
        itemData.setPoBox(getValue(parts, 38));

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
