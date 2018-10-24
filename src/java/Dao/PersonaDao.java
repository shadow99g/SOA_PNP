/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

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
            String sql = "SELECT * FROM PERSONA";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            modelPersona Model;
            while (rs.next()) {
                Model = new modelPersona();
                Model.setCODPER(rs.getString("CODPER"));
                Model.setNOMPER(rs.getString("NOMPER"));
                Model.setAPEPATPER(rs.getString("APEPATPER"));
                Model.setAPEMATPER(rs.getString("APEMATPER"));
                Model.setDNIPER(rs.getString("DNIPER"));         
                Model.setFECNACPER(rs.getString("FECNACPER"));         
                Model.setDOMPER(rs.getString("DOMPER"));         
                Model.setESTCOMPER(rs.getString("ESTCOMPER"));         
                Model.setTIPOPER(rs.getString("TIPOPER"));         
                Model.setESTPER(rs.getString("ESTPER"));         
                Model.setlATPER(rs.getString("LATPER"));         
                Model.setLONPER(rs.getString("LONPER"));         
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
