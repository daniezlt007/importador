package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.ContainerTypeModel;
import br.com.deadsystem.importador.model.HeaderData;
import br.com.deadsystem.importador.model.ItemData;
import br.com.deadsystem.importador.model.SfcData;
import br.com.deadsystem.importador.model.dto.ItemDto;
import br.com.deadsystem.importador.model.dto.RelDto;
import br.com.deadsystem.importador.repository.ItemDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeradorRelatorioService {

    @Autowired
    private SfcServiceImpl sfcService;

    @Autowired
    private HeaderDataServiceImpl headerDataService;

    @Autowired
    private ContainerTypeModelServiceImpl containerTypeModelService;

    @Autowired
    private ItemDataServiceImpl itemDataService;


    public RelDto retornoRel(String ubli){
        HeaderData headerData = this.headerDataService.findByUbli(ubli);
        RelDto relDto = new RelDto();
        relDto.setScacCode(headerData.getScacCode());
        relDto.setIssueDate(headerData.getIssueDate());
        relDto.setShipper(retornoCampoShipper(headerData.getShipper()));
        relDto.setConsignee(retornoCampoShipper(headerData.getConsignee()));
        relDto.setNotify(retornoCampoShipper(headerData.getNotify1()));
        relDto.setBlNum(headerData.getShortBlNr());
        relDto.setBookingNum(headerData.getBookingNumber());
        //relDto.setExportReferences(headerData.);
        relDto.setVoyage(headerData.getVoyage());
        relDto.setOceanVessel(headerData.getVessel());
        relDto.setPortOfLoading(headerData.getPortOfLoading());
        relDto.setPortOfDischarge(headerData.getPortOfDischarge());
        relDto.setItemDtoList(buscarTodosItens(headerData.getUbli()));
        return relDto;
    }

    private String retornoCampoShipper(String sfc){
        SfcData sfcData = this.sfcService.findById(sfc);
        if(sfcData != null){
            StringBuilder builder = new StringBuilder();
            builder.append((sfcData.getSfcName() != null ? sfcData.getSfcName() : "") + " ");
            builder.append((sfcData.getSfcName2() != null ? sfcData.getSfcName2() : "") + " ");
            builder.append((sfcData.getStreet() != null ? sfcData.getStreet() : "") + " ");
            builder.append((sfcData.getCityName() != null ? sfcData.getCityName() : "") + " ");
            builder.append((sfcData.getCountryNo() != null ? sfcData.getCountryNo() : "") + " ");
            builder.append((sfcData.getStateNo() != null ? sfcData.getStateNo() : "") + " ");
            builder.append((sfcData.getZipNo() != null ? sfcData.getZipNo() : "") + " ");
            builder.append((sfcData.getPhoneNo() != null ? sfcData.getPhoneNo() : "") + " ");
            builder.append((sfcData.getSupplement() != null ? sfcData.getSupplement() : "") + " ");
            builder.append((sfcData.getStreetNumber() != null ? sfcData.getStreetNumber() : "") + " ");
            return builder.toString();
        } else {
            return "Dados não existentes";
        }
    }

    private String retornoContainerTypeModel(String codigo){
        ContainerTypeModel containerTypeModelById = this.containerTypeModelService.findById(codigo);
        if(containerTypeModelById != null){
            return containerTypeModelById.getRemark();
        } else {
            return "";
        }
    }

    private List<ItemDto> buscarTodosItens(String ubli){
        List<ItemData> itemDataList = this.itemDataService.findAllByUbli(ubli);
        List<ItemDto> itemDtoList = new ArrayList<>();
        ItemDto itemDto;
        for (ItemData itemData : itemDataList) {
            itemDto = new ItemDto();
            itemDto.setScacCode(itemData.getScacCode());
            itemDto.setContainerNr(itemData.getContainerNr());
            itemDto.setShipmentType1(itemData.getShipmentType1());
            itemDto.setContainerType(retornoContainerTypeModel(itemData.getContainerType()));
            itemDto.setGrossWeight(String.valueOf(itemData.getGrossWeight()));
            itemDto.setGrossWeightUnit(itemData.getGrossWeightUnit());
            itemDto.setItemBookNo(itemData.getItemBookNo());
            itemDto.setVolume(String.valueOf(itemData.getVolume()));
            itemDto.setVolumeUnit(itemData.getVolumeUnit());
            itemDto.setHsCode(itemData.getHsCode());
            itemDto.setPackageCount(String.valueOf(itemData.getPackageCount()));
            itemDto.setPackageType(itemData.getPackageType());
            itemDto.setUbli13(itemData.getUbli13());
            itemDtoList.add(itemDto);
        }
        return itemDtoList;
    }

}
