package br.com.deadsystem.importador.repository;

import br.com.deadsystem.importador.model.ItemData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDataRepository extends JpaRepository<ItemData, Long> {
}
