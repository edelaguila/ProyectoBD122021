/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;
import Comercial.dominio.BalanceSaldosProveedores1;
import Comercial.datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author SipaqueRitaMaria
 */
public class BalanceSaldosProveedoresDAO {                                                                                                           
  private static final String SQL_SELECT = "SELECT PK_codigo_documento, codigo_proveedor, transaccion,  fecha_emision,  fecha_atraso, dias_vencidos, total_detalle FROM tbl_balance_saldo_proveedores";
    private static final String SQL_INSERT = "INSERT INTO tbl_balance_saldo_proveedores(PK_codigo_documento, codigo_proveedor, transaccion,  fecha_emision,  fecha_atraso, dias_vencidos, total_detalle) VALUES(?,?,?,?,?,?,?)";
   
    private static final String SQL_QUERY = "SELECT PK_codigo_documento, codigo_proveedor, transaccion,  fecha_emision,  fecha_atraso, dias_vencidos, total_detalle FROM tbl_balance_saldo_proveedores WHERE PK_codigo_documento=?";
 
    
    public List<BalanceSaldosProveedores1> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        BalanceSaldosProveedores1  proveedor = null;
        List<BalanceSaldosProveedores1> proveedores = new ArrayList<BalanceSaldosProveedores1>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int  PK_codigo_Proveedor = rs.getInt("PK_codigo_documento");
                String codigo_Documento = rs.getString("codigo_proveedor");
                String transaccioN = rs.getString("transaccion");
                String fecha_Emison = rs.getString("fecha_emision");
                String fecha_Atraso = rs.getString("fecha_atraso");
                String dias_Vencidos = rs.getString("dias_vencidos");
                 String total_Detalle = rs.getString("total_detalle");

                proveedor = new BalanceSaldosProveedores1();
                proveedor.setPK_codigo_proveedor(PK_codigo_Proveedor);
                proveedor.setCodigo_documento(codigo_Documento);
                proveedor.setTransaccion(transaccioN );
                proveedor.setFecha_emision(fecha_Emison );
                proveedor.setFecha_atraso(fecha_Atraso);
                proveedor.setDiasvencidos(dias_Vencidos);
                proveedor.setTotal_detalle(total_Detalle);
                proveedores.add(proveedor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return proveedores;
    }
    
    public int insert(BalanceSaldosProveedores1 proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, proveedor.getPK_codigo_proveedor());
            stmt.setString(2, proveedor.getCodigo_documento());
            stmt.setString(3, proveedor.getTransaccion());
            stmt.setString(4, proveedor.getFecha_emision());
            stmt.setString(5, proveedor.getFecha_atraso());
            stmt.setString(6, proveedor.getDiasvencidos());
            stmt.setString(7, proveedor.getTotal_detalle());

            //System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public BalanceSaldosProveedores1 query(BalanceSaldosProveedores1 proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);

            stmt.setInt(1, proveedor.getPK_codigo_proveedor());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
          int  PK_codigo_Proveedor = rs.getInt("PK_codigo_documento");
                String codigo_Documento = rs.getString("codigo_proveedor");
                String transaccioN = rs.getString("transaccion");
                String fecha_Emison = rs.getString("fecha_emision");
                String fecha_Atraso = rs.getString("fecha_atraso");
                String dias_Vencidos = rs.getString("Dias_vencidos");
                 String total_Detalle = rs.getString("total_detalle");

                proveedor = new BalanceSaldosProveedores1();
                proveedor.setPK_codigo_proveedor(PK_codigo_Proveedor);
                proveedor.setCodigo_documento(codigo_Documento);
                proveedor.setTransaccion(transaccioN );
                proveedor.setFecha_emision(fecha_Emison );
                proveedor.setFecha_atraso(fecha_Atraso);
                proveedor.setDiasvencidos(dias_Vencidos);
                proveedor.setTotal_detalle(total_Detalle);
                

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return proveedor;
    }
    
    
    
    
}
