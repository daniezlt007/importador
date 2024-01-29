package br.com.deadsystem.importador.repository;

import br.com.deadsystem.importador.model.CurrencyMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyMappingRepository extends JpaRepository<CurrencyMapping, Long> {


}
