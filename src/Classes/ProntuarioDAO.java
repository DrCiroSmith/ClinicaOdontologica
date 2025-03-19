/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author a.pereira
 */
public class ProntuarioDAO {
    private Connection con;

    public ProntuarioDAO() {
        this.con = Conecta.getConexao();
    }
    
    
    
    public Prontuario pesquisarProntuario(int id){
        Prontuario p = new Prontuario();
        try{
            Statement stmt=con.createStatement();
            String sql="SELECT * FROM prontuario WHERE idPaciente="+id;
            stmt.execute(sql);
            ResultSet rs=stmt.getResultSet();
            while(rs.next()){
                p.setIdProntuario(rs.getInt("idProntuario"));
                p.setIdPaciente(rs.getInt("idPaciente"));
                p.setDescricao(rs.getString("descricao"));
                
   
            }
            rs.close();
            stmt.close();
        }catch(Exception e){
            System.err.println("Erro ao pesquisar prontuário: " + e.getMessage());
        }
        return p;
    }
    
    public String gravarProntuario(Prontuario prontuario) {
        String resp = "";
        try {
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO prontuario (idPaciente, descricao) ";
            sql += "VALUES ('" + prontuario.getIdPaciente()+"','" + prontuario.getDescricao()+"')";
            stmt.executeUpdate(sql);
            stmt.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }
    
    
    public String editarProntuario(Prontuario prontuario) {
        String resp = "";
        try {
            Statement stmt = con.createStatement();
            String sql = "UPDATE prontuario SET descricao='" + prontuario.getDescricao()+ "' WHERE idProntuario=" + prontuario.getIdProntuario();
            stmt.executeUpdate(sql);
            stmt.close();
            resp = "OK";
        } catch (Exception e) {
            resp = e.toString();
        }
        return resp;
    }
}
