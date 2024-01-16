package br.com.deadsystem.importador.model.dto;

import br.com.deadsystem.importador.model.ItemData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    private String scacCode;
    private String containerNr;
    private String shipmentType1;
    private String containerType;
    private String grossWeight;
    private String grossWeightUnit;
    private String itemBookNo;
    private String volume;
    private String volumeUnit;
    private String hsCode;
    private String packageCount;
    private String packageType;
    private String Ubli13;

    public ItemDto(ItemData itemData){
        if(itemData != null){
            this.scacCode = itemData.getScacCode();
            this.containerNr = itemData.getContainerNr();
            this.shipmentType1 = itemData.getShipmentType1();
            this.containerType = itemData.getContainerType();
            this.grossWeight = String.valueOf(itemData.getGrossWeight());
            this.grossWeightUnit = itemData.getGrossWeightUnit();
            this.itemBookNo = itemData.getItemBookNo();
            this.volume = String.valueOf(itemData.getVolume());
            this.volumeUnit = itemData.getVolumeUnit();
            this.hsCode = itemData.getHsCode();
            this.packageCount = String.valueOf(itemData.getPackageCount());
            this.packageType = itemData.getPackageType();
            this.Ubli13 = itemData.getUbli13();
        }
    }

    public static List<ItemDto> converter(List<ItemData> itemDataList) {
        return itemDataList.stream().map(ItemDto::new).collect(Collectors.toList());
    }

}
