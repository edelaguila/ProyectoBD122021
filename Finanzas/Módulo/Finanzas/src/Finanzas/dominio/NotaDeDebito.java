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
public class NotaDeDebito {
 private String NumeroDeDocumento;
    private String NumeroDeCuenta;
    private String Beneficiario;
    private String Fecha;
    private String Monto;
    private String Descripcion;

    public NotaDeDebito() {
    }

    public NotaDeDebito(String NumeroDeDocumento, String NumeroDeCuenta, String Beneficiario, String Fecha, String Monto, String Descripcion) {
        this.NumeroDeDocumento = NumeroDeDocumento;
        this.NumeroDeCuenta = NumeroDeCuenta;
        this.Beneficiario = Beneficiario;
        this.Fecha = Fecha;
        this.Monto = Monto;
        this.Descripcion = Descripcion;
    }

    public String getNumeroDeDocumento() {
        return NumeroDeDocumento;
    }

    public void setNumeroDeDocumento(String NumeroDeDocumento) {
        this.NumeroDeDocumento = NumeroDeDocumento;
    }

    public String getNumeroDeCuenta() {
        return NumeroDeCuenta;
    }

    public void setNumeroDeCuenta(String NumeroDeCuenta) {
        this.NumeroDeCuenta = NumeroDeCuenta;
    }

    public String getBeneficiario() {
        return Beneficiario;
    }

    public void setBeneficiario(String Beneficiario) {
        this.Beneficiario = Beneficiario;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getMonto() {
        return Monto;
    }

    public void setMonto(String Monto) {
        this.Monto = Monto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return "NotaDeDebito{" + "NumeroDeDocumento=" + NumeroDeDocumento + ", NumeroDeCuenta=" + NumeroDeCuenta + ", Beneficiario=" + Beneficiario + ", Fecha=" + Fecha + ", Monto=" + Monto + ", Descripcion=" + Descripcion + '}';
    }

    
}
