/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;

import Comercial.dominio.Proveedor;
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
 * @author SipaqueRita
 */
public class ProveedorDAO {

    private static final String SQL_SELECT = "SELECT PK_codigo_proveedor, nombre_proveedor, direccion_proveedor,  telefono_proveedor, nit_proveedor, email_proveedor, representante_proveedor, estatus_proveedor FROM tbl_proveedor";
    private static final String SQL_INSERT = "INSERT INTO tbl_proveedor (PK_codigo_proveedor, nombre_proveedor, direccion_proveedor,  telefono_proveedor, nit_proveedor, email_proveedor, representante_proveedor, estatus_proveedor) VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_proveedor SET  nombre_proveedor=?, direccion_proveedor=?,  telefono_proveedor=?, nit_proveedor=?, email_proveedor=?, representante_proveedor=?, estatus_proveedor=?    WHERE PK_codigo_proveedor=?";
    private static final String SQL_QUERY = "SELECT PK_codigo_proveedor, nombre_proveedor, direccion_proveedor, telefono_proveedor, nit_proveedor, email_proveedor, representante_proveedor ,estatus_proveedor FROM tbl_proveedor WHERE PK_codigo_proveedor= ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_proveedor WHERE PK_codigo_proveedor=?";
    public static final String SQL_QUERY2 = "SELECT PK_codigo_proveedor FROM tbl_proveedor";

    public List<Proveedor> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Proveedor proveedor = null;
        List<Proveedor> proveedores = new ArrayList<Proveedor>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String PK_codigo_Proveedor = rs.getString("PK_codigo_proveedor");
                String nombre_Proveedor = rs.getString("nombre_proveedor");
                String direccion_Proveedor = rs.getString("direccion_proveedor");
                String telefono_Proveedor = rs.getString("telefono_proveedor");
                String nit_Proveedor = rs.getString("nit_proveedor");
                String email_Proveedor = rs.getString("email_proveedor");
                String saldo_Proveedor = rs.getString("representante_proveedor");
                String estatus_Proveedor = rs.getString("estatus_proveedor");

                proveedor = new Proveedor();
                proveedor.setPK_codigo_Proveedor(PK_codigo_Proveedor);
                proveedor.setNombre_Proveedor(nombre_Proveedor);
                proveedor.setDireccion_Proveedor(direccion_Proveedor);
                proveedor.setTelefono_Proveedor(telefono_Proveedor);
                proveedor.setNit_Proveedor(nit_Proveedor);
                proveedor.setEmail_Proveedor(email_Proveedor);
                proveedor.setSaldo_Proveedor(saldo_Proveedor);
                proveedor.setEstatus_Proveedor(estatus_Proveedor);
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

    public int insert(Proveedor proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, proveedor.getPK_codigo_Proveedor());
            stmt.setString(2, proveedor.getNombre_Proveedor());
            stmt.setString(3, proveedor.getDireccion_Proveedor());
            stmt.setString(4, proveedor.getTelefono_Proveedor());
            stmt.setString(5, proveedor.getNit_Proveedor());
            stmt.setString(6, proveedor.getEmail_Proveedor());
            stmt.setString(7, proveedor.getSaldo_Proveedor());
            stmt.setString(8, proveedor.getEstatus_Proveedor());

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

    public Proveedor query(Proveedor proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);

            stmt.setString(1, proveedor.getPK_codigo_Proveedor());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String codigoProveedor = rs.getString("PK_codigo_proveedor");
                String nombreProveedor = rs.getString("nombre_proveedor");
                String direccionProveedor = rs.getString("direccion_proveedor");
                String telefonoProveedor = rs.getString("telefono_proveedor");
                String nitProveedor = rs.getString("nit_proveedor");
                String emailProveedor = rs.getString("email_proveedor");
                String saldoProveedor = rs.getString("representante_proveedor");
                String estatusProveedor = rs.getString("estatus_proveedor");

                proveedor = new Proveedor();
                proveedor.setPK_codigo_Proveedor(codigoProveedor);
                proveedor.setNombre_Proveedor(nombreProveedor);
                proveedor.setDireccion_Proveedor(direccionProveedor);
                proveedor.setTelefono_Proveedor(telefonoProveedor);
                proveedor.setNit_Proveedor(nitProveedor);
                proveedor.setEmail_Proveedor(emailProveedor);
                proveedor.setSaldo_Proveedor(saldoProveedor);
                proveedor.setEstatus_Proveedor(estatusProveedor);

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

    public int delete(Proveedor aplicacion) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, aplicacion.getPK_codigo_Proveedor());
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

    public int update(Proveedor proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            
            stmt.setString(1, proveedor.getNombre_Proveedor());
            stmt.setString(2, proveedor.getDireccion_Proveedor());
            stmt.setString(3, proveedor.getTelefono_Proveedor());
            stmt.setString(4, proveedor.getNit_Proveedor());
            stmt.setString(5, proveedor.getEmail_Proveedor());
            stmt.setString(6, proveedor.getSaldo_Proveedor());
            stmt.setString(7, proveedor.getEstatus_Proveedor());
            stmt.setString(8, proveedor.getPK_codigo_Proveedor());

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

    public void query2(JComboBox txt_combox) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY2);
            //stmt.setInt(1, aplicacion.getId_ModuloCbx());
            rs = stmt.executeQuery();

            txt_combox.addItem("Seleccionar...");

            while (rs.next()) {
                txt_combox.addItem(rs.getInt("PK_codigo_proveedor"));
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

    public List<Proveedor> listar() {
        List<Proveedor> proveedores = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setPK_codigo_Proveedor(rs.getString(1));
                proveedor.setNombre_Proveedor(rs.getString(2));
                proveedor.setDireccion_Proveedor(rs.getString(3));
                proveedor.setTelefono_Proveedor(rs.getString(4));
                proveedor.setNit_Proveedor(rs.getString(5));
                proveedor.setEmail_Proveedor(rs.getString(6));
                proveedor.setSaldo_Proveedor(rs.getString(7));
                proveedor.setEstatus_Proveedor(rs.getString(8));


                proveedores.add(proveedor);
            }
        } catch (Exception e) {
        }
        return proveedores;
    }

}
