package com.insurance.beans;

import javax.faces.bean.*;

import com.insurance.models.ClientModel;
import com.insurance.entities.Client;
import com.insurance.entities.Personne;
import com.insurance.entities.Societe;
import com.insurance.models.PersonneModel;
import com.insurance.models.SocieteModel;
import java.io.Serializable;

import java.util.*;

@ManagedBean(name = "clientBean")
@SessionScoped
public class ClientBean implements Serializable {

    private ClientModel ut = new ClientModel();
    private PersonneModel pm = new PersonneModel();
    private SocieteModel sm = new SocieteModel();

    private Client u = new Client();

    private Personne personne = new Personne();

    private Societe societe = new Societe();

    private List<String> client_types = new ArrayList<>();
    private String selected_type = "personne";

    public ClientBean() {
        client_types.add("personne");
        client_types.add("societe");
    }

    public List<String> getClient_types() {
        return client_types;
    }

    public void setClient_types(List<String> client_types) {
        this.client_types = client_types;
    }

    public String getSelected_type() {
        return selected_type;
    }

    public void setSelected_type(String selected_type) {
        this.selected_type = selected_type;
    }

    public String triggerType() {
        System.out.println("Changed to : " + this.selected_type);
        return "";
    }

    public ClientModel getUt() {
        return ut;
    }

    public void setUt(ClientModel ut) {
        this.ut = ut;
    }

    public PersonneModel getPm() {
        return pm;
    }

    public void setPm(PersonneModel pm) {
        this.pm = pm;
    }

    public SocieteModel getSm() {
        return sm;
    }

    public void setSm(SocieteModel sm) {
        this.sm = sm;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public Client getU() {
        return u;
    }

    public void setU(Client u) {
        this.u = u;
    }

    public List<Client> findAll() {
        try {
            return ut.findAll();
        } catch (Exception e) {
            System.out.println("Exception here : " + e.getMessage());
        }
        return null;
    }

    public String add() {
        this.ut.create(this.u);
        switch (this.selected_type) {
            case "societe": {
                this.societe.setCodeCli(this.u.getCodeCli());
                this.sm.create(this.societe);
            }
            default: {
                this.personne.setCodeCli(this.u.getCodeCli());
                this.pm.create(this.personne);
            }
        }
        this.u = new Client();
        return "clients";
    }

    public void delete(Client u) {
        this.ut.delete(u);
    }

    public String edit(Client u) {
        this.u = u;
        return "modifierclient";
    }

    public String edit() {
        this.ut.update(this.u);
        return "index2";
    }

    public Boolean isEmpty() {
        List<Client> al = findAll();
        return al != null;
    }
}
