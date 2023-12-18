package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.HeaderData;

import java.util.List;

public interface HeaderDataService {

    public HeaderData save(HeaderData headerData);
    public HeaderData update(HeaderData headerData);
    public HeaderData findById(Long id);
    public List<HeaderData> findAll();
    public void delete(Long id);

    public List<HeaderData> saveAll(List<HeaderData> headerDataList);

}
