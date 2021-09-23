/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.dominio;

/**
 *
 * @author Rita  Sipaque
 */
public class Proveedor {
    
  String PK_codigo_Proveedor;
  String nombre_Proveedor; 
  String direccion_Proveedor; 
  String telefono_Proveedor;
  String nit_Proveedor; 
  String email_Proveedor;
  String saldo_Proveedor;
  String estatus_Proveedor; 

    public String getPK_codigo_Proveedor() {
        return PK_codigo_Proveedor;
    }

    public void setPK_codigo_Proveedor(String PK_codigo_Proveedor) {
        this.PK_codigo_Proveedor = PK_codigo_Proveedor;
    }

    public String getNombre_Proveedor() {
        return nombre_Proveedor;
    }

    public void setNombre_Proveedor(String nombre_Proveedor) {
        this.nombre_Proveedor = nombre_Proveedor;
    }

    public String getDireccion_Proveedor() {
        return direccion_Proveedor;
    }

    public void setDireccion_Proveedor(String direccion_Proveedor) {
        this.direccion_Proveedor = direccion_Proveedor;
    }

    public String getTelefono_Proveedor() {
        return telefono_Proveedor;
    }

    public void setTelefono_Proveedor(String telefono_Proveedor) {
        this.telefono_Proveedor = telefono_Proveedor;
    }

    public String getNit_Proveedor() {
        return nit_Proveedor;
    }

    public void setNit_Proveedor(String nit_Proveedor) {
        this.nit_Proveedor = nit_Proveedor;
    }

    public String getEmail_Proveedor() {
        return email_Proveedor;
    }

    public void setEmail_Proveedor(String email_Proveedor) {
        this.email_Proveedor = email_Proveedor;
    }

    public String getSaldo_Proveedor() {
        return saldo_Proveedor;
    }

    public void setSaldo_Proveedor(String saldo_Proveedor) {
        this.saldo_Proveedor = saldo_Proveedor;
    }

    public String getEstatus_Proveedor() {
        return estatus_Proveedor;
    }

    public void setEstatus_Proveedor(String estatus_Proveedor) {
        this.estatus_Proveedor = estatus_Proveedor;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "PK_codigo_Proveedor=" + PK_codigo_Proveedor + ", nombre_Proveedor=" + nombre_Proveedor + ", direccion_Proveedor=" + direccion_Proveedor + ", telefono_Proveedor=" + telefono_Proveedor + ", nit_Proveedor=" + nit_Proveedor + ", email_Proveedor=" + email_Proveedor + ", saldo_Proveedor=" + saldo_Proveedor + ", estatus_Proveedor=" + estatus_Proveedor + '}';
    }

 
  
}
