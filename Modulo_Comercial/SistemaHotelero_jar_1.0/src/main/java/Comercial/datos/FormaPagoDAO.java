/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;
import Comercial.dominio.FormaPago;
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
public class FormaPagoDAO {
private static final String SQL_SELECT = "SELECT PK_codigo_pago,codigo_proveedor, tipo_transaccion, forma_pago, dias_pago,  fecha_pago, estatus_pago FROM tbl_forma_pago";
    private static final String SQL_INSERT = "INSERT INTO tbl_forma_pago (PK_codigo_pago,codigo_proveedor, tipo_transaccion, forma_pago, dias_pago,  fecha_pago, estatus_pago) VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_forma_pago SET codigo_proveedor=?, tipo_transaccion=?, forma_pago=?, dias_pago=?,  fecha_pago=?, estatus_pago=?    WHERE PK_codigo_pago=?";
    private static final String SQL_QUERY = "SELECT PK_codigo_pago,codigo_proveedor, tipo_transaccion, forma_pago, dias_pago,  fecha_pago, estatus_pago FROM tbl_forma_pago WHERE PK_codigo_pago=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_forma_pago WHERE PK_codigo_pago=?";    


    public List<FormaPago> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        FormaPago proveedor = null;
        List<FormaPago> proveedores = new ArrayList<FormaPago>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int  PK_Codigo_Pago = rs.getInt("PK_codigo_pago");
                String codigo_Proveedor = rs.getString("codigo_proveedor");
                String tipo_Transaccion = rs.getString("tipo_transaccion");
                String forma_Pago = rs.getString("forma_pago");
                String dias_Pago = rs.getString("dias_pago");
                String fecha_Pago = rs.getString("fecha_pago");
                String estatus_Pago = rs.getString("estatus_pago");
                

                proveedor = new FormaPago();
                proveedor.setPK_codigo_pago (PK_Codigo_Pago );
                proveedor.setCodigo_proveedor(codigo_Proveedor);
                proveedor.setTipo_pago(tipo_Transaccion);
                proveedor.setForma_pago(forma_Pago);
                proveedor.setDias_pago(dias_Pago);
                proveedor.setFecha_pago(fecha_Pago);
                proveedor.setEstatus_pago(estatus_Pago);
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
    
    public int insert(FormaPago proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, proveedor.getPK_codigo_pago());
            stmt.setString(2, proveedor.getCodigo_proveedor());
            stmt.setString(3, proveedor.getTipo_pago());
            stmt.setString(4, proveedor.getForma_pago());
            stmt.setString(5, proveedor.getDias_pago());
            stmt.setString(6, proveedor.getFecha_pago());
            stmt.setString(7, proveedor.getEstatus_pago());
            

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

    public FormaPago query(FormaPago proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);

            stmt.setInt(1, proveedor.getPK_codigo_pago());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                int  PK_Codigo_Pago = rs.getInt("PK_codigo_pago");
                String codigo_Proveedor = rs.getString("codigo_proveedor");
                String tipo_Transaccion = rs.getString("tipo_transaccion");
                String forma_Pago = rs.getString("forma_pago");
                String dias_Pago = rs.getString("dias_pago");
                String fecha_Pago = rs.getString("fecha_pago");
                String estatus_Pago = rs.getString("estatus_pago");
                

                proveedor = new FormaPago();
                proveedor.setPK_codigo_pago (PK_Codigo_Pago );
                proveedor.setCodigo_proveedor(codigo_Proveedor);
                proveedor.setTipo_pago(tipo_Transaccion);
                proveedor.setForma_pago(forma_Pago);
                proveedor.setDias_pago(dias_Pago);
                proveedor.setFecha_pago(fecha_Pago);
                proveedor.setEstatus_pago(estatus_Pago);
                
                

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
    public int delete(FormaPago aplicacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, aplicacion.getPK_codigo_pago());
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
    
    public int update(FormaPago proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, proveedor.getCodigo_proveedor());
            stmt.setString(2, proveedor.getTipo_pago());
            stmt.setString(3, proveedor.getForma_pago());
            stmt.setString(4, proveedor.getDias_pago());
            stmt.setString(5, proveedor.getFecha_pago());
            stmt.setString(6, proveedor.getEstatus_pago());
            stmt.setInt(7, proveedor.getPK_codigo_pago());
            
            
            
            
        
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
