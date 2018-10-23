/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.modelInfractor;
import Model.modelPersona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class PersonaDao extends Conexion {
    
    public List<modelPersona> listarHab() throws Exception {
        this.Conexion();
        List<modelPersona> lista;
        ResultSet rs;

        try {
            String sql = "";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            modelPersona Model;
            while (rs.next()) {
                Model = new modelPersona();
                Model.setCODPER(rs.getString(""));
                Model.setNOMPER(rs.getString(""));
                Model.setAPEPATPER(rs.getString(""));
                Model.setAPEMATPER(rs.getString(""));
                Model.setDNIPER(rs.getString(""));         
                Model.setFECNACPER(rs.getString(""));         
                Model.setDOMPER(rs.getString(""));         
                Model.setESTCOMPER(rs.getString(""));         
                Model.setTIPOPER(rs.getString(""));         
                Model.setESTPER(rs.getString(""));         
                Model.setlATPER(rs.getString(""));         
                Model.setLONPER(rs.getString(""));         
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
