/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Menu;
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
public class MenuDAO {
    public static String codigoAuxiliar, nombreAuxiliar;
    private static final String SQL_INSERT = "insert into tbl_menu_restaurante values(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_menu_restaurante SET nombre_plato=?, descripcion_plato=?, precio_plato=?, estado_plato=? WHERE PK_codigo_correlativo=?";
    private static final String SQL_QUERY = "SELECT PK_codigo_correlativo, nombre_plato, descripcion_plato, precio_plato, estado_plato FROM tbl_menu_restaurante WHERE PK_codigo_correlativo = ?";
    private static final String SQL_DELETE = "delete from tbl_menu_restaurante where PK_codigo_correlativo = ?";

    public int insert(Menu menu) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, menu.getId());
            stmt.setString(2, menu.getNombre());
            stmt.setString(3, menu.getDescripcion());
            stmt.setString(4, menu.getPrecio());
            stmt.setString(5, menu.getEstado());

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

    public int update(Menu menu) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//          System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, menu.getNombre());
            stmt.setString(2, menu.getDescripcion());
            stmt.setString(3, menu.getPrecio());
            stmt.setString(4, menu.getEstado());
            stmt.setString(5, menu.getId());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public List<Menu> select() {

        String SQL_SELECT = "SELECT * FROM tbl_menu_restaurante WHERE PK_codigo_correlativo LIKE '%"+codigoAuxiliar+"%' OR nombre_plato LIKE '%"+nombreAuxiliar+"%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Menu menu = null;
        List<Menu> servicios = new ArrayList<Menu>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_codigo_correlativo");
                String nombre = rs.getString("nombre_plato");
                String descripcion = rs.getString("descripcion_plato");
                String precio = rs.getString("precio_plato");
                String estado = rs.getString("estado_plato");

                menu = new Menu();
                menu.setId(id);
                menu.setNombre(nombre);
                menu.setDescripcion(descripcion);
                menu.setPrecio(precio);
                menu.setEstado(estado);

                servicios.add(menu);
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

    public Menu query(Menu menu) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, menu.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_codigo_correlativo");
                String nombre = rs.getString("nombre_plato");
                String descripcion = rs.getString("descripcion_plato");
                String precio = rs.getString("precio_plato");
                String estado = rs.getString("estado_plato");


                menu = new Menu();
                menu.setId(id);
                menu.setNombre(nombre);
                menu.setDescripcion(descripcion);
                menu.setPrecio(precio);
                menu.setEstado(estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return menu;
    }

    public int delete(Menu menu) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, menu.getId());
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
