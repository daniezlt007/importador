package br.com.deadsystem.importador.model.dto;

import br.com.deadsystem.importador.model.ChargeCalculoCorreto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RelDto {

    private String scacCode;
    private String issueDate;
    private String shipper;
    private String consignee;
    private String notify;
    private String blNum;
    private String bookingNum;
    private String exportReferences;
    private String freightPayable;
    private String oceanVessel;
    private String voyage;
    private String direction;
    private String portOfLoading;
    private String portOfDischarge;
    private List<ItemDto> itemDtoList;
    private List<ChargeCalculoCorreto> chargeDtoList;

    @Override
    public String toString() {
        return "RelDto{" +
                "scacCode='" + scacCode + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", shipper='" + shipper + '\'' +
                ", consignee='" + consignee + '\'' +
                ", notify='" + notify + '\'' +
                ", blNum='" + blNum + '\'' +
                ", bookingNum='" + bookingNum + '\'' +
                ", exportReferences='" + exportReferences + '\'' +
                ", freightPayable='" + freightPayable + '\'' +
                ", oceanVessel='" + oceanVessel + '\'' +
                ", voyage='" + voyage + '\'' +
                ", direction='" + direction + '\'' +
                ", portOfLoading='" + portOfLoading + '\'' +
                ", portOfDischarge='" + portOfDischarge + '\'' +
                ", itemDtoList=" + itemDtoList +
                ", chargeDtoList=" + chargeDtoList +
                '}';
    }
}
