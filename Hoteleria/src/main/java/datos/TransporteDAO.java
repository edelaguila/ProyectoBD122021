/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Transporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leelu
 */
public class TransporteDAO {
    public static String codigoAuxiliar;
    private static final String SQL_INSERT = "insert into tbl_transporte values(?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_transporte SET clase_transporte=? WHERE PK_codigo_transporte=?";
    private static final String SQL_QUERY = "SELECT PK_codigo_transporte, clase_transporte FROM tbl_transporte WHERE PK_codigo_transporte = ?";
    private static final String SQL_DELETE = "delete from tbl_transporte where PK_codigo_transporte = ?";
    
    public int insert(Transporte huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, huespedes.getId());
            stmt.setString(2, huespedes.getNombre());

            //System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            //System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public int update(Transporte huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//          System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, huespedes.getNombre());
            stmt.setString(2, huespedes.getId());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public List<Transporte> select() {

        String SQL_SELECT = "SELECT * FROM tbl_transporte WHERE PK_codigo_transporte LIKE '%"+codigoAuxiliar+"%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Transporte huespedes = null;
        List<Transporte> huesped = new ArrayList<Transporte>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_codigo_transporte");
                String nombre = rs.getString("clase_transporte");
                huespedes = new Transporte();
                huespedes.setId(id);
                huespedes.setNombre(nombre);

                huesped.add(huespedes);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return huesped;
    }
    
    public Transporte query(Transporte huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, huespedes.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_codigo_transporte");
                String nombre = rs.getString("clase_transporte");

                huespedes = new Transporte();
                huespedes.setId(id);
                huespedes.setNombre(nombre);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return huespedes;
    }
    
    public int delete(Transporte huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, huespedes.getId());
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
