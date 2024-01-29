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
@Table(name = "places_mapping")
public class ShippingCorreto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "place_no_hsdg")
    private String placeNoHSDG;

    @Column(name = "place_no_columbus")
    private String placeNoColumbus;

    @Column(name = "unlocode")
    private String unlocode;

    @Column(name = "name")
    private String name;

}
