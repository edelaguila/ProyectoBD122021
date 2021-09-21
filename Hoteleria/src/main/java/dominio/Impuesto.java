
package dominio;

/**
 *
 * @author JEFF
 */
public class Impuesto {
    private String idImpuesto, nombreImpuesto, descripcionImpuesto, estadoImpuesto, valorImpuesto;

    public String getValorImpuesto() {
        return valorImpuesto;
    }

    public void setValorImpuesto(String valorImpuesto) {
        this.valorImpuesto = valorImpuesto;
    }

    public String getIdImpuesto() {
        return idImpuesto;
    }

    public void setIdImpuesto(String idImpuesto) {
        this.idImpuesto = idImpuesto;
    }

    public String getNombreImpuesto() {
        return nombreImpuesto;
    }

    public void setNombreImpuesto(String nombreImpuesto) {
        this.nombreImpuesto = nombreImpuesto;
    }

    public String getDescripcionImpuesto() {
        return descripcionImpuesto;
    }

    public void setDescripcionImpuesto(String descripcionImpuesto) {
        this.descripcionImpuesto = descripcionImpuesto;
    }

    public String getEstadoImpuesto() {
        return estadoImpuesto;
    }

    public void setEstadoImpuesto(String estadoImpuesto) {
        this.estadoImpuesto = estadoImpuesto;
    } 
}
