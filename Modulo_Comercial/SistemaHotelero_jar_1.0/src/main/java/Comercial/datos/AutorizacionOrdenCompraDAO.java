/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;
import Comercial.dominio.AutorizacionOrdenCompra1;
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
public class AutorizacionOrdenCompraDAO {
 private static final String SQL_SELECT = "SELECT PK_codigo_autorizacion, codigo_ordencompra, nombre_autorizacion, departamento_autorizacion, fecha_autorizacion,  estatus_autorizacion FROM tbl_autorizacion_ordencompra";
    private static final String SQL_INSERT = "INSERT INTO tbl_autorizacion_ordencompra (PK_codigo_autorizacion, codigo_ordencompra, nombre_autorizacion, departamento_autorizacion, fecha_autorizacion,  estatus_autorizacion) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_autorizacion_ordencompra SET   codigo_ordencompra=?, nombre_autorizacion=?, departamento_autorizacion=?, fecha_autorizacion=?,  estatus_autorizacion=?    WHERE PK_codigo_autorizacion=?";
    private static final String SQL_QUERY = "SELECT PK_codigo_autorizacion, codigo_ordencompra, nombre_autorizacion, departamento_autorizacion, fecha_autorizacion,  estatus_autorizacion FROM tbl_autorizacion_ordencompra WHERE PK_codigo_autorizacion=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_autorizacion_ordencompra WHERE PK_codigo_autorizacion=?";    
public static final String SQL_QUERY2 = "SELECT PK_codigo_ordencompra FROM tbl_ordencompra_encabezado"; 

    public List<AutorizacionOrdenCompra1> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AutorizacionOrdenCompra1  proveedor = null;
        List<AutorizacionOrdenCompra1> proveedores = new ArrayList<AutorizacionOrdenCompra1>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int  PK_codigo_Autorizacion = rs.getInt("PK_codigo_autorizacion");
                String codigo_Ordencompra = rs.getString("codigo_ordencompra");
                String nombre_Autorizacion = rs.getString("nombre_autorizacion");
                String departamento_Autorizacion = rs.getString("departamento_autorizacion");
                String fecha_Autorizacion = rs.getString("fecha_autorizacion");
                String estatus_Autorizacion = rs.getString("estatus_autorizacion");

                proveedor = new AutorizacionOrdenCompra1();
                proveedor.setPK_codigo_autorizacion(PK_codigo_Autorizacion);
                proveedor.setCodigo_ordencompra(codigo_Ordencompra);
                proveedor.setNombre_autorizacion(nombre_Autorizacion);
                proveedor.setDepartamento_autorizacion(departamento_Autorizacion);
                proveedor.setFecha_autorizacion(fecha_Autorizacion);
                proveedor.setEstatus_autorizacion(estatus_Autorizacion);
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
    
    public int insert(AutorizacionOrdenCompra1 proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, proveedor.getPK_codigo_autorizacion());
            stmt.setString(2, proveedor.getCodigo_ordencompra());
            stmt.setString(3, proveedor.getNombre_autorizacion());
            stmt.setString(4, proveedor.getDepartamento_autorizacion());
            stmt.setString(5, proveedor.getFecha_autorizacion());
            stmt.setString(6, proveedor.getEstatus_autorizacion());

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
    
    public AutorizacionOrdenCompra1 query(AutorizacionOrdenCompra1 proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);

            stmt.setInt(1, proveedor.getPK_codigo_autorizacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                
          int  PK_codigo_Autorizacion = rs.getInt("PK_codigo_autorizacion");
                String codigo_Ordencompra = rs.getString("codigo_ordencompra");
                String nombre_Autorizacion = rs.getString("nombre_autorizacion");
                String departamento_Autorizacion = rs.getString("departamento_autorizacion");
                String fecha_Autorizacion = rs.getString("fecha_autorizacion");
                String estatus_Autorizacion = rs.getString("estatus_autorizacion");

                proveedor = new AutorizacionOrdenCompra1();
                proveedor.setPK_codigo_autorizacion(PK_codigo_Autorizacion);
                proveedor.setCodigo_ordencompra(codigo_Ordencompra);
                proveedor.setNombre_autorizacion(nombre_Autorizacion);
                proveedor.setDepartamento_autorizacion(departamento_Autorizacion);
                proveedor.setFecha_autorizacion(fecha_Autorizacion);
                proveedor.setEstatus_autorizacion(estatus_Autorizacion);
                

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
    
    public int delete( AutorizacionOrdenCompra1  aplicacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, aplicacion.getPK_codigo_autorizacion());
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
    
    
    public int update(AutorizacionOrdenCompra1 proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            
            stmt.setString(1, proveedor.getCodigo_ordencompra());
            stmt.setString(2, proveedor.getNombre_autorizacion());
            stmt.setString(3, proveedor.getDepartamento_autorizacion());
            stmt.setString(4, proveedor.getFecha_autorizacion());
            stmt.setString(5, proveedor.getEstatus_autorizacion());
            stmt.setInt(6, proveedor.getPK_codigo_autorizacion());
            
            
            
        
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
    
    public void query2(JComboBox txt_ordencompra) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY2);
            //stmt.setInt(1, aplicacion.getId_ModuloCbx());
            rs = stmt.executeQuery();

            txt_ordencompra.addItem("Seleccionar...");
            
            while (rs.next()) {
                txt_ordencompra.addItem(rs.getInt("PK_codigo_ordencompra"));
                
            }
            //System.out.println("Registros buscado:" + aplicacion);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    
    
    
 }
    
    

}
