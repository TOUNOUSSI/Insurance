package com.insurance.beans;

import javax.faces.bean.*;

import com.insurance.models.MarqueModel;
import com.insurance.entities.Marque;
import java.io.Serializable;

import java.util.*;


@ManagedBean(name="marqueBean")
@SessionScoped
public class MarqueBean implements Serializable{
	
	private MarqueModel ut = new MarqueModel();
	private Marque u = new Marque();
	
	public Marque getU() {
		return u;
	}

	public void setU(Marque u) {
		this.u = u;
	}

	public List<Marque> findAll(){
		return ut.findAll();
	}
	
	public String add() {
		this.ut.create(this.u);
		this.u=new Marque();
		return "index2";
	}
	public void delete(Marque u) {
		this.ut.delete(u);
	}
	public String edit(Marque u)
	{
		this.u=u;
		return "modifierMarque";
	}
	
	public String edit()
	{
		this.ut.update(this.u);
		return "index2";
	}
	
	
	
}
