/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas.datos;


import Finanzas.dominio.Puesto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author OtakuGT
 */
public class PuestoDAO extends Conexion{
    private static final String SQL_SELECT = "SELECT * FROM tbl_puesto";
    private static final String SQL_INSERT = "INSERT INTO tbl_puesto(PK_id_puesto, nombre_puesto, salario_puesto) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_puesto SET nombre_puesto=?, salario_puesto=? WHERE PK_id_puesto=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_puesto WHERE PK_id_puesto=?";
    private static final String SQL_QUERY = "SELECT PK_id_puesto, nombre_puesto, salario_puesto FROM tbl_puesto WHERE PK_id_puesto = ?";

    Conexion conectar = new Conexion();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Puesto puesto = null;

    public List<Puesto> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Puesto puesto = null;
        List<Puesto> puestos = new ArrayList<Puesto>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_puesto = rs.getInt("PK_id_puesto");
                String nombre = rs.getString("nombre_puesto");
                double salario = rs.getDouble("salario_puesto");

                puesto = new Puesto();
                puesto.setId_puesto(id_puesto);
                puesto.setNombre_puesto(nombre);
                puesto.setSalario_puesto(salario);


                puestos.add(puesto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return puestos;
    }

    public Puesto query(Puesto puesto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, puesto.getId_puesto());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_puesto = rs.getInt("PK_id_puesto");
                String nombre_puesto = rs.getString("nombre_puesto");
                double salario_puesto = rs.getDouble("salario_puesto");

                puesto = new Puesto();
                puesto.setId_puesto(id_puesto);
                puesto.setNombre_puesto(nombre_puesto);
                puesto.setSalario_puesto(salario_puesto);

                rows++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return puesto;
    }
    

    public int delete(Puesto puesto) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, puesto.getId_puesto());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Puesto puesto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, puesto.getNombre_puesto());
            stmt.setDouble(2, puesto.getSalario_puesto());
            stmt.setInt(3, puesto.getId_puesto());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int insert(Puesto puesto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, puesto.getId_puesto());
            stmt.setString(2, puesto.getNombre_puesto());
            stmt.setDouble(3, puesto.getSalario_puesto());
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


