package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.ItemData;

import java.util.List;

public interface ItemDataService {

    public ItemData save(ItemData itemData);
    public ItemData edit(ItemData itemData);
    public void delete(Long itemData);
    public ItemData findById(Long id);
    public List<ItemData> findAll();

    public List<ItemData> saveAll(List<ItemData> itemDataList);

}
