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

    private static final String SQL_INSERT = "insert into tbl_menu_orden_encabezado values(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_menu_orden_encabezado SET id_habitacion=?, mesa_orden=?, fecha_orden=?, horario_orden=? WHERE PK_id_orden_encabezado=?";

    ProcesosRepetidos llenar = new ProcesosRepetidos();

    public int insert(OrdenRestaurante ordenRestaurante) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, "0");
            stmt.setString(2, ordenRestaurante.getIdHabitacion());
            stmt.setString(3, ordenRestaurante.getMesaOrden());
            stmt.setString(4, ordenRestaurante.getFechaOrden());
            stmt.setString(5, ordenRestaurante.getHoraOrden());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public List<OrdenRestaurante> select() {

        String SQL_SELECT = "SELECT * FROM tbl_menu_orden_encabezado WHERE PK_id_orden_encabezado LIKE '%" + codigoAuxiliar + "%' OR id_habitacion LIKE '%" + nombreAuxiliar + "%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        OrdenRestaurante restaurante = null;
        List<OrdenRestaurante> restaurantes = new ArrayList<OrdenRestaurante>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_id_orden_encabezado");
                String habitacion = rs.getString("id_habitacion");
                String mesa = rs.getString("mesa_orden");
                String fecha = rs.getString("fecha_orden");
                String hora = rs.getString("horario_orden");

                restaurante = new OrdenRestaurante();
                restaurante.setIdEncabezado(id);
                restaurante.setIdHabitacion(habitacion);
                restaurante.setMesaOrden(mesa);
                restaurante.setFechaOrden(fecha);
                restaurante.setHoraOrden(hora);

                restaurantes.add(restaurante);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return restaurantes;
    }

    public int update(OrdenRestaurante ordenRestaurante) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, ordenRestaurante.getIdHabitacion());
            stmt.setString(2, ordenRestaurante.getMesaOrden());
            stmt.setString(3, ordenRestaurante.getFechaOrden());
            stmt.setString(4, ordenRestaurante.getHoraOrden());
            stmt.setString(5, ordenRestaurante.getIdEncabezado());

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
