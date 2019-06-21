package com.insurance.beans;

import com.insurance.entities.Utilisateur;
import com.insurance.models.UtilisateurModel;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "utilisateur")
@SessionScoped
/**
 * @author TOUNOUSSI Youssef
 */
public class UtilisateurBean implements Serializable {

    private UtilisateurModel ut = new UtilisateurModel();
	private Utilisateur u = new Utilisateur();
	
    /**
     * Default constructor
     */
    public UtilisateurBean() {
    }

    public UtilisateurModel getUt() {
        return ut;
    }

    public void setUt(UtilisateurModel ut) {
        this.ut = ut;
    }

    public Utilisateur getU() {
        return u;
    }

    public void setU(Utilisateur u) {
        this.u = u;
    }

    
   public List<Utilisateur> findAll(){
		return ut.findAll();
	}
	
	public String add() {
		this.ut.create(this.u);
		this.u=new Utilisateur();
		return "index2";
	}
	public void delete(Utilisateur u) {
		this.ut.delete(u);
	}
	public String edit(Utilisateur u)
	{
		this.u=u;
		return "modifierUtilisateur";
	}
	
	public String edit()
	{
		this.ut.update(this.u);
		return "index2";
	}
}
