/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.AsignacionLimpieza;
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
public class AsignacionLimpiezaDAO {

    public static String codigoAuxiliar, nombreAuxiliar;
    private static final String SQL_QUERY_GOBERNANTA = "select PK_id_empleado from tbl_empleado where puesto_empleado='1' and estado_empleado='1'";
    private static final String SQL_PK = "PK_id_empleado";
    private static final String SQL_QUERY_PISO = "select PK_id_piso from tbl_piso where estado_piso='1'";
    private static final String SQL_PK2 = "PK_id_piso";
    private static final String SQL_QUERY_HORARIO = "select PK_id_horario from tbl_horario where estado_horario='1'";
    private static final String SQL_PK3 = "PK_id_horario";
    private static final String SQL_INSERT = "insert into tbl_asignacion_limpieza values(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_asignacion_limpieza SET PK_id_asignacion_gobernanta=?, PK_id_piso=?, PK_id_horario=?, estado_asignacion_limpieza=? WHERE PK_id_asignacion_limpieza=?";
    private static final String SQL_DELETE = "delete from tbl_asignacion_limpieza where PK_id_asignacion_limpieza = ?";

    public List<AsignacionLimpieza> select() {

        String SQL_SELECT = "SELECT * FROM tbl_asignacion_limpieza WHERE PK_id_asignacion_limpieza LIKE '%" + codigoAuxiliar + "%' OR PK_id_asignacion_gobernanta LIKE '%" + nombreAuxiliar + "%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AsignacionLimpieza piso = null;
        List<AsignacionLimpieza> pisos = new ArrayList<AsignacionLimpieza>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_id_asignacion_limpieza");
                String gobernanta = rs.getString("PK_id_asignacion_gobernanta");
                String pis = rs.getString("PK_id_piso");
                String horario = rs.getString("PK_id_horario");
                String estado = rs.getString("estado_asignacion_limpieza");

                piso = new AsignacionLimpieza();
                piso.setIdAsignacionLimpieza(id);
                piso.setIdAsignacionGobernanta(gobernanta);
                piso.setIdPiso(pis);
                piso.setIdHorario(horario);
                piso.setEstadoAsignacionLimpieza(estado);

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

    public void llenarCbxGobernanta(JComboBox cbxModulo) {
        llenar.llenarCbx(SQL_QUERY_GOBERNANTA, SQL_PK, cbxModulo);
    }

    public void llenarCbxPiso(JComboBox cbxModulo) {
        llenar.llenarCbx(SQL_QUERY_PISO, SQL_PK2, cbxModulo);
    }
    
    public void llenarCbxHorario(JComboBox cbxModulo) {
        llenar.llenarCbx(SQL_QUERY_HORARIO, SQL_PK3, cbxModulo);
    }
    
    public int insert(AsignacionLimpieza asignacionLimpieza) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, "0");
            stmt.setString(2, asignacionLimpieza.getIdAsignacionGobernanta());
            stmt.setString(3, asignacionLimpieza.getIdPiso());
            stmt.setString(4, asignacionLimpieza.getIdHorario());
            stmt.setString(5, asignacionLimpieza.getEstadoAsignacionLimpieza());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public int update(AsignacionLimpieza asignacionLimpieza) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, asignacionLimpieza.getIdAsignacionGobernanta());
            stmt.setString(2, asignacionLimpieza.getIdPiso());
            stmt.setString(3, asignacionLimpieza.getIdHorario());
            stmt.setString(4, asignacionLimpieza.getEstadoAsignacionLimpieza());
            stmt.setString(5, asignacionLimpieza.getIdAsignacionLimpieza());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public int delete(AsignacionLimpieza asignacionLimpieza) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, asignacionLimpieza.getIdAsignacionLimpieza());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
}
