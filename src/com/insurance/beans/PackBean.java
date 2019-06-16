package com.insurance.beans;

import javax.faces.bean.*;

import com.insurance.models.PackModel;
import com.insurance.entities.Pack;
import java.io.Serializable;

import java.util.*;


@ManagedBean(name="packBean")
@SessionScoped
public class PackBean implements Serializable{
	
	private PackModel ut = new PackModel();
	private Pack u = new Pack();
	
	public Pack getU() {
		return u;
	}

	public void setU(Pack u) {
		this.u = u;
	}

	public List<Pack> findAll(){
		return ut.findAll();
	}
	
	public String add() {
		this.ut.create(this.u);
		this.u=new Pack();
		return "index2";
	}
	public void delete(Pack u) {
		this.ut.delete(u);
	}
	public String edit(Pack u)
	{
		this.u=u;
		return "modifierPack";
	}
	
	public String edit()
	{
		this.ut.update(this.u);
		return "index2";
	}
	
	
	
}
