/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas.datos;

import Finanzas.dominio.CuentaBancaria;
import Finanzas.dominio.CuentaHabiente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Finanzas.dominio.MovimientoBancario;
import java.sql.SQLException;
import java.sql.CallableStatement;

/**
 *
 * @author SantiagoMD
 */
public class MovimientoBancarioDAO {
    
    private static final String SQL_SELECT2 =
            "SELECT ID_DOCUMENTO,Codigo_CuentaHabiente, fecha, Transaccion,Balance,\n" +
"COALESCE(((SELECT SUM(Transaccion) FROM movimientobancario b WHERE \n" +
"b.ID_DOCUMENTO <= a.ID_DOCUMENTO AND Codigo_CuentaHabiente = Codigo_CuentaHabiente)\n" +
" -\n" +
" (SELECT SUM(Transaccion) \n" +
"FROM movimientobancario b\n" +
" WHERE b.Codigo_CuentaHabiente <= a.Codigo_CuentaHabiente AND \n" +
" Codigo_CuentaHabiente = Codigo_CuentaHabiente )), 0) as \"CONCEPTO\"\n" +
"FROM movimientobancario a WHERE Codigo_CuentaHabiente =Codigo_CuentaHabiente\n" +
" ORDER BY Codigo_CuentaHabiente DESC";
    
        private static final String SQL_SELECT5 =
            "SELECT ID_DOCUMENTO,Codigo_CuentaHabiente, fecha, Transaccion,Balance,\n" +
"COALESCE(((SELECT SUM(Transaccion) FROM movimientobancario b WHERE \n" +
"b.ID_DOCUMENTO <= a.ID_DOCUMENTO AND Codigo_CuentaHabiente = Codigo_CuentaHabiente)\n" +
" -\n" +
" (SELECT SUM(Transaccion) \n" +
"FROM movimientobancario b\n" +
" WHERE b.Codigo_CuentaHabiente <= a.Codigo_CuentaHabiente AND \n" +
" Codigo_CuentaHabiente = Codigo_CuentaHabiente )), 0) as \"CONCEPTO\"\n" +
"FROM movimientobancario a WHERE Codigo_CuentaHabiente =Codigo_CuentaHabiente\n" +
" ORDER BY Codigo_CuentaHabiente DESC";

    
     private static final String SQL_PA1 = " (call DEPOSITO{?,?,?,?,?})";
    
private static final String SQL_SELECT = "SELECT Codigo_CuentaHabiente, Nombre_CuentaHabiente, ApellidoP_CuentaHabiente,Saldo_Habilitado FROM CuentaHabiente where Codigo_CuentaHabiente = Codigo_CuentaHabiente and Codigo_CuentaHabiente = ?";
 private static final String SQL_INSERT = "Insert into MovimientoBancario(ID_DOCUMENTO,Codigo_CuentaHabiente,Balance,Transaccion,fecha,CONCEPTO)values(?,?,?,?,?,?)";
  private static final String SQL_INSERT2 = "Insert into MovimientoBancario(Codigo_CuentaHabiente,Balance,Transaccion,fecha)values(?,?,?,?)";
private static final String SQL_UPDATE = "update CuentaHabiente set Saldo_Habilitado= Saldo_Habilitado + ? where Codigo_CuentaHabiente=?";
 private static final String SQL_UPDATE2 = "update CuentaHabiente set Saldo_Habilitado= Saldo_Habilitado - ? where Codigo_CuentaHabiente=?";
public static final String SQL_QUERY2 = "SELECT  Codigo_CuentaHabiente, Nombre_CuentaHabiente, ApellidoP_CuentaHabiente,Saldo_Habilitado FROM CuentaHabiente where Codigo_CuentaHabiente = Codigo_CuentaHabiente and Codigo_CuentaHabiente = ?";
private static final String sql_query = "SELECT  Codigo_CuentaHabiente, Nombre_CuentaHabiente, ApellidoP_CuentaHabiente,Saldo_Habilitado FROM CuentaHabiente where Codigo_CuentaHabiente = Codigo_CuentaHabiente and Codigo_CuentaHabiente = ?";
private static final String sql_query2 = "SELECT  Numero_CuentaBancaria, CuentaHabiente_Cuenta, Banco_Cuenta,Saldo_Cuenta FROM CuentaHabiente where Numero_CuentaBancaria = Numero_CuentaBancaria and Numero_CuentaBancaria = ?";
  private static final String sql_query3= "SELECT  ID_DOCUMENTO, Codigo_CuentaHabiente, Balance,Transaccion,fecha,CONCEPTO FROM movimientobancario where ID_DOCUMENTO = ID_DOCUMENTO and ID_DOCUMENTO = ?";
public List<MovimientoBancario> listar2()  {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        MovimientoBancario cuenta = null;
        List<MovimientoBancario> tipo1 = new ArrayList<>();

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT2);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String ID_DOCUMENTO = rs.getString("ID_DOCUMENTO");
                String Codigo_CuentaHabiente = rs.getString("Codigo_CuentaHabiente");
                String Balance = rs.getString("Balance");
                String Transaccion = rs.getString("Transaccion");
                String fecha = rs.getString("fecha");
                String CONCEPTO = rs.getString("CONCEPTO");
 
                cuenta = new MovimientoBancario();
                cuenta.setID_DOCUMENTO(ID_DOCUMENTO);
               cuenta.setCodigo_CuentaHabiente(Codigo_CuentaHabiente);
                 cuenta.setBalance(Balance);
                cuenta.setTransaccion(Transaccion);
                    cuenta.setFecha(fecha);
                    cuenta.setCONCEPTO(CONCEPTO);
             

                tipo1.add(cuenta);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(con);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return tipo1;
  }
  
public List<CuentaHabiente> listar()  {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CuentaHabiente cuenta = null;
        List<CuentaHabiente> tipo1 = new ArrayList<>();

        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String Codigo_CuentaHabiente = rs.getString("Codigo_CuentaHabiente");
                String Nombre_CuentaHabiente = rs.getString("Nombre_CuentaHabiente");
                String ApellidoP_CuentaHabiente = rs.getString("ApellidoP_CuentaHabiente");
                String Saldo_Habilitado = rs.getString("Saldo_Habilitado");
 
                cuenta = new CuentaHabiente();
               cuenta.setCodigo_CuentaHabiente(Codigo_CuentaHabiente);
                cuenta.setNombre_CuentaHabiente(Nombre_CuentaHabiente);
                cuenta.setApellidoP_CuentaHabiente(ApellidoP_CuentaHabiente);
                cuenta.setSaldo_Habilitado(Saldo_Habilitado);
             

                tipo1.add(cuenta);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(con);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return tipo1;
    }
   
     public int Select1(MovimientoBancario cuenta) {
        Connection con = null;
        PreparedStatement stmt = null;
        CallableStatement proc = null;
        int rows = 0;
        String SQL_PA = " (call DEPOSITO{?,?,?,?})";
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_PA1);
            stmt.setString(1, cuenta.getCodigo_CuentaHabiente());
            stmt.setString(2, cuenta.getBalance());
            stmt.setString(3, cuenta.getTransaccion());
            stmt.setString(4, cuenta.getFecha());
            System.out.println("ejecutando PA" + SQL_PA );
            proc.setString(1, "prueba de bitacora");
            proc.execute();

            rows = stmt.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(con);
            Conexion.close(stmt);
              Conexion.close(proc);
        }
        return rows;
    }
   
  public int insert(MovimientoBancario cuenta) {
        Connection con = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
             stmt.setString(1, cuenta.getID_DOCUMENTO());
            stmt.setString(2, cuenta.getCodigo_CuentaHabiente());
            stmt.setString(3, cuenta.getBalance());
            stmt.setString(4, cuenta.getTransaccion());
            stmt.setString(5, cuenta.getFecha());
             stmt.setString(6, cuenta.getCONCEPTO());
            rows = stmt.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(con);
            Conexion.close(stmt);
        }
        return rows;
    }

  public int update(MovimientoBancario emisioncheque){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
 
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, emisioncheque.getTransaccion());
            stmt.setString(2, emisioncheque.getCodigo_CuentaHabiente());
            rows = stmt.executeUpdate();
    
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
 }
  
   public int update2(MovimientoBancario emisioncheque){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE2);
            stmt.setString(1, emisioncheque.getTransaccion());
            stmt.setString(2, emisioncheque.getCodigo_CuentaHabiente());
            rows = stmt.executeUpdate();

            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
 }
  
  

       public CuentaHabiente query(CuentaHabiente tipot) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
 
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql_query);
            stmt.setString(1, tipot.getCodigo_CuentaHabiente());
            rs = stmt.executeQuery();
            while (rs.next()) {
                 String Nombre_CuentaHabiente = rs.getString("Nombre_CuentaHabiente");
                String ApellidoP_CuentaHabiente = rs.getString("ApellidoP_CuentaHabiente");
                String Saldo_Habilitado = rs.getString("Saldo_Habilitado");

                tipot = new CuentaHabiente();
                tipot.setNombre_CuentaHabiente(Nombre_CuentaHabiente);
                tipot.setApellidoP_CuentaHabiente(ApellidoP_CuentaHabiente);
                tipot.setSaldo_Habilitado(Saldo_Habilitado);
                rows++;
            }

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return tipot;
    }

  

       public MovimientoBancario query(MovimientoBancario tipot) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
 
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT5);
            stmt.setString(1, tipot.getID_DOCUMENTO());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String ID_DOCUMENTO = rs.getString("ID_DOCUMENTO");
                String Codigo_CuentaHabiente = rs.getString("Codigo_CuentaHabiente");
                String fecha = rs.getString("fecha");
                String Transaccion = rs.getString("Transaccion");
                String Balance = rs.getString("Balance");
      

                tipot = new MovimientoBancario();
                tipot.setID_DOCUMENTO(ID_DOCUMENTO);
                tipot.setCodigo_CuentaHabiente(Codigo_CuentaHabiente);
                tipot.setTransaccion(Transaccion);
                 tipot.setBalance(Balance);
                  tipot.setFecha(fecha);
                  
                rows++;
            }

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return tipot;
       }
}


  
