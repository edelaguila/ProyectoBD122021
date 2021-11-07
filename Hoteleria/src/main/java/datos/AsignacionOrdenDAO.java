/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.OrdenRestaurante;
import dominio.ProcesosRepetidos;
import java.sql.CallableStatement;
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
public class AsignacionOrdenDAO {

    public static String codigoAuxiliar, nombreAuxiliar;
    public static String validacionOrden;

    private static final String SQL_INSERT = "insert into tbl_menu_orden values(?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_asignacion_gobernanta SET PK_id_gobernanta=?, PK_id_ama_de_llave=?, estado_asignacion_gobernanta=? WHERE PK_id_asignacion_gobernanta=?";
    private static final String SQL_DELETE = "delete from tbl_asignacion_gobernanta where PK_id_asignacion_gobernanta = ?";

    ProcesosRepetidos llenar = new ProcesosRepetidos();
    
//    public OrdenRestaurante getProcesoAlmacenado(OrdenRestaurante ordenRestaurante){
//        Connection conn = null;
//        CallableStatement stmt = null;
//        int rows = 0;
//        try {
//            conn = Conexion.getConnection();
//            String sql = "{call insertarMenuEncabezado (?, ?, ?, ?)}";
//            stmt = conn.prepareCall(sql);
//            
//            stmt.setString(1, ordenRestaurante.getIdHabitacion());
//            stmt.setString(2, ordenRestaurante.getMesaOrden());
//            stmt.setString(3, ordenRestaurante.getFechaOrden());
//            stmt.setString(4, ordenRestaurante.getHoraOrden());
//            
//            rows = stmt.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        } finally {
//            Conexion.close(stmt);
//            Conexion.close(conn);
//        }
//        return rows;
//    }

//    public List<OrdenRestaurante> select() {

//        String SQL_SELECT = "SELECT * FROM tbl_menu_orden WHERE PK_id_orden LIKE '%" + codigoAuxiliar + "%' OR PK_id_habitacion LIKE '%" + nombreAuxiliar + "%'";
//
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        OrdenRestaurante restaurante = null;
//        List<OrdenRestaurante> restaurantes = new ArrayList<OrdenRestaurante>();
//
//        try {
//            conn = Conexion.getConnection();
//            stmt = conn.prepareStatement(SQL_SELECT);
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                String id = rs.getString("PK_id_orden");
//                String menu = rs.getString("PK_id_menu");
//                String habitacion = rs.getString("PK_id_habitacion");
//                String cantidad = rs.getString("cantidad_orden");
//                String mesa = rs.getString("no_mesa");
//                String horario = rs.getString("horario_orden");
//                String fecha = rs.getString("fecha_orden");
//                String total = rs.getString("total_orden");
//
//                restaurante = new OrdenRestaurante();
//                restaurante.setIdOrden(id);
//                restaurante.setIdMenu(menu);
//                restaurante.setIdHabitacion(habitacion);
//                restaurante.setCantidadOrden(cantidad);
//                restaurante.setMesaOrden(mesa);
//                restaurante.setHoraOrden(horario);
//                restaurante.setFechaOrden(fecha);
//                restaurante.setTotalOrden(total);
//
//                restaurantes.add(restaurante);
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        } finally {
//            Conexion.close(rs);
//            Conexion.close(stmt);
//            Conexion.close(conn);
//        }
//
//        return restaurantes;
//    }

//    public int insert(OrdenRestaurante ordenRestaurante) {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        int rows = 0;
//        try {
//            conn = Conexion.getConnection();
//            stmt = conn.prepareStatement(SQL_INSERT);
//            stmt.setString(1, "0");
//            stmt.setString(2, ordenRestaurante.getIdMenu());
//            stmt.setString(3, ordenRestaurante.getIdHabitacion());
//            stmt.setString(4, ordenRestaurante.getCantidadOrden());
//            stmt.setString(5, ordenRestaurante.getMesaOrden());
//            stmt.setString(6, ordenRestaurante.getHoraOrden());
//            stmt.setString(7, ordenRestaurante.getFechaOrden());
//            stmt.setString(8, ordenRestaurante.getTotalOrden());
//            rows = stmt.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        } finally {
//            Conexion.close(stmt);
//            Conexion.close(conn);
//        }
//        return rows;
//    }
    
//    public int update(OrdenRestaurante ordenRestaurante) {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        int rows = 0;
//
//        try {
//            conn = Conexion.getConnection();
//
//            stmt = conn.prepareStatement(SQL_UPDATE);
//            stmt.setString(1, asignacionGobernanta.getIdGobernanta());
//            stmt.setString(2, asignacionGobernanta.getIdAmaDeLlave());
//            stmt.setString(3, asignacionGobernanta.getEstadoAsignacionGobernanta());
//            stmt.setString(4, asignacionGobernanta.getIdAsignacionGobernanta());
//
//            rows = stmt.executeUpdate();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        } finally {
//            Conexion.close(stmt);
//            Conexion.close(conn);
//        }
//
//        return rows;
//    }

//    public int delete(OrdenRestaurante ordenRestaurante) {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        int rows = 0;
//        try {
//            conn = Conexion.getConnection();
//            stmt = conn.prepareStatement(SQL_DELETE);
//            stmt.setString(1, asignacionGobernanta.getIdAsignacionGobernanta());
//            rows = stmt.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        } finally {
//            Conexion.close(stmt);
//            Conexion.close(conn);
//        }
//
//        return rows;
//    }
}
