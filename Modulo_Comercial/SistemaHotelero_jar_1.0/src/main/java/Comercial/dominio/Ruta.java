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
public class Ruta {
    String PK_codigo_transporteruta;
    String nombre_conductoruta;
    String nombre_transporteruta;
    String tipo_transporteruta;
    String ubicacion_transporteruta;
    String direccion_transporteruta;
    String hora_salida_transporteruta;
    String hora_entrada_transporteruta;
    String estatus_transporteruta;

    public String getPK_codigo_transporteruta() {
        return PK_codigo_transporteruta;
    }

    public void setPK_codigo_transporteruta(String PK_codigo_transporteruta) {
        this.PK_codigo_transporteruta = PK_codigo_transporteruta;
    }

    public String getNombre_conductoruta() {
        return nombre_conductoruta;
    }

    public void setNombre_conductoruta(String nombre_conductoruta) {
        this.nombre_conductoruta = nombre_conductoruta;
    }

    public String getNombre_transporteruta() {
        return nombre_transporteruta;
    }

    public void setNombre_transporteruta(String nombre_transporteruta) {
        this.nombre_transporteruta = nombre_transporteruta;
    }

    public String getTipo_transporteruta() {
        return tipo_transporteruta;
    }

    public void setTipo_transporteruta(String tipo_transporteruta) {
        this.tipo_transporteruta = tipo_transporteruta;
    }

    public String getUbicacion_transporteruta() {
        return ubicacion_transporteruta;
    }

    public void setUbicacion_transporteruta(String ubicacion_transporteruta) {
        this.ubicacion_transporteruta = ubicacion_transporteruta;
    }

    public String getDireccion_transporteruta() {
        return direccion_transporteruta;
    }

    public void setDireccion_transporteruta(String direccion_transporteruta) {
        this.direccion_transporteruta = direccion_transporteruta;
    }

    public String getHora_salida_transporteruta() {
        return hora_salida_transporteruta;
    }

    public void setHora_salida_transporteruta(String hora_salida_transporteruta) {
        this.hora_salida_transporteruta = hora_salida_transporteruta;
    }

    public String getHora_entrada_transporteruta() {
        return hora_entrada_transporteruta;
    }

    public void setHora_entrada_transporteruta(String hora_entrada_transporteruta) {
        this.hora_entrada_transporteruta = hora_entrada_transporteruta;
    }

    public String getEstatus_transporteruta() {
        return estatus_transporteruta;
    }

    public void setEstatus_transporteruta(String estatus_transporteruta) {
        this.estatus_transporteruta = estatus_transporteruta;
    }

    @Override
    public String toString() {
        return "Ruta{" + "PK_codigo_transporteruta=" + PK_codigo_transporteruta + ", nombre_conductoruta=" + nombre_conductoruta + ", nombre_transporteruta=" + nombre_transporteruta + ", tipo_transporteruta=" + tipo_transporteruta + ", ubicacion_transporteruta=" + ubicacion_transporteruta + ", direccion_transporteruta=" + direccion_transporteruta + ", hora_salida_transporteruta=" + hora_salida_transporteruta + ", hora_entrada_transporteruta=" + hora_entrada_transporteruta + ", estatus_transporteruta=" + estatus_transporteruta + '}';
    }

    
    
    
}
