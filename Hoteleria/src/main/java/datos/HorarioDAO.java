
package datos;

import dominio.Horario;
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
public class HorarioDAO {

    public static String codigoAuxiliar, nombreAuxiliar;
    private static final String SQL_INSERT = "insert into tbl_horario values(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_horario SET entrada_horario=?, salida_horario=?, descripcion_horario=?, estado_horario=? WHERE PK_id_horario=?";
    private static final String SQL_QUERY = "SELECT PK_id_horario, entrada_horario, salida_horario, descripcion_horario, estado_horario FROM tbl_horario WHERE PK_id_horario = ?";
    private static final String SQL_DELETE = "delete from tbl_horario where PK_id_horario = ?";

    public int insert(Horario horario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, horario.getIdHorario());
            stmt.setString(2, horario.getEntradaHorario());
            stmt.setString(3, horario.getSalidaHorario());
//            stmt.setString(4, horario.getHorasExtrasHorario());
            stmt.setString(4, horario.getDescripcionHorario());
            stmt.setString(5, horario.getEstadoHorario());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Horario horario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, horario.getEntradaHorario());
            stmt.setString(2, horario.getSalidaHorario());
//            stmt.setString(3, horario.getHorasExtrasHorario());
            stmt.setString(3, horario.getDescripcionHorario());
            stmt.setString(4, horario.getEstadoHorario());
            stmt.setString(5, horario.getIdHorario());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public List<Horario> select() {

        String SQL_SELECT = "SELECT * FROM tbl_horario WHERE PK_id_horario LIKE '%"+codigoAuxiliar+"%' OR entrada_horario LIKE '%"+nombreAuxiliar+"%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Horario horario = null;
        List<Horario> horarios = new ArrayList<Horario>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_id_horario");
                String entrada = rs.getString("entrada_horario");
                String salida = rs.getString("salida_horario");
                String descripcion = rs.getString("descripcion_horario");
                String estado = rs.getString("estado_horario");

                horario = new Horario();
                horario.setIdHorario(id);
                horario.setEntradaHorario(entrada);
                horario.setSalidaHorario(salida);
//                horario.setHorasExtrasHorario(horas);
                horario.setDescripcionHorario(descripcion);
                horario.setEstadoHorario(estado);

                horarios.add(horario);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return horarios;
    }

    public Horario query(Horario horario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, horario.getIdHorario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_id_horario");
                String entrada = rs.getString("entrada_horario");
                String salida = rs.getString("salida_horario");
                String descripcion = rs.getString("descripcion_horario");
                String estado = rs.getString("estado_horario");

                horario = new Horario();
                horario.setIdHorario(id);
                horario.setEntradaHorario(entrada);
                horario.setSalidaHorario(salida);
//                horario.setHorasExtrasHorario(horas);
                horario.setDescripcionHorario(descripcion);
                horario.setEstadoHorario(estado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return horario;
    }

    public int delete(Horario horario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, horario.getIdHorario());
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
