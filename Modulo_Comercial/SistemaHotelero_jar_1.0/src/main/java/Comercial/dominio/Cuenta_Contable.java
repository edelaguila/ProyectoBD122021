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
public class Cuenta_Contable {
    String codigo_contable;
     String codigo_clasificacion;
String codigo_subclasificacion;   
String estado_contable;
String monto;
String efecto_contable;

    public String getCodigo_contable() {
        return codigo_contable;
    }

    public void setCodigo_contable(String codigo_contable) {
        this.codigo_contable = codigo_contable;
    }

    public String getCodigo_clasificacion() {
        return codigo_clasificacion;
    }

    public void setCodigo_clasificacion(String codigo_clasificacion) {
        this.codigo_clasificacion = codigo_clasificacion;
    }

    public String getCodigo_subclasificacion() {
        return codigo_subclasificacion;
    }

    public void setCodigo_subclasificacion(String codigo_subclasificacion) {
        this.codigo_subclasificacion = codigo_subclasificacion;
    }

    public String getEstado_contable() {
        return estado_contable;
    }

    public void setEstado_contable(String estado_contable) {
        this.estado_contable = estado_contable;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getEfecto_contable() {
        return efecto_contable;
    }

    public void setEfecto_contable(String efecto_contable) {
        this.efecto_contable = efecto_contable;
    }

    @Override
    public String toString() {
        return "cuenta_contable{" + "codigo_contable=" + codigo_contable + ", codigo_clasificacion=" + codigo_clasificacion + ", codigo_subclasificacion=" + codigo_subclasificacion + ", estado_contable=" + estado_contable + ", monto=" + monto + ", efecto_contable=" + efecto_contable + '}';
    }


}
