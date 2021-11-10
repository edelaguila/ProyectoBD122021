/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;
import Comercial.dominio.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author SipaqueRitaMaria
 */
public class MarcaDAO {
    private static final String SQL_SELECT = "SELECT PK_codigo_marca, nombre_marca,  estatus_marca FROM tbl_marca";
    private static final String SQL_INSERT = "INSERT INTO tbl_marca(PK_codigo_marca, nombre_marca, estatus_marca) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_marca SET  nombre_marca=?, estatus_marca=? WHERE PK_codigo_marca=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_marca WHERE PK_codigo_marca =?";
    private static final String SQL_QUERY = "SELECT PK_codigo_marca, nombre_marca, estatus_marca FROM tbl_marca WHERE PK_codigo_marca = ?";
    

public List<Marca> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Marca marca = null;
        List<Marca> marcas = new ArrayList<Marca>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                String codigoMarca = rs.getString("PK_codigo_marca");
                String nombreMarca = rs.getString("nombre_marca");
                String estatusMarca = rs.getString("estatus_marca");
                
                marca = new Marca();
                marca.setPK_codigo_Marca(codigoMarca);
                marca.setNombre_Marca(nombreMarca);
                marca.setEstatus_Marca(estatusMarca);
                marcas.add(marca);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return marcas;
    }


public int insert(Marca aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            
            stmt.setString(1, aplicacion.getPK_codigo_Marca());
            stmt.setString(2, aplicacion.getNombre_Marca());
            stmt.setString(3, aplicacion.getEstatus_Marca());
           
            
             
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

public int update(Marca marca) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
         
            stmt.setString(1, marca.getNombre_Marca());
            stmt.setString(2, marca.getEstatus_Marca());
            stmt.setString(3, marca.getPK_codigo_Marca());
            
            
            
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

public Marca query(Marca marca) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Marca> marcas = new ArrayList<Marca>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
           stmt.setString(1, marca.getPK_codigo_Marca());
            rs = stmt.executeQuery();
            while (rs.next()) {
               
                String codigoMarca = rs.getString("PK_codigo_marca");
                String nombreMarca = rs.getString("nombre_marca");
                String estatusMarca = rs.getString("estatus_marca");
                
                 
                
                marca = new Marca();
                marca.setPK_codigo_Marca(codigoMarca);
                marca.setNombre_Marca(nombreMarca);
                marca.setEstatus_Marca(estatusMarca);
                
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
        return marca;
    }



public int delete(Marca marca) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, marca.getPK_codigo_Marca());
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
