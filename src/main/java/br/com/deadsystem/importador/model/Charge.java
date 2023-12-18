package br.com.deadsystem.importador.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "charge_data")
public class Charge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ubli;

    @Column(name = "item_nr")
    private Integer itemNr;

    @Column(name = "item_order")
    private Integer itemOrder;

    @Column(name = "charge_code")
    private String chargeCode;

    @Column(name = "charge_name_short")
    private String chargeNameShort;

    @Column(name = "charge_pay_mode")
    private String chargePayMode;

    @Column(name = "invoice_date")
    private LocalDate invoiceDate;

    @Column(name = "invoice_no")
    private String invoiceNo;

    @Column(name = "credit_date")
    private LocalDate creditDate;

    @Column(name = "credit_no")
    private String creditNo;

    @Column(name = "accounting_company")
    private String accountingCompany;

    @Column(name = "agency_code")
    private String agencyCode;

    private String customer;

    @Column(name = "place_pay_code")
    private String placePayCode;

    @Column(name = "ymc_main")
    private String ymcMain;

    @Column(name = "calculation_base_rule")
    private String calculationBaseRule;

    @Column(name = "calculation_base_unit")
    private String calculationBaseUnit;

    @Column(name = "amount_rd_net")
    private Double amountRdNet;

    @Column(name = "amount_rd_incl_vat")
    private Double amountRdInclVat;

    @Column(name = "amount_eur")
    private Double amountEur;

    @Column(name = "amount_acc")
    private Double amountAcc;

    @Column(name = "amount_trf")
    private Double amountTrf;

    @Column(name = "amount_inv")
    private Double amountInv;

    @Column(name = "currency_rd")
    private String currencyRd;

    @Column(name = "exchange_rate_rd_inv")
    private Double exchangeRateRdInv;

    @Column(name = "exchange_rate_rd_trf")
    private Double exchangeRateRdTrf;

    @Column(name = "exchange_rate_rd_acc")
    private Double exchangeRateRdAcc;

    @Column(name = "boleto_no")
    private String boletoNo;

    @Column(name = "creation_timestamp")
    private LocalDateTime creationTimestamp;

    @Column(name = "place_pay_unlocode")
    private String placePayUnlocode;

    @Column(name = "ubli_13")
    private String ubli13;

    private Integer version;

}
