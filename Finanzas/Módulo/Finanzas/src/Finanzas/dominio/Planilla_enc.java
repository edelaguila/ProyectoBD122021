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
public class Planilla_enc {
    private int id_planen;
    private double total_percep;
    private double total_deduc;
    private double total_liq;

    @Override
    public String toString() {
        return "Planilla_enc{" + "id_planen=" + id_planen + ", total_percep=" + total_percep + ", total_deduc=" + total_deduc + ", total_liq=" + total_liq + '}';
    }

    public int getId_planen() {
        return id_planen;
    }

    public void setId_planen(int id_planen) {
        this.id_planen = id_planen;
    }

    public double getTotal_percep() {
        return total_percep;
    }

    public void setTotal_percep(double total_percep) {
        this.total_percep = total_percep;
    }

    public double getTotal_deduc() {
        return total_deduc;
    }

    public void setTotal_deduc(double total_deduc) {
        this.total_deduc = total_deduc;
    }

    public double getTotal_liq() {
        return total_liq;
    }

    public void setTotal_liq(double total_liq) {
        this.total_liq = total_liq;
    }

    public Planilla_enc() {
    }
}
