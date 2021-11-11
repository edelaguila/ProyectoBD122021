/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.dominio;

/**
 *
 * @author Diana
 */
public class Existencia {
   
    String Pk_codigo_producto;
    String Pk_codigo_bodega;
    String cantidad_existencia;
    String fecha_entrada_existencia;
    String fecha_salida_existencia;
    String estatus_existencia;

    public String getPk_codigo_producto() {
        return Pk_codigo_producto;
    }

    public void setPk_codigo_producto(String Pk_codigo_producto) {
        this.Pk_codigo_producto = Pk_codigo_producto;
    }

    public String getPk_codigo_bodega() {
        return Pk_codigo_bodega;
    }

    public void setPk_codigo_bodega(String Pk_codigo_bodega) {
        this.Pk_codigo_bodega = Pk_codigo_bodega;
    }

    public String getCantidad_existencia() {
        return cantidad_existencia;
    }

    public void setCantidad_existencia(String cantidad_existencia) {
        this.cantidad_existencia = cantidad_existencia;
    }

    public String getFecha_entrada_existencia() {
        return fecha_entrada_existencia;
    }

    public void setFecha_entrada_existencia(String fecha_entrada_existencia) {
        this.fecha_entrada_existencia = fecha_entrada_existencia;
    }

    public String getFecha_salida_existencia() {
        return fecha_salida_existencia;
    }

    public void setFecha_salida_existencia(String fecha_salida_existencia) {
        this.fecha_salida_existencia = fecha_salida_existencia;
    }

    public String getEstatus_existencia() {
        return estatus_existencia;
    }

    public void setEstatus_existencia(String estatus_existencia) {
        this.estatus_existencia = estatus_existencia;
    }

    @Override
    public String toString() {
        return "Existencia{" + "Pk_codigo_producto=" + Pk_codigo_producto + ", Pk_codigo_bodega=" + Pk_codigo_bodega + ", cantidad_existencia=" + cantidad_existencia + ", fecha_entrada_existencia=" + fecha_entrada_existencia + ", fecha_salida_existencia=" + fecha_salida_existencia + ", estatus_existencia=" + estatus_existencia + '}';
    }

   
    
}
