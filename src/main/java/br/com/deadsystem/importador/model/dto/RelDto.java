package br.com.deadsystem.importador.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String portOfLoading;
    private String portOfDischarge;

}
