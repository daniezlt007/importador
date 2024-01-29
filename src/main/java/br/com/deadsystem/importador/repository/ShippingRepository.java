package br.com.deadsystem.importador.repository;

import br.com.deadsystem.importador.model.Charge;
import br.com.deadsystem.importador.model.ShippingCorreto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface ShippingRepository extends JpaRepository<ShippingCorreto, Long> {

    @Query(value = "SELECT DISTINCT ON (unlocode) place_no_hsdg, place_no_columbus, unlocode, name, id \n" +
            "FROM public.places_mapping WHERE unlocode = ?1 \n" +
            "ORDER BY unlocode, id;",nativeQuery = true)
    ShippingCorreto findByUnlocode(String unlocode);

}
