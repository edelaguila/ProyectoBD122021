
package datos;

import dominio.Impuesto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jefferson Dávila
 */
public class ImpuestoDAO {

    public static String codigoAuxiliar, nombreAuxiliar;
    private static final String SQL_INSERT = "insert into tbl_impuesto values(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_impuesto SET nombre_impuesto=?, valor_impuesto=?, descripcion_impuesto=?, estado_impuesto=? WHERE PK_id_impuesto=?";
    private static final String SQL_QUERY = "SELECT PK_id_impuesto, nombre_impuesto, valor_impuesto, descripcion_impuesto, estado_impuesto FROM tbl_impuesto WHERE PK_id_impuesto = ?";
    private static final String SQL_DELETE = "delete from tbl_impuesto where PK_id_impuesto = ?";

    public int insert(Impuesto impuesto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, impuesto.getIdImpuesto());
            stmt.setString(2, impuesto.getNombreImpuesto());
            stmt.setString(3, impuesto.getValorImpuesto());
            stmt.setString(4, impuesto.getDescripcionImpuesto());
            stmt.setString(5, impuesto.getEstadoImpuesto());

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

    public int update(Impuesto horario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//          System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, horario.getNombreImpuesto());
            stmt.setString(2, horario.getValorImpuesto());
            stmt.setString(3, horario.getDescripcionImpuesto());
            stmt.setString(4, horario.getEstadoImpuesto());
            stmt.setString(5, horario.getIdImpuesto());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public List<Impuesto> select() {

        String SQL_SELECT = "SELECT * FROM tbl_impuesto WHERE PK_id_impuesto LIKE '%"+codigoAuxiliar+"%' OR nombre_impuesto LIKE '%"+nombreAuxiliar+"%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Impuesto impuesto = null;
        List<Impuesto> impuestos = new ArrayList<Impuesto>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_id_impuesto");
                String nombre = rs.getString("nombre_impuesto");
                String valor = rs.getString("valor_impuesto");
                String descripcion = rs.getString("descripcion_impuesto");
                String estado = rs.getString("estado_impuesto");

                impuesto = new Impuesto();
                impuesto.setIdImpuesto(id);
                impuesto.setNombreImpuesto(nombre);
                impuesto.setValorImpuesto(valor);
                impuesto.setDescripcionImpuesto(descripcion);
                impuesto.setEstadoImpuesto(estado);

                impuestos.add(impuesto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return impuestos;
    }

    public Impuesto query(Impuesto impuesto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, impuesto.getIdImpuesto());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_id_impuesto");
                String nombre = rs.getString("nombre_impuesto");
                String valor = rs.getString("valor_impuesto");
                String descripcion = rs.getString("descripcion_impuesto");
                String estado = rs.getString("estado_impuesto");

                impuesto = new Impuesto();
                impuesto.setIdImpuesto(id);
                impuesto.setNombreImpuesto(nombre);
                impuesto.setValorImpuesto(valor);
                impuesto.setDescripcionImpuesto(descripcion);
                impuesto.setEstadoImpuesto(estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return impuesto;
    }

    public int delete(Impuesto impuesto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, impuesto.getIdImpuesto());
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
