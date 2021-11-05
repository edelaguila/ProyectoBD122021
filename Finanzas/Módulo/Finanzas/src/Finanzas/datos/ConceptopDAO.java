/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas.datos;

import Finanzas.datos.Conexion;
import Finanzas.dominio.Conceptop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author OtakuGT
 */
public class ConceptopDAO extends Conexion{
    private static final String SQL_SELECT = "SELECT * FROM concepto_planilla";
    private static final String SQL_INSERT = "INSERT INTO concepto_planilla(id_conceptoPlanilla, nombre_concepto, tipo_concepto, clase_concepto, valor_concepto) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE concepto_planilla SET nombre_concepto=?, tipo_concepto=?, clase_concepto=?, valor_concepto=? WHERE PK_id_puesto=?";
    private static final String SQL_DELETE = "DELETE FROM concepto_planilla WHERE id_conceptoPlanilla=?";
    private static final String SQL_QUERY = "SELECT id_conceptoPlanilla, nombre_concepto, tipo_concepto, clase_concepto, valor_concepto FROM concepto_planilla WHERE id_conceptoPlanilla = ?";

    Conexion conectar = new Conexion();
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Conceptop conceptop = null;

    public List<Conceptop> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Conceptop conceptop = null;
        List<Conceptop> conceptos = new ArrayList<Conceptop>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("PK_id_conceptoPlanilla");
                String nombre = rs.getString("nombre_concepto");
                String tipo = rs.getString("tipo_concepto");
                String clase = rs.getString("clase_concepto");
                double valor = rs.getDouble("valor_concepto");

                conceptop = new Conceptop();
                conceptop.setId_conceptop(id);
                conceptop.setNombre_conceptop(nombre);
                conceptop.setTipo_conceptop(tipo);
                conceptop.setClase_conceptop(clase);
                conceptop.setValor_conceptop(valor);



                conceptos.add(conceptop);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return conceptos;
    }

    public Conceptop query(Conceptop conceptop) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, conceptop.getId_conceptop());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("PK_id_conceptoPlanilla");
                String nombre = rs.getString("nombre_concepto");
                String tipo = rs.getString("tipo_concepto");
                String clase = rs.getString("clase_concepto");
                double valor  = rs.getDouble("valor_concepto");

                conceptop = new Conceptop();
                conceptop.setId_conceptop(id);
                conceptop.setNombre_conceptop(nombre);
                conceptop.setTipo_conceptop(tipo);
                conceptop.setClase_conceptop(clase);
                conceptop.setValor_conceptop(valor);

                rows++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return conceptop;
    }
    

    public int delete(Conceptop conceptop) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, conceptop.getId_conceptop());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Conceptop conceptop) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, conceptop.getId_conceptop());
            stmt.setString(2, conceptop.getNombre_conceptop());
            stmt.setString(3, conceptop.getTipo_conceptop());
            stmt.setString(4, conceptop.getClase_conceptop());
            stmt.setDouble(5, conceptop.getValor_conceptop());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int insert(Conceptop conceptop) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, conceptop.getId_conceptop());
            stmt.setString(2, conceptop.getNombre_conceptop());
            stmt.setString(3, conceptop.getTipo_conceptop());
            stmt.setString(4, conceptop.getClase_conceptop());
            stmt.setDouble(5, conceptop.getValor_conceptop());
            stmt.executeUpdate();
        } catch (Exception ex) {
            System.err.println(ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return 1;
    }

}
