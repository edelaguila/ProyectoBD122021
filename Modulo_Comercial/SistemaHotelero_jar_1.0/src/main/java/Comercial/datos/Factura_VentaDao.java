/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;

import Comercial.dominio.Factura_Venta;
import Comercial.datos.Conexion;
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
public class Factura_VentaDao {
  private static final String SQL_INSERT = "INSERT INTO tbl_factura_encabezado("
       + "no_serie,PK_codigo_factura_encabezado,codigo_cliente,codigo_cobrador,codigo_vendedor,"
   + ",fecha_emision,fecha_vencimiento,impuesto_iva_encabezado,subtotal_encabezado,estatus_factura) VALUES(?,?,?,?,?,?,?,?,?,?)";
  private static final String SQL_UPDATE = "UPDATE tbl_factura_encabezado SET no_serie=?,PK_codigo_factura_encabezado=?,"
   + "codigo_cliente=?,codigo_cobrador=?,codigo_vendedor=?," 
  + ",fecha_emision=?,fecha_vencimiento=?,impuesto_iva_encabezado=?,subtotal_encabezado=?,estatus_factura =? WHERE no_serie"; 
   private static final String SQL_SELECT = "SELECT  no_serie,PK_codigo_factura_encabezado,codigo_cliente,codigo_cobrador,codigo_vendedor," 
   + ",fecha_emision,fecha_vencimiento,impuesto_iva_encabezado,subtotal_encabezado,estatus_factura FROM tbl_factura_encabezado";
      private static final String SQL_QUERY = "SELECT no_serie,PK_codigo_factura_encabezado,codigo_cliente,codigo_cobrador,codigo_vendedor," 
   + ",fecha_emision,fecha_vencimiento,impuesto_iva_encabezado,subtotal_encabezado,estatus_factura  FROM tbl_cliente WHERE no_serie = ?";
  
  public int insert(Factura_Venta insertar)  {
         ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
      
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, insertar.getNo_serie());
            stmt.setString(2, insertar.getCodigo_factura_encabezado());
            stmt.setString(3, insertar.getCodigo_cliente());
            stmt.setString(4, insertar.getCodigo_cobrador());
            stmt.setString(5, insertar.getCodigo_vendedor());
            stmt.setString(6, insertar.getFecha_emision());
            stmt.setString(7, insertar.getFecha_vencimiento());
            stmt.setString(8, insertar.getImpuesto_iva_encabezado());
            stmt.setString(9, insertar.getSubtotal_encabezado());
            stmt.setString(10, insertar.getEstatus_factura());
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
public int  update(Factura_Venta insertar)  {
         ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
      
        int rows = 0;
        try {
             
            
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
              stmt.setString(1, insertar.getNo_serie());
            stmt.setString(2, insertar.getCodigo_factura_encabezado());
            stmt.setString(3, insertar.getCodigo_cliente());
            stmt.setString(4, insertar.getCodigo_cobrador());
            stmt.setString(5, insertar.getCodigo_vendedor());
            stmt.setString(6, insertar.getFecha_emision());
            stmt.setString(7, insertar.getFecha_vencimiento());
            stmt.setString(8, insertar.getImpuesto_iva_encabezado());
            stmt.setString(9, insertar.getSubtotal_encabezado());
            stmt.setString(10, insertar.getEstatus_factura());
           
          
             
       
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
   public List<Factura_Venta> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Factura_Venta venta = null;
        List<Factura_Venta> ventas = new ArrayList<Factura_Venta>();
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
                String codigo_factura_encabezado  = rs.getString("PK_codigo_factura_encabezado");
                String codigo_cliente =      rs.getString("codigo_cliente");
              
                 String codigo_cobrador  = rs.getString("codigo_cobrador");
                  String codigo_vendedor  = rs.getString("codigo_vendedor");
                String fecha_emision  = rs.getString("fecha_emision");
                String fecha_vencimiento =      rs.getString("fecha_vencimiento");
                String impuesto_iva_encabezado = rs.getString("impuesto_iva_encabezado");
                  String subtotal_encabezado = rs.getString("subtotal_encabezado");
                    String estatus_factura = rs.getString("estatus_factura");
            
                  venta.setNo_serie(no_serie);
                  venta.setCodigo_factura_encabezado(codigo_factura_encabezado);
                    venta.setCodigo_cobrador(codigo_cobrador);
                 venta.setCodigo_vendedor(codigo_vendedor);
                 venta.setCodigo_cliente(codigo_cliente);
                 venta.setFecha_emision(fecha_emision);
                   venta.setFecha_vencimiento(fecha_vencimiento);
                  venta.setImpuesto_iva_encabezado(impuesto_iva_encabezado);
                   venta.setSubtotal_encabezado(subtotal_encabezado);
                    venta.setEstatus_factura(estatus_factura);
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
 public   Factura_Venta  query(Factura_Venta  venta){
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
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
           stmt.setString(1, venta.getNo_serie());
             
          
            rs = stmt.executeQuery();
            while (rs.next()) {
                        String no_serie  = rs.getString("no_serie");
                String codigo_factura_encabezado  = rs.getString("PK_codigo_factura_encabezado");
                String codigo_cliente =      rs.getString("codigo_cliente");
              
                 String codigo_cobrador  = rs.getString("codigo_cobrador");
                  String codigo_vendedor  = rs.getString("codigo_vendedor");
                String fecha_emision  = rs.getString("fecha_emision");
               String fecha_vencimiento =      rs.getString("fecha_vencimiento");
                String impuesto_iva_encabezado = rs.getString("impuesto_iva_encabezado");
                  String subtotal_encabezado = rs.getString("subtotal_encabezado");
                    String estatus_factura = rs.getString("estatus_factura");
            
                  venta.setNo_serie(no_serie);
                  venta.setCodigo_factura_encabezado(codigo_factura_encabezado);
                    venta.setCodigo_cobrador(codigo_cobrador);
                 venta.setCodigo_vendedor(codigo_vendedor);
                 venta.setCodigo_cliente(codigo_cliente);
                 venta.setFecha_emision(fecha_emision);
                   venta.setFecha_vencimiento(fecha_vencimiento);
                  venta.setImpuesto_iva_encabezado(impuesto_iva_encabezado);
                   venta.setSubtotal_encabezado(subtotal_encabezado);
                    venta.setEstatus_factura(estatus_factura);
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

/**
 *
 * Factura detalle
 */

 private static final String SQL_INSERT1 = "INSERT INTO tbl_factura_detalle("
       + "no_serie,PK_codigo_factura_encabezado,cantidad_servicio,precio_servicio, VALUES(?,?,?,?)";
  private static final String SQL_UPDATE1 = "UPDATE tbl_factura_detalle SET no_serie=?,PK_codigo_factura_encabezado=?,"
   + ",cantidad_servicio=?,precio_servicio=? WHERE no_serie"; 
   private static final String SQL_SELECT1 = "SELECT  no_serie=?,PK_codigo_factura_encabezado=?,"
   + ",cantidad_servicio=?,precio_servicio=?  FROM tbl_factura_detalle";
      private static final String SQL_QUERY1 = "SELECT  no_serie=?,PK_codigo_factura_encabezado=?,"
   + ",cantidad_servicio=?,precio_servicio=?   FROM tbl_factura_detalle  WHERE no_serie = ?";
  public int insert1(Factura_Venta insertar)  {
         ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, insertar.getNo_serie());
            stmt.setString(2, insertar.getCodigo_factura_encabezado());
            stmt.setString(3, insertar.getCantidad_servicio());
            stmt.setString(4, insertar.getPrecio_servicio());
          
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
  public int  update1(Factura_Venta insertar)  {
         ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
      
        int rows = 0;
        try {
             
            
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
          
             stmt.setString(1, insertar.getNo_serie());
            stmt.setString(2, insertar.getCodigo_factura_encabezado());
            stmt.setString(3, insertar.getCantidad_servicio());
            stmt.setString(4, insertar.getPrecio_servicio());
          
             
       
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
  public List<Factura_Venta> select1() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Factura_Venta venta = null;
        List<Factura_Venta> ventas = new ArrayList<Factura_Venta>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String no_serie  = rs.getString("no_serie");
                String codigo_factura_encabezado  = rs.getString("PK_codigo_factura_encabezado");
                String cantidad_servicio =      rs.getString("cantidad_servicio");
                 String precio_servicio  = rs.getString("precio_servicio");
               
            
                  venta.setNo_serie(no_serie);
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
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
             stmt.setString(1, venta.getNo_serie());
             
          
            rs = stmt.executeQuery();
            while (rs.next()) {
                      
                   String no_serie  = rs.getString("no_serie");
                String codigo_factura_encabezado  = rs.getString("PK_codigo_factura_encabezado");
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

  
}
 

