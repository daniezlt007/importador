package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.Charge;
import br.com.deadsystem.importador.model.ShippingCorreto;

import java.util.List;

public interface ShippingService {

    public ShippingCorreto save(ShippingCorreto shippingCorreto);
    public ShippingCorreto edit(ShippingCorreto shippingCorreto);
    public void delete(Long id);
    public ShippingCorreto findById(Long id);
    public List<ShippingCorreto> findAll();
    public List<ShippingCorreto> saveAll(List<ShippingCorreto> itemDataList);

}
