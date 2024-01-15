package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.SfcData;
import br.com.deadsystem.importador.model.SfcData;

import java.util.List;

public interface SfcService {

    public SfcData save(SfcData SfcData);
    public SfcData edit(SfcData SfcData);

    public void delete(String id);

    public SfcData findById(String id);
    public List<SfcData> findAll();
    public List<SfcData> saveAll(List<SfcData> itemDataList);
    
}
