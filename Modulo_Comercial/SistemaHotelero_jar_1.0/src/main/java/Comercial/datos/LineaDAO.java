/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;
import Comercial.dominio.Linea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author SIPAQUE.RITA
 */
public class LineaDAO {
    
    private static final String SQL_SELECT = "SELECT PK_codigo_linea, nombre_linea,  estatus_linea FROM tbl_linea";
    private static final String SQL_INSERT = "INSERT INTO tbl_linea(PK_codigo_linea, nombre_linea, estatus_linea) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_linea SET  nombre_linea=?, estatus_linea=? WHERE PK_codigo_linea=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_linea WHERE PK_codigo_linea =?";
    private static final String SQL_QUERY = "SELECT PK_codigo_linea, nombre_linea, estatus_linea FROM tbl_linea WHERE PK_codigo_linea = ?";
    
    
    
     public List<Linea> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Linea linea = null;
        List<Linea> lineas = new ArrayList<Linea>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                String codigoLinea = rs.getString("PK_codigo_linea");
                String nombreLinea = rs.getString("nombre_linea");
                String estatusLinea = rs.getString("estatus_linea");
                
                linea = new Linea();
                linea.setPK_codigo_Linea(codigoLinea);
                linea.setNombre_Linea(nombreLinea);
                linea.setEstatus_Linea(estatusLinea);
                lineas.add(linea);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return lineas;
    }
     
     public int insert(Linea linea) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            
            stmt.setString(1, linea.getPK_codigo_Linea());
            stmt.setString(2, linea.getNombre_Linea());
            stmt.setString(3, linea.getEstatus_Linea());
           
            
             
            //System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);            stmt.setString(2, aplicacion.getCliente());

            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
     
    public int update(Linea  linea) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            
            stmt.setString(1, linea.getNombre_Linea());
            stmt.setString(2, linea.getEstatus_Linea());
            stmt.setString(3, linea.getPK_codigo_Linea());
            
            
            
            rows = stmt.executeUpdate();
            //System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    public Linea query(Linea linea) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Linea> productos = new ArrayList<Linea>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
           stmt.setString(1, linea.getPK_codigo_Linea());
            rs = stmt.executeQuery();
            while (rs.next()) {
               
                String codigoLinea = rs.getString("PK_codigo_linea");
                String nombreLinea = rs.getString("nombre_linea");
                String estatusLinea = rs.getString("estatus_linea");
                
                 
                
                linea = new Linea();
                linea.setPK_codigo_Linea(codigoLinea);
                linea.setNombre_Linea(nombreLinea);
                linea.setEstatus_Linea(estatusLinea);
                
                //empleados.add(empleado); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + empleado);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return empleados;  // Si se utiliza un ArrayList
        return linea;
    }
    
    public int delete(Linea linea) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, linea.getPK_codigo_Linea());
            rows = stmt.executeUpdate();
            //System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
}
