package br.com.deadsystem.importador.model;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@Table(name = "sfc_data")
public class SfcData {

    @Id
    @Column(name = "sfc_int_no")
    private String sfcIntNo;

    @Column(name = "sfc_name")
    private String sfcName;

    @Column(name = "sfc_name2")
    private String sfcName2;

    @Column(name = "street")
    private String street;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "country_no")
    private String countryNo;

    @Column(name = "state_no")
    private String stateNo;

    @Column(name = "zip_no")
    private String zipNo;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "supplement")
    private String supplement;

    @Column(name = "street_number")
    private String streetNumber;

}
