/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Finanzas.dominio;

import seguridad.datos.*;

/**
 *
 * @author SantiagoMD
 */
public class MovimientoBancario {
    
    
   private String ID_DOCUMENTO;
   private String Codigo_CuentaHabiente;
   private String Balance;
     private String Transaccion;
   private String fecha;
   private String CONCEPTO;

    public MovimientoBancario() {
    }

    public MovimientoBancario(String ID_DOCUMENTO, String Codigo_CuentaHabiente, String Balance, String Transaccion, String fecha, String CONCEPTO) {
        this.ID_DOCUMENTO = ID_DOCUMENTO;
        this.Codigo_CuentaHabiente = Codigo_CuentaHabiente;
        this.Balance = Balance;
        this.Transaccion = Transaccion;
        this.fecha = fecha;
        this.CONCEPTO = CONCEPTO;
    }

    public String getID_DOCUMENTO() {
        return ID_DOCUMENTO;
    }

    public void setID_DOCUMENTO(String ID_DOCUMENTO) {
        this.ID_DOCUMENTO = ID_DOCUMENTO;
    }

    public String getCodigo_CuentaHabiente() {
        return Codigo_CuentaHabiente;
    }

    public void setCodigo_CuentaHabiente(String Codigo_CuentaHabiente) {
        this.Codigo_CuentaHabiente = Codigo_CuentaHabiente;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String Balance) {
        this.Balance = Balance;
    }

    public String getTransaccion() {
        return Transaccion;
    }

    public void setTransaccion(String Transaccion) {
        this.Transaccion = Transaccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCONCEPTO() {
        return CONCEPTO;
    }

    public void setCONCEPTO(String CONCEPTO) {
        this.CONCEPTO = CONCEPTO;
    }

    @Override
    public String toString() {
        return "MovimientoBancario{" + "ID_DOCUMENTO=" + ID_DOCUMENTO + ", Codigo_CuentaHabiente=" + Codigo_CuentaHabiente + ", Balance=" + Balance + ", Transaccion=" + Transaccion + ", fecha=" + fecha + ", CONCEPTO=" + CONCEPTO + '}';
    }
   
   
    
    
}
