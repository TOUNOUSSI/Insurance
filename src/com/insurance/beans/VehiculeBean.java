package com.insurance.beans;

import com.insurance.entities.Vehicule;
import com.insurance.models.VehiculeModel;
import javax.faces.bean.*;

import java.io.Serializable;

import java.util.*;


@ManagedBean(name="vehiculeBean")
@SessionScoped
public class VehiculeBean implements Serializable{
	
	private VehiculeModel ut = new VehiculeModel();
	private Vehicule u = new Vehicule();
	
	public Vehicule getU() {
		return u;
	}

	public void setU(Vehicule u) {
		this.u = u;
	}

	public List<Vehicule> findAll(){
		return ut.findAll();
	}
	
	public String add() {
		this.ut.create(this.u);
		this.u=new Vehicule();
		return "index2";
	}
	public void delete(Vehicule u) {
		this.ut.delete(u);
	}
	public String edit(Vehicule u)
	{
		this.u=u;
		return "modifierVehicule";
	}
	
	public String edit()
	{
		this.ut.update(this.u);
		return "index2";
	}
	
	
	
}
