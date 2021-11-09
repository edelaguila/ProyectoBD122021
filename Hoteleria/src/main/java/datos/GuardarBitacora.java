package datos;

import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import seguridad.datos.BitacoraDao;
import seguridad.dominio.Bitacora;
import seguridad.vista.Aplicacion_Perfil;
import seguridad.vista.Login_LD;
import vista.Hoteleria_MDI;

/**
 *
 * @author Leonel
 */
public class GuardarBitacora {

    public void GuardarEnBitacora(String accion, String codigoModulo) {
        BitacoraDao BitacoraDAO = new BitacoraDao();
        Bitacora AInsertar = new Bitacora();
        boolean estado = false;
        AInsertar.setId_Usuario(Login_LD.usuario);
        AInsertar.setAccion(accion);
        AInsertar.setCodigoAplicacion(codigoModulo);
        AInsertar.setModulo("2000");
        estado = true;

        if (estado == true) {
            try {
                BitacoraDAO.insert(AInsertar);
            } catch (UnknownHostException ex) {
                Logger.getLogger(Aplicacion_Perfil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
