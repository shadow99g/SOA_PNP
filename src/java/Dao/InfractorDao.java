/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

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
            String sql = "Select concat (adolecente.nomper ,concat( ' ', concat (adolecente.apepatper,concat(' ',adolecente.apematper)))) as ad,\n" +
"    concat (familiar.nomper ,concat( ' ', concat (familiar.apepatper,concat(' ',familiar.apematper)))) as fam,\n" +
"    persona_direccion.refper,\n" +
"    persona_direccion.latdir,\n" +
"    persona_direccion.londir\n" +
"    \n" +
"from Persona Adolecente\n" +
"inner join infractor on adolecente.codper = infractor.codper_ado\n" +
"inner join persona_direccion on infractor.codinf = persona_direccion.codinf\n" +
"inner join Persona Familiar on persona_direccion.codper = familiar.codper";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            modelInfractor Model;
            while (rs.next()) {
                Model = new modelInfractor();
                Model.setCODINFRAC(rs.getString("ad"));
                Model.setPARNACINF(rs.getString("fam"));
                Model.setPARBAUINF(rs.getString("refper"));
                Model.setLIBMILINF(rs.getString("latdir"));
                Model.setCODPER_ADO(rs.getString("londir"));                
                lista.add(Model);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    
    
    
    /*
    codigo sql 
    
    select ficha_integral.codinf,persona.codper,persona.nomper from ficha_integral
inner join
persona on persona.codper = ficha_integral.codper_mad
inner join
persona on persona.codper = ficha_integral.codper_pad
inner join
persona on persona.codper = ficha_integral.codper_par;

select persona.codper,persona.nomper,persona.apepatper,persona.apematper,persona_direccion.latdir,persona_direccion.londir,persona_direccion.refper from persona
inner join
persona_direccion on persona_direccion.codper_ado = persona.codper;
    
    */
    
}
