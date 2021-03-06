package seguridad.datos;

import java.sql.*;

public class Conexion {

    // Estas constantes deben cambiarse temporalmente para probarlo localmente

    private static final String JDBC_URL = "jdbc:mysql://10.0.0.9:3306/empresarial?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "procesoEmpresarial";
    private static final String JDBC_PASS = "Laboratorio2021";



    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
    
}
