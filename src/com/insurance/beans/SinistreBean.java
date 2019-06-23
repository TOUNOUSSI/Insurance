package com.insurance.beans;

import com.insurance.entities.Sinistre;
import com.insurance.hibernate.util.HibernateUtil;
import com.insurance.models.ReglementModel;
import com.insurance.models.ContratModel;
import com.insurance.models.SinistreModel;
import javax.faces.bean.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
    private Integer nombreDeSinistre;

    public SinistreBean() {
        this.nombreDeSinistre = this.ut.findAll().size();
    }

    public SinistreModel getUt() {
        return ut;
    }

    public void setUt(SinistreModel ut) {
        this.ut = ut;
    }

    public Integer getNombreDeSinistre() {
        return nombreDeSinistre;
    }

    public void setNombreDeSinistre(Integer nombreDeSinistre) {
        this.nombreDeSinistre = nombreDeSinistre;
    }

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

    public String[] getSinistreNumberPerMonth() {
        Session session = null;
        String[] oneYearResult = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        try {

            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            //Group By Clause Example
            String SQL_QUERY = "select count(*) as Total, dateSinistre  FROM Sinistre where dateSinistre >= :myDate group by dateSinistre";
            Query query = session.createQuery(SQL_QUERY);
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH, -12);
            Date date = cal.getTime();
            query.setParameter("myDate", date);
            for (Iterator it = query.iterate(); it.hasNext();) {
                Object[] row = (Object[]) it.next();
                oneYearResult[Integer.parseInt(row[1].toString().substring(5, 7)) - 1] = row[0].toString();

            }
        } catch (NumberFormatException | HibernateException e) {
            return new String[0];
        }
        return oneYearResult;

    }

    public List<Object[]> getSinistreNumbersPerStats() {
        Session session = null;
        List<Object[]> sinistresPersStatsDATA = new ArrayList<>();
        try {

            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            //Group By Clause Example
            String SQL_QUERY = "select count(*) as Total, etatAvance  FROM Sinistre group by etatAvance";
            Query query = session.createQuery(SQL_QUERY);
            
            for (Iterator it = query.iterate(); it.hasNext();) {
                Object[] row = (Object[]) it.next();
                sinistresPersStatsDATA.add(row);
            }
        } catch (NumberFormatException | HibernateException e) {
            return new ArrayList<>();
        }
        return sinistresPersStatsDATA;

    }

}
