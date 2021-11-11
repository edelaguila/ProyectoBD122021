/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.CocinaRestaurante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leone
 */
public class CocinaRestauranteDAO {

    public static String codigoAuxiliar, nombreAuxiliar, existenciasAux;
    private static final String SQL_INSERT = "insert into tbl_cocina_restaurante values(?,?,?,?)";
    private static final String SQL_DELETE = "delete from tbl_cocina_restaurante where PK_codigo_correlativo = ?";
    private static final String SQL_UPDATE = "UPDATE tbl_existencia SET cantidad_existencia=? WHERE Pk_codigo_producto=?";
    private static final String SQL_SELECT2 = "SELECT * FROM tbl_existencia WHERE Pk_codigo_producto=? AND cantidad_existencia>'0' AND estatus_existencia='1'";
    
    public int insert(CocinaRestaurante cocinar) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, "0");
            stmt.setString(2, cocinar.getHora());
            stmt.setString(3, cocinar.getOrden());
            stmt.setString(4, cocinar.getMenu());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public List<CocinaRestaurante> select() {

        String SQL_SELECT = "SELECT * FROM tbl_cocina_restaurante WHERE id_orden LIKE '%" + codigoAuxiliar + "%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CocinaRestaurante piso = null;
        List<CocinaRestaurante> pisos = new ArrayList<CocinaRestaurante>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String correlativo = rs.getString("Pk_correlativo_cocina");
                String hora = rs.getString("hora_despacho");
                String orden = rs.getString("id_orden");
                String menu = rs.getString("PK_id_menu");
                piso = new CocinaRestaurante();
                piso.setCorrelativo(correlativo);
                piso.setHora(hora);
                piso.setOrden(orden);
                piso.setMenu(menu);

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

    public CocinaRestaurante query(CocinaRestaurante plato) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_SELECT2);
            stmt.setString(1, plato.getIngrediente());
            rs = stmt.executeQuery();

            while (rs.next()) {
                String existencias = rs.getString("cantidad_existencia");
                plato = new CocinaRestaurante();
                existenciasAux = existencias;
                plato.setNuevaExistencia(existencias);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return plato;
    }

    public int delete(CocinaRestaurante cocinar) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, cocinar.getCorrelativo());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(CocinaRestaurante cocinar) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
//          System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cocinar.getNuevaExistencia());
            stmt.setString(2, cocinar.getIngrediente());
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
