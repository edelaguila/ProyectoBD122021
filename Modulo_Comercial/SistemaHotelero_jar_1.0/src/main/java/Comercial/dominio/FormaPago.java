/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.dominio;

/**
 *
 * @author SipaqueRitaMaria
 */
public class FormaPago {
  int PK_codigo_pago;
  String codigo_proveedor;
  String tipo_pago;
  String Forma_pago;
  String dias_pago;
  String fecha_pago;
String   estatus_pago;

    public int getPK_codigo_pago() {
        return PK_codigo_pago;
    }

    public void setPK_codigo_pago(int PK_codigo_pago) {
        this.PK_codigo_pago = PK_codigo_pago;
    }

    public String getCodigo_proveedor() {
        return codigo_proveedor;
    }

    public void setCodigo_proveedor(String codigo_proveedor) {
        this.codigo_proveedor = codigo_proveedor;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getForma_pago() {
        return Forma_pago;
    }

    public void setForma_pago(String Forma_pago) {
        this.Forma_pago = Forma_pago;
    }

    public String getDias_pago() {
        return dias_pago;
    }

    public void setDias_pago(String dias_pago) {
        this.dias_pago = dias_pago;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getEstatus_pago() {
        return estatus_pago;
    }

    public void setEstatus_pago(String estatus_pago) {
        this.estatus_pago = estatus_pago;
    }

   
  

}
