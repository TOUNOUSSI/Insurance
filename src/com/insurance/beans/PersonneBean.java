package com.insurance.beans;

import javax.faces.bean.*;

import com.insurance.models.PersonneModel;
import com.insurance.entities.Personne;
import java.io.Serializable;

import java.util.*;


@ManagedBean(name="personneBean")
@SessionScoped
public class PersonneBean implements Serializable{
	
	private PersonneModel ut = new PersonneModel();
	private Personne u = new Personne();
	
	public Personne getU() {
		return u;
	}

	public void setU(Personne u) {
		this.u = u;
	}

	public List<Personne> findAll(){
		return ut.findAll();
	}
	
	public String add() {
		this.ut.create(this.u);
		this.u=new Personne();
		return "index2";
	}
	public void delete(Personne u) {
		this.ut.delete(u);
	}
	public String edit(Personne u)
	{
		this.u=u;
		return "modifierPersonne";
	}
	
	public String edit()
	{
		this.ut.update(this.u);
		return "index2";
	}
	
	
	
}
