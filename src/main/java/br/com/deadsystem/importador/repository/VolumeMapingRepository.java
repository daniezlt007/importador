package br.com.deadsystem.importador.repository;

import br.com.deadsystem.importador.model.VolumeMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolumeMapingRepository extends JpaRepository<VolumeMapping, String> {
}
