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
@Table(name = "header_data_text")
public class HeaderDataTextCorreto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String station;
    private String ubli;
    private String scacCode;
    private String creationTimestamp;
    private String blRemarks;
    private String bilateralAgreements;
    private String documentRemarks;
    private String primaryBlMark;

}
