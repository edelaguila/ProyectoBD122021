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
public class AutorizacionOrdenCompra1 {
 
int PK_codigo_autorizacion;
String codigo_ordencompra;
String nombre_autorizacion;
String departamento_autorizacion; 
String fecha_autorizacion; 
String estatus_autorizacion;   

    public int getPK_codigo_autorizacion() {
        return PK_codigo_autorizacion;
    }

    public void setPK_codigo_autorizacion(int PK_codigo_autorizacion) {
        this.PK_codigo_autorizacion = PK_codigo_autorizacion;
    }

    public String getCodigo_ordencompra() {
        return codigo_ordencompra;
    }

    public void setCodigo_ordencompra(String codigo_ordencompra) {
        this.codigo_ordencompra = codigo_ordencompra;
    }

    public String getNombre_autorizacion() {
        return nombre_autorizacion;
    }

    public void setNombre_autorizacion(String nombre_autorizacion) {
        this.nombre_autorizacion = nombre_autorizacion;
    }

    public String getDepartamento_autorizacion() {
        return departamento_autorizacion;
    }

    public void setDepartamento_autorizacion(String departamento_autorizacion) {
        this.departamento_autorizacion = departamento_autorizacion;
    }

    public String getFecha_autorizacion() {
        return fecha_autorizacion;
    }

    public void setFecha_autorizacion(String fecha_autorizacion) {
        this.fecha_autorizacion = fecha_autorizacion;
    }

    public String getEstatus_autorizacion() {
        return estatus_autorizacion;
    }

    public void setEstatus_autorizacion(String estatus_autorizacion) {
        this.estatus_autorizacion = estatus_autorizacion;
    }


}
