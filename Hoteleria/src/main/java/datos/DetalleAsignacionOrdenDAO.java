package datos;

import dominio.DetalleOrdenRestaurante;
import dominio.ProcesosRepetidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import dominio.DetalleOrdenRestaurante;

/**
 *
 * @author JEFF
 */
public class DetalleAsignacionOrdenDAO {

    public static String codigoAuxiliar, nombreAuxiliar;
    public static String validacionOrden;
    ProcesosRepetidos llenar = new ProcesosRepetidos();

    private static final String SQL_INSERT = "insert into tbl_menu_orden_detalle values(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE tbl_menu_orden_detalle SET id_orden_encabezado=?, id_menu=?, cantidad_orden=?, estado_orden=? WHERE PK_id_orden_detalle=?";
    private static final String SQL_QUERY_ENCABEZADO = "select PK_id_orden_encabezado from tbl_menu_orden_encabezado";
    private static final String SQL_PK = "PK_id_orden_encabezado";

    public void llenarCbxGobernanta(JComboBox cbxModulo) {
        llenar.llenarCbx(SQL_QUERY_ENCABEZADO, SQL_PK, cbxModulo);
    }
    
    public int insert(DetalleOrdenRestaurante detalleOrdenRestaurante) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, "0");
            stmt.setString(2, detalleOrdenRestaurante.getIdEncabezado());
            stmt.setString(3, detalleOrdenRestaurante.getIdMenu());
            stmt.setString(4, detalleOrdenRestaurante.getCantidadOrden());
            stmt.setString(5, detalleOrdenRestaurante.getEstadoOrden());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public List<DetalleOrdenRestaurante> select() {

        String SQL_SELECT = "SELECT * FROM tbl_menu_orden_detalle WHERE PK_id_orden_detalle LIKE '%" + codigoAuxiliar + "%' OR id_orden_encabezado LIKE '%" + nombreAuxiliar + "%'";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DetalleOrdenRestaurante restaurante = null;
        List<DetalleOrdenRestaurante> restaurantes = new ArrayList<DetalleOrdenRestaurante>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("PK_id_orden_detalle");
                String encabezado = rs.getString("id_orden_encabezado");
                String menu = rs.getString("id_menu");
                String cantidad = rs.getString("cantidad_orden");
                String estado = rs.getString("estado_orden");

                restaurante = new DetalleOrdenRestaurante();
                restaurante.setIdDetalle(id);
                restaurante.setIdEncabezado(encabezado);
                restaurante.setIdMenu(menu);
                restaurante.setCantidadOrden(cantidad);
                restaurante.setEstadoOrden(estado);

                restaurantes.add(restaurante);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return restaurantes;
    }
}
