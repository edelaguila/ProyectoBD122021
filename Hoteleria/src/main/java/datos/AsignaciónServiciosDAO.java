/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.AsignaciónServicios;
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
public class AsignaciónServiciosDAO {
    private static final String SQL_INSERT = "insert into tbl_paquete_servicios values(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_paquete_servicios SET id_tarifa_paquete=?, id_servicio_paquete=? WHERE PK_correlativo_paquete=?";
    private static final String SQL_QUERY = "SELECT * FROM tbl_paquete_servicios WHERE id_tarifa_paquete=?";
    private static final String SQL_DELETE = "delete from tbl_paquete_servicios where PK_correlativo_paquete = ?";
    private static final String SQL_SELECT = "SELECT * FROM tbl_paquete_servicios";
    public int insert(AsignaciónServicios asignacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, asignacion.getCorrelativo());
            stmt.setString(2, asignacion.getId_tarifa());
            stmt.setString(3, asignacion.getId_servicio());

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

    public int update(AsignaciónServicios asignacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//          System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(4, asignacion.getId_tarifa());
            stmt.setString(4, asignacion.getId_servicio());
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

    public List<AsignaciónServicios> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AsignaciónServicios asignacion = null;
        List<AsignaciónServicios> asiganaciones=  new ArrayList<AsignaciónServicios>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String correlativo = rs.getString("PK_correlativo_paquete");
                String id_tarifa = rs.getString("id_tarifa_paquete");
                String id_servicio = rs.getString("id_servicio_paquete");

                asignacion = new AsignaciónServicios();
                asignacion.setCorrelativo(correlativo);
                asignacion.setId_tarifa(id_tarifa);
                asignacion.setId_servicio(id_servicio);
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

    public AsignaciónServicios query(AsignaciónServicios asignacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, asignacion.getId_tarifa());
            stmt.setString(2, asignacion.getId_servicio());
            rs = stmt.executeQuery();
            while (rs.next()) {                
                String correlativo = rs.getString("PK_correlativo_paquete");
                String id_tarifa = rs.getString("id_tarifa_paquete");
                String id_servicio = rs.getString("id_servicio_paquete");

                asignacion = new AsignaciónServicios();
                asignacion.setCorrelativo(correlativo);
                asignacion.setId_tarifa(id_tarifa);
                asignacion.setId_tarifa(id_servicio);
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

    public int delete(AsignaciónServicios asignacion) {
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
