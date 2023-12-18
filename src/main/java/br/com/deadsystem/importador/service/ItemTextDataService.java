package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.ItemTextData;

import java.util.List;

public interface ItemTextDataService {

    public ItemTextData save(ItemTextData itemTextData);
    public ItemTextData edit(ItemTextData itemTextData);
    public void delete(Long id);
    public ItemTextData findById(Long id);
    public List<ItemTextData> findAll();
    public List<ItemTextData> saveAll(List<ItemTextData> itemTextDataList);
    
}
