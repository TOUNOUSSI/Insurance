/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.insurance.services;

import com.insurance.entities.Client;
import com.insurance.entities.Utilisateur;
import com.insurance.hibernate.util.HibernateUtil;
import com.insurance.models.UtilisateurModel;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import org.hibernate.service.spi.InjectService;
import org.primefaces.push.annotation.Singleton;

@ManagedBean(name = "AuthentificationService")
public class AuthentificationService implements Serializable {

    private UtilisateurModel ut = new UtilisateurModel();
    private static Utilisateur authenticatedUser = new Utilisateur();

    private Client client = null;

    @ManagedProperty(value = "#{param.login}")
    private String login;

    @ManagedProperty(value = "#{param.password}")
    private String password;

    @ManagedProperty(value = "#{param.loggin}")
    private String loggin;

    @ManagedProperty(value = "#{param.role}")
    private String role;

    @ManagedProperty(value = "#{sessionScope.sessionBean}")
    SessionBean sessionBean = new SessionBean();

    public String getLoggin() {
        return loggin;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
    
    

    public void setLoggin(String loggin) {
        this.loggin = loggin;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public String singin() {

        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = SessionBean.getSession();

            if (session != null) {
                login = request.getParameter("Lgn:login");
                //note the difference when getting the parameter
                password = request.getParameter("Lgn:password");
                System.out.println("Test login");

                authenticatedUser = ut.findAll().
                        stream()
                        .filter(person -> (login.equals(person.getLogin()) && password.equals(person.getPassword())))
                        .findAny()
                        .orElse(null);
                if (authenticatedUser == null) {
                    FacesMessage fm = new FacesMessage("Echec d'authentification", "ERROR MSG");
                    fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                    FacesContext.getCurrentInstance().addMessage(null, fm);
                    return "/login.xhtml";
                } else {
                    this.setRole(authenticatedUser.getRoleUtilisateur());
                    this.setLoggin(authenticatedUser.getLogin());
                    System.out.println(authenticatedUser.getClient());
                    this.client = authenticatedUser.getClient();
                    session.setAttribute("username", authenticatedUser.getLogin());
                    System.out.println("CODE HERE : "+authenticatedUser.getClient().getCodeCli());
                    session.setAttribute("codeCli", authenticatedUser.getClient().getCodeCli());
                    session.setAttribute("role", authenticatedUser.getRoleUtilisateur());
                    return "/index2.xhtml";
                }

            }
        } catch (HibernateException e) {
            FacesMessage fm = new FacesMessage("Echec d'authentification", "ERROR MSG");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            System.out.print("l'identification a echoué : " + e.getMessage());
        }
        return "/login.xhtml";
    }

    public Client getClient() {
        return client;
    }

    public void setUt(UtilisateurModel ut) {
        this.ut = ut;
    }

    public void setAuthenticatedUser(Utilisateur authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }

    public Utilisateur getAuthenticatedUser() {
        return authenticatedUser;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String doLogout() {

        return "/login.xhtml";
    }

}
