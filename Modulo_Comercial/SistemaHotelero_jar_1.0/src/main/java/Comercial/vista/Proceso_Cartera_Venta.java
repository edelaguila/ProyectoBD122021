package Comercial.vista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import Comercial.datos.Cartera_venta_Dao;
import Comercial.datos.ClienteDao;
import Comercial.datos.CobradorDao;
import Comercial.datos.VendedorDao;
import Comercial.dominio.Cartera_Venta;
import Comercial.dominio.Cliente;
import Comercial.dominio.Cobrador;
import Comercial.dominio.Vendedor;


import java.io.File;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import seguridad.datos.BitacoraDao;
import seguridad.dominio.Bitacora;
import seguridad.vista.Aplicacion_Perfil;
import seguridad.vista.GenerarPermisos;
import seguridad.vista.Login;
import seguridad.vista.MDI_Components;

/**
 *
 * @author PERSONAL
 */
public class Proceso_Cartera_Venta extends javax.swing.JInternalFrame {
ClienteDao Cliente= new   ClienteDao  ();
  Cliente Buscar = new  Cliente ();
  VendedorDao Vendedor = new   VendedorDao  ();
  Vendedor Buscar1 = new  Vendedor ();
  CobradorDao Cobrador = new  CobradorDao  ();
  Cobrador Buscar2 = new  Cobrador ();
    int codigoAplicacion = 3001;

//    void habilitarAcciones() {
//
//        int codigoAplicacion = 3001;
//        var usuario = Login.usuarioComercial;
//
//        btnAgregar.setEnabled(false);
//        btnModificar.setEnabled(false);
//        btnEliminar.setEnabled(false);
//        btnBuscar.setEnabled(false);
//
//        GenerarPermisos permisos = new GenerarPermisos();
//
//        String[] permisosApp = new String[4];
//
//        for (int i = 0; i < 4; i++) {
//            permisosApp[i] = permisos.getAccionesAplicacion(codigoAplicacion, usuario)[i];
//        }
//
//        if (permisosApp[0].equals("1")) {
//            btnAgregar.setEnabled(true);
//        }
//        if (permisosApp[1].equals("1")) {
//            btnBuscar.setEnabled(true);
//        }
//        if (permisosApp[2].equals("1")) {
//            btnModificar.setEnabled(true);
//        }
//        if (permisosApp[3].equals("1")) {
//            btnEliminar.setEnabled(true);
//        }
//    }

    public void llenadoDeCombos() {
        
        List<Cliente> Buscar =  Cliente.select();
        cbox_cliente.addItem("Seleccione un cliente");
        for (int i = 0; i < Buscar.size(); i++) {
            cbox_cliente.addItem(Buscar.get(i).getCodigo_Cliente());
             String valor =  cbox_cliente.getSelectedItem().toString();
   

    }}
public void llenadoDeCombos1() {
        
        List<Vendedor> Buscar1 =  Vendedor.select();
        cbox_vendedor.addItem("Seleccione un vendedor");
        for (int i = 0; i < Buscar1.size(); i++) {
            cbox_vendedor.addItem(Buscar1.get(i).getCodigo_Vendedor());
             String valor =  cbox_vendedor.getSelectedItem().toString();
   

    }}
public void llenadoDeCombos2() {
        
        List<Cobrador> Buscar2 =  Cobrador.select();
        cbox_cobrador.addItem("Seleccione un cobrador");
        for (int i = 0; i < Buscar2.size(); i++) {
            cbox_cobrador.addItem(Buscar2.get(i).getCodigo_Cobrador());
             String valor =  cbox_cobrador.getSelectedItem().toString();
   

    }}
  
    public void llenadoDeTablas() {
        /**
         *
         * creaccion de la tabla de de titulos
         */
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Numero");
        modelo.addColumn("Codigp Cliente");
        modelo.addColumn("Nombre Cliente");
        modelo.addColumn("Codigo Cliente");

        modelo.addColumn("Codigo cobrador");
        modelo.addColumn("Nombre Cobrador");
           modelo.addColumn("Codigo vendedor");
              modelo.addColumn("Nombre vendedor");


        modelo.addColumn("Estatus Cartera");
      

         Cartera_venta_Dao ventasDAO = new  Cartera_venta_Dao();

        List<Cartera_Venta> ventas = ventasDAO.select();
        JtProductos1.setModel(modelo);
        String[] dato = new String[7];
        for (int i = 0; i < ventas.size(); i++) {
            dato[0] = (ventas.get(i).getNo_serie());
            dato[1] = ventas.get(i).getCodigo_cliente();
             dato[2] = ventas.get(i).getNombre_cliente();
             dato[3] = (ventas.get(i).getCodigo_cobrador());
            dato[4] = ventas.get(i).getNombre_cobrador();
            dato[5] = ventas.get(i).getCodigo_vendedor();
              dato[6] = ventas.get(i).getNombre_vendedor();
             

            System.out.println("vendedor:" + ventas);
            modelo.addRow(dato);
        }
    }

    public void buscarVendedor() {

         Cartera_venta_Dao Clientes = new  Cartera_venta_Dao();

        Cartera_Venta Buscar = new Cartera_Venta() ;
        Buscar.setNo_serie(Txt_numero.getText());
        Buscar = Clientes.query(Buscar);
        Txt_nombre.setText(Buscar.getNombre_cliente());
         Txt_cobrador.setText(Buscar.getNombre_cobrador());
        Txt_estatus.setText(Buscar.getEstatus_cartera());
          Txt_vendedor.setText(Buscar.getNombre_vendedor());
            cobrador.setText(Buscar.getCodigo_cobrador());
              vendedor.setText(Buscar.getCodigo_vendedor());
        cliente1.setText(Buscar.getCodigo_cliente());
   

    }

    public void limpiar() {
//        Txt_codigo.setText("");
//        Txt_nombre.setText("");
//        Txt_nit.setText("");
//        Txt_estatus.setText("");
//        Txt_telefono.setText("");
//        Txt_direccion.setText("");
//        Txt_vendedor.setText("");
//        Txt_cuenta.setText("");
//        Txt_cobrador.setText("");
        
    
    }

    /**
     * Creates new form Mantenimiento_Cliente
     */
    public Proceso_Cartera_Venta() {
        int codigoAplicacion = 3001;
        initComponents();
//        habilitarAcciones();
        llenadoDeTablas();
         llenadoDeCombos1();
     llenadoDeCombos2();
     llenadoDeCombos();
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        Btn_Modificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Btn_Eliminar = new javax.swing.JButton();
        Btn_Agregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtProductos1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        Btn_reporte = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cliente = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Txt_nombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Txt_estatus = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Txt_vendedor = new javax.swing.JTextField();
        Txt_cobrador = new javax.swing.JTextField();
        cbox_vendedor = new javax.swing.JComboBox<>();
        cbox_cliente = new javax.swing.JComboBox<>();
        cbox_cobrador = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cobrador = new javax.swing.JLabel();
        vendedor = new javax.swing.JLabel();
        cliente1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        Btn_Buscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Txt_numero = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimieto Cliente\n");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_Modificar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Btn_Modificar.setText("Modificar");
        Btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ModificarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 100, 40));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Cartera Venta");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        Btn_Eliminar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Btn_Eliminar.setText("Eliminar");
        Btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EliminarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 110, 40));

        Btn_Agregar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Btn_Agregar.setText("Guardar");
        Btn_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AgregarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 100, 40));

        JtProductos1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        JtProductos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(JtProductos1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 620, 138));

        jButton1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton1.setText("Ayuda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 110, 40));

        Btn_reporte.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Btn_reporte.setText("Reporte");
        Btn_reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_reporteActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 100, 40));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 167, -1, -1));

        cliente.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        cliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Cliente Nombre");
        cliente.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Estatus cartera");
        cliente.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, -1, 10));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Codigo Cliente");
        cliente.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));
        cliente.add(Txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 180, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Cobrador Nombre ");
        cliente.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, 10));

        Txt_estatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_estatusActionPerformed(evt);
            }
        });
        cliente.add(Txt_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 180, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Codigo vencedor");
        cliente.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Vendedor Nombre");
        cliente.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, 10));
        cliente.add(Txt_vendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 180, -1));

        Txt_cobrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_cobradorActionPerformed(evt);
            }
        });
        cliente.add(Txt_cobrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 180, -1));

        cliente.add(cbox_vendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 110, 20));

        cliente.add(cbox_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 110, 20));

        cliente.add(cbox_cobrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 110, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Codigo Cobrador");
        cliente.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));
        cliente.add(cobrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 50, 20));
        cliente.add(vendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 50, 20));
        cliente.add(cliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 50, 20));

        jToggleButton1.setText("Consultar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        cliente.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 163, 90, 40));

        getContentPane().add(cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 690, 220));

        Btn_Buscar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Btn_Buscar.setText("Buscar");
        Btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BuscarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 43, 90, 30));

        jLabel4.setText("Numero de correlativo");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));
        getContentPane().add(Txt_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 100, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ModificarActionPerformed
 Cartera_venta_Dao DAO = new  Cartera_venta_Dao();

        Cartera_Venta AInsertar = new Cartera_Venta();
        AInsertar.setNo_serie(Txt_numero.getText());
        AInsertar.setCodigo_cliente(cliente1.getText());
       
        AInsertar.setCodigo_cobrador(cobrador.getText());
       AInsertar.setCodigo_vendedor(vendedor.getText());
        AInsertar.setNombre_cliente(Txt_nombre.getText());
         AInsertar.setNombre_vendedor(Txt_vendedor.getText());
           AInsertar.setNombre_cobrador(Txt_cobrador.getText());
            AInsertar.setEstatus_cartera(Txt_estatus.getText());
        DAO.update(AInsertar);

        llenadoDeTablas();
        



        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_ModificarActionPerformed

    private void Btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EliminarActionPerformed
//
        
    Cartera_venta_Dao DAO = new  Cartera_venta_Dao();

        Cartera_Venta AInsertar = new Cartera_Venta();
        AInsertar.setNo_serie(Txt_numero.getText());
        AInsertar.setCodigo_cliente(cliente1.getText());
       
        AInsertar.setCodigo_cobrador(cobrador.getText());
       AInsertar.setCodigo_vendedor(vendedor.getText());
        AInsertar.setNombre_cliente(Txt_nombre.getText());
         AInsertar.setNombre_vendedor(Txt_vendedor.getText());
           AInsertar.setNombre_cobrador(Txt_cobrador.getText());
            AInsertar.setEstatus_cartera(Txt_estatus.getText());
        DAO.delete(AInsertar);

        llenadoDeTablas();
        
        llenadoDeTablas();
        limpiar();
       
        BitacoraDao BitacoraDAO = new BitacoraDao();

        Bitacora Insertar = new Bitacora();

        Insertar.setAccion("Eliminar");
        GenerarPermisos permisos = new GenerarPermisos();
        MDI_Components mdi_Components = new MDI_Components();
        Insertar.setCodigoAplicacion("3001");
        Insertar.setModulo("3000");
        Insertar.setId_Usuario(Login.usuarioComercial);
        try {
            BitacoraDAO.insert(Insertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_EliminarActionPerformed

    private void Btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BuscarActionPerformed
        buscarVendedor() ;
        BitacoraDao BitacoraDAO = new BitacoraDao();

        Bitacora Insertar = new Bitacora();

        Insertar.setAccion("Buscar");
        GenerarPermisos permisos = new GenerarPermisos();
        MDI_Components mdi_Components = new MDI_Components();
        Insertar.setCodigoAplicacion("3001");
        Insertar.setModulo("3000");
        Insertar.setId_Usuario(Login.usuarioComercial);
        try {
            BitacoraDAO.insert(Insertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }
  
//        buscarVendedor();
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_BuscarActionPerformed

    private void Btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AgregarActionPerformed

////        GenerarPermisos permisos = new GenerarPermisos();
////        MDI_Components mdi_Components = new MDI_Components();
////
////        String id = "0";
         Cartera_venta_Dao DAO = new  Cartera_venta_Dao();

        Cartera_Venta AInsertar = new Cartera_Venta();
        AInsertar.setNo_serie(Txt_numero.getText());
        AInsertar.setCodigo_cliente(cliente1.getText());
       
        AInsertar.setCodigo_cobrador(cobrador.getText());
       AInsertar.setCodigo_vendedor(vendedor.getText());
        AInsertar.setNombre_cliente(Txt_nombre.getText());
         AInsertar.setNombre_vendedor(Txt_vendedor.getText());
           AInsertar.setNombre_cobrador(Txt_cobrador.getText());
            AInsertar.setEstatus_cartera(Txt_estatus.getText());
        DAO.insert(AInsertar);

        llenadoDeTablas();
        
        limpiar();
        BitacoraDao BitacoraDAO = new BitacoraDao();

        Bitacora Insertar = new Bitacora();
        Insertar.setId_Usuario(Login.usuarioComercial);
        Insertar.setAccion("Insertar");

        Insertar.setCodigoAplicacion("3001");
        Insertar.setModulo("3000");

        try {
            BitacoraDAO.insert(Insertar);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_AgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if ((new File("src\\main\\java\\Comercial\\reportes\\cartera.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\Comercial\\reportes\\cartera.chm");
                p.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Txt_estatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_estatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_estatusActionPerformed
private Connection connection = null;
    private void Btn_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_reporteActionPerformed
//  Map p = new HashMap();
//        JasperReport report;
//        JasperPrint print;
//
//        try {
//            connection = Conexion.getConnection();
//            report = JasperCompileManager.compileReport(new File("").getAbsolutePath()
//                    + "/src/main/java/Comercial/reportes/MantenimientoCliente.jrxml");
//            print = JasperFillManager.fillReport(report, p, connection);
//            JasperViewer view = new JasperViewer(print, false);
//            view.setTitle("cliente ");
//            view.setVisible(true);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        

        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_reporteActionPerformed

    private void Txt_cobradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_cobradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_cobradorActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
 String valor =  cbox_cliente.getSelectedItem().toString();
      String valor2 =  cbox_vendedor.getSelectedItem().toString();
        String valor3 =  cbox_cobrador.getSelectedItem().toString();
        Buscar.setCodigo_Cliente(valor);
        Buscar1.setCodigo_Vendedor(valor2);
         Buscar2.setCodigo_Cobrador(valor3);
       Buscar =   Cliente.query( Buscar);
       Buscar1 =   Vendedor.query( Buscar1);
        Buscar2 =   Cobrador.query( Buscar2);
       
           
              Txt_nombre.setText(  Buscar.getNombre_Cliente());
               cliente1.setText(  Buscar.getCodigo_Cliente());
              vendedor.setText(  Buscar1.getCodigo_Vendedor());
            cobrador.setText(  Buscar2.getCodigo_Cobrador());
                Txt_vendedor.setText(  Buscar1.getNombre_Vendedor());
                 Txt_cobrador.setText(  Buscar2.getNombre_Cobrador());  
// TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Agregar;
    private javax.swing.JButton Btn_Buscar;
    private javax.swing.JButton Btn_Eliminar;
    private javax.swing.JButton Btn_Modificar;
    private javax.swing.JButton Btn_reporte;
    private javax.swing.JTable JtProductos1;
    private javax.swing.JTextField Txt_cobrador;
    private javax.swing.JTextField Txt_estatus;
    private javax.swing.JTextField Txt_nombre;
    private javax.swing.JTextField Txt_numero;
    private javax.swing.JTextField Txt_vendedor;
    private javax.swing.JComboBox<String> cbox_cliente;
    private javax.swing.JComboBox<String> cbox_cobrador;
    private javax.swing.JComboBox<String> cbox_vendedor;
    private javax.swing.JPanel cliente;
    private javax.swing.JLabel cliente1;
    private javax.swing.JLabel cobrador;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel vendedor;
    // End of variables declaration//GEN-END:variables
}
