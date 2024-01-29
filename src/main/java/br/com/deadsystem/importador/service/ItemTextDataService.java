package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.ItemTextDataCorreto;

import java.util.List;

public interface ItemTextDataService {

    public ItemTextDataCorreto save(ItemTextDataCorreto itemTextDataCorreto);
    public ItemTextDataCorreto edit(ItemTextDataCorreto itemTextDataCorreto);
    public void delete(Long id);
    public ItemTextDataCorreto findById(Long id);
    public List<ItemTextDataCorreto> findAll();
    public List<ItemTextDataCorreto> saveAll(List<ItemTextDataCorreto> itemTextDataCorretoList);
    
}
