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
@Table(name = "currency_mapping")
public class CurrencyMapping {

    @Id
    private Long id;

    @Column(name = "currency_no")
    private String currencyNo;

    @Column(name = "currency_name")
    private String currencyName;


}
