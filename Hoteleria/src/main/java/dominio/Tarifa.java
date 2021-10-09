/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author leone
 */
public class Tarifa {
    private String correlativo, id_tarifa, id_habitacion, nombre, estado;

    public String getId_tarifa() {
        return id_tarifa;
    }

    public void setId_tarifa(String id_tarifa) {
        this.id_tarifa = id_tarifa;
    }

    public String getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(String id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    
    
}
