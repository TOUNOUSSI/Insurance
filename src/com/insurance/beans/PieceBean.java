package com.insurance.beans;

import com.insurance.entities.Piece;
import com.insurance.models.PieceModel;
import javax.faces.bean.*;

import java.io.Serializable;

import java.util.*;


@ManagedBean(name="pieceBean")
@SessionScoped
public class PieceBean implements Serializable {
	
	private PieceModel ut = new PieceModel();
	private Piece u = new Piece();
	
	public Piece getU() {
		return u;
	}

	public void setU(Piece u) {
		this.u = u;
	}

	public List<Piece> findAll(){
		return ut.findAll();
	}
	
	public String add() {
		this.ut.create(this.u);
		this.u=new Piece();
		return "index2";
	}
	public void delete(Piece u) {
		this.ut.delete(u);
	}
	public String edit(Piece u)
	{
		this.u=u;
		return "modifierPiece";
	}
	
	public String edit()
	{
		this.ut.update(this.u);
		return "index2";
	}
	
	
	
}
