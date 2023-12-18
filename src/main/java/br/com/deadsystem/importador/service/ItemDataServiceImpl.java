package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.ItemData;
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
    public ItemData save(ItemData itemData) {
        if(itemData != null){
            ItemData save = this.itemDataRepository.save(itemData);
            return save;
        } else {
            throw new RuntimeException("Object save is null!");
        }
    }

    @Override
    public ItemData edit(ItemData itemDataUpdate) {
        Optional<ItemData> itemDataOptional = this.itemDataRepository.findById(itemDataUpdate.getId());
        if(itemDataOptional.isPresent()){
            ItemData itemData = itemDataOptional.get();
            itemData.setUbli(itemDataUpdate.getUbli());
            itemData.setScacCode(itemDataUpdate.getScacCode());
            itemData.setContainerNr(itemDataUpdate.getContainerNr());
            itemData.setItemNr(itemDataUpdate.getItemNr());
            itemData.setShipmentType1(itemDataUpdate.getShipmentType1());
            itemData.setContainerType(itemDataUpdate.getContainerType());
            itemData.setGrossWeight(itemDataUpdate.getGrossWeight());
            itemData.setGrossWeightUnit(itemDataUpdate.getGrossWeightUnit());
            itemData.setItemBookNo(itemDataUpdate.getItemBookNo());
            itemData.setVolume(itemDataUpdate.getVolume());
            itemData.setVolumeUnit(itemDataUpdate.getVolumeUnit());
            itemData.setHsCode(itemDataUpdate.getHsCode());
            itemData.setPackageCount(itemDataUpdate.getPackageCount());
            itemData.setPackageType(itemDataUpdate.getPackageType());
            itemData.setUbli13(itemDataUpdate.getUbli13());
            itemData.setVolume(itemDataUpdate.getVolume());
            return this.itemDataRepository.save(itemData);
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<ItemData> itemDataOptional = this.itemDataRepository.findById(id);
        if(itemDataOptional.isPresent()){
            this.itemDataRepository.delete(itemDataOptional.get());
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public ItemData findById(Long id) {
        Optional<ItemData> itemDataOptional = this.itemDataRepository.findById(id);
        if(itemDataOptional.isPresent()){
            return itemDataOptional.get();
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public List<ItemData> findAll() {
        return this.itemDataRepository.findAll();
    }

    @Override
    public List<ItemData> saveAll(List<ItemData> itemDataList) {
        if(!itemDataList.isEmpty()){
            List<ItemData> dataList = this.itemDataRepository.saveAll(itemDataList);
            return dataList;
        } else {
            throw new RuntimeException("Object list is empty in method saveAll");
        }
    }

    public static ItemData fromStringItemData(String line){
        ItemData itemData = new ItemData();
        String[] parts = line.split("\\|");
        itemData.setUbli(parts[0]);
        itemData.setScacCode(parts[1]);
        itemData.setContainerNr(parts[2]);
        itemData.setItemNr(Integer.parseInt(parts[3]));
        itemData.setShipmentType1(parts[4]);
        return itemData;
    }
}
