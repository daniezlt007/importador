package br.com.deadsystem.importador.repository;

import br.com.deadsystem.importador.model.UsedSfcCorreto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface UsedSfcRepository extends JpaRepository<UsedSfcCorreto, Long> {

    @Query(value = "select * from used_sfc where sfc_int_no= :sfcIntNo", nativeQuery = true)
    UsedSfcCorreto findBySfcIntNo(@PathVariable("sfcIntNo") String sfcIntNo);

}
