package com.insurance.beans;

import com.insurance.entities.Attestation;
import com.insurance.entities.Client;
import com.insurance.models.AttestationModel;
import com.insurance.services.AuthentificationService;
import com.insurance.services.SessionBean;
import javax.faces.bean.*;

import java.io.Serializable;

import java.util.*;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@ManagedBean(name = "attestationBean")
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
        List<Attestation> mes_attestations  = new ArrayList<>();
        try {
            Session session = null;
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession sessionBean = SessionBean.getSession();
            System.out.println(sessionBean.getAttribute("username"));

            String SQL_QUERY = "FROM Attestation attest join Contrat c join  Client  where c.codeCli = :codecli";
            Query query = session.createQuery(SQL_QUERY);
            query.setParameter("codecli", sessionBean.getAttribute("codeCli"));
            mes_attestations = query.list();
        } catch (NumberFormatException | HibernateException e) {
            return new ArrayList<>();
        }

        return mes_attestations;
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
