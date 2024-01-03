package br.com.deadsystem.importador.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "used_sfc")
public class UsedSfc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sfc_int_no")
    private String sfcIntNo;

    @Column(name = "territory_no")
    private String territoryNo;

    @Column(name = "account_current")
    private String accountCurrent;

    @Column(name = "sfc_name")
    private String sfcName;

    @Column(name = "sfc_name2")
    private String sfcName2;

    @Column(name = "update_user_int_no")
    private String updateUserIntNo;

    @Column(name = "update_timestamp")
    private LocalDateTime updateTimestamp;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "im_export")
    private String imExport;

    @Column(name = "cif_fob")
    private String cifFob;

    @Column(name = "reorg_yn")
    private String reorgYn;

    @Column(name = "carrier_merchant")
    private String carrierMerchant;

    @Column(name = "cares_yn")
    private String caresYn;

    @Column(name = "top_shipper_yn")
    private String topShipperYn;

    @Column(name = "branch_id")
    private String branchId;

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

    @Column(name = "fax_no")
    private String faxNo;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "home_page_address")
    private String homepageAddress;

    @Column(name = "tax_no")
    private String taxNo;

    @Column(name = "area_region_lbu")
    private String areaRegionLbu;

    @Column(name = "inttra_code")
    private String inttraCode;

    private String matrix;

    @Column(name = "currency_no")
    private String currencyNo;

    private String remark;

    @Column(name = "accessor_office")
    private String accessorOffice;

    @Column(name = "site_info")
    private String siteInfo;

    @Column(name = "sfc_types")
    private String sfcTypes;

    @Column(name = "city_code")
    private String cityCode;

    private String supplement;

    private String neighborhood;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "po_box")
    private String poBox;

}
