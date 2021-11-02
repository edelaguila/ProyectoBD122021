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
    String nombre_unidad;
    String medida_acronimo;
    String estatus_unidad;

    public String getPKcodigoUnidad() {
        return PKcodigoUnidad;
    }

    public String getNombre_unidad() {
        return nombre_unidad;
    }

    public String getMedida_acronimo() {
        return medida_acronimo;
    }

    public String getEstatus_unidad() {
        return estatus_unidad;
    }

    public void setPKcodigoUnidad(String PKcodigoUnidad) {
        this.PKcodigoUnidad = PKcodigoUnidad;
    }

    public void setNombre_unidad(String nombre_unidad) {
        this.nombre_unidad = nombre_unidad;
    }

    public void setMedida_acronimo(String medida_acronimo) {
        this.medida_acronimo = medida_acronimo;
    }

    public void setEstatus_unidad(String estatus_unidad) {
        this.estatus_unidad = estatus_unidad;
    }

    @Override
    public String toString() {
        return "Unidad{" + "PKcodigoUnidad=" + PKcodigoUnidad + ", nombre_unidad=" + nombre_unidad + ", medida_acronimo=" + medida_acronimo + ", estatus_unidad=" + estatus_unidad + '}';
    }

    
}
