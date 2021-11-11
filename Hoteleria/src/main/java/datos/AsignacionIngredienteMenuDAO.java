/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dominio.AsignacionIngresienteMenu;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JEFF
 */
public class AsignacionIngredienteMenuDAO {
    public static String codigoAuxiliar, nombreAuxiliar;
    private static final String SQL_INSERT = "insert into tbl_ingredientes_menu values(?,?,?,?)";
    private static final String SQL_DELETE = "delete from tbl_ingredientes_menu where PK_codigo_correlativo = ?";
    
    public int insert(AsignacionIngresienteMenu asignacionIngresienteMenu) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, "0");
            stmt.setString(2, asignacionIngresienteMenu.getIdPlato());
            stmt.setString(3, asignacionIngresienteMenu.getIdProducto());
            stmt.setString(4, asignacionIngresienteMenu.getCantidadIngrediente());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public List<AsignacionIngresienteMenu> select() {

        String SQL_SELECT = "SELECT * FROM tbl_ingredientes_menu WHERE PK_codigo_correlativo LIKE '%" + codigoAuxiliar + "%' OR id_plato_menu LIKE '%" + nombreAuxiliar + "%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AsignacionIngresienteMenu piso = null;
        List<AsignacionIngresienteMenu> pisos = new ArrayList<AsignacionIngresienteMenu>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_codigo_correlativo");
                String plato = rs.getString("id_plato_menu");
                String producto = rs.getString("id_codigo_producto");
                String cantidad = rs.getString("cantidad_ingrediente");

                piso = new AsignacionIngresienteMenu();
                piso.setIdCorrelativo(id);
                piso.setIdPlato(plato);
                piso.setIdProducto(producto);
                piso.setCantidadIngrediente(cantidad);

                pisos.add(piso);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return pisos;
    }
    
    public List<AsignacionIngresienteMenu> selectProductos() {

        String SQL_SELECT = "SELECT tbl_producto.PK_codigo_producto as id, tbl_producto.nombre_producto as nombre, tbl_unidad.nombre_unidad as unidad FROM tbl_producto INNER JOIN tbl_unidad ON tbl_producto.codigo_unidad = tbl_unidad.PK_codigo_unidad WHERE tbl_producto.estatus_producto='1'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AsignacionIngresienteMenu piso = null;
        List<AsignacionIngresienteMenu> pisos = new ArrayList<AsignacionIngresienteMenu>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String plato = rs.getString("nombre");
                String producto = rs.getString("unidad");

                piso = new AsignacionIngresienteMenu();
                piso.setIdPlato(id);
                piso.setNombrePlato(plato);
                piso.setUnidadPlato(producto);

                pisos.add(piso);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return pisos;
    }
    
    public int delete(AsignacionIngresienteMenu asignacionIngresienteMenu) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, asignacionIngresienteMenu.getIdCorrelativo());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
}
