package br.com.deadsystem.importador.repository;

import br.com.deadsystem.importador.model.SfcData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SfcDataRepository extends JpaRepository<SfcData, String> {
}
