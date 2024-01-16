package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.Charge;
import br.com.deadsystem.importador.model.ContainerTypeModel;

import java.util.List;

public interface ContainerTypeModelService {

    public ContainerTypeModel save(ContainerTypeModel containerTypeModel);
    public ContainerTypeModel edit(ContainerTypeModel containerTypeModel);
    public void delete(String id);
    public ContainerTypeModel findById(String id);
    public List<ContainerTypeModel> findAll();
    public List<ContainerTypeModel> saveAll(List<ContainerTypeModel> containerDataList);

}
