/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Concepto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

/**
 * 
 * @author Santiago Martinez Diaz
 */
public class ConceptoDAO {
    
    private static final String SQL_SELECT = "SELECT Id_Concepto, Nombre_Concepto,Descripcion_Concepto, Estatus_Concepto FROM Concepto";
    private static final String SQL_INSERT = "INSERT INTO Concepto VALUES(?, ?, ?,?)";
    private static final String SQL_DELETE = "DELETE FROM Concepto WHERE Id_Concepto=?";
    private static final String SQL_UPDATE = "UPDATE Concepto SET Id_Concepto=?, Nombre_Concepto=?,Descripcion_Concepto=? Estatus_Concepto=? WHERE Id_Concepto = ?";
    private static final String SQL_QUERY = "SELECT Id_Concepto, Nombre_Concepto,Descripcion_Concepto Estatus_Concepto FROM Concepto WHERE Id_Concepto = ?";
   
     public int insert(Concepto concepto){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, concepto.getId_Concepto());
            stmt.setString(2, concepto.getNombre_Concepto());
            stmt.setString(3, concepto.getDescripcion_Concepto());
            stmt.setString(4, concepto.getEstatus_Concepto());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }        
        return rows;
    }
 
 public int update(Concepto concepto){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            //System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, concepto.getId_Concepto());
            stmt.setString(2, concepto.getNombre_Concepto());
            stmt.setString(3, concepto.getDescripcion_Concepto());
            stmt.setString(4, concepto.getEstatus_Concepto());
            stmt.setString(5, concepto.getId_Concepto());
            rows = stmt.executeUpdate();
            //System.out.println("Registros actualizado:" + rows);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
 }
  public int delete(Concepto concepto){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, concepto.getId_Concepto());
            rows = stmt.executeUpdate();
            //System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
      public Concepto query(Concepto concepto){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        int rows = 0; 
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, concepto.getId_Concepto());
            rs = stmt.executeQuery();
            while(rs.next()){
            String Id_Concepto = rs.getString("Id_Concepto");
            String Nombre_Concepto = rs.getString("Nombre_Concepto");
            String Descripcion_Concepto = rs.getString("Descripcion_Concepto");
            String Estatus_Concepto = rs.getString("Estatus_Concepto");
                    
                concepto = new Concepto();
                concepto.setId_Concepto(Id_Concepto);
                concepto.setNombre_Concepto(Nombre_Concepto);
                concepto.setDescripcion_Concepto(Descripcion_Concepto);
                concepto.setEstatus_Concepto(Estatus_Concepto);         
            }
  
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }     
        return concepto;
    }   

     public List<Concepto> listar() {
        List<Concepto> moneda = new ArrayList <>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;   
        try {
            conn=Conexion.getConnection();
            stmt=conn.prepareStatement(SQL_SELECT);
            rs=stmt.executeQuery();
            while (rs.next()) {
            Concepto usr = new Concepto();
            usr.setId_Concepto(rs.getString(1));
            usr.setNombre_Concepto(rs.getString(2));
            usr.setDescripcion_Concepto(rs.getString(3));
            usr.setEstatus_Concepto(rs.getString(4));
            moneda.add(usr);
             }
         }catch (Exception e){
         }
         return moneda;
     }
    
    
    

}
