package com.insurance.beans;

import com.insurance.entities.Attestation;
import com.insurance.models.AttestationModel;
import javax.faces.bean.*;

import java.io.Serializable;

import java.util.*;


@ManagedBean(name="attestationBean")
@SessionScoped
public class AttestationBean implements Serializable{
	
	private AttestationModel ut = new AttestationModel();
	private Attestation u = new Attestation();
	
	public Attestation getU() {
		return u;
	}

	public void setU(Attestation u) {
		this.u = u;
	}

	public List<Attestation> findAll(){
		return ut.findAll();
	}
	
	public String add() {
		this.ut.create(this.u);
		this.u=new Attestation();
		return "index2";
	}
	public void delete(Attestation u) {
		this.ut.delete(u);
	}
	public String edit(Attestation u)
	{
		this.u=u;
		return "modifierAttestation";
	}
	
	public String edit()
	{
		this.ut.update(this.u);
		return "index2";
	}
	
	
	
}
