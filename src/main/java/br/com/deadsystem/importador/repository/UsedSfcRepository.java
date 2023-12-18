package br.com.deadsystem.importador.repository;

import br.com.deadsystem.importador.model.UsedSfc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsedSfcRepository extends JpaRepository<UsedSfc, Long> {
}
