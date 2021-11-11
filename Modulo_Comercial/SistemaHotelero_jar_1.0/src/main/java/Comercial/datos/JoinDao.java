/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;

import Comercial.dominio.Cotizacion_Venta;
import Comercial.dominio.Join_venta;
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
public class JoinDao {
    
      private static final String SQL_SELECT = "SELECT  PK_id_reservacion,fecha_entrada_reservacion , PK_id_servicio , precio_servicio , PK_id_menu , cantidad_orden ,fecha_orden,total_orden,PK_id_tarifa,nombre_tarifa FROM tbl_reservacion INNER JOIN tbl_servicio \n" +
"	ON tbl_reservacion.PK_id_reservacion = tbl_servicio.PK_id_servicio\n" +
"    INNER JOIN tbl_menu_orden ON tbl_servicio.PK_id_servicio = tbl_menu_orden.PK_id_orden\n" +
"     INNER JOIN tbl_tarifa ON tbl_servicio.PK_id_servicio = tbl_menu_orden.PK_id_orden;";
 
      public List< Join_venta> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
         Join_venta venta = null;
        List<Join_venta> ventas = new ArrayList<Join_venta>();
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
              
             
                   
                String reservacion  = rs.getString("PK_id_reservacion");
                String fecha_entrada_reservacion= rs.getString("fecha_entrada_reservacion");
                String PK_id_servicio =      rs.getString("PK_id_servicio");
              String precio_servicio =      rs.getString("precio_servicio");
                 String PK_id_menu = rs.getString("PK_id_menu");
                  String cantidad_orden  = rs.getString("cantidad_orden");
                   
                  String fecha_orden = rs.getString("fecha_orden");
                String total_orden  = rs.getString("total_orden");
                String PK_id_tarifa =      rs.getString("PK_id_tarifa");
                String nombre_tarifa = rs.getString("nombre_tarifa");
                 
              venta =  new Join_venta ();
                  venta.setReservacion(reservacion);
                  venta.setReservacion_fecha(fecha_entrada_reservacion);
                    venta.setServicio(PK_id_servicio);
                 venta.setPrecio_servicio(precio_servicio);
                 
                 venta.setFecha_orden(fecha_orden);
                   venta.setMenu(PK_id_menu);
                  venta.setOrden(total_orden);
                   venta.setTariafa(PK_id_tarifa);
                    venta.setNombre(nombre_tarifa);
                    
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

    private Join_venta Join() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
      
}


