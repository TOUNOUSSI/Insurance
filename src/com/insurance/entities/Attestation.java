package com.insurance.entities;
// Generated 20 mai 2019 23:32:14 by Hibernate Tools 5.4.2.Final

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Attestation generated by hbm2java
 */
@Entity
@Table(name = "attestation", catalog = "assurance")
public class Attestation implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_att", unique = true, nullable = false)
    private Integer idAtt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "immat_ou_moto", referencedColumnName = "ref_contrat",nullable = true)
    private Contrat immatOuMoto = new Contrat();

    public Attestation() {
    }

    public Attestation(Contrat immatOuMoto) {
        this.immatOuMoto = immatOuMoto;
    }

    public Attestation(Integer idAtt, Contrat immatOuMoto) {
        this.idAtt = idAtt;
        this.immatOuMoto = immatOuMoto;
    }

   

    public Integer getIdAtt() {
        return this.idAtt;
    }

    public void setIdAtt(Integer idAtt) {
        this.idAtt = idAtt;
    }

    public Contrat getImmatOuMoto() {
        return immatOuMoto;
    }

    public void setImmatOuMoto(Contrat immatOuMoto) {
        this.immatOuMoto = immatOuMoto;
    }

    @Override
    public String toString() {
        return "Attestation{" + "idAtt=" + idAtt + ", immatOuMoto=" + immatOuMoto + '}';
    }

    
   
}
