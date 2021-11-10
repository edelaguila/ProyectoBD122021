/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas.dominio;

/**
 *
 * @author OtakuGT
 */
public class Conceptop {
    private int id_conceptop;
    private String nombre_conceptop;
    private String tipo_conceptop;
    private String clase_conceptop;
    private double valor_conceptop;

    @Override
    public String toString() {
        return "Conceptop{" + "id_conceptop=" + id_conceptop + ", nombre_conceptop=" + nombre_conceptop + ", tipo_conceptop=" + tipo_conceptop + ", clase_conceptop=" + clase_conceptop + ", valor_conceptop=" + valor_conceptop + '}';
    }

    public int getId_conceptop() {
        return id_conceptop;
    }

    public void setId_conceptop(int id_conceptop) {
        this.id_conceptop = id_conceptop;
    }

    public String getNombre_conceptop() {
        return nombre_conceptop;
    }

    public void setNombre_conceptop(String nombre_conceptop) {
        this.nombre_conceptop = nombre_conceptop;
    }

    public String getTipo_conceptop() {
        return tipo_conceptop;
    }

    public void setTipo_conceptop(String tipo_conceptop) {
        this.tipo_conceptop = tipo_conceptop;
    }

    public String getClase_conceptop() {
        return clase_conceptop;
    }

    public void setClase_conceptop(String clase_conceptop) {
        this.clase_conceptop = clase_conceptop;
    }

    public double getValor_conceptop() {
        return valor_conceptop;
    }

    public void setValor_conceptop(double valor_conceptop) {
        this.valor_conceptop = valor_conceptop;
    }

    public Conceptop() {
    }
}
