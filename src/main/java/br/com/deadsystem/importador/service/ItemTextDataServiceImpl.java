package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.ItemTextDataCorreto;
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
    public ItemTextDataCorreto save(ItemTextDataCorreto itemTextDataCorreto) {
        if(itemTextDataCorreto != null){
            ItemTextDataCorreto save = this.itemTextDataRepository.save(itemTextDataCorreto);
            return save;
        }  else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public ItemTextDataCorreto edit(ItemTextDataCorreto itemTextDataCorretoUpdate) {
        Optional<ItemTextDataCorreto> itemTextDataOptional = this.itemTextDataRepository.findById(itemTextDataCorretoUpdate.getId());
        if(itemTextDataOptional.isPresent()){
            ItemTextDataCorreto itemTextDataCorreto = itemTextDataOptional.get();
            itemTextDataCorreto.setId(itemTextDataCorreto.getId());
            itemTextDataCorreto.setUbli(itemTextDataCorretoUpdate.getUbli());
            itemTextDataCorreto.setScacCode(itemTextDataCorretoUpdate.getScacCode());
            itemTextDataCorreto.setItemNr(itemTextDataCorretoUpdate.getItemNr());
            itemTextDataCorreto.setDescriptionOfGoods(itemTextDataCorretoUpdate.getDescriptionOfGoods());
            itemTextDataCorreto.setNcmNumbers(itemTextDataCorretoUpdate.getNcmNumbers());
            return this.itemTextDataRepository.save(itemTextDataCorreto);
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<ItemTextDataCorreto> itemTextDataOptional = this.itemTextDataRepository.findById(id);
        if(itemTextDataOptional.isPresent()){
            this.itemTextDataRepository.delete(itemTextDataOptional.get());
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public ItemTextDataCorreto findById(Long id) {
        Optional<ItemTextDataCorreto> itemTextDataOptional = this.itemTextDataRepository.findById(id);
        if(itemTextDataOptional.isPresent()){
            return itemTextDataOptional.get();
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public List<ItemTextDataCorreto> findAll() {
        return this.itemTextDataRepository.findAll();
    }

    @Override
    public List<ItemTextDataCorreto> saveAll(List<ItemTextDataCorreto> itemTextDataCorretoList) {
        if(!itemTextDataCorretoList.isEmpty()){
            List<ItemTextDataCorreto> dataList = this.itemTextDataRepository.saveAll(itemTextDataCorretoList);
            return dataList;
        } else {
            throw new RuntimeException("Object list is empty in method saveAll");
        }
    }

    public static ItemTextDataCorreto fromStringItemTextData(String line){
        ItemTextDataCorreto itemData = new ItemTextDataCorreto();
        String[] parts = line.split("\\|");
        itemData.setUbli(parts[0]);
        itemData.setScacCode(parts[1]);
        itemData.setItemNr(parts[2]);
        itemData.setDescriptionOfGoods(parts[3]);
        itemData.setNcmNumbers(parts[4]);
        return itemData;
    }

    public String findByUbli(String ubli){
        List<ItemTextDataCorreto> itemTextDataCorretoList = this.itemTextDataRepository.findByUbli(ubli);
        String msg = "";
        for (ItemTextDataCorreto itemTextDataCorreto : itemTextDataCorretoList){
            msg += itemTextDataCorreto.getDescriptionOfGoods() + " ";
        }
        return msg;
    }


}
