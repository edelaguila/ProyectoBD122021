/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import datos.GuardarBitacora;
import datos.HuespedDAO;
import datos.ReservacionDAO;
import dominio.Huesped;
import dominio.ProcesosRepetidos;
import dominio.Reservacion;
import java.awt.Color;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import seguridad.vista.GenerarPermisos;
import seguridad.vista.Login_LD;

/**
 *
 * @author leone
 */
public class Prcs_Reservacion extends javax.swing.JInternalFrame {

    ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
    Reservacion reservacion = new Reservacion();
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    Date fechaentrada = null, fechasalida = null, fechaactual = null;

    GuardarBitacora bitacora = new GuardarBitacora();

    void habilitarAcciones() {

        var codigoAplicacion = 2207;
        var usuario = Login_LD.usuario;

        Btn_guardar.setVisible(false);
        Btn_modificar.setVisible(false);
        Btn_eliminar.setVisible(false);
        Btn_buscar.setVisible(false);

        GenerarPermisos permisos = new GenerarPermisos();

        String[] permisosApp = new String[5];

        for (int i = 0; i < 5; i++) {
            permisosApp[i] = permisos.getAccionesAplicacion(codigoAplicacion, usuario)[i];
        }

        if (permisosApp[0].equals("1")) {
            Btn_guardar.setVisible(true);
        }
        if (permisosApp[1].equals("1")) {
            Btn_buscar.setVisible(true);
        }
        if (permisosApp[2].equals("1")) {
            Btn_modificar.setVisible(true);
        }
        if (permisosApp[3].equals("1")) {
            Btn_eliminar.setVisible(true);
        }
    }

    /**
     * Creates new form Prcs_Reservacion
     */
    public Prcs_Reservacion() {
        initComponents();
        habilitarAcciones();
        actualizarTabla("");
        diseño();
        fechaActual();
    }

    public void fechaActual() {
        Date date = new Date();
        Date date2 = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Dtc_fechaActual.setDate(date);
        Dtc_fechaIngreso.setMinSelectableDate(date);
        Dtc_fechaEgreso.setMinSelectableDate(date);
    }

    public void diseño() {
        this.setTitle("Reservación PASO 1");
        ImageIcon icono = new ImageIcon("src/main/java/assets/price.png");
        this.setFrameIcon(icono);
        Txt_codigo.setBorder(null);
        Txt_buscar.setBorder(null);
        Txt_nombreCliente.setBorder(null);
        Txt_cantPersonas.setBorder(null);
        Txt_docIdentificacion.setBorder(null);
        Rdb_limpiar2.setVisible(false);
        prcs_repetidos.Cursor(Btn_ayuda, Btn_cancelar, Btn_eliminar, Btn_guardar, Btn_modificar, Btn_reporte, Btn_buscar, Btn_buscarCliente, Tbl_Datos);
    }

    public void actualizarTabla(String dato) {
        ReservacionDAO.codigoAuxReservacion = dato;
        ReservacionDAO.codigoAuxCliente = dato;
        ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
        String columnas[] = {"ID", "F. Reservación", "F. Ingreso", "F. Egreso", "ID Cliente", "Cant. Personas", "Estado"};
        int cantidadcolumnas = columnas.length;
        prcs_repetidos.llenarColumnas(columnas, cantidadcolumnas, Tbl_Datos);
        String datos[] = new String[cantidadcolumnas];
        int tamaño[] = {40, 100, 100, 100, 50, 100, 100};
        ReservacionDAO reservaciondao = new ReservacionDAO();
        List<Reservacion> reservacion = reservaciondao.select();
        for (Reservacion listaReservaciones : reservacion) {
            datos[0] = listaReservaciones.getIdReservacion();
            datos[1] = listaReservaciones.getFechaActual();
            datos[2] = listaReservaciones.getFechaIngreso();
            datos[3] = listaReservaciones.getFechaEgreso();
            datos[4] = listaReservaciones.getIdCliente();
            datos[5] = listaReservaciones.getCantidadPersonas();
            if (listaReservaciones.getEstadoReservacion().equals("1")) {
                datos[6] = "Activo";
            } else {
                datos[6] = "Inactivo";
            }
            prcs_repetidos.llenarFilas(datos, tamaño, Tbl_Datos);
        }
    }

    public void Limpiar() {
        prcs_repetidos.Limpiar(Txt_buscar, Txt_codigo, Txt_cantPersonas, Txt_docIdentificacion, Txt_nombreCliente);
        Dtc_fechaEgreso.setDate(null);
        Dtc_fechaIngreso.setDate(null);
        Rdb_limpiar2.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Btg_estado = new javax.swing.ButtonGroup();
        Pnl_ingresoDatos = new javax.swing.JPanel();
        Lbl_id = new javax.swing.JLabel();
        Txt_codigo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        Lbl_ingreso = new javax.swing.JLabel();
        Dtc_fechaIngreso = new com.toedter.calendar.JDateChooser();
        jSeparator3 = new javax.swing.JSeparator();
        Lbl_fechaEgreso = new javax.swing.JLabel();
        Dtc_fechaEgreso = new com.toedter.calendar.JDateChooser();
        jSeparator4 = new javax.swing.JSeparator();
        Lbl_docIdenficacion = new javax.swing.JLabel();
        Txt_docIdentificacion = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        Btn_buscarCliente = new javax.swing.JButton();
        Lbl_estado = new javax.swing.JLabel();
        Lbl_nombreCliente = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        Txt_nombreCliente = new javax.swing.JTextField();
        Lbl_cantPersonas = new javax.swing.JLabel();
        Txt_cantPersonas = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        Rdb_activo = new javax.swing.JRadioButton();
        Rdb_limpiar2 = new javax.swing.JRadioButton();
        Rdb_inactivo = new javax.swing.JRadioButton();
        Btn_fondoGuardar = new javax.swing.JPanel();
        Btn_guardar = new javax.swing.JLabel();
        Btn_fondo_eliminar = new javax.swing.JPanel();
        Btn_eliminar = new javax.swing.JLabel();
        Btn_fondo_modificar = new javax.swing.JPanel();
        Btn_modificar = new javax.swing.JLabel();
        Btn_fondo_reporte = new javax.swing.JPanel();
        Btn_reporte = new javax.swing.JLabel();
        Btn_fondo_ayuda = new javax.swing.JPanel();
        Btn_ayuda = new javax.swing.JLabel();
        Btn_fondo_cancelar = new javax.swing.JPanel();
        Btn_cancelar = new javax.swing.JLabel();
        Lbl_ingreso1 = new javax.swing.JLabel();
        Dtc_fechaActual = new com.toedter.calendar.JDateChooser();
        jSeparator8 = new javax.swing.JSeparator();
        Pnl_datos = new javax.swing.JPanel();
        Lbl_codigoNombre = new javax.swing.JLabel();
        Txt_buscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tbl_Datos = new javax.swing.JTable();
        Btn_fondo_buscar = new javax.swing.JPanel();
        Btn_buscar = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(36, 47, 65));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        Pnl_ingresoDatos.setBackground(new java.awt.Color(36, 47, 65));
        Pnl_ingresoDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INGRESO DE DATOS:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        Lbl_id.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_id.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_id.setText("ID Reservación:");

        Txt_codigo.setBackground(new java.awt.Color(36, 47, 65));
        Txt_codigo.setForeground(new java.awt.Color(255, 255, 255));
        Txt_codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_codigo.setPreferredSize(new java.awt.Dimension(200, 20));

        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 20));

        Lbl_ingreso.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_ingreso.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_ingreso.setText("Fecha Ingreso:");

        Dtc_fechaIngreso.setBackground(new java.awt.Color(36, 47, 65));
        Dtc_fechaIngreso.setForeground(new java.awt.Color(255, 255, 255));
        Dtc_fechaIngreso.setDateFormatString("yyyy-MM-dd");
        Dtc_fechaIngreso.setPreferredSize(new java.awt.Dimension(200, 20));

        jSeparator3.setPreferredSize(new java.awt.Dimension(200, 20));

        Lbl_fechaEgreso.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_fechaEgreso.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_fechaEgreso.setText("Fecha Egreso:");

        Dtc_fechaEgreso.setBackground(new java.awt.Color(36, 47, 65));
        Dtc_fechaEgreso.setForeground(new java.awt.Color(255, 255, 255));
        Dtc_fechaEgreso.setDateFormatString("yyyy-MM-dd");
        Dtc_fechaEgreso.setPreferredSize(new java.awt.Dimension(200, 20));

        jSeparator4.setPreferredSize(new java.awt.Dimension(200, 20));

        Lbl_docIdenficacion.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_docIdenficacion.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_docIdenficacion.setText("Doc. Ident:");

        Txt_docIdentificacion.setBackground(new java.awt.Color(36, 47, 65));
        Txt_docIdentificacion.setForeground(new java.awt.Color(255, 255, 255));
        Txt_docIdentificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_docIdentificacion.setPreferredSize(new java.awt.Dimension(200, 20));

        jSeparator2.setPreferredSize(new java.awt.Dimension(200, 20));

        Btn_buscarCliente.setBackground(new java.awt.Color(36, 47, 65));
        Btn_buscarCliente.setForeground(new java.awt.Color(255, 255, 255));
        Btn_buscarCliente.setText("BUSCAR");
        Btn_buscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_buscarClienteActionPerformed(evt);
            }
        });

        Lbl_estado.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_estado.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_estado.setText("Estado:");

        Lbl_nombreCliente.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_nombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_nombreCliente.setText("Nombre:");

        jSeparator5.setPreferredSize(new java.awt.Dimension(200, 20));

        Txt_nombreCliente.setBackground(new java.awt.Color(36, 47, 65));
        Txt_nombreCliente.setForeground(new java.awt.Color(255, 255, 255));
        Txt_nombreCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_nombreCliente.setPreferredSize(new java.awt.Dimension(200, 20));

        Lbl_cantPersonas.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_cantPersonas.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_cantPersonas.setText("Cant. Personas:");

        Txt_cantPersonas.setBackground(new java.awt.Color(36, 47, 65));
        Txt_cantPersonas.setForeground(new java.awt.Color(255, 255, 255));
        Txt_cantPersonas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_cantPersonas.setPreferredSize(new java.awt.Dimension(200, 20));

        jSeparator6.setPreferredSize(new java.awt.Dimension(200, 20));

        Btg_estado.add(Rdb_activo);
        Rdb_activo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        Rdb_activo.setForeground(new java.awt.Color(255, 255, 255));
        Rdb_activo.setText("Activo");

        Btg_estado.add(Rdb_limpiar2);

        Btg_estado.add(Rdb_inactivo);
        Rdb_inactivo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        Rdb_inactivo.setForeground(new java.awt.Color(255, 255, 255));
        Rdb_inactivo.setText("Inactivo");

        Btn_fondoGuardar.setBackground(new java.awt.Color(97, 212, 195));
        Btn_fondoGuardar.setMaximumSize(new java.awt.Dimension(102, 40));
        Btn_fondoGuardar.setMinimumSize(new java.awt.Dimension(102, 40));
        Btn_fondoGuardar.setPreferredSize(new java.awt.Dimension(102, 40));

        Btn_guardar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_guardar.setText("Insertar");
        Btn_guardar.setMaximumSize(new java.awt.Dimension(102, 40));
        Btn_guardar.setMinimumSize(new java.awt.Dimension(102, 40));
        Btn_guardar.setPreferredSize(new java.awt.Dimension(102, 40));
        Btn_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_guardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_guardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_guardarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondoGuardarLayout = new javax.swing.GroupLayout(Btn_fondoGuardar);
        Btn_fondoGuardar.setLayout(Btn_fondoGuardarLayout);
        Btn_fondoGuardarLayout.setHorizontalGroup(
            Btn_fondoGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 102, Short.MAX_VALUE)
            .addGroup(Btn_fondoGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
        );
        Btn_fondoGuardarLayout.setVerticalGroup(
            Btn_fondoGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(Btn_fondoGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        Btn_fondo_eliminar.setBackground(new java.awt.Color(97, 212, 195));
        Btn_fondo_eliminar.setMaximumSize(new java.awt.Dimension(102, 40));
        Btn_fondo_eliminar.setMinimumSize(new java.awt.Dimension(102, 40));

        Btn_eliminar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_eliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_eliminar.setText("Eliminar");
        Btn_eliminar.setMaximumSize(new java.awt.Dimension(102, 40));
        Btn_eliminar.setMinimumSize(new java.awt.Dimension(102, 40));
        Btn_eliminar.setPreferredSize(new java.awt.Dimension(102, 40));
        Btn_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_eliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_eliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_eliminarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_eliminarLayout = new javax.swing.GroupLayout(Btn_fondo_eliminar);
        Btn_fondo_eliminar.setLayout(Btn_fondo_eliminarLayout);
        Btn_fondo_eliminarLayout.setHorizontalGroup(
            Btn_fondo_eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondo_eliminarLayout.setVerticalGroup(
            Btn_fondo_eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Btn_fondo_modificar.setBackground(new java.awt.Color(97, 212, 195));
        Btn_fondo_modificar.setMaximumSize(new java.awt.Dimension(102, 40));
        Btn_fondo_modificar.setMinimumSize(new java.awt.Dimension(102, 40));
        Btn_fondo_modificar.setPreferredSize(new java.awt.Dimension(102, 40));

        Btn_modificar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_modificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_modificar.setText("Modificar");
        Btn_modificar.setMaximumSize(new java.awt.Dimension(102, 40));
        Btn_modificar.setMinimumSize(new java.awt.Dimension(102, 40));
        Btn_modificar.setPreferredSize(new java.awt.Dimension(102, 40));
        Btn_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_modificarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_modificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_modificarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_modificarLayout = new javax.swing.GroupLayout(Btn_fondo_modificar);
        Btn_fondo_modificar.setLayout(Btn_fondo_modificarLayout);
        Btn_fondo_modificarLayout.setHorizontalGroup(
            Btn_fondo_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondo_modificarLayout.setVerticalGroup(
            Btn_fondo_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Btn_fondo_reporte.setBackground(new java.awt.Color(97, 212, 195));
        Btn_fondo_reporte.setMaximumSize(new java.awt.Dimension(102, 40));
        Btn_fondo_reporte.setMinimumSize(new java.awt.Dimension(102, 40));
        Btn_fondo_reporte.setPreferredSize(new java.awt.Dimension(102, 40));

        Btn_reporte.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_reporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_reporte.setText("Reporte");
        Btn_reporte.setMaximumSize(new java.awt.Dimension(102, 40));
        Btn_reporte.setMinimumSize(new java.awt.Dimension(102, 40));
        Btn_reporte.setPreferredSize(new java.awt.Dimension(102, 40));
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
            .addComponent(Btn_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Btn_fondo_ayuda.setBackground(new java.awt.Color(253, 255, 182));
        Btn_fondo_ayuda.setMaximumSize(new java.awt.Dimension(102, 40));
        Btn_fondo_ayuda.setMinimumSize(new java.awt.Dimension(102, 40));
        Btn_fondo_ayuda.setPreferredSize(new java.awt.Dimension(102, 40));

        Btn_ayuda.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_ayuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_ayuda.setText("Ayuda");
        Btn_ayuda.setMaximumSize(new java.awt.Dimension(102, 40));
        Btn_ayuda.setMinimumSize(new java.awt.Dimension(102, 40));
        Btn_ayuda.setPreferredSize(new java.awt.Dimension(102, 40));
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
            .addComponent(Btn_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Btn_fondo_cancelar.setBackground(new java.awt.Color(255, 128, 115));
        Btn_fondo_cancelar.setMaximumSize(new java.awt.Dimension(102, 40));
        Btn_fondo_cancelar.setMinimumSize(new java.awt.Dimension(102, 40));

        Btn_cancelar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_cancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_cancelar.setText("Cancelar");
        Btn_cancelar.setMaximumSize(new java.awt.Dimension(102, 40));
        Btn_cancelar.setMinimumSize(new java.awt.Dimension(102, 40));
        Btn_cancelar.setPreferredSize(new java.awt.Dimension(102, 40));
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
            .addComponent(Btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondo_cancelarLayout.setVerticalGroup(
            Btn_fondo_cancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Lbl_ingreso1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_ingreso1.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_ingreso1.setText("Fecha Actual:");

        Dtc_fechaActual.setBackground(new java.awt.Color(36, 47, 65));
        Dtc_fechaActual.setForeground(new java.awt.Color(255, 255, 255));
        Dtc_fechaActual.setDateFormatString("yyyy-MM-dd");
        Dtc_fechaActual.setEnabled(false);
        Dtc_fechaActual.setPreferredSize(new java.awt.Dimension(200, 20));

        jSeparator8.setPreferredSize(new java.awt.Dimension(200, 20));

        javax.swing.GroupLayout Pnl_ingresoDatosLayout = new javax.swing.GroupLayout(Pnl_ingresoDatos);
        Pnl_ingresoDatos.setLayout(Pnl_ingresoDatosLayout);
        Pnl_ingresoDatosLayout.setHorizontalGroup(
            Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Lbl_ingreso, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Lbl_docIdenficacion)
                                        .addComponent(Lbl_fechaEgreso)
                                        .addComponent(Lbl_nombreCliente)))
                                .addGap(18, 18, 18)
                                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Dtc_fechaEgreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Dtc_fechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Pnl_ingresoDatosLayout.createSequentialGroup()
                                            .addComponent(Rdb_activo)
                                            .addGap(18, 18, 18)
                                            .addComponent(Rdb_limpiar2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Rdb_inactivo))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Txt_cantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Txt_nombreCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                                                    .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                        .addComponent(Txt_docIdentificacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(Btn_buscarCliente)))
                                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Lbl_estado)
                                    .addComponent(Lbl_cantPersonas)))
                            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Lbl_ingreso1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Txt_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Dtc_fechaActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btn_fondo_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_fondoGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Btn_fondo_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_fondo_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btn_fondo_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_fondo_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Pnl_ingresoDatosLayout.setVerticalGroup(
            Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_id)
                    .addComponent(Txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Lbl_ingreso1)
                    .addComponent(Dtc_fechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Lbl_ingreso)
                    .addComponent(Dtc_fechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Lbl_fechaEgreso)
                    .addComponent(Dtc_fechaEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_docIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_docIdenficacion)
                    .addComponent(Btn_buscarCliente))
                .addGap(2, 2, 2)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Txt_nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_nombreCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_cantPersonas)
                    .addComponent(Txt_cantPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Lbl_estado)
                                .addComponent(Rdb_activo))
                            .addComponent(Rdb_limpiar2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btn_fondo_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_fondo_ayuda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_fondo_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btn_fondoGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_fondo_eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_fondo_modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addComponent(Rdb_inactivo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        Pnl_datos.setBackground(new java.awt.Color(36, 47, 65));
        Pnl_datos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        Lbl_codigoNombre.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_codigoNombre.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_codigoNombre.setText("Código o Nombre:");

        Txt_buscar.setBackground(new java.awt.Color(36, 47, 65));
        Txt_buscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Txt_buscar.setForeground(new java.awt.Color(255, 255, 255));
        Txt_buscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Tbl_Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tbl_Datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tbl_DatosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tbl_Datos);

        Btn_fondo_buscar.setBackground(new java.awt.Color(97, 212, 195));
        Btn_fondo_buscar.setMaximumSize(new java.awt.Dimension(102, 40));
        Btn_fondo_buscar.setMinimumSize(new java.awt.Dimension(102, 40));

        Btn_buscar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_buscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_buscar.setText("Buscar");
        Btn_buscar.setMaximumSize(new java.awt.Dimension(102, 40));
        Btn_buscar.setMinimumSize(new java.awt.Dimension(102, 40));
        Btn_buscar.setPreferredSize(new java.awt.Dimension(102, 40));
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

        javax.swing.GroupLayout Btn_fondo_buscarLayout = new javax.swing.GroupLayout(Btn_fondo_buscar);
        Btn_fondo_buscar.setLayout(Btn_fondo_buscarLayout);
        Btn_fondo_buscarLayout.setHorizontalGroup(
            Btn_fondo_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondo_buscarLayout.setVerticalGroup(
            Btn_fondo_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Pnl_datosLayout = new javax.swing.GroupLayout(Pnl_datos);
        Pnl_datos.setLayout(Pnl_datosLayout);
        Pnl_datosLayout.setHorizontalGroup(
            Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                    .addGroup(Pnl_datosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Lbl_codigoNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator7)
                            .addComponent(Txt_buscar))
                        .addGap(18, 18, 18)
                        .addComponent(Btn_fondo_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        Pnl_datosLayout.setVerticalGroup(
            Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_datosLayout.createSequentialGroup()
                .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Btn_fondo_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Pnl_datosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Txt_buscar)
                                .addComponent(Lbl_codigoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_ingresoDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Pnl_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Pnl_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pnl_ingresoDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseClicked
        if (prcs_repetidos.isNoneEmpty(Txt_codigo, Txt_docIdentificacion, Txt_nombreCliente, Txt_cantPersonas)) {
            if (prcs_repetidos.isDateNoneEmpty(Dtc_fechaEgreso, Dtc_fechaIngreso)) {
                if (prcs_repetidos.isSelected(Rdb_activo, Rdb_inactivo)) {
                    if (prcs_repetidos.isNumeric(Txt_codigo.getText(), Txt_docIdentificacion.getText(), Txt_cantPersonas.getText())) {

                        ReservacionDAO reservaciondao = new ReservacionDAO();
                        String fechaactual = new SimpleDateFormat("yyyy-MM-dd").format(Dtc_fechaActual.getDate());
                        String fechaentrada = new SimpleDateFormat("yyyy-MM-dd").format(Dtc_fechaIngreso.getDate());
                        String fechasalida = new SimpleDateFormat("yyyy-MM-dd").format(Dtc_fechaEgreso.getDate());

                        reservacion.setIdReservacion(Txt_codigo.getText());
                        reservacion.setFechaActual(fechaactual);
                        reservacion.setFechaIngreso(fechaentrada);
                        reservacion.setFechaEgreso(fechasalida);
                        reservacion.setIdCliente(Txt_docIdentificacion.getText());
                        reservacion.setCantidadPersonas(Txt_cantPersonas.getText());
                        if (Rdb_activo.isSelected()) {
                            reservacion.setEstadoReservacion("1");
                        } else {
                            reservacion.setEstadoReservacion("0");
                        }

                        reservaciondao.insert(reservacion);
                        bitacora.GuardarEnBitacora("insertar", "2207");
                        actualizarTabla("");
                        Limpiar();
                    }
                }
            }
        }
    }//GEN-LAST:event_Btn_guardarMouseClicked

    private void Btn_guardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseEntered
        Btn_fondoGuardar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_guardarMouseEntered

    private void Btn_guardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseExited
        Btn_fondoGuardar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_guardarMouseExited

    private void Btn_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseClicked
        if (prcs_repetidos.isNoneEmpty(Txt_codigo)) {
            if (prcs_repetidos.isNumeric(Txt_codigo.getText())) {
                if (prcs_repetidos.ConfirmarEliminacion("eliminar", "reservación", this)) {
                    ReservacionDAO reservaciondao = new ReservacionDAO();
                    reservacion.setIdReservacion(Txt_codigo.getText());
                    reservaciondao.delete(reservacion);
                    bitacora.GuardarEnBitacora("eliminar", "2207");
                    actualizarTabla("");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar la reservación");
                }
            }
        }
    }//GEN-LAST:event_Btn_eliminarMouseClicked

    private void Btn_eliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseEntered
        Btn_fondo_eliminar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_eliminarMouseEntered

    private void Btn_eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseExited
        Btn_fondo_eliminar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_eliminarMouseExited

    private void Btn_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_modificarMouseClicked
        if (prcs_repetidos.isNoneEmpty(Txt_codigo, Txt_docIdentificacion, Txt_nombreCliente, Txt_cantPersonas)) {
            if (prcs_repetidos.isDateNoneEmpty(Dtc_fechaEgreso, Dtc_fechaIngreso)) {
                if (prcs_repetidos.isSelected(Rdb_activo, Rdb_inactivo)) {
                    if (prcs_repetidos.isNumeric(Txt_codigo.getText(), Txt_docIdentificacion.getText(), Txt_cantPersonas.getText())) {

                        ReservacionDAO reservaciondao = new ReservacionDAO();
                        String fechaactual = new SimpleDateFormat("yyyy-MM-dd").format(Dtc_fechaActual.getDate());
                        String fechaentrada = new SimpleDateFormat("yyyy-MM-dd").format(Dtc_fechaIngreso.getDate());
                        String fechasalida = new SimpleDateFormat("yyyy-MM-dd").format(Dtc_fechaEgreso.getDate());
                        System.out.println(fechaactual + " " + fechaentrada + " " + fechasalida);

                        reservacion.setIdReservacion(Txt_codigo.getText());
                        reservacion.setFechaActual(fechaactual);
                        reservacion.setFechaIngreso(fechaentrada);
                        reservacion.setFechaEgreso(fechasalida);
                        reservacion.setIdCliente(Txt_docIdentificacion.getText());
                        reservacion.setCantidadPersonas(Txt_cantPersonas.getText());
                        if (Rdb_activo.isSelected()) {
                            reservacion.setEstadoReservacion("1");
                        } else {
                            reservacion.setEstadoReservacion("0");
                        }

                        reservaciondao.update(reservacion);
                        bitacora.GuardarEnBitacora("modificar", "2207");
                        actualizarTabla("");
                        Limpiar();
                    }
                }
            }
        }
    }//GEN-LAST:event_Btn_modificarMouseClicked

    private void Btn_modificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_modificarMouseEntered
        Btn_fondo_modificar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_modificarMouseEntered

    private void Btn_modificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_modificarMouseExited
        Btn_fondo_modificar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_modificarMouseExited

    private void Btn_reporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseClicked
        prcs_repetidos.imprimirReporte("Rpt_PrcsReservación.jrxml", "Reporte Reservaciones");
        bitacora.GuardarEnBitacora("reporte", "2207");
    }//GEN-LAST:event_Btn_reporteMouseClicked

    private void Btn_reporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseEntered
        Btn_fondo_reporte.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_reporteMouseEntered

    private void Btn_reporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseExited
        Btn_fondo_reporte.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_reporteMouseExited

    private void Btn_ayudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseClicked
        prcs_repetidos.imprimirAyuda("AyudaMantenimientoServicios.chm");
        bitacora.GuardarEnBitacora("ayuda", "2207");
    }//GEN-LAST:event_Btn_ayudaMouseClicked

    private void Btn_ayudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseEntered
        Btn_fondo_ayuda.setBackground(new Color(255, 255, 63));
    }//GEN-LAST:event_Btn_ayudaMouseEntered

    private void Btn_ayudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseExited
        Btn_fondo_ayuda.setBackground(new Color(253, 255, 182));
    }//GEN-LAST:event_Btn_ayudaMouseExited

    private void Btn_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseClicked
        Limpiar();
    }//GEN-LAST:event_Btn_cancelarMouseClicked

    private void Btn_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseEntered
        Btn_fondo_cancelar.setBackground(new Color(255, 52, 31));
    }//GEN-LAST:event_Btn_cancelarMouseEntered

    private void Btn_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseExited
        Btn_fondo_cancelar.setBackground(new Color(255, 128, 115));
    }//GEN-LAST:event_Btn_cancelarMouseExited

    private void Tbl_DatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_DatosMouseClicked
        if (evt.getClickCount() == 2) {
            Txt_codigo.setText(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 0).toString());
            try {
                fechaentrada = formato.parse(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 2).toString());
                fechasalida = formato.parse(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 3).toString());
            } catch (ParseException ex) {
                Logger.getLogger(Prcs_Reservacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            Dtc_fechaIngreso.setDate(fechaentrada);
            Dtc_fechaEgreso.setDate(fechasalida);
            Txt_docIdentificacion.setText(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 4).toString());
            Txt_cantPersonas.setText(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 5).toString());
            if (Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 6).toString().equals("Activo")) {
                Rdb_activo.setSelected(true);
            } else {
                Rdb_inactivo.setSelected(true);
            }
            bitacora.GuardarEnBitacora("buscar", "2207");
        }
    }//GEN-LAST:event_Tbl_DatosMouseClicked

    private void Btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseClicked
        actualizarTabla(Txt_buscar.getText());
        bitacora.GuardarEnBitacora("buscar", "2207");
        Limpiar();
    }//GEN-LAST:event_Btn_buscarMouseClicked

    private void Btn_buscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseEntered
        Btn_fondo_buscar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_buscarMouseEntered

    private void Btn_buscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseExited
        Btn_fondo_buscar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_buscarMouseExited

    private void Btn_buscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_buscarClienteActionPerformed
        if (prcs_repetidos.isNoneEmpty(Txt_docIdentificacion)) {
            if (prcs_repetidos.isNumeric(Txt_docIdentificacion.getText())) {
                HuespedDAO huespeddao = new HuespedDAO();
                Huesped huesped = new Huesped();
                huesped.setPasaporte(Txt_docIdentificacion.getText());
                huesped = huespeddao.query(huesped);

                if (huesped.getNombre() != null) {
                    Txt_nombreCliente.setText(huesped.getNombre() + " " + huesped.getApellido());
                } else {
                    JOptionPane.showMessageDialog(null, "Huesped no encontrado");
                }
            }
        }
    }//GEN-LAST:event_Btn_buscarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Btg_estado;
    private javax.swing.JLabel Btn_ayuda;
    private javax.swing.JLabel Btn_buscar;
    private javax.swing.JButton Btn_buscarCliente;
    private javax.swing.JLabel Btn_cancelar;
    private javax.swing.JLabel Btn_eliminar;
    private javax.swing.JPanel Btn_fondoGuardar;
    private javax.swing.JPanel Btn_fondo_ayuda;
    private javax.swing.JPanel Btn_fondo_buscar;
    private javax.swing.JPanel Btn_fondo_cancelar;
    private javax.swing.JPanel Btn_fondo_eliminar;
    private javax.swing.JPanel Btn_fondo_modificar;
    private javax.swing.JPanel Btn_fondo_reporte;
    private javax.swing.JLabel Btn_guardar;
    private javax.swing.JLabel Btn_modificar;
    private javax.swing.JLabel Btn_reporte;
    private com.toedter.calendar.JDateChooser Dtc_fechaActual;
    private com.toedter.calendar.JDateChooser Dtc_fechaEgreso;
    private com.toedter.calendar.JDateChooser Dtc_fechaIngreso;
    private javax.swing.JLabel Lbl_cantPersonas;
    private javax.swing.JLabel Lbl_codigoNombre;
    private javax.swing.JLabel Lbl_docIdenficacion;
    private javax.swing.JLabel Lbl_estado;
    private javax.swing.JLabel Lbl_fechaEgreso;
    private javax.swing.JLabel Lbl_id;
    private javax.swing.JLabel Lbl_ingreso;
    private javax.swing.JLabel Lbl_ingreso1;
    private javax.swing.JLabel Lbl_nombreCliente;
    private javax.swing.JPanel Pnl_datos;
    private javax.swing.JPanel Pnl_ingresoDatos;
    private javax.swing.JRadioButton Rdb_activo;
    private javax.swing.JRadioButton Rdb_inactivo;
    private javax.swing.JRadioButton Rdb_limpiar2;
    private javax.swing.JTable Tbl_Datos;
    private javax.swing.JTextField Txt_buscar;
    private javax.swing.JTextField Txt_cantPersonas;
    private javax.swing.JTextField Txt_codigo;
    private javax.swing.JTextField Txt_docIdentificacion;
    private javax.swing.JTextField Txt_nombreCliente;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    // End of variables declaration//GEN-END:variables
}
