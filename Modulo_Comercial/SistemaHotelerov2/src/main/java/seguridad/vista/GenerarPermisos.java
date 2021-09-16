package seguridad.vista;


import Comercial.vista.*;
import java.net.UnknownHostException;
import seguridad.dominio.Permisos;

/**
 *
 * @author Diego Vásquez
 */
public class GenerarPermisos {

    Permisos ejecutarPermisos = new Permisos();

    public void getPermisos(String modulo, String usuario) {
        try {
            if (modulo == "Seguridad") {

                MDI_Sistema.JMenu_Mantenimientos.setVisible(false);
                MDI_Sistema.JMenuItem_Usuarios.setVisible(false);
                MDI_Sistema.JMenuItem_Aplicaciones.setVisible(false);
                MDI_Sistema.JMenu_Asignaciones.setVisible(false);
                MDI_Sistema.JMenuItem_Perfiles.setVisible(false);
                MDI_Sistema.JMenuItem_Modulos.setVisible(false);
                MDI_Sistema.JMenuItem_AplicacionesUsuario.setVisible(false);
                MDI_Sistema.JMenuItem_Bitacora.setVisible(false);

                ejecutarPermisos.ejecutarBusqueda(usuario);

                for (int i = 0; i < ejecutarPermisos.getAplicaciones().length; i++) {
                    int varApp = Integer.parseInt(ejecutarPermisos.getAplicaciones()[i]);
                    if (varApp >= 10 && varApp <= 99) {
                        MDI_Sistema.JMenu_Mantenimientos.setVisible(true);
                        switch (varApp) {
                            case 10:
                                MDI_Sistema.JMenuItem_Usuarios.setVisible(true);
                                break;
                            case 20:
                                break;
                        }
                    }
                    if (varApp >= 100 && varApp <= 199) {
                        MDI_Sistema.JMenu_Asignaciones.setVisible(true);
                        switch (varApp) {
                            case 100:
                                break;
                            case 200:
                                break;
                        }
                    }

                }
            }
            
            if (modulo == "Comercial") {

                ejecutarPermisos.ejecutarBusqueda(usuario);
                MDIComercial.M_venta.setVisible(false);
                MDIComercial.M_compras.setVisible(false);
                MDIComercial.M_inventario.setVisible(false);
                MDIComercial.P_ventas.setVisible(true);
                MDIComercial.P_compras.setVisible(false);
                 MDIComercial.P_pedido_factura.setVisible(true);
                //   MDIComercial.ProcesoInventario.setVisible(false);
                for (int i = 0; i < ejecutarPermisos.getAplicaciones().length; i++) {
                    int varApp = Integer.parseInt(ejecutarPermisos.getAplicaciones()[i]);
                    if (varApp >= 3000 && varApp <= 3360) {
                        MDIComercial.M_venta.setVisible(true);
                        MDIComercial.M_compras.setVisible(true);
                        MDIComercial.M_inventario.setVisible(true);
                        MDIComercial.P_ventas.setVisible(true);
                        MDIComercial.P_compras.setVisible(true);
                        //    MDIComercial.ProcesoInventario.setVisible(true);
                        switch (varApp) {
                            case 3001:
                                MDIComercial.M_cliente.setVisible(true);
                                break;
                            case 3002:
                                MDIComercial.M_deudor.setVisible(true);
                                break;
                            case 3003:
                                MDIComercial.M_proveedor.setVisible(true);
                                break;
                            case 3004:
                                MDIComercial.M_producto1.setVisible(true);
                                break;
                            case 3005:
                                MDIComercial.P_pedido_factura.setVisible(true);
                                break;
                            case 3006:
                             
                                break;
                            case 3007:
                                MDIComercial.ProcesoCompra.setVisible(true);
                                break;
                            case 3008:
                                MDIComercial.FacturaCompras.setVisible(true);
                                break;

                            case 3009:
                                MDIComercial.P_producto.setVisible(true);
                                break;
                        }
                    }

                }

            }
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
    }

    public String[] getAccionesAplicacion(int codigoAplicacion, String usuario) {
        ejecutarPermisos.ejecutarBusqueda(usuario);
        String[] matrixPermisos = new String[5];
        for (int i = 0; i < 5; i++) {
            matrixPermisos[i] = ejecutarPermisos.getPermisosApps(codigoAplicacion)[i];
        }
        return matrixPermisos;
    }
}
