/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;
import Comercial.dominio.FacturaCompra;
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
public class FacturaCompraDAO {
 private static final String SQL_SELECT = "SELECT PK_codigo_factura, PK_codigo_bodega, codigo_proveedor, fecha_emision, fecha_vencimiento, codigo_pago,  estatus_factura FROM tbl_compra_encabezado";
    private static final String SQL_INSERT = "INSERT INTO tbl_compra_encabezado (PK_codigo_factura, PK_codigo_bodega, codigo_proveedor, fecha_emision, fecha_vencimiento, codigo_pago, estatus_factura) VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_compra_encabezado SET  PK_codigo_bodega=?, codigo_proveedor=?, fecha_emision=?, fecha_vencimiento=?, codigo_pago=?,  estatus_factura=?     WHERE PK_codigo_factura=?";
    private static final String SQL_QUERY = "SELECT PK_codigo_factura, PK_codigo_bodega, codigo_proveedor, fecha_emision, fecha_vencimiento, codigo_pago,  estatus_factura FROM tbl_compra_encabezado WHERE PK_codigo_factura=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_compra_encabezado WHERE PK_codigo_factura=?";

   
   public List<FacturaCompra> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        FacturaCompra  proveedor = null;
        List<FacturaCompra> proveedores = new ArrayList<FacturaCompra>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int  PK_Codigo_Factura = rs.getInt("PK_codigo_factura");
                String PK_Codigo_Bodega = rs.getString("PK_codigo_bodega");
                String Codigo_Proveedor = rs.getString("codigo_proveedor");
                String Fecha_Emision = rs.getString("fecha_emision");
                String Fecha_Vencimiento = rs.getString("fecha_vencimiento");
                String Codigo_Pago = rs.getString("codigo_pago");
               String Estatus_Factura = rs.getString("estatus_factura");

                proveedor = new FacturaCompra();
                proveedor.setPK_codigo_factura(PK_Codigo_Factura);
                proveedor.setPK_codigo_bodega(PK_Codigo_Bodega);
                proveedor.setCodigo_proveedor(Codigo_Proveedor);
                proveedor.setFecha_emision(Fecha_Emision);
                proveedor.setFecha_vencimiento(Fecha_Vencimiento);
                proveedor.setCodigo_pago(Codigo_Pago);
               
                proveedor.setEstatus_factura(Estatus_Factura);
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
   
   public int insert(FacturaCompra proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, proveedor.getPK_codigo_factura());
            stmt.setString(2, proveedor.getPK_codigo_bodega());
            stmt.setString(3, proveedor.getCodigo_proveedor());
            stmt.setString(4, proveedor.getFecha_emision());
            stmt.setString(5, proveedor.getFecha_vencimiento());
            stmt.setString(6, proveedor.getCodigo_pago());
            
            stmt.setString(7, proveedor.getEstatus_factura());

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

   
   public FacturaCompra query(FacturaCompra proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);

            stmt.setInt(1, proveedor.getPK_codigo_factura());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                 int  PK_Codigo_Factura = rs.getInt("PK_codigo_factura");
                String PK_Codigo_Bodega = rs.getString("PK_codigo_bodega");
                String Codigo_Proveedor = rs.getString("codigo_proveedor");
                String Fecha_Emision = rs.getString("fecha_emision");
                String Fecha_Vencimiento = rs.getString("fecha_vencimiento");
                String Codigo_Pago = rs.getString("codigo_pago");
               String Estatus_Factura = rs.getString("estatus_factura");

                proveedor = new FacturaCompra();
                proveedor.setPK_codigo_factura(PK_Codigo_Factura);
                proveedor.setPK_codigo_bodega(PK_Codigo_Bodega);
                proveedor.setCodigo_proveedor(Codigo_Proveedor);
                proveedor.setFecha_emision(Fecha_Emision);
                proveedor.setFecha_vencimiento(Fecha_Vencimiento);
                proveedor.setCodigo_pago(Codigo_Pago);
                proveedor.setEstatus_factura(Estatus_Factura);
                

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
    public int delete(FacturaCompra aplicacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, aplicacion.getPK_codigo_factura());
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

   
   public int update(FacturaCompra proveedor) {
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
            stmt.setString(5, proveedor.getCodigo_pago());
            stmt.setString(6, proveedor.getEstatus_factura());
            stmt.setInt(7, proveedor.getPK_codigo_factura());
            
            
            
        
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
