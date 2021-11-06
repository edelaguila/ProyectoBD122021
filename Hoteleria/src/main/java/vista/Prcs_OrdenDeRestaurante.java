package vista;

import datos.AsignacionOrdenDAO;
import dominio.ProcesosRepetidos;
import dominio.OrdenRestaurante;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import seguridad.vista.GenerarPermisos;
import seguridad.vista.Login_LD;
import java.time.LocalDateTime;

/**
 *
 * @author Jeff
 */
public class Prcs_OrdenDeRestaurante extends javax.swing.JInternalFrame {

    ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
    OrdenRestaurante restaurante = new OrdenRestaurante();

    void habilitarAcciones() {

        var codigoAplicacion = 2004;
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

    public Prcs_OrdenDeRestaurante() {
        initComponents();
        diseño();
        actualizarTabla("");
    }

    public void diseño() {
        this.setTitle("Ordenes de Restaurante");
        Txt_CantidadPlatos.setBorder(null);
        Txt_Menu.setBorder(null);
        Txt_Precio.setBorder(null);
        Txt_Habitacion.setBorder(null);
        Txt_NoMesa.setBorder(null);
        Txt_Total.setBorder(null);
        Txt_buscar.setBorder(null);
        prcs_repetidos.Cursor(Btn_ayuda, Btn_cancelar, Btn_eliminar, Btn_guardar, Btn_modificar, Btn_reporte, Btn_buscar, Btn_Total, Btn_catalogo, Btn_precio);
        ImageIcon icono = new ImageIcon("src/main/java/assets/menu.png");
        this.setFrameIcon(icono);
    }

    public void actualizarTabla(String codigo) {
//        ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
//        AsignacionOrdenDAO.codigoAuxiliar = codigo;
//        AsignacionOrdenDAO.nombreAuxiliar = codigo;
//        String columnas[] = {"ID", "MENU", "HABITACIÒN", "CANTIDAD", "MESA/HABITACIÒN", "HORA", "FECHA", "TOTAL"};
//        int cantidadcolumnas = columnas.length;
//        prcs_repetidos.llenarColumnas(columnas, cantidadcolumnas, Tbl_Datos);
//        String datos[] = new String[cantidadcolumnas];
//        int tamaño[] = {50, 60, 75, 75, 175, 60, 60, 60};
//        AsignacionOrdenDAO restaurantedao = new AsignacionOrdenDAO();
//        List<OrdenRestaurante> restaurante = restaurantedao.select();
//        for (OrdenRestaurante listaServicio : restaurante) {
//            datos[0] = String.valueOf(listaServicio.getIdOrden());
//            datos[1] = String.valueOf(listaServicio.getIdMenu());
//            datos[2] = String.valueOf(listaServicio.getIdHabitacion());
//            datos[3] = String.valueOf(listaServicio.getCantidadOrden());
//            datos[4] = String.valueOf(listaServicio.getMesaOrden());
//            datos[5] = String.valueOf(listaServicio.getHoraOrden());
//            datos[6] = String.valueOf(listaServicio.getFechaOrden());
//            datos[7] = String.valueOf(listaServicio.getTotalOrden());
//            prcs_repetidos.llenarFilas(datos, tamaño, Tbl_Datos);
//        }
    }

    public void Limpiar() {
        prcs_repetidos.Limpiar(Txt_CantidadPlatos, Txt_Habitacion, Txt_buscar, Txt_NoMesa, Txt_Total, Txt_Precio);
        Cbx_Servicio.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnGp_tipo = new javax.swing.ButtonGroup();
        BtnGp_estado = new javax.swing.ButtonGroup();
        Pnl_ingresoDatos = new javax.swing.JPanel();
        Lbl_id = new javax.swing.JLabel();
        Lbl_nombre = new javax.swing.JLabel();
        Lbl_descripcion = new javax.swing.JLabel();
        Txt_CantidadPlatos = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        Txt_Habitacion = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
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
        Lbl_nombre1 = new javax.swing.JLabel();
        Txt_NoMesa = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        Btn_fondo_cancelar1 = new javax.swing.JPanel();
        Btn_Total = new javax.swing.JLabel();
        Lbl_nombre2 = new javax.swing.JLabel();
        Txt_Total = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        Cbx_Servicio = new javax.swing.JComboBox<>();
        Lbl_nombre3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Btn_fondo_reporte1 = new javax.swing.JPanel();
        Btn_catalogo = new javax.swing.JLabel();
        Txt_Precio = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        Lbl_id1 = new javax.swing.JLabel();
        Txt_Menu = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        Btn_fondo_reporte2 = new javax.swing.JPanel();
        Btn_precio = new javax.swing.JLabel();
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
        setVisible(true);

        Pnl_ingresoDatos.setBackground(new java.awt.Color(36, 47, 65));
        Pnl_ingresoDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INGRESO DE DATOS:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        Lbl_id.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_id.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_id.setText("Cantidad Platos:");

        Lbl_nombre.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_nombre.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_nombre.setText("No. Habitación:");

        Lbl_descripcion.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_descripcion.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_descripcion.setText("No. Plato");

        Txt_CantidadPlatos.setBackground(new java.awt.Color(36, 47, 65));
        Txt_CantidadPlatos.setForeground(new java.awt.Color(255, 255, 255));
        Txt_CantidadPlatos.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Txt_Habitacion.setBackground(new java.awt.Color(36, 47, 65));
        Txt_Habitacion.setForeground(new java.awt.Color(255, 255, 255));
        Txt_Habitacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Btn_fondoGuardar.setBackground(new java.awt.Color(97, 212, 195));

        Btn_guardar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_guardar.setText("Insertar");
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
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(Btn_fondoGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
        );
        Btn_fondoGuardarLayout.setVerticalGroup(
            Btn_fondoGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(Btn_fondoGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        Btn_fondo_eliminar.setBackground(new java.awt.Color(97, 212, 195));

        Btn_eliminar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_eliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_eliminar.setText("Eliminar");
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
            .addComponent(Btn_eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );
        Btn_fondo_eliminarLayout.setVerticalGroup(
            Btn_fondo_eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Btn_fondo_modificar.setBackground(new java.awt.Color(97, 212, 195));

        Btn_modificar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_modificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_modificar.setText("Modificar");
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
            .addComponent(Btn_reporte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(Btn_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(Btn_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );
        Btn_fondo_cancelarLayout.setVerticalGroup(
            Btn_fondo_cancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_cancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Lbl_nombre1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_nombre1.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_nombre1.setText("No. Mesa:");

        Txt_NoMesa.setEditable(false);
        Txt_NoMesa.setBackground(new java.awt.Color(36, 47, 65));
        Txt_NoMesa.setForeground(new java.awt.Color(255, 255, 255));
        Txt_NoMesa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_NoMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_NoMesaActionPerformed(evt);
            }
        });

        Btn_fondo_cancelar1.setBackground(new java.awt.Color(255, 128, 115));

        Btn_Total.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_Total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_Total.setText("Total");
        Btn_Total.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_TotalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_TotalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_TotalMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_cancelar1Layout = new javax.swing.GroupLayout(Btn_fondo_cancelar1);
        Btn_fondo_cancelar1.setLayout(Btn_fondo_cancelar1Layout);
        Btn_fondo_cancelar1Layout.setHorizontalGroup(
            Btn_fondo_cancelar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_Total, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        Btn_fondo_cancelar1Layout.setVerticalGroup(
            Btn_fondo_cancelar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_Total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        Lbl_nombre2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_nombre2.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_nombre2.setText("Total:");

        Txt_Total.setBackground(new java.awt.Color(36, 47, 65));
        Txt_Total.setForeground(new java.awt.Color(255, 255, 255));
        Txt_Total.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_TotalActionPerformed(evt);
            }
        });

        Cbx_Servicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Restaurante", "Habitación" }));
        Cbx_Servicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Cbx_Servicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Cbx_ServicioItemStateChanged(evt);
            }
        });

        Lbl_nombre3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_nombre3.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_nombre3.setText("Servicio:");

        jLabel1.setText("jLabel1");

        Btn_fondo_reporte1.setBackground(new java.awt.Color(97, 212, 195));

        Btn_catalogo.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_catalogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_catalogo.setText("CATALOGO DE PLATOS");
        Btn_catalogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_catalogoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_catalogoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_catalogoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_reporte1Layout = new javax.swing.GroupLayout(Btn_fondo_reporte1);
        Btn_fondo_reporte1.setLayout(Btn_fondo_reporte1Layout);
        Btn_fondo_reporte1Layout.setHorizontalGroup(
            Btn_fondo_reporte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_catalogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondo_reporte1Layout.setVerticalGroup(
            Btn_fondo_reporte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_catalogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        Txt_Precio.setBackground(new java.awt.Color(36, 47, 65));
        Txt_Precio.setForeground(new java.awt.Color(255, 255, 255));
        Txt_Precio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Lbl_id1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_id1.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_id1.setText("Precio:");

        Txt_Menu.setBackground(new java.awt.Color(36, 47, 65));
        Txt_Menu.setForeground(new java.awt.Color(255, 255, 255));
        Txt_Menu.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Btn_fondo_reporte2.setBackground(new java.awt.Color(97, 212, 195));

        Btn_precio.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_precio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_precio.setText("PRECIO");
        Btn_precio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_precioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_precioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_precioMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_reporte2Layout = new javax.swing.GroupLayout(Btn_fondo_reporte2);
        Btn_fondo_reporte2.setLayout(Btn_fondo_reporte2Layout);
        Btn_fondo_reporte2Layout.setHorizontalGroup(
            Btn_fondo_reporte2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_precio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondo_reporte2Layout.setVerticalGroup(
            Btn_fondo_reporte2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_precio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Pnl_ingresoDatosLayout = new javax.swing.GroupLayout(Pnl_ingresoDatos);
        Pnl_ingresoDatos.setLayout(Pnl_ingresoDatosLayout);
        Pnl_ingresoDatosLayout.setHorizontalGroup(
            Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btn_fondo_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                                .addComponent(Lbl_nombre2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(4, 4, 4))
                            .addComponent(Lbl_nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lbl_nombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lbl_nombre)
                            .addComponent(jLabel1)
                            .addComponent(Lbl_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_fondoGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Btn_fondo_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Btn_fondo_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Btn_fondo_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Btn_fondo_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator4)
                                    .addComponent(Txt_Total)
                                    .addComponent(Btn_fondo_cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Txt_NoMesa)
                                    .addComponent(jSeparator3)
                                    .addComponent(Cbx_Servicio, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Txt_Habitacion, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator2)
                                    .addComponent(Txt_CantidadPlatos)
                                    .addComponent(jSeparator1)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                            .addComponent(Lbl_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                            .addComponent(Txt_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Pnl_ingresoDatosLayout.createSequentialGroup()
                            .addComponent(Lbl_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(33, 33, 33)
                            .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Btn_fondo_reporte1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                .addComponent(Txt_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                                .addComponent(Btn_fondo_reporte2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Pnl_ingresoDatosLayout.setVerticalGroup(
            Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lbl_descripcion)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addComponent(Txt_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_fondo_reporte1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_fondo_reporte2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_id1))
                .addGap(3, 3, 3)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_CantidadPlatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_id))
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_Habitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_nombre))
                .addGap(2, 2, 2)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cbx_Servicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_nombre3))
                .addGap(18, 18, 18)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_NoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_nombre1))
                .addGap(2, 2, 2)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Btn_fondo_cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_nombre2))
                .addGap(3, 3, 3)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_fondo_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_fondo_ayuda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_fondo_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_fondoGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_fondo_eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_fondo_modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        Pnl_datos.setBackground(new java.awt.Color(36, 47, 65));
        Pnl_datos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        Lbl_codigoNombre.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_codigoNombre.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_codigoNombre.setText("Código:");

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

        javax.swing.GroupLayout Btn_fondo_buscarLayout = new javax.swing.GroupLayout(Btn_fondo_buscar);
        Btn_fondo_buscar.setLayout(Btn_fondo_buscarLayout);
        Btn_fondo_buscarLayout.setHorizontalGroup(
            Btn_fondo_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );
        Btn_fondo_buscarLayout.setVerticalGroup(
            Btn_fondo_buscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Pnl_datosLayout = new javax.swing.GroupLayout(Pnl_datos);
        Pnl_datos.setLayout(Pnl_datosLayout);
        Pnl_datosLayout.setHorizontalGroup(
            Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_ingresoDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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

    private void Btn_reporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseEntered
        Btn_fondo_reporte.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_reporteMouseEntered

    private void Btn_reporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseExited
        Btn_fondo_reporte.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_reporteMouseExited

    private void Btn_guardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseEntered
        Btn_fondoGuardar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_guardarMouseEntered

    private void Btn_eliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseEntered
        Btn_fondo_eliminar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_eliminarMouseEntered

    private void Btn_modificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_modificarMouseEntered
        Btn_fondo_modificar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_modificarMouseEntered

    private void Btn_guardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseExited
        Btn_fondoGuardar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_guardarMouseExited

    private void Btn_eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseExited
        Btn_fondo_eliminar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_eliminarMouseExited

    private void Btn_modificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_modificarMouseExited
        Btn_fondo_modificar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_modificarMouseExited

    private void Btn_ayudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseEntered
        Btn_fondo_ayuda.setBackground(new Color(255, 255, 63));
    }//GEN-LAST:event_Btn_ayudaMouseEntered

    private void Btn_ayudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseExited
        Btn_fondo_ayuda.setBackground(new Color(253, 255, 182));
    }//GEN-LAST:event_Btn_ayudaMouseExited

    private void Btn_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseEntered
        Btn_fondo_cancelar.setBackground(new Color(255, 52, 31));
    }//GEN-LAST:event_Btn_cancelarMouseEntered

    private void Btn_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseExited
        Btn_fondo_cancelar.setBackground(new Color(255, 128, 115));
    }//GEN-LAST:event_Btn_cancelarMouseExited

    private void Btn_buscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseEntered
        Btn_fondo_buscar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_buscarMouseEntered

    private void Btn_buscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseExited
        Btn_fondo_buscar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_buscarMouseExited

    private void Btn_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseClicked
        if (prcs_repetidos.isNoneEmpty(Txt_CantidadPlatos, Txt_Habitacion, Txt_Total)) {
            if (prcs_repetidos.cbxNoneSelected(Cbx_Servicio)) {
                if (prcs_repetidos.isNumeric(Txt_CantidadPlatos.getText(), Txt_Habitacion.getText())) {
//                    String cbxServicio = Cbx_Servicio.getSelectedItem().toString();
//                    LocalDateTime locaDate = LocalDateTime.now();
//                    /*Tiempo*/
//                    int horas = locaDate.getHour();
//                    int minutos = locaDate.getMinute();
//                    int segundos = locaDate.getSecond();
//                    String horaOrden = String.valueOf(horas + ":" + minutos + ":" + segundos);
//                    /*Dias*/
//                    int anio = locaDate.getYear();
//                    int mes = locaDate.getMonthValue();
//                    int dia = locaDate.getDayOfMonth();
//                    String fechaOrden = String.valueOf(anio + "-" + mes + "-" + dia);
//
//                    AsignacionOrdenDAO restauranteDAO = new AsignacionOrdenDAO();
//                    restaurante.setIdMenu(Txt_Menu.getText());
//                    restaurante.setIdHabitacion(Txt_Habitacion.getText());
//                    restaurante.setCantidadOrden(Txt_CantidadPlatos.getText());
//                    if (cbxServicio.equals("Habitación")) {
//                        restaurante.setMesaOrden("Habitación");
//                    } else {
//                        restaurante.setMesaOrden(Txt_NoMesa.getText());
//                    }
//                    restaurante.setHoraOrden(horaOrden);
//                    restaurante.setFechaOrden(fechaOrden);
//                    restaurante.setTotalOrden(Txt_Total.getText());
//
//                    restauranteDAO.insert(restaurante);
//                    actualizarTabla("");
//                    prcs_repetidos.AlertaMensaje("registrada", "Orden", "exitosamente");
//                    Limpiar();
                } else {
                }
            }
        }
    }//GEN-LAST:event_Btn_guardarMouseClicked

    private void Btn_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_modificarMouseClicked
//        if (prcs_repetidos.isNoneEmpty(Txt_Platos, Txt_NoHabitacion) && Txt_Descripcion.getText() != "") {
//            if (prcs_repetidos.isSelected(Rdb_Activo, Rdb_Inactivo)) {
//                if (prcs_repetidos.isNumeric(Txt_Platos.getText(), Txt_NoHabitacion.getText())) {
//                    PisoDAO pisosdao = new PisoDAO();
//                    pisos.setIdPiso(Integer.parseInt(Txt_Platos.getText()));
//                    pisos.setCantidadHabitacionesPiso(Integer.parseInt(Txt_NoHabitacion.getText()));
//                    pisos.setDescripcionPiso(Txt_Descripcion.getText());
//                    if (Rdb_Activo.isSelected()) {
//                        pisos.setEstadoPiso("1");
//                    } else if (Rdb_Inactivo.isSelected()) {
//                        pisos.setEstadoPiso("0");
//                    }
//                    pisosdao.update(pisos);
//                    actualizarTabla("");
//                    prcs_repetidos.AlertaMensaje("modificado", "Piso", "exitosamente");
//                    Limpiar();
//                }
//            }
//        }
    }//GEN-LAST:event_Btn_modificarMouseClicked

    private void Btn_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseClicked
//        if (prcs_repetidos.isNoneEmpty(Txt_Platos)) {
//            if (prcs_repetidos.isNumeric(Txt_Platos.getText())) {
//                if (prcs_repetidos.ConfirmarEliminacion("eliminar", "piso", this)) {
//                    PisoDAO pisosdao = new PisoDAO();
//                    pisos.setIdPiso(Integer.parseInt(Txt_Platos.getText()));
//                    pisosdao.delete(pisos);
//                    actualizarTabla("");
//                    prcs_repetidos.AlertaMensaje("eliminado", "Piso", "exitosamente");
//                    Limpiar();
//                } else {
//                    JOptionPane.showMessageDialog(null, "No se pudo eliminar el piso");
//                }
//            }
//        }
    }//GEN-LAST:event_Btn_eliminarMouseClicked

    private void Tbl_DatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_DatosMouseClicked
        if (evt.getClickCount() == 2) {
            Txt_Menu.setText(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 0).toString());
            Txt_Precio.setText(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 1).toString());
            Txt_CantidadPlatos.setText(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 2).toString());
            Txt_Habitacion.setText(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 3).toString());
            if (Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 4).toString().equals("Habitación")) {
                Cbx_Servicio.setSelectedIndex(2);
            } else {
                Cbx_Servicio.setSelectedIndex(1);
                Txt_NoMesa.setText(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 4).toString());
            }
            Txt_Total.setText(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 7).toString());
        }
    }//GEN-LAST:event_Tbl_DatosMouseClicked

    private void Btn_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseClicked
        Limpiar();
    }//GEN-LAST:event_Btn_cancelarMouseClicked

    private void Btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseClicked
        actualizarTabla(Txt_buscar.getText());
    }//GEN-LAST:event_Btn_buscarMouseClicked

    private void Btn_ayudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseClicked
        prcs_repetidos.imprimirAyuda("AyudaMantenimientoPisos.chm");
    }//GEN-LAST:event_Btn_ayudaMouseClicked

    private void Btn_reporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseClicked
        prcs_repetidos.imprimirReporte("Rpt_MantPisos.jrxml", "Reporte Pisos");
    }//GEN-LAST:event_Btn_reporteMouseClicked

    private void Txt_NoMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_NoMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_NoMesaActionPerformed

    private void Btn_TotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_TotalMouseClicked

    }//GEN-LAST:event_Btn_TotalMouseClicked

    private void Btn_TotalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_TotalMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_TotalMouseEntered

    private void Btn_TotalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_TotalMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_TotalMouseExited

    private void Txt_TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_TotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_TotalActionPerformed

    private void Cbx_ServicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Cbx_ServicioItemStateChanged
        String cbxServicio = Cbx_Servicio.getSelectedItem().toString();
        if (cbxServicio.equals("Restaurante")) {
            Txt_NoMesa.setEditable(true);
        } else if (cbxServicio.equals("Habitación")) {
            Txt_NoMesa.setEditable(false);
        }
    }//GEN-LAST:event_Cbx_ServicioItemStateChanged

    private void Btn_catalogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_catalogoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_catalogoMouseClicked

    private void Btn_catalogoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_catalogoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_catalogoMouseEntered

    private void Btn_catalogoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_catalogoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_catalogoMouseExited

    private void Btn_precioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_precioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_precioMouseClicked

    private void Btn_precioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_precioMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_precioMouseEntered

    private void Btn_precioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_precioMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_precioMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BtnGp_estado;
    private javax.swing.ButtonGroup BtnGp_tipo;
    private javax.swing.JLabel Btn_Total;
    private javax.swing.JLabel Btn_ayuda;
    private javax.swing.JLabel Btn_buscar;
    private javax.swing.JLabel Btn_cancelar;
    private javax.swing.JLabel Btn_catalogo;
    private javax.swing.JLabel Btn_eliminar;
    private javax.swing.JPanel Btn_fondoGuardar;
    private javax.swing.JPanel Btn_fondo_ayuda;
    private javax.swing.JPanel Btn_fondo_buscar;
    private javax.swing.JPanel Btn_fondo_cancelar;
    private javax.swing.JPanel Btn_fondo_cancelar1;
    private javax.swing.JPanel Btn_fondo_eliminar;
    private javax.swing.JPanel Btn_fondo_modificar;
    private javax.swing.JPanel Btn_fondo_reporte;
    private javax.swing.JPanel Btn_fondo_reporte1;
    private javax.swing.JPanel Btn_fondo_reporte2;
    private javax.swing.JLabel Btn_guardar;
    private javax.swing.JLabel Btn_modificar;
    private javax.swing.JLabel Btn_precio;
    private javax.swing.JLabel Btn_reporte;
    private javax.swing.JComboBox<String> Cbx_Servicio;
    private javax.swing.JLabel Lbl_codigoNombre;
    private javax.swing.JLabel Lbl_descripcion;
    private javax.swing.JLabel Lbl_id;
    private javax.swing.JLabel Lbl_id1;
    private javax.swing.JLabel Lbl_nombre;
    private javax.swing.JLabel Lbl_nombre1;
    private javax.swing.JLabel Lbl_nombre2;
    private javax.swing.JLabel Lbl_nombre3;
    private javax.swing.JPanel Pnl_datos;
    private javax.swing.JPanel Pnl_ingresoDatos;
    private javax.swing.JTable Tbl_Datos;
    private javax.swing.JTextField Txt_CantidadPlatos;
    private javax.swing.JTextField Txt_Habitacion;
    private javax.swing.JTextField Txt_Menu;
    private javax.swing.JTextField Txt_NoMesa;
    private javax.swing.JTextField Txt_Precio;
    private javax.swing.JTextField Txt_Total;
    private javax.swing.JTextField Txt_buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    // End of variables declaration//GEN-END:variables
}
