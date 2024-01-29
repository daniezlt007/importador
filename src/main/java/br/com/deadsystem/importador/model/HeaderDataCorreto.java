package br.com.deadsystem.importador.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "header_data")
public class HeaderDataCorreto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ubli;

    @Column(name = "scac_code")
    private String scacCode;

    @Column(name = "creation_date")
    private String creationDate;

    @Column(name = "sailing_date")
    private String sailingDate;

    @Column(name = "issue_date")
    private String issueDate;

    @Column(name = "issuing_office")
    private String issuingOffice;

    private String origin;

    @Column(name = "port_loading")
    private String portOfLoading;

    @Column(name = "port_discharge")
    private String portOfDischarge;

    private String shipper;

    private String consignee;

    @Column(name = "notify_1")
    private String notify1;

    @Column(name = "multi_modal")
    private String multiModal;

    @Column(name = "booking_date")
    private String bookingDate;

    @Column(name = "short_bl_nr")
    private String shortBlNr;

    private String vessel;

    private String voyage;

    private String direction;

    private String version;

    @Column(name = "correction_code")
    private String correctionCode;

    @Column(name = "creation_timestamp")
    private String creationTimeStamp;

    @Column(name = "last_unload_date")
    private String lastUnloadDate;

    @Column(name = "final_manifest_date")
    private String finalManifestDate;

    @Column(name = "issuing_office_place")
    private String issuingOfficePlace;

    @Column(name = "issuing_office_hsdg")
    private String issuingOfficeHsdg;

    @Column(name = "released_at")
    private String releasedAt;

    @Column(name = "released_at_place")
    private String releasedAtPlace;

    @Column(name = "released_hsdg")
    private String releasedHsdg;

    private String service;

    @Column(name = "booking_number")
    private String bookingNumber;

    @Column(name = "ubli_13")
    private String ubli13;

}

