package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.Charge;
import br.com.deadsystem.importador.model.ItemData;

import java.util.List;

public interface ChargeService {

    public Charge save(Charge charge);
    public Charge edit(Charge charge);
    public void delete(Long id);
    public Charge findById(Long id);
    public List<Charge> findAll();
    public List<Charge> saveAll(List<Charge> itemDataList);

}
