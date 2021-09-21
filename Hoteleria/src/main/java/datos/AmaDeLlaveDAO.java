package datos;

import dominio.AmaDeLlave;
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
public class AmaDeLlaveDAO {

    public static String codigoAuxiliar, nombreAuxiliar;
    private static final String SQL_INSERT = "insert into tbl_ama_de_llave values(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_ama_de_llave SET nombre_ama_de_llave=?, apellido_ama_de_llave=?, piso_ama_de_llave=?, horario_ama_de_llave=?, descripcion_ama_de_llave=?, estado_ama_de_llave=? WHERE PK_id_ama_de_llave=?";
    private static final String SQL_QUERY = "SELECT PK_id_ama_de_llave, nombre_ama_de_llave, apellido_ama_de_llave, piso_ama_de_llave, horario_ama_de_llave, descripcion_ama_de_llave, estado_ama_de_llave FROM tbl_ama_de_llave WHERE PK_id_ama_de_llave = ?";
    private static final String SQL_DELETE = "delete from tbl_ama_de_llave where PK_id_ama_de_llave = ?";

    public int insert(AmaDeLlave amaDeLlave) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, amaDeLlave.getIdAmaDeLlave());
            stmt.setString(2, amaDeLlave.getNombreAmaDeLlave());
            stmt.setString(3, amaDeLlave.getApellidoAmaDeLlave());
            stmt.setString(4, amaDeLlave.getPisoAmaDeLlave());
            stmt.setString(5, amaDeLlave.getHorarioAmaDeLlave());
            stmt.setString(6, amaDeLlave.getDescripcionAmaDeLlave());
            stmt.setString(7, amaDeLlave.getEstadoAmaDeLlave());

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

    public int update(AmaDeLlave amaDeLlave) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
//          System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, amaDeLlave.getNombreAmaDeLlave());
            stmt.setString(2, amaDeLlave.getApellidoAmaDeLlave());
            stmt.setString(3, amaDeLlave.getPisoAmaDeLlave());
            stmt.setString(4, amaDeLlave.getHorarioAmaDeLlave());
            stmt.setString(5, amaDeLlave.getDescripcionAmaDeLlave());
            stmt.setString(6, amaDeLlave.getEstadoAmaDeLlave());
            stmt.setString(7, amaDeLlave.getIdAmaDeLlave());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public List<AmaDeLlave> select() {

        String SQL_SELECT = "SELECT * FROM tbl_ama_de_llave WHERE PK_id_ama_de_llave LIKE '%" + codigoAuxiliar + "%' OR nombre_ama_de_llave LIKE '%" + nombreAuxiliar + "%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        AmaDeLlave amaDeLlave = null;
        List<AmaDeLlave> amaDeLlaves = new ArrayList<AmaDeLlave>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_id_ama_de_llave");
                String nombre = rs.getString("nombre_ama_de_llave");
                String apellido = rs.getString("apellido_ama_de_llave");
                String piso = rs.getString("piso_ama_de_llave");
                String horario = rs.getString("horario_ama_de_llave");
                String descripcion = rs.getString("descripcion_ama_de_llave");
                String estado = rs.getString("estado_ama_de_llave");

                amaDeLlave = new AmaDeLlave();
                amaDeLlave.setIdAmaDeLlave(id);
                amaDeLlave.setNombreAmaDeLlave(nombre);
                amaDeLlave.setApellidoAmaDeLlave(apellido);
                amaDeLlave.setPisoAmaDeLlave(piso);
                amaDeLlave.setHorarioAmaDeLlave(horario);
                amaDeLlave.setDescripcionAmaDeLlave(descripcion);
                amaDeLlave.setEstadoAmaDeLlave(estado);

                amaDeLlaves.add(amaDeLlave);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return amaDeLlaves;
    }

    public AmaDeLlave query(AmaDeLlave amaDeLlave) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, amaDeLlave.getIdAmaDeLlave());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_id_ama_de_llave");
                String nombre = rs.getString("nombre_ama_de_llave");
                String apellido = rs.getString("apellido_ama_de_llave");
                String piso = rs.getString("piso_ama_de_llave");
                String horario = rs.getString("horario_ama_de_llave");
                String descripcion = rs.getString("descripcion_ama_de_llave");
                String estado = rs.getString("estado_ama_de_llave");

                amaDeLlave = new AmaDeLlave();
                amaDeLlave.setIdAmaDeLlave(id);
                amaDeLlave.setNombreAmaDeLlave(nombre);
                amaDeLlave.setApellidoAmaDeLlave(apellido);
                amaDeLlave.setPisoAmaDeLlave(piso);
                amaDeLlave.setHorarioAmaDeLlave(horario);
                amaDeLlave.setDescripcionAmaDeLlave(descripcion);
                amaDeLlave.setEstadoAmaDeLlave(estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return amaDeLlave;
    }

    public int delete(AmaDeLlave amaDeLlave) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, amaDeLlave.getIdAmaDeLlave());
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
