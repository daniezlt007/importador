package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.CurrencyMapping;
import br.com.deadsystem.importador.repository.CurrencyMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyMappingServiceImpl {

    @Autowired
    private CurrencyMappingRepository repository;

    public CurrencyMapping findById(Integer id){
        return this.repository.findById(Long.valueOf(id)).get();
    }


}
