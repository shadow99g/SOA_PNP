/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.dao;
import Model.model;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author jordy
 */
@Named(value = "controllerInfrac")
@SessionScoped
public class ControllerInfrac implements Serializable {

    List<model> lista =new ArrayList<>();
    dao cc= new dao();
    
    @PostConstruct
    public void init(){
    agregar();
    }
    
    public void agregar()
    {
        try {
            lista = cc.array();
        } catch (Exception e) {
            System.out.println("alerta: "+e);
        }
       
    }

    public List<model> getLista() {
        return lista;
    }

    public void setLista(List<model> lista) {
        this.lista = lista;
    }

    public dao getCc() {
        return cc;
    }

    public void setCc(dao cc) {
        this.cc = cc;
    }
    
    
}
