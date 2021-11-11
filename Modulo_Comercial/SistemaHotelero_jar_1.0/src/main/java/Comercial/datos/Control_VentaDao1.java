/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;

import Comercial.dominio.Factura_Venta;
import Comercial.datos.Conexion;
import Comercial.dominio.Cliente;
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
public class Control_VentaDao1 {
  private static final String SQL_INSERT1 = "INSERT INTO tbl_control_pago(no_serie,codigo_cotizacion_encabezado,cantidad_servicio,precio_servicio) VALUES(?,?,?,?)";
  private static final String SQL_UPDATE1 = "UPDATE  tbl_control_pago SET no_serie=?,codigo_cotizacion_encabezado=?,cantidad_servicio=?,precio_servicio=? WHERE no_serie"; 
   private static final String SQL_SELECT1 = "SELECT  no_serie,codigo_fcotizacion_encabezado,cantidad_servicio,precio_servicio  FROM tbl_control_pago _detalle";
      private static final String SQL_QUERY1 = "SELECT  no_serie,codigo_cotizacion_encabezado,cantidad_servicio,precio_servicio  FROM tbl_control_pago  WHERE no_serie = ?";
      private static final String SQL_DELETE1 = "DELETE FROM  tbl_control_pago WHERE no_serie = ? ";
  public int insert1(Factura_Venta insertar)  {
         ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT1);
            stmt.setString(1, insertar.getNo_serie1());
            stmt.setString(2, insertar.getCodigo_factura_encabezado());
            stmt.setString(3, insertar.getCantidad_servicio());
            stmt.setString(4, insertar.getPrecio_servicio());
          
            System.out.println("ejecutando query:" + SQL_INSERT1);
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
  public int  update1(Factura_Venta insertar)  {
         ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
      
        int rows = 0;
        try {
             
            
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE1);
          
             stmt.setString(1, insertar.getNo_serie1());
            stmt.setString(2, insertar.getCodigo_factura_encabezado());
            stmt.setString(3, insertar.getCantidad_servicio());
            stmt.setString(4, insertar.getPrecio_servicio());
          
             
       
            System.out.println("ejecutando query:" + SQL_INSERT1);
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
  public List<Factura_Venta> select1() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Factura_Venta venta = null;
        List<Factura_Venta> ventas = new ArrayList<Factura_Venta>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT1);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String no_serie  = rs.getString("no_serie");
                String codigo_factura_encabezado  = rs.getString("codigo_cotizacion_encabezado");
                String cantidad_servicio =      rs.getString("cantidad_servicio");
                 String precio_servicio  = rs.getString("precio_servicio");
               
            
                  venta.setNo_serie1(no_serie);
                  venta.setCodigo_factura_encabezado(codigo_factura_encabezado);
                    venta.setCantidad_servicio(cantidad_servicio);
                 venta.setPrecio_servicio(precio_servicio);
                
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
  public   Factura_Venta  query1(Factura_Venta  venta){
        /**
         *
         * conexion de base de datos
         */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Factura_Venta > ventas = new ArrayList<>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY1);
            stmt = conn.prepareStatement(SQL_QUERY1);
             stmt.setString(1, venta.getNo_serie1());
             
          
            rs = stmt.executeQuery();
            while (rs.next()) {
                      
                   String no_serie  = rs.getString("no_serie");
                String codigo_factura_encabezado  = rs.getString("codigo_factura_encabezado");
                String cantidad_servicio =      rs.getString("cantidad_servicio");
                 String precio_servicio  = rs.getString("precio_servicio");
               
            
                  venta.setNo_serie(no_serie);
                  venta.setCodigo_factura_encabezado(codigo_factura_encabezado);
                    venta.setCantidad_servicio(cantidad_servicio);
                 venta.setPrecio_servicio(precio_servicio);    
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
public int delete(Factura_Venta eliminar) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
             
            
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE1);
           
           System.out.println("Ejecutando query:" + SQL_DELETE1);
               stmt.setString(1,  eliminar.getNo_serie1());
         
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

 

