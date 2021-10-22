/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Piso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jefferson Dávila
 */
public class AsignacionServicioLimpiezaDAO {

    public static String codigoAuxiliar, nombreAuxiliar;
    private static final String SQL_INSERT = "insert into tbl_piso values(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_piso SET cantidad_habitaciones_piso=?, descripcion_piso=?, estado_piso=? WHERE PK_id_piso=?";
    private static final String SQL_QUERY = "SELECT PK_id_piso, cantidad_habitaciones_piso, descripcion_piso, estado_piso FROM tbl_piso WHERE PK_id_piso = ?";
    private static final String SQL_DELETE = "delete from tbl_piso where PK_id_piso = ?";

    public int insert(Piso piso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, piso.getIdPiso());
            stmt.setInt(2, piso.getCantidadHabitacionesPiso());
            stmt.setString(3, piso.getDescripcionPiso());
            stmt.setString(4, piso.getEstadoPiso());

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

    public int update(Piso piso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//          System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, piso.getCantidadHabitacionesPiso());
            stmt.setString(2, piso.getDescripcionPiso());
            stmt.setString(3, piso.getEstadoPiso());
            stmt.setInt(4, piso.getIdPiso());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public List<Piso> select() {

        String SQL_SELECT = "SELECT * FROM tbl_piso WHERE PK_id_piso LIKE '%"+codigoAuxiliar+"%' OR cantidad_habitaciones_piso LIKE '%"+nombreAuxiliar+"%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Piso piso = null;
        List<Piso> pisos = new ArrayList<Piso>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("PK_id_piso");
                int cantidad = rs.getInt("cantidad_habitaciones_piso");
                String descripcion = rs.getString("descripcion_piso");
                String estado = String.valueOf(rs.getInt("estado_piso"));

                piso = new Piso();
                piso.setIdPiso(id);
                piso.setCantidadHabitacionesPiso(cantidad);
                piso.setDescripcionPiso(descripcion);
                piso.setEstadoPiso(estado);
                
                pisos.add(piso);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return pisos;
    }

    public Piso query(Piso piso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, piso.getIdPiso());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("PK_id_piso");
                int cantidad = rs.getInt("cantidad_habitaciones_piso");
                String descripcion = rs.getString("descripcion_piso");
                String estado = String.valueOf(rs.getInt("estado_piso"));

                piso = new Piso();
                piso.setIdPiso(id);
                piso.setCantidadHabitacionesPiso(cantidad);
                piso.setDescripcionPiso(descripcion);
                piso.setEstadoPiso(estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return piso;
    }

    public int delete(Piso servicios) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, servicios.getIdPiso());
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
