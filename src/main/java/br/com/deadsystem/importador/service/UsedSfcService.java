package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.Charge;
import br.com.deadsystem.importador.model.UsedSfc;

import java.util.List;

public interface UsedSfcService {

    public UsedSfc save(UsedSfc usedSfc);
    public UsedSfc edit(UsedSfc usedSfc);
    public void delete(Long id);
    public UsedSfc findById(Long id);
    public List<UsedSfc> findAll();
    public List<UsedSfc> saveAll(List<UsedSfc> itemDataList);

}
