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
public class Unidad {
    
    String PKcodigoUnidad;
    String unidadEntrada;
    String unidadSalida;

    public String getPKcodigoUnidad() {
        return PKcodigoUnidad;
    }

    public String getUnidadEntrada() {
        return unidadEntrada;
    }

    public String getUnidadSalida() {
        return unidadSalida;
    }

    public void setPKcodigoUnidad(String PKcodigoUnidad) {
        this.PKcodigoUnidad = PKcodigoUnidad;
    }

    public void setUnidadEntrada(String unidadEntrada) {
        this.unidadEntrada = unidadEntrada;
    }

    public void setUnidadSalida(String unidadSalida) {
        this.unidadSalida = unidadSalida;
    }
    
}
