package com.insurance.beans;

import com.insurance.entities.Assureur;
import com.insurance.models.AssureurModel;
import javax.faces.bean.*;


import java.util.*;

@ManagedBean(name="assureurBean")
@SessionScoped
public class AssureurBean {
	
	private AssureurModel ut = new AssureurModel();
	private Assureur u = new Assureur();
	
	public Assureur getU() {
		return u;
	}

	public void setU(Assureur u) {
		this.u = u;
	}

	public List<Assureur> findAll(){
		return ut.findAll();
	}
	
	public String add() {
		this.ut.create(this.u);
		this.u=new Assureur();
		return "index2";
	}
	public void delete(Assureur u) {
		this.ut.delete(u);
	}
	public String edit(Assureur u)
	{
		this.u=u;
		return "modifierAssureur";
	}
	
	public String edit()
	{
		this.ut.update(this.u);
		return "index2";
	}
	
	
	
}
