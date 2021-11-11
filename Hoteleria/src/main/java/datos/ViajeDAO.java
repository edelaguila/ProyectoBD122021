/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Viaje;
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
public class ViajeDAO {
    public static String codigoAuxiliar, nombreAuxiliar, apellidoAuxiliar;
    private static final String SQL_INSERT = "insert into tbl_solicitud_viaje values(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_solicitud_viaje SET PK_id_habitacion=?, PK_id_transporte=?, destino_viaje=?, precio_viaje=? WHERE PK_id_solicitud=?";
    private static final String SQL_QUERY = "SELECT PK_id_solicitud, PK_id_habitacion, PK_id_transporte, destino_viaje, precio_viaje FROM tbl_solicitud_viaje WHERE PK_id_solicitud = ?";
    private static final String SQL_DELETE = "delete from tbl_solicitud_viaje where PK_id_solicitud = ?";
    
    public int insert(Viaje huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, huespedes.getId());
            stmt.setString(2, huespedes.getHabitacion());
            stmt.setString(3, huespedes.getTransporte());
            stmt.setString(4, huespedes.getDestino());
            stmt.setString(5, huespedes.getPrecio());

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
    
    public int update(Viaje huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//          System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, huespedes.getHabitacion());
            stmt.setString(2, huespedes.getTransporte());
            stmt.setString(3, huespedes.getDestino());
            stmt.setString(4, huespedes.getPrecio());
            stmt.setString(5, huespedes.getId());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public List<Viaje> select() {

        String SQL_SELECT = "SELECT * FROM tbl_solicitud_viaje WHERE PK_id_solicitud LIKE '%"+codigoAuxiliar+"%' OR PK_id_habitacion LIKE '%"+nombreAuxiliar+"%' OR PK_id_transporte LIKE '%"+apellidoAuxiliar+"%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Viaje huespedes = null;
        List<Viaje> huesped = new ArrayList<Viaje>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_id_solicitud");
                String nombre = rs.getString("PK_id_habitacion");
                String apellido = rs.getString("PK_id_transporte");
                String direccion = rs.getString("destino_viaje");
                String nacionalidad = rs.getString("precio_viaje");
                huespedes = new Viaje();
                huespedes.setId(id);
                huespedes.setHabitacion(nombre);
                huespedes.setTransporte(apellido);
                huespedes.setDestino(nacionalidad);
                huespedes.setPrecio(direccion);

                huesped.add(huespedes);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return huesped;
    }
    
    public Viaje query(Viaje huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, huespedes.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_id_solicitud");
                String nombre = rs.getString("PK_id_habitacion");
                String apellido = rs.getString("PK_id_transporte");
                String direccion = rs.getString("destino_viaje");
                String nacionalidad = rs.getString("precio_viaje");
                huespedes = new Viaje();
                huespedes.setId(id);
                huespedes.setHabitacion(nombre);
                huespedes.setTransporte(apellido);
                huespedes.setDestino(nacionalidad);
                huespedes.setPrecio(direccion);
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
    
    public int delete(Viaje huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, huespedes.getId());
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
