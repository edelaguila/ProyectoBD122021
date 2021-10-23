package Comercial.datos;

import Comercial.dominio.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PERSONAL
 */
public class VendedorDao {

    private static final String SQL_INSERT = "INSERT INTO tbl_vendedor(PK_codigo_vendedor,nombre_vendedor,estatus_vendedor) VALUES(?,?,?)";
    private static final String SQL_SELECT = "SELECT PK_codigo_vendedor,nombre_vendedor,estatus_vendedor FROM tbl_vendedor";
    private static final String SQL_QUERY = "SELECT PK_codigo_vendedor,nombre_vendedor,estatus_vendedor FROM tbl_vendedor WHERE PK_codigo_vendedor = ?";
    private static final String SQL_UPDATE = "UPDATE tbl_vendedor SET PK_codigo_vendedor= ? ,nombre_vendedor = ?,estatus_vendedor = ? WHERE PK_codigo_vendedor";
    private static final String SQL_DELETE = "DELETE FROM tbl_vendedor  WHERE PK_codigo_vendedor = ? ";
//      private static final String SQL_QUERY22 = "SELECT Id_cliente,cliente,Nit,telefono,Estatus_Cliente FROM tbl_vendedor WHERE cliente = ?";
//    private static final String SQL_QUERY3 = "SELECT nombre_producto,NuevaExistencia, FROM tbl_proceso_producto WHERE  nombre_producto =?";

    public List<Vendedor> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Vendedor venta = null;
        List<Vendedor> ventas = new ArrayList<Vendedor>();
        try {
            /**
             *
             * conecion con sql de selecccion
             */
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                /**
                 *
                 * busqueda de datos de la bitacocora en la de usuarios
                 */
                String codigo_Vendedor = rs.getString("PK_codigo_vendedor");
                String nombre_Vendedor = rs.getString("nombre_vendedor");
                String estatus_Vendedor = rs.getString("estatus_vendedor");

                /**
                 *
                 * concatenacionde de variables de de busqueda
                 */
                venta = new Vendedor();
                venta.setCodigo_Vendedor(codigo_Vendedor);
                venta.setNombre_Vendedor(nombre_Vendedor);

                venta.setEstatus_Vendedor(estatus_Vendedor);

                ventas.add(venta);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return ventas;

    }

    public Vendedor query(Vendedor venta) {
        /**
         *
         * conexion de base de datos
         */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Vendedor> ventas = new ArrayList<Vendedor>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, venta.getCodigo_Vendedor());

            rs = stmt.executeQuery();
            while (rs.next()) {

                String codigo_Vendedor = rs.getString("PK_codigo_vendedor");
                String nombre_Vendedor = rs.getString("nombre_vendedor");
                String estatus_Vendedor = rs.getString("estatus_vendedor");

                /**
                 *
                 * concatenacionde de variables de de busqueda
                 */
                venta = new Vendedor();
                venta.setCodigo_Vendedor(codigo_Vendedor);
                venta.setNombre_Vendedor(nombre_Vendedor);

                venta.setEstatus_Vendedor(estatus_Vendedor);

                ventas.add(venta);
                /**
                 *
                 * busqueda de datos de la bitacocora en la de usuarios
                 */

            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return venta;

    }

    public int insert(Vendedor insertar) {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;

        int rows = 0;
        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, insertar.getCodigo_Vendedor());
            stmt.setString(2, insertar.getNombre_Vendedor());
            stmt.setString(3, insertar.getEstatus_Vendedor());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Vendedor insertar) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, insertar.getCodigo_Vendedor());
            stmt.setString(2, insertar.getNombre_Vendedor());
            stmt.setString(3, insertar.getEstatus_Vendedor());

            rows = stmt.executeUpdate();

            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Vendedor eliminar) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt.setString(1, eliminar.getCodigo_Vendedor());

            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

}
