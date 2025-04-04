package com.smart.vm_avoca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dossier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;
    private Long NumeroDossier;
    private String DescriptionDossier;
    private Long CodeDossier;
    private Date DateEnregistrement;
    private Date DateEncaissement;
    private double RéferencePaiement;
    private String NomTribunal;


}
