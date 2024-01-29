package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.ShippingCorreto;
import br.com.deadsystem.importador.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingServiceImpl implements ShippingService{

    @Autowired
    private ShippingRepository shippingRepository;

    @Override
    public ShippingCorreto save(ShippingCorreto shippingCorreto) {
        return null;
    }

    @Override
    public ShippingCorreto edit(ShippingCorreto shippingCorreto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ShippingCorreto findById(Long id) {
        return null;
    }

    @Override
    public List<ShippingCorreto> findAll() {
        return null;
    }

    @Override
    public List<ShippingCorreto> saveAll(List<ShippingCorreto> itemDataList) {
        return null;
    }

    public ShippingCorreto findByUnlocode(String unlocode){
        ShippingCorreto shippingCorreto = this.shippingRepository.findByUnlocode(unlocode);
        return shippingCorreto;
    }

}
