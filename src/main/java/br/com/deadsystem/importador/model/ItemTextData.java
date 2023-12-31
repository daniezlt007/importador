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
@Table(name = "item_text_data")
public class ItemTextData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ubli;

    @Column(name = "scac_code")
    private String scacCode;

    @Column(name = "item_nr")
    private int itemNr;

    @Column(name = "description_goods")
    private String desctiptionOfGoods;

    @Column(name = "ncm_numbers")
    private String ncmNumbers;

}
