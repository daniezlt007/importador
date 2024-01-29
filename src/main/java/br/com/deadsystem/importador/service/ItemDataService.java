package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.ItemDataCorreto;

import java.util.List;

public interface ItemDataService {

    public ItemDataCorreto save(ItemDataCorreto itemDataCorreto);
    public ItemDataCorreto edit(ItemDataCorreto itemDataCorreto);
    public void delete(Long itemData);
    public ItemDataCorreto findById(Long id);
    public List<ItemDataCorreto> findAll();

    public List<ItemDataCorreto> saveAll(List<ItemDataCorreto> itemDataCorretoList);

}
