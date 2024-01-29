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
public class ItemTextDataCorreto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ubli;

    @Column(name = "scac_code")
    private String scacCode;

    @Column(name = "item_nr")
    private String itemNr;

    @Column(name = "description_goods")
    private String descriptionOfGoods;

    @Column(name = "ncm_numbers")
    private String ncmNumbers;

}
