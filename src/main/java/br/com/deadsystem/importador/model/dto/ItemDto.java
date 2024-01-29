    package br.com.deadsystem.importador.model.dto;

import br.com.deadsystem.importador.model.ItemDataCorreto;
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

    private String descriptionOfGoods;

    public ItemDto(ItemDataCorreto itemDataCorreto){
        if(itemDataCorreto != null){
            this.scacCode = itemDataCorreto.getScacCode();
            this.containerNr = itemDataCorreto.getContainerNr();
            this.shipmentType1 = itemDataCorreto.getShipmentType1();
            this.containerType = itemDataCorreto.getContainerType();
            this.grossWeight = String.valueOf(itemDataCorreto.getGrossWeight());
            this.grossWeightUnit = itemDataCorreto.getGrossWeightUnit();
            this.itemBookNo = itemDataCorreto.getItemBookNo();
            this.volume = String.valueOf(itemDataCorreto.getVolume());
            this.volumeUnit = itemDataCorreto.getVolumeUnit();
            this.hsCode = itemDataCorreto.getHsCode();
            this.packageCount = String.valueOf(itemDataCorreto.getPackageCount());
            this.packageType = itemDataCorreto.getPackageType();
            this.Ubli13 = itemDataCorreto.getUbli13();
        }
    }

    public static List<ItemDto> converter(List<ItemDataCorreto> itemDataCorretoList) {
        return itemDataCorretoList.stream().map(ItemDto::new).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "scacCode='" + scacCode + '\'' +
                ", containerNr='" + containerNr + '\'' +
                ", shipmentType1='" + shipmentType1 + '\'' +
                ", containerType='" + containerType + '\'' +
                ", grossWeight='" + grossWeight + '\'' +
                ", grossWeightUnit='" + grossWeightUnit + '\'' +
                ", itemBookNo='" + itemBookNo + '\'' +
                ", volume='" + volume + '\'' +
                ", volumeUnit='" + volumeUnit + '\'' +
                ", hsCode='" + hsCode + '\'' +
                ", packageCount='" + packageCount + '\'' +
                ", packageType='" + packageType + '\'' +
                ", Ubli13='" + Ubli13 + '\'' +
                '}';
    }
}
