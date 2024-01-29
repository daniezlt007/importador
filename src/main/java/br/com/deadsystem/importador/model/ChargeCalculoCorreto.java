package br.com.deadsystem.importador.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "charge_calculo")
public class ChargeCalculoCorreto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "calculation_base_rule")
    private String calculationBaseRule;

    @Column(name = "calculation_base_unit")
    private String calculationBaseUnit;

    @Column(name = "amount_rd_net")
    private double amountRdNet;

    @Column(name = "amount_rd_incl_vat")
    private double amountRdInclVat;

    @Column(name = "amount_eur")
    private double amountEur;

    @Column(name = "amount_acc")
    private double amountAcc;

    @Column(name = "amount_trf")
    private double amountTrf;

    @Column(name = "amount_inv")
    private double amountInv;

    @Column(name = "currency_rd")
    private String currencyRd;

    @Column(name = "exchange_rate_rd_inv")
    private double exchangeRateRdInv;

    @Column(name = "exchange_rate_rd_trf")
    private double exchangeRateRdTrf;

    @Column(name = "exchange_rate_rd_acc")
    private double exchangeRateRdAcc;

    @Column(name = "boleto_no")
    private String boletoNo;

    @Column(name = "creation_timestamp")
    private String creationTimestamp;

    @Column(name = "place_pay_unlocode")
    private String placePayUnlocode;

    @Column(name = "ubli13")
    private String ubli13;

    @Column(name = "version")
    private String version;

    @Override
    public String toString() {
        return "ChargeCalculoCorreto{" +
                "id=" + id +
                ", calculationBaseRule='" + calculationBaseRule + '\'' +
                ", calculationBaseUnit='" + calculationBaseUnit + '\'' +
                ", amountRdNet=" + amountRdNet +
                ", amountRdInclVat=" + amountRdInclVat +
                ", amountEur=" + amountEur +
                ", amountAcc=" + amountAcc +
                ", amountTrf=" + amountTrf +
                ", amountInv=" + amountInv +
                ", currencyRd=" + currencyRd +
                ", exchangeRateRdInv=" + exchangeRateRdInv +
                ", exchangeRateRdTrf=" + exchangeRateRdTrf +
                ", exchangeRateRdAcc=" + exchangeRateRdAcc +
                ", boletoNo='" + boletoNo + '\'' +
                ", creationTimestamp='" + creationTimestamp + '\'' +
                ", placePayUnlocode='" + placePayUnlocode + '\'' +
                ", ubli13='" + ubli13 + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
