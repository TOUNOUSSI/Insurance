package com.insurance.beans;

import com.insurance.entities.Contrat;
import com.insurance.models.AssureurModel;
import com.insurance.models.VehiculeModel;
import com.insurance.models.ContratModel;
import com.insurance.models.SinistreModel;
import com.insurance.models.PackModel;
import com.insurance.models.ClientModel;
import javax.faces.bean.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@ManagedBean(name = "contratBean")
@SessionScoped
public class ContratBean implements Serializable {

    private ContratModel ut = new ContratModel();
    private AssureurModel assureurModel = new AssureurModel();
    private Contrat u = new Contrat();
    private Contrat editedContrat = new Contrat();
    private String pack_lib;
    private String assureur_lib;
    private String vehicule_lib;
    private String sinistre_lib;
    private List<String> packs;
    private List<String> clients;
    private List<String> assureurs;
    private List<String> sinistres;
    private List<String> vehicules;
    private Integer nombreDeContrat;

    public ContratBean() {
        System.out.println("SIZEEEEEEED :"+ this.ut.findAll().size());
        this.nombreDeContrat = this.ut.findAll().size();
    }

    public ContratModel getUt() {
        return ut;
    }

    public void setUt(ContratModel ut) {
        this.ut = ut;
    }

    public AssureurModel getAssureurModel() {
        return assureurModel;
    }

    public void setAssureurModel(AssureurModel assureurModel) {
        this.assureurModel = assureurModel;
    }

    public Integer getNombreDeContrat() {
        return nombreDeContrat;
    }

    public void setPacks(List<String> packs) {
        this.packs = packs;
    }

    public void setClients(List<String> clients) {
        this.clients = clients;
    }

    public void setAssureurs(List<String> assureurs) {
        this.assureurs = assureurs;
    }

    public void setSinistres(List<String> sinistres) {
        this.sinistres = sinistres;
    }

    public void setVehicules(List<String> vehicules) {
        this.vehicules = vehicules;
    }
    

    public void setNombreDeContrat(Integer nombreDeContrat) {
        this.nombreDeContrat = nombreDeContrat;
    }

    public Contrat getU() {
        return u;
    }

    public void setU(Contrat u) {
        this.u = u;
    }

    public Contrat getEditedContrat() {
        return editedContrat;
    }

    public void setEditedContrat(Contrat editedContrat) {
        this.editedContrat = editedContrat;
    }

    public String getPack_lib() {
        return pack_lib;
    }

    public void setPack_lib(String pack_lib) {
        this.pack_lib = pack_lib;
    }

    public String getAssureur_lib() {
        return assureur_lib;
    }

    public void setAssureur_lib(String assureur_lib) {
        this.assureur_lib = assureur_lib;
    }

    public String getSinistre_lib() {
        return sinistre_lib;
    }

    public void setSinistre_lib(String sinistre_lib) {
        this.sinistre_lib = sinistre_lib;
    }

    public String getVehicule_lib() {
        return vehicule_lib;
    }

    public void setVehicule_lib(String vehicule_lib) {
        this.vehicule_lib = vehicule_lib;
    }

    public List<Contrat> findAll() {
        return ut.findAll();
    }

    public String add() {
        try {
            this.ut.create(this.u);
            this.u = new Contrat();
        } catch (Exception e) {
            System.out.println("Exception ContratBean : " + e.getMessage());
        }
        return "contrats";
    }

    public void delete(Contrat u) {
        this.ut.delete(u);
    }

    public String edit(Contrat u) {
        this.editedContrat = u;
        return "modifiercontrat";
    }

    public String edit() {
        this.ut.update(this.editedContrat);
        return "contrats";
    }

    public Boolean isEmpty() {
        List<Contrat> al = findAll();
        return al != null;
    }

    public List<String> getPacks() {
        PackModel pm = new PackModel();
        packs = new ArrayList<>();
        pm.findAll().forEach((p) -> {
            packs.add(p.getIdPack().toString());
        });
        return packs;
    }

    public List<String> getClients() {
        ClientModel cm = new ClientModel();
        clients = new ArrayList<>();
        cm.findAll().forEach((p) -> {
            clients.add(p.getCodeCli().toString());
        });
        return clients;
    }

    public List<String> getAssureurs() {
        AssureurModel cm = new AssureurModel();
        assureurs = new ArrayList<>();
        cm.findAll().forEach((p) -> {
            assureurs.add(p.getCodeAssr().toString());
        });
        return assureurs;
    }

    public List<String> getSinistres() {
        SinistreModel sm = new SinistreModel();
        sinistres = new ArrayList<>();
        sm.findAll().forEach((p) -> {
            sinistres.add(p.getCodeSinistre().toString());
        });
        return sinistres;
    }

    public List<String> getVehicules() {

        VehiculeModel vm = new VehiculeModel();
        vehicules = new ArrayList<>();
        vm.findAll().forEach((p) -> {
            vehicules.add(p.getImmatOuMoto().toString());
        });
        return vehicules;

    }

    public String[] getContratNumberPerMonth() {
        Session session = null;
        String[] oneYearResult = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
        try {

            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            //Group By Clause Example
            String SQL_QUERY = "select count(*) as Total, dateEffet  FROM Contrat where dateEffet >= :myDate group by dateEffet ";
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

}
