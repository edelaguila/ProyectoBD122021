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
public class Marca {
String PK_codigo_Marca;
String nombre_Marca; 
String estatus_Marca; 

    public String getPK_codigo_Marca() {
        return PK_codigo_Marca;
    }

    public void setPK_codigo_Marca(String PK_codigo_Marca) {
        this.PK_codigo_Marca = PK_codigo_Marca;
    }

    public String getNombre_Marca() {
        return nombre_Marca;
    }

    public void setNombre_Marca(String nombre_Marca) {
        this.nombre_Marca = nombre_Marca;
    }

    public String getEstatus_Marca() {
        return estatus_Marca;
    }

    public void setEstatus_Marca(String estatus_Marca) {
        this.estatus_Marca = estatus_Marca;
    }

    @Override
    public String toString() {
        return "Marca{" + "PK_codigo_Marca=" + PK_codigo_Marca + ", nombre_Marca=" + nombre_Marca + ", estatus_Marca=" + estatus_Marca + '}';
    }

    
    
    




}
