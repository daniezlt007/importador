package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.ItemDataCorreto;
import br.com.deadsystem.importador.repository.ItemDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemDataServiceImpl implements ItemDataService {

    @Autowired
    private ItemDataRepository itemDataRepository;

    @Override
    public ItemDataCorreto save(ItemDataCorreto itemDataCorreto) {
        if(itemDataCorreto != null){
            ItemDataCorreto save = this.itemDataRepository.save(itemDataCorreto);
            return save;
        } else {
            throw new RuntimeException("Object save is null!");
        }
    }

    @Override
    public ItemDataCorreto edit(ItemDataCorreto itemDataCorretoUpdate) {
        Optional<ItemDataCorreto> itemDataOptional = this.itemDataRepository.findById(itemDataCorretoUpdate.getId());
        if(itemDataOptional.isPresent()){
            ItemDataCorreto itemDataCorreto = itemDataOptional.get();
            itemDataCorreto.setUbli(itemDataCorretoUpdate.getUbli());
            itemDataCorreto.setScacCode(itemDataCorretoUpdate.getScacCode());
            itemDataCorreto.setContainerNr(itemDataCorretoUpdate.getContainerNr());
            itemDataCorreto.setItemNr(itemDataCorretoUpdate.getItemNr());
            itemDataCorreto.setShipmentType1(itemDataCorretoUpdate.getShipmentType1());
            itemDataCorreto.setContainerType(itemDataCorretoUpdate.getContainerType());
            itemDataCorreto.setGrossWeight(itemDataCorretoUpdate.getGrossWeight());
            itemDataCorreto.setGrossWeightUnit(itemDataCorretoUpdate.getGrossWeightUnit());
            itemDataCorreto.setItemBookNo(itemDataCorretoUpdate.getItemBookNo());
            itemDataCorreto.setVolume(itemDataCorretoUpdate.getVolume());
            itemDataCorreto.setVolumeUnit(itemDataCorretoUpdate.getVolumeUnit());
            itemDataCorreto.setHsCode(itemDataCorretoUpdate.getHsCode());
            itemDataCorreto.setPackageCount(itemDataCorretoUpdate.getPackageCount());
            itemDataCorreto.setPackageType(itemDataCorretoUpdate.getPackageType());
            itemDataCorreto.setUbli13(itemDataCorretoUpdate.getUbli13());
            itemDataCorreto.setVolume(itemDataCorretoUpdate.getVolume());
            return this.itemDataRepository.save(itemDataCorreto);
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<ItemDataCorreto> itemDataOptional = this.itemDataRepository.findById(id);
        if(itemDataOptional.isPresent()){
            this.itemDataRepository.delete(itemDataOptional.get());
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public ItemDataCorreto findById(Long id) {
        Optional<ItemDataCorreto> itemDataOptional = this.itemDataRepository.findById(id);
        if(itemDataOptional.isPresent()){
            return itemDataOptional.get();
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public List<ItemDataCorreto> findAll() {
        return this.itemDataRepository.findAll();
    }

    @Override
    public List<ItemDataCorreto> saveAll(List<ItemDataCorreto> itemDataCorretoList) {
        if(!itemDataCorretoList.isEmpty()){
            List<ItemDataCorreto> dataList = this.itemDataRepository.saveAll(itemDataCorretoList);
            return dataList;
        } else {
            throw new RuntimeException("Object list is empty in method saveAll");
        }
    }

    public static ItemDataCorreto fromStringItemData(String line){
        ItemDataCorreto itemDataCorreto = new ItemDataCorreto();
        String[] parts = line.split("\\|");
        itemDataCorreto.setUbli(parts[0]);
        itemDataCorreto.setScacCode(parts[1]);
        itemDataCorreto.setContainerNr(parts[2]);
        itemDataCorreto.setItemNr(parts[3] != null ? Integer.parseInt(parts[3]) : 0);
        itemDataCorreto.setShipmentType1(parts[4]);
        itemDataCorreto.setContainerType(parts[5]);
        itemDataCorreto.setGrossWeight(parts[6] != null ? Double.parseDouble(parts[6].replace(",",".")) : 0);
        itemDataCorreto.setGrossWeightUnit(parts[7]);
        itemDataCorreto.setItemBookNo(parts[8]);
        itemDataCorreto.setVolume(parts[9] != null ? Double.parseDouble(parts[9].replace(",",".")) : 0);
        itemDataCorreto.setVolumeUnit(parts[10]);
        itemDataCorreto.setHsCode(parts[11]);
        itemDataCorreto.setPackageCount(!parts[12].isEmpty() ? Integer.parseInt(parts[12]) : 0);
        itemDataCorreto.setPackageType(parts[13]);
        itemDataCorreto.setUbli13(parts[14]);
        itemDataCorreto.setVersion(parts[15]);
        return itemDataCorreto;
    }

    public List<ItemDataCorreto> findAllByUbli(String ubli){
        return this.itemDataRepository.findAllByUbli(ubli);
    }

}
