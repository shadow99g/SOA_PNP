/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.dao;
import Model.modelPersona;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author PC
 */
@Named(value = "controllerPersona")
@SessionScoped
public class ControllerPersona implements Serializable {

    List<modelPersona> lista = new ArrayList<>();
    dao cc= new dao();
    
   @PostConstruct
   public void init(){
   
   }

   
   
   
   
   
   
   /*- encapsulado de listas -*/
    public List<modelPersona> getLista() {
        return lista;
    }

    public void setLista(List<modelPersona> lista) {
        this.lista = lista;
    }

    public dao getCc() {
        return cc;
    }

    public void setCc(dao cc) {
        this.cc = cc;
    } 
}
