package Comercial.datos;




import Comercial.dominio.Cobrador;
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
public class CobradorDao {
       private static final String SQL_INSERT = "INSERT INTO tbl_cobrador(PK_codigo_cobrador,nombre_cobrador,estatus_cobrador) VALUES(?,?,?)";
    private static final String SQL_SELECT = "SELECT PK_codigo_cobrador,nombre_cobrador,estatus_cobrador FROM tbl_cobrador";
    private static final String SQL_QUERY = "SELECT PK_codigo_cobrador,nombre_cobrador,estatus_cobrador FROM tbl_cobrador WHERE PK_codigo_cobrador = ?";
  private static final String SQL_UPDATE = "UPDATE tbl_cobrador SET  PK_codigo_cobrador=?,nombre_cobrador=?,estatus_cobrador=? WHERE PK_codigo_cobrador";
    private static final String SQL_DELETE = "DELETE FROM tbl_cobrador  WHERE PK_codigo_cobrador = ? ";
//      private static final String SQL_QUERY22 = "SELECT Id_cliente,cliente,Nit,telefono,Estatus_Cliente FROM tbl_vendedor WHERE cliente = ?";
//    private static final String SQL_QUERY3 = "SELECT nombre_producto,NuevaExistencia, FROM tbl_proceso_producto WHERE  nombre_producto =?";
     public List<Cobrador> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cobrador venta = null;
        List<Cobrador> ventas = new ArrayList<Cobrador>();
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
                String codigo_Cobrador = rs.getString("PK_codigo_cobrador");
                String nombre_Cobrador = rs.getString("nombre_cobrador");
                String estatus_Cobrador = rs.getString("estatus_cobrador");
                      

                /**
                 *
                 * concatenacionde de variables de de busqueda
                 */
              

                  venta = new Cobrador();
                  venta.setCodigo_Cobrador(codigo_Cobrador);
                    venta.setNombre_Cobrador(nombre_Cobrador );
                 
               venta.setEstatus_Cobrador(estatus_Cobrador);
                 
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
 public   Cobrador query(Cobrador venta){
        /**
         *
         * conexion de base de datos
         */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Cobrador> ventas = new ArrayList<Cobrador>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
             stmt.setString(1, venta.getCodigo_Cobrador ());
             
          
            rs = stmt.executeQuery();
            while (rs.next()) {
              
              
                String codigo_Cobrador = rs.getString("PK_codigo_cobrador");
                String nombre_Cobrador = rs.getString("nombre_cobrador");
                String estatus_Cobrador = rs.getString("estatus_cobrador");
                      

                /**
                 *
                 * concatenacionde de variables de de busqueda
                 */
              

                  venta = new Cobrador();
                  venta.setCodigo_Cobrador(codigo_Cobrador);
                    venta.setNombre_Cobrador(nombre_Cobrador );
                 
               venta.setEstatus_Cobrador(estatus_Cobrador);
                 
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

 

     public int insert(Cobrador  insertar)  {
         ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
      
        int rows = 0;
        try {
             
            
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1,  insertar.getCodigo_Cobrador ());
            stmt.setString(2,  insertar.getNombre_Cobrador ());       
            stmt.setString(3,  insertar.getEstatus_Cobrador ());
       
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
        public int update(Cobrador  insertar) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
           stmt.setString(1,  insertar.getCodigo_Cobrador ());
            stmt.setString(2,  insertar.getNombre_Cobrador ());       
            stmt.setString(3,  insertar.getEstatus_Cobrador ());
           
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

       public int delete(Cobrador  eliminar) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
             
            
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
           
           System.out.println("Ejecutando query:" + SQL_DELETE);
               stmt.setString(1,  eliminar.getCodigo_Cobrador ());
         
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
