package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.HeaderDataCorreto;

import java.util.List;

public interface HeaderDataService {

    public HeaderDataCorreto save(HeaderDataCorreto headerDataCorreto);
    public HeaderDataCorreto update(HeaderDataCorreto headerDataCorreto);
    public HeaderDataCorreto findById(Long id);
    public List<HeaderDataCorreto> findAll();
    public void delete(Long id);

    public List<HeaderDataCorreto> saveAll(List<HeaderDataCorreto> headerDataCorretoList);

}
