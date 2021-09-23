package Comercial.dominio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos
 */
public class Vendedor {
    
   String  codigo_Vendedor;
  String nombre_Vendedor;

String estatus_Vendedor;

    public String getCodigo_Vendedor() {
        return codigo_Vendedor;
    }

    public void setCodigo_Vendedor(String codigo_Vendedor) {
        this.codigo_Vendedor = codigo_Vendedor;
    }

    public String getNombre_Vendedor() {
        return nombre_Vendedor;
    }

    public void setNombre_Vendedor(String nombre_Vendedor) {
        this.nombre_Vendedor = nombre_Vendedor;
    }

    public String getEstatus_Vendedor() {
        return estatus_Vendedor;
    }

    public void setEstatus_Vendedor(String estatus_Vendedor) {
        this.estatus_Vendedor = estatus_Vendedor;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "codigo_Vendedor=" + codigo_Vendedor + ", nombre_Vendedor=" + nombre_Vendedor + ", estatus_Vendedor=" + estatus_Vendedor + '}';
    }

 


}
