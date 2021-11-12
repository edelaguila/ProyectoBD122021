/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.vista;

import Comercial.datos.LineaDAO;
import Comercial.datos.LineaDAO;
import Comercial.dominio.Linea;
import Comercial.datos.MarcaDAO;
import Comercial.datos.MarcaDAO;
import Comercial.dominio.Marca;
import Comercial.datos.BodegaDAO;
import Comercial.datos.BodegaDAO;
import Comercial.datos.Conexion;
import Comercial.dominio.Bodega;
import Comercial.datos.UnidadDAO;
import Comercial.datos.UnidadDAO;
import Comercial.dominio.Unidad;
import Comercial.dominio.Producto;
import Comercial.datos.ProductoDAO;
import java.io.File;
import Comercial.datos.Conexion;
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
public class Mantenimiento_Producto extends javax.swing.JInternalFrame {

    /**
     * Creates new form Mantenimiento_Producto
     */
//    LineaDAO Producto = new LineaDAO();
//    Linea producto1 = new Linea();
//
//    MarcaDAO Product = new MarcaDAO();
//    Marca produc1 = new Marca();
//
//    BodegaDAO Produc = new BodegaDAO();
//    Bodega produ1 = new Bodega();
//
//    UnidadDAO Prod = new UnidadDAO();
//    Unidad prod1 = new Unidad();
//
//    public void llenadoDeCombos2() {
//
//        List<Linea> producto1 = Producto.select();
//        Cbx_linea.addItem("Seleccione:");
//        for (int i = 0; i < producto1.size(); i++) {
//            Cbx_linea.addItem(producto1.get(i).getNombre_Linea());
//            String valor = Cbx_linea.getSelectedItem().toString();
//        }
//    }
//
//    public void llenadoDeCombos3() {
//
//        List<Marca> produc1 = Product.select();
//        Cbx_marca.addItem("Seleccione:");
//        for (int i = 0; i < produc1.size(); i++) {
//            Cbx_marca.addItem(produc1.get(i).getNombre_Marca());
//            String valor = Cbx_marca.getSelectedItem().toString();
//        }
//    }
//
//    public void llenadoDeCombos4() {
//
//        List<Bodega> produ1 = Produc.select();
//        Cbx_bodega.addItem("Seleccione:");
//        for (int i = 0; i < produ1.size(); i++) {
//            Cbx_bodega.addItem(produ1.get(i).getNombreBodega());
//            String valor = Cbx_bodega.getSelectedItem().toString();
//        }
//    }
//
//    public void llenadoDeCombos5() {
//
//        List<Unidad> prod1 = Prod.select();
//        Cbx_unidad.addItem("Seleccione:");
//        for (int i = 0; i < prod1.size(); i++) {
//            Cbx_unidad.addItem(prod1.get(i).getNombre_unidad());
//            String valor = Cbx_unidad.getSelectedItem().toString();
//        }
//    }
    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID Producto");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Descripcion Producto");
        modelo.addColumn("Precio Producto");
        modelo.addColumn("Costo Producto");
        modelo.addColumn("Estatus Producto");
        modelo.addColumn("Producto Linea");
        modelo.addColumn("Producto Marca");
        modelo.addColumn("Producto Bodega");
        modelo.addColumn("Producto Unidad");
        ProductoDAO productoDAO = new ProductoDAO();

        List<Producto> producto = productoDAO.select();
        Tbl_tablaproducto.setModel(modelo);
        String[] dato = new String[10];
        for (int i = 0; i < producto.size(); i++) {
             dato[0] = Integer.toString(producto.get(i).getPKcodigoProducto());
            
            dato[1] = producto.get(i).getNombreProducto();
            dato[2] = producto.get(i).getDescripcionProducto();
            dato[3] = producto.get(i).getPrecioProducto();
            dato[4] = producto.get(i).getCostoProducto();
            dato[5] = producto.get(i).getEstatusProducto();
            dato[6] = producto.get(i).getLineaProducto();
            dato[7] = producto.get(i).getMarcaProducto();
            dato[8] = producto.get(i).getBodegaProducto();
            dato[9] = producto.get(i).getUnidadProducto();

            //System.out.println("vendedor:" + vendedores);
            modelo.addRow(dato);
        }
    }

    public void buscar() {
        Producto productoAConsultar = new Producto();
        ProductoDAO productoDAO = new ProductoDAO();
        productoAConsultar.setPKcodigoProducto(Integer.parseInt(Txt_id.getText()));
        
        productoAConsultar = productoDAO.query(productoAConsultar);
        Txt_nombreproducto.setText(String.valueOf(productoAConsultar.getNombreProducto()));
        Txt_descipcionproducto.setText(String.valueOf(productoAConsultar.getDescripcionProducto()));
        Txt_precioproducto.setText(String.valueOf(productoAConsultar.getPrecioProducto()));
        Txt_costoproducto.setText(String.valueOf(productoAConsultar.getCostoProducto()));
        Txt_estadoproducto.setText(String.valueOf(productoAConsultar.getEstatusProducto()));
        Txt_linea.setText(String.valueOf(productoAConsultar.getLineaProducto()));
        Txt_marca.setText(String.valueOf(productoAConsultar.getMarcaProducto()));
        Txt_bodega.setText(String.valueOf(productoAConsultar.getBodegaProducto()));
        Txt_unidad.setText(String.valueOf(productoAConsultar.getUnidadProducto()));

    }

    public void limpiar() {
        Txt_id.setText("");
        Txt_nombreproducto.setText("");
        Txt_descipcionproducto.setText("");
        Txt_precioproducto.setText("");
        Txt_costoproducto.setText("");
        Txt_estadoproducto.setText("");
        Txt_linea.setText("");
        Txt_marca.setText("");
        Txt_bodega.setText("");
        Txt_unidad.setText("");
    }

    public Mantenimiento_Producto() {
        initComponents();
        llenadoDeTablas();

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
        Txt_id = new javax.swing.JTextField();
        Txt_nombreproducto = new javax.swing.JTextField();
        Txt_descipcionproducto = new javax.swing.JTextField();
        Txt_precioproducto = new javax.swing.JTextField();
        Txt_costoproducto = new javax.swing.JTextField();
        Txt_estadoproducto = new javax.swing.JTextField();
        Btn_Guardar = new javax.swing.JButton();
        Btn_Modificar = new javax.swing.JButton();
        Btn_Eliminar = new javax.swing.JButton();
        Btn_Reporte = new javax.swing.JButton();
        Btn_Buscar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Txt_linea = new javax.swing.JTextField();
        Txt_marca = new javax.swing.JTextField();
        Txt_bodega = new javax.swing.JTextField();
        Txt_unidad = new javax.swing.JTextField();
        Btn_ayudalineap = new javax.swing.JButton();
        Btn_ayudamarcap = new javax.swing.JButton();
        Btn_ayudabodegap = new javax.swing.JButton();
        Btn_ayudaunidadp = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_tablaproducto = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        Btn_Ayuda = new javax.swing.JButton();

        setBackground(java.awt.Color.white);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Nombre Producto");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Descripcion Producto");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Precio Producto");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Costo Producto");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Estado Producto");

        Txt_id.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        Txt_nombreproducto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        Txt_descipcionproducto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        Txt_precioproducto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        Txt_costoproducto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        Txt_estadoproducto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        Btn_Guardar.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Btn_Guardar.setText("Guardar");
        Btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_GuardarActionPerformed(evt);
            }
        });

        Btn_Modificar.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Btn_Modificar.setText("Modificar");
        Btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ModificarActionPerformed(evt);
            }
        });

        Btn_Eliminar.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Btn_Eliminar.setText("Eliminar");
        Btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EliminarActionPerformed(evt);
            }
        });

        Btn_Reporte.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Btn_Reporte.setText("Reporte");
        Btn_Reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ReporteActionPerformed(evt);
            }
        });

        Btn_Buscar.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Btn_Buscar.setText("Buscar");
        Btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BuscarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Linea");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Marca");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Bodega");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Unidad");

        Txt_linea.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        Txt_marca.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        Txt_bodega.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        Txt_unidad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        Btn_ayudalineap.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Btn_ayudalineap.setText("?");
        Btn_ayudalineap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ayudalineapActionPerformed(evt);
            }
        });

        Btn_ayudamarcap.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Btn_ayudamarcap.setText("?");
        Btn_ayudamarcap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ayudamarcapActionPerformed(evt);
            }
        });

        Btn_ayudabodegap.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Btn_ayudabodegap.setText("?");
        Btn_ayudabodegap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ayudabodegapActionPerformed(evt);
            }
        });

        Btn_ayudaunidadp.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Btn_ayudaunidadp.setText("?");
        Btn_ayudaunidadp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ayudaunidadpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Txt_id)
                                    .addComponent(Txt_nombreproducto)
                                    .addComponent(Txt_descipcionproducto)
                                    .addComponent(Txt_precioproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Txt_costoproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(171, 171, 171)
                                        .addComponent(jLabel8))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(Btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Txt_linea)
                                    .addComponent(Txt_marca)
                                    .addComponent(Txt_bodega)
                                    .addComponent(Txt_unidad)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Txt_estadoproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(Btn_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Btn_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(Btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addComponent(Btn_Reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_ayudaunidadp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_ayudabodegap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_ayudamarcap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_ayudalineap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Txt_nombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(Txt_descipcionproducto))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(Txt_linea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Btn_ayudalineap))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Txt_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_ayudamarcap))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(Txt_bodega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_ayudabodegap))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(Txt_unidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_ayudaunidadp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Txt_precioproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Txt_costoproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Txt_estadoproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        Tbl_tablaproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Tbl_tablaproducto);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(222, 222, 222))
        );

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setText("Mantenimiento Producto");

        Btn_Ayuda.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Btn_Ayuda.setText("Ayuda");
        Btn_Ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AyudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(117, 117, 117)
                                .addComponent(Btn_Ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_GuardarActionPerformed
        // TODO add your handling code here:

        ProductoDAO productoDAO = new ProductoDAO();
        Producto productoAInsertar = new Producto();
        productoAInsertar.setPKcodigoProducto((int) Integer.parseInt(Txt_id.getText()));
       
        productoAInsertar.setNombreProducto(Txt_nombreproducto.getText());
        productoAInsertar.setDescripcionProducto(Txt_descipcionproducto.getText());
        productoAInsertar.setPrecioProducto(Txt_precioproducto.getText());
        productoAInsertar.setCostoProducto(Txt_costoproducto.getText());
        productoAInsertar.setEstatusProducto(Txt_estadoproducto.getText());
        productoAInsertar.setLineaProducto(Txt_linea.getText());
        productoAInsertar.setMarcaProducto(Txt_marca.getText());
        productoAInsertar.setBodegaProducto(Txt_bodega.getText());
        productoAInsertar.setUnidadProducto(Txt_unidad.getText());
        productoDAO.insert(productoAInsertar);
        JOptionPane.showMessageDialog(null, "Registro Exitoso.");
        llenadoDeTablas();

        limpiar();
        //        
//                Bitacora Insertar = new Bitacora();
//                Insertar.setId_Usuario(Login.usuarioComercial);
//                Insertar.setAccion("Insertar");
//        
//                Insertar.setCodigoAplicacion("3001");
//                Insertar.setModulo("3000");
//        
//                try {
//                        BitacoraDAO.insert(Insertar);
//                    } catch (UnknownHostException ex) {
//                        Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                
//                Registro_ventaDao  DAO = new Registro_ventaDao();
//        
//                Registro_venta Inserta = new Registro_venta();
//                Inserta.setUsuario(Login.usuarioComercial);
//                Inserta.setAccion("Insertar");
//        
//                Inserta.setTabla("3001");
//                Inserta.setTotal(Txt_total.getText());
    }//GEN-LAST:event_Btn_GuardarActionPerformed

    private void Btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ModificarActionPerformed
        // TODO add your handling code here:
        ProductoDAO productoDAO = new ProductoDAO();
        Producto productoAActualizar = new Producto();
        
        productoAActualizar.setPKcodigoProducto(Integer.parseInt(Txt_id.getText()));
        productoAActualizar.setNombreProducto(Txt_nombreproducto.getText());
        productoAActualizar.setDescripcionProducto(Txt_descipcionproducto.getText());
        productoAActualizar.setPrecioProducto(Txt_precioproducto.getText());
        productoAActualizar.setCostoProducto(Txt_costoproducto.getText());
        productoAActualizar.setEstatusProducto(Txt_estadoproducto.getText());
        productoAActualizar.setLineaProducto(Txt_linea.getText());
        productoAActualizar.setMarcaProducto(Txt_marca.getText());
        productoAActualizar.setBodegaProducto(Txt_bodega.getText());
        productoAActualizar.setUnidadProducto(Txt_unidad.getText());
        productoDAO.update(productoAActualizar);
        JOptionPane.showMessageDialog(null, "Modificación Exitosa.");
        llenadoDeTablas();
        limpiar();
        //        
//                Bitacora Insertar = new Bitacora();
//                Insertar.setId_Usuario(Login.usuarioComercial);
//                Insertar.setAccion("Insertar");
//        
//                Insertar.setCodigoAplicacion("3001");
//                Insertar.setModulo("3000");
//        
//                try {
//                        BitacoraDAO.insert(Insertar);
//                    } catch (UnknownHostException ex) {
//                        Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                
//                Registro_ventaDao  DAO = new Registro_ventaDao();
//        
//                Registro_venta Inserta = new Registro_venta();
//                Inserta.setUsuario(Login.usuarioComercial);
//                Inserta.setAccion("Insertar");
//        
//                Inserta.setTabla("3001");
//                Inserta.setTotal(Txt_total.getText());
    }//GEN-LAST:event_Btn_ModificarActionPerformed

    private void Btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EliminarActionPerformed
        // TODO add your handling code here:
        ProductoDAO productoDAO = new ProductoDAO();
        Producto productoAEliminar = new Producto();
        productoAEliminar.setPKcodigoProducto(Integer.parseInt(Txt_id.getText()));
        
        productoDAO.delete(productoAEliminar);
        JOptionPane.showMessageDialog(null, "Registro Eliminado.");

        llenadoDeTablas();
        limpiar();
        //        
//                Bitacora Insertar = new Bitacora();
//                Insertar.setId_Usuario(Login.usuarioComercial);
//                Insertar.setAccion("Insertar");
//        
//                Insertar.setCodigoAplicacion("3001");
//                Insertar.setModulo("3000");
//        
//                try {
//                        BitacoraDAO.insert(Insertar);
//                    } catch (UnknownHostException ex) {
//                        Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                
//                Registro_ventaDao  DAO = new Registro_ventaDao();
//        
//                Registro_venta Inserta = new Registro_venta();
//                Inserta.setUsuario(Login.usuarioComercial);
//                Inserta.setAccion("Insertar");
//        
//                Inserta.setTabla("3001");
//                Inserta.setTotal(Txt_total.getText());
    }//GEN-LAST:event_Btn_EliminarActionPerformed

    private void Btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BuscarActionPerformed
        // TODO add your handling code here:
        buscar();
    }//GEN-LAST:event_Btn_BuscarActionPerformed

    private void Btn_AyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AyudaActionPerformed
        // TODO add your handling code here:
        try {
            if ((new File("src\\main\\java\\Comercial\\reportes\\AyudaMantenimientProducto.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\Comercial\\reportes\\AyudaMantenimientProducto.chm");
                p.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //        
//                Bitacora Insertar = new Bitacora();
//                Insertar.setId_Usuario(Login.usuarioComercial);
//                Insertar.setAccion("Insertar");
//        
//                Insertar.setCodigoAplicacion("3001");
//                Insertar.setModulo("3000");
//        
//                try {
//                        BitacoraDAO.insert(Insertar);
//                    } catch (UnknownHostException ex) {
//                        Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                
//                Registro_ventaDao  DAO = new Registro_ventaDao();
//        
//                Registro_venta Inserta = new Registro_venta();
//                Inserta.setUsuario(Login.usuarioComercial);
//                Inserta.setAccion("Insertar");
//        
//                Inserta.setTabla("3001");
//                Inserta.setTotal(Txt_total.getText());
    }//GEN-LAST:event_Btn_AyudaActionPerformed
    private Connection connection = null;
    private void Btn_ReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ReporteActionPerformed
        // TODO add your handling code here:
        Map p = new HashMap();
        JasperReport report;
        JasperPrint print;
        try {
            connection = Conexion.getConnection();
            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                    + "/src/main/java/Comercial/reportes/producto.jrxml");
            print = JasperFillManager.fillReport(report, p, connection);
            JasperViewer view = new JasperViewer(print, false);
            view.setTitle("Reporte de Transporte");
            view.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //        
//                Bitacora Insertar = new Bitacora();
//                Insertar.setId_Usuario(Login.usuarioComercial);
//                Insertar.setAccion("Insertar");
//        
//                Insertar.setCodigoAplicacion("3001");
//                Insertar.setModulo("3000");
//        
//                try {
//                        BitacoraDAO.insert(Insertar);
//                    } catch (UnknownHostException ex) {
//                        Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                
//                Registro_ventaDao  DAO = new Registro_ventaDao();
//        
//                Registro_venta Inserta = new Registro_venta();
//                Inserta.setUsuario(Login.usuarioComercial);
//                Inserta.setAccion("Insertar");
//        
//                Inserta.setTabla("3001");
//                Inserta.setTotal(Txt_total.getText());
    }//GEN-LAST:event_Btn_ReporteActionPerformed

    private void Btn_ayudalineapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ayudalineapActionPerformed
        // TODO add your handling code here:
        try {
            if ((new File("src\\main\\java\\Comercial\\reportes\\AyudaLineaProducto.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\Comercial\\reportes\\AyudaLineaProducto.chm");
                p.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //        
//                Bitacora Insertar = new Bitacora();
//                Insertar.setId_Usuario(Login.usuarioComercial);
//                Insertar.setAccion("Insertar");
//        
//                Insertar.setCodigoAplicacion("3001");
//                Insertar.setModulo("3000");
//        
//                try {
//                        BitacoraDAO.insert(Insertar);
//                    } catch (UnknownHostException ex) {
//                        Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                
//                Registro_ventaDao  DAO = new Registro_ventaDao();
//        
//                Registro_venta Inserta = new Registro_venta();
//                Inserta.setUsuario(Login.usuarioComercial);
//                Inserta.setAccion("Insertar");
//        
//                Inserta.setTabla("3001");
//                Inserta.setTotal(Txt_total.getText());

    }//GEN-LAST:event_Btn_ayudalineapActionPerformed

    private void Btn_ayudamarcapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ayudamarcapActionPerformed
        // TODO add your handling code here:
        try {
            if ((new File("src\\main\\java\\Comercial\\reportes\\AyudaMarcaProducto.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\Comercial\\reportes\\AyudaMarcaProducto.chm");
                p.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_Btn_ayudamarcapActionPerformed

    private void Btn_ayudabodegapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ayudabodegapActionPerformed
        // TODO add your handling code here:
        try {
            if ((new File("src\\main\\java\\Comercial\\reportes\\AyudaBodegaProducto.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\Comercial\\reportes\\AyudaBodegaProducto.chm");
                p.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_Btn_ayudabodegapActionPerformed

    private void Btn_ayudaunidadpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ayudaunidadpActionPerformed
        // TODO add your handling code here:
        try {
            if ((new File("src\\main\\java\\Comercial\\reportes\\AyudaUnidadProducto.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\Comercial\\reportes\\AyudaUnidadProducto.chm");
                p.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }//GEN-LAST:event_Btn_ayudaunidadpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Ayuda;
    private javax.swing.JButton Btn_Buscar;
    private javax.swing.JButton Btn_Eliminar;
    private javax.swing.JButton Btn_Guardar;
    private javax.swing.JButton Btn_Modificar;
    private javax.swing.JButton Btn_Reporte;
    private javax.swing.JButton Btn_ayudabodegap;
    private javax.swing.JButton Btn_ayudalineap;
    private javax.swing.JButton Btn_ayudamarcap;
    private javax.swing.JButton Btn_ayudaunidadp;
    private javax.swing.JTable Tbl_tablaproducto;
    private javax.swing.JTextField Txt_bodega;
    private javax.swing.JTextField Txt_costoproducto;
    private javax.swing.JTextField Txt_descipcionproducto;
    private javax.swing.JTextField Txt_estadoproducto;
    private javax.swing.JTextField Txt_id;
    private javax.swing.JTextField Txt_linea;
    private javax.swing.JTextField Txt_marca;
    private javax.swing.JTextField Txt_nombreproducto;
    private javax.swing.JTextField Txt_precioproducto;
    private javax.swing.JTextField Txt_unidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
