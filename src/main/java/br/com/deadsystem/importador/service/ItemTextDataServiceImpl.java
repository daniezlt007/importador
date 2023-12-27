package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.HeaderData;
import br.com.deadsystem.importador.model.ItemData;
import br.com.deadsystem.importador.model.ItemTextData;
import br.com.deadsystem.importador.repository.ItemTextDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemTextDataServiceImpl implements ItemTextDataService {

    @Autowired
    private ItemTextDataRepository itemTextDataRepository;


    @Override
    public ItemTextData save(ItemTextData itemTextData) {
        if(itemTextData != null){
            ItemTextData save = this.itemTextDataRepository.save(itemTextData);
            return save;
        }  else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public ItemTextData edit(ItemTextData itemTextDataUpdate) {
        Optional<ItemTextData> itemTextDataOptional = this.itemTextDataRepository.findById(itemTextDataUpdate.getId());
        if(itemTextDataOptional.isPresent()){
            ItemTextData itemTextData = itemTextDataOptional.get();
            itemTextData.setId(itemTextData.getId());
            itemTextData.setUbli(itemTextDataUpdate.getUbli());
            itemTextData.setScacCode(itemTextDataUpdate.getScacCode());
            itemTextData.setItemNr(itemTextDataUpdate.getItemNr());
            itemTextData.setDesctiptionOfGoods(itemTextDataUpdate.getDesctiptionOfGoods());
            itemTextData.setNcmNumbers(itemTextDataUpdate.getNcmNumbers());
            return this.itemTextDataRepository.save(itemTextData);
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<ItemTextData> itemTextDataOptional = this.itemTextDataRepository.findById(id);
        if(itemTextDataOptional.isPresent()){
            this.itemTextDataRepository.delete(itemTextDataOptional.get());
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public ItemTextData findById(Long id) {
        Optional<ItemTextData> itemTextDataOptional = this.itemTextDataRepository.findById(id);
        if(itemTextDataOptional.isPresent()){
            return itemTextDataOptional.get();
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public List<ItemTextData> findAll() {
        return this.itemTextDataRepository.findAll();
    }

    @Override
    public List<ItemTextData> saveAll(List<ItemTextData> itemTextDataList) {
        if(!itemTextDataList.isEmpty()){
            List<ItemTextData> dataList = this.itemTextDataRepository.saveAll(itemTextDataList);
            return dataList;
        } else {
            throw new RuntimeException("Object list is empty in method saveAll");
        }
    }

    public static ItemTextData fromStringItemTextData(String line){
        ItemTextData itemData = new ItemTextData();
        String[] parts = line.split("\\|");
        itemData.setUbli(parts[0]);
        itemData.setScacCode(parts[1]);
        itemData.setItemNr(Integer.parseInt(parts[2]));
        itemData.setDesctiptionOfGoods(parts[3]);
        itemData.setNcmNumbers(!parts[4].isEmpty() || parts[4] != null ? parts[4] : "");
        return itemData;
    }

}
