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
public class Control_pago_Venta {
    
String  no_serie;
String  no_serie1;
String  precio;
String  fecha;
String  estatus;
String  servicio;
String  precio_cambio;

    public String getNo_serie() {
        return no_serie;
    }

    public void setNo_serie(String no_serie) {
        this.no_serie = no_serie;
    }

    public String getNo_serie1() {
        return no_serie1;
    }

    public void setNo_serie1(String no_serie1) {
        this.no_serie1 = no_serie1;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getPrecio_cambio() {
        return precio_cambio;
    }

    public void setPrecio_cambio(String precio_cambio) {
        this.precio_cambio = precio_cambio;
    }
    @Override
    public String toString() {
        return "Control_pago_Venta{" + "no_serie=" + no_serie + ", no_serie1=" + no_serie1 + ", precio=" + precio + ", fecha=" + fecha + ", estatus=" + estatus + ", servicio=" + servicio + ", precio_cambio=" + precio_cambio + '}';
    }






    
    
}
