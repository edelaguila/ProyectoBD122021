/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;


import Comercial.dominio.Tipo_Documento;
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
public class Tipo_DocumentoDAO {
    private static final String SQL_SELECT = "SELECT Pk_codigo_tipo_documento, nombre_tipo_documento, estatus_tipo_documento "
            + "FROM tbl_tipo_documento";

    private static final String SQL_INSERT = "INSERT INTO tbl_tipo_documento "
            + "(Pk_codigo_tipo_documento, nombre_tipo_documento, estatus_tipo_documento) "
            + "VALUES(?,?,?)";

    private static final String SQL_UPDATE = "UPDATE tbl_tipo_documento "
            + "SET  nombre_tipo_documento= ?, estatus_tipo_documento= ? WHERE Pk_codigo_tipo_documento=?";

    private static final String SQL_QUERY = "SELECT Pk_codigo_tipo_documento, nombre_tipo_documento, estatus_tipo_documento"
            + " FROM tbl_tipo_documento WHERE Pk_codigo_tipo_documento=?";

    private static final String SQL_DELETE = "DELETE FROM tbl_tipo_documento WHERE Pk_codigo_tipo_documento=?";

    public List<Tipo_Documento> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tipo_Documento tipodocumento = null;
        List<Tipo_Documento> documentos = new ArrayList<Tipo_Documento>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String Pk_codigo_tipo_documento = rs.getString("Pk_codigo_tipo_documento");
                String nombre_tipo_documento = rs.getString("nombre_tipo_documento");
                String estatus_tipo_documento = rs.getString("estatus_tipo_documento");

                tipodocumento = new Tipo_Documento();
                tipodocumento.setPk_codigo_tipo_documento(Pk_codigo_tipo_documento);
                tipodocumento.setNombre_tipo_documento(nombre_tipo_documento);
                tipodocumento.setEstatus_tipo_documento(estatus_tipo_documento);

                documentos.add(tipodocumento);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return documentos;
    }

    public int insert(Tipo_Documento documento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, documento.getPk_codigo_tipo_documento());
            stmt.setString(2, documento.getNombre_tipo_documento());
            stmt.setString(3, documento.getEstatus_tipo_documento());

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

    public int update(Tipo_Documento documento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, documento.getNombre_tipo_documento());
            stmt.setString(2, documento.getEstatus_tipo_documento());
            stmt.setString(3, documento.getPk_codigo_tipo_documento());
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

    public Tipo_Documento query(Tipo_Documento documento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Tipo_Documento> documentos = new ArrayList<Tipo_Documento>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, documento.getPk_codigo_tipo_documento());
            rs = stmt.executeQuery();

            while (rs.next()) {
                String Pk_codigo_tipo_documento = rs.getString("Pk_codigo_tipo_documento");
                String nombre_tipo_documento = rs.getString("nombre_tipo_documento");
                String estatus_tipo_documento = rs.getString("estatus_tipo_documento");

                documento = new Tipo_Documento();
                documento.setPk_codigo_tipo_documento(Pk_codigo_tipo_documento);
                documento.setNombre_tipo_documento(nombre_tipo_documento);
                documento.setEstatus_tipo_documento(estatus_tipo_documento);

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
        return documento;
    }

    public int delete(Tipo_Documento documento) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, documento.getPk_codigo_tipo_documento());
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
