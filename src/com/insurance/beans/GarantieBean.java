package com.insurance.beans;

import javax.faces.bean.*;

import com.insurance.models.GarantieModel;
import com.insurance.entities.Garantie;
import java.io.Serializable;

import java.util.*;


@ManagedBean(name="garantieBean")
@SessionScoped
public class GarantieBean implements Serializable{
	
	private GarantieModel ut = new GarantieModel();
	private Garantie u = new Garantie();
	
	public Garantie getU() {
		return u;
	}

	public void setU(Garantie u) {
		this.u = u;
	}

	public List<Garantie> findAll(){
		return ut.findAll();
	}
	
	public String add() {
		this.ut.create(this.u);
		this.u=new Garantie();
		return "index2";
	}
	public void delete(Garantie u) {
		this.ut.delete(u);
	}
	public String edit(Garantie u)
	{
		this.u=u;
		return "modifierGarantie";
	}
	
	public String edit()
	{
		this.ut.update(this.u);
		return "index2";
	}
	
	
	
}
