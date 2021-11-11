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
public class Cotizacion_Venta {
    
String  no_serie;
String  no_serie1;

String codigo_cotizacion_encabezado;
String  codigo_cliente;
String codigo_cobrador;
String codigo_vendedor;
String fecha_emision;
String fecha_vencimiento; 
String impuesto_iva_encabezado;
String subtotal_encabezado;
String estatus_cotizacion  ;
String cantidad_servicio;
String precio_servicio;
String servicio;
String reservacion;

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

    public String getCodigo_cotizacion_encabezado() {
        return codigo_cotizacion_encabezado;
    }

    public void setCodigo_cotizacion_encabezado(String codigo_cotizacion_encabezado) {
        this.codigo_cotizacion_encabezado = codigo_cotizacion_encabezado;
    }

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getCodigo_cobrador() {
        return codigo_cobrador;
    }

    public void setCodigo_cobrador(String codigo_cobrador) {
        this.codigo_cobrador = codigo_cobrador;
    }

    public String getCodigo_vendedor() {
        return codigo_vendedor;
    }

    public void setCodigo_vendedor(String codigo_vendedor) {
        this.codigo_vendedor = codigo_vendedor;
    }

    public String getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(String fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getImpuesto_iva_encabezado() {
        return impuesto_iva_encabezado;
    }

    public void setImpuesto_iva_encabezado(String impuesto_iva_encabezado) {
        this.impuesto_iva_encabezado = impuesto_iva_encabezado;
    }

    public String getSubtotal_encabezado() {
        return subtotal_encabezado;
    }

    public void setSubtotal_encabezado(String subtotal_encabezado) {
        this.subtotal_encabezado = subtotal_encabezado;
    }

    public String getEstatus_cotizacion() {
        return estatus_cotizacion;
    }

    public void setEstatus_cotizacion(String estatus_cotizacion) {
        this.estatus_cotizacion = estatus_cotizacion;
    }

    public String getCantidad_servicio() {
        return cantidad_servicio;
    }

    public void setCantidad_servicio(String cantidad_servicio) {
        this.cantidad_servicio = cantidad_servicio;
    }

    public String getPrecio_servicio() {
        return precio_servicio;
    }

    public void setPrecio_servicio(String precio_servicio) {
        this.precio_servicio = precio_servicio;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getReservacion() {
        return reservacion;
    }

    public void setReservacion(String reservacion) {
        this.reservacion = reservacion;
    }

    @Override
    public String toString() {
        return "Cotizacion_Venta{" + "no_serie=" + no_serie + ", no_serie1=" + no_serie1 + ", codigo_cotizacion_encabezado=" + codigo_cotizacion_encabezado + ", codigo_cliente=" + codigo_cliente + ", codigo_cobrador=" + codigo_cobrador + ", codigo_vendedor=" + codigo_vendedor + ", fecha_emision=" + fecha_emision + ", fecha_vencimiento=" + fecha_vencimiento + ", impuesto_iva_encabezado=" + impuesto_iva_encabezado + ", subtotal_encabezado=" + subtotal_encabezado + ", estatus_cotizacion=" + estatus_cotizacion + ", cantidad_servicio=" + cantidad_servicio + ", precio_servicio=" + precio_servicio + ", servicio=" + servicio + ", reservacion=" + reservacion + '}';
    }

  
    
}
