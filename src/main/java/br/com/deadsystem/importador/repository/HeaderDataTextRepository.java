package br.com.deadsystem.importador.repository;

import br.com.deadsystem.importador.model.HeaderDataTextCorreto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaderDataTextRepository extends JpaRepository<HeaderDataTextCorreto, Long> {
}
