package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.UsedSfcCorreto;

import java.util.List;

public interface UsedSfcService {

    public UsedSfcCorreto save(UsedSfcCorreto usedSfcCorreto);
    public UsedSfcCorreto edit(UsedSfcCorreto usedSfcCorreto);
    public void delete(Long id);
    public UsedSfcCorreto findById(Long id);
    public List<UsedSfcCorreto> findAll();
    public List<UsedSfcCorreto> saveAll(List<UsedSfcCorreto> itemDataList);
    public UsedSfcCorreto findBySfcIdNo(String id);

}
