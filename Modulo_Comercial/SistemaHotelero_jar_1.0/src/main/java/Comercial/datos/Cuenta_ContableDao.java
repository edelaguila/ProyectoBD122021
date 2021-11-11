/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;

import Comercial.dominio.Cuenta_Contable;
import Comercial.dominio.Devolucion_Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author PERSONAL
 */
public class Cuenta_ContableDao {
    private static final String SQL_INSERT = "INSERT INTO cuenta_contable("
    + "Codigo_CuentaContable,Codigo_Clasificacion,Correlativo_Subclasificacion,Estado_CuentaContable,Monto_CuentaContable,Efecto_CuentaContable) VALUES(?,?,?,?,?,?)";
  private static final String SQL_UPDATE = "UPDATE cuenta_contable SET Codigo_CuentaContable=?,Codigo_Clasificacion=?,Correlativo_Subclasificacion=?,Estado_CuentaContable=?,Monto_CuentaContable=?,Efecto_CuentaContable=? WHERE Codigo_CuentaContable"; 
private static final String SQL_DELETE = "DELETE FROM cuenta_contable  WHERE Codigo_CuentaContable = ? ";
  
   public int insert( Cuenta_Contable insertar)  {
         ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
      
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, insertar.getCodigo_contable());
            stmt.setString(2, insertar.getCodigo_clasificacion());
            stmt.setString(3, insertar.getCodigo_subclasificacion());
            stmt.setString(4, insertar.getEstado_contable());
            stmt.setString(5, insertar.getMonto());
            stmt.setString(6, insertar.getEfecto_contable());
           
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
   
    public int update( Cuenta_Contable insertar)  {
         ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
      
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
           stmt.setString(1, insertar.getCodigo_contable());
            stmt.setString(2, insertar.getCodigo_clasificacion());
            stmt.setString(3, insertar.getCodigo_subclasificacion());
            stmt.setString(4, insertar.getEstado_contable());
            stmt.setString(5, insertar.getMonto());
            stmt.setString(6, insertar.getEfecto_contable());
           
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
 
   
}
