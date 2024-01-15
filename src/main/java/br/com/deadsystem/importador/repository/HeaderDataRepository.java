package br.com.deadsystem.importador.repository;

import br.com.deadsystem.importador.model.HeaderData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaderDataRepository extends JpaRepository<HeaderData, Long> {

    public HeaderData findByUbli(String ubli);

}
