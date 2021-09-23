/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;

import Comercial.dominio.Bodega;
import Comercial.dominio.Transporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Diana
 */
public class TransporteDAO {

    private static final String SQL_SELECT = "SELECT PK_codigo_transporte, nombre_transporte, tipo_transporte, estatus_transporte FROM tbl_transporte";
    private static final String SQL_INSERT = "INSERT INTO tbl_transporte (PK_codigo_transporte, nombre_transporte, tipo_transporte, estatus_transporte) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_transporte SET  nombre_transporte= ?, tipo_transporte= ?, estatus_transporte=? WHERE PK_codigo_transporte=?";
    private static final String SQL_QUERY = "SELECT PK_codigo_transporte, nombre_transporte, tipo_transporte, estatus_transporte FROM tbl_transporte WHERE PK_codigo_transporte=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_transporte WHERE PK_codigo_transporte=?";

    public List<Transporte> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Transporte transporte = null;
        List<Transporte> transportes = new ArrayList<Transporte>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int PKcodigoTransporte = rs.getInt("PK_codigo_transporte");
                String nombreTransporte = rs.getString("nombre_transporte");
                String tipoTransporte = rs.getString("tipo_transporte");
                String estatusTransporte = rs.getString("estatus_transporte");
                
                transporte = new Transporte();
                transporte.setPKcodigoTransporte(PKcodigoTransporte);
                transporte.setNombreTransporte(nombreTransporte);
                transporte.setTipoTransporte(tipoTransporte);
                transporte.setEstatusTransporte(estatusTransporte);

                transportes.add(transporte);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return transportes;
    }

    public int insert(Transporte transporte) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, transporte.getPKcodigoTransporte());
            stmt.setString(2, transporte.getNombreTransporte());
            stmt.setString(3, transporte.getTipoTransporte());
            stmt.setString(4, transporte.getEstatusTransporte());
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

    public int update(Transporte transporte) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setInt(1, transporte.getPKcodigoTransporte());
            stmt.setString(2, transporte.getNombreTransporte());
            stmt.setString(3, transporte.getTipoTransporte());
            stmt.setString(4, transporte.getEstatusTransporte());
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

    public Transporte query(Transporte transporte) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Bodega> bodegas = new ArrayList<Bodega>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, transporte.getPKcodigoTransporte());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int PKcodigoTransporte = rs.getInt("PK_codigo_transporte");
                String nombreTransporte = rs.getString("nombre_transporte");
                String tipoTransporte = rs.getString("tipo_transporte");
                String estatusTransporte = rs.getString("estatus_transporte");

                transporte = new Transporte();
                transporte.setPKcodigoTransporte(PKcodigoTransporte);
                transporte.setNombreTransporte(nombreTransporte);
                transporte.setTipoTransporte(tipoTransporte);
                transporte.setEstatusTransporte(estatusTransporte);

                //empleados.add(empleado); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + empleado);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return empleados;  // Si se utiliza un ArrayList
        return transporte;
    }

    public int delete(Transporte transporte) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, transporte.getPKcodigoTransporte());
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

}
