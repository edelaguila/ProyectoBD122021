/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Huespedes;
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
public class HuespedesDAO {
    public static String codigoAuxiliar, nombreAuxiliar, apellidoAuxiliar;
    private static final String SQL_INSERT = "insert into tbl_huesped values(?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_huesped SET nombre_huesped=?, apellido_huesped=?, nacionalidad_huesped=?, direccion_huesped=?, sexo_huesped=?, telefono_huesped=?, cumpleaños_huesped=? WHERE PK_no_identificacion=?";
    private static final String SQL_QUERY = "SELECT PK_no_identificacion, nombre_huesped, apellido_huesped, nacionalidad_huesped, direccion_huesped, sexo_huesped, telefono_huesped, cumpleaños_huesped FROM tbl_huesped WHERE PK_no_identificacion = ?";
    private static final String SQL_DELETE = "delete from tbl_huesped where PK_no_identificacion = ?";
    
    public int insert(Huespedes huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, huespedes.getPasaporte());
            stmt.setString(2, huespedes.getNombre());
            stmt.setString(3, huespedes.getApellido());
            stmt.setString(4, huespedes.getNacionalidad());
            stmt.setString(5, huespedes.getDireccion());
            stmt.setString(6, huespedes.getSexo());
            stmt.setString(7, huespedes.getTelefono());
            stmt.setString(8, huespedes.getCumple());

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
    
    public int update(Huespedes huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//          System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, huespedes.getNombre());
            stmt.setString(2, huespedes.getApellido());
            stmt.setString(3, huespedes.getNacionalidad());
            stmt.setString(4, huespedes.getDireccion());
            stmt.setString(5, huespedes.getSexo());
            stmt.setString(6, huespedes.getTelefono());
            stmt.setString(7, huespedes.getCumple());
            stmt.setString(8, huespedes.getPasaporte());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public List<Huespedes> select() {

        String SQL_SELECT = "SELECT * FROM tbl_huesped WHERE PK_no_identificacion LIKE '%"+codigoAuxiliar+"%' OR nombre_huesped LIKE '%"+nombreAuxiliar+"%' OR apellido_huesped LIKE '%"+apellidoAuxiliar+"%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Huespedes huespedes = null;
        List<Huespedes> huesped = new ArrayList<Huespedes>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_no_identificacion");
                String nombre = rs.getString("nombre_huesped");
                String apellido = rs.getString("apellido_huesped");
                String direccion = rs.getString("direccion_huesped");
                String nacionalidad = rs.getString("nacionalidad_huesped");
                String sexo = rs.getString("sexo_huesped");
                String telefono = rs.getString("telefono_huesped");
                String cumple = rs.getString("cumpleaños_huesped");
                huespedes = new Huespedes();
                huespedes.setPasaporte(id);
                huespedes.setNombre(nombre);
                huespedes.setApellido(apellido);
                huespedes.setNacionalidad(nacionalidad);
                huespedes.setDireccion(direccion);
                huespedes.setSexo(sexo);
                huespedes.setTelefono(telefono);
                huespedes.setCumple(cumple);

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
    
    public Huespedes query(Huespedes huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, huespedes.getPasaporte());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_no_identificacion");
                String nombre = rs.getString("nombre_huesped");
                String apellido = rs.getString("apellido_huesped");
                String direccion = rs.getString("direccion_huesped");
                String nacionalidad = rs.getString("nacionalidad_huesped");
                String sexo = rs.getString("sexo_huesped");
                String telefono = rs.getString("telefono_huesped");
                String cumple = rs.getString("cumpleaños_huesped");

                huespedes = new Huespedes();
                huespedes.setPasaporte(id);
                huespedes.setNombre(nombre);
                huespedes.setApellido(apellido);
                huespedes.setNacionalidad(nacionalidad);
                huespedes.setDireccion(direccion);
                huespedes.setSexo(sexo);
                huespedes.setTelefono(telefono);
                huespedes.setCumple(cumple);
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
    
    public int delete(Huespedes huespedes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, huespedes.getPasaporte());
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
