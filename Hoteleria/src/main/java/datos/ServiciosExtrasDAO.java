/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.ServiciosExtras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leone
 */
public class ServiciosExtrasDAO {

    private static final String SQL_INSERT = "insert into tbl_detalle_servicioextra values(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_detalle_servicioextra SET id_reservacion=?, id_servicio=? WHERE Pk_correlativo_detalle=?";
    private static final String SQL_QUERY = "SELECT * FROM tbl_detalle_servicioextra WHERE Pk_correlativo_detalle=?";
    private static final String SQL_DELETE = "delete from tbl_detalle_servicioextra where Pk_correlativo_detalle = ?";
    private static final String SQL_SELECT = "SELECT * FROM tbl_detalle_servicioextra";

    public int insert(ServiciosExtras asignacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, asignacion.getCorrelativo());
            stmt.setString(2, asignacion.getReservación());
            stmt.setString(3, asignacion.getServicio());

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

    public int update(ServiciosExtras asignacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//          System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(4, asignacion.getReservación());
            stmt.setString(4, asignacion.getServicio());
            stmt.setString(4, asignacion.getCorrelativo());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public List<ServiciosExtras> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ServiciosExtras asignacion = null;
        List<ServiciosExtras> asiganaciones = new ArrayList<ServiciosExtras>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String correlativo = rs.getString("Pk_correlativo_detalle");
                String id_reservacion = rs.getString("id_reservacion");
                String id_servicio = rs.getString("id_servicio");

                asignacion = new ServiciosExtras();
                asignacion.setCorrelativo(correlativo);
                asignacion.setReservación(id_reservacion);
                asignacion.setServicio(id_servicio);
                asiganaciones.add(asignacion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return asiganaciones;
    }

    public ServiciosExtras query(ServiciosExtras asignacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, asignacion.getCorrelativo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String correlativo = rs.getString("Pk_correlativo_detalle");
                String id_reservacion = rs.getString("id_reservacion");
                String id_servicio = rs.getString("id_servicio");

                asignacion = new ServiciosExtras();
                asignacion.setCorrelativo(correlativo);
                asignacion.setReservación(id_reservacion);
                asignacion.setServicio(id_servicio);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return asignacion;
    }

    public int delete(ServiciosExtras asignacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, asignacion.getCorrelativo());
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
