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
public class Linea {
    
String PK_codigo_Linea;
String nombre_Linea; 
String estatus_Linea; 

    public String getPK_codigo_Linea() {
        return PK_codigo_Linea;
    }

    public void setPK_codigo_Linea(String PK_codigo_Linea) {
        this.PK_codigo_Linea = PK_codigo_Linea;
    }

    public String getNombre_Linea() {
        return nombre_Linea;
    }

    public void setNombre_Linea(String nombre_Linea) {
        this.nombre_Linea = nombre_Linea;
    }

    public String getEstatus_Linea() {
        return estatus_Linea;
    }

    public void setEstatus_Linea(String estatus_Linea) {
        this.estatus_Linea = estatus_Linea;
    }

    @Override
    public String toString() {
        return "Linea{" + "PK_codigo_Linea=" + PK_codigo_Linea + ", nombre_Linea=" + nombre_Linea + ", estatus_Linea=" + estatus_Linea + '}';
    }
    
    
}
