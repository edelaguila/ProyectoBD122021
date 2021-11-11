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
public class Transporte {
    
   String PK_codigo_transporte;
    String clase_transporte;
    String marca_transporte;
    String modelo_transporte;
    String tipo_transporte;
    String placa_transporte;
    String color_transporte;
    String estado_transporte;
    String numero_motor_transporte;
    String estatus_transporte;

    public String getPK_codigo_transporte() {
        return PK_codigo_transporte;
    }

    public void setPK_codigo_transporte(String PK_codigo_transporte) {
        this.PK_codigo_transporte = PK_codigo_transporte;
    }

    public String getClase_transporte() {
        return clase_transporte;
    }

    public void setClase_transporte(String clase_transporte) {
        this.clase_transporte = clase_transporte;
    }

    public String getMarca_transporte() {
        return marca_transporte;
    }

    public void setMarca_transporte(String marca_transporte) {
        this.marca_transporte = marca_transporte;
    }

    public String getModelo_transporte() {
        return modelo_transporte;
    }

    public void setModelo_transporte(String modelo_transporte) {
        this.modelo_transporte = modelo_transporte;
    }

    public String getTipo_transporte() {
        return tipo_transporte;
    }

    public void setTipo_transporte(String tipo_transporte) {
        this.tipo_transporte = tipo_transporte;
    }

    public String getPlaca_transporte() {
        return placa_transporte;
    }

    public void setPlaca_transporte(String placa_transporte) {
        this.placa_transporte = placa_transporte;
    }

    public String getColor_transporte() {
        return color_transporte;
    }

    public void setColor_transporte(String color_transporte) {
        this.color_transporte = color_transporte;
    }

    public String getEstado_transporte() {
        return estado_transporte;
    }

    public void setEstado_transporte(String estado_transporte) {
        this.estado_transporte = estado_transporte;
    }

    public String getNumero_motor_transporte() {
        return numero_motor_transporte;
    }

    public void setNumero_motor_transporte(String numero_motor_transporte) {
        this.numero_motor_transporte = numero_motor_transporte;
    }

    public String getEstatus_transporte() {
        return estatus_transporte;
    }

    public void setEstatus_transporte(String estatus_transporte) {
        this.estatus_transporte = estatus_transporte;
    }

    @Override
    public String toString() {
        return "Transporte{" + "PK_codigo_transporte=" + PK_codigo_transporte +
                ", clase_transporte=" + clase_transporte + 
                ", marca_transporte=" + marca_transporte + 
                ", modelo_transporte=" + modelo_transporte +
                ", tipo_transporte=" + tipo_transporte + 
                ", placa_transporte=" + placa_transporte +
                ", color_transporte=" + color_transporte + 
                ", estado_transporte=" + estado_transporte + 
                ", numero_motor_transporte=" + numero_motor_transporte +
                ", estatus_transporte=" + estatus_transporte + '}';
    }
    
    
    
    
    
}
