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
public class CocinaRestaurante {
    private String correlativo, hora, orden, menu, nuevaExistencia, ingrediente;

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getNuevaExistencia() {
        return nuevaExistencia;
    }

    public void setNuevaExistencia(String nuevaExistencia) {
        this.nuevaExistencia = nuevaExistencia;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }
    
    public String getIngrediente() {
        return ingrediente;
    }
}
