/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import com.toedter.calendar.JDateChooser;
import datos.Conexion;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import seguridad.vista.Login_LD;

// @author Herbert Leonel Dominguez Chavez
public class ProcesosRepetidos {

    DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            if (column > 20) {
                return true;
            }
            return false;
        }
    };
    DefaultTableCellRenderer centro = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {

            if (row % 2 == 0) {
                setBackground(new Color(229, 229, 229));
                setForeground(Color.BLACK);
            } else {
                setBackground(Color.white);
                setForeground(Color.BLACK);
            }

            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    };
    int totalColumnas;

    public static boolean isNoneEmpty(JTextField... textFields) {
        for (JTextField textField : textFields) {
            if (textField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Existen campos vacios, revise e intente de nuevo");
                return false;
            }
        }
        return true;
    }

    public static boolean isSelected(JRadioButton... radioButtons) {
        int flat = 0;
        for (JRadioButton button : radioButtons) {
            if (button.isSelected()) {
                flat++;
            }
        }

        if (flat == 0) {
            JOptionPane.showMessageDialog(null, "Existen campos vacios, revise e intente de nuevo");
            return true;
        }
        return true;
    }

    public static boolean isNumeric(String... cadena) {
        try {
            for (String button : cadena) {
                Integer.parseInt(button);
            }
            return true;
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Existen campos que solo aceptan números, revise e intente de nuevo");
            return false;
        }
    }

    public static boolean ConfirmarEliminacion(String Accion, String Objeto, Component com) {
        int confirmar = JOptionPane.showConfirmDialog(com, "¿Desea " + Accion + " el " + Objeto + "?", "Alerta", JOptionPane.YES_NO_OPTION);
        if (confirmar == 0) {
            return true;
        }
        return false;
    }

    public static void AlertaMensaje(String Accion, String Objeto, String Estado) {
        JOptionPane.showMessageDialog(null, Objeto + " " + Accion + " " + Estado, "ALERTA", 1);
    }

    public void Limpiar(JTextField... textFields) {
        for (JTextField textField : textFields) {
            textField.setText("");
        }
    }

    public String getFecha() {
        Date fecha = new Date();
        String fecha_string = new SimpleDateFormat("dd-MM-yyyy").format(fecha);
        return fecha_string;
    }

    public void Cursor(Component... textFields) {
        Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        for (Component textField : textFields) {
            textField.setCursor(cursor);
        }
    }

    public static Boolean ValidarEmail(String email) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[_.])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void llenarColumnas(String datos[], int cantidad, JTable tabla) {
        totalColumnas = cantidad;
        for (int j = 0; j < cantidad; j++) {
            modelo.addColumn(datos[j]);
        }
        tabla.setModel(modelo);
    }

    public void llenarFilas(Object fila[], int tamaño[], JTable tabla) {
        for (int i = 0; i < totalColumnas; i++) {
            centro.setHorizontalAlignment(JLabel.CENTER);
            tabla.getColumnModel().getColumn(i).setCellRenderer(centro);
            tabla.getColumnModel().getColumn(i).setPreferredWidth(tamaño[i]);
        }
        modelo.addRow(fila);
        tabla.setModel(modelo);
    }

    public void imprimirAyuda(String nombreAyuda) {
        try {
            if ((new File("src\\main\\java\\ayudas\\" + nombreAyuda + "")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\ayudas\\" + nombreAyuda + "");
                p.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private Connection connection = null;

    public void imprimirReporte(String nombreReporte, String titulo) {
        Map p = new HashMap();
        JasperReport report;
        JasperPrint print;

        try {
            connection = Conexion.getConnection();
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/main/java/reportes/"+ nombreReporte);
            p.put("usuario", Login_LD.usuario);
            p.put("logo", new File("").getAbsolutePath() + "/src/main/java/reportes/hotel.png");
            print = JasperFillManager.fillReport(report, p, connection);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle(titulo);
            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static boolean isDateNoneEmpty(JDateChooser... date){
        for (JDateChooser fecha : date) {
            if (fecha==null) {
                JOptionPane.showMessageDialog(null, "Existen campos vacios, revise e intente de nuevo");
                return false;
            }
        }
        return true;
    }
    
    public void llenarCbx(String consulta, String mostrar, JComboBox cbxModulo) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(consulta);
            rs = stmt.executeQuery();
            cbxModulo.addItem("Seleccionar...");
            while (rs.next()) {
                cbxModulo.addItem(rs.getInt(mostrar));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }
    
    public static boolean cbxNoneSelected(JComboBox... jComboBoxes) {
        for (JComboBox jComboBox : jComboBoxes) {
            String cbx = jComboBox.getSelectedItem().toString();
            if (cbx.equals("Seleccionar...")) {
                JOptionPane.showMessageDialog(null, "Existen campos vacios, revise e intente de nuevo");
                return false;
            }
        }
        return true;
    }

}
