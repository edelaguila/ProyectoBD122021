
package dominio;

/**
 *
 * @author JEFF
 */
public class Impuesto {
    private int idImpuesto, estadoImpuesto;
    private float valorImpuesto;
    private String nombreImpuesto, descripcionImpuesto;

    public int getIdImpuesto() {
        return idImpuesto;
    }

    public void setIdImpuesto(int idImpuesto) {
        this.idImpuesto = idImpuesto;
    }

    public int getEstadoImpuesto() {
        return estadoImpuesto;
    }

    public void setEstadoImpuesto(int estadoImpuesto) {
        this.estadoImpuesto = estadoImpuesto;
    }

    public float getValorImpuesto() {
        return valorImpuesto;
    }

    public void setValorImpuesto(float valorImpuesto) {
        this.valorImpuesto = valorImpuesto;
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
}
