package br.com.deadsystem.importador.repository;

import br.com.deadsystem.importador.model.Charge;
import br.com.deadsystem.importador.model.ChargeCalculoCorreto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChargeCalculoCorretoRepository extends JpaRepository<ChargeCalculoCorreto, Long> {

    @Query(value = "SELECT * FROM charge_calculo where ubli13=?1", nativeQuery = true)
    List<ChargeCalculoCorreto> findByUbli13(String ubli13);

}
