/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Reservacion;
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
public class ReservacionDAO {

    public static String codigoAuxReservacion, codigoAuxCliente;
    private static final String SQL_INSERT = "insert into tbl_reservacion values(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_reservacion SET fecha_reservacion=?, fecha_entrada_reservacion=?, fecha_salida_reservacion=?, identificacion_huesped_reservacion=?, cantidad_personas_reservacion=?, estado_reservacion=? WHERE PK_id_reservacion=?";
    private static final String SQL_QUERY = "SELECT PK_id_reservacion, fecha_reservacion, fecha_entrada_reservacion, fecha_salida_reservacion, identificacion_huesped_reservacion, cantidad_personas_reservacion, estado_reservacion FROM tbl_reservacion WHERE PK_id_reservacion = ?";
    private static final String SQL_DELETE = "delete from tbl_reservacion where PK_id_reservacion = ?";

    public int insert(Reservacion reservacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, reservacion.getIdReservacion());
            stmt.setString(2, reservacion.getFechaActual());
            stmt.setString(3, reservacion.getFechaIngreso());
            stmt.setString(4, reservacion.getFechaEgreso());
            stmt.setString(5, reservacion.getIdCliente());
            stmt.setString(6, reservacion.getCantidadPersonas());
            stmt.setString(7, reservacion.getEstadoReservacion());

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

    public int update(Reservacion reservacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//          System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, reservacion.getFechaActual());
            stmt.setString(2, reservacion.getFechaIngreso());
            stmt.setString(3, reservacion.getFechaEgreso());
            stmt.setString(4, reservacion.getIdCliente());
            stmt.setString(5, reservacion.getCantidadPersonas());
            stmt.setString(6, reservacion.getEstadoReservacion());
            stmt.setString(7, reservacion.getIdReservacion());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public List<Reservacion> select() {

        String SQL_SELECT = "SELECT * FROM tbl_reservacion WHERE PK_id_reservacion LIKE '%" + codigoAuxReservacion + "%' OR identificacion_huesped_reservacion LIKE '%" + codigoAuxCliente + "%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Reservacion reservacion = null;
        List<Reservacion> reservaciones = new ArrayList<Reservacion>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idReservacion = rs.getString("PK_id_reservacion");
                String fechaReservacion = rs.getString("fecha_reservacion");
                String fechaIngreso = rs.getString("fecha_entrada_reservacion");
                String fechaEgreso = rs.getString("fecha_salida_reservacion");
                String idCliente = rs.getString("identificacion_huesped_reservacion");
                String cantPersonas = rs.getString("cantidad_personas_reservacion");
                String estadoReservacion = rs.getString("estado_reservacion");

                reservacion = new Reservacion();
                reservacion.setIdReservacion(idReservacion);
                reservacion.setFechaActual(fechaReservacion);
                reservacion.setFechaIngreso(fechaIngreso);
                reservacion.setFechaEgreso(fechaEgreso);
                reservacion.setIdCliente(idCliente);
                reservacion.setCantidadPersonas(cantPersonas);
                reservacion.setEstadoReservacion(estadoReservacion);
                reservaciones.add(reservacion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return reservaciones;
    }

    public Reservacion query(Reservacion reservacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, reservacion.getIdReservacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String idReservacion = rs.getString("PK_id_reservacion");
                String fechaReservacion = rs.getString("fecha_reservacion");
                String fechaIngreso = rs.getString("fecha_entrada_reservacion");
                String fechaEgreso = rs.getString("fecha_salida_reservacion");
                String idCliente = rs.getString("identificacion_huesped_reservacion");
                String cantPersonas = rs.getString("cantidad_personas_reservacion");
                String estadoReservacion = rs.getString("estado_reservacion");

                reservacion = new Reservacion();
                reservacion.setIdReservacion(idReservacion);
                reservacion.setFechaActual(fechaReservacion);
                reservacion.setFechaIngreso(fechaIngreso);
                reservacion.setFechaEgreso(fechaEgreso);
                reservacion.setIdCliente(idCliente);
                reservacion.setCantidadPersonas(cantPersonas);
                reservacion.setEstadoReservacion(estadoReservacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return reservacion;
    }

    public int delete(Reservacion reservacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, reservacion.getIdReservacion());
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