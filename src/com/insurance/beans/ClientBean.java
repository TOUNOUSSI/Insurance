package com.insurance.beans;

import javax.faces.bean.*;

import com.insurance.models.ClientModel;
import com.insurance.entities.Client;
import java.io.Serializable;

import java.util.*;

@ManagedBean(name = "clientBean")
@SessionScoped
public class ClientBean implements Serializable {

    private ClientModel ut = new ClientModel();
    private Client u = new Client();

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
        this.u = new Client();
        return "index2";
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
        return al != null;}
}
