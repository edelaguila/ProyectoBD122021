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
public class Puesto {
    private int id_puesto;
    private String nombre_puesto;
    private double salario_puesto;

    public Puesto() {
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public String getNombre_puesto() {
        return nombre_puesto;
    }

    public void setNombre_puesto(String nombre_puesto) {
        this.nombre_puesto = nombre_puesto;
    }

    public double getSalario_puesto() {
        return salario_puesto;
    }

    public void setSalario_puesto(double salario_puesto) {
        this.salario_puesto = salario_puesto;
    }

    public Puesto(int id_puesto, String nombre_puesto, double salario_puesto) {
        this.id_puesto = id_puesto;
        this.nombre_puesto = nombre_puesto;
        this.salario_puesto = salario_puesto;
    }

    @Override
    public String toString() {
        return "Puesto{" + "id_puesto=" + id_puesto + ", nombre_puesto=" + nombre_puesto + ", salario_puesto=" + salario_puesto + '}';
    }
}
