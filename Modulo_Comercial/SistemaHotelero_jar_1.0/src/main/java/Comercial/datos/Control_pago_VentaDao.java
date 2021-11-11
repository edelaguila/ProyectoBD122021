/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;

import Comercial.dominio.Control_pago_Venta;
import Comercial.dominio.Devolucion_Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PERSONAL
 */
public class Control_pago_VentaDao {
     private static final String SQL_INSERT = "INSERT INTO tbl_control_precio_encabezado("
       + "no_serie,codigo_servicio,precio,precio_cambio,fecha_emision,estatus_precio) VALUES(?,?,?,?,?,?)";
  private static final String SQL_UPDATE = "UPDATE tbl_control_precio_encabezado SET no_serie = ?,codigo_servicio=?,precio=?,precio_cambio=?,fecha_emision=?,estatus_precio=? WHERE no_serie"; 
 private static final String SQL_SELECT = "SELECT  no_serie,codigo_servicio,precio,precio_cambio,fecha_emision,estatus_precio FROM  tbl_control_precio_encabezado";
      private static final String SQL_QUERY = "SELECT no_serie,codigo_servicio,precio,precio_cambio,fecha_emision,estatus_precio FROM   tbl_control_precio_encabezado WHERE no_serie = ?";
  private static final String SQL_DELETE = "DELETE FROM  tbl_control_precio_encabezado  WHERE no_serie = ? ";
  public int insert( Control_pago_Venta insertar)  {
         ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
      
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, insertar.getNo_serie());
            stmt.setString(2, insertar.getServicio());
            stmt.setString(3, insertar.getPrecio());
            stmt.setString(4, insertar.getPrecio_cambio());
            stmt.setString(5, insertar.getFecha());
            stmt.setString(6, insertar.getEstatus());
    
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
 public int update(Control_pago_Venta insertar)  {
         ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
      
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            
       stmt.setString(1, insertar.getNo_serie());
            stmt.setString(2, insertar.getServicio());
            stmt.setString(3, insertar.getPrecio());
            stmt.setString(4, insertar.getPrecio_cambio());
            stmt.setString(5, insertar.getFecha());
            stmt.setString(6, insertar.getEstatus());
            System.out.println("ejecutando query:" + SQL_UPDATE);
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
 
 
 public List<Control_pago_Venta> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Control_pago_Venta venta = null;
        List<Control_pago_Venta> ventas = new ArrayList<Control_pago_Venta>();
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
              
             
                   
                String no_serie  = rs.getString("no_serie");
               
                   String codigo_servicio  = rs.getString("codigo_servicio");
                String fecha_emision  = rs.getString("fecha_emision");
                String precio =      rs.getString("precio");
                String precio_cambio = rs.getString("precio_cambio");
                    String estatus_precio = rs.getString("estatus_precio");
               venta = new Control_pago_Venta();
                  venta.setNo_serie(no_serie);
                  venta.setServicio(codigo_servicio);
                    venta.setPrecio(precio);
                 venta.setPrecio_cambio(precio_cambio);
                
                 venta.setFecha(fecha_emision);
                  
                    venta.setEstatus(estatus_precio);
                   
                    ventas.add(venta);
                    

                /**
                 *
                 * concatenacionde de variables de de busqueda
                 */
              

                 
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
          
    Conexion.close(stmt);
            Conexion.close(conn);
        }
  return ventas;

       
    }
 public   Control_pago_Venta  query(Control_pago_Venta  venta){
        /**
         *
         * conexion de base de datos
         */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Control_pago_Venta > ventas = new ArrayList<>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
           stmt.setString(1, venta.getNo_serie());
             
          
            rs = stmt.executeQuery();
            while (rs.next()) {
                  
                
                   
                  String no_serie  = rs.getString("no_serie");
               
                   String codigo_servicio  = rs.getString("codigo_servicio");
                String fecha_emision  = rs.getString("fecha_emision");
                String precio =      rs.getString("precio");
                String precio_cambio = rs.getString("precio_cambio");
                    String estatus_precio = rs.getString("estatus_precio");
               venta = new Control_pago_Venta();
                  venta.setNo_serie(no_serie);
                  venta.setServicio(codigo_servicio);
                    venta.setPrecio(precio);
                 venta.setPrecio_cambio(precio_cambio);
                
                 venta.setFecha(fecha_emision);
                  
                    venta.setEstatus(estatus_precio);
                   
                    ventas.add(venta);
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
 public int delete(Control_pago_Venta eliminar) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
             
            
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
           
           System.out.println("Ejecutando query:" + SQL_DELETE);
               stmt.setString(1,  eliminar.getNo_serie());
         
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
