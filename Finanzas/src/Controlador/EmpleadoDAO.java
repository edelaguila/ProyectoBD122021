/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Conexion;
import Modelo.Empleado;
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
public class EmpleadoDAO extends Conexion {
    private static final String SQL_SELECT = "SELECT * FROM tbl_empleado";
    private static final String SQL_INSERT = "INSERT INTO tbl_empleado(PK_id_empleado, nombre_empleado, apellido_empleado, dpi_empleado, correo_empleado, puesto_empleado, estado_empleado, fechacontrato_empleado) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_empleado SET nombre_empleado=?, apellido_empleado=?,dpi_empleado=?, correo_empleado=?, puesto_empleado=?, estado_empleado=?, fechacontrato_empleado=? WHERE PK_id_empleado=?";
    private static final String SQL_DELETE = "DELETE FROM tbl_empleado WHERE PK_id_empleado=?";
    private static final String SQL_QUERY = "SELECT PK_id_empleado, nombre_empleado, apellido_empleado, dpi_empleado, correo_empleado, puesto_empleado, estado_empleado, fechacontrato_empleado FROM tbl_empleado WHERE PK_id_empleado = ?";

    Conexion conectar = new Conexion();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Empleado empleado = null;

    public List<Empleado> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleado empleado = null;
        List<Empleado> empleados = new ArrayList<Empleado>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_empleado = rs.getInt("PK_id_empleado");
                String nombre = rs.getString("nombre_empleado");
                String apellido = rs.getString("apellido_empleado");
                int dpi = rs.getInt("dpi_empleado");
                String correo = rs.getString("correo_empleado");
                String puesto = rs.getString("puesto_empleado");                
                int estado = rs.getInt("estado_empleado");
                String contrato = rs.getString("fechacontrato_empleado");

                empleado = new Empleado();
                empleado.setId_empleado(id_empleado);
                empleado.setNombre_empleado(nombre);
                empleado.setApellido_empleado(apellido);
                empleado.setDpi_empleado(dpi);
                empleado.setCorreo_empleado(correo);
                empleado.setPuesto_empleado(puesto);
                empleado.setEstado_empleado(estado);
                empleado.setFcontrato_empleado(contrato);

                empleados.add(empleado);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return empleados;
    }

    public Empleado query(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, empleado.getId_empleado());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_empleado = rs.getInt("PK_id_empleado");
                String nombre_empleado = rs.getString("nombre_empleado");
                String apellido_empleado = rs.getString("apellido_empleado");
                int dpi_empleado = rs.getInt("dpi_empleado");
                String correo_empleado = rs.getString("correo_empleado");
                String puesto_empleado = rs.getString("puesto_empleado");
                int estado_empleado = rs.getInt("estado_empleado");
                String fcontrato_empleado = rs.getString("fechacontrato_empleado");

                empleado = new Empleado();
                empleado.setId_empleado(id_empleado);
                empleado.setNombre_empleado(nombre_empleado);
                empleado.setApellido_empleado(apellido_empleado);
                empleado.setDpi_empleado(dpi_empleado);
                empleado.setCorreo_empleado(correo_empleado);
                empleado.setPuesto_empleado(puesto_empleado);
                empleado.setEstado_empleado(estado_empleado);
                empleado.setFcontrato_empleado(fcontrato_empleado);

                rows++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return empleado;
    }
    

    public int delete(Empleado empleado) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, empleado.getId_empleado());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, empleado.getNombre_empleado());
            stmt.setString(2, empleado.getApellido_empleado());
            stmt.setInt(3, empleado.getDpi_empleado());
            stmt.setString(4, empleado.getCorreo_empleado());
            stmt.setString(5, empleado.getPuesto_empleado());
            stmt.setInt(6, empleado.getEstado_empleado());
            stmt.setString(7, empleado.getFcontrato_empleado());
            stmt.setInt(8, empleado.getId_empleado());
            rows = stmt.executeUpdate();
            //System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int insert(Empleado empleado) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, empleado.getId_empleado());
            stmt.setString(2, empleado.getNombre_empleado());
            stmt.setString(3, empleado.getApellido_empleado());
            stmt.setInt(4, empleado.getDpi_empleado());
            stmt.setString(5, empleado.getCorreo_empleado());
            stmt.setString(6, empleado.getPuesto_empleado());
            stmt.setInt(7, empleado.getEstado_empleado());
            stmt.setString(8, empleado.getFcontrato_empleado());
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
