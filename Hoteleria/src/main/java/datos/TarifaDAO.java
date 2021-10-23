/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Tarifa;
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
public class TarifaDAO {
    public static String codigoAuxiliar, nombreAuxiliar;
    private static final String SQL_INSERT = "insert into tbl_tarifa values(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_tarifa SET id_habitacion_tarifa=?, nombre_tarifa=?, estado_tarifa=? WHERE PK_id_tarifa=?";
    private static final String SQL_QUERY = "SELECT PK_id_tarifa, id_habitacion_tarifa, nombre_tarifa, estado_tarifa FROM tbl_tarifa WHERE PK_id_tarifa = ?";
    private static final String SQL_DELETE = "delete from tbl_tarifa where PK_id_tarifa = ?";

    public int insert(Tarifa tarifa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, tarifa.getId_tarifa());
            stmt.setString(2, tarifa.getId_habitacion());
            stmt.setString(3, tarifa.getNombre());
            stmt.setString(4, tarifa.getEstado());

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

    public int update(Tarifa tarifa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//          System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, tarifa.getId_habitacion());
            stmt.setString(2, tarifa.getNombre());
            stmt.setString(3, tarifa.getEstado());
            stmt.setString(4, tarifa.getId_tarifa());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public List<Tarifa> select() {

        String SQL_SELECT = "SELECT * FROM tbl_tarifa WHERE PK_id_tarifa LIKE '%"+codigoAuxiliar+"%' OR nombre_tarifa LIKE '%"+nombreAuxiliar+"%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tarifa tarifa = null;
        List<Tarifa> tarifas=  new ArrayList<Tarifa>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id_tarifa = rs.getString("PK_id_tarifa");
                String id_habitacion = rs.getString("id_habitacion_tarifa");
                String nombre = rs.getString("nombre_tarifa");
                String estado = rs.getString("estado_tarifa");

                tarifa = new Tarifa();
                tarifa.setId_tarifa(id_tarifa);
                tarifa.setId_habitacion(id_habitacion);
                tarifa.setNombre(nombre);
                tarifa.setEstado(estado);
                tarifas.add(tarifa);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return tarifas;
    }

    public Tarifa query(Tarifa tarifa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, tarifa.getId_tarifa());
            rs = stmt.executeQuery();
            while (rs.next()) {                
                String id_tarifa = rs.getString("PK_id_tarifa");
                String id_habitacion = rs.getString("id_habitacion_tarifa");
                String nombre = rs.getString("nombre_tarifa");
                String estado = rs.getString("estado_tarifa");


                tarifa = new Tarifa();
                tarifa.setId_tarifa(id_tarifa);
                tarifa.setId_habitacion(id_habitacion);
                tarifa.setNombre(nombre);
                tarifa.setEstado(estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return tarifa;
    }

    public int delete(Tarifa tarifa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, tarifa.getId_tarifa());
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
