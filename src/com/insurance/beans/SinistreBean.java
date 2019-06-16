package com.insurance.beans;

import com.insurance.entities.Sinistre;
import com.insurance.models.ReglementModel;
import com.insurance.models.ContratModel;
import com.insurance.models.SinistreModel;
import javax.faces.bean.*;

import java.io.Serializable;

import java.util.*;

@ManagedBean(name = "sinistreBean")
@SessionScoped
public class SinistreBean implements Serializable {

    private SinistreModel ut = new SinistreModel();
    private Sinistre u = new Sinistre();
    private Sinistre editedSinistre = new Sinistre();

    private String contrat_lib;
    private String reglement_lib;
    private List<String> contrats;
    private List<String> reglements;

    public Sinistre getU() {
        return u;
    }

    public void setU(Sinistre u) {
        this.u = u;
    }

    public Sinistre getEditedSinistre() {
        return editedSinistre;
    }

    public void setEditedSinistre(Sinistre editedSinistre) {
        this.editedSinistre = editedSinistre;
    }

    public String getContrat_lib() {
        return contrat_lib;
    }

    public void setContrat_lib(String contrat_lib) {
        this.contrat_lib = contrat_lib;
    }

    public String getReglement_lib() {
        return reglement_lib;
    }

    public void setReglement_lib(String reglement_lib) {
        this.reglement_lib = reglement_lib;
    }
    
    

    public List<Sinistre> findAll() {
        try {
            System.out.println("Liste des sinistres");
            List<Sinistre> sinstrs = ut.findAll();
            for (Sinistre s : sinstrs) {
                System.out.println(s.toString());

            }
            return ut.findAll();
        } catch (Exception e) {
            System.out.println("Exception inside SinistreBean | findAll | causedBy:  " + e.getMessage());
            return null;
        }

    }

    public String add() {
        this.ut.create(this.u);
        this.u = new Sinistre();
        return "index2";
    }

    public void delete(Sinistre u) {
        this.ut.delete(u);
    }

    public String edit(Sinistre u) {
        this.editedSinistre = u;
        return "modifiersinistre";
    }

    public String edit() {
        this.ut.update(this.editedSinistre);
        return "sinistres";
    }

    public Boolean isEmpty() {
        List<Sinistre> al = null;
        try {
            al = findAll();
        } catch (Exception e) {
            return false;
        }
        return al != null;
    }
    
     public List<String> getReglements() {
        ReglementModel rm = new ReglementModel();
        reglements = new ArrayList<>();
        rm.findAll().forEach((p) -> {
            reglements.add(p.getCodeRegl().toString());
        });
        return reglements;
    }
     
       public List<String> getContrats() {
        ContratModel cm = new ContratModel();
        contrats = new ArrayList<>();
        cm.findAll().forEach((p) -> {
            contrats.add(p.getRefContrat().toString());
        });
        return contrats;
    }

}
