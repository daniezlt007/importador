package br.com.deadsystem.importador.repository;

import br.com.deadsystem.importador.model.VesselMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VesselMapingRepository extends JpaRepository<VesselMapping, String> {

    @Query(value="SELECT * FROM vessel_mapping where vessel_code=?1", nativeQuery = true)
    VesselMapping findByVesselCode(String code);

}
