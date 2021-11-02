/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.vista;

import Comercial.datos.BodegaDAO;
import Comercial.datos.Conexion;
import Comercial.datos.ExistenciaDAO;
import Comercial.datos.InventarioDAO;
import Comercial.datos.LineaDAO;
import Comercial.datos.MarcaDAO;
import Comercial.datos.ProductoDAO;
import Comercial.datos.UnidadDAO;
import Comercial.dominio.Bodega;
import Comercial.dominio.Existencia;
import Comercial.dominio.Inventario;
import Comercial.dominio.Linea;
import Comercial.dominio.Marca;
import Comercial.dominio.Producto;
import Comercial.dominio.Unidad;
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
public class Proceso_Inventario extends javax.swing.JInternalFrame {

    /**
     * Creates new form Proceso_Inventario
     */
    BodegaDAO Inventario = new BodegaDAO();
    Bodega inventario1 = new Bodega();

    ExistenciaDAO Invent = new ExistenciaDAO();
    Existencia invent1 = new Existencia();

    LineaDAO Inventario2 = new LineaDAO();
    Linea inventari2 = new Linea();

    MarcaDAO Inventario3 = new MarcaDAO();
    Marca inventari3 = new Marca();
    
    UnidadDAO Inventario4 = new UnidadDAO();
    Unidad inventari4 = new Unidad();
    
    ProductoDAO producto= new   ProductoDAO  ();
    Producto producto1 = new  Producto (); 

    public void llenadoDeCombos2() {

        List<Existencia> invent1 = Invent.select();
        Cbx_existencia.addItem("Seleccione:");
        for (int i = 0; i < invent1.size(); i++) {
            Cbx_existencia.addItem(invent1.get(i).getPk_codigo_existencia());
            String valor = Cbx_existencia.getSelectedItem().toString();
        }
    }

    public void llenadoDeCombos3() {

        List<Bodega> inventario1 = Inventario.select();
        Cbx_bodega.addItem("Seleccione:");
        for (int i = 0; i < inventario1.size(); i++) {
            Cbx_bodega.addItem(inventario1.get(i).getNombreBodega());
            String valor = Cbx_bodega.getSelectedItem().toString();
        }
    }

    public void llenadoDeCombos4() {

        List<Linea> inventari2 = Inventario2.select();
        Cbx_linea.addItem("Seleccione:");
        for (int i = 0; i < inventari2.size(); i++) {
            Cbx_linea.addItem(inventari2.get(i).getNombre_Linea());
            String valor = Cbx_linea.getSelectedItem().toString();
        }
    }

    public void llenadoDeCombos5() {

        List<Marca> inventari3 = Inventario3.select();
        Cbx_marca.addItem("Seleccione:");
        for (int i = 0; i < inventari3.size(); i++) {
            Cbx_marca.addItem(inventari3.get(i).getNombre_Marca());
            String valor = Cbx_marca.getSelectedItem().toString();
        }
    }
    
      public void llenadoDeCombos6() {

        List<Unidad> inventari4 = Inventario4.select();
        Cbx_unidad.addItem("Seleccione:");
        for (int i = 0; i < inventari4.size(); i++) {
            Cbx_unidad.addItem(inventari4.get(i).getMedida_acronimo());
            String valor = Cbx_unidad.getSelectedItem().toString();
        }    
    }
   
       public void llenadoDeCombos7() {

        List<Producto> producto1 =  producto.select();
        Cbx_producto.addItem("Seleccione:");
        for (int i = 0; i < producto1.size(); i++) {
            Cbx_producto.addItem(producto1.get(i).getNombreProducto());
             String valor =  Cbx_producto.getSelectedItem().toString();
        }    
    }
       
       public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Inventario");
        modelo.addColumn("Codigo Producto");
        modelo.addColumn("Codigo Bodega");
        modelo.addColumn("Codigo Existencia");
        modelo.addColumn("Codigo Linea");
        modelo.addColumn("Codigo Marca");
        modelo.addColumn("Codigo Unidad");
        modelo.addColumn("Estatus Inventario");
        InventarioDAO inventarioDAO = new InventarioDAO();

        List<Inventario> inventario = inventarioDAO.select();
        Tbl_inventario.setModel(modelo);
        String[] dato = new String[8];
        for (int i = 0; i < inventario.size(); i++) {
            dato[0] = inventario.get(i).getPK_codigo_inventario();
            dato[1] = inventario.get(i).getPK_codigo_producto();
            dato[2] = inventario.get(i).getPK_codigo_bodega();
            dato[3] = inventario.get(i).getPK_codigo_existencia();
            dato[4] = inventario.get(i).getPK_codigo_linea();
            dato[5] = inventario.get(i).getPK_codigo_marca();
            dato[6] = inventario.get(i).getPK_codigo_unidad();
            dato[7] = inventario.get(i).getEstatus_inventario();

            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
    }
       
        public void buscar() {
        Inventario inventarioAConsultar = new Inventario();
        InventarioDAO inventarioDAO = new InventarioDAO();
        inventarioAConsultar.setPK_codigo_inventario(Txt_id.getText());
        inventarioAConsultar = inventarioDAO.query(inventarioAConsultar);
       
        Txt_estatus.setText(String.valueOf(inventarioAConsultar.getEstatus_inventario()));
//        cbx_bodega.setSelectedItem(String.valueOf(0));
    }

    public void limpiar() {
        Txt_id.setText("");
      
        Txt_estatus.setText("");
//        cbx_bodega.setSelectedIndex(0);
    }

    
    public Proceso_Inventario() {
        initComponents();
        llenadoDeCombos2();
        llenadoDeCombos3();
        llenadoDeCombos4();
        llenadoDeCombos5();
        llenadoDeCombos6();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Cbx_existencia = new javax.swing.JComboBox<>();
        Cbx_bodega = new javax.swing.JComboBox<>();
        Cbx_producto = new javax.swing.JComboBox<>();
        Cbx_linea = new javax.swing.JComboBox<>();
        Cbx_marca = new javax.swing.JComboBox<>();
        Cbx_unidad = new javax.swing.JComboBox<>();
        Txt_id = new javax.swing.JTextField();
        Txt_estatus = new javax.swing.JTextField();
        Btn_Guardar = new javax.swing.JButton();
        Btn_Modificar = new javax.swing.JButton();
        Btn_Eliminar = new javax.swing.JButton();
        Btn_Buscar = new javax.swing.JButton();
        Btn_Reporte = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tbl_inventario = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        Btn_Ayuda = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inventario Detalle"));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Codigo Producto");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Codigo Bodega");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Codigo Existencia");

        jLabel5.setText("Codigo Linea");

        jLabel6.setText("Codigo Marca");

        jLabel7.setText("Codigo Unidad");

        jLabel10.setText("Estatus");

        Cbx_existencia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        Cbx_bodega.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Cbx_bodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cbx_bodegaActionPerformed(evt);
            }
        });

        Cbx_producto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        Cbx_linea.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        Cbx_marca.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        Cbx_unidad.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        Txt_id.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        Txt_estatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        Btn_Guardar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Btn_Guardar.setText("Guardar");
        Btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_GuardarActionPerformed(evt);
            }
        });

        Btn_Modificar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Btn_Modificar.setText("Modificar");
        Btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ModificarActionPerformed(evt);
            }
        });

        Btn_Eliminar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Btn_Eliminar.setText("Eliminar");
        Btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EliminarActionPerformed(evt);
            }
        });

        Btn_Buscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Btn_Buscar.setText("Buscar");

        Btn_Reporte.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Cbx_bodega, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Cbx_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Cbx_existencia, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Btn_Buscar)))
                                .addGap(64, 64, 64))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Btn_Guardar)
                                .addGap(21, 21, 21)
                                .addComponent(Btn_Modificar)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(Btn_Eliminar)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)))
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Cbx_marca, javax.swing.GroupLayout.Alignment.LEADING, 0, 139, Short.MAX_VALUE)
                        .addComponent(Txt_estatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Cbx_linea, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Cbx_unidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Btn_Reporte))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(Cbx_linea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_Buscar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Cbx_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(Cbx_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Cbx_bodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(Cbx_unidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(Txt_estatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbx_existencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Guardar)
                    .addComponent(Btn_Modificar)
                    .addComponent(Btn_Eliminar)
                    .addComponent(Btn_Reporte))
                .addGap(27, 27, 27))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle Inventario"));

        Tbl_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(Tbl_inventario);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("PROCESO INVENTARIO");

        Btn_Ayuda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Btn_Ayuda.setText("Ayuda");

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
            .addGroup(layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btn_Ayuda)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Btn_Ayuda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cbx_bodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cbx_bodegaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cbx_bodegaActionPerformed

    private void Btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_GuardarActionPerformed
        // TODO add your handling code here:
        String id = "0";
        Proceso_Inventario procesoinventDAO = new Proceso_Inventario();
        InventarioDAO inventarioDAO = new InventarioDAO();
        Inventario inventarioAInsertar = new Inventario();
        //String cbxbodega = cbx_bodega.getSelectedItem().toString();
        inventarioAInsertar.setPK_codigo_inventario(Txt_id.getText());
        inventarioAInsertar.setEstatus_inventario(Txt_estatus.getText());

        inventarioDAO.insert(inventarioAInsertar);
        llenadoDeTablas();
        limpiar();
    }//GEN-LAST:event_Btn_GuardarActionPerformed

    private void Btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ModificarActionPerformed
        // TODO add your handling code here:
        InventarioDAO inventarioDAO = new  InventarioDAO();
        Inventario inventarioAActualizar = new Inventario();
        inventarioAActualizar.setPK_codigo_inventario(Txt_id.getText());
        inventarioAActualizar.setEstatus_inventario(Txt_estatus.getText());
        inventarioDAO.update(inventarioAActualizar);
        JOptionPane.showMessageDialog(null, "Modificación Exitosa.");
        llenadoDeTablas();
        limpiar();
    }//GEN-LAST:event_Btn_ModificarActionPerformed

    private void Btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EliminarActionPerformed
        // TODO add your handling code here:
        InventarioDAO inventarioDAO = new InventarioDAO();
        Inventario inventarioAEliminar = new Inventario();
        inventarioAEliminar.setPK_codigo_inventario(Txt_id.getText());
        inventarioDAO.delete(inventarioAEliminar);
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
                                            + "/src/main/java/Comercial/reportes/inventario.jrxml");
                                print = JasperFillManager.fillReport(report, p, connection);
                                JasperViewer view = new JasperViewer(print, false);
                                view.setTitle("Reporte de Proceso Productos");
                                view.setVisible(true);
            
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
    }//GEN-LAST:event_Btn_ReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Ayuda;
    private javax.swing.JButton Btn_Buscar;
    private javax.swing.JButton Btn_Eliminar;
    private javax.swing.JButton Btn_Guardar;
    private javax.swing.JButton Btn_Modificar;
    private javax.swing.JButton Btn_Reporte;
    private javax.swing.JComboBox<String> Cbx_bodega;
    private javax.swing.JComboBox<String> Cbx_existencia;
    private javax.swing.JComboBox<String> Cbx_linea;
    private javax.swing.JComboBox<String> Cbx_marca;
    private javax.swing.JComboBox<String> Cbx_producto;
    private javax.swing.JComboBox<String> Cbx_unidad;
    private javax.swing.JTable Tbl_inventario;
    private javax.swing.JTextField Txt_estatus;
    private javax.swing.JTextField Txt_id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
