/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;

import Comercial.dominio.Bodega;
import Comercial.dominio.Ruta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Diana
 */
public class RutaDAO {
    
    private static final String SQL_SELECT = "SELECT PK_codigo_transporteruta, nombre_conductoruta, "
            + "nombre_transporteruta, tipo_transporteruta, ubicacion_transporteruta, direccion_transporteruta,"
            + "hora_salida_transporteruta, hora_entrada_transporteruta, estatus_transporteruta FROM tbl_transporteruta";
    
    private static final String SQL_INSERT = "INSERT INTO tbl_transporteruta (PK_codigo_transporteruta, nombre_conductoruta, "
            + "nombre_transporteruta, tipo_transporteruta, ubicacion_transporteruta, direccion_transporteruta,"
            + "hora_salida_transporteruta, hora_entrada_transporteruta, estatus_transporteruta) "
            + "VALUES(?,?,?,?,?,?,?,?,?)";
    
    private static final String SQL_UPDATE = "UPDATE tbl_transporteruta SET nombre_conductoruta= ?, "
            + "nombre_transporteruta= ?, tipo_transporteruta=?, ubicacion_transporteruta=?, direccion_transporteruta=?,"
            + "hora_salida_transporteruta=?, hora_entrada_transporteruta=?, estatus_transporteruta=? "
            + "WHERE PK_codigo_transporteruta=?";
    
    private static final String SQL_QUERY = "SELECT  PK_codigo_transporteruta, nombre_conductoruta, "
            + "nombre_transporteruta, tipo_transporteruta, ubicacion_transporteruta, direccion_transporteruta,"
            + "hora_salida_transporteruta, hora_entrada_transporteruta, estatus_transporteruta"
            + " FROM tbl_transporteruta WHERE PK_codigo_transporteruta=?";
    
    private static final String SQL_DELETE = "DELETE FROM tbl_transporteruta WHERE PK_codigo_transporteruta=?";
    
    public List<Ruta> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Ruta ruta = null;
        List<Ruta> rutas = new ArrayList<Ruta>();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String PK_codigo_transporteruta = rs.getString("PK_codigo_transporteruta");
                String nombre_conductoruta = rs.getString("nombre_conductoruta");
                String nombre_transporteruta = rs.getString("nombre_transporteruta");
                String tipo_transporteruta = rs.getString("tipo_transporteruta");
                String ubicacion_transporteruta = rs.getString("ubicacion_transporteruta");
                String direccion_transporteruta = rs.getString("direccion_transporteruta");
                String hora_salida_transporteruta = rs.getString("hora_salida_transporteruta");
                String hora_entrada_transporteruta = rs.getString("hora_entrada_transporteruta");
                String estatus_transporteruta = rs.getString("estatus_transporteruta");
                
                ruta = new Ruta();
                ruta.setPK_codigo_transporteruta(PK_codigo_transporteruta);
                ruta.setNombre_conductoruta(nombre_conductoruta);
                ruta.setNombre_transporteruta(nombre_transporteruta);
                ruta.setTipo_transporteruta(tipo_transporteruta);
                ruta.setUbicacion_transporteruta(ubicacion_transporteruta);
                ruta.setDireccion_transporteruta(direccion_transporteruta);
                ruta.setHora_salida_transporteruta(hora_salida_transporteruta);
                ruta.setHora_entrada_transporteruta(hora_entrada_transporteruta);
                ruta.setEstatus_transporteruta(estatus_transporteruta);
                
                rutas.add(ruta);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rutas;
    }
    
    public int insert(Ruta ruta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, ruta.getPK_codigo_transporteruta());
            stmt.setString(2, ruta.getNombre_conductoruta());
            stmt.setString(3, ruta.getNombre_transporteruta());
            stmt.setString(4, ruta.getTipo_transporteruta());
            stmt.setString(5, ruta.getUbicacion_transporteruta());
            stmt.setString(6, ruta.getDireccion_transporteruta());
            stmt.setString(7, ruta.getHora_entrada_transporteruta());
            stmt.setString(8, ruta.getHora_salida_transporteruta());
            stmt.setString(9, ruta.getEstatus_transporteruta());

            //System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    public int update(Ruta ruta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, ruta.getNombre_conductoruta());
            stmt.setString(2, ruta.getNombre_transporteruta());
            stmt.setString(3, ruta.getTipo_transporteruta());
            stmt.setString(4, ruta.getUbicacion_transporteruta());
            stmt.setString(5, ruta.getDireccion_transporteruta());
            stmt.setString(6, ruta.getHora_entrada_transporteruta());
            stmt.setString(7, ruta.getHora_salida_transporteruta());
            stmt.setString(8, ruta.getEstatus_transporteruta());
            stmt.setString(9, ruta.getPK_codigo_transporteruta());
            
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
    
    public Ruta query(Ruta ruta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Ruta> rutas = new ArrayList<Ruta>();
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, ruta.getPK_codigo_transporteruta());
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                String PK_codigo_transporteruta = rs.getString("PK_codigo_transporteruta");
                String nombre_conductoruta = rs.getString("nombre_conductoruta");
                String nombre_transporteruta = rs.getString("nombre_transporteruta");
                String tipo_transporteruta = rs.getString("tipo_transporteruta");
                String ubicacion_transporteruta = rs.getString("ubicacion_transporteruta");
                String direccion_transporteruta = rs.getString("direccion_transporteruta");
                String hora_salida_transporteruta = rs.getString("hora_salida_transporteruta");
                String hora_entrada_transporteruta = rs.getString("hora_entrada_transporteruta");
                String estatus_transporteruta = rs.getString("estatus_transporteruta");
                
                ruta = new Ruta();
                ruta.setPK_codigo_transporteruta(PK_codigo_transporteruta);
                ruta.setNombre_conductoruta(nombre_conductoruta);
                ruta.setNombre_transporteruta(nombre_transporteruta);
                ruta.setTipo_transporteruta(tipo_transporteruta);
                ruta.setUbicacion_transporteruta(ubicacion_transporteruta);
                ruta.setDireccion_transporteruta(direccion_transporteruta);
                ruta.setHora_salida_transporteruta(hora_salida_transporteruta);
                ruta.setHora_entrada_transporteruta(hora_entrada_transporteruta);
                ruta.setEstatus_transporteruta(estatus_transporteruta);

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
        return ruta;
    }
    
    public int delete(Ruta ruta) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, ruta.getPK_codigo_transporteruta());
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
