package seguridad.vista;

import seguridad.dominio.Permisos;
import vista.Hoteleria_MDI;

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
            
            if (modulo == "Hotelero") {
                
                Hoteleria_MDI.Mnb_menu.setVisible(true);
                Hoteleria_MDI.Sbm_archivos.setVisible(true);
                Hoteleria_MDI.Sbm_ayuda.setVisible(true);
                Hoteleria_MDI.Sbm_catalogo.setVisible(true);
                Hoteleria_MDI.Sbm_herramientas.setVisible(true);
                Hoteleria_MDI.Sbm_procesos.setVisible(true);
                Hoteleria_MDI.Btn_cerrarSesion.setVisible(true);
                
                Hoteleria_MDI.Mnu_mantenimientos.setVisible(false);
                Hoteleria_MDI.Mnu_procesos.setVisible(false);
                
                Hoteleria_MDI.MnI_habitaciones.setVisible(false);
                Hoteleria_MDI.MnI_horario.setVisible(false);
                Hoteleria_MDI.MnI_huespedes.setVisible(false);
                Hoteleria_MDI.MnI_menu.setVisible(false);
                Hoteleria_MDI.MnI_piso.setVisible(false);
                Hoteleria_MDI.MnI_servicios.setVisible(false);
                Hoteleria_MDI.MnI_tarifas.setVisible(false);
                
                Hoteleria_MDI.MnI_asingacionServiciosHabitacion.setVisible(false);
                Hoteleria_MDI.MnI_RegistroObjetoPerdido.setVisible(false);
                Hoteleria_MDI.MnI_CheckIn.setVisible(false);
                Hoteleria_MDI.MnI_CheckOut.setVisible(false);
                Hoteleria_MDI.MnI_ObjetosPerdidosE.setVisible(false);
                Hoteleria_MDI.MnI_serviciosExtras.setVisible(false);
                Hoteleria_MDI.MnI_reservacion.setVisible(false);
                Hoteleria_MDI.MnI_reservacionDetalle.setVisible(false);
                Hoteleria_MDI.MnI_Viaje.setVisible(false);
                Hoteleria_MDI.MnI_Cocina.setVisible(false);
                
                ejecutarPermisos.ejecutarBusqueda(usuario);
                for (int i = 0; i < ejecutarPermisos.getAplicaciones().length; i++) {
                    int varApp = Integer.parseInt(ejecutarPermisos.getAplicaciones()[i]);
                    if (varApp >= 2001 && varApp <= 2200) {
                                Hoteleria_MDI.Mnu_mantenimientos.setVisible(true);
                        switch (varApp) {
                            case 2001:Hoteleria_MDI.MnI_habitaciones.setVisible(true);break;
                            case 2002:Hoteleria_MDI.MnI_horario.setVisible(true);break;
                            case 2003:Hoteleria_MDI.MnI_huespedes.setVisible(true);break;
                            case 2004:Hoteleria_MDI.MnI_piso.setVisible(true);break;
                            case 2005:Hoteleria_MDI.MnI_servicios.setVisible(true);break;
                            case 2006:Hoteleria_MDI.MnI_menu.setVisible(true);break;
                            case 2007:Hoteleria_MDI.MnI_tarifas.setVisible(true);break;
                        }
                    }
                }
                for (int i = 0; i < ejecutarPermisos.getAplicaciones().length; i++) {
                    int varApp = Integer.parseInt(ejecutarPermisos.getAplicaciones()[i]);
                    if (varApp >= 2201 && varApp <= 2500) {
                                Hoteleria_MDI.Mnu_procesos.setVisible(true);
                        switch (varApp) {
                            case 2201:Hoteleria_MDI.MnI_asingacionServiciosHabitacion.setVisible(true);break;
                            case 2202:Hoteleria_MDI.MnI_RegistroObjetoPerdido.setVisible(true);break;
                            case 2203:Hoteleria_MDI.MnI_ObjetosPerdidosE.setVisible(true);break;
                            case 2204:Hoteleria_MDI.MnI_CheckIn.setVisible(true);break;
                            case 2205:Hoteleria_MDI.MnI_CheckOut.setVisible(true);break;
                            case 2206:Hoteleria_MDI.MnI_serviciosExtras.setVisible(true);break;                         
                            case 2207:Hoteleria_MDI.MnI_reservacion.setVisible(true);Hoteleria_MDI.MnI_reservacionDetalle.setVisible(true);break;
                            case 2208:Hoteleria_MDI.MnI_Gobernanta.setVisible(true);break;
                            case 2209:Hoteleria_MDI.MnI_Limpieza.setVisible(true);break;
                            case 2210:Hoteleria_MDI.MnI_ConsultaLimpieza.setVisible(true);break;
                            case 2211:Hoteleria_MDI.MnI_SupervisiónLimpieza.setVisible(true);break;
                            case 2212:Hoteleria_MDI.MnI_Ingrediente.setVisible(true);break;
                            case 2213:Hoteleria_MDI.MnI_InicioOrden.setVisible(true);break;
                            case 2214:Hoteleria_MDI.MnI_EfectuarOrden.setVisible(true);break;
                            case 2215:Hoteleria_MDI.MnI_Cocina.setVisible(true);break;
                            case 2222:Hoteleria_MDI.MnI_Viaje.setVisible(true);break;
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
