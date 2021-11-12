/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;

import Comercial.dominio.Bodega;
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
public class BodegaDAO {

    private static final String SQL_SELECT = "SELECT PK_codigo_bodega, nombre_bodega, estatus_bodega FROM tbl_bodega";
    private static final String SQL_INSERT = "INSERT INTO tbl_bodega (PK_codigo_bodega, nombre_bodega, estatus_bodega) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_bodega SET  nombre_bodega= ?, estatus_bodega= ? WHERE PK_codigo_bodega=?";
    private static final String SQL_QUERY = "SELECT PK_codigo_bodega, nombre_bodega, estatus_bodega FROM tbl_bodega WHERE PK_codigo_bodega=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_bodega WHERE PK_codigo_bodega=?";

    public List<Bodega> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Bodega bodega = null;
        List<Bodega> bodegas = new ArrayList<Bodega>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int PK_codigo_bodega = rs.getInt("PK_codigo_bodega");
                String nombre_bodega = rs.getString("nombre_bodega");
                String estatus_bodega = rs.getString("estatus_bodega");

                bodega = new Bodega();
                bodega.setPKcodigoBodega(PK_codigo_bodega);
                bodega.setNombreBodega(nombre_bodega);
                bodega.setEstatusBodega(estatus_bodega);

                bodegas.add(bodega);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return bodegas;
    }

    public int insert(Bodega bodega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, bodega.getPKcodigoBodega());
            stmt.setString(2, bodega.getNombreBodega());
            stmt.setString(3, bodega.getEstatusBodega());

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

    public int update(Bodega bodega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, bodega.getNombreBodega());
            stmt.setString(2, bodega.getEstatusBodega());
            stmt.setInt(3, bodega.getPKcodigoBodega());
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

    public Bodega query(Bodega bodega) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Bodega> bodegas = new ArrayList<Bodega>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, bodega.getPKcodigoBodega());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int PK_codigo_bodega = rs.getInt("PK_codigo_bodega");
                String nombre_bodega = rs.getString("nombre_bodega");
                String estatus_bodega = rs.getString("estatus_bodega");

                bodega = new Bodega();
                bodega.setPKcodigoBodega(PK_codigo_bodega);
                bodega.setNombreBodega(nombre_bodega);
                bodega.setEstatusBodega(estatus_bodega);

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
        return bodega;
    }

    public int delete(Bodega bodega) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, bodega.getPKcodigoBodega());
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
