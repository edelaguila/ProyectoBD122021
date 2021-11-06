/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.DetalleReservacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leone
 */
public class DetalleReservacionDAO {
    public static String validacionReservacion;
    private static final String SQL_INSERT = "insert into tbl_detalle_reservacion values(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_detalle_reservacion SET id_reservacion_detalle=?, id_tarifa_detalle=? WHERE Pk_correlativo_detalle=?";
    private static final String SQL_QUERY = "SELECT * FROM tbl_detalle_reservacion WHERE Pk_correlativo_detalle=? AND id_tarifa_detalle=?";
    private static final String SQL_DELETE = "delete from tbl_detalle_reservacion where Pk_correlativo_detalle = ?";
    private static final String SQL_SELECT = "SELECT * FROM tbl_detalle_reservacion";

    public int insert(DetalleReservacion detalleRes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, detalleRes.getCorrelativo());
            stmt.setString(2, detalleRes.getIdReservacion());
            stmt.setString(3, detalleRes.getIdTarifa());
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

    public int update(DetalleReservacion detalleRes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
//          System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(2, detalleRes.getIdReservacion());
            stmt.setString(3, detalleRes.getIdTarifa());
            stmt.setString(4, detalleRes.getCorrelativo());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public List<DetalleReservacion> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DetalleReservacion detalleRes = null;
        List<DetalleReservacion> detalleReservacion = new ArrayList<DetalleReservacion>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                String correlativo = rs.getString("Pk_correlativo_detalle");
                String id_reservacion = rs.getString("id_reservacion_detalle");
                String id_tarifa = rs.getString("id_tarifa_detalle");
                
                detalleRes = new DetalleReservacion();
                
                detalleRes.setCorrelativo(correlativo);
                detalleRes.setIdReservacion(id_reservacion);
                detalleRes.setIdTarifa(id_tarifa);
                
                detalleReservacion.add(detalleRes);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return detalleReservacion;
    }

    public DetalleReservacion query(DetalleReservacion detalleRes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, detalleRes.getIdReservacion());
            stmt.setString(2, detalleRes.getIdTarifa());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String correlativo = rs.getString("PK_correlativo_paquete");
                String id_reservacion = rs.getString("id_tarifa_paquete");
                String id_tarifa = rs.getString("id_servicio_paquete");

                detalleRes = new DetalleReservacion();
                detalleRes.setCorrelativo(correlativo);
                detalleRes.setIdReservacion(id_reservacion);
                detalleRes.setIdTarifa(id_tarifa);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return detalleRes;
    }

    public int delete(DetalleReservacion detalleRes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, detalleRes.getCorrelativo());
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
    
    public DetalleReservacion getProcesoAlmacenado(DetalleReservacion detalleRes){
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            String sql = "{call getValidarReservacion (?, ?, ?)}";
            stmt = conn.prepareCall(sql);
            stmt.setString(1, detalleRes.getIdReservacion());
            
            stmt.setString(2, detalleRes.getIdTarifa());
            
            stmt.registerOutParameter(3, java.sql.Types.INTEGER);
            
            stmt.execute();
            
            validacionReservacion = stmt.getString(3);
            System.out.println(detalleRes.getIdReservacion() + " " + detalleRes.getIdTarifa() + " " + stmt.getString(3));
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return detalleRes;
    }
}
