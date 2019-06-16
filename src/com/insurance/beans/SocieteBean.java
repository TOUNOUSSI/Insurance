package com.insurance.beans;

import javax.faces.bean.*;

import com.insurance.models.SocieteModel;
import com.insurance.entities.Societe;

import java.util.*;


@ManagedBean(name="societeBean")
@SessionScoped
public class SocieteBean {
	
	private SocieteModel ut = new SocieteModel();
	private Societe u = new Societe();
	
	public Societe getU() {
		return u;
	}

	public void setU(Societe u) {
		this.u = u;
	}

	public List<Societe> findAll(){
		return ut.findAll();
	}
	
	public String add() {
		this.ut.create(this.u);
		this.u=new Societe();
		return "index2";
	}
	public void delete(Societe u) {
		this.ut.delete(u);
	}
	public String edit(Societe u)
	{
		this.u=u;
		return "modifierSociete";
	}
	
	public String edit()
	{
		this.ut.update(this.u);
		return "index2";
	}
	
	
	
}
