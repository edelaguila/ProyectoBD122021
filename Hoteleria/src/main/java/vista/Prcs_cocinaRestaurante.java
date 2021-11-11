/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import datos.AsignacionIngredienteMenuDAO;
import datos.CocinaRestauranteDAO;
import datos.DetalleAsignacionOrdenDAO;
import datos.GuardarBitacora;
import datos.MenuDAO;
import dominio.AsignacionIngresienteMenu;
import dominio.CocinaRestaurante;
import dominio.DetalleOrdenRestaurante;
import dominio.Menu;
import dominio.ProcesosRepetidos;
import java.awt.Color;
import java.time.LocalDateTime;
import java.util.List;
import seguridad.vista.GenerarPermisos;
import seguridad.vista.Login_LD;

/**
 *
 * @author leone
 */
public class Prcs_cocinaRestaurante extends javax.swing.JInternalFrame {

    CocinaRestaurante cocina = new CocinaRestaurante();
    
    GuardarBitacora bitacora = new GuardarBitacora();
    
    void habilitarAcciones() {

        var codigoAplicacion = 2215;
        var usuario = Login_LD.usuario;

        Btn_guardar.setVisible(false);
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
        if (permisosApp[3].equals("1")) {
            Btn_eliminar.setVisible(true);
        }
    }
    
    /**
     * Creates new form Prcs_cocinaRestaurante
     */
    public Prcs_cocinaRestaurante() {
        initComponents();
        actualizarTablaPedidos();
        habilitarAcciones();
        actualizarCocina("");
        this.setTitle("Proceso de Cocina");
    }

    public void insertCocina() {
        LocalDateTime locaDate = LocalDateTime.now();
        CocinaRestauranteDAO dao = new CocinaRestauranteDAO();
        cocina.setHora(title);
        int horas = locaDate.getHour();
        int minutos = locaDate.getMinute();
        int segundos = locaDate.getSecond();
        String horaOrden = String.valueOf(horas + ":" + minutos + ":" + segundos);
        cocina.setHora(horaOrden);
        cocina.setOrden(Tbl_Pedidos.getValueAt(Tbl_Pedidos.getSelectedRow(), 0).toString());
        cocina.setMenu(Tbl_Pedidos.getValueAt(Tbl_Pedidos.getSelectedRow(), 2).toString());
        dao.insert(cocina);
    }

    public void actualizarTablaPedidos() {
        ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
        DetalleAsignacionOrdenDAO.codigoAuxiliar = "";
        DetalleAsignacionOrdenDAO.nombreAuxiliar = "";
        String columnas[] = {"CORRELATIVO", "ID PEDIDO", "ID COMIDA", "CANTIDAD"};
        int cantidadcolumnas = columnas.length;
        prcs_repetidos.llenarColumnas(columnas, cantidadcolumnas, Tbl_Pedidos);
        String datos[] = new String[cantidadcolumnas];
        int tamaño[] = {200, 200, 200, 200};
        DetalleAsignacionOrdenDAO restaurantedao = new DetalleAsignacionOrdenDAO();
        List<DetalleOrdenRestaurante> restaurante = restaurantedao.select();
        for (DetalleOrdenRestaurante listaServicio : restaurante) {
            if (listaServicio.getEstadoOrden().equals("0") && Integer.valueOf(listaServicio.getCantidadOrden()) > 0) {
                datos[0] = String.valueOf(listaServicio.getIdDetalle());
                datos[1] = String.valueOf(listaServicio.getIdEncabezado());
                datos[2] = String.valueOf(listaServicio.getIdMenu());
                datos[3] = String.valueOf(listaServicio.getCantidadOrden());
                prcs_repetidos.llenarFilas(datos, tamaño, Tbl_Pedidos);
            }
        }
    }

    public void actualizarCocina(String codigo) {
        ProcesosRepetidos prcs_repetidos = new ProcesosRepetidos();
        CocinaRestauranteDAO.codigoAuxiliar = codigo;
        String columnas[] = {"CORRELATIVO", "ID ORDEN", "ID MENU"};
        int cantidadcolumnas = columnas.length;
        prcs_repetidos.llenarColumnas(columnas, cantidadcolumnas, Tbl_Despachos);
        String datos[] = new String[cantidadcolumnas];
        int tamaño[] = {200, 200, 200};
        CocinaRestauranteDAO daococina = new CocinaRestauranteDAO();
        List<CocinaRestaurante> cocina = daococina.select();
        for (CocinaRestaurante listacocina : cocina) {
            datos[0] = String.valueOf(listacocina.getCorrelativo());
            datos[1] = String.valueOf(listacocina.getOrden());
            datos[2] = String.valueOf(listacocina.getMenu());
            prcs_repetidos.llenarFilas(datos, tamaño, Tbl_Despachos);
        }
    }

    public void debitarPlato() {
        int platos = 0;
        DetalleAsignacionOrdenDAO reservaciondao = new DetalleAsignacionOrdenDAO();
        DetalleOrdenRestaurante reservacion = new DetalleOrdenRestaurante();
        platos = Integer.valueOf(Tbl_Pedidos.getValueAt(Tbl_Pedidos.getSelectedRow(), 3).toString()) - 1;
        reservacion.setIdDetalle(Tbl_Pedidos.getValueAt(Tbl_Pedidos.getSelectedRow(), 0).toString());
        reservacion.setCantidadOrden(String.valueOf(platos));
        if (platos == 0) {
            reservacion.setEstadoOrden("1");
        } else {
            reservacion.setEstadoOrden("0");
        }
        reservaciondao.update2(reservacion);
    }

    public void debitarExistencias(String codigo) {
        float existencias = 0;
        AsignacionIngredienteMenuDAO.codigoAuxiliar = codigo;
        AsignacionIngredienteMenuDAO.nombreAuxiliar = codigo;
        AsignacionIngredienteMenuDAO restaurantedao = new AsignacionIngredienteMenuDAO();
        List<AsignacionIngresienteMenu> restaurante = restaurantedao.select();
        for (AsignacionIngresienteMenu listaServicio : restaurante) {
            if (listaServicio.getIdPlato().equals(codigo)) {
                CocinaRestauranteDAO cocinadao = new CocinaRestauranteDAO();
                cocina.setIngrediente(listaServicio.getIdProducto());
                cocina = cocinadao.query(cocina);
                float aux = Float.valueOf(listaServicio.getCantidadIngrediente());
                existencias = Integer.valueOf(CocinaRestauranteDAO.existenciasAux) - aux;
                cocina.setIngrediente(listaServicio.getIdProducto());
                cocina.setNuevaExistencia(String.valueOf(existencias));
                cocinadao.update(cocina);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pnl_ingresoDatos = new javax.swing.JPanel();
        Lbl_id = new javax.swing.JLabel();
        Txt_codigo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        Btn_fondoGuardar = new javax.swing.JPanel();
        Btn_guardar = new javax.swing.JLabel();
        Btn_fondo_eliminar = new javax.swing.JPanel();
        Btn_eliminar = new javax.swing.JLabel();
        Btn_fondo_reporte = new javax.swing.JPanel();
        Btn_reporte = new javax.swing.JLabel();
        Btn_fondo_ayuda = new javax.swing.JPanel();
        Btn_ayuda = new javax.swing.JLabel();
        Btn_fondo_cancelar = new javax.swing.JPanel();
        Btn_cancelar = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tbl_Despachos = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tbl_Pedidos = new javax.swing.JTable();
        Btn_fondoBuscar = new javax.swing.JPanel();
        Btn_buscar = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        Pnl_ingresoDatos.setBackground(new java.awt.Color(36, 47, 65));
        Pnl_ingresoDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INGRESO DE DATOS:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        Lbl_id.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Lbl_id.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_id.setText("Clasificar por:");

        Txt_codigo.setBackground(new java.awt.Color(36, 47, 65));
        Txt_codigo.setForeground(new java.awt.Color(255, 255, 255));
        Txt_codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Btn_fondoGuardar.setBackground(new java.awt.Color(97, 212, 195));
        Btn_fondoGuardar.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_fondoGuardar.setMinimumSize(new java.awt.Dimension(104, 40));

        Btn_guardar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_guardar.setText("Cocinar");
        Btn_guardar.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_guardar.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_guardar.setPreferredSize(new java.awt.Dimension(104, 40));
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
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(Btn_fondoGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Btn_guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        Btn_fondo_eliminar.setBackground(new java.awt.Color(97, 212, 195));
        Btn_fondo_eliminar.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_fondo_eliminar.setMinimumSize(new java.awt.Dimension(104, 40));

        Btn_eliminar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_eliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_eliminar.setText("Fallo Cocina");
        Btn_eliminar.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_eliminar.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_eliminar.setPreferredSize(new java.awt.Dimension(104, 40));
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

        Btn_fondo_reporte.setBackground(new java.awt.Color(97, 212, 195));
        Btn_fondo_reporte.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_fondo_reporte.setMinimumSize(new java.awt.Dimension(104, 40));

        Btn_reporte.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_reporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_reporte.setText("Reporte");
        Btn_reporte.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_reporte.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_reporte.setPreferredSize(new java.awt.Dimension(104, 40));
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
        Btn_fondo_ayuda.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_fondo_ayuda.setMinimumSize(new java.awt.Dimension(104, 40));

        Btn_ayuda.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_ayuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_ayuda.setText("Ayuda");
        Btn_ayuda.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_ayuda.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_ayuda.setPreferredSize(new java.awt.Dimension(104, 40));
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
        Btn_fondo_cancelar.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_fondo_cancelar.setMinimumSize(new java.awt.Dimension(104, 40));

        Btn_cancelar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        Btn_cancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Btn_cancelar.setText("Cancelar");
        Btn_cancelar.setMaximumSize(new java.awt.Dimension(104, 40));
        Btn_cancelar.setMinimumSize(new java.awt.Dimension(104, 40));
        Btn_cancelar.setPreferredSize(new java.awt.Dimension(104, 40));
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

        Tbl_Despachos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CORRELATIVO", "ID TARIFA", "ID SERVICIO"
            }
        ));
        jScrollPane3.setViewportView(Tbl_Despachos);

        Tbl_Pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "SERVICIO", "PRECIO"
            }
        ));
        jScrollPane4.setViewportView(Tbl_Pedidos);

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

        javax.swing.GroupLayout Pnl_ingresoDatosLayout = new javax.swing.GroupLayout(Pnl_ingresoDatos);
        Pnl_ingresoDatos.setLayout(Pnl_ingresoDatosLayout);
        Pnl_ingresoDatosLayout.setHorizontalGroup(
            Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addComponent(Lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(Txt_codigo))))
                .addGap(18, 18, 18)
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btn_fondoGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_fondo_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_fondo_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_fondo_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_fondo_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addComponent(Btn_fondoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        Pnl_ingresoDatosLayout.setVerticalGroup(
            Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Btn_fondoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Lbl_id))
                                .addGap(3, 3, 3)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(Pnl_ingresoDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addContainerGap())
                    .addGroup(Pnl_ingresoDatosLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(Btn_fondoGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_fondo_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_fondo_ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_fondo_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_fondo_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Pnl_ingresoDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pnl_ingresoDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseClicked
        boolean duplicada = true;
        int filaSeleccionada = Tbl_Pedidos.getSelectedRow();
        if (filaSeleccionada >= 0) {
            debitarExistencias(Tbl_Pedidos.getValueAt(Tbl_Pedidos.getSelectedRow(), 2).toString());
            debitarPlato();
            insertCocina();
            actualizarCocina("");
            actualizarTablaPedidos();
            bitacora.GuardarEnBitacora("insertar", "2215");
        }
    }//GEN-LAST:event_Btn_guardarMouseClicked

    private void Btn_guardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseEntered
        Btn_fondoGuardar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_guardarMouseEntered

    private void Btn_guardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseExited
        Btn_fondoGuardar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_guardarMouseExited

    private void Btn_eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseClicked
        boolean duplicada = true;
        int filaSeleccionada = Tbl_Despachos.getSelectedRow();
        if (filaSeleccionada >= 0) {

            DetalleAsignacionOrdenDAO restaurantedao = new DetalleAsignacionOrdenDAO();
            List<DetalleOrdenRestaurante> restaurante = restaurantedao.select();
            for (DetalleOrdenRestaurante listaServicio : restaurante) {
                int platos = 0;
                if (listaServicio.getIdDetalle().equals(Tbl_Despachos.getValueAt(Tbl_Despachos.getSelectedRow(), 1).toString())) {
                    DetalleOrdenRestaurante reservacion = new DetalleOrdenRestaurante();
                    reservacion.setIdDetalle(Tbl_Despachos.getValueAt(Tbl_Despachos.getSelectedRow(), 1).toString());
                    platos = Integer.valueOf(listaServicio.getCantidadOrden()) + 1;
                    reservacion.setCantidadOrden(String.valueOf(platos));
                    reservacion.setEstadoOrden("0");
                    restaurantedao.update2(reservacion);
                    bitacora.GuardarEnBitacora("fallo cocina", "2215");
                }
            }
            actualizarCocina("");
            actualizarTablaPedidos();
        }
    }//GEN-LAST:event_Btn_eliminarMouseClicked

    private void Btn_eliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseEntered
        Btn_fondo_eliminar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_eliminarMouseEntered

    private void Btn_eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseExited
        Btn_fondo_eliminar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_eliminarMouseExited

    private void Btn_reporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseClicked
bitacora.GuardarEnBitacora("reporte", "2215");
    }//GEN-LAST:event_Btn_reporteMouseClicked

    private void Btn_reporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseEntered
        Btn_fondo_reporte.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_reporteMouseEntered

    private void Btn_reporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporteMouseExited
        Btn_fondo_reporte.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_reporteMouseExited

    private void Btn_ayudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseClicked
bitacora.GuardarEnBitacora("ayuda", "2215");
    }//GEN-LAST:event_Btn_ayudaMouseClicked

    private void Btn_ayudaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseEntered
        Btn_fondo_ayuda.setBackground(new Color(255, 255, 63));
    }//GEN-LAST:event_Btn_ayudaMouseEntered

    private void Btn_ayudaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ayudaMouseExited
        Btn_fondo_ayuda.setBackground(new Color(253, 255, 182));
    }//GEN-LAST:event_Btn_ayudaMouseExited

    private void Btn_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseClicked
Txt_codigo.setText("");
    }//GEN-LAST:event_Btn_cancelarMouseClicked

    private void Btn_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseEntered
        Btn_fondo_cancelar.setBackground(new Color(255, 52, 31));
    }//GEN-LAST:event_Btn_cancelarMouseEntered

    private void Btn_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cancelarMouseExited
        Btn_fondo_cancelar.setBackground(new Color(255, 128, 115));
    }//GEN-LAST:event_Btn_cancelarMouseExited

    private void Btn_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseClicked
actualizarCocina(Txt_codigo.getText());
    }//GEN-LAST:event_Btn_buscarMouseClicked

    private void Btn_buscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseEntered
        Btn_fondoBuscar.setBackground(new Color(114, 243, 227));
    }//GEN-LAST:event_Btn_buscarMouseEntered

    private void Btn_buscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseExited
        Btn_fondoBuscar.setBackground(new Color(97, 212, 195));
    }//GEN-LAST:event_Btn_buscarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Btn_ayuda;
    private javax.swing.JLabel Btn_buscar;
    private javax.swing.JLabel Btn_cancelar;
    private javax.swing.JLabel Btn_eliminar;
    private javax.swing.JPanel Btn_fondoBuscar;
    private javax.swing.JPanel Btn_fondoGuardar;
    private javax.swing.JPanel Btn_fondo_ayuda;
    private javax.swing.JPanel Btn_fondo_cancelar;
    private javax.swing.JPanel Btn_fondo_eliminar;
    private javax.swing.JPanel Btn_fondo_reporte;
    private javax.swing.JLabel Btn_guardar;
    private javax.swing.JLabel Btn_reporte;
    private javax.swing.JLabel Lbl_id;
    private javax.swing.JPanel Pnl_ingresoDatos;
    private javax.swing.JTable Tbl_Despachos;
    private javax.swing.JTable Tbl_Pedidos;
    private javax.swing.JTextField Txt_codigo;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
