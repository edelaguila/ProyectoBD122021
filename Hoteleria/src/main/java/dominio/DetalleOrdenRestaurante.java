
package dominio;

/**
 *
 * @author JEFF
 */
public class DetalleOrdenRestaurante {
    String idDetalle, idEncabezado, idMenu, cantidadOrden, estadoOrden;

    public String getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(String idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getIdEncabezado() {
        return idEncabezado;
    }

    public void setIdEncabezado(String idEncabezado) {
        this.idEncabezado = idEncabezado;
    }

    public String getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu;
    }

    public String getCantidadOrden() {
        return cantidadOrden;
    }

    public void setCantidadOrden(String cantidadOrden) {
        this.cantidadOrden = cantidadOrden;
    }

    public String getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(String estadoOrden) {
        this.estadoOrden = estadoOrden;
    }
}
