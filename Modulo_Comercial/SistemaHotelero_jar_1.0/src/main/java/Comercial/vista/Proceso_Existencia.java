/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.vista;

import Comercial.datos.Conexion;
import Comercial.datos.ExistenciaDAO;
import Comercial.dominio.Existencia;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Diana
 */
public class Proceso_Existencia extends javax.swing.JInternalFrame {

    /**
     * Creates new form Proceso_Existencia
     */
       public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Existencia");
        modelo.addColumn("Producto");
        modelo.addColumn("Bodega");
        modelo.addColumn("Cantidad Existencia");
        modelo.addColumn("Fecha Entrada");
        modelo.addColumn("Fecha Salida");
        modelo.addColumn("Estatus Existencia");
        ExistenciaDAO existenciaDAO = new ExistenciaDAO();

        List<Existencia> existencia = existenciaDAO.select();
        Tbl_existencia.setModel(modelo);
        String[] dato = new String[7];
        for (int i = 0; i < existencia.size(); i++) {
            dato[0] = existencia.get(i).getPk_codigo_existencia();
            dato[1] = existencia.get(i).getPk_codigo_producto();
            dato[2] = existencia.get(i).getPk_codigo_bodega();
            dato[3] = existencia.get(i).getCantidad_existencia();
            dato[4] = existencia.get(i).getFecha_entrada_existencia();
            dato[5] = existencia.get(i).getFecha_salida_existencia();
            dato[6] = existencia.get(i).getEstatus_existencia();
            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
    }

    public void buscar() {
        Existencia existenciaAConsultar = new Existencia();
        ExistenciaDAO existenciaDAO = new ExistenciaDAO();
        existenciaAConsultar.setPk_codigo_existencia(Txt_id.getText());
        existenciaAConsultar = existenciaDAO.query(existenciaAConsultar);
        Tbx_producto.setText(existenciaAConsultar.getPk_codigo_producto());
        Tbx_bodega.setText(existenciaAConsultar.getPk_codigo_bodega());
        Txt_cantidad.setText(existenciaAConsultar.getCantidad_existencia());
        Txt_fechaentrada.setText(String.valueOf(existenciaAConsultar.getFecha_entrada_existencia()));
        Txt_fechasalida.setText(String.valueOf(existenciaAConsultar.getFecha_salida_existencia()));
        Txt_estatus.setText(String.valueOf(existenciaAConsultar.getEstatus_existencia()));
//        cbx_bodega.setSelectedItem(String.valueOf(0));
    }

    public void limpiar() {
        Txt_id.setText("");
        Tbx_producto.setText("");
        Tbx_bodega.setText("");
        Txt_cantidad.setText("");
        Txt_fechaentrada.setText("");
        Txt_fechasalida.setText("");
        Txt_estatus.setText("");

    }
    
    public Proceso_Existencia() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Txt_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Txt_cantidad = new javax.swing.JTextField();
        Txt_fechaentrada = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Txt_fechasalida = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Txt_estatus = new javax.swing.JTextField();
        Btn_guardar = new javax.swing.JButton();
        Btn_Modificar = new javax.swing.JButton();
        Btn_Buscar = new javax.swing.JButton();
        Btn_Eliminar = new javax.swing.JButton();
        Btn_Reporte = new javax.swing.JButton();
        Tbx_bodega = new javax.swing.JTextField();
        Tbx_producto = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_existencia = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jButton6.setText("Ayuda");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle Existencia"));

        jLabel1.setText("ID existencia");

        jLabel2.setText("Producto codigo");

        jLabel3.setText("Bodega Codigo");

        jLabel4.setText("Cantidad Existencia");

        jLabel5.setText("Fecha entrada");

        jLabel6.setText("Fecha Salida");

        jLabel7.setText("Estatus");

        Btn_guardar.setText("Guardar");
        Btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_guardarActionPerformed(evt);
            }
        });

        Btn_Modificar.setText("Modificar");
        Btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ModificarActionPerformed(evt);
            }
        });

        Btn_Buscar.setText("Buscar");
        Btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BuscarActionPerformed(evt);
            }
        });

        Btn_Eliminar.setText("Eliminar");
        Btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EliminarActionPerformed(evt);
            }
        });

        Btn_Reporte.setText("Reporte");
        Btn_Reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                    .addComponent(Txt_cantidad)
                                    .addComponent(Tbx_bodega)
                                    .addComponent(Tbx_producto)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Btn_guardar)
                                .addGap(9, 9, 9)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Btn_Modificar)
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_Eliminar)
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_Reporte)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Btn_Buscar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Txt_fechaentrada)
                    .addComponent(Txt_fechasalida)
                    .addComponent(Txt_estatus, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Buscar)
                    .addComponent(jLabel5)
                    .addComponent(Txt_fechaentrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(Txt_fechasalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tbx_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(Txt_estatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tbx_bodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_guardar)
                    .addComponent(Btn_Modificar)
                    .addComponent(Btn_Eliminar)
                    .addComponent(Btn_Reporte))
                .addGap(29, 29, 29))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Existencia Detalle"));

        Tbl_existencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tbl_existencia);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("PROCESO EXISTENCIA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(196, 196, 196)
                .addComponent(jButton6)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_guardarActionPerformed
        // TODO add your handling code here:
        String id = "0";
        Proceso_Existencia proexistenciaDAO = new Proceso_Existencia();
        ExistenciaDAO existenciaDAO = new ExistenciaDAO();
        Existencia existenciaAInsertar = new Existencia();
        //        String cbxproducto = Cbx_producto.getSelectedItem().toString();
        existenciaAInsertar.setPk_codigo_existencia(Txt_id.getText());
        existenciaAInsertar.setPk_codigo_producto(Tbx_producto.getText());
        existenciaAInsertar.setPk_codigo_bodega(Tbx_bodega.getText());
        existenciaAInsertar.setCantidad_existencia(Txt_cantidad.getText());
        existenciaAInsertar.setFecha_entrada_existencia(Txt_fechaentrada.getText());
        existenciaAInsertar.setFecha_salida_existencia(Txt_fechasalida.getText());
        existenciaAInsertar.setEstatus_existencia(Txt_estatus.getText());

        existenciaDAO.insert(existenciaAInsertar);
        llenadoDeTablas();
        limpiar();

    }//GEN-LAST:event_Btn_guardarActionPerformed

    private void Btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ModificarActionPerformed
        // TODO add your handling code here:
        ExistenciaDAO existenciaDAO = new ExistenciaDAO();
        Existencia existenciaAActualizar = new Existencia();
        existenciaAActualizar.setPk_codigo_existencia(Txt_id.getText());
        existenciaAActualizar.setPk_codigo_producto(Tbx_producto.getText());
        existenciaAActualizar.setPk_codigo_bodega(Tbx_bodega.getText());
        existenciaAActualizar.setCantidad_existencia(Txt_cantidad.getText());
        existenciaAActualizar.setFecha_entrada_existencia(Txt_fechaentrada.getText());
        existenciaAActualizar.setFecha_salida_existencia(Txt_fechasalida.getText());
        existenciaAActualizar.setEstatus_existencia(Txt_estatus.getText());
        existenciaDAO.update(existenciaAActualizar);
        JOptionPane.showMessageDialog(null, "Modificación Exitosa.");
        llenadoDeTablas();
        limpiar();
    }//GEN-LAST:event_Btn_ModificarActionPerformed

    private void Btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BuscarActionPerformed
        // TODO add your handling code here:
        buscar();
    }//GEN-LAST:event_Btn_BuscarActionPerformed

    private void Btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EliminarActionPerformed
        // TODO add your handling code here:
        ExistenciaDAO existenciaDAO = new ExistenciaDAO();
        Existencia existenciaAEliminar = new Existencia();
        existenciaAEliminar.setPk_codigo_existencia(Txt_id.getText());
        existenciaDAO.delete(existenciaAEliminar);
        JOptionPane.showMessageDialog(null, "Registro Eliminado.");

        llenadoDeTablas();
        limpiar();
    }//GEN-LAST:event_Btn_EliminarActionPerformed
    private Connection connection = null;
    private void Btn_ReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ReporteActionPerformed
        // TODO add your handling code here:
     Map p = new HashMap();
                JasperReport report;
                JasperPrint print;
                try {
                    connection = Conexion.getConnection();
                    report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                            + "/src/main/java/Comercial/reportes/existencia.jrxml");
                    print = JasperFillManager.fillReport(report, p, connection);
                    JasperViewer view = new JasperViewer(print, false);
                    view.setTitle("Reporte de Proceso Productos");
                    view.setVisible(true);
        
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }//GEN-LAST:event_Btn_ReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Buscar;
    private javax.swing.JButton Btn_Eliminar;
    private javax.swing.JButton Btn_Modificar;
    private javax.swing.JButton Btn_Reporte;
    private javax.swing.JButton Btn_guardar;
    private javax.swing.JTable Tbl_existencia;
    private javax.swing.JTextField Tbx_bodega;
    private javax.swing.JTextField Tbx_producto;
    private javax.swing.JTextField Txt_cantidad;
    private javax.swing.JTextField Txt_estatus;
    private javax.swing.JTextField Txt_fechaentrada;
    private javax.swing.JTextField Txt_fechasalida;
    private javax.swing.JTextField Txt_id;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
