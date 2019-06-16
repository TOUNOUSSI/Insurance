package com.insurance.beans;

import javax.faces.bean.*;

import com.insurance.models.UsagModel;
import com.insurance.entities.Usag;
import java.io.Serializable;

import java.util.*;


@ManagedBean(name="usagBean")
@SessionScoped
public class UsagBean implements Serializable {
	
	private UsagModel ut = new UsagModel();
	private Usag u = new Usag();
	
	public Usag getU() {
		return u;
	}

	public void setU(Usag u) {
		this.u = u;
	}

	public List<Usag> findAll(){
		return ut.findAll();
	}
	
	public String add() {
		this.ut.create(this.u);
		this.u=new Usag();
		return "index2";
	}
	public void delete(Usag u) {
		this.ut.delete(u);
	}
	public String edit(Usag u)
	{
		this.u=u;
		return "modifierUsag";
	}
	
	public String edit()
	{
		this.ut.update(this.u);
		return "index2";
	}
	
	
	
}
