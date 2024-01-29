package br.com.deadsystem.importador.repository;

import br.com.deadsystem.importador.model.ItemDataCorreto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ItemDataRepository extends JpaRepository<ItemDataCorreto, Long> {

    @Query(value = "select * from item_data where ubli= :ubli", nativeQuery = true)
    public List<ItemDataCorreto> findAllByUbli(@PathVariable("ubli") String ubli);

}
