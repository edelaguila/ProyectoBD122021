/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.ConsultaYRevisionLimpieza;
import dominio.ProcesosRepetidos;
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
public class ConsultaYRevisionLimpiezaDAO {

    ProcesosRepetidos llenar = new ProcesosRepetidos();
    public static String codigoAuxiliar;

    public List<ConsultaYRevisionLimpieza> selectAsignacionesAmaDeLlave() {

        String SQL_SELECT = "SELECT tbl_asignacion_gobernanta.PK_id_gobernanta as gobernanta, tbl_asignacion_limpieza.PK_id_piso as piso, tbl_asignacion_limpieza.PK_id_horario as horario FROM tbl_asignacion_limpieza INNER JOIN tbl_asignacion_gobernanta ON tbl_asignacion_limpieza.PK_id_asignacion_gobernanta = tbl_asignacion_gobernanta.PK_id_gobernanta WHERE tbl_asignacion_gobernanta.PK_id_ama_de_llave LIKE '%" + codigoAuxiliar + "%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ConsultaYRevisionLimpieza piso = null;
        List<ConsultaYRevisionLimpieza> pisos = new ArrayList<ConsultaYRevisionLimpieza>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String gobernanta = rs.getString("gobernanta");
                String pis = rs.getString("piso");
                String horario = rs.getString("horario");

                piso = new ConsultaYRevisionLimpieza();
                piso.setIdGobernanta(gobernanta);
                piso.setIdPiso(pis);
                piso.setIdHorario(horario);

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

    public List<ConsultaYRevisionLimpieza> selectHabitacionesAmaDeLlave() {

        String SQL_SELECT = "SELECT tbl_mantenimiento_habitacion.PK_id_habitacion as habitacion, tbl_mantenimiento_habitacion.estado_limpieza as limpieza, tbl_asignacion_limpieza.PK_id_horario as horario FROM tbl_mantenimiento_habitacion INNER JOIN tbl_asignacion_limpieza ON tbl_mantenimiento_habitacion.PK_id_piso = tbl_asignacion_limpieza.PK_id_piso INNER JOIN tbl_asignacion_gobernanta ON tbl_asignacion_limpieza.PK_id_asignacion_gobernanta = tbl_asignacion_gobernanta.PK_id_gobernanta WHERE tbl_asignacion_gobernanta.PK_id_ama_de_llave LIKE '%" + codigoAuxiliar + "%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ConsultaYRevisionLimpieza piso = null;
        List<ConsultaYRevisionLimpieza> pisos = new ArrayList<ConsultaYRevisionLimpieza>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String habitacion = rs.getString("habitacion");
                String limpieza = rs.getString("limpieza");
                String horario = rs.getString("horario");

                piso = new ConsultaYRevisionLimpieza();
                piso.setIdHabitacion(habitacion);
                piso.setLimpiezaHabitacion(limpieza);
                piso.setHorarioHabitacion(horario);

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

    public List<ConsultaYRevisionLimpieza> selectAsignacionesGobernanta() {
        String SQL_SELECT = "SELECT tbl_mantenimiento_habitacion.PK_id_piso, tbl_mantenimiento_habitacion.PK_id_habitacion, tbl_mantenimiento_habitacion.estado_limpieza, tbl_asignacion_limpieza.PK_id_horario FROM tbl_mantenimiento_habitacion INNER JOIN tbl_asignacion_limpieza ON tbl_mantenimiento_habitacion.PK_id_piso = tbl_asignacion_limpieza.PK_id_piso WHERE tbl_asignacion_limpieza.PK_id_asignacion_gobernanta='" + codigoAuxiliar + "'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ConsultaYRevisionLimpieza piso = null;
        List<ConsultaYRevisionLimpieza> pisos = new ArrayList<ConsultaYRevisionLimpieza>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String pis = rs.getString("PK_id_piso");
                String habitacion = rs.getString("PK_id_habitacion");
                String limpieza = rs.getString("estado_limpieza");
                String horario = rs.getString("PK_id_horario");

                piso = new ConsultaYRevisionLimpieza();
                piso.setPisoAsigGob(pis);
                piso.setHabitacionAsigGob(habitacion);
                piso.setLimpiezaAsigGob(limpieza);
                piso.setHorarioAsigGob(horario);

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
    
    public List<ConsultaYRevisionLimpieza> selectHabitacionesGobernanta() {
        String SQL_SELECT = "SELECT tbl_mantenimiento_habitacion.PK_id_habitacion, tbl_mantenimiento_habitacion.estado_habitacion, tbl_mantenimiento_habitacion.estado_limpieza, tbl_mantenimiento_habitacion.tipo_de_habitacion FROM tbl_mantenimiento_habitacion INNER JOIN tbl_asignacion_limpieza ON tbl_mantenimiento_habitacion.PK_id_piso = tbl_asignacion_limpieza.PK_id_piso WHERE tbl_asignacion_limpieza.PK_id_asignacion_gobernanta='" + codigoAuxiliar + "'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ConsultaYRevisionLimpieza piso = null;
        List<ConsultaYRevisionLimpieza> pisos = new ArrayList<ConsultaYRevisionLimpieza>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String habitacion = rs.getString("PK_id_habitacion");
                String estado = rs.getString("estado_habitacion");
                String limpieza = rs.getString("estado_limpieza");
                String tipo = rs.getString("tipo_de_habitacion");

                piso = new ConsultaYRevisionLimpieza();
                piso.setHabitacionHabGob(habitacion);
                piso.setEstadoHabGob(estado);
                piso.setLimpiezaHabGob(limpieza);
                piso.setTipoHabGob(tipo);

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
