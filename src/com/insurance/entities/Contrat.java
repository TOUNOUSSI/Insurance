package com.insurance.entities;
// Generated 20 mai 2019 23:32:14 by Hibernate Tools 5.4.2.Final

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Contrat generated by hbm2java
 */
@Entity
@Table(name = "contrat", catalog = "assurance")
public class Contrat implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ref_contrat", unique = true)
    private Integer refContrat;

    @Column(name = "contrat_type")
    private String contratType;

    @Column(name = "date_echeance")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEcheance;

    @Column(name = "date_effet")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEffet;

    @Column(name = "comission")
    private Integer comission;

    @Column(name = "police")
    private String police;

    @Column(name = "taxe")
    private Integer taxe;

    @Column(name = "ristourne")
    private String ristourne;

    @OneToMany(mappedBy = "contrat", targetEntity = Sinistre.class, cascade = CascadeType.ALL)
    private List<Attestation> attestations;

    @OneToMany(mappedBy = "contrat", targetEntity = Sinistre.class, cascade = CascadeType.ALL)
    private List<Sinistre> sinistres;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "code_cli")
    Client num_client;

    @ManyToOne(targetEntity = Assureur.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "code_assr", referencedColumnName = "code_assr", updatable = false, nullable = false, insertable = false)
    Assureur assureur;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pack", referencedColumnName = "id_pack", updatable = false, nullable = false, insertable = false)
    private Pack pack;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "immat_ou_moto", referencedColumnName = "immat_ou_moto", updatable = false, nullable = false, insertable = false,unique = false)
    private Vehicule vehicule;

    public Contrat() {
    }

    public Contrat(Integer refContrat, String contratType, Date dateEcheance, Date dateEffet, Integer comission, String police, Integer taxe, String ristourne, List<Attestation> attestations, List<Sinistre> sinistres, Client num_client, Assureur assureur, Pack pack, Vehicule vehicule) {
        this.refContrat = refContrat;
        this.contratType = contratType;
        this.dateEcheance = dateEcheance;
        this.dateEffet = dateEffet;
        this.comission = comission;
        this.police = police;
        this.taxe = taxe;
        this.ristourne = ristourne;
        this.attestations = attestations;
        this.sinistres = sinistres;
        this.num_client = num_client;
        this.assureur = assureur;
        this.pack = pack;
        this.vehicule = vehicule;
    }

    public Contrat(Integer refContrat, String contratType, Date dateEcheance, Date dateEffet, Integer comission, String police, Integer taxe, String ristourne, Client num_client, Assureur assureur, Pack pack, Vehicule vehicule) {
        this.refContrat = refContrat;
        this.contratType = contratType;
        this.dateEcheance = dateEcheance;
        this.dateEffet = dateEffet;
        this.comission = comission;
        this.police = police;
        this.taxe = taxe;
        this.ristourne = ristourne;
        this.num_client = num_client;
        this.assureur = assureur;
        this.pack = pack;
        this.vehicule = vehicule;
    }

    public Integer getRefContrat() {
        return this.refContrat;
    }

    public void setRefContrat(Integer refContrat) {
        this.refContrat = refContrat;
    }

    public Assureur getAssureur() {
        return assureur;
    }

    public void setAssureur(Assureur assureur) {
        this.assureur = assureur;
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    public List<Attestation> getAttestations() {
        return attestations;
    }

    public void setAttestations(List<Attestation> attestations) {
        this.attestations = attestations;
    }

    public List<Sinistre> getSinistres() {
        return sinistres;
    }

    public void setSinistres(List<Sinistre> sinistres) {
        this.sinistres = sinistres;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Client getNum_client() {
        return num_client;
    }

    public void setNum_client(Client num_client) {
        this.num_client = num_client;
    }

    public Vehicule getImmatOuMoto() {
        return this.vehicule;
    }

    public void setImmatOuMoto(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public String getContratType() {
        return this.contratType;
    }

    public void setContratType(String contratType) {
        this.contratType = contratType;
    }

    public Date getDateEcheance() {
        return this.dateEcheance;
    }

    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public Date getDateEffet() {
        return this.dateEffet;
    }

    public void setDateEffet(Date dateEffet) {
        this.dateEffet = dateEffet;
    }

    public Integer getComission() {
        return this.comission;
    }

    public void setComission(Integer comission) {
        this.comission = comission;
    }

    public String getPolice() {
        return this.police;
    }

    public void setPolice(String police) {
        this.police = police;
    }

    public Integer getTaxe() {
        return this.taxe;
    }

    public void setTaxe(Integer taxe) {
        this.taxe = taxe;
    }

    public String getRistourne() {
        return this.ristourne;
    }

    public void setRistourne(String ristourne) {
        this.ristourne = ristourne;
    }

    
    
}
