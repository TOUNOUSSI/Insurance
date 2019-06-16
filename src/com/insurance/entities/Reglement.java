package com.insurance.entities;
// Generated 20 mai 2019 23:32:14 by Hibernate Tools 5.4.2.Final

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import javax.persistence.Table;

/**
 * Reglement generated by hbm2java
 */
@Entity
@Table(name = "reglement", catalog = "assurance")
public class Reglement implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "code_regl", unique = true, nullable = false)
    private Integer codeRegl;

    @Column(name = "date_regl")
    private String dateRegl;

    @Column(name = "frais_expert")
    private Integer fraisExpert;

    @Column(name = "franchise")
    private Integer franchise;

    @Column(name = "indemmite")
    private Integer indemmite;

    @Column(name = "mode_regl")
    private String modeRegl;

    @Column(name = "montant_regl")
    private String montantRegl;

    @Column(name = "observation")
    private String observation;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "code_sinistre", updatable = true,nullable = true,insertable = true)
    private Sinistre sinistre;

    public Reglement() {
        
    }


    public Reglement(Sinistre sinistre, String dateRegl, Integer fraisExpert, Integer franchise, Integer indemmite, String modeRegl, String montantRegl, String observation) {
        this.sinistre = sinistre;
        this.dateRegl = dateRegl;
        this.fraisExpert = fraisExpert;
        this.franchise = franchise;
        this.indemmite = indemmite;
        this.modeRegl = modeRegl;
        this.montantRegl = montantRegl;
        this.observation = observation;
    }

    public Integer getCodeRegl() {
        return this.codeRegl;
    }

    public void setCodeRegl(Integer codeRegl) {
        this.codeRegl = codeRegl;
    }

    public String getStringRegl() {
        return this.dateRegl;
    }

    public void setStringRegl(String dateRegl) {
        this.dateRegl = dateRegl;
    }

    public Integer getFraisExpert() {
        return this.fraisExpert;
    }

    public void setFraisExpert(Integer fraisExpert) {
        this.fraisExpert = fraisExpert;
    }

    public Integer getFranchise() {
        return this.franchise;
    }

    public void setFranchise(Integer franchise) {
        this.franchise = franchise;
    }

    public Integer getIndemmite() {
        return this.indemmite;
    }

    public void setIndemmite(Integer indemmite) {
        this.indemmite = indemmite;
    }

    public String getModeRegl() {
        return this.modeRegl;
    }

    public void setModeRegl(String modeRegl) {
        this.modeRegl = modeRegl;
    }

    public String getMontantRegl() {
        return this.montantRegl;
    }

    public void setMontantRegl(String montantRegl) {
        this.montantRegl = montantRegl;
    }

    public String getObservation() {
        return this.observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Sinistre getSinistre() {
        return sinistre;
    }

    public void setSinistre(Sinistre sinistre) {
        this.sinistre = sinistre;
    }

    public String getDateRegl() {
        return dateRegl;
    }

    public void setDateRegl(String dateRegl) {
        this.dateRegl = dateRegl;
    }
    
    

}