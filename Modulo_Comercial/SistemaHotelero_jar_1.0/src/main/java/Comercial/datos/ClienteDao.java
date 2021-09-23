package Comercial.datos;





import Comercial.dominio.Cliente;
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
public class ClienteDao {
    
        private static final String SQL_INSERT = "INSERT INTO tbl_cliente(PK_codigo_cliente,nombre_cliente,direccion_cliente,"
                + "telefono_cliente,nit_cliente,email_cliente,saldo_cliente,cuenta_cliente,estatus_cliente) VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String SQL_SELECT = "SELECT PK_codigo_cliente,nombre_cliente,direccion_cliente,"
                + "telefono_cliente,nit_cliente,email_cliente,saldo_cliente,cuenta_cliente,estatus_cliente FROM tbl_cliente";
    private static final String SQL_QUERY = "SELECT PK_codigo_cliente,nombre_cliente,direccion_cliente,"
                + "telefono_cliente,nit_cliente,email_cliente,saldo_cliente,cuenta_cliente,estatus_cliente  FROM tbl_cliente WHERE PK_codigo_cliente = ?";
  private static final String SQL_UPDATE = "UPDATE tbl_cliente SET PK_codigo_cliente=?,nombre_cliente=?,direccion_cliente=?,"
                + "telefono_cliente=?,nit_cliente=?,email_cliente=?,saldo_cliente=?,cuenta_cliente=?,estatus_cliente=? WHERE PK_codigo_cliente";
    private static final String SQL_DELETE = "DELETE FROM tbl_cliente  WHERE PK_codigo_cliente = ? ";
//      private static final String SQL_QUERY22 = "SELECT Id_cliente,cliente,Nit,telefono,Estatus_Cliente FROM tbl_cliente WHERE cliente = ?";
//    private static final String SQL_QUERY3 = "SELECT nombre_producto,NuevaExistencia, FROM tbl_proceso_producto WHERE  nombre_producto =?";
     public List<Cliente> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente venta = null;
        List<Cliente> ventas = new ArrayList<Cliente>();
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
                String codigo_Cliente  = rs.getString("PK_codigo_cliente");
                String nombre_Cliente  = rs.getString("nombre_cliente");
                String nit_Cliente =      rs.getString("nit_cliente");
              
                 String estatus_Cliente  = rs.getString("estatus_cliente");
                  String direccion_Cliente  = rs.getString("direccion_cliente");
                String email_Cliente  = rs.getString("nombre_cliente");
                String saldo_Cliente =      rs.getString("saldo_cliente");
                String telefono_cliente = rs.getString("telefono_cliente");
                  String cuenta_cliente = rs.getString("cuenta_cliente");
             
             
                    

                /**
                 *
                 * concatenacionde de variables de de busqueda
                 */
              

                  venta = new Cliente();
                  venta.setNombre_Cliente(nombre_Cliente);
                    venta.setCodigo_Cliente(codigo_Cliente);
                 venta.setNit_Cliente(nit_Cliente);
                 venta.setTelefono_Cliente(telefono_cliente);
                 venta.setEstatus_Cliente(estatus_Cliente);
                   venta.setDireccion_Cliente(direccion_Cliente);
                  venta.setEmail_Cliente(email_Cliente);
                   venta.setSaldo_Cliente(saldo_Cliente);
                    venta.setCuenta_Cliente(cuenta_cliente);
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
 public   Cliente query(Cliente venta){
        /**
         *
         * conexion de base de datos
         */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cliente> ventas = new ArrayList<Cliente>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
             stmt.setString(1, venta.getCodigo_Cliente());
             
          
            rs = stmt.executeQuery();
            while (rs.next()) {
                      String codigo_Cliente = rs.getString("PK_codigo_cliente");
                String nombre_Cliente = rs.getString("nombre_cliente");
                String nit_Cliente = rs.getString("nit_cliente");

                String estatus_Cliente = rs.getString("estatus_cliente");
                String direccion_Cliente = rs.getString("direccion_cliente");
                String email_Cliente = rs.getString("nombre_cliente");
                String saldo_Cliente = rs.getString("saldo_cliente");
                String telefono_cliente = rs.getString("telefono_cliente");
                String cuenta_cliente = rs.getString("cuenta_cliente");
             

             
             
                    

                /**
                 *
                 * concatenacionde de variables de de busqueda
                 */
              

                  venta = new Cliente();
                  venta.setNombre_Cliente(nombre_Cliente);
                    venta.setCodigo_Cliente(codigo_Cliente);
                 venta.setNit_Cliente(nit_Cliente);
                 venta.setTelefono_Cliente(telefono_cliente);
                 venta.setEstatus_Cliente(estatus_Cliente);
                   venta.setDireccion_Cliente(direccion_Cliente);
                  venta.setEmail_Cliente(email_Cliente);
                   venta.setSaldo_Cliente(saldo_Cliente);
                    venta.setCuenta_Cliente(cuenta_cliente);
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
     public int insert(Cliente insertar)  {
         ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
      
        int rows = 0;
        try {
             
            
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, insertar.getCodigo_Cliente());
            stmt.setString(2, insertar.getNombre_Cliente());
            stmt.setString(3, insertar.getDireccion_Cliente());
            stmt.setString(4, insertar.getTelefono_Cliente());
            stmt.setString(5, insertar.getNit_Cliente());
            stmt.setString(6, insertar.getEmail_Cliente());
            stmt.setString(7, insertar.getSaldo_Cliente());
            stmt.setString(8, insertar.getCuenta_Cliente());
            stmt.setString(9, insertar.getEstatus_Cliente());
           
          
             
       
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
        public int update(Cliente insertar) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
           stmt.setString(1, insertar.getCodigo_Cliente());
            stmt.setString(2, insertar.getNombre_Cliente());
            stmt.setString(3, insertar.getDireccion_Cliente());
            stmt.setString(4, insertar.getTelefono_Cliente());
            stmt.setString(5, insertar.getNit_Cliente());
            stmt.setString(6, insertar.getEmail_Cliente());
            stmt.setString(7, insertar.getSaldo_Cliente());
            stmt.setString(8, insertar.getCuenta_Cliente());
            stmt.setString(9, insertar.getEstatus_Cliente());
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

       public int delete(Cliente eliminar) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
             
            
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
           
           System.out.println("Ejecutando query:" + SQL_DELETE);
               stmt.setString(1,  eliminar.getCodigo_Cliente());
         
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
