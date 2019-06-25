/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.insurance.services;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name="sessionBean")
@SessionScoped
public class SessionBean {
    public static HttpSession getSession(){
    return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    } 
    public static HttpServletRequest getRequest(){
    return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }
}
