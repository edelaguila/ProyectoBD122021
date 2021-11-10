/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.datos;



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

    private static final String SQL_SELECT = "SELECT PK_codigo_transporte, clase_transporte, marca_transporte,"
            + " modelo_transporte, tipo_transporte, placa_transporte, color_transporte, estado_transporte,"
            + "numero_motor_transporte, estatus_transporte FROM tbl_transporte";
    private static final String SQL_INSERT = "INSERT INTO tbl_transporte "
            + "(PK_codigo_transporte, clase_transporte, marca_transporte,"
            + " modelo_transporte, tipo_transporte, placa_transporte, color_transporte, estado_transporte,"
            + "numero_motor_transporte, estatus_transporte) VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_transporte SET  "
            + "clase_transporte= ?, marca_transporte= ?, modelo_transporte= ?, tipo_transporte= ?, "
            + "placa_transporte= ?, color_transporte= ?, estado_transporte= ?, numero_motor_transporte= ?,"
            + " estatus_transporte= ?"
            + " WHERE PK_codigo_transporte=?";
    private static final String SQL_QUERY = "SELECT PK_codigo_transporte, clase_transporte, marca_transporte,"
            + " modelo_transporte, tipo_transporte, placa_transporte, color_transporte, estado_transporte,"
            + "numero_motor_transporte, estatus_transporte FROM tbl_transporte WHERE PK_codigo_transporte=?";
    
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
                String PK_codigo_transporte = rs.getString("PK_codigo_transporte");
                String clase_transporte = rs.getString("clase_transporte");
                String marca_transporte = rs.getString("marca_transporte");
                String modelo_transporte = rs.getString("modelo_transporte");
                String tipo_transporte = rs.getString("tipo_transporte");
                String placa_transporte = rs.getString("placa_transporte");
                String color_transporte = rs.getString("color_transporte");
                String estado_transporte = rs.getString("estado_transporte");
                String numero_motor_transporte = rs.getString("numero_motor_transporte");
                String estatus_transporte = rs.getString("estatus_transporte");
                
                transporte = new Transporte();
                transporte.setPK_codigo_transporte(PK_codigo_transporte);
                transporte.setClase_transporte(clase_transporte);
                transporte.setMarca_transporte(marca_transporte);
                transporte.setModelo_transporte(modelo_transporte);
                transporte.setTipo_transporte(tipo_transporte);
                transporte.setPlaca_transporte(placa_transporte);
                transporte.setColor_transporte(color_transporte);
                transporte.setEstado_transporte(estado_transporte);
                transporte.setNumero_motor_transporte(numero_motor_transporte);
                transporte.setEstatus_transporte(estatus_transporte);

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
            stmt.setString(1, transporte.getPK_codigo_transporte());
            stmt.setString(2, transporte.getClase_transporte());
            stmt.setString(3, transporte.getMarca_transporte());
            stmt.setString(4, transporte.getModelo_transporte());
            stmt.setString(5, transporte.getTipo_transporte());
            stmt.setString(6, transporte.getPlaca_transporte());
            stmt.setString(7, transporte.getColor_transporte());
            stmt.setString(8, transporte.getEstado_transporte());
            stmt.setString(9, transporte.getNumero_motor_transporte());
            stmt.setString(10, transporte.getEstatus_transporte());
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

            stmt.setString(1, transporte.getClase_transporte());
            stmt.setString(2, transporte.getMarca_transporte());
            stmt.setString(3, transporte.getModelo_transporte());
            stmt.setString(4, transporte.getTipo_transporte());
            stmt.setString(5, transporte.getPlaca_transporte());
            stmt.setString(6, transporte.getColor_transporte());
            stmt.setString(7, transporte.getEstado_transporte());
            stmt.setString(8, transporte.getNumero_motor_transporte());
            stmt.setString(9, transporte.getEstatus_transporte());
            stmt.setString(10, transporte.getPK_codigo_transporte());            
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
        List<Transporte> trasnportes = new ArrayList<Transporte>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, transporte.getPK_codigo_transporte());
            rs = stmt.executeQuery();

            while (rs.next()) { 
                String PKcodigoTransporte = rs.getString("PK_codigo_transporte");
                String clase_transporte = rs.getString("clase_transporte");
                String marca_transporte = rs.getString("marca_transporte");
                String modelo_transporte = rs.getString("modelo_transporte");
                String tipo_transporte = rs.getString("tipo_transporte");
                String placa_transporte = rs.getString("placa_transporte");
                String color_transporte = rs.getString("color_transporte");
                String estado_transporte = rs.getString("estado_transporte");
                String numero_motor_transporte = rs.getString("numero_motor_transporte");
                String estatus_transporte = rs.getString("estatus_transporte");
                
                transporte = new Transporte();
                transporte.setPK_codigo_transporte(PKcodigoTransporte);
                transporte.setClase_transporte(clase_transporte);
                transporte.setMarca_transporte(marca_transporte);
                transporte.setModelo_transporte(modelo_transporte);
                transporte.setTipo_transporte(tipo_transporte);
                transporte.setPlaca_transporte(placa_transporte);
                transporte.setColor_transporte(color_transporte);
                transporte.setEstado_transporte(estado_transporte);
                transporte.setNumero_motor_transporte(numero_motor_transporte);
                transporte.setEstatus_transporte(estatus_transporte);

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
            stmt.setString(1, transporte.getPK_codigo_transporte());
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
