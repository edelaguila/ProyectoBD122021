/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.AsignacionGobernanta;
import dominio.ProcesosRepetidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author Jefferson Dávila
 */
public class AsignacionGobernantaDAO {

    public static String codigoAuxiliar, nombreAuxiliar;
    private static final String SQL_INSERT = "insert into tbl_asignacion_gobernanta values(?,?,?,?)";
    private static final String SQL_SELECT_LLAVE = "SELECT empresarial.tbl_empleado.PK_id_empleado as ID, empresarial.tbl_empleado.nombre_empleado as NOMBRE FROM tbl_empleado INNER JOIN tbl_puesto ON empresarial.tbl_empleado.puesto_empleado = empresarial.tbl_puesto.nombre_puesto WHERE empresarial.tbl_puesto.nombre_puesto='Ama de Llave' AND empresarial.tbl_empleado.estado_empleado='1'";
    private static final String SQL_UPDATE = "UPDATE tbl_asignacion_gobernanta SET PK_id_gobernanta=?, PK_id_ama_de_llave=?, estado_asignacion_gobernanta=? WHERE PK_id_asignacion_gobernanta=?";
    private static final String SQL_DELETE = "delete from tbl_asignacion_gobernanta where PK_id_asignacion_gobernanta = ?";
    private static final String SQL_QUERY = "select PK_id_empleado, concat(nombre_empleado,' ',apellido_empleado) AS nombreCompleto, estado_empleado from tbl_empleado where puesto_empleado='Gobernanta' and estado_empleado='1'";
    private static final String SQL_QUERY_GOBERNANTA = "select PK_id_empleado from tbl_empleado where puesto_empleado='Gobernanta' and estado_empleado='1'";
    private static final String SQL_PK = "PK_id_empleado";
    private static final String SQL_QUERY_LLAVE = "select PK_id_empleado from tbl_empleado where puesto_empleado='Ama de Llave' and estado_empleado='1'";
    private static final String SQL_PK2 = "PK_id_empleado";

    public List<AsignacionGobernanta> select() {

        String SQL_SELECT = "SELECT * FROM tbl_asignacion_gobernanta WHERE PK_id_asignacion_gobernanta LIKE '%" + codigoAuxiliar + "%' OR PK_id_gobernanta LIKE '%" + nombreAuxiliar + "%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AsignacionGobernanta piso = null;
        List<AsignacionGobernanta> pisos = new ArrayList<AsignacionGobernanta>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_id_asignacion_gobernanta");
                String gobernanta = rs.getString("PK_id_gobernanta");
                String amaDeLlave = rs.getString("PK_id_ama_de_llave");
                String estado = rs.getString("estado_asignacion_gobernanta");

                piso = new AsignacionGobernanta();
                piso.setIdAsignacionGobernanta(id);
                piso.setIdGobernanta(gobernanta);
                piso.setIdAmaDeLlave(amaDeLlave);
                piso.setEstadoAsignacionGobernanta(estado);

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

    public List<AsignacionGobernanta> selectAmaDeLlave() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AsignacionGobernanta piso = null;
        List<AsignacionGobernanta> pisos = new ArrayList<AsignacionGobernanta>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_LLAVE);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("ID");
                String nombre = rs.getString("NOMBRE");

                piso = new AsignacionGobernanta();
                piso.setIdAmaDeLlave(id);
                piso.setNombreAmaDeLlave(nombre);

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

    ProcesosRepetidos llenar = new ProcesosRepetidos();

    public void llenarCbx(JComboBox cbxModulo) {
        llenar.llenarCbx(SQL_QUERY_GOBERNANTA, SQL_PK, cbxModulo);
    }

    public void llenarCbx2(JComboBox cbxModulo) {
        llenar.llenarCbx(SQL_QUERY_LLAVE, SQL_PK2, cbxModulo);
    }

    public int insert(AsignacionGobernanta asignacionGobernanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, "0");
            stmt.setString(2, asignacionGobernanta.getIdGobernanta());
            stmt.setString(3, asignacionGobernanta.getIdAmaDeLlave());
            stmt.setString(4, asignacionGobernanta.getEstadoAsignacionGobernanta());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int update(AsignacionGobernanta asignacionGobernanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, asignacionGobernanta.getIdGobernanta());
            stmt.setString(2, asignacionGobernanta.getIdAmaDeLlave());
            stmt.setString(3, asignacionGobernanta.getEstadoAsignacionGobernanta());
            stmt.setString(4, asignacionGobernanta.getIdAsignacionGobernanta());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(AsignacionGobernanta asignacionGobernanta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, asignacionGobernanta.getIdAsignacionGobernanta());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public List<AsignacionGobernanta> selectGobernanta() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AsignacionGobernanta piso = null;
        List<AsignacionGobernanta> pisos = new ArrayList<AsignacionGobernanta>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_id_empleado");
                String nombre = rs.getString("nombreCompleto");
                String estado = rs.getString("estado_empleado");

                piso = new AsignacionGobernanta();
                piso.setIdGobernanta(id);
                piso.setNombreGobernanta(nombre);
                piso.setEstadoGobernanta(estado);

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
}
