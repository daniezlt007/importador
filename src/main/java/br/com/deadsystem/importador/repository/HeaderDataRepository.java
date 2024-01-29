package br.com.deadsystem.importador.repository;

import br.com.deadsystem.importador.model.HeaderDataCorreto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeaderDataRepository extends JpaRepository<HeaderDataCorreto, Long> {

    public HeaderDataCorreto findByUbli(String ubli);

    @Query(value = "SELECT * FROM header_data limit 10",nativeQuery = true)
    List<HeaderDataCorreto> buscarTodosPorLimit10();

}
