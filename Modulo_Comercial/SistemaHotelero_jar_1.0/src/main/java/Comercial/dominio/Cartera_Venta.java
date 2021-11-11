/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.dominio;

/**
 *
 * @author PERSONAL
 */
public class Cartera_Venta {
     String no_serie;
    String codigo_cliente;
      String codigo_vendedor;
        String codigo_cobrador;
          String nombre_cliente;
           String nombre_cobrador;
            String nombre_vendedor;

              String estatus_cartera;

    public String getNo_serie() {
        return no_serie;
    }

    public void setNo_serie(String no_serie) {
        this.no_serie = no_serie;
    }

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getCodigo_vendedor() {
        return codigo_vendedor;
    }

    public void setCodigo_vendedor(String codigo_vendedor) {
        this.codigo_vendedor = codigo_vendedor;
    }

    public String getCodigo_cobrador() {
        return codigo_cobrador;
    }

    public void setCodigo_cobrador(String codigo_cobrador) {
        this.codigo_cobrador = codigo_cobrador;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getNombre_cobrador() {
        return nombre_cobrador;
    }

    public void setNombre_cobrador(String nombre_cobrador) {
        this.nombre_cobrador = nombre_cobrador;
    }

    public String getNombre_vendedor() {
        return nombre_vendedor;
    }

    public void setNombre_vendedor(String nombre_vendedor) {
        this.nombre_vendedor = nombre_vendedor;
    }

    public String getEstatus_cartera() {
        return estatus_cartera;
    }

    public void setEstatus_cartera(String estatus_cartera) {
        this.estatus_cartera = estatus_cartera;
    }

    @Override
    public String toString() {
        return "Cartera_Venta{" + "no_serie=" + no_serie + ", codigo_cliente=" + codigo_cliente + ", codigo_vendedor=" + codigo_vendedor + ", codigo_cobrador=" + codigo_cobrador + ", nombre_cliente=" + nombre_cliente + ", nombre_cobrador=" + nombre_cobrador + ", nombre_vendedor=" + nombre_vendedor + ", estatus_cartera=" + estatus_cartera + '}';
    }
   
            
            
            
            
            
            
            
            
}
