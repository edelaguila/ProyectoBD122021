
package dominio;

/**
 *
 * @author JEFF
 */
public class AsignacionGobernanta {
    private String idAsignacionGobernanta, idGobernanta, estadoAsignacionGobernanta;
    private String idAmaDeLlave, nombreAmaDeLlave;

    public String getEstadoAsignacionGobernanta() {
        return estadoAsignacionGobernanta;
    }

    public void setEstadoAsignacionGobernanta(String estadoAsignacionGobernanta) {
        this.estadoAsignacionGobernanta = estadoAsignacionGobernanta;
    }

    public String getIdAsignacionGobernanta() {
        return idAsignacionGobernanta;
    }

    public void setIdAsignacionGobernanta(String idAsignacionGobernanta) {
        this.idAsignacionGobernanta = idAsignacionGobernanta;
    }

    public String getIdGobernanta() {
        return idGobernanta;
    }

    public void setIdGobernanta(String idGobernanta) {
        this.idGobernanta = idGobernanta;
    }

    public String getIdAmaDeLlave() {
        return idAmaDeLlave;
    }

    public void setIdAmaDeLlave(String idAmaDeLlave) {
        this.idAmaDeLlave = idAmaDeLlave;
    }
    
    public String getNombreAmaDeLlave() {
        return nombreAmaDeLlave;
    }

    public void setNombreAmaDeLlave(String nombreAmaDeLlave) {
        this.nombreAmaDeLlave = nombreAmaDeLlave;
    }
    
}
