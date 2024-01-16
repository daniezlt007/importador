package br.com.deadsystem.importador.repository;

import br.com.deadsystem.importador.model.ContainerTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContainerTypeRepository extends JpaRepository<ContainerTypeModel, String> {
}
