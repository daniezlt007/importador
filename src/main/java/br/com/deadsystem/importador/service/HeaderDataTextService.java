package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.HeaderDataTextCorreto;

import java.util.List;

public interface HeaderDataTextService {

    public HeaderDataTextCorreto save(HeaderDataTextCorreto headerDataTextCorreto);
    public List<HeaderDataTextCorreto> saveAll(List<HeaderDataTextCorreto> headerDataTextCorretoList);

}
