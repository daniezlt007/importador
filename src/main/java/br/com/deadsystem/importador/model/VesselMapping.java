package br.com.deadsystem.importador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vessel_mapping")
public class VesselMapping {

    @Id
    @Column(name = "vessel_code")
    private String vesselCode;

    @Column(name = "vessel_name_short")
    private String vesselNameShort;

    @Column(name = "vessel_name_long")
    private String vesselNameLong;

    @Column(name = "imo_number")
    private String imoNumber;

}
