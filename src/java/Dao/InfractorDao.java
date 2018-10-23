/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.model;
import Model.modelInfractor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class InfractorDao extends Conexion{
    
    
    public List<modelInfractor> listarHab() throws Exception {
        this.Conexion();
        List<modelInfractor> lista;
        ResultSet rs;

        try {
            String sql = "";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            modelInfractor Model;
            while (rs.next()) {
                Model = new modelInfractor();
                Model.setCODINFRAC(rs.getString(""));
                Model.setPNAC(rs.getString(""));
                Model.setPBAU(rs.getString(""));
                Model.setBMILI(rs.getString(""));
                Model.setOTRO(rs.getString(""));         
                lista.add(Model);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    
    
    
    
    
}
