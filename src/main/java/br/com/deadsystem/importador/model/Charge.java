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
    private String itemNr;

    @Column(name = "item_order")
    private String itemOrder;

    @Column(name = "charge_code")
    private String chargeCode;

    @Column(name = "charge_name_short")
    private String chargeNameShort;

    @Column(name = "charge_pay_mode")
    private String chargePayMode;

    @Column(name = "invoice_date")
    private String invoiceDate;

    @Column(name = "invoice_no")
    private String invoiceNo;

    @Column(name = "credit_date")
    private String creditDate;

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

    @Column(name = "calculation_rate")
    private String calculationRate;

    @Column(name = "calculation_factor")
    private String calculationFactor;

    @Column(name = "calculation_base_rule")
    private String calculationBaseRule;

    @Column(name = "calculation_base_unit")
    private String calculationBaseUnit;

    @Column(name = "amount_rd_net")
    private String amountRdNet;

    @Column(name = "amount_rd_incl_vat")
    private String amountRdInclVat;

    @Column(name = "amount_eur")
    private String amountEur;

    @Column(name = "amount_acc")
    private String amountAcc;

    @Column(name = "amount_trf")
    private String amountTrf;

    @Column(name = "amount_inv")
    private String amountInv;

    @Column(name = "currency_rd")
    private String currencyRd;

    @Column(name = "exchange_rate_rd_inv")
    private String exchangeRateRdInv;

    @Column(name = "exchange_rate_rd_trf")
    private String exchangeRateRdTrf;

    @Column(name = "exchange_rate_rd_acc")
    private String exchangeRateRdAcc;

    @Column(name = "boleto_no")
    private String boletoNo;

    @Column(name = "creation_timestamp")
    private String creationTimestamp;

    @Column(name = "place_pay_unlocode")
    private String placePayUnlocode;

    @Column(name = "ubli_13")
    private String ubli13;

    private String version;

}
