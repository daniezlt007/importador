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
@Table(name = "item_data")
public class ItemData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ubli;

    @Column(name = "scac_code")
    private String scacCode;

    @Column(name = "container_nr")
    private String containerNr;

    @Column(name = "item_nr")
    private int itemNr;

    @Column(name = "shipment_type1")
    private String shipmentType1;

    @Column(name = "container_type")
    private String containerType;

    @Column(name = "gross_weight")
    private double grossWeight;

    @Column(name = "gross_weight_unit")
    private String grossWeightUnit;

    @Column(name = "item_book_no")
    private String itemBookNo;

    private double volume;

    @Column(name = "volume_unit")
    private String volumeUnit;

    @Column(name = "hs_code")
    private String hsCode;

    @Column(name = "package_count")
    private int packageCount;

    @Column(name = "package_type")
    private String packageType;

    @Column(name = "ubli_13")
    private String ubli13;

    private String version;

}
