/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Habitaciones;
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
public class HabitacionDAO {
        public static String codigoAuxiliar;
    private static final String SQL_INSERT = "insert into tbl_mantenimiento_habitaciones values(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_mantenimiento_habitaciones SET precio_habitacion=?, piso_habitaciones=?, estado_habitacion=?, estado_limpieza=?, tipo_de_habitacion=?, cantidad_maxima_pers=? WHERE PK_id_habitacion=?";
    private static final String SQL_QUERY = "SELECT PK_id_habitacion, precio_habitacion, piso_habitaciones, estado_habitacion, estado_limpieza, tipo_de_habitacion, cantidad_maxima_pers FROM tbl_mantenimiento_habitaciones WHERE PK_id_habitacion = ?";
    private static final String SQL_DELETE = "delete from tbl_mantenimiento_habitaciones where PK_id_habitacion = ?";
    
    public int insert(Habitaciones huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, huespedes.getId());
            stmt.setString(2, huespedes.getPrecio());
            stmt.setString(3, huespedes.getPiso());
            stmt.setString(4, huespedes.getEstado());
            stmt.setString(5, huespedes.getLimpieza());
            stmt.setString(6, huespedes.getTipo());
            stmt.setString(7, huespedes.getCantidad());

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
    
    public int update(Habitaciones huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//          System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, huespedes.getPrecio());
            stmt.setString(2, huespedes.getPiso());
            stmt.setString(3, huespedes.getEstado());
            stmt.setString(4, huespedes.getLimpieza());
            stmt.setString(5, huespedes.getTipo());
            stmt.setString(6, huespedes.getCantidad());
            stmt.setString(7, huespedes.getId());            

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public List<Habitaciones> select() {

        String SQL_SELECT = "SELECT * FROM tbl_mantenimiento_habitaciones WHERE PK_id_habitacion LIKE '%"+codigoAuxiliar+"%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Habitaciones huespedes = null;
        List<Habitaciones> huesped = new ArrayList<Habitaciones>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_id_habitacion");
                String precio = rs.getString("precio_habitacion");
                String piso = rs.getString("piso_habitaciones");
                String estado = rs.getString("estado_habitacion");
                String limpieza = rs.getString("estado_limpieza");
                String tipo = rs.getString("tipo_de_habitacion");
                String cantidad = rs.getString("cantidad_maxima_pers");
                huespedes = new Habitaciones();
                huespedes.setId(id);
                huespedes.setPrecio(precio);
                huespedes.setPiso(piso);
                huespedes.setEstado(estado);
                huespedes.setLimpieza(limpieza);
                huespedes.setTipo(tipo);
                huespedes.setCantidad(cantidad);

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
    
    public Habitaciones query(Habitaciones huespedes) {
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
                String id = rs.getString("PK_id_habitacion");
                String precio = rs.getString("precio_habitacion");
                String piso = rs.getString("piso_habitaciones");
                String estado = rs.getString("estado_habitacion");
                String limpieza = rs.getString("estado_limpieza");
                String tipo = rs.getString("tipo_de_habitacion");
                String cantidad = rs.getString("cantidad_maxima_pers");
                
                huespedes = new Habitaciones();
                huespedes.setId(id);
                huespedes.setPrecio(precio);
                huespedes.setPiso(piso);
                huespedes.setEstado(estado);
                huespedes.setLimpieza(limpieza);
                huespedes.setTipo(tipo);
                huespedes.setCantidad(cantidad);
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
    
    public int delete(Habitaciones huespedes) {
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
