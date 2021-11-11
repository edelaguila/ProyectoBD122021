/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;

import Comercial.dominio.Registro_venta;
import Comercial.datos.Conexion;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author PERSONAL
 */
public class Registro_ventaDao {
    private static final String SQL_INSERT = "INSERT INTO tbl_registro_movimientos_venta( no_serie,accion, tabla ,total) VALUES(?, ?,?, ?)";
    private static final String SQL_SELECT = "SELECT no_serie,accion, tabla ,total FROM tbl_registro_movimientos_venta";
    public List<Registro_venta> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Registro_venta venta = null;
        List<Registro_venta> ventas = new ArrayList<Registro_venta>();
        try {
            /**
             *
             * conecion con sql de selecccion
             */
            conn = Comercial.datos.Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                /**
                 *
                 * busqueda de datos de la bitacocora en la de usuarios
                 */
                String no_serie = rs.getString("no_serie");
               
              
                /**
                 *
                 * concatenacionde de variables de de busqueda
                 */
                
                String accion = rs.getString("accion");
                String CodigoAplicacion = rs.getString("tabla");
                 String total = rs.getString("total");

                venta = new Registro_venta();
                venta.setNo_serie(no_serie);
                venta.setAccion(accion);
                venta.setTabla(CodigoAplicacion);
                venta.setTotal(total);

                ventas.add(venta);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            seguridad.datos.Conexion.close(rs);

            seguridad.datos.Conexion.close(conn);
        }

        return ventas;
    }


      public int insert( Registro_venta insertar)    {
         ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
      
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
   stmt.setString(1, insertar.getNo_serie());
            stmt.setString(2, insertar.getAccion());
            stmt.setString(3, insertar.getTabla());
            stmt.setString(4, insertar.getTotal());
    
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
    
}
