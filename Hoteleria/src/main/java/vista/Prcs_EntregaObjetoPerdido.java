/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import datos.HabitacionDAO;
import datos.ObjetoPerdidoDAO;
import dominio.Habitacion;
import dominio.ObjetoPerdido;
import dominio.ProcesosRepetidos;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leelu
 */
public class Prcs_EntregaObjetoPerdido extends javax.swing.JInternalFrame {
        ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
    ObjetoPerdido asignacion = new ObjetoPerdido();
    DefaultTableModel modelo1;
    DefaultTableModel modelo2;
    DefaultTableCellRenderer centro = new DefaultTableCellRenderer();

    /**
     * Creates new form Prcs_EntregaObjetoPerdido
     */
    public Prcs_EntregaObjetoPerdido() {
        initComponents();
        diseño();
        fecha_actual();
        cargar_habitaciones();
        imprimir_Objetos();
        imprimir_Objetos_entregar();
    }
    
            public void diseño() {
        this.setTitle("Entrega Objetos Perdidos");
        ImageIcon icono = new ImageIcon("src/main/java/assets/package.png");
        this.setFrameIcon(icono);
        Txt_codigo2.setBorder(null);
        prcs_repetidos.Cursor(Btn_ayuda, Btn_cancelar, Btn_guardar2, Btn_reporte, Btn_buscar, Tbl_Servicios, Tbl_Asignaciones);
    }
            
            public void cargar_habitaciones() {
        txt_habitacion.addItem("Seleccionar...");
        HabitacionDAO personaDAO = new HabitacionDAO();
        HabitacionDAO.codigoAuxiliar="";
        List<Habitacion> habitaciones = personaDAO.select();
        for (Habitacion habitacion : habitaciones) {
            txt_habitacion.addItem(String.valueOf(habitacion.getId()));   
            }
        }
            
            private static boolean isNumeric(String cadena){
        try {
                Integer.parseInt(cadena);
                return true;
        } catch (NumberFormatException nfe){
                return false;
        }
    }
            
            public void imprimir_Objetos() {
        modelo1 = new DefaultTableModel();
        modelo1.addColumn("ID");
        modelo1.addColumn("Habitacion");
        modelo1.addColumn("Ama");
        modelo1.addColumn("Fecha");
        modelo1.addColumn("Objeto");
        Tbl_Servicios.setModel(modelo1);

        centro.setHorizontalAlignment(JLabel.CENTER);
        Tbl_Servicios.getColumnModel().getColumn(0).setCellRenderer(centro);
        Tbl_Servicios.getColumnModel().getColumn(1).setCellRenderer(centro);
        Tbl_Servicios.getColumnModel().getColumn(2).setCellRenderer(centro);
        Tbl_Servicios.getColumnModel().getColumn(3).setCellRenderer(centro);
        Tbl_Servicios.getColumnModel().getColumn(4).setCellRenderer(centro);

        Tbl_Servicios.getColumnModel().getColumn(0).setPreferredWidth(50);
        Tbl_Servicios.getColumnModel().getColumn(1).setPreferredWidth(50);
        Tbl_Servicios.getColumnModel().getColumn(2).setPreferredWidth(50);
        Tbl_Servicios.getColumnModel().getColumn(3).setPreferredWidth(50);
        Tbl_Servicios.getColumnModel().getColumn(4).setPreferredWidth(50);
    }
            
            public void imprimir_Objetos_entregar() {
                ObjetoPerdidoDAO.codigoAuxiliar="";
                ObjetoPerdidoDAO.nombreAuxiliar="";
        modelo2 = new DefaultTableModel();
        modelo2.addColumn("ID");
        modelo2.addColumn("Habitacion");
        modelo2.addColumn("Ama");
        modelo2.addColumn("Fecha");
        modelo2.addColumn("Objeto");
        Tbl_Asignaciones.setModel(modelo2);

        centro.setHorizontalAlignment(JLabel.CENTER);
        Tbl_Asignaciones.getColumnModel().getColumn(0).setCellRenderer(centro);
        Tbl_Asignaciones.getColumnModel().getColumn(1).setCellRenderer(centro);
        Tbl_Asignaciones.getColumnModel().getColumn(2).setCellRenderer(centro);
        Tbl_Asignaciones.getColumnModel().getColumn(3).setCellRenderer(centro);
        Tbl_Asignaciones.getColumnModel().getColumn(4).setCellRenderer(centro);
        
        Tbl_Asignaciones.getColumnModel().getColumn(0).setPreferredWidth(50);
        Tbl_Asignaciones.getColumnModel().getColumn(1).setPreferredWidth(50);
        Tbl_Asignaciones.getColumnModel().getColumn(2).setPreferredWidth(50);
        Tbl_Asignaciones.getColumnModel().getColumn(3).setPreferredWidth(50);
        Tbl_Asignaciones.getColumnModel().getColumn(4).setPreferredWidth(50);
    }
            private void limpiar(){
        Txt_codigo2.setText("");
        txt_habitacion.setSelectedItem("Seleccionar...");
        imprimir_Objetos();
        imprimir_Objetos_entregar();
    }
            
            private void limpiart(){
        imprimir_Objetos();
        imprimir_Objetos_entregar();
    }       
            
            public void fecha_actual() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        fecha.setDate(date);
    }            
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_ingresoDatos2 = new javax.swing.JPanel();
        Lbl_id2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        fecha = new com.toedter.calendar.JDateChooser();
        Btn_fondoGuardar2 = new javax.swing.JPanel();
        Btn_guardar2 = new javax.swing.JLabel();
        Btn_fondo_reporte = new javax.swing.JPanel();
        Btn_reporte = new javax.swing.JLabel();
        Btn_fondo_ayuda = new javax.swing.JPanel();
        Btn_ayuda = new javax.swing.JLabel();
        Btn_fondo_cancelar = new javax.swing.JPanel();
        Btn_cancelar = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tbl_Asignaciones = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tbl_Servicios = new javax.swing.JTable();
        Btn_fondoBuscar = new javax.swing.JPanel();
        Btn_buscar = new javax.swing.JLabel();
        txt_habitacion = new javax.swing.JComboBox<>();
        Lbl_id3 = new javax.swing.JLabel();
        Txt_codigo2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(36, 47, 65));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        Pnl_ingresoDatos2.setBackground(new java.awt.Color(36, 47, 65));
        Pnl_ingresoDatos2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INGRESO DE DATOS:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        Lbl_id2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_id2.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_id2.setText("Identificacion:");

        fecha.setEnabled(false);

        Btn_fondoGuardar2.setBackground(new java.awt.Color(97, 212, 195));

        Btn_guardar2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_guardar2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_guardar2.setText("Insertar");
        Btn_guardar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_guardar2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_guardar2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_guardar2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoGuardar2Layout = new javax.swing.GroupLayout(Btn_fondoGuardar2);
        Btn_fondoGuardar2.setLayout(Btn_fondoGuardar2Layout);
        Btn_fondoGuardar2Layout.setHorizontalGroup(
            Btn_fondoGuardar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(Btn_fondoGuardar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_guardar2, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
        );
        Btn_fondoGuardar2Layout.setVerticalGroup(
            Btn_fondoGuardar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(Btn_fondoGuardar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_guardar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        Btn_fondo_reporte.setBackground(new java.awt.Color(97, 212, 195));

        Btn_reporte.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_reporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_reporte.setText("Reporte");
        Btn_reporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_reporteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_reporteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_reporteMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_reporteLayout = new javax.swing.GroupLayout(Btn_fondo_reporte);
        Btn_fondo_reporte.setLayout(Btn_fondo_reporteLayout);
        Btn_fondo_reporteLayout.setHorizontalGroup(
            Btn_fondo_reporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondo_reporteLayout.setVerticalGroup(
            Btn_fondo_reporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Btn_fondo_ayuda.setBackground(new java.awt.Color(253, 255, 182));

        Btn_ayuda.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_ayuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_ayuda.setText("Ayuda");
        Btn_ayuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_ayudaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_ayudaLayout = new javax.swing.GroupLayout(Btn_fondo_ayuda);
        Btn_fondo_ayuda.setLayout(Btn_fondo_ayudaLayout);
        Btn_fondo_ayudaLayout.setHorizontalGroup(
            Btn_fondo_ayudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondo_ayudaLayout.setVerticalGroup(
            Btn_fondo_ayudaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Btn_fondo_cancelar.setBackground(new java.awt.Color(255, 128, 115));

        Btn_cancelar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_cancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_cancelar.setText("Cancelar");
        Btn_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_cancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_cancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_cancelarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_cancelarLayout = new javax.swing.GroupLayout(Btn_fondo_cancelar);
        Btn_fondo_cancelar.setLayout(Btn_fondo_cancelarLayout);
        Btn_fondo_cancelarLayout.setHorizontalGroup(
            Btn_fondo_cancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );
        Btn_fondo_cancelarLayout.setVerticalGroup(
            Btn_fondo_cancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Tbl_Asignaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "IDENTIFICAION", "FECHA", "OBJETO"
            }
        ));
        jScrollPane3.setViewportView(Tbl_Asignaciones);

        Tbl_Servicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "HABITACION", "AMA", "FECHA", "OBJETO"
            }
        ));
        jScrollPane4.setViewportView(Tbl_Servicios);

        Btn_fondoBuscar.setBackground(new java.awt.Color(97, 212, 195));

        Btn_buscar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_buscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_buscar.setText("Buscar");
        Btn_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_buscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_buscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_buscarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoBuscarLayout = new javax.swing.GroupLayout(Btn_fondoBuscar);
        Btn_fondoBuscar.setLayout(Btn_fondoBuscarLayout);
        Btn_fondoBuscarLayout.setHorizontalGroup(
            Btn_fondoBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
            .addGroup(Btn_fondoBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
        );
        Btn_fondoBuscarLayout.setVerticalGroup(
            Btn_fondoBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(Btn_fondoBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_buscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        Lbl_id3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_id3.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_id3.setText("Habitacion:");

        jButton1.setText("<<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText(">>");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText(">");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Pnl_ingresoDatos2Layout = new javax.swing.GroupLayout(Pnl_ingresoDatos2);
        Pnl_ingresoDatos2.setLayout(Pnl_ingresoDatos2Layout);
        Pnl_ingresoDatos2Layout.setHorizontalGroup(
            Pnl_ingresoDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatos2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_ingresoDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                    .addGroup(Pnl_ingresoDatos2Layout.createSequentialGroup()
                        .addGroup(Pnl_ingresoDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lbl_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lbl_id3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(Pnl_ingresoDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3)
                            .addComponent(txt_habitacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Txt_codigo2))))
                .addGap(18, 18, 18)
                .addGroup(Pnl_ingresoDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_ingresoDatos2Layout.createSequentialGroup()
                        .addGroup(Pnl_ingresoDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btn_fondoGuardar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_fondo_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_fondo_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_fondo_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Pnl_ingresoDatos2Layout.createSequentialGroup()
                        .addComponent(Btn_fondoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(368, 368, 368)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        Pnl_ingresoDatos2Layout.setVerticalGroup(
            Pnl_ingresoDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatos2Layout.createSequentialGroup()
                .addGroup(Pnl_ingresoDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_ingresoDatos2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Pnl_ingresoDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_habitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lbl_id3))
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Btn_fondoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Pnl_ingresoDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_id2)
                    .addComponent(Txt_codigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Pnl_ingresoDatos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_ingresoDatos2Layout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(76, 76, 76)
                        .addComponent(Btn_fondoGuardar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_fondo_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_fondo_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_fondo_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_ingresoDatos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_ingresoDatos2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_guardar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardar2MouseClicked
if (Prcs_EntregaObjetoPerdido.isNumeric(txt_habitacion.getSelectedItem().toString())) {
            if (txt_habitacion.getSelectedItem().toString().length()!=0&&Txt_codigo2.getText().length()!=0) {
        ObjetoPerdidoDAO modulosDAO = new ObjetoPerdidoDAO();
                ObjetoPerdidoDAO.codigoAuxiliar="";
                ObjetoPerdidoDAO.nombreAuxiliar="";
        String Vector[]=new String[5];
            ObjetoPerdido moduloInsertar = new ObjetoPerdido();
            for (int i = 0; i < Tbl_Asignaciones.getRowCount(); i++) {
             
           
           Vector[0]=(String) Tbl_Asignaciones.getValueAt(i, 0);
           Vector[1]=(String) Tbl_Asignaciones.getValueAt(i, 1);
           Vector[2]=(String) Tbl_Asignaciones.getValueAt(i, 2);
           Vector[3]=(String) Tbl_Asignaciones.getValueAt(i, 3);
           Vector[4]=(String) Tbl_Asignaciones.getValueAt(i, 4);
            
            moduloInsertar.setIdobjeto(Vector[0]);           
            moduloInsertar.setAma(Vector[2]);
            moduloInsertar.setHabitacion(Vector[1]);
            String fechaactual = new SimpleDateFormat("yyyy-MM-dd").format(fecha.getDate());
            moduloInsertar.setFechae(fechaactual);
            moduloInsertar.setObjeto(Vector[4]);
            moduloInsertar.setDpi(Txt_codigo2.getText());
            moduloInsertar.setEstado("2");
            
            modulosDAO.update(moduloInsertar);   
        }
            
            JOptionPane.showMessageDialog(null, "Objeto Entregado");
            }else{
            JOptionPane.showMessageDialog(null, "Existen campos vacios, por favor revise y llene los campos");
        }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione una habitacion");
        }
        limpiar();
    }//GEN-LAST:event_Btn_guardar2MouseClicked

    private void Btn_guardar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardar2MouseEntered
        Btn_fondoGuardar2.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_guardar2MouseEntered

    private void Btn_guardar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardar2MouseExited
        Btn_fondoGuardar2.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_guardar2MouseExited

    private void Btn_reporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseClicked

    }//GEN-LAST:event_Btn_reporteMouseClicked

    private void Btn_reporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseEntered
        Btn_fondo_reporte.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_reporteMouseEntered

    private void Btn_reporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseExited
        Btn_fondo_reporte.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_reporteMouseExited

    private void Btn_ayudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseClicked
        prcs_repetidos.imprimirAyuda("AyudaMantenimientoServicios.chm");
    }//GEN-LAST:event_Btn_ayudaMouseClicked

    private void Btn_ayudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseEntered
        Btn_fondo_ayuda.setBackground(new Color(255, 255, 63));
    }//GEN-LAST:event_Btn_ayudaMouseEntered

    private void Btn_ayudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseExited
        Btn_fondo_ayuda.setBackground(new Color(253, 255, 182));
    }//GEN-LAST:event_Btn_ayudaMouseExited

    private void Btn_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseClicked
limpiar();
    }//GEN-LAST:event_Btn_cancelarMouseClicked

    private void Btn_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseEntered
        Btn_fondo_cancelar.setBackground(new Color(255, 52, 31));
    }//GEN-LAST:event_Btn_cancelarMouseEntered

    private void Btn_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseExited
        Btn_fondo_cancelar.setBackground(new Color(255, 128, 115));
    }//GEN-LAST:event_Btn_cancelarMouseExited

    private void Btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseClicked
limpiart();
        String combobox=txt_habitacion.getSelectedItem().toString();
        int validar=Integer.parseInt(combobox);        
        String datos[] = new String[5];
        ObjetoPerdidoDAO dao = new ObjetoPerdidoDAO();
        ObjetoPerdidoDAO.codigoAuxiliar="";
                ObjetoPerdidoDAO.nombreAuxiliar="";
        List<ObjetoPerdido> personas = dao.select();
        for (ObjetoPerdido persona : personas) {
            if (validar==Integer.parseInt(persona.getHabitacion())) {
                if (persona.getEstado().equals("1")) {
                    
                
            datos[0] = persona.getIdobjeto();
            datos[1] = persona.getHabitacion();
            datos[2] = persona.getAma();
            datos[3] = persona.getFecha();
            datos[4] = persona.getObjeto();
            
            modelo1.addRow(datos);
            Tbl_Servicios.setModel(modelo1);
                }
            }
        }
        for (ObjetoPerdido persona : personas) {
                if (persona.getEstado().equals("2")&&persona.getDpi().equals(Txt_codigo2.getText())) {
                    
                
            datos[0] = persona.getIdobjeto();
            datos[1] = persona.getHabitacion();
            datos[2] = persona.getAma();
            datos[3] = persona.getFecha();
            datos[4] = persona.getObjeto();
            
            modelo2.addRow(datos);
            Tbl_Asignaciones.setModel(modelo2);
                }
            }
    }//GEN-LAST:event_Btn_buscarMouseClicked

    private void Btn_buscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseEntered
        Btn_fondoBuscar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_buscarMouseEntered

    private void Btn_buscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseExited
        Btn_fondoBuscar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_buscarMouseExited

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = Tbl_Servicios.getSelectedRow();
        if (1 == 1) {
            if (filaSeleccionada >= 0) {
                String Vector[] = new String[5];
                Vector[0] = Tbl_Servicios.getValueAt(filaSeleccionada, 0).toString();
                Vector[1] = Tbl_Servicios.getValueAt(filaSeleccionada, 1).toString();
                Vector[2] = Tbl_Servicios.getValueAt(filaSeleccionada, 2).toString();
                Vector[3] = Tbl_Servicios.getValueAt(filaSeleccionada, 3).toString();
                Vector[4] = Tbl_Servicios.getValueAt(filaSeleccionada, 4).toString();
                modelo2.addRow(Vector);
                modelo1.removeRow(filaSeleccionada);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < Tbl_Servicios.getRowCount(); i++) {
            String Vector[] = new String[5];
            Vector[0] = Tbl_Servicios.getValueAt(i, 0).toString();
            Vector[1] = Tbl_Servicios.getValueAt(i, 1).toString();
            Vector[2] = Tbl_Servicios.getValueAt(i, 2).toString();
            Vector[3] = Tbl_Servicios.getValueAt(i, 3).toString();
            Vector[4] = Tbl_Servicios.getValueAt(i, 4).toString();
            modelo2.addRow(Vector);
        }
        imprimir_Objetos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int filaSeleccionada = Tbl_Asignaciones.getSelectedRow();
        if (1 == 1) {
            if (filaSeleccionada >= 0) {
                String Vector[] = new String[5];
                Vector[0] = Tbl_Asignaciones.getValueAt(filaSeleccionada, 0).toString();
                Vector[1] = Tbl_Asignaciones.getValueAt(filaSeleccionada, 1).toString();
                Vector[2] = Tbl_Asignaciones.getValueAt(filaSeleccionada, 2).toString();
                Vector[3] = Tbl_Asignaciones.getValueAt(filaSeleccionada, 3).toString();
                Vector[4] = Tbl_Asignaciones.getValueAt(filaSeleccionada, 4).toString();
                modelo1.addRow(Vector);
                modelo2.removeRow(filaSeleccionada);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < Tbl_Asignaciones.getRowCount(); i++) {
            String Vector[] = new String[5];
            Vector[0] = Tbl_Asignaciones.getValueAt(i, 0).toString();
            Vector[1] = Tbl_Asignaciones.getValueAt(i, 1).toString();
            Vector[2] = Tbl_Asignaciones.getValueAt(i, 2).toString();
            Vector[3] = Tbl_Asignaciones.getValueAt(i, 3).toString();
            Vector[4] = Tbl_Asignaciones.getValueAt(i, 4).toString();
            modelo1.addRow(Vector);
        }
        imprimir_Objetos();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Btn_ayuda;
    private javax.swing.JLabel Btn_buscar;
    private javax.swing.JLabel Btn_cancelar;
    private javax.swing.JPanel Btn_fondoBuscar;
    private javax.swing.JPanel Btn_fondoGuardar;
    private javax.swing.JPanel Btn_fondoGuardar1;
    private javax.swing.JPanel Btn_fondoGuardar2;
    private javax.swing.JPanel Btn_fondo_ayuda;
    private javax.swing.JPanel Btn_fondo_cancelar;
    private javax.swing.JPanel Btn_fondo_reporte;
    private javax.swing.JLabel Btn_guardar;
    private javax.swing.JLabel Btn_guardar1;
    private javax.swing.JLabel Btn_guardar2;
    private javax.swing.JLabel Btn_reporte;
    private javax.swing.JLabel Lbl_id;
    private javax.swing.JLabel Lbl_id1;
    private javax.swing.JLabel Lbl_id2;
    private javax.swing.JLabel Lbl_id3;
    private javax.swing.JPanel Pnl_ingresoDatos;
    private javax.swing.JPanel Pnl_ingresoDatos1;
    private javax.swing.JPanel Pnl_ingresoDatos2;
    private javax.swing.JTable Tbl_Asignaciones;
    private javax.swing.JTable Tbl_Servicios;
    private javax.swing.JTextField Txt_codigo;
    private javax.swing.JTextField Txt_codigo1;
    private javax.swing.JTextField Txt_codigo2;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JComboBox<String> txt_habitacion;
    // End of variables declaration//GEN-END:variables
}
