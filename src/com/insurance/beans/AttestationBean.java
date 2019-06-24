package com.insurance.beans;

import com.insurance.entities.Attestation;
import com.insurance.entities.Client;
import com.insurance.models.AttestationModel;
import com.insurance.services.AuthentificationService;
import javax.faces.bean.*;

import java.io.Serializable;

import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@ManagedBean(name = "attestationBean")
@SessionScoped
public class AttestationBean implements Serializable {

    private AttestationModel ut = new AttestationModel();
    private Attestation u = new Attestation();
    private Attestation editedAttestation = new Attestation();

    public Attestation getU() {
        return u;
    }

    public AttestationModel getUt() {
        return ut;
    }

    public void setUt(AttestationModel ut) {
        this.ut = ut;
    }

    public Attestation getEditedAttestation() {
        return editedAttestation;
    }

    public void setEditedAttestation(Attestation editedAttestation) {
        this.editedAttestation = editedAttestation;
    }

    public void setU(Attestation u) {
        this.u = u;
    }

    public List<Attestation> findMyAttestations() {
        Session session = null;
         Client client = new Client();
        try {

            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            //Group By Clause Example
            AuthentificationService auth = new AuthentificationService();
            System.out.println("Connected Client : "+ auth.getLoggin());
          //  String SQL_QUERY = "select * FROM Client where codeCli = ";
            //Query query = session.createQuery(SQL_QUERY);
            //query.uniqueResult();
        } catch (NumberFormatException | HibernateException e) {
            return new ArrayList<>();
        }

        return null;
    }

    public List<Attestation> findAll() {
        return ut.findAll();
    }

    public String add() {
        this.ut.create(this.u);
        this.u = new Attestation();
        return "attestations";
    }

    public void delete(Attestation u) {
        this.ut.delete(u);
    }

    public String edit(Attestation u) {
        try {
            this.editedAttestation = u;

            System.out.println("Attestation found");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "modifierattestation";
    }

    public String edit() {
        this.ut.update(this.u);
        return "index2";
    }

    public Boolean isEmpty() {
        List<Attestation> al = findAll();
        return al != null;
    }

}
