/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.insurance.services;

import com.insurance.entities.Utilisateur;
import com.insurance.hibernate.util.HibernateUtil;
import com.insurance.models.UtilisateurModel;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

@ManagedBean(name = "AuthentificationService")
@RequestScoped
/**
 *
 * @author TOUNOUSSI
 */
public class AuthentificationService implements Serializable {

    private UtilisateurModel ut = new UtilisateurModel();
    private Utilisateur authenticatedUser = new Utilisateur();

    @ManagedProperty(value = "#{param.login}")
    private String login;
    
    @ManagedProperty(value = "#{param.password}")
    private String password;
    
    @ManagedProperty(value = "#{param.loggin}")
    private String loggin;

    public String getLoggin() {
        return loggin;
    }

    public void setLoggin(String loggin) {
        this.loggin = loggin;
    }
    @ManagedProperty(value = "#{param.role}")

    private String role;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String dbuserName;
    private String dbpassword;
    HttpSession session;

    String sql;

    public String singin() {

        try {
             HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            session = request.getSession();
            HibernateUtil.getSessionFactory().openSession();

            if (session != null) {
                login = request.getParameter("Lgn:login");
                //note the difference when getting the parameter
                password = request.getParameter("Lgn:password");
                

            }
        } catch (Exception e) {
            System.out.print("l'identification a echoué : " + e.getMessage());
        }
        return"/index2.xhtml";
    }

    public void setUt(UtilisateurModel ut) {
        this.ut = ut;
    }

    public void setAuthenticatedUser(Utilisateur authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDbuserName(String dbuserName) {
        this.dbuserName = dbuserName;
    }

    public void setDbpassword(String dbpassword) {
        this.dbpassword = dbpassword;
    }
    
    

    public String doLogout() {

        return "/login.xhtml";
    }

}
