/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.dominio;

/**
 *
 * @author PERSONAL
 */
public class Join_venta {
    String reservacion;
    String reservacion_fecha;
    String servicio;
    String  precio_servicio;
    String menu;
    String fecha_orden;
    String tariafa;
    String orden;
    String nombre;

    public String getReservacion() {
        return reservacion;
    }

    public void setReservacion(String reservacion) {
        this.reservacion = reservacion;
    }

    public String getReservacion_fecha() {
        return reservacion_fecha;
    }

    public void setReservacion_fecha(String reservacion_fecha) {
        this.reservacion_fecha = reservacion_fecha;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getPrecio_servicio() {
        return precio_servicio;
    }

    public void setPrecio_servicio(String precio_servicio) {
        this.precio_servicio = precio_servicio;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getFecha_orden() {
        return fecha_orden;
    }

    public void setFecha_orden(String fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    public String getTariafa() {
        return tariafa;
    }

    public void setTariafa(String tariafa) {
        this.tariafa = tariafa;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Join{" + "reservacion=" + reservacion + ", reservacion_fecha=" + reservacion_fecha + ", servicio=" + servicio + ", precio_servicio=" + precio_servicio + ", menu=" + menu + ", fecha_orden=" + fecha_orden + ", tariafa=" + tariafa + ", orden=" + orden + ", nombre=" + nombre + '}';
    }
    
    
    
}
