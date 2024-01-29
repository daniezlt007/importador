package br.com.deadsystem.importador.service;

import br.com.deadsystem.importador.model.*;
import br.com.deadsystem.importador.model.dto.ItemDto;
import br.com.deadsystem.importador.model.dto.RelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GeradorRelatorioService {

    @Autowired
    private SfcServiceImpl sfcService;

    @Autowired
    private UsedSfcServiceImpl usedSfcService;

    @Autowired
    private HeaderDataServiceImpl headerDataService;

    @Autowired
    private ContainerTypeModelServiceImpl containerTypeModelService;

    @Autowired
    private ItemDataServiceImpl itemDataService;

    @Autowired
    private ShippingServiceImpl shippingService;

    @Autowired
    private VesselMapingService vesselMapingService;

    @Autowired
    private ItemTextDataServiceImpl itemTextDataService;

    @Autowired
    private VolumeMppingService volumeMppingService;

    @Autowired
    private ChargeCalculoCorretoServiceImpl chargeCalculoCorretoService;

    @Autowired
    private CurrencyMappingServiceImpl currencyMappingService;


    public RelDto retornoRel(String ubli){
        HeaderDataCorreto headerDataCorreto = this.headerDataService.findByUbli(ubli);
        RelDto relDto = new RelDto();
        relDto.setScacCode(headerDataCorreto != null ? headerDataCorreto.getScacCode() : "");
        relDto.setIssueDate(headerDataCorreto != null ? headerDataCorreto.getIssueDate() : "");
        relDto.setShipper(headerDataCorreto != null ? retornoCampoShipper(headerDataCorreto.getShipper()) : "");
        relDto.setConsignee(headerDataCorreto != null ? retornoCampoShipper(headerDataCorreto.getConsignee()) : "");
        relDto.setNotify(headerDataCorreto != null ? retornoCampoShipper(headerDataCorreto.getNotify1()) : "");
        relDto.setBlNum(headerDataCorreto != null ? headerDataCorreto.getShortBlNr() : "");
        relDto.setBookingNum(headerDataCorreto != null ? headerDataCorreto.getBookingNumber() : "");

        relDto.setVoyage(headerDataCorreto != null ? headerDataCorreto.getVoyage() : "");
        relDto.setDirection(headerDataCorreto != null ? headerDataCorreto.getDirection() : "");
        relDto.setOceanVessel(headerDataCorreto != null ? retornVesselMapingNameLong(headerDataCorreto.getVessel()) : "");
        relDto.setPortOfLoading(headerDataCorreto != null ? findByUnlocode(headerDataCorreto.getPortOfLoading()) : "");
        relDto.setPortOfDischarge(headerDataCorreto != null ? findByUnlocode(headerDataCorreto.getPortOfDischarge()) : "");
        relDto.setItemDtoList(headerDataCorreto != null ? buscarTodosItens(headerDataCorreto.getUbli()) : null);
        relDto.setChargeDtoList(findAllByUbli13(headerDataCorreto.getUbli13()));
        return relDto;
    }

    public List<RelDto> retornoRel(){
        List<HeaderDataCorreto> headerDataCorretoList = this.headerDataService.findAll();
        RelDto relDto;
        List<RelDto> relDtoList = new ArrayList<>();
        for (HeaderDataCorreto headerDataCorreto : headerDataCorretoList) {
            System.out.println("Linha header: " + headerDataCorreto.getId());
            relDto = new RelDto();
            relDto.setScacCode(headerDataCorreto != null ? headerDataCorreto.getScacCode() : "");
            relDto.setIssueDate(headerDataCorreto != null ? headerDataCorreto.getIssueDate() : "");
            relDto.setShipper(headerDataCorreto != null ? retornoCampoShipper(headerDataCorreto.getShipper()) : "");
            relDto.setConsignee(headerDataCorreto != null ? retornoCampoShipper(headerDataCorreto.getConsignee()) : "");
            relDto.setNotify(headerDataCorreto != null ? retornoCampoShipper(headerDataCorreto.getNotify1()) : "");
            relDto.setBlNum(headerDataCorreto != null ? headerDataCorreto.getShortBlNr() : "");
            relDto.setBookingNum(headerDataCorreto != null ? headerDataCorreto.getBookingNumber() : "");

            relDto.setVoyage(headerDataCorreto != null ? headerDataCorreto.getVoyage() : "");
            relDto.setDirection(headerDataCorreto != null ? headerDataCorreto.getDirection() : "");
            relDto.setOceanVessel(headerDataCorreto != null ? retornVesselMapingNameLong(headerDataCorreto.getVessel()) : "");
            relDto.setPortOfLoading(headerDataCorreto != null ? findByUnlocode(headerDataCorreto.getPortOfLoading()) : "");
            relDto.setPortOfDischarge(headerDataCorreto != null ? findByUnlocode(headerDataCorreto.getPortOfDischarge()) : "");
            relDto.setItemDtoList(headerDataCorreto != null ? buscarTodosItens(headerDataCorreto.getUbli()) : null);
            relDto.setChargeDtoList(findAllByUbli13(headerDataCorreto.getUbli13()));
            relDtoList.add(relDto);
        }
        return relDtoList;
    }

    private String retornoCampoShipper(String sfc){
        if(sfc != null){
            UsedSfcCorreto usedSfcCorreto = this.usedSfcService.findBySfcIdNo(sfc);
            if(usedSfcCorreto != null){
                StringBuilder builder = new StringBuilder();
                builder.append((usedSfcCorreto.getSfcName() != null ? usedSfcCorreto.getSfcName() : "") + " ");
                builder.append((usedSfcCorreto.getSfcName2() != null ? usedSfcCorreto.getSfcName2() : "") + " ");
                builder.append((usedSfcCorreto.getStreet() != null ? usedSfcCorreto.getStreet() : "") + " ");
                builder.append((usedSfcCorreto.getCityName() != null ? usedSfcCorreto.getCityName() : "") + " ");
                builder.append((usedSfcCorreto.getCountryNo() != null ? usedSfcCorreto.getCountryNo() : "") + " ");
                builder.append((usedSfcCorreto.getStateNo() != null ? usedSfcCorreto.getStateNo() : "") + " ");
                builder.append((usedSfcCorreto.getZipNo() != null ? usedSfcCorreto.getZipNo() : "") + " ");
                builder.append((usedSfcCorreto.getPhoneNo() != null ? usedSfcCorreto.getPhoneNo() : "") + " ");
                builder.append((usedSfcCorreto.getSupplement() != null ? usedSfcCorreto.getSupplement() : "") + " ");
                builder.append((usedSfcCorreto.getStreetNumber() != null ? usedSfcCorreto.getStreetNumber() : "") + " ");

                return builder.toString();
            } else {
                return "";
            }
        } else {
            return "";
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
        List<ItemDataCorreto> itemDataCorretoList = this.itemDataService.findAllByUbli(ubli);
        List<ItemDto> itemDtoList = new ArrayList<>();
        ItemDto itemDto;
        for (ItemDataCorreto itemDataCorreto : itemDataCorretoList) {
            itemDto = new ItemDto();
            itemDto.setScacCode(itemDataCorreto.getScacCode());
            itemDto.setContainerNr(itemDataCorreto.getContainerNr());
            itemDto.setShipmentType1(itemDataCorreto.getShipmentType1());
            itemDto.setContainerType(itemDataCorreto.getContainerType());
            itemDto.setGrossWeight(String.valueOf(itemDataCorreto.getGrossWeight()));
            itemDto.setGrossWeightUnit(retornoFindVolumeMapping(itemDataCorreto.getGrossWeightUnit()));
            itemDto.setItemBookNo(itemDataCorreto.getItemBookNo());
            itemDto.setVolume(String.valueOf(itemDataCorreto.getVolume()));
            itemDto.setVolumeUnit(retornoFindVolumeMapping(itemDataCorreto.getVolumeUnit()));
            itemDto.setHsCode(itemDataCorreto.getHsCode());
            itemDto.setPackageCount(String.valueOf(itemDataCorreto.getPackageCount()));
            itemDto.setPackageType(itemDataCorreto.getPackageType());
            itemDto.setUbli13(itemDataCorreto.getUbli13());
            itemDto.setDescriptionOfGoods(retornDescriptionGoods(ubli));
            itemDtoList.add(itemDto);
        }
        return itemDtoList;
    }

    public String findByUnlocode(String unlocode){
        return this.shippingService.findByUnlocode(unlocode).getName();
    }

    public String retornVesselMapingNameLong(String id) {
        VesselMapping vessel = this.vesselMapingService.findById(id);
        if (vessel != null && vessel.getVesselNameLong() != null) {
            return vessel.getVesselNameLong();
        } else {
            return vessel != null && vessel.getVesselNameShort() != null ? vessel.getVesselNameShort() : "";
        }

    }

    public String retornDescriptionGoods(String ubli){
        String msg = this.itemTextDataService.findByUbli(ubli);
        return msg;
    }

    public String retornoFindVolumeMapping(String code){
        VolumeMapping byCode = this.volumeMppingService.findByCode(code);
        if(code.equals("01") || code.equals("04")){
            return "KGS";
        } else if(code.equals("02")) {
            return "MET";
        } else if (code.equals("03")){
            return "POU";
        } else if (code.equals("05")){
            return "CBM";
        } else if (code.equals("06")){
            return "VAL";
        } else if (code.equals("07")){
            return "CBF";
        } else if (code.equals("08")){
            return "BOF";
        } else {
            return byCode.getCode() != null ? byCode.getCode() : "";
        }
    }

    public List<ChargeCalculoCorreto> findAllByUbli13(String ubli13){
        List<ChargeCalculoCorreto> chargeCalculoCorretoList = this.chargeCalculoCorretoService.findAllByUbli13(ubli13);
        List<ChargeCalculoCorreto> listaRetorno = new ArrayList<>();
        ChargeCalculoCorreto chargeCalculoCorretoNew;
        for (ChargeCalculoCorreto chargeCalculoCorreto : chargeCalculoCorretoList) {
            System.out.println("Linha: " + chargeCalculoCorreto.getId());
            chargeCalculoCorretoNew = new ChargeCalculoCorreto();
            chargeCalculoCorretoNew.setId(chargeCalculoCorreto.getId());
            chargeCalculoCorretoNew.setCalculationBaseRule(chargeCalculoCorreto.getCalculationBaseRule());
            chargeCalculoCorretoNew.setCalculationBaseUnit(chargeCalculoCorreto.getCalculationBaseUnit());
            chargeCalculoCorretoNew.setAmountRdNet(chargeCalculoCorreto.getAmountRdNet());
            chargeCalculoCorretoNew.setAmountRdInclVat(chargeCalculoCorreto.getAmountRdInclVat());
            chargeCalculoCorretoNew.setAmountEur(chargeCalculoCorreto.getAmountEur());
            chargeCalculoCorretoNew.setAmountAcc(chargeCalculoCorreto.getAmountAcc());
            chargeCalculoCorretoNew.setAmountTrf(chargeCalculoCorreto.getAmountTrf());
            chargeCalculoCorretoNew.setAmountInv(chargeCalculoCorreto.getAmountInv());
            chargeCalculoCorretoNew.setAmountInv(chargeCalculoCorreto.getAmountInv());
            chargeCalculoCorretoNew.setCurrencyRd(findByCurrencyNo(chargeCalculoCorreto.getCurrencyRd()));
            listaRetorno.add(chargeCalculoCorretoNew);
        }
        return listaRetorno;
    }

    public String findByCurrencyNo(String id){
        CurrencyMapping currencyMapping = this.currencyMappingService.findById(Integer.valueOf(id));
        return currencyMapping.getCurrencyNo() != null ? currencyMapping.getCurrencyNo() : "";
    }


}
