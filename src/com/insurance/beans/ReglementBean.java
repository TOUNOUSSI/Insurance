package com.insurance.beans;

import com.insurance.entities.Reglement;
import com.insurance.entities.Sinistre;
import com.insurance.models.ReglementModel;
import javax.faces.bean.*;

import java.io.Serializable;

import java.util.*;

@ManagedBean(name = "reglementBean")
@SessionScoped
public class ReglementBean implements Serializable {

    private ReglementModel ut = new ReglementModel();
    private Reglement u = new Reglement();
    private Reglement reglement_ToAdd = new Reglement();
    private List<String> sinistres = new ArrayList<>();

    @ManagedProperty(value = "#{sinistreBean}")
    private SinistreBean sinistrebean;

    public SinistreBean getSinistrebean() {
        return sinistrebean;
    }

    public void setSinistrebean(SinistreBean sinistrebean) {
        this.sinistrebean = sinistrebean;
    }

    public Reglement getU() {
        return u;
    }

    public void setU(Reglement u) {
        this.u = u;
    }

    public Reglement getReglement_ToAdd() {
        return reglement_ToAdd;
    }

    public void setReglement_ToAdd(Reglement reglement_ToAdd) {
        this.reglement_ToAdd = reglement_ToAdd;
    }

    
    public void setSinistres(List<String> sinistres) {
        this.sinistres = sinistres;
    }

    public List<Reglement> findAll() {
        return ut.findAll();
    }

    public String add() {
        this.ut.create(this.reglement_ToAdd);
        this.reglement_ToAdd = new Reglement();
        return "index2";
    }

    public void delete(Reglement u) {
        this.ut.delete(u);
    }

    public String edit(Reglement u) {
        try {
            this.u = u;
            this.ut.update(this.u);
        } catch (Exception e) {
            System.out.println("Exception e : " + e.getMessage());
        }

        return "modifierReglement";
    }

    public String edit() {
        this.ut.update(this.u);
        return "index2";
    }

    public Boolean isEmpty() {
        List<Reglement> al = findAll();
        return al != null;
    }

    public List<String> getSinistres() {
        try {
            System.out.println("get sinistres called");
            List<Sinistre> sinstrs = sinistrebean.findAll();
            for (Sinistre s : sinstrs) {
                System.out.println(s.getNumSinistre().toString());
                this.sinistres.add(s.getNumSinistre().toString());
            }
        } catch (Exception e) {
            System.out.println("Exception e |ReglementBean Constructor | caused By : " + e.getMessage());
            e.printStackTrace();
        }
        return this.sinistres;
    }

}
