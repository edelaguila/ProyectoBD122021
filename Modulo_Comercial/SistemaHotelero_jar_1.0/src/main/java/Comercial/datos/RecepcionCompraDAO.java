/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;
import Comercial.dominio.RecepcionCompra;
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
public class RecepcionCompraDAO {
 private static final String SQL_SELECT = "SELECT PK_codigo_recepcioncompra, PK_codigo_bodega, codigo_proveedor, fecha_emision, fecha_entrega,   estatus_recepcion FROM tbl_recepcioncompra_encabezado";
    private static final String SQL_INSERT = "INSERT INTO tbl_recepcioncompra_encabezado (PK_codigo_recepcioncompra, PK_codigo_bodega, codigo_proveedor, fecha_emision, fecha_entrega,  estatus_recepcion) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_recepcioncompra_encabezado SET  PK_codigo_bodega=?, codigo_proveedor=?, fecha_emision=?, fecha_entrega=?,   estatus_recepcion=?     WHERE PK_codigo_recepcioncompra=?";
    private static final String SQL_QUERY = "SELECT PK_codigo_recepcioncompra, PK_codigo_bodega, codigo_proveedor, fecha_emision, fecha_entrega,   estatus_recepcion FROM tbl_recepcioncompra_encabezado WHERE PK_codigo_recepcioncompra=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_recepcioncompra_encabezado WHERE PK_codigo_recepcioncompra=?";

   
   public List<RecepcionCompra> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        RecepcionCompra proveedor = null;
        List<RecepcionCompra> proveedores = new ArrayList<RecepcionCompra>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int  PK_Codigo_Factura = rs.getInt("PK_codigo_recepcioncompra");
                String PK_Codigo_Bodega = rs.getString("PK_codigo_bodega");
                String Codigo_Proveedor = rs.getString("codigo_proveedor");
                String Fecha_Emision = rs.getString("fecha_emision");
                String Fecha_Vencimiento = rs.getString("fecha_entrega");
                
               String Estatus_Factura = rs.getString("estatus_recepcion");

                proveedor = new RecepcionCompra();
                proveedor.setPK_codigo_RecepcionCompra(PK_Codigo_Factura);
                proveedor.setPK_codigo_bodega(PK_Codigo_Bodega);
                proveedor.setCodigo_proveedor(Codigo_Proveedor);
                proveedor.setFecha_emision(Fecha_Emision);
                proveedor.setFecha_vencimiento(Fecha_Vencimiento);
                
               
                proveedor.setEstatus_recepcioncompra(Estatus_Factura);
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
   
   public int insert(RecepcionCompra proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, proveedor.getPK_codigo_RecepcionCompra());
            stmt.setString(2, proveedor.getPK_codigo_bodega());
            stmt.setString(3, proveedor.getCodigo_proveedor());
            stmt.setString(4, proveedor.getFecha_emision());
            stmt.setString(5, proveedor.getFecha_vencimiento());
            
            
            stmt.setString(6, proveedor.getEstatus_recepcioncompra());

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

   
   public RecepcionCompra query(RecepcionCompra proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);

            stmt.setInt(1, proveedor.getPK_codigo_RecepcionCompra());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                 int  PK_Codigo_Factura = rs.getInt("PK_codigo_recepcioncompra");
                String PK_Codigo_Bodega = rs.getString("PK_codigo_bodega");
                String Codigo_Proveedor = rs.getString("codigo_proveedor");
                String Fecha_Emision = rs.getString("fecha_emision");
                String Fecha_Vencimiento = rs.getString("fecha_entrega");
               
               String Estatus_Factura = rs.getString("estatus_recepcioncompra");

                proveedor = new RecepcionCompra();
                proveedor.setPK_codigo_RecepcionCompra(PK_Codigo_Factura);
                proveedor.setPK_codigo_bodega(PK_Codigo_Bodega);
                proveedor.setCodigo_proveedor(Codigo_Proveedor);
                proveedor.setFecha_emision(Fecha_Emision);
                proveedor.setFecha_vencimiento(Fecha_Vencimiento);
                
                proveedor.setEstatus_recepcioncompra(Estatus_Factura);
                

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
    public int delete(RecepcionCompra aplicacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, aplicacion.getPK_codigo_RecepcionCompra());
            rows = stmt.executeUpdate();
            //System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

   
   public int update(RecepcionCompra proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            
            stmt.setString(1, proveedor.getPK_codigo_bodega());
            stmt.setString(2, proveedor.getCodigo_proveedor());
            stmt.setString(3, proveedor.getFecha_emision());
            stmt.setString(4, proveedor.getFecha_vencimiento());
            ;
            stmt.setString(5, proveedor.getEstatus_recepcioncompra());
            stmt.setInt(6, proveedor.getPK_codigo_RecepcionCompra());
            
            
            
        
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
   
   
   
   
   
   
   
}
