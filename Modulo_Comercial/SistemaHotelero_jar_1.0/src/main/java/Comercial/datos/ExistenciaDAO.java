/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;

import Comercial.dominio.Existencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Diana
 */
public class ExistenciaDAO {

    private static final String SQL_SELECT = "SELECT Pk_codigo_producto, Pk_codigo_bodega, "
            + "cantidad_existencia, fecha_entrada_existencia, fecha_salida_existencia, estatus_existencia"
            + " FROM tbl_existencia";

    private static final String SQL_INSERT = "INSERT INTO tbl_existencia (Pk_codigo_producto, Pk_codigo_bodega, "
            + "cantidad_existencia, fecha_entrada_existencia, fecha_salida_existencia, estatus_existencia) "
            + "VALUES(?,?,?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE tbl_existencia SET Pk_codigo_bodega=?, "
            + "cantidad_existencia=?, fecha_entrada_existencia=?, fecha_salida_existencia=?, estatus_existencia=?"
            + " WHERE PK_codigo_producto=?";

    private static final String SQL_QUERY = "SELECT  Pk_codigo_producto, Pk_codigo_bodega, "
            + "cantidad_existencia, fecha_entrada_existencia, fecha_salida_existencia, estatus_existencia"
            + " FROM tbl_existencia WHERE PK_codigo_producto=?";

    private static final String SQL_DELETE = "DELETE FROM tbl_existencia WHERE PK_codigo_producto=?";

    public List<Existencia> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Existencia existencia = null;
        List<Existencia> existencias = new ArrayList<Existencia>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String Pk_codigo_producto = rs.getString("Pk_codigo_producto");
                String Pk_codigo_bodega = rs.getString("Pk_codigo_bodega");
                String cantidad_existencia = rs.getString("cantidad_existencia");
                String fecha_entrada_existencia = rs.getString("fecha_entrada_existencia");
                String fecha_salida_existencia = rs.getString("fecha_salida_existencia");
                String estatus_existencia = rs.getString("estatus_existencia");

                existencia = new Existencia();
                existencia.setPk_codigo_producto(Pk_codigo_producto);
                existencia.setPk_codigo_bodega(Pk_codigo_bodega);
                existencia.setCantidad_existencia(cantidad_existencia);
                existencia.setFecha_entrada_existencia(fecha_entrada_existencia);
                existencia.setFecha_salida_existencia(fecha_salida_existencia);
                existencia.setEstatus_existencia(estatus_existencia);

                existencias.add(existencia);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return existencias;
    }

    public int insert(Existencia existencia) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, existencia.getPk_codigo_producto());
            stmt.setString(2, existencia.getPk_codigo_bodega());
            stmt.setString(3, existencia.getCantidad_existencia());
            stmt.setString(4, existencia.getFecha_entrada_existencia());
            stmt.setString(5, existencia.getFecha_salida_existencia());
            stmt.setString(6, existencia.getEstatus_existencia());

            //System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Existencia existencia) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, existencia.getPk_codigo_bodega());
            stmt.setString(2, existencia.getCantidad_existencia());
            stmt.setString(3, existencia.getFecha_entrada_existencia());
            stmt.setString(4, existencia.getFecha_salida_existencia());
            stmt.setString(5, existencia.getEstatus_existencia());
            stmt.setString(6, existencia.getPk_codigo_producto());

            rows = stmt.executeUpdate();
            //System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public Existencia query(Existencia existencia) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Existencia> existencias = new ArrayList<Existencia>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, existencia.getPk_codigo_producto());
            rs = stmt.executeQuery();

            while (rs.next()) {
                String Pk_codigo_producto = rs.getString("Pk_codigo_producto");
                String Pk_codigo_bodega = rs.getString("Pk_codigo_bodega");
                String cantidad_existencia = rs.getString("cantidad_existencia");
                String fecha_entrada_existencia = rs.getString("fecha_entrada_existencia");
                String fecha_salida_existencia = rs.getString("fecha_salida_existencia");
                String estatus_existencia = rs.getString("estatus_existencia");

                existencia = new Existencia();
                existencia.setPk_codigo_producto(Pk_codigo_producto);
                existencia.setPk_codigo_bodega(Pk_codigo_bodega);
                existencia.setCantidad_existencia(cantidad_existencia);
                existencia.setFecha_entrada_existencia(fecha_entrada_existencia);
                existencia.setFecha_salida_existencia(fecha_salida_existencia);
                existencia.setEstatus_existencia(estatus_existencia);

                //empleados.add(empleado); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + empleado);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return empleados;  // Si se utiliza un ArrayList
        return existencia;
    }

    public int delete(Existencia existencia) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, existencia.getPk_codigo_producto());
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
