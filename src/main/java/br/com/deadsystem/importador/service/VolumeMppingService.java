package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.VolumeMapping;
import br.com.deadsystem.importador.repository.VolumeMapingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VolumeMppingService {

    @Autowired
    private VolumeMapingRepository volumeMapingRepository;

    public VolumeMapping findByCode(String code){
        Optional<VolumeMapping> byId = this.volumeMapingRepository.findById(code);
        if(byId.isPresent()){
            return byId.get();
        } else {
            return null;
        }
    }

}
