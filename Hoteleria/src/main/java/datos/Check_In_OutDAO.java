/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Check_In_Out;
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
public class Check_In_OutDAO {
    public static String codigoAuxiliar;
    private static final String SQL_INSERT = "insert into tbl_check_in_out values(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_check_in_out SET PK_id_reservacion=?, validacion_entrada=?, validacion_salida=?, id_tarifa=?, id_habitacion=?, estado=? WHERE PK_correlativo=?";
    private static final String SQL_QUERY = "SELECT PK_correlativo, PK_id_reservacion, validacion_entrada, validacion_salida, id_tarifa, id_habitacion, estado FROM tbl_check_in_out WHERE PK_correlativo = ?";
    private static final String SQL_DELETE = "delete from tbl_check_in_out where PK_correlativo = ?";
    
    public int insert(Check_In_Out huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, huespedes.getCorrelativo());
            stmt.setString(2, huespedes.getReservacion());
            stmt.setString(3, huespedes.getEntrada());
            stmt.setString(4, huespedes.getSalida());
            stmt.setString(5, huespedes.getTarifa());
            stmt.setString(6, huespedes.getEstado());

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
    
    public int update(Check_In_Out huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//          System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(6, huespedes.getCorrelativo());
            stmt.setString(1, huespedes.getReservacion());
            stmt.setString(2, huespedes.getEntrada());
            stmt.setString(3, huespedes.getSalida());
            stmt.setString(4, huespedes.getTarifa());
            stmt.setString(5, huespedes.getEstado());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public List<Check_In_Out> select() {

        String SQL_SELECT = "SELECT * FROM tbl_check_in_out WHERE PK_correlativo LIKE '%"+codigoAuxiliar+"%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Check_In_Out huespedes = null;
        List<Check_In_Out> huesped = new ArrayList<Check_In_Out>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String correlativo = rs.getString("PK_correlativo");
                String reservacion = rs.getString("PK_id_reservacion");
                String entrada = rs.getString("validacion_entrada");
                String salida = rs.getString("validacion_salida");
                String tarifa = rs.getString("id_tarifa");
                String estado = rs.getString("estado");
                huespedes = new Check_In_Out();
                huespedes.setCorrelativo(correlativo);
                huespedes.setReservacion(reservacion);
                huespedes.setEntrada(entrada);
                huespedes.setSalida(salida);
                huespedes.setTarifa(tarifa);
                huespedes.setEstado(estado);

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
    
    public Check_In_Out query(Check_In_Out huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, huespedes.getCorrelativo());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String correlativo = rs.getString("PK_correlativo");
                String reservacion = rs.getString("PK_id_reservacion");
                String entrada = rs.getString("validacion_entrada");
                String salida = rs.getString("validacion_salida");
                String tarifa = rs.getString("id_tarifa");
                String estado = rs.getString("estado");
                huespedes = new Check_In_Out();
                huespedes.setCorrelativo(correlativo);
                huespedes.setReservacion(reservacion);
                huespedes.setEntrada(entrada);
                huespedes.setSalida(salida);
                huespedes.setTarifa(tarifa);
                huespedes.setEstado(estado);
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
    
    public int delete(Check_In_Out huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, huespedes.getCorrelativo());
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
