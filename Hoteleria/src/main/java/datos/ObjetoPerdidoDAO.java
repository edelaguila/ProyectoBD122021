/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.ObjetoPerdido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leelu
 */
public class ObjetoPerdidoDAO {
public static String codigoAuxiliar, nombreAuxiliar;
    private static final String SQL_INSERT = "insert into tbl_objeto_perdido values(?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_objeto_perdido SET Pk_id_habitacion=?,Pk_id_ama_de_llaves=?, fecha_entregado=?, objeto=?, identificacion=?, estado=?, fecha_entregado=? WHERE PK_id_objeto=?";
    private static final String SQL_SELECT = "SELECT Pk_id_objeto, PK_id_habitacion, Pk_id_ama_de_llaves, fecha_encontrado, objeto, identificacion, estado, fecha_entregado FROM tbl_objeto_perdido";
    private static final String SQL_QUERY = "SELECT Pk_id_objeto, PK_id_habitacion, Pk_id_ama_de_llaves, fecha_encontrado, objeto, identificacion, estado, fecha_entregado FROM tbl_objeto_perdido WHERE PK_id_objeto = ?";
    private static final String SQL_DELETE = "delete from tbl_objeto_perdido where PK_id_objeto = ?";
    
    public int insert(ObjetoPerdido huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, huespedes.getIdobjeto());
            stmt.setString(2, huespedes.getHabitacion());
            stmt.setString(3, huespedes.getAma());
            stmt.setString(4, huespedes.getFecha());
            stmt.setString(5, huespedes.getObjeto());
            stmt.setString(6, huespedes.getDpi());
            stmt.setString(7, huespedes.getEstado());
            stmt.setString(8, huespedes.getFechae());
           

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
    
    public int update(ObjetoPerdido huespedes){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
//          System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(8, huespedes.getIdobjeto());
            stmt.setString(1, huespedes.getHabitacion());
            stmt.setString(2, huespedes.getAma());
            stmt.setString(3, huespedes.getFecha());
            stmt.setString(4, huespedes.getObjeto());
            stmt.setString(5, huespedes.getDpi());
            stmt.setString(6, huespedes.getEstado());
            stmt.setString(7, huespedes.getFechae());

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
    
    public List<ObjetoPerdido> select(){
        
        String SQL_SELECT = "SELECT * FROM tbl_objeto_perdido WHERE PK_id_Objeto LIKE '%"+codigoAuxiliar+"%' OR objeto LIKE '%"+nombreAuxiliar+"%'";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ObjetoPerdido huespedes = null;
        List<ObjetoPerdido> metodo = new ArrayList<ObjetoPerdido>();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                String idobjeto = rs.getString("PK_id_Objeto");
                String habitacion = rs.getString("PK_id_habitacion");
                String ama = rs.getString("PK_id_ama_de_llaves");
                String fecha = rs.getString("fecha_encontrado");
                String objeto = rs.getString("objeto");
                String dpi = rs.getString("identificacion");
                String estado = rs.getString("estado");
                String fechae = rs.getString("fecha_entregado");
                
                
                huespedes = new ObjetoPerdido();
                huespedes.setIdobjeto(idobjeto);
                huespedes.setHabitacion(habitacion);
                huespedes.setAma(ama);
                huespedes.setFecha(fecha);
                huespedes.setObjeto(objeto);
                huespedes.setDpi(dpi);
                huespedes.setEstado(estado);
                huespedes.setFechae(fechae);
                
                
                
                metodo.add(huespedes);
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
    
    public ObjetoPerdido query(ObjetoPerdido huespedes) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, huespedes.getIdobjeto());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idobjeto = rs.getString("PK_id_Objeto");
                String habitacion = rs.getString("PK_id_habitacion");
                String ama = rs.getString("PK_id_ama_de_llaves");
                String fecha = rs.getString("fecha_encontrado");
                String objeto = rs.getString("objeto");
                String dpi = rs.getString("identificacion");
                String estado = rs.getString("estado");
                String fechae = rs.getString("fecha_entregado");
                
                
                huespedes = new ObjetoPerdido();
                huespedes.setIdobjeto(idobjeto);
                huespedes.setHabitacion(habitacion);
                huespedes.setAma(ama);
                huespedes.setFecha(fecha);
                huespedes.setObjeto(objeto);
                huespedes.setDpi(dpi);
                huespedes.setEstado(estado);
                huespedes.setFecha(fechae);
                System.out.println(huespedes.getHabitacion());
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return huespedes;
    }
    
    public int delete(ObjetoPerdido modulos){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, modulos.getIdobjeto());
            rows = stmt.executeUpdate();
            System.out.println("Objeto eliminado:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
}
