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
public class Tipo_Documento {

    String Pk_codigo_tipo_documento;
    String nombre_tipo_documento;
    String estatus_tipo_documento;

    public String getPk_codigo_tipo_documento() {
        return Pk_codigo_tipo_documento;
    }

    public void setPk_codigo_tipo_documento(String Pk_codigo_tipo_documento) {
        this.Pk_codigo_tipo_documento = Pk_codigo_tipo_documento;
    }

    public String getNombre_tipo_documento() {
        return nombre_tipo_documento;
    }

    public void setNombre_tipo_documento(String nombre_tipo_documento) {
        this.nombre_tipo_documento = nombre_tipo_documento;
    }

    public String getEstatus_tipo_documento() {
        return estatus_tipo_documento;
    }

    public void setEstatus_tipo_documento(String estatus_tipo_documento) {
        this.estatus_tipo_documento = estatus_tipo_documento;
    }

    @Override
    public String toString() {
        return "Tipo_Documento{" + "Pk_codigo_tipo_documento=" + Pk_codigo_tipo_documento + ", nombre_tipo_documento=" + nombre_tipo_documento + ", estatus_tipo_documento=" + estatus_tipo_documento + '}';
    }

}
