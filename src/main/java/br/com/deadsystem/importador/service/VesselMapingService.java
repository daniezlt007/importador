package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.VesselMapping;
import br.com.deadsystem.importador.repository.VesselMapingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VesselMapingService {

    @Autowired
    private VesselMapingRepository vesselMapingRepository;

    public VesselMapping findById(String id){
        VesselMapping byId = this.vesselMapingRepository.findByVesselCode(id);
        return byId;
    }


}
