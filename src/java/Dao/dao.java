/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Monitor
 */
public class dao {
    
    model m1 = new model("01", "JOSETH", "ALZAMORA", -13.076908 , -76.389021 , "RJ1");
    model m2 = new model("02", "LUIS", "MARQUEZ", -13.074651 , -76.389085 , "RJ1");
    model m3 = new model("03", "ROGER", "RODRIGUEZ", -13.078465 , -76.390920 , "RJ1");
    model m4 = new model("04", "ISSAC", "VARGAS", -13.084265 , -76.387809 , "RJ1");
    model m5 = new model("05", "AUGUSTO", "REJAS", -13.076479 , -76.381865 , "RJ1");
    model m6 = new model("06", "SULBERTO", "GUILLER", -13.072079 , -76.380717 , "RJ1");
    model m7 = new model("07", "ALEXANDER", "PAYANO", -13.073647 , -76.372627 , "RJ1");
    model m8 = new model("08", "FELIPE", "YMAN", -13.074002 , -76.375288 , "RJ1");
    
    public List<model>array(){
        
        List<model> datos = new ArrayList<>();
        datos.add(m1);
        datos.add(m2);
        datos.add(m3);
        datos.add(m4);
        datos.add(m5);
        datos.add(m6);
        datos.add(m7);
        datos.add(m8);
        return datos;
    
    };
    
    
    
}
