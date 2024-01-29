package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.ChargeCalculoCorreto;

import java.util.List;

public interface ChargeCalculoCorretoService {

    public ChargeCalculoCorreto save(ChargeCalculoCorreto chargeCalculoCorreto);
    public ChargeCalculoCorreto edit(ChargeCalculoCorreto chargeCalculoCorreto);
    public void delete(Long id);
    public ChargeCalculoCorreto findById(Long id);
    public List<ChargeCalculoCorreto> findAll();
    public List<ChargeCalculoCorreto> saveAll(List<ChargeCalculoCorreto> itemDataList);

}
