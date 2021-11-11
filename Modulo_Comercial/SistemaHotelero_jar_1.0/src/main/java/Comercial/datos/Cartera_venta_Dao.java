/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;

import Comercial.dominio.Cartera_Venta;
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
public class Cartera_venta_Dao {
            private static final String SQL_INSERT = "INSERT INTO tbl_cartera_venta(no_correlativo,codigo_cliente,nombre_cliente,codigo_cobrador,"
                    + "nombre_cobrador,codigo_vendedor,nombre_vendedor,estatus_cartera ) VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_SELECT = "SELECT no_correlativo,codigo_cliente,nombre_cliente,codigo_cobrador,"
                    + "nombre_cobrador,codigo_vendedor,nombre_vendedor,estatus_cartera  FROM tbl_cartera_venta";
    private static final String SQL_QUERY = "SELECT no_correlativo,codigo_cliente,nombre_cliente,codigo_cobrador,"
                    + "nombre_cobrador,codigo_vendedor,nombre_vendedor,estatus_cartera  FROM tbl_cartera_venta WHERE no_correlativo = ?";
  private static final String SQL_UPDATE = "UPDATE tbl_cartera_venta SET no_correlativo=?,codigo_cliente=?,nombre_cliente=?,codigo_cobrador=?,"
                    + "nombre_cobrador=?,codigo_vendedor=?,nombre_vendedor=?,estatus_cartera=? WHERE no_correlativo";
    private static final String SQL_DELETE = "DELETE FROM tbl_cartera_venta  WHERE no_correlativo = ? ";
//      private static final String SQL_QUERY22 = "SELECT Id_cliente,cliente,Nit,telefono,Estatus_Cliente FROM tbl_cliente WHERE cliente = ?";
//    private static final String SQL_QUERY3 = "SELECT nombre_producto,NuevaExistencia, FROM tbl_proceso_producto WHERE  nombre_producto =?";
     public List<Cartera_Venta> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cartera_Venta venta = null;
        List<Cartera_Venta> ventas = new ArrayList<Cartera_Venta>();
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
              String no_Serie  = rs.getString("no_correlativo");
                String codigo_Cliente  = rs.getString("codigo_cliente");
                String nombre_Cliente  = rs.getString("nombre_cliente");
             String codigo_Cobrador  = rs.getString("codigo_cobrador");
                String nombre_Cobrador  = rs.getString("nombre_cobrador");
                 String codigo_Vendedor  = rs.getString("codigo_cliente");
                String nombre_Vendedor  = rs.getString("nombre_cliente");
              
                 String estatus_Cartera  = rs.getString("estatus_cartera");
                 
             
             
                    

                /**
                 *
                 * concatenacionde de variables de de busqueda
                 */
              

                  venta = new Cartera_Venta();
                  venta.setCodigo_cliente(nombre_Cliente);
                    venta.setCodigo_cobrador(codigo_Cobrador);
                 venta.setCodigo_vendedor(codigo_Vendedor);
                 venta.setNombre_cliente(nombre_Cliente);
                 venta.setNombre_cobrador(nombre_Cobrador);
                   venta.setNombre_vendedor(nombre_Vendedor);
                  venta.setNo_serie(no_Serie);
                   venta.setEstatus_cartera(estatus_Cartera);
                  
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
 public   Cartera_Venta query(Cartera_Venta venta){
        /**
         *
         * conexion de base de datos
         */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cartera_Venta> ventas = new ArrayList<Cartera_Venta>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
             stmt.setString(1, venta.getNo_serie());
             
          
            rs = stmt.executeQuery();
            while (rs.next()) {
                     String no_Serie  = rs.getString("no_correlativo");
                String codigo_Cliente  = rs.getString("codigo_cliente");
                String nombre_Cliente  = rs.getString("nombre_cliente");
             String codigo_Cobrador  = rs.getString("codigo_cobrador");
                String nombre_Cobrador  = rs.getString("nombre_cobrador");
                 String codigo_Vendedor  = rs.getString("codigo_cliente");
                String nombre_Vendedor  = rs.getString("nombre_cliente");
              
                 String estatus_Cartera  = rs.getString("estatus_cartera");
                 
             
             
                    

                /**
                 *
                 * concatenacionde de variables de de busqueda
                 */
              

                  venta = new Cartera_Venta();
                  venta.setCodigo_cliente(codigo_Cliente );
                    venta.setCodigo_cobrador(codigo_Cobrador);
                 venta.setCodigo_vendedor(codigo_Vendedor);
                 venta.setNombre_cliente(nombre_Cliente);
                 venta.setNombre_cobrador(nombre_Cobrador);
                   venta.setNombre_vendedor(nombre_Vendedor);
                  venta.setNo_serie(no_Serie);
                   venta.setEstatus_cartera(estatus_Cartera);
                  
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
// public   ProcesoProducto query3(ProcesoProducto venta){
//        /**
//         *
//         * conexion de base de datos
//         */
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        List<ProcesoProducto> ventas = new ArrayList<ProcesoProducto>();
//        int rows = 0;
//
//        try {
//            conn = Conexion.getConnection();
//            System.out.println("Ejecutando query:" + SQL_QUERY3);
//            stmt = conn.prepareStatement(SQL_QUERY3);
//             stmt.setString(1, venta.getNombre_producto());
//             
//          
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                  
//                String nombre  = rs.getString("nombre_producto");
//                String existencia =      rs.getString("NuevaExistencia");
//            
//                /**
//                 *
//                 * concatenacionde de variables de de busqueda
//                 */
//              
//
//                  venta = new ProcesoProducto();
//                  
//                  venta.setNombre_producto(nombre);
//              venta.setNuevaExistencia(existencia);
//             
//               
//                
//                    ventas.add(venta);
//                /**
//                 *
//                 * busqueda de datos de la bitacocora en la de usuarios
//                 */
//                
//               
//            }
//            //System.out.println("Registros buscado:" + vendedor);
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        } finally {
//           
//            Conexion.close(stmt);
//            Conexion.close(conn);
//        }
//       return venta;
// 
//
//    
//     }
 
 
// public   Cliente query2(Cliente venta){
//        /**
//         *
//         * conexion de base de datos
//         */
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        List<Cliente> ventas = new ArrayList<Cliente>();
//        int rows = 0;
//
//        try {
//            conn = Conexion.getConnection();
//            System.out.println("Ejecutando query:" + SQL_QUERY22);
//            stmt = conn.prepareStatement(SQL_QUERY22);
//             
//                 stmt.setString(1, venta.getCliente());
//          
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//              
//                String cliente  = rs.getString("Cliente");
//                String nit =      rs.getString("Nit");
//                String telefono = rs.getString("telefono");
//                  String id = rs.getString("Id_cliente");
//             
//                /**
//                 *
//                 * concatenacionde de variables de de busqueda
//                 */
//              
//
//                  venta = new Cliente();
//                  venta.setCliente(cliente);
//              venta.setId_cliente(id);
//                 venta.setNit(nit);
//                 venta.setTelefono(telefono);
//               
//                
//                    ventas.add(venta);
//                /**
//                 *
//                 * busqueda de datos de la bitacocora en la de usuarios
//                 */
//                
//               
//            }
//            //System.out.println("Registros buscado:" + vendedor);
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        } finally {
//           
//            Conexion.close(stmt);
//            Conexion.close(conn);
//        }
//       return venta;
// 
//
//    
//     }
     public int insert(Cartera_Venta insertar)  {
         ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
      
        int rows = 0;
        try {
             
            
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, insertar.getNo_serie());
            stmt.setString(2, insertar.getCodigo_cliente());
            stmt.setString(3, insertar.getNombre_cliente());
            stmt.setString(4, insertar.getCodigo_cobrador());
            stmt.setString(5, insertar.getNombre_cobrador());
            stmt.setString(6, insertar.getCodigo_vendedor());
            stmt.setString(7, insertar.getNombre_vendedor());
            stmt.setString(8, insertar.getEstatus_cartera());
           
           
          
             
       
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
        public int update(Cartera_Venta insertar) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
           stmt.setString(1, insertar.getNo_serie());
            stmt.setString(2, insertar.getCodigo_cliente());
            stmt.setString(3, insertar.getNombre_cliente());
            stmt.setString(4, insertar.getCodigo_cobrador());
            stmt.setString(5, insertar.getNombre_cobrador());
            stmt.setString(6, insertar.getCodigo_vendedor());
            stmt.setString(7, insertar.getNombre_vendedor());
            stmt.setString(8, insertar.getEstatus_cartera());
           
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

       public int delete(Cartera_Venta eliminar) {
        
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
