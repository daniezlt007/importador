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
@Table(name = "container_type")
public class ContainerTypeModel {

    @Id
    @Column(name = "equipment_type_iso_no")
    private String codigo;

    private String remark;

}
