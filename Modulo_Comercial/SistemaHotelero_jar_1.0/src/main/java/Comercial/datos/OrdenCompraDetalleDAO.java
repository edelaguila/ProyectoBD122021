/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;

import Comercial.dominio.OrdenCompraDetalle;
import Comercial.datos.Conexion;
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
 * @author SipaqueRitaMaria
 */
public class OrdenCompraDetalleDAO {

    private static final String SQL_SELECT = "SELECT correlativo, PK_codigo_ordencompra, PK_codigo_producto, PK_codigo_bodega, cantidad_detalle, costo_detalle, total_detalle FROM tbl_ordencompra_detalle";
    private static final String SQL_INSERT = "INSERT INTO tbl_ordencompra_detalle (correlativo, PK_codigo_ordencompra, PK_codigo_producto, PK_codigo_bodega, cantidad_detalle, costo_detalle, total_detalle) VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_ordencompra_detalle SET  PK_codigo_ordencompra=?, PK_codigo_producto=?, PK_codigo_bodega=?, cantidad_detalle=?, costo_detalle=?, total_detalle=?     WHERE correlativo=?";
    private static final String SQL_QUERY = "SELECT correlativo, PK_codigo_ordencompra, PK_codigo_producto, PK_codigo_bodega, cantidad_detalle, costo_detalle, total_detalle FROM tbl_ordencompra_detalle WHERE correlativo=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_ordencompra_detalle WHERE correlativo=?";

    public List<OrdenCompraDetalle> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        OrdenCompraDetalle proveedor = null;
        List<OrdenCompraDetalle> proveedores = new ArrayList<OrdenCompraDetalle>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int correlativo = rs.getInt("correlativo");
                int PK_codigo_factura = rs.getInt("PK_codigo_ordencompra");
                String PK_codigo_producto = rs.getString("PK_codigo_producto");
                String PK_Codigo_Bodega = rs.getString("PK_codigo_bodega");
                String Cantidad_Detalle = rs.getString("cantidad_detalle");
                String Costo_Detalle = rs.getString("costo_detalle");
                int Total_Detalle = rs.getInt("total_detalle");

                proveedor = new OrdenCompraDetalle();
                proveedor.setCorrelativo(correlativo);
                proveedor.setPK_Codigo_Ordencompra(PK_codigo_factura);
                proveedor.setPK_codigo_producto(PK_codigo_producto);
                proveedor.setPK_codigo_bodega(PK_Codigo_Bodega);
                proveedor.setCantidad_detalle(Cantidad_Detalle);
                proveedor.setCosto_detalle(Costo_Detalle);
                proveedor.setTotal_detalle(Total_Detalle);

                proveedores.add(proveedor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return proveedores;
    }

    public int insert(OrdenCompraDetalle proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, proveedor.getCorrelativo());
            stmt.setInt(2, proveedor.getPK_Codigo_Ordencompra());
            stmt.setString(3, proveedor.getPK_codigo_producto());
            stmt.setString(4, proveedor.getPK_codigo_bodega());
            stmt.setString(5, proveedor.getCantidad_detalle());
            stmt.setString(6, proveedor.getCosto_detalle());
            stmt.setInt(7, proveedor.getTotal_detalle());

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

    public OrdenCompraDetalle query(OrdenCompraDetalle proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);

            stmt.setInt(1, proveedor.getCorrelativo());
            rs = stmt.executeQuery();
            while (rs.next()) {

                int correlativo = rs.getInt("correlativo");
                int PK_codigo_factura = rs.getInt("PK_codigo_ordencompra");
                String PK_codigo_producto = rs.getString("PK_codigo_producto");
                String PK_Codigo_Bodega = rs.getString("PK_codigo_bodega");
                String Cantidad_Detalle = rs.getString("cantidad_detalle");
                String Costo_Detalle = rs.getString("costo_detalle");
                int Total_Detalle = rs.getInt("total_detalle");

                proveedor = new OrdenCompraDetalle();
                proveedor.setCorrelativo(correlativo);
                proveedor.setPK_Codigo_Ordencompra(PK_codigo_factura);
                proveedor.setPK_codigo_producto(PK_codigo_producto);
                proveedor.setPK_codigo_bodega(PK_Codigo_Bodega);
                proveedor.setCantidad_detalle(Cantidad_Detalle);
                proveedor.setCosto_detalle(Costo_Detalle);
                proveedor.setTotal_detalle(Total_Detalle);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return proveedor;
    }

    public int delete(OrdenCompraDetalle aplicacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, aplicacion.getCorrelativo());
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

    public int update(OrdenCompraDetalle proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setInt(1, proveedor.getPK_Codigo_Ordencompra());
            stmt.setString(2, proveedor.getPK_codigo_producto());
            stmt.setString(3, proveedor.getPK_codigo_bodega());
            stmt.setString(4, proveedor.getCantidad_detalle());
            stmt.setString(5, proveedor.getCosto_detalle());
            stmt.setInt(6, proveedor.getTotal_detalle());
            stmt.setInt(7, proveedor.getCorrelativo());

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

}
