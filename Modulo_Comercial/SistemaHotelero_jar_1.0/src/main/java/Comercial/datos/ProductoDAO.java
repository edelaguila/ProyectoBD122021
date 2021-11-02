/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;

import Comercial.dominio.Bodega;
import Comercial.dominio.Producto;
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
public class ProductoDAO {

    private static final String SQL_INSERT = "INSERT INTO tbl_producto(PK_codigo_producto, nombre_prodcuto,"
            + " descripcion_producto, precio_producto, costo_producto, estatus_producto,"
            + " codigo_linea, codigo_marca, codigo_bodega, codigo_unidad) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_SELECT = "SELECT PK_codigo_producto,nombre_prodcuto, descripcion_producto,"
            + " precio_producto, costo_producto, estatus_producto, "
            + "codigo_linea, codigo_marca, codigo_bodega, codigo_unidad FROM tbl_producto";
    private static final String SQL_QUERY = "SELECT PK_codigo_producto, nombre_prodcuto, descripcion_producto, "
            + "precio_producto, costo_producto, estatus_producto, "
            + "codigo_linea, codigo_marca, codigo_bodega, codigo_unidad FROM tbl_producto WHERE PK_codigo_producto = ?";
    private static final String SQL_UPDATE = "UPDATE tbl_producto SET PK_codigo_producto=?, nombre_prodcuto=?,"
            + " descripcion_producto=?, precio_producto=?, costo_producto=?, estatus_producto=?, "
            + "codigo_linea=?, codigo_marca=?, "
            + "codigo_bodega=?, codigo_unidad=?  WHERE PK_codigo_producto";
    private static final String SQL_DELETE = "DELETE FROM tbl_producto  WHERE PK_codigo_producto = ? ";

    public List<Producto> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Producto> productos = new ArrayList<Producto>();
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
                String codigoProducto = rs.getString("PK_codigo_producto");
//                String line = rs.getString("linea")
                String nombreProducto = rs.getString("nombre_prodcuto");
                String descripcionProducto = rs.getString("descripcion_producto");
                String precioProducto = rs.getString("precio_producto");
                String costoProducto = rs.getString("costo_producto");
                String estatusProducto = rs.getString("estatus_producto");
                String lineaProducto = rs.getString("codigo_linea");
                String marcaProducto = rs.getString("codigo_marca");
                String bodegaProducto = rs.getString("codigo_bodega");
                String unidadProducto = rs.getString("codigo_unidad");
                /**
                 *
                 * concatenacionde de variables de de busqueda
                 */
                producto = new Producto();
                producto.setPKcodigoProducto(codigoProducto);
//                producto.setLinea(line);
                producto.setNombreProducto(nombreProducto);
                producto.setDescripcionProducto(descripcionProducto);
                producto.setPrecioProducto(precioProducto);
                producto.setCostoProducto(costoProducto);
                producto.setEstatusProducto(estatusProducto);
                producto.setLineaProducto(lineaProducto);
                producto.setMarcaProducto(marcaProducto);
                producto.setBodegaProducto(bodegaProducto);
                producto.setUnidadProducto(unidadProducto);
                
                productos.add(producto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return productos;

    }

    public Producto query(Producto producto) {
        /**
         *
         * conexion de base de datos
         */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Producto> productos = new ArrayList<Producto>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, producto.getPKcodigoProducto());
            rs = stmt.executeQuery();
            
            while (rs.next()) {

                String codigoProducto = rs.getString("PK_codigo_producto");
                String nombreProducto = rs.getString("nombre_prodcuto");
                String descripcionProducto = rs.getString("descripcion_producto");
                String precioProducto = rs.getString("precio_producto");
                String costoProducto = rs.getString("costo_producto");
                String estatusProducto = rs.getString("estatus_producto");
                String lineaProducto = rs.getString("codigo_linea");
                String marcaProducto = rs.getString("codigo_marca");
                String bodegaProducto = rs.getString("codigo_bodega");
                String unidadProducto = rs.getString("codigo_unidad");

                /**
                 *
                 * concatenacionde de variables de de busqueda
                 */
                producto = new Producto();
                producto.setPKcodigoProducto(codigoProducto);
                producto.setNombreProducto(nombreProducto);
                producto.setDescripcionProducto(descripcionProducto);
                producto.setPrecioProducto(precioProducto);
                producto.setCostoProducto(costoProducto);
                producto.setEstatusProducto(estatusProducto);
                producto.setLineaProducto(lineaProducto);
                producto.setMarcaProducto(marcaProducto);
                producto.setBodegaProducto(bodegaProducto);
                producto.setUnidadProducto(unidadProducto);
                
                productos.add(producto);
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
        return producto;

    }

    public int insert(Producto insertar) {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;

        int rows = 0;
        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, insertar.getPKcodigoProducto());
            stmt.setString(2, insertar.getNombreProducto());
            stmt.setString(3, insertar.getDescripcionProducto());
            stmt.setString(4, insertar.getPrecioProducto());
            stmt.setString(5, insertar.getCostoProducto());
            stmt.setString(6, insertar.getEstatusProducto());
            stmt.setString(7, insertar.getLineaProducto());
            stmt.setString(8, insertar.getMarcaProducto());
            stmt.setString(9, insertar.getBodegaProducto());
            stmt.setString(10, insertar.getUnidadProducto());

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

    public int update(Producto update) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, update.getPKcodigoProducto());
            stmt.setString(2, update.getNombreProducto());
            stmt.setString(3, update.getDescripcionProducto());
            stmt.setString(4, update.getPrecioProducto());
            stmt.setString(5, update.getCostoProducto());
            stmt.setString(6, update.getEstatusProducto());
            stmt.setString(7, update.getLineaProducto());
            stmt.setString(8, update.getMarcaProducto());
            stmt.setString(9, update.getBodegaProducto());
            stmt.setString(10, update.getUnidadProducto());
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

    public int delete(Producto eliminar) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {

            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt.setString(1, eliminar.getPKcodigoProducto());

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
