package vista;

import datos.AsignacionIngredienteMenuDAO;
import datos.GuardarBitacora;
import dominio.ProcesosRepetidos;
import dominio.AsignacionIngresienteMenu;
import java.awt.Color;
import java.util.List;
import javax.swing.ImageIcon;
import seguridad.vista.GenerarPermisos;
import seguridad.vista.Login_LD;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeff
 */
public class Prcs_IngredienteMenu extends javax.swing.JInternalFrame {

    ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
    AsignacionIngredienteMenuDAO restauranteDAO = new AsignacionIngredienteMenuDAO();
    AsignacionIngresienteMenu restaurante = new AsignacionIngresienteMenu();
    ButtonGroup grupoDeRadios;
    GuardarBitacora bitacora = new GuardarBitacora();

    void habilitarAcciones() {

        var codigoAplicacion = 2212;
        var usuario = Login_LD.usuario;

        Btn_guardar.setVisible(false);
        Btn_modificar.setVisible(false);
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
    }

    public Prcs_IngredienteMenu() {
        initComponents();
        diseño();
        actualizarTabla("");
        ID_Encabezado.setVisible(false);
        habilitarAcciones();
    }

    public void diseño() {
        this.setTitle("Ingredientes del menú");
        Txt_Producto.setBorder(null);
        Txt_buscar.setBorder(null);
        Txt_Menu.setBorder(null);
        Txt_Cantidad.setBorder(null);
        prcs_repetidos.Cursor(Btn_ayuda, Btn_cancelar, Btn_guardar, Btn_modificar, Btn_reporte, Btn_buscar, Btn_catalogo, Btn_producto);
        ImageIcon icono = new ImageIcon("src/main/java/assets/menu.png");
        this.setFrameIcon(icono);
    }

    public void actualizarTabla(String codigo) {
        ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
        AsignacionIngredienteMenuDAO.codigoAuxiliar = codigo;
        AsignacionIngredienteMenuDAO.nombreAuxiliar = codigo;
        String columnas[] = {"ID", "ID MENU", "ID PRODUCTO", "CANTIDAD DEL PRODUCTO"};
        int cantidadcolumnas = columnas.length;
        prcs_repetidos.llenarColumnas(columnas, cantidadcolumnas, Tbl_Datos);
        String datos[] = new String[cantidadcolumnas];
        int tamaño[] = {50, 70, 70, 200};
        AsignacionIngredienteMenuDAO restaurantedao = new AsignacionIngredienteMenuDAO();
        List<AsignacionIngresienteMenu> restaurante = restaurantedao.select();
        for (AsignacionIngresienteMenu listaServicio : restaurante) {
            datos[0] = String.valueOf(listaServicio.getIdCorrelativo());
            datos[1] = String.valueOf(listaServicio.getIdPlato());
            datos[2] = String.valueOf(listaServicio.getIdProducto());
            datos[3] = String.valueOf(listaServicio.getCantidadIngrediente());
            prcs_repetidos.llenarFilas(datos, tamaño, Tbl_Datos);
        }
    }

    public void Limpiar() {
        prcs_repetidos.Limpiar(Txt_buscar, Txt_Producto, Txt_Menu, Txt_Cantidad);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnGp_tipo = new javax.swing.ButtonGroup();
        BtnGp_estado = new javax.swing.ButtonGroup();
        Pnl_ingresoDatos = new javax.swing.JPanel();
        Btn_fondoGuardar = new javax.swing.JPanel();
        Btn_guardar = new javax.swing.JLabel();
        Btn_fondo_modificar = new javax.swing.JPanel();
        Btn_modificar = new javax.swing.JLabel();
        Btn_fondo_reporte = new javax.swing.JPanel();
        Btn_reporte = new javax.swing.JLabel();
        Btn_fondo_ayuda = new javax.swing.JPanel();
        Btn_ayuda = new javax.swing.JLabel();
        Btn_fondo_cancelar = new javax.swing.JPanel();
        Btn_cancelar = new javax.swing.JLabel();
        Lbl_mesa = new javax.swing.JLabel();
        Txt_Producto = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        Lbl_nombre3 = new javax.swing.JLabel();
        ID_Encabezado = new javax.swing.JLabel();
        Btn_fondo_reporte1 = new javax.swing.JPanel();
        Btn_catalogo = new javax.swing.JLabel();
        Txt_Menu = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        Lbl_nombre4 = new javax.swing.JLabel();
        Txt_Cantidad = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        Btn_fondo_reporte2 = new javax.swing.JPanel();
        Btn_producto = new javax.swing.JLabel();
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

        Btn_fondo_modificar.setBackground(new java.awt.Color(97, 212, 195));

        Btn_modificar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_modificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_modificar.setText("Eliminar");
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
            .addComponent(Btn_modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Btn_fondo_modificarLayout.setVerticalGroup(
            Btn_fondo_modificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(Btn_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        Btn_fondo_reporteLayout.setVerticalGroup(
            Btn_fondo_reporteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_reporte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(Btn_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
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
            .addComponent(Btn_cancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        Lbl_mesa.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_mesa.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_mesa.setText("NO. PRODUCTO:");

        Txt_Producto.setBackground(new java.awt.Color(36, 47, 65));
        Txt_Producto.setForeground(new java.awt.Color(255, 255, 255));
        Txt_Producto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_ProductoActionPerformed(evt);
            }
        });

        Lbl_nombre3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_nombre3.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_nombre3.setText("NO. MENU:");

        Btn_fondo_reporte1.setBackground(new java.awt.Color(97, 212, 195));

        Btn_catalogo.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_catalogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_catalogo.setText("MENÚ");
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
            .addComponent(Btn_catalogo, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        Btn_fondo_reporte1Layout.setVerticalGroup(
            Btn_fondo_reporte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_catalogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        Txt_Menu.setBackground(new java.awt.Color(36, 47, 65));
        Txt_Menu.setForeground(new java.awt.Color(255, 255, 255));
        Txt_Menu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_MenuActionPerformed(evt);
            }
        });

        Lbl_nombre4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_nombre4.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_nombre4.setText("CANTIDAD PRODUCTO:");

        Txt_Cantidad.setBackground(new java.awt.Color(36, 47, 65));
        Txt_Cantidad.setForeground(new java.awt.Color(255, 255, 255));
        Txt_Cantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Txt_Cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_CantidadActionPerformed(evt);
            }
        });

        Btn_fondo_reporte2.setBackground(new java.awt.Color(97, 212, 195));

        Btn_producto.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_producto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_producto.setText("PRODUCTO");
        Btn_producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_productoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_productoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_productoMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Btn_fondo_reporte2Layout = new javax.swing.GroupLayout(Btn_fondo_reporte2);
        Btn_fondo_reporte2.setLayout(Btn_fondo_reporte2Layout);
        Btn_fondo_reporte2Layout.setHorizontalGroup(
            Btn_fondo_reporte2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_producto, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        Btn_fondo_reporte2Layout.setVerticalGroup(
            Btn_fondo_reporte2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Btn_producto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Pnl_ingresoDatosLayout = new javax.swing.GroupLayout(Pnl_ingresoDatos);
        Pnl_ingresoDatos.setLayout(Pnl_ingresoDatosLayout);
        Pnl_ingresoDatosLayout.setHorizontalGroup(
            Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator5)
                                    .addComponent(Txt_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)))
                            .addComponent(ID_Encabezado)
                            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Btn_fondo_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Btn_fondoGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(15, 15, 15)
                                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Btn_fondo_ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Btn_fondo_modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(Btn_fondo_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lbl_mesa)
                            .addComponent(Lbl_nombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lbl_nombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Txt_Producto)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(Btn_fondo_reporte1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator6)
                            .addComponent(Txt_Cantidad)
                            .addComponent(Btn_fondo_reporte2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Pnl_ingresoDatosLayout.setVerticalGroup(
            Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_nombre3))
                .addGap(2, 2, 2)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_fondo_reporte1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ID_Encabezado)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lbl_mesa))
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Btn_fondo_reporte2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txt_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Lbl_nombre4))
                .addGap(2, 2, 2)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_fondo_reporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_fondo_ayuda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btn_fondo_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_fondoGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
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

    private void Btn_modificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_modificarMouseEntered
        Btn_fondo_modificar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_modificarMouseEntered

    private void Btn_guardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseExited
        Btn_fondoGuardar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_guardarMouseExited

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

        if (prcs_repetidos.isNoneEmpty(Txt_Menu, Txt_Producto, Txt_Cantidad)) {
            if (prcs_repetidos.isNumeric(Txt_Menu.getText(), Txt_Producto.getText(), Txt_Cantidad.getText())) {

                restaurante.setIdPlato(Txt_Menu.getText());
                restaurante.setIdProducto(Txt_Producto.getText());
                restaurante.setCantidadIngrediente(Txt_Cantidad.getText());

                restauranteDAO.insert(restaurante);
                actualizarTabla("");
                prcs_repetidos.AlertaMensaje("registrados", "Ingredientes", "exitosamente");
                Limpiar();
                bitacora.GuardarEnBitacora("Guardar", "2212");
            } else {
            }
        }

    }//GEN-LAST:event_Btn_guardarMouseClicked

    private void Btn_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_modificarMouseClicked
        restaurante.setIdCorrelativo(ID_Encabezado.getText());
        restauranteDAO.delete(restaurante);
        actualizarTabla("");
        prcs_repetidos.AlertaMensaje("eliminado", "Ingrediente", "exitosamente");
        Limpiar();
        bitacora.GuardarEnBitacora("Modificar", "2212");
    }//GEN-LAST:event_Btn_modificarMouseClicked

    private void Tbl_DatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tbl_DatosMouseClicked
        if (evt.getClickCount() == 2) {
            ID_Encabezado.setText(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 0).toString());
            Txt_Menu.setText(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 1).toString());
            Txt_Producto.setText(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 2).toString());
            Txt_Cantidad.setText(Tbl_Datos.getValueAt(Tbl_Datos.getSelectedRow(), 3).toString());
            bitacora.GuardarEnBitacora("Buscar", "2212");
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

    private void Txt_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_ProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_ProductoActionPerformed

    private void Btn_catalogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_catalogoMouseClicked
        Prcs_MenuOrden abrir = new Prcs_MenuOrden();
        abrir.setVisible(true);
    }//GEN-LAST:event_Btn_catalogoMouseClicked

    private void Btn_catalogoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_catalogoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_catalogoMouseEntered

    private void Btn_catalogoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_catalogoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_catalogoMouseExited

    private void Txt_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_MenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_MenuActionPerformed

    private void Txt_CantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_CantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_CantidadActionPerformed

    private void Btn_productoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_productoMouseClicked
        Prcs_ProductoMenu abrir = new Prcs_ProductoMenu();
        abrir.setVisible(true);
    }//GEN-LAST:event_Btn_productoMouseClicked

    private void Btn_productoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_productoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_productoMouseEntered

    private void Btn_productoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_productoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_productoMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BtnGp_estado;
    private javax.swing.ButtonGroup BtnGp_tipo;
    private javax.swing.JLabel Btn_ayuda;
    private javax.swing.JLabel Btn_buscar;
    private javax.swing.JLabel Btn_cancelar;
    private javax.swing.JLabel Btn_catalogo;
    private javax.swing.JPanel Btn_fondoGuardar;
    private javax.swing.JPanel Btn_fondo_ayuda;
    private javax.swing.JPanel Btn_fondo_buscar;
    private javax.swing.JPanel Btn_fondo_cancelar;
    private javax.swing.JPanel Btn_fondo_modificar;
    private javax.swing.JPanel Btn_fondo_reporte;
    private javax.swing.JPanel Btn_fondo_reporte1;
    private javax.swing.JPanel Btn_fondo_reporte2;
    private javax.swing.JLabel Btn_guardar;
    private javax.swing.JLabel Btn_modificar;
    private javax.swing.JLabel Btn_producto;
    private javax.swing.JLabel Btn_reporte;
    private javax.swing.JLabel ID_Encabezado;
    private javax.swing.JLabel Lbl_codigoNombre;
    private javax.swing.JLabel Lbl_mesa;
    private javax.swing.JLabel Lbl_nombre3;
    private javax.swing.JLabel Lbl_nombre4;
    private javax.swing.JPanel Pnl_datos;
    private javax.swing.JPanel Pnl_ingresoDatos;
    private javax.swing.JTable Tbl_Datos;
    private javax.swing.JTextField Txt_Cantidad;
    private javax.swing.JTextField Txt_Menu;
    private javax.swing.JTextField Txt_Producto;
    private javax.swing.JTextField Txt_buscar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    // End of variables declaration//GEN-END:variables
}
