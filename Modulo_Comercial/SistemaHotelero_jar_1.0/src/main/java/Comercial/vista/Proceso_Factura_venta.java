/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.vista;

import Comercial.datos.ClienteDao;
import Comercial.datos.CobradorDao;
import Comercial.datos.Cuenta_ContableDao;
import Comercial.datos.Factura_VentaDao;
import Comercial.datos.Factura_VentaDao1;
import Comercial.datos.JoinDao;
import Comercial.datos.Registro_ventaDao;
import Comercial.datos.VendedorDao;
import Comercial.dominio.Cliente;
import Comercial.dominio.Cobrador;
import Comercial.dominio.Cuenta_Contable;
import Comercial.dominio.Factura_Venta;
import Comercial.dominio.Join_venta;
import Comercial.dominio.Registro_venta;
import Comercial.dominio.Vendedor;
import java.io.File;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import seguridad.datos.BitacoraDao;
import seguridad.dominio.Bitacora;
import seguridad.vista.Aplicacion_Perfil;
import seguridad.vista.Login;

/**
 *
 * @author PERSONAL
 */
public class Proceso_Factura_venta extends javax.swing.JInternalFrame {
ClienteDao Cliente= new   ClienteDao  ();
  Cliente Buscar = new  Cliente ();
  VendedorDao vendedor= new   VendedorDao  ();
  Vendedor Buscar1 = new  Vendedor ();
  CobradorDao cobrador= new  CobradorDao  ();
  Cobrador Buscar2 = new  Cobrador ();
  Factura_VentaDao Buscar3  = new Factura_VentaDao();  
  Factura_VentaDao1 Buscar4  = new Factura_VentaDao1();  
  Factura_Venta venta  = new Factura_Venta();
 Factura_Venta venta1  = new Factura_Venta(); 
   public void limpiar() {
        Txt_reservacion.setText("");
        txt_estatus.setText("");
        Txt_total.setText("");
        txt_encabezado.setText("");
        Txt_fecha.setText("");
        Txt_numero.setText("");
        Txt_cliente.setText("");
        Txt_vendedor.setText("");
        Txt_cobrador.setText("");
        Txt_fecha1.setText("");
        Txt_servicio.setText("");
        Txt_cantidad.setText("");
        Txt_precio.setText("");
        Txt_impuesto.setText("");
    }   
  /**
     * Creates new form Proceso_Factura_venta
     */
       
public void llenadoDeCombos() {
        
        List<Cliente> Buscar =  Cliente.select();
        cbox_cliente.addItem("Seleccione un cliente");
        for (int i = 0; i < Buscar.size(); i++) {
            cbox_cliente.addItem(Buscar.get(i).getCodigo_Cliente());
             String valor =  cbox_cliente.getSelectedItem().toString();
   

    }}
public void llenadoDeCombos1() {
        
        List<Vendedor> Buscar1 =  vendedor.select();
        cbox_vendedor.addItem("Seleccione un vendedor");
        for (int i = 0; i < Buscar1.size(); i++) {
            cbox_vendedor.addItem(Buscar1.get(i).getCodigo_Vendedor());
             String valor =  cbox_vendedor.getSelectedItem().toString();
   

    }}
public void llenadoDeCombos2() {
        
        List<Cobrador> Buscar2 =  cobrador.select();
        cbox_cobrador.addItem("Seleccione un cobrador");
        for (int i = 0; i < Buscar2.size(); i++) {
            cbox_cobrador.addItem(Buscar2.get(i).getCodigo_Cobrador());
             String valor =  cbox_cobrador.getSelectedItem().toString();
   

    }}
  
public void llenadoDeDatos1() {
  Factura_VentaDao Factura_VentaDao  = new Factura_VentaDao();
 Factura_VentaDao1 Factura_VentaDao1  = new Factura_VentaDao1();
        Factura_Venta AInser = new Factura_Venta();
      
        AInser.setCodigo_factura_encabezado(txt_encabezado.getText());
       
        AInser.setFecha_emision(Txt_fecha.getText());
        AInser.setNo_serie(Txt_numero.getText());
       
        AInser.setCodigo_cliente(Txt_cliente.getText());
        AInser.setCodigo_vendedor(Txt_vendedor.getText());
        AInser.setCodigo_cobrador(Txt_cobrador.getText());
        AInser.setSubtotal_encabezado(Txt_total.getText());
        AInser.setFecha_vencimiento(Txt_fecha1.getText());
        AInser.setEstatus_factura(txt_estatus.getText());
         AInser.setReservacion(Txt_reservacion.getText());
 AInser.setServicio(Txt_servicio.getText());

        AInser.setImpuesto_iva_encabezado(Txt_impuesto.getText());
        Factura_VentaDao.delete(AInser);
            
   

}      

public void llenadoDeDatos2() {

 Factura_VentaDao1 Factura_VentaDao1  = new Factura_VentaDao1();
       
        Factura_Venta AInser1 = new Factura_Venta();
        AInser1.setCodigo_factura_encabezado(txt_encabezado.getText());
      
       
        AInser1.setPrecio_servicio(Txt_precio.getText());

        AInser1.setCantidad_servicio(Txt_cantidad.getText());
       
        Factura_VentaDao1.delete(AInser1);
            
   

}    






public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
     
   modelo.addColumn("No serie");
        modelo.addColumn("Reservacion");
        modelo.addColumn("Codigo encabezado");
        modelo.addColumn("Cliente");
        modelo.addColumn("Vendedor");
        modelo.addColumn("Cobrador");
           modelo.addColumn("Fecha");
              modelo.addColumn("Fecha");
modelo.addColumn("Servicio");
        modelo.addColumn("Impuesto");
        modelo.addColumn("Total");
        modelo.addColumn("Estatus");

    
      
        Factura_VentaDao  ventasDAO = new Factura_VentaDao ();

        List<Factura_Venta> ventas = ventasDAO.select();
//        List<Factura_Venta > ventas1 = ventasDAO1.select1();
        Jtfactura.setModel(modelo);
        String[] dato = new String[12];
        for (int i = 0; i < ventas.size(); i++) {
             dato[0] = (ventas.get(i).getNo_serie());
             dato[1] = ventas.get(i).getReservacion();
             dato[2] = ventas.get(i).getCodigo_factura_encabezado();
             dato[3] = ventas.get(i).getCodigo_cliente();
             dato[4] = (ventas.get(i).getCodigo_cobrador());
             dato[5] = (ventas.get(i).getCodigo_vendedor());
             dato[6] = ventas.get(i).getFecha_emision();
             dato[7] = ventas.get(i).getFecha_vencimiento();
             dato[8] = (ventas.get(i).getServicio());  
             dato[9] = (ventas.get(i).getImpuesto_iva_encabezado());
            dato[10] = ventas.get(i).getSubtotal_encabezado();
             dato[11] = ventas.get(i).getEstatus_factura();
//             dato[12] = ventas1.get(i).getCantidad_servicio();
//              dato[13] = ventas1.get(i).getPrecio_servicio();
            System.out.println("vendedor:" + ventas);
            modelo.addRow(dato);
        }
    }        

public void llenadoDeTabla2() {
        DefaultTableModel modelo = new DefaultTableModel();
     
   modelo.addColumn("Reservacion");
        modelo.addColumn("Fecha");
        modelo.addColumn("Servicio");
        modelo.addColumn("Precio");
        modelo.addColumn("Menu");
        modelo.addColumn("Orden");
           modelo.addColumn("Fecha");
              modelo.addColumn("Orden");
modelo.addColumn("Tarifa");
        modelo.addColumn("nombre");
        

    
      
        JoinDao  ventasDAO = new JoinDao ();

        List<Join_venta> ventas = ventasDAO.select();
//        List<Factura_Venta > ventas1 = ventasDAO1.select1();
        join.setModel(modelo);
        String[] dato = new String[10];
        for (int i = 0; i < ventas.size(); i++) {
             dato[0] = (ventas.get(i).getReservacion());
             dato[1] = ventas.get(i).getReservacion_fecha();
             dato[2] = ventas.get(i).getServicio();
             dato[3] = ventas.get(i).getPrecio_servicio();
             dato[4] = (ventas.get(i).getMenu());
             dato[5] = ventas.get(i).getOrden();
             dato[6] = ventas.get(i).getFecha_orden();
             dato[7] = ventas.get(i).getOrden();
             dato[8] = ventas.get(i).getTariafa();  
             dato[9] = ventas.get(i).getNombre();
           
//             dato[12] = ventas1.get(i).getCantidad_servicio();
//              dato[13] = ventas1.get(i).getPrecio_servicio();
            System.out.println("vendedor:" + ventas);
            modelo.addRow(dato);
        }
    }      


public void buscarVendedor1() {
     
   venta.setNo_serie(Txt_numero.getText());
    venta1.setNo_serie1(Txt_numero.getText());
venta=Buscar3.query(venta);

venta1=Buscar4.query1(venta1);
txt_encabezado.setText(venta.getCodigo_factura_encabezado());
txt_encabezado.setText(venta1.getCodigo_factura_encabezado());
Txt_fecha.setText(venta.getFecha_emision());
Txt_numero.setText(venta.getNo_serie());
Txt_cliente.setText(venta.getCodigo_cliente());
Txt_vendedor.setText(venta.getCodigo_vendedor());
Txt_cobrador.setText(venta.getCodigo_cobrador());
Txt_total.setText(venta.getSubtotal_encabezado());
txt_estatus.setText(venta.getEstatus_factura());
Txt_fecha1.setText(venta.getFecha_emision());
Txt_servicio.setText(venta.getPrecio_servicio());
Txt_cantidad.setText(venta1.getCantidad_servicio());
Txt_precio.setText(venta1.getPrecio_servicio());
Txt_impuesto.setText(venta.getImpuesto_iva_encabezado());
Txt_reservacion.setText(venta.getReservacion());
Txt_servicio.setText(venta.getServicio());


}

public Proceso_Factura_venta() {
        initComponents();
     llenadoDeCombos1();
     llenadoDeCombos2();
     llenadoDeCombos();
     llenadoDeTablas();
     llenadoDeTabla2();
  
        
        
      
}
  
        
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Txt_contabilidad = new javax.swing.JTextField();
        Txt_fecha = new javax.swing.JTextField();
        Txt_numero = new javax.swing.JTextField();
        cbox_cliente = new javax.swing.JComboBox<>();
        cbox_vendedor = new javax.swing.JComboBox<>();
        cbox_cobrador = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        Txt_cobrador = new javax.swing.JLabel();
        Txt_vendedor = new javax.swing.JLabel();
        Txt_cliente = new javax.swing.JLabel();
        txt_encabezado = new javax.swing.JTextField();
        Btn_Buscar = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Txt_precio = new javax.swing.JTextField();
        Txt_fecha1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Txt_cantidad = new javax.swing.JTextField();
        Txt_servicio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Txt_impuesto = new javax.swing.JTextField();
        c = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        Btn_Agregar = new javax.swing.JButton();
        Btn_Modificar = new javax.swing.JButton();
        Btn_Eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        join = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Jtfactura = new javax.swing.JTable();
        Txt_reservacion = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Txt_total = new javax.swing.JTextField();
        Btn_reporte = new javax.swing.JButton();
        Btn_Agregar1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_estatus = new javax.swing.JTextField();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel21.setText("FACTURA VENTA");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, -1, -1));

        jLabel18.setText("CODIGO COBRADOR");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel2.setText("NO. FACTURA");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        jLabel13.setText("CODIGO CLIENTE");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel15.setText("FECHA DE FACTURACION");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel17.setText("CONTABILIDAD");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, 20));

        jLabel1.setText("FACTURA ENCABECERA");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel2.add(Txt_contabilidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 110, -1));
        jPanel2.add(Txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 110, -1));
        jPanel2.add(Txt_numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 110, -1));

        jPanel2.add(cbox_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 110, -1));

        jPanel2.add(cbox_vendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 110, -1));

        jPanel2.add(cbox_cobrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 110, -1));

        jLabel20.setText("CODIGO VENDEDOR");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));
        jPanel2.add(Txt_cobrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 90, 20));
        jPanel2.add(Txt_vendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 90, 20));
        jPanel2.add(Txt_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 110, 20));

        txt_encabezado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_encabezadoActionPerformed(evt);
            }
        });
        jPanel2.add(txt_encabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 110, -1));

        Btn_Buscar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Btn_Buscar.setText("Buscar");
        Btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BuscarActionPerformed(evt);
            }
        });
        jPanel2.add(Btn_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 63, 80, 30));

        jToggleButton1.setText("Guardar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 90, 40));

        jToggleButton2.setText("Modificar");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 223, 90, 40));

        jToggleButton3.setText("Eliminar");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jToggleButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 223, 80, 40));

        jLabel14.setText("NUEMRO DE RESERVCION");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("FACTURA DETALLE");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel12.setText("FECHA");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel10.setText("CANTIDAD");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel8.setText("IMPUESTO");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 10));
        jPanel3.add(Txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 109, 20));
        jPanel3.add(Txt_fecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 109, -1));

        jLabel11.setText("SERVICIO");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));
        jPanel3.add(Txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 109, -1));
        jPanel3.add(Txt_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 109, -1));

        jLabel6.setText("PRECIO");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));
        jPanel3.add(Txt_impuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 109, 20));

        c.setText("Calcular");
        c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cActionPerformed(evt);
            }
        });
        jPanel3.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 83, 90, 30));

        jToggleButton4.setText("Actualizar");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jToggleButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 83, 110, 30));

        Btn_Agregar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Btn_Agregar.setText("Guardar");
        Btn_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AgregarActionPerformed(evt);
            }
        });
        jPanel3.add(Btn_Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 90, 30));

        Btn_Modificar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Btn_Modificar.setText("Modificar");
        Btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ModificarActionPerformed(evt);
            }
        });
        jPanel3.add(Btn_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 100, 30));

        Btn_Eliminar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Btn_Eliminar.setText("Eliminar");
        Btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EliminarActionPerformed(evt);
            }
        });
        jPanel3.add(Btn_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 90, 30));

        join.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "FECHA", "RESERVACION", "SERVIO", "catidad", "precio"
            }
        ));
        jScrollPane1.setViewportView(join);

        Jtfactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "FECHA", "SERVIVO", "CANTIDAD"
            }
        ));
        jScrollPane2.setViewportView(Jtfactura);

        jLabel16.setText("TOTAL");

        Btn_reporte.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Btn_reporte.setText("Reporte");
        Btn_reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_reporteActionPerformed(evt);
            }
        });

        Btn_Agregar1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        Btn_Agregar1.setText("AGREGAR");
        Btn_Agregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Agregar1ActionPerformed(evt);
            }
        });

        jLabel4.setText("FACTURA PENDIENTE");

        jLabel5.setText("FACTURA EN LINEA");

        jLabel7.setText("Estatus");

        jToggleButton5.setText("Nueva Factura");
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });

        jToggleButton6.setText("Enviar a Finanzas");
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });

        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton2.setText("Ayuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(51, 51, 51)
                                .addComponent(Btn_Agregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(133, 133, 133))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Btn_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(46, 46, 46)
                                .addComponent(jToggleButton6)
                                .addGap(144, 144, 144))
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel21))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)
                        .addGap(34, 34, 34)
                        .addComponent(Txt_reservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton5)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(Txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel7)
                        .addGap(31, 31, 31)
                        .addComponent(txt_estatus, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(133, 133, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(Txt_reservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16)
                                .addComponent(Txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)
                                .addComponent(txt_estatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Btn_Agregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jToggleButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(Btn_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(594, 594, 594))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ModificarActionPerformed
Factura_VentaDao Factura_VentaDao  = new Factura_VentaDao();
 Factura_VentaDao1 Factura_VentaDao1  = new Factura_VentaDao1();
       
        Factura_Venta AInser1 = new Factura_Venta();
            AInser1.setNo_serie1(Txt_numero.getText());
        AInser1.setCodigo_factura_encabezado(txt_encabezado.getText());
      
       
        AInser1.setPrecio_servicio(Txt_precio.getText());

        AInser1.setCantidad_servicio(Txt_cantidad.getText());
       
        Factura_VentaDao1.update1(AInser1);

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


//           Factura_VentaDao.update1(AInsertar1);
//
        // TODO add your handling code here:
       
               
                Registro_ventaDao Registro_ventaDao = new Registro_ventaDao();
        
                Registro_venta In = new Registro_venta();
         
                In.setAccion("Insertar");
        In.setNo_serie(Txt_numero.getText());
                In.setTabla("3001");
                In.setTotal(Txt_total.getText());  
      
          
          
          
    }//GEN-LAST:event_Btn_ModificarActionPerformed

    
    
    
    
    
    private void Btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EliminarActionPerformed
  Factura_VentaDao1 Factura_VentaDao1  = new Factura_VentaDao1();
       
        Factura_Venta AInser1 = new Factura_Venta();
        AInser1.setNo_serie1(Txt_numero.getText());
        AInser1.setCodigo_factura_encabezado(txt_encabezado.getText());
      
       
        AInser1.setPrecio_servicio(Txt_precio.getText());

        AInser1.setCantidad_servicio(Txt_cantidad.getText());
       
        Factura_VentaDao1.delete(AInser1);
            
     
//        Cuenta_ContableDao Cuenta_ContableDao  = new Cuenta_ContableDao();
//       
//        Cuenta_Contable AInser = new Cuenta_Contable();
//        AInser.setCodigo_clasificacion(Txt_numero.getText());
//        AInser.setCodigo_subclasificacion(txt_encabezado.getText());
//      
//       
//        AInser.setEstado_contable(txt_estatus.getText());
//
//        AInser.setMonto(Txt_total.getText());
//        AInser.setEfecto_contable("abono");
//       
//        Cuenta_ContableDao.(AInser);
//            
 BitacoraDao BitacoraDAO = new BitacoraDao();
        
                Bitacora Insertar = new Bitacora();
                Insertar.setId_Usuario(Login.usuarioComercial);
                Insertar.setAccion("Eliminar");
        
                Insertar.setCodigoAplicacion("3003");
                Insertar.setModulo("3000");
        
                try {
                        BitacoraDAO.insert(Insertar);
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
                    }
     
     
    
//
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_EliminarActionPerformed

    private void Btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AgregarActionPerformed

 Factura_VentaDao1 Factura_VentaDao1  = new Factura_VentaDao1();
       
        Factura_Venta AInser1 = new Factura_Venta();
        AInser1.setNo_serie1(Txt_numero.getText());
        AInser1.setCodigo_factura_encabezado(txt_encabezado.getText());
      
       
        AInser1.setPrecio_servicio(Txt_precio.getText());

        AInser1.setCantidad_servicio(Txt_cantidad.getText());
       
        Factura_VentaDao1.insert1(AInser1);
            
   
        
        
        
        ////        GenerarPermisos permisos = new GenerarPermisos();
        ////        MDI_Components mdi_Components = new MDI_Components();
        ////
//        ////        String id = "0";
   

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
                
                Registro_ventaDao  DAO = new Registro_ventaDao();
        
                Registro_venta Inserta = new Registro_venta();
                Inserta.setUsuario(Login.usuarioComercial);
                Inserta.setAccion("Insertar");
        
                Inserta.setTabla("3001");
                Inserta.setTotal(Txt_total.getText());
        




   
                Registro_ventaDao Registro_ventaDao = new Registro_ventaDao();
        
                Registro_venta In = new Registro_venta();
         
                In.setAccion("Insertar");
        In.setNo_serie(Txt_numero.getText());
                In.setTabla("3001");
                In.setTotal(Txt_total.getText());

       
    }//GEN-LAST:event_Btn_AgregarActionPerformed

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

    private void Btn_Agregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Agregar1ActionPerformed
 String valor =  cbox_cliente.getSelectedItem().toString();
      String valor2 =  cbox_vendedor.getSelectedItem().toString();
        String valor3 =  cbox_cobrador.getSelectedItem().toString();
        Buscar.setCodigo_Cliente(valor);
        Buscar1.setCodigo_Vendedor(valor2);
         Buscar2.setCodigo_Cobrador(valor3);
       Buscar =   Cliente.query( Buscar);
       Buscar1 =   vendedor.query( Buscar1);
        Buscar2 =   cobrador.query( Buscar2);
       
           
            Txt_cliente.setText(  Buscar.getCodigo_Cliente());
              Txt_vendedor.setText(  Buscar1.getCodigo_Vendedor());
              Txt_cobrador.setText(  Buscar2.getCodigo_Cobrador());
              
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_Agregar1ActionPerformed

    private void txt_encabezadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_encabezadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_encabezadoActionPerformed

    private void Btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BuscarActionPerformed
buscarVendedor1();


// TODO add your handling code here:
    }//GEN-LAST:event_Btn_BuscarActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
 Factura_VentaDao Factura_VentaDao  = new Factura_VentaDao();
 Factura_VentaDao1 Factura_VentaDao1  = new Factura_VentaDao1();
        Factura_Venta AInser = new Factura_Venta();
      
        AInser.setCodigo_factura_encabezado(txt_encabezado.getText());
       
        AInser.setFecha_emision(Txt_fecha.getText());
        AInser.setNo_serie(Txt_numero.getText());
       
        AInser.setCodigo_cliente(Txt_cliente.getText());
        AInser.setCodigo_vendedor(Txt_vendedor.getText());
        AInser.setCodigo_cobrador(Txt_cobrador.getText());
        AInser.setSubtotal_encabezado(Txt_total.getText());
        AInser.setFecha_vencimiento(Txt_fecha1.getText());
        AInser.setEstatus_factura(txt_estatus.getText());
         AInser.setReservacion(Txt_reservacion.getText());
 AInser.setServicio(Txt_servicio.getText());

        AInser.setImpuesto_iva_encabezado(Txt_impuesto.getText());
        Factura_VentaDao.insert(AInser);
         BitacoraDao BitacoraDAO = new BitacoraDao();
        
                Bitacora Insertar = new Bitacora();
                Insertar.setId_Usuario(Login.usuarioComercial);
                Insertar.setAccion("Insertar");
        
                Insertar.setCodigoAplicacion("3003");
                Insertar.setModulo("3000");
        
                try {
                        BitacoraDAO.insert(Insertar);
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
                    }
         
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
 Factura_VentaDao Factura_VentaDao  = new Factura_VentaDao();
 
        Factura_Venta AInser = new Factura_Venta();
      
           AInser.setNo_serie(Txt_numero.getText());
        AInser.setCodigo_factura_encabezado(txt_encabezado.getText());
       
        AInser.setFecha_emision(Txt_fecha.getText());
     
       
        AInser.setCodigo_cliente(Txt_cliente.getText());
        AInser.setCodigo_vendedor(Txt_vendedor.getText());
        AInser.setCodigo_cobrador(Txt_cobrador.getText());
        AInser.setSubtotal_encabezado(Txt_total.getText());
        AInser.setFecha_vencimiento(Txt_fecha1.getText());
        AInser.setEstatus_factura(txt_estatus.getText());
         AInser.setReservacion(Txt_reservacion.getText());
 AInser.setServicio(Txt_servicio.getText());

        AInser.setImpuesto_iva_encabezado(Txt_impuesto.getText());
        Factura_VentaDao.update(AInser);
         BitacoraDao BitacoraDAO = new BitacoraDao();
        
                Bitacora Insertar = new Bitacora();
                Insertar.setId_Usuario(Login.usuarioComercial);
                Insertar.setAccion("Modificar");
        
                Insertar.setCodigoAplicacion("3003");
                Insertar.setModulo("3000");
        
                try {
                        BitacoraDAO.insert(Insertar);
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
                    }
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed

 Factura_VentaDao Factura_VentaDao  = new Factura_VentaDao();
        Factura_Venta AInser = new Factura_Venta();
         AInser.setNo_serie(Txt_numero.getText());
        AInser.setCodigo_factura_encabezado(txt_encabezado.getText());
       
        AInser.setFecha_emision(Txt_fecha.getText());
       
       
        AInser.setCodigo_cliente(Txt_cliente.getText());
        AInser.setCodigo_vendedor(Txt_vendedor.getText());
        AInser.setCodigo_cobrador(Txt_cobrador.getText());
        AInser.setSubtotal_encabezado(Txt_total.getText());
        AInser.setFecha_vencimiento(Txt_fecha1.getText());
        AInser.setEstatus_factura(txt_estatus.getText());
         AInser.setReservacion(Txt_reservacion.getText());
 AInser.setServicio(Txt_servicio.getText());

        AInser.setImpuesto_iva_encabezado(Txt_impuesto.getText());
        Factura_VentaDao.delete(AInser);
       BitacoraDao BitacoraDAO = new BitacoraDao();
        
                Bitacora Insertar = new Bitacora();
                Insertar.setId_Usuario(Login.usuarioComercial);
                Insertar.setAccion("Eliminar");
        
                Insertar.setCodigoAplicacion("3003");
                Insertar.setModulo("3000");
        
                try {
                        BitacoraDAO.insert(Insertar);
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cActionPerformed
    
        
        String valor1 ,valor2;
float resultado;
valor1=this.Txt_precio.getText();
valor2=this.Txt_cantidad.getText();
float valor3=Float.parseFloat(valor1);
float valor4=Float.parseFloat(valor2);
resultado = valor3 * valor4;
String resultado2 = Float.toString(resultado) ;
this.Txt_total.setText(resultado2);

   
        String valor5 ,valor6="1.12";
float resultado4;

valor6=this.Txt_total.getText();
float valor8=Float.parseFloat(valor6);
resultado4 = (float) (valor8/1.12*0.12);
String resultado3 = Float.toString(resultado4) ;
this.Txt_impuesto.setText(resultado3);



        // TODO add your handling code here:
    }//GEN-LAST:event_cActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
   
        String valor1 ,valor2;
float resultado;
valor1=this.Txt_precio.getText();
valor2=this.Txt_cantidad.getText();
float valor3=Float.parseFloat(valor1);
float valor4=Float.parseFloat(valor2);
resultado = valor3 - valor4;
String resultado2 = Float.toString(resultado) ;
this.Txt_total.setText(resultado2);
  String valor5 ,valor6="1.12";
float resultado4;

valor6=this.Txt_total.getText();
float valor8=Float.parseFloat(valor6);
resultado4 = (float) (valor8/1.12*0.12);
String resultado3 = Float.toString(resultado4) ;
this.Txt_impuesto.setText(resultado3);

        
// TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
    limpiar();
        this.Txt_total.setText("0");
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
Cuenta_ContableDao Cuenta_ContableDao  = new Cuenta_ContableDao();
       
        Cuenta_Contable AInsert = new Cuenta_Contable();
         AInsert.setCodigo_contable(Txt_numero.getText());
        AInsert.setCodigo_clasificacion(Txt_numero.getText());
        AInsert.setCodigo_subclasificacion(txt_encabezado.getText());
      
       
        AInsert.setEstado_contable(txt_estatus.getText());

        AInsert.setMonto(Txt_total.getText());
        AInsert.setEfecto_contable("1");
       
       Cuenta_ContableDao.insert(AInsert);
            

        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiar();
        llenadoDeTablas();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if ((new File("src\\main\\java\\Comercial\\reportes\\factura.chm")).exists()) {
                Process p = Runtime
                .getRuntime()
                .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\Comercial\\reportes\\factura.chm");
                p.waitFor();
            } else {
                JOptionPane.showMessageDialog(null, "La ayuda no Fue encontrada");
            }
            //System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Agregar;
    private javax.swing.JButton Btn_Agregar1;
    private javax.swing.JButton Btn_Buscar;
    private javax.swing.JButton Btn_Eliminar;
    private javax.swing.JButton Btn_Modificar;
    private javax.swing.JButton Btn_reporte;
    private javax.swing.JTable Jtfactura;
    private javax.swing.JTextField Txt_cantidad;
    private javax.swing.JLabel Txt_cliente;
    private javax.swing.JLabel Txt_cobrador;
    private javax.swing.JTextField Txt_contabilidad;
    private javax.swing.JTextField Txt_fecha;
    private javax.swing.JTextField Txt_fecha1;
    private javax.swing.JTextField Txt_impuesto;
    private javax.swing.JTextField Txt_numero;
    private javax.swing.JTextField Txt_precio;
    private javax.swing.JTextField Txt_reservacion;
    private javax.swing.JTextField Txt_servicio;
    private javax.swing.JTextField Txt_total;
    private javax.swing.JLabel Txt_vendedor;
    private javax.swing.JToggleButton c;
    private javax.swing.JComboBox<String> cbox_cliente;
    private javax.swing.JComboBox<String> cbox_cobrador;
    private javax.swing.JComboBox<String> cbox_vendedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JTable join;
    private javax.swing.JTextField txt_encabezado;
    private javax.swing.JTextField txt_estatus;
    // End of variables declaration//GEN-END:variables
}
