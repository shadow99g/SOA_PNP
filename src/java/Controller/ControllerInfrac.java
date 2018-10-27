/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.InfractorDao;

import Model.model;
import Model.modelInfractor;
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

 //   List<model> lista =new ArrayList<>();
    List<modelInfractor> lista ;
   
    InfractorDao inf;
    
    @PostConstruct
    public void init(){
    agregar();
    }
    
    public void agregar()
    {
        try {
            inf = new InfractorDao();
          //  lista = cc.array();
          lista = inf.listarHab();
        } catch (Exception e) {
            System.out.println("alerta: "+e);
        }
       
    }

    

    public List<modelInfractor> getLista() {
        return lista;
    }

/*- encapsulado de listas -*/
    public void setLista(List<modelInfractor> lista) {    
        this.lista = lista;
    }

    
    
    
}
