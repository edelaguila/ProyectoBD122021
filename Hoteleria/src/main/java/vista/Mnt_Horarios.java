package vista;

import datos.GuardarBitacora;
import datos.HorarioDAO;
import dominio.ProcesosRepetidos;
import dominio.Horario;
import java.awt.Color;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import seguridad.vista.GenerarPermisos;
import seguridad.vista.Login_LD;

/**
 *
 * @author Jeff
 */
public class Mnt_Horarios extends javax.swing.JInternalFrame {

    ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
    HorarioDAO horariosdao = new HorarioDAO();
    Horario horarios = new Horario();
    GuardarBitacora bitacora = new GuardarBitacora();
    
    void habilitarAcciones() {

        var codigoAplicacion = 2002;
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
     * Creates new form Mnt_Horarios
     */
    public Mnt_Horarios() {
        initComponents();
        diseño();
        actualizarTabla("");
        habilitarAcciones();
    }

    public void diseño() {
        this.setTitle("Mantenimiento de Horarios");
        Txt_Id.setBorder(null);
//        Txt_Extras.setBorder(null);
        Txt_buscar.setBorder(null);
        Rdb_limpiar2.setVisible(false);
        Txt_descripcion.setBorder(BorderFactory.createEmptyBorder());
        Txt_descripcion.setBorder(null);
        prcs_repetidos.Cursor(Btn_ayuda, Btn_cancelar, Btn_eliminar, Btn_guardar, Btn_modificar, Btn_reporte, Btn_buscar);
        ImageIcon icono = new ImageIcon("src/main/java/assets/horarios.png");
        this.setFrameIcon(icono);
    }

    public void actualizarTabla(String codigo) {
        ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
        HorarioDAO.codigoAuxiliar = codigo;
        HorarioDAO.nombreAuxiliar = codigo;
        String columnas[] = {"ID", "ENTRADA", "SALIDA", "DESCRIPCION", "ESTADO"};
        int cantidadcolumnas = columnas.length;
        prcs_repetidos.llenarColumnas(columnas, cantidadcolumnas, Tbl_Datos);
        String datos[] = new String[cantidadcolumnas];
        int tamaño[] = {50, 250, 450, 150, 150};
        HorarioDAO serviciosdao = new HorarioDAO();
        List<Horario> servicio = serviciosdao.select();
        for (Horario listaServicio : servicio) {
            datos[0] = listaServicio.getIdHorario();
            datos[1] = listaServicio.getEntradaHorario();
            datos[2] = listaServicio.getSalidaHorario();
//            datos[3] = listaServicio.getHorasExtrasHorario();
            datos[3] = listaServicio.getDescripcionHorario();
            if (listaServicio.getEstadoHorario().equals("1")) {
                datos[4] = "Activo";
            } else {
                datos[4] = "Inactivo";
            }
            prcs_repetidos.llenarFilas(datos, tamaño, Tbl_Datos);
        }
    }

    public void validarHorarios(int h1, int h2, String cbx1, String cbx2, String cbx3, String cbx4) {
        int total = h1 + 8;
        if (total == h2) {

            if (cbx2 == "pm") {
                if (cbx1.equals("13")) {
                    cbx1 = "1";
                }
                if (cbx1.equals("14")) {
                    cbx1 = "2";
                }
                if (cbx1.equals("15")) {
                    cbx1 = "3";
                }
                if (cbx1.equals("16")) {
                    cbx1 = "4";
                }
                if (cbx1.equals("17")) {
                    cbx1 = "5";
                }
                if (cbx1.equals("18")) {
                    cbx1 = "6";
                }
                if (cbx1.equals("19")) {
                    cbx1 = "7";
                }
                if (cbx1.equals("20")) {
                    cbx1 = "8";
                }
                if (cbx1.equals("21")) {
                    cbx1 = "9";
                }
                if (cbx1.equals("22")) {
                    cbx1 = "10";
                }
                if (cbx1.equals("23")) {
                    cbx1 = "11";
                }
                if (cbx1.equals("24")) {
                    cbx1 = "12";
                }
            }

            if (cbx4 == "pm") {
                if (cbx3.equals("13")) {
                    cbx3 = "1";
                }
                if (cbx3.equals("14")) {
                    cbx3 = "2";
                }
                if (cbx3.equals("15")) {
                    cbx3 = "3";
                }
                if (cbx3.equals("16")) {
                    cbx3 = "4";
                }
                if (cbx3.equals("17")) {
                    cbx3 = "5";
                }
                if (cbx3.equals("18")) {
                    cbx3 = "6";
                }
                if (cbx3.equals("19")) {
                    cbx3 = "7";
                }
                if (cbx3.equals("20")) {
                    cbx3 = "8";
                }
                if (cbx3.equals("21")) {
                    cbx3 = "9";
                }
                if (cbx3.equals("22")) {
                    cbx3 = "10";
                }
                if (cbx3.equals("23")) {
                    cbx3 = "11";
                }
                if (cbx3.equals("24")) {
                    cbx3 = "12";
                }
            }

            horarios.setIdHorario(Txt_Id.getText());
            horarios.setEntradaHorario(cbx1 + " " + cbx2);
            horarios.setSalidaHorario(cbx3 + " " + cbx4);
            horarios.setDescripcionHorario(Txt_descripcion.getText());
            if (Rdb_activo.isSelected()) {
                horarios.setEstadoHorario("1");
            } else if (Rdb_inactivo.isSelected()) {
                horarios.setEstadoHorario("0");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El horario asignado es invalido");
        }
    }

    public void Limpiar() {
        prcs_repetidos.Limpiar(Txt_Id, Txt_buscar);
        Txt_descripcion.setText("");
        Rdb_limpiar2.setSelected(true);
        Cbx_EHora.setSelectedIndex(0);
        Cbx_EJornada.setSelectedIndex(0);
        Cbx_SHora.setSelectedIndex(0);
        Cbx_SJornada.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnGp_tipo = new javax.swing.ButtonGroup();
        BtnGp_estado = new javax.swing.ButtonGroup();
        Pnl_ingresoDatos = new javax.swing.JPanel();
        Lbl_id = new javax.swing.JLabel();
        Lbl_descripcion = new javax.swing.JLabel();
        Lbl_estado = new javax.swing.JLabel();
        Txt_Id = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        Txt_descripcion = new javax.swing.JTextArea();
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
        Lbl_id1 = new javax.swing.JLabel();
        Cbx_EHora = new javax.swing.JComboBox<>();
        Lbl_id2 = new javax.swing.JLabel();
        Lbl_id3 = new javax.swing.JLabel();
        Cbx_EJornada = new javax.swing.JComboBox<>();
        Lbl_id4 = new javax.swing.JLabel();
        Lbl_id5 = new javax.swing.JLabel();
        Cbx_SHora = new javax.swing.JComboBox<>();
        Cbx_SJornada = new javax.swing.JComboBox<>();
        Lbl_id6 = new javax.swing.JLabel();
        Lbl_id7 = new javax.swing.JLabel();
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
        setMaximumSize(new java.awt.Dimension(104, 40));
        setMinimumSize(new java.awt.Dimension(104, 40));
        setVisible(true);

        Pnl_ingresoDatos.setBackground(new java.awt.Color(36, 47, 65));
        Pnl_ingresoDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INGRESO DE DATOS:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        Lbl_id.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_id.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_id.setText("ID:");

        Lbl_descripcion.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_descripcion.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_descripcion.setText("DESCRIPCIÓN:");

        Lbl_estado.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_estado.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_estado.setText("ESTADO:");

        Txt_Id.setBackground(new java.awt.Color(36, 47, 65));
        Txt_Id.setForeground(new java.awt.Color(255, 255, 255));
        Txt_Id.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Txt_descripcion.setBackground(new java.awt.Color(36, 47, 65));
        Txt_descripcion.setColumns(20);
        Txt_descripcion.setForeground(new java.awt.Color(255, 255, 255));
        Txt_descripcion.setRows(5);
        Txt_descripcion.setBorder(null);
        jScrollPane1.setViewportView(Txt_descripcion);

        BtnGp_estado.add(Rdb_activo);
        Rdb_activo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        Rdb_activo.setForeground(new java.awt.Color(255, 255, 255));
        Rdb_activo.setText("Activo");

        BtnGp_estado.add(Rdb_limpiar2);

        BtnGp_estado.add(Rdb_inactivo);
        Rdb_inactivo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        Rdb_inactivo.setForeground(new java.awt.Color(255, 255, 255));
        Rdb_inactivo.setText("Inactivo");

        Btn_fondoGuardar.setBackground(new java.awt.Color(97, 212, 195));

        Btn_guardar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_guardar.setText("Insertar");
        Btn_guardar.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_guardar.setMinimumSize(new java.awt.Dimension(104, 40));
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
            .addGap(0, 104, Short.MAX_VALUE)
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

        Btn_eliminar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_eliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_eliminar.setText("Eliminar");
        Btn_eliminar.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_eliminar.setMinimumSize(new java.awt.Dimension(104, 40));
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
            .addComponent(Btn_eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );
        Btn_fondo_eliminarLayout.setVerticalGroup(
            Btn_fondo_eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Btn_fondo_modificar.setBackground(new java.awt.Color(97, 212, 195));

        Btn_modificar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_modificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_modificar.setText("Modificar");
        Btn_modificar.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_modificar.setMinimumSize(new java.awt.Dimension(104, 40));
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
        Btn_reporte.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_reporte.setMinimumSize(new java.awt.Dimension(104, 40));
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

        Btn_ayuda.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_ayuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_ayuda.setText("Ayuda");
        Btn_ayuda.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_ayuda.setMinimumSize(new java.awt.Dimension(104, 40));
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
        Btn_cancelar.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_cancelar.setMinimumSize(new java.awt.Dimension(104, 40));
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

        Lbl_id1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_id1.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_id1.setText("HORARIO:");

        Cbx_EHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        Lbl_id2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_id2.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_id2.setText("ENTRADA:");

        Lbl_id3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_id3.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_id3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_id3.setText("Hora");

        Cbx_EJornada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "am", "pm" }));

        Lbl_id4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_id4.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_id4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_id4.setText("Jornada");

        Lbl_id5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_id5.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_id5.setText("SALIDA:");

        Cbx_SHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        Cbx_SHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cbx_SHoraActionPerformed(evt);
            }
        });

        Cbx_SJornada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "am", "pm" }));

        Lbl_id6.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_id6.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_id6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_id6.setText("Hora");

        Lbl_id7.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_id7.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_id7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_id7.setText("Jornada");

        javax.swing.GroupLayout Pnl_ingresoDatosLayout = new javax.swing.GroupLayout(Pnl_ingresoDatos);
        Pnl_ingresoDatos.setLayout(Pnl_ingresoDatosLayout);
        Pnl_ingresoDatosLayout.setHorizontalGroup(
            Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
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
                    .addComponent(Btn_fondo_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Lbl_descripcion)
                            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                                .addComponent(Lbl_estado)
                                .addGap(80, 80, 80)
                                .addComponent(Rdb_activo)
                                .addGap(18, 18, 18)
                                .addComponent(Rdb_limpiar2)
                                .addGap(18, 18, 18)
                                .addComponent(Rdb_inactivo))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Lbl_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lbl_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lbl_id5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSeparator1)
                                .addComponent(Txt_Id, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_ingresoDatosLayout.createSequentialGroup()
                                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Lbl_id6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Cbx_EHora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Cbx_SHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Cbx_EJornada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Cbx_SJornada, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Lbl_id7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Pnl_ingresoDatosLayout.createSequentialGroup()
                                .addComponent(Lbl_id3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Lbl_id4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        Pnl_ingresoDatosLayout.setVerticalGroup(
            Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_id))
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Lbl_id1)
                .addGap(8, 8, 8)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_id4)
                    .addComponent(Lbl_id3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cbx_EJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbx_EHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_id2))
                .addGap(18, 18, 18)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_id6)
                    .addComponent(Lbl_id7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lbl_id5)
                    .addComponent(Cbx_SHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbx_SJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Lbl_descripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Lbl_estado)
                        .addComponent(Rdb_limpiar2)
                        .addComponent(Rdb_activo))
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addComponent(Rdb_inactivo)
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
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

    private void Btn_buscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseEntered
        Btn_fondo_buscar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_buscarMouseEntered

    private void Btn_buscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseExited
        Btn_fondo_buscar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_buscarMouseExited

    private void Tbl_DatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_DatosMouseClicked
        if (evt.getClickCount() == 2) {
            String cadena1 = Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 1).toString();
            String[] parts = cadena1.split(" ");
            String part1 = parts[0];
            String part2 = parts[1];

            String cadena2 = Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 2).toString();
            String[] parts2 = cadena2.split(" ");
            String part3 = parts2[0];
            String part4 = parts2[1];

            Txt_Id.setText(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 0).toString());
            Cbx_EHora.setSelectedItem(part1);
            Cbx_EJornada.setSelectedItem(part2);
            Cbx_SHora.setSelectedItem(part3);
            Cbx_SJornada.setSelectedItem(part4);
//            Txt_Extras.setText(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 3).toString());
            Txt_descripcion.setText(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 3).toString());
            if (Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 4).toString().equals("Activo")) {
                Rdb_activo.setSelected(true);
            } else {
                Rdb_inactivo.setSelected(true);
            }
            bitacora.GuardarEnBitacora("Buscar", "2002");
        }
    }//GEN-LAST:event_Tbl_DatosMouseClicked

    private void Btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseClicked
        actualizarTabla(Txt_buscar.getText());
    }//GEN-LAST:event_Btn_buscarMouseClicked

    private void Btn_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseExited
        Btn_fondo_cancelar.setBackground(new Color(255, 128, 115));
    }//GEN-LAST:event_Btn_cancelarMouseExited

    private void Btn_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseEntered
        Btn_fondo_cancelar.setBackground(new Color(255, 52, 31));
    }//GEN-LAST:event_Btn_cancelarMouseEntered

    private void Btn_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseClicked
        Limpiar();
    }//GEN-LAST:event_Btn_cancelarMouseClicked

    private void Btn_ayudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseExited
        Btn_fondo_ayuda.setBackground(new Color(253, 255, 182));
    }//GEN-LAST:event_Btn_ayudaMouseExited

    private void Btn_ayudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseEntered
        Btn_fondo_ayuda.setBackground(new Color(255, 255, 63));
    }//GEN-LAST:event_Btn_ayudaMouseEntered

    private void Btn_reporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseExited
        Btn_fondo_reporte.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_reporteMouseExited

    private void Btn_reporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseEntered
        Btn_fondo_reporte.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_reporteMouseEntered

    private void Btn_modificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_modificarMouseExited
        Btn_fondo_modificar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_modificarMouseExited

    private void Btn_modificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_modificarMouseEntered
        Btn_fondo_modificar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_modificarMouseEntered

    private void Btn_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_modificarMouseClicked
        if (prcs_repetidos.isNoneEmpty(Txt_Id) && Txt_descripcion.getText() != "") {
            if (prcs_repetidos.isSelected(Rdb_activo, Rdb_inactivo)) {
                if (prcs_repetidos.isNumeric(Txt_Id.getText())) {

                    String cbx_Ehora = Cbx_EHora.getSelectedItem().toString();
                    String cbx_Ejornada = Cbx_EJornada.getSelectedItem().toString();
                    String cbx_Shora = Cbx_SHora.getSelectedItem().toString();
                    String cbx_Sjornada = Cbx_SJornada.getSelectedItem().toString();

                    if (cbx_Ejornada == "pm") {
                        if (cbx_Ehora.equals("1")) {
                            cbx_Ehora = "13";
                        }
                        if (cbx_Ehora.equals("2")) {
                            cbx_Ehora = "14";
                        }
                        if (cbx_Ehora.equals("3")) {
                            cbx_Ehora = "15";
                        }
                        if (cbx_Ehora.equals("4")) {
                            cbx_Ehora = "16";
                        }
                        if (cbx_Ehora.equals("5")) {
                            cbx_Ehora = "17";
                        }
                        if (cbx_Ehora.equals("6")) {
                            cbx_Ehora = "18";
                        }
                        if (cbx_Ehora.equals("7")) {
                            cbx_Ehora = "19";
                        }
                        if (cbx_Ehora.equals("8")) {
                            cbx_Ehora = "20";
                        }
                        if (cbx_Ehora.equals("9")) {
                            cbx_Ehora = "21";
                        }
                        if (cbx_Ehora.equals("10")) {
                            cbx_Ehora = "22";
                        }
                        if (cbx_Ehora.equals("11")) {
                            cbx_Ehora = "23";
                        }
                        if (cbx_Ehora.equals("12")) {
                            cbx_Ehora = "24";
                        }
                    }

                    if (cbx_Sjornada == "pm") {
                        if (cbx_Shora.equals("1")) {
                            cbx_Shora = "13";
                        }
                        if (cbx_Shora.equals("2")) {
                            cbx_Shora = "14";
                        }
                        if (cbx_Shora.equals("3")) {
                            cbx_Shora = "15";
                        }
                        if (cbx_Shora.equals("4")) {
                            cbx_Shora = "16";
                        }
                        if (cbx_Shora.equals("5")) {
                            cbx_Shora = "17";
                        }
                        if (cbx_Shora.equals("6")) {
                            cbx_Shora = "18";
                        }
                        if (cbx_Shora.equals("7")) {
                            cbx_Shora = "19";
                        }
                        if (cbx_Shora.equals("8")) {
                            cbx_Shora = "20";
                        }
                        if (cbx_Shora.equals("9")) {
                            cbx_Shora = "21";
                        }
                        if (cbx_Shora.equals("10")) {
                            cbx_Shora = "22";
                        }
                        if (cbx_Shora.equals("11")) {
                            cbx_Shora = "23";
                        }
                        if (cbx_Shora.equals("12")) {
                            cbx_Shora = "24";
                        }
                    }

                    int hora1 = Integer.parseInt(cbx_Ehora);
                    int hora2 = Integer.parseInt(cbx_Shora);

                    validarHorarios(hora1, hora2, cbx_Ehora, cbx_Ejornada, cbx_Shora, cbx_Sjornada);
                    horariosdao.update(horarios);
                    actualizarTabla("");
                    prcs_repetidos.AlertaMensaje("modificado", "Horario", "exitosamente");
                    Limpiar();
                    bitacora.GuardarEnBitacora("Modificar", "2002");
                }
            }
        }
    }//GEN-LAST:event_Btn_modificarMouseClicked

    private void Btn_eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseExited
        Btn_fondo_eliminar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_eliminarMouseExited

    private void Btn_eliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseEntered
        Btn_fondo_eliminar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_eliminarMouseEntered

    private void Btn_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseClicked
        if (prcs_repetidos.isNoneEmpty(Txt_Id)) {
            if (prcs_repetidos.isNumeric(Txt_Id.getText())) {
                if (prcs_repetidos.ConfirmarEliminacion("eliminar", "horario", this)) {
                    HorarioDAO horariosdao = new HorarioDAO();
                    horarios.setIdHorario(Txt_Id.getText());
                    horariosdao.delete(horarios);
                    actualizarTabla("");
                    prcs_repetidos.AlertaMensaje("eliminado", "Horario", "exitosamente");
                    Limpiar();
                    bitacora.GuardarEnBitacora("Eliminar", "2002");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo eliminar el horario");
                }
            }
        }
    }//GEN-LAST:event_Btn_eliminarMouseClicked

    private void Btn_guardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseExited
        Btn_fondoGuardar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_guardarMouseExited

    private void Btn_guardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseEntered
        Btn_fondoGuardar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_guardarMouseEntered

    private void Btn_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseClicked
        if (prcs_repetidos.isNoneEmpty(Txt_Id) && Txt_descripcion.getText() != "") {
            if (prcs_repetidos.isSelected(Rdb_activo, Rdb_inactivo)) {
                if (prcs_repetidos.isNumeric(Txt_Id.getText())) {

                    String cbx_Ehora = Cbx_EHora.getSelectedItem().toString();
                    String cbx_Ejornada = Cbx_EJornada.getSelectedItem().toString();
                    String cbx_Shora = Cbx_SHora.getSelectedItem().toString();
                    String cbx_Sjornada = Cbx_SJornada.getSelectedItem().toString();

                    if (cbx_Ejornada == "pm") {
                        if (cbx_Ehora.equals("1")) {
                            cbx_Ehora = "13";
                        }
                        if (cbx_Ehora.equals("2")) {
                            cbx_Ehora = "14";
                        }
                        if (cbx_Ehora.equals("3")) {
                            cbx_Ehora = "15";
                        }
                        if (cbx_Ehora.equals("4")) {
                            cbx_Ehora = "16";
                        }
                        if (cbx_Ehora.equals("5")) {
                            cbx_Ehora = "17";
                        }
                        if (cbx_Ehora.equals("6")) {
                            cbx_Ehora = "18";
                        }
                        if (cbx_Ehora.equals("7")) {
                            cbx_Ehora = "19";
                        }
                        if (cbx_Ehora.equals("8")) {
                            cbx_Ehora = "20";
                        }
                        if (cbx_Ehora.equals("9")) {
                            cbx_Ehora = "21";
                        }
                        if (cbx_Ehora.equals("10")) {
                            cbx_Ehora = "22";
                        }
                        if (cbx_Ehora.equals("11")) {
                            cbx_Ehora = "23";
                        }
                        if (cbx_Ehora.equals("12")) {
                            cbx_Ehora = "24";
                        }
                    }

                    if (cbx_Sjornada == "pm") {
                        if (cbx_Shora.equals("1")) {
                            cbx_Shora = "13";
                        }
                        if (cbx_Shora.equals("2")) {
                            cbx_Shora = "14";
                        }
                        if (cbx_Shora.equals("3")) {
                            cbx_Shora = "15";
                        }
                        if (cbx_Shora.equals("4")) {
                            cbx_Shora = "16";
                        }
                        if (cbx_Shora.equals("5")) {
                            cbx_Shora = "17";
                        }
                        if (cbx_Shora.equals("6")) {
                            cbx_Shora = "18";
                        }
                        if (cbx_Shora.equals("7")) {
                            cbx_Shora = "19";
                        }
                        if (cbx_Shora.equals("8")) {
                            cbx_Shora = "20";
                        }
                        if (cbx_Shora.equals("9")) {
                            cbx_Shora = "21";
                        }
                        if (cbx_Shora.equals("10")) {
                            cbx_Shora = "22";
                        }
                        if (cbx_Shora.equals("11")) {
                            cbx_Shora = "23";
                        }
                        if (cbx_Shora.equals("12")) {
                            cbx_Shora = "24";
                        }
                    }

                    int hora1 = Integer.parseInt(cbx_Ehora);
                    int hora2 = Integer.parseInt(cbx_Shora);

                    validarHorarios(hora1, hora2, cbx_Ehora, cbx_Ejornada, cbx_Shora, cbx_Sjornada);
                    horariosdao.insert(horarios);
                    actualizarTabla("");
                    prcs_repetidos.AlertaMensaje("guardado", "Horario", "exitosamente");
                    Limpiar();
                    bitacora.GuardarEnBitacora("Guardar", "2002");
                } else {
                }
            }
        }
    }//GEN-LAST:event_Btn_guardarMouseClicked

    private void Cbx_SHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cbx_SHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cbx_SHoraActionPerformed

    private void Btn_ayudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseClicked
        prcs_repetidos.imprimirAyuda("AyudaMantenimientoHorarios.chm");
    }//GEN-LAST:event_Btn_ayudaMouseClicked

    private void Btn_reporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseClicked
        prcs_repetidos.imprimirReporte("Rpt_MantHorario.jrxml", "Reporte Horarios");
    }//GEN-LAST:event_Btn_reporteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BtnGp_estado;
    private javax.swing.ButtonGroup BtnGp_tipo;
    private javax.swing.JLabel Btn_ayuda;
    private javax.swing.JLabel Btn_buscar;
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
    private javax.swing.JComboBox<String> Cbx_EHora;
    private javax.swing.JComboBox<String> Cbx_EJornada;
    private javax.swing.JComboBox<String> Cbx_SHora;
    private javax.swing.JComboBox<String> Cbx_SJornada;
    private javax.swing.JLabel Lbl_codigoNombre;
    private javax.swing.JLabel Lbl_descripcion;
    private javax.swing.JLabel Lbl_estado;
    private javax.swing.JLabel Lbl_id;
    private javax.swing.JLabel Lbl_id1;
    private javax.swing.JLabel Lbl_id2;
    private javax.swing.JLabel Lbl_id3;
    private javax.swing.JLabel Lbl_id4;
    private javax.swing.JLabel Lbl_id5;
    private javax.swing.JLabel Lbl_id6;
    private javax.swing.JLabel Lbl_id7;
    private javax.swing.JPanel Pnl_datos;
    private javax.swing.JPanel Pnl_ingresoDatos;
    private javax.swing.JRadioButton Rdb_activo;
    private javax.swing.JRadioButton Rdb_inactivo;
    private javax.swing.JRadioButton Rdb_limpiar2;
    private javax.swing.JTable Tbl_Datos;
    private javax.swing.JTextField Txt_Id;
    private javax.swing.JTextField Txt_buscar;
    private javax.swing.JTextArea Txt_descripcion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator7;
    // End of variables declaration//GEN-END:variables
}
