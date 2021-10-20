/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas.dominio;

import java.util.Date;

/**
 *
 * @author OtakuGT
 */
public class PeriodoFiscal {
 private String IDPerFis;   
 private String InicioAñoPerFis;
 private String FinAñoPerFis;
 private int EstadoPerFis;

 public PeriodoFiscal(){

 }
 
     public PeriodoFiscal(String IDPerFis, String InicioAñoPerFis, String FinAñoPerFis, int EstadoPerFis) {
        this.IDPerFis = IDPerFis;
        this.InicioAñoPerFis = InicioAñoPerFis;
        this.FinAñoPerFis = FinAñoPerFis;
        this.EstadoPerFis = EstadoPerFis;
    }
     public String getFinAñoPerFis() {
        return FinAñoPerFis;
    }

    public void setFinAñoPerFis(String FinAñoPerFis) {
        this.FinAñoPerFis = FinAñoPerFis;
    }
    
    public int getEstadoPerFis() {
        return EstadoPerFis;
    }

    public void setEstadoPerFis(int EstadoPerFis) {
        this.EstadoPerFis = EstadoPerFis;
    }

    public String getIDPerFis() {
        return IDPerFis;
    }

    public void setIDPerFis(String IDPerFis) {
        this.IDPerFis = IDPerFis;
    }

    public String getInicioAñoPerFis() {
        return InicioAñoPerFis;
    }

    public void setInicioAñoPerFis(String InicioAñoPerFis) {
        this.InicioAñoPerFis = InicioAñoPerFis;
    }

    @Override
    public String toString() {
        return "PeriodoFiscal{" + "IDPerFis=" + IDPerFis + ", InicioAñoPerFis=" + InicioAñoPerFis + ", FinAñoPerFis=" + FinAñoPerFis + ", EstadoPerFis=" + EstadoPerFis + '}';
    }



}
