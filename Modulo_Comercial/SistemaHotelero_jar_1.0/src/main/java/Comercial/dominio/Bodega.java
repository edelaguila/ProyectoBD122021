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
public class Bodega {

    int PK_codigo_bodega;
    String nombre_bodega;
    String estatus_bodega;

    public int getPK_codigo_bodega() {
        return PK_codigo_bodega;
    }

    public String getNombre_bodega() {
        return nombre_bodega;
    }

    public String getEstatus_bodega() {
        return estatus_bodega;
    }

    public void setPK_codigo_bodega(int PK_codigo_bodega) {
        this.PK_codigo_bodega = PK_codigo_bodega;
    }

    public void setNombre_bodega(String nombre_bodega) {
        this.nombre_bodega = nombre_bodega;
    }

    public void setEstatus_bodega(String estatus_bodega) {
        this.estatus_bodega = estatus_bodega;
    }

}
