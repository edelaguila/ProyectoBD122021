/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Herbert Leonel Dominguez Chavez
 */
public class ServicioDAO {

    public static String codigoAuxiliar, nombreAuxiliar;
    private static final String SQL_INSERT = "insert into tbl_servicios values(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_servicios SET nombre_servicio=?, descripcion_servicio=?, precio_servicio=?, tipo_servicio=?, estado_servicio=? WHERE PK_id_servicio=?";
    private static final String SQL_QUERY = "SELECT PK_id_servicio, nombre_servicio, descripcion_servicio, precio_servicio, tipo_servicio, estado_servicio FROM tbl_servicios WHERE PK_id_servicio = ?";
    private static final String SQL_DELETE = "delete from tbl_servicios where PK_id_servicio = ?";

    public int insert(Servicio servicios) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, servicios.getId());
            stmt.setString(2, servicios.getNombre());
            stmt.setString(3, servicios.getDescripcion());
            stmt.setString(4, servicios.getPrecio());
            stmt.setString(5, servicios.getTipo());
            stmt.setString(6, servicios.getEstado());

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

    public int update(Servicio servicios) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//          System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, servicios.getNombre());
            stmt.setString(2, servicios.getDescripcion());
            stmt.setString(3, servicios.getPrecio());
            stmt.setString(4, servicios.getTipo());
            stmt.setString(5, servicios.getEstado());
            stmt.setString(6, servicios.getId());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public List<Servicio> select() {

        String SQL_SELECT = "SELECT * FROM tbl_servicios WHERE PK_id_servicio LIKE '%"+codigoAuxiliar+"%' OR nombre_servicio LIKE '%"+nombreAuxiliar+"%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Servicio servicio = null;
        List<Servicio> servicios = new ArrayList<Servicio>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_id_servicio");
                String nombre = rs.getString("nombre_servicio");
                String descripcion = rs.getString("descripcion_servicio");
                String precio = rs.getString("precio_servicio");
                String tipo = rs.getString("tipo_servicio");
                String estado = rs.getString("estado_servicio");

                servicio = new Servicio();
                servicio.setId(id);
                servicio.setNombre(nombre);
                servicio.setDescripcion(descripcion);
                servicio.setPrecio(precio);
                servicio.setTipo(tipo);
                servicio.setEstado(estado);

                servicios.add(servicio);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return servicios;
    }

    public Servicio query(Servicio servicios) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, servicios.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_id_servicio");
                String nombre = rs.getString("nombre_servicio");
                String descripcion = rs.getString("descripcion_servicio");
                String precio = rs.getString("precio_servicio");
                String tipo = rs.getString("tipo_servicio");
                String estado = rs.getString("estado_servicio");

                servicios = new Servicio();
                servicios.setId(id);
                servicios.setNombre(nombre);
                servicios.setDescripcion(descripcion);
                servicios.setPrecio(precio);
                servicios.setTipo(tipo);
                servicios.setEstado(estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return servicios;
    }

    public int delete(Servicio servicios) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, servicios.getId());
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
