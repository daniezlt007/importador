package br.com.deadsystem.importador.repository;

import br.com.deadsystem.importador.model.ItemTextDataCorreto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemTextDataRepository extends JpaRepository<ItemTextDataCorreto, Long> {

    @Query(value = "SELECT * FROM item_text_data WHERE ubli=?1", nativeQuery = true)
    List<ItemTextDataCorreto> findByUbli(String ubli);

}
