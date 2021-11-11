/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.dominio;

/**
 *
 * @author SipaqueRitaMaria
 */
public class BalanceSaldosProveedores1 {
       int PK_codigo_proveedor;
 String Codigo_documento;
String transaccion;
String codigo_proveedor;
 String fecha_emision;
String fecha_atraso;

 String Diasvencidos;
 String total_detalle;

    public int getPK_codigo_proveedor() {
        return PK_codigo_proveedor;
    }

    public void setPK_codigo_proveedor(int PK_codigo_proveedor) {
        this.PK_codigo_proveedor = PK_codigo_proveedor;
    }

    public String getCodigo_documento() {
        return Codigo_documento;
    }

    public void setCodigo_documento(String Codigo_documento) {
        this.Codigo_documento = Codigo_documento;
    }

    public String getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }

    public String getCodigo_proveedor() {
        return codigo_proveedor;
    }

    public void setCodigo_proveedor(String codigo_proveedor) {
        this.codigo_proveedor = codigo_proveedor;
    }

    public String getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(String fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getFecha_atraso() {
        return fecha_atraso;
    }

    public void setFecha_atraso(String fecha_atraso) {
        this.fecha_atraso = fecha_atraso;
    }

    public String getDiasvencidos() {
        return Diasvencidos;
    }

    public void setDiasvencidos(String Diasvencidos) {
        this.Diasvencidos = Diasvencidos;
    }

    public String getTotal_detalle() {
        return total_detalle;
    }

    public void setTotal_detalle(String total_detalle) {
        this.total_detalle = total_detalle;
    }
 
}
