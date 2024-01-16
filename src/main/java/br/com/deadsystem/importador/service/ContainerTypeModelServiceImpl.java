package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.Charge;
import br.com.deadsystem.importador.model.ContainerTypeModel;
import br.com.deadsystem.importador.model.HeaderData;
import br.com.deadsystem.importador.model.UsedSfc;
import br.com.deadsystem.importador.repository.ContainerTypeRepository;
import br.com.deadsystem.importador.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContainerTypeModelServiceImpl implements ContainerTypeModelService {

    @Autowired
    private ContainerTypeRepository repository;

    @Override
    public ContainerTypeModel save(ContainerTypeModel containerTypeModel) {
        if(containerTypeModel != null){
            ContainerTypeModel save = this.repository.save(containerTypeModel);
            return save;
        }  else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public ContainerTypeModel edit(ContainerTypeModel containerTypeModel) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public ContainerTypeModel findById(String id) {
        Optional<ContainerTypeModel> containerTypeModelOptional = this.repository.findById(id);
        if(containerTypeModelOptional.isPresent()){
            return containerTypeModelOptional.get();
        } else {
            throw new RuntimeException("Object not found.");
        }
    }

    @Override
    public List<ContainerTypeModel> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<ContainerTypeModel> saveAll(List<ContainerTypeModel> containerDataList) {
        if(!containerDataList.isEmpty()){
            List<ContainerTypeModel> dataList = this.repository.saveAll(containerDataList);
            return dataList;
        } else {
            throw new RuntimeException("Object list is empty in method saveAll");
        }
    }

    public static ContainerTypeModel fromStringContainerType(String line) {
        ContainerTypeModel itemData = new ContainerTypeModel();
        String[] parts = line.split("\\|");

        itemData.setCodigo(getValue(parts, 0));
        itemData.setRemark(getValue(parts, 1));
        return itemData;
    }

    private static String getValue(String[] array, int index) {
        return (index >= 0 && index < array.length && !array[index].isEmpty()) ? array[index] : null;
    }
}
