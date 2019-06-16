package com.insurance.entities;
// Generated 20 mai 2019 23:32:14 by Hibernate Tools 5.4.2.Final

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Societe generated by hbm2java
 */
@Entity
@Table(name="societe", catalog="assurance")
@AttributeOverrides({
	
    @AttributeOverride(name="adresseCli", column=@Column(name="adresse_cli")),
    @AttributeOverride(name="datenaisCli", column=@Column(name="datenais_cli")),
    @AttributeOverride(name="emailCli", column=@Column(name="email_cli")),
    @AttributeOverride(name="faxCli", column=@Column(name="fax_cli")),
    @AttributeOverride(name="telCli", column=@Column(name="tel_cli")),
    @AttributeOverride(name="loginCli", column=@Column(name="login_cli")),
    @AttributeOverride(name="mdpCli", column=@Column(name="mdp_cli")),
    @AttributeOverride(name="permis", column=@Column(name="permis")),
    @AttributeOverride(name="datePermis", column=@Column(name="date_permis"))
    
})
public class Societe extends Client implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	private Integer codeCli;
	@Column(name = "raison_social", unique = false, nullable = false, length = 254)
	private String raisonSocial;
	@Column(name = "domaine_d_activite", unique = false, nullable = false, length = 254)
	private String domaineDActivite;
	@Column(name = "sigle", unique = false, nullable = false, length = 254)
	private String sigle;

	public Societe() {
	}

	public Societe(String adresseCli, Date datenaisCli, String emailCli, String faxCli, String telCli, String loginCli,
			String mdpCli, String permis, Date datePermis ,String raisonSocial, String domaineDActivite, String sigle) {
		super(adresseCli,datenaisCli,emailCli,faxCli,telCli,loginCli,mdpCli,permis,datePermis);
		this.raisonSocial = raisonSocial;
		this.domaineDActivite = domaineDActivite;
		this.sigle = sigle;
	}

	public Integer getCodeCli() {
		return this.codeCli;
	}

	public void setCodeCli(Integer codeCli) {
		this.codeCli = codeCli;
	}

	public String getRaisonSocial() {
		return this.raisonSocial;
	}

	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}

	public String getDomaineDActivite() {
		return this.domaineDActivite;
	}

	public void setDomaineDActivite(String domaineDActivite) {
		this.domaineDActivite = domaineDActivite;
	}

	public String getSigle() {
		return this.sigle;
	}

	public void setSigle(String sigle) {
		this.sigle = sigle;
	}

}