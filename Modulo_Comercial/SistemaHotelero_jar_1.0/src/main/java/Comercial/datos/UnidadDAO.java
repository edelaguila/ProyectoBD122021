/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;

import Comercial.dominio.Bodega;
import Comercial.dominio.Unidad;
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
 * @author Diana
 */
public class UnidadDAO {
    
    private static final String SQL_SELECT = "SELECT PK_codigo_unidad, nombre_unidad, medida_acronimo, estatus_unidad"
            + " FROM tbl_unidad";
    private static final String SQL_INSERT = "INSERT INTO tbl_unidad (PK_codigo_unidad, nombre_unidad, medida_acronimo,"
            + " estatus_unidad)"
            + " VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_unidad SET  nombre_unidad= ?, medida_acronimo= ?,"
            + " estatus_unidad=?"
            + " WHERE PK_codigo_unidad=?";
    
    private static final String SQL_QUERY = "SELECT PK_codigo_unidad, nombre_unidad, medida_acronimo, estatus_unidad"
            + " FROM tbl_unidad WHERE PK_codigo_unidad=?";
    
    private static final String SQL_DELETE = "DELETE FROM tbl_unidad WHERE PK_codigo_unidad=?";

    public List<Unidad> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Unidad unidad = null;
        List<Unidad> unidades = new ArrayList<Unidad>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String PKcodigoUnidad = rs.getString("PK_codigo_unidad");
                String nombre_unidad = rs.getString("nombre_unidad");
                String medida_acronimo = rs.getString("medida_acronimo");
                String estatus_unidad = rs.getString("estatus_unidad");

                unidad = new Unidad();
                unidad.setPKcodigoUnidad(PKcodigoUnidad);
                unidad.setNombre_unidad(nombre_unidad);
                unidad.setMedida_acronimo(medida_acronimo);
                unidad.setEstatus_unidad(estatus_unidad);
                unidades.add(unidad);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return unidades;
    }

    public int insert(Unidad unidad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, unidad.getPKcodigoUnidad());
            stmt.setString(2, unidad.getNombre_unidad());
            stmt.setString(3, unidad.getMedida_acronimo());
            stmt.setString(4, unidad.getEstatus_unidad());
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

    public int update(Unidad unidad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, unidad.getNombre_unidad());
            stmt.setString(2, unidad.getMedida_acronimo());
            stmt.setString(3, unidad.getEstatus_unidad());
            stmt.setString(4, unidad.getPKcodigoUnidad());
            
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

    public Unidad query(Unidad unidad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Unidad> unidades = new ArrayList<Unidad>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, unidad.getPKcodigoUnidad());
            rs = stmt.executeQuery();

            while (rs.next()) {
                String PKcodigoUnidad = rs.getString("PK_codigo_unidad");
                String nombre_unidad = rs.getString("nombre_unidad");
                String medida_acronimo = rs.getString("medida_acronimo");
                String estatus_unidad = rs.getString("estatus_unidad");

                unidad = new Unidad();

                unidad.setPKcodigoUnidad(PKcodigoUnidad);
                unidad.setNombre_unidad(nombre_unidad);
                unidad.setMedida_acronimo(medida_acronimo);
                unidad.setEstatus_unidad(estatus_unidad);

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
        return unidad;
    }

    public int delete(Unidad unidad) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, unidad.getPKcodigoUnidad());
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
