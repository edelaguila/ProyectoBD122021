

package Finanzas.dominio;

import seguridad.datos.*;

public class Transaccion1 {
     private String Codigo_CuentaHabiente;
    private String Balance;
    private String Credito;
      private String Debito;
    private String fecha;

    public Transaccion1(String Codigo_CuentaHabiente, String Balance, String Credito, String Debito, String fecha) {
        this.Codigo_CuentaHabiente = Codigo_CuentaHabiente;
        this.Balance = Balance;
        this.Credito = Credito;
        this.Debito = Debito;
        this.fecha = fecha;
    }

    public Transaccion1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public String getCredito() {
        return Credito;
    }

    public void setCredito(String Credito) {
        this.Credito = Credito;
    }

    public String getDebito() {
        return Debito;
    }

    public void setDebito(String Debito) {
        this.Debito = Debito;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Transaccion1{" + "Codigo_CuentaHabiente=" + Codigo_CuentaHabiente + ", Balance=" + Balance + ", Credito=" + Credito + ", Debito=" + Debito + ", fecha=" + fecha + '}';
    }

    
}
