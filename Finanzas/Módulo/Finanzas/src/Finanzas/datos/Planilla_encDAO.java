/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas.datos;

import Finanzas.dominio.Planilla_enc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author OtakuGT
 */
public class Planilla_encDAO extends Conexion {
    private static final String SQL_SELECT = "SELECT * FROM planilla_enc";
    private static final String SQL_INSERT = "INSERT INTO planilla_enc(id_conceptoPlanilla, total_percepcion, total_deduccion, total_liquido) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE planilla_enc SET total_percepcion=?, total_deduccion=?, total_liquido=? WHERE id_planillaenc=?";
    private static final String SQL_DELETE = "DELETE FROM planilla_enc WHERE id_planillaenc=?";
    private static final String SQL_QUERY = "SELECT id_planillaenc, total_percepcion, total_deduccion, total_liquido FROM planilla_enc WHERE id_planillaenc = ?";
 

    Conexion conectar = new Conexion();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Planilla_enc enc = null;

    public List<Planilla_enc> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Planilla_enc enc = null;
        List<Planilla_enc> encs = new ArrayList<Planilla_enc>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_planillaenc");
                double percep = rs.getDouble("total_percepcion");
                double deduc = rs.getDouble("total_deduccion");
                double total = rs.getDouble("total_liquido");

                enc = new Planilla_enc();
                enc.setId_planen(id);
                enc.setTotal_percep(percep);
                enc.setTotal_deduc(deduc);
                enc.setTotal_liq(total);



                encs.add(enc);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return encs;
    }
        public Planilla_enc query(Planilla_enc enc) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, enc.getId_planen());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_planillaenc");
                double percep = rs.getDouble("total_percepcion");
                double deduc = rs.getDouble("total_deduccion");
                double total = rs.getDouble("total_liquido");


                enc = new Planilla_enc();
                enc.setId_planen(id);
                enc.setTotal_percep(percep);
                enc.setTotal_deduc(deduc);
                enc.setTotal_liq(total);

                rows++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return enc;
    }
    

    public int delete(Planilla_enc enc) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, enc.getId_planen());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Planilla_enc enc) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, enc.getId_planen());
            stmt.setDouble(2, enc.getTotal_percep());
            stmt.setDouble(3, enc.getTotal_deduc());
            stmt.setDouble(4, enc.getTotal_liq());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int insert(Planilla_enc enc) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, enc.getId_planen());
            stmt.setDouble(2, enc.getTotal_percep());
            stmt.setDouble(3, enc.getTotal_deduc());
            stmt.setDouble(4, enc.getTotal_liq());
            stmt.executeUpdate();
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return 1;
    }
    }

