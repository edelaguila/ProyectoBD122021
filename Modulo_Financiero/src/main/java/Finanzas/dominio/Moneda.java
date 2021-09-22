/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas.dominio;

/**
 *
 * @author Nay Ale
 */
public class Moneda {

   private String Codigo_Moneda;
   private String Nombre_Moneda;
   private String Tipo_Cambio;
   private String Simbolo_Moneda;

    public Moneda() {
    }

    public Moneda(String Codigo_Moneda, String Nombre_Moneda, String Tipo_Cambio, String Simbolo_Moneda) {
        this.Codigo_Moneda = Codigo_Moneda;
        this.Nombre_Moneda = Nombre_Moneda;
        this.Tipo_Cambio = Tipo_Cambio;
        this.Simbolo_Moneda = Simbolo_Moneda;
    }

    public String getCodigo_Moneda() {
        return Codigo_Moneda;
    }

    public void setCodigo_Moneda(String Codigo_Moneda) {
        this.Codigo_Moneda = Codigo_Moneda;
    }

    public String getNombre_Moneda() {
        return Nombre_Moneda;
    }

    public void setNombre_Moneda(String Nombre_Moneda) {
        this.Nombre_Moneda = Nombre_Moneda;
    }

    public String getTipo_Cambio() {
        return Tipo_Cambio;
    }

    public void setTipo_Cambio(String Tipo_Cambio) {
        this.Tipo_Cambio = Tipo_Cambio;
    }

    public String getSimbolo_Moneda() {
        return Simbolo_Moneda;
    }

    public void setSimbolo_Moneda(String Simbolo_Moneda) {
        this.Simbolo_Moneda = Simbolo_Moneda;
    }

    @Override
    public String toString() {
        return "Moneda{" + "Codigo_Moneda=" + Codigo_Moneda + ", Nombre_Moneda=" + Nombre_Moneda + ", Tipo_Cambio=" + Tipo_Cambio + ", Simbolo_Moneda=" + Simbolo_Moneda + '}';
    }
   
    
 
   
   
}
