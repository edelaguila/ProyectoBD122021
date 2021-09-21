
package dominio;

/**
 *
 * @author Jefferson Dávila
 */
public class Piso {
    private int idPiso, cantidadHabitacionesPiso;
    private String estadoPiso, descripcionPiso;

    public int getIdPiso() {
        return idPiso;
    }

    public void setIdPiso(int idPiso) {
        this.idPiso = idPiso;
    }

    public int getCantidadHabitacionesPiso() {
        return cantidadHabitacionesPiso;
    }

    public void setCantidadHabitacionesPiso(int cantidadHabitacionesPiso) {
        this.cantidadHabitacionesPiso = cantidadHabitacionesPiso;
    }

    public String getDescripcionPiso() {
        return descripcionPiso;
    }

    public void setDescripcionPiso(String descripcionPiso) {
        this.descripcionPiso = descripcionPiso;
    }

    public String getEstadoPiso() {
        return estadoPiso;
    }

    public void setEstadoPiso(String estadoPiso) {
        this.estadoPiso = estadoPiso;
    }
}
