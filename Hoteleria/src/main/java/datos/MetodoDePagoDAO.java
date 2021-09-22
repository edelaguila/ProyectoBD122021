/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.MetodoDePago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Herbert Leonel Dominguez Chavez
 */
public class MetodoDePagoDAO {
    public static String codigoAuxiliar, nombreAuxiliar;
    private static final String SQL_INSERT = "insert into tbl_metodo_de_pago values(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_metodo_de_pago SET nombre_metodo=?, descripcion_metodo=?, estado_metodo=? WHERE PK_id_metodo=?";
    private static final String SQL_QUERY = "SELECT PK_id_metodo, nombre_metodo, descripcion_metodo, estado_metodo FROM tbl_metodo_de_pago WHERE PK_id_metodo = ?";
    private static final String SQL_DELETE = "delete from tbl_metodo_de_pago where PK_id_metodo = ?";  
    
    public int insert(MetodoDePago metodoPago) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, metodoPago.getId());
            stmt.setString(2, metodoPago.getNombre());
            stmt.setString(3, metodoPago.getDescripcion());
            stmt.setString(4, metodoPago.getEstado());
           

            //System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    public int update(MetodoDePago metodoPago){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
//          System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, metodoPago.getNombre());
            stmt.setString(2, metodoPago.getDescripcion());
            stmt.setString(3, metodoPago.getEstado());
            stmt.setString(4, metodoPago.getId());
            
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
    public List<MetodoDePago> select(){
        String SQL_SELECT = "SELECT * FROM tbl_metodo_de_pago WHERE PK_id_metodo LIKE '%"+codigoAuxiliar+"%' OR nombre_metodo LIKE'%"+nombreAuxiliar+"%'";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MetodoDePago metodoPago = null;
        List<MetodoDePago> metodo = new ArrayList<MetodoDePago>();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                String id_metodo = rs.getString("PK_id_metodo");
                String nombre_metodo = rs.getString("nombre_metodo");
                String descripcion_metodo = rs.getString("descripcion_metodo");
                String estado_metodo = rs.getString("estado_metodo");
                
                metodoPago = new MetodoDePago();
                metodoPago.setId(id_metodo);
                metodoPago.setNombre(nombre_metodo);
                metodoPago.setDescripcion(descripcion_metodo);
                metodoPago.setEstado(estado_metodo);
                
                
                metodo.add(metodoPago);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return metodo;
    }
    public MetodoDePago query(MetodoDePago metodoPago) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, metodoPago.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id_metodo = rs.getString("PK_id_metodo");
                String nombre = rs.getString("nombre_metodo");
                String descripcio = rs.getString("descripcion_metodo");
                String estado = rs.getString("estado_metodo");

                metodoPago = new MetodoDePago();
                metodoPago.setId(id_metodo);
                metodoPago.setNombre(nombre);
                metodoPago.setDescripcion(descripcio);
                metodoPago.setEstado(estado);
                System.out.println(metodoPago.getNombre());
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return metodoPago;
    }
    public int delete(MetodoDePago metodoPago){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, metodoPago.getId());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    } 
}
