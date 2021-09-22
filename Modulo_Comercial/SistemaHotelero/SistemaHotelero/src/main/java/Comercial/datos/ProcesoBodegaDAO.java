/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;

import static Comercial.datos.ProductoDAO.SQL_QUERY2;
import Comercial.dominio.Bodega;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Diana
 */
public class ProcesoBodegaDAO {

    private static final String SQL_SELECT = "SELECT PK_id_procesobodega, nombre_producto, descripcion_producto, fechaIngreso, fechaSalida FROM tbl_proceso_bodega";
    private static final String SQL_INSERT = "INSERT INTO tbl_proceso_bodega (PK_id_procesobodega, nombre_producto, descripcion_producto, fechaIngreso, fechaSalida) VALUES(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_proceso_bodega SET   nombre_producto= ?, descripcion_producto= ?, fechaIngreso= ?, fechaSalida=? WHERE PK_id_procesobodega= ?";
    private static final String SQL_QUERY = "SELECT PK_id_procesobodega, nombre_producto, descripcion_producto, fechaIngreso, fechaSalida FROM tbl_proceso_bodega WHERE PK_id_procesobodega=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_proceso_bodega WHERE PK_id_procesobodega=?";
    public static final String SQL_QUERY3 = "SELECT  PK_id_producto  FROM tbl_producto";

    public List<Bodega> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Bodega bodega = null;
        List<Bodega> bodegas = new ArrayList<Bodega>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int PK_id_bodega = rs.getInt("PK_id_bodega");
                String nombre_bodega = rs.getString("nombre_bodega");
                String direccion = rs.getString("direccion");
                String codigo_almacen = rs.getString("codigo_almacen");

                bodega = new Bodega();
                bodega.setPK_id_bodega(PK_id_bodega);
                bodega.setNombre_bodega(nombre_bodega);
               // bodega.setDireccion(direccion);
                bodega.setCodigo_almacen(codigo_almacen);

                bodegas.add(bodega);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return bodegas;
    }

    public int insert(Bodega bodega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, bodega.getPK_id_bodega());
            stmt.setString(2, bodega.getNombre_bodega());
//            stmt.setString(3, bodega.getDireccion());
            stmt.setString(4, bodega.getCodigo_almacen());

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

    public int update(Bodega bodega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, bodega.getPK_id_bodega());
            stmt.setString(2, bodega.getNombre_bodega());
//            stmt.setString(3, bodega.getDireccion());
            stmt.setString(4, bodega.getCodigo_almacen());

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

    public Bodega query(Bodega bodega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Bodega> bodegas = new ArrayList<Bodega>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, bodega.getPK_id_bodega());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int getPK_id_bodega = rs.getInt("getPK_id_bodega");
                String nombre_bodega = rs.getString("nombre_bodega");
                String direccion = rs.getString("direccion");
                String codigo_almacen = rs.getString("codigo_almacen");

                bodega = new Bodega();
                bodega.setNombre_bodega(nombre_bodega);
//                bodega.setDireccion(direccion);
                bodega.setCodigo_almacen(codigo_almacen);

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
        return bodega;
    }

    public int delete(Bodega bodega) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, bodega.getPK_id_bodega());
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

    public void query3(JComboBox uno) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY2);
            //stmt.setInt(1, aplicacion.getId_ModuloCbx());
            rs = stmt.executeQuery();

            uno.addItem("Seleccionar...");

            while (rs.next()) {
                uno.addItem(rs.getInt("PK_id_producto"));

            }
            //System.out.println("Registros buscado:" + aplicacion);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

    }
}
