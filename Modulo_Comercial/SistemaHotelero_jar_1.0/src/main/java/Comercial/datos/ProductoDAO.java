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

     private static final String SQL_SELECT = "SELECT PK_codigo_producto, nombre_producto, "
            + "descripcion_producto, precio_producto, costo_producto, estatus_producto,"
            + "codigo_linea, codigo_marca, codigo_bodega, codigo_unidad FROM tbl_producto";
    
    private static final String SQL_INSERT = "INSERT INTO tbl_producto (PK_codigo_producto, nombre_producto, "
            + "descripcion_producto, precio_producto, costo_producto, estatus_producto,"
            + "codigo_linea, codigo_marca, codigo_bodega, codigo_unidad) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?)";
    
    private static final String SQL_UPDATE = "UPDATE tbl_producto SET nombre_producto=?, "
            + "descripcion_producto=?, precio_producto=?, costo_producto=?, estatus_producto=?,"
            + "codigo_linea=?, codigo_marca=?, codigo_bodega=?, codigo_unidad=?"
            + " WHERE tbl_producto";
    
    private static final String SQL_QUERY = "SELECT  PK_codigo_producto, nombre_producto, "
            + "descripcion_producto, precio_producto, costo_producto, estatus_producto,"
            + "codigo_linea, codigo_marca, codigo_bodega, codigo_unidad"
            + " WHERE tbl_producto=?";
    
    private static final String SQL_DELETE = "DELETE FROM tbl_producto WHERE PK_codigo_producto=?";
    
    public List<Producto> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Producto> productos = new ArrayList<Producto>();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String PK_codigo_producto = rs.getString("PK_codigo_producto");
                String nombre_producto = rs.getString("nombre_producto");
                String descripcion_producto = rs.getString("descripcion_producto");
                String precio_producto = rs.getString("precio_producto");
                String costo_producto = rs.getString("costo_producto");
                String estatus_producto = rs.getString("estatus_producto");
                String codigo_linea = rs.getString("codigo_linea");
                String codigo_marca = rs.getString("codigo_marca");
                String codigo_bodega = rs.getString("codigo_bodega");
                String codigo_unidad = rs.getString("codigo_unidad");
                
                producto = new Producto();
                producto.setPKcodigoProducto(PK_codigo_producto);
                producto.setNombreProducto(nombre_producto);
                producto.setDescripcionProducto(descripcion_producto);
                producto.setPrecioProducto(precio_producto);
                producto.setCostoProducto(costo_producto);
                producto.setEstatusProducto(estatus_producto);
                producto.setLineaProducto(codigo_linea);
                producto.setMarcaProducto(codigo_marca);
                producto.setBodegaProducto(codigo_bodega);
                producto.setUnidadProducto(codigo_unidad);
                
                producto.setUnidadProducto(codigo_unidad);
                
                productos.add(producto);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return productos;
    }
    
    public int insert(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getPKcodigoProducto());
            stmt.setString(2, producto.getNombreProducto());
            stmt.setString(3, producto.getDescripcionProducto());
            stmt.setString(4, producto.getPrecioProducto());
            stmt.setString(5, producto.getCostoProducto());
            stmt.setString(6, producto.getEstatusProducto());
            stmt.setString(7, producto.getLineaProducto());
            stmt.setString(8, producto.getMarcaProducto());
            stmt.setString(9, producto.getBodegaProducto());
            stmt.setString(10, producto.getUnidadProducto());

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
    
    public int update(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, producto.getPKcodigoProducto());
            stmt.setString(2, producto.getNombreProducto());
            stmt.setString(3, producto.getDescripcionProducto());
            stmt.setString(4, producto.getPrecioProducto());
            stmt.setString(5, producto.getCostoProducto());
            stmt.setString(6, producto.getEstatusProducto());
            stmt.setString(7, producto.getLineaProducto());
            stmt.setString(8, producto.getMarcaProducto());
            stmt.setString(9, producto.getBodegaProducto());
            stmt.setString(10, producto.getUnidadProducto());
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
    
    public Producto query(Producto producto) {
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
                String PK_codigo_producto = rs.getString("PK_codigo_producto");
                String nombre_producto = rs.getString("nombre_producto");
                String descripcion_producto = rs.getString("descripcion_producto");
                String precio_producto = rs.getString("precio_producto");
                String costo_producto = rs.getString("costo_producto");
                String estatus_producto = rs.getString("estatus_producto");
                String codigo_linea = rs.getString("codigo_linea");
                String codigo_marca = rs.getString("codigo_marca");
                String codigo_bodega = rs.getString("codigo_bodega");
                String codigo_unidad = rs.getString("codigo_unidad");
                
                producto = new Producto();
                producto.setPKcodigoProducto(PK_codigo_producto);
                producto.setNombreProducto(nombre_producto);
                producto.setDescripcionProducto(descripcion_producto);
                producto.setPrecioProducto(precio_producto);
                producto.setCostoProducto(costo_producto);
                producto.setEstatusProducto(estatus_producto);
                producto.setLineaProducto(codigo_linea);
                producto.setMarcaProducto(codigo_marca);
                producto.setBodegaProducto(codigo_bodega);
                producto.setUnidadProducto(codigo_unidad);

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
        return producto;
    }
    
    public int delete(Producto producto) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, producto.getPKcodigoProducto());
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
