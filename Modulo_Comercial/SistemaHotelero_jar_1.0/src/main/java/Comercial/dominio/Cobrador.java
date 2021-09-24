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
public class Cobrador {
      String  codigo_Cobrador;
  String nombre_Cobrador;

String estatus_Cobrador;

    public String getCodigo_Cobrador() {
        return codigo_Cobrador;
    }

    public void setCodigo_Cobrador(String codigo_Cobrador) {
        this.codigo_Cobrador = codigo_Cobrador;
    }

    public String getNombre_Cobrador() {
        return nombre_Cobrador;
    }

    public void setNombre_Cobrador(String nombre_Cobrador) {
        this.nombre_Cobrador = nombre_Cobrador;
    }

    public String getEstatus_Cobrador() {
        return estatus_Cobrador;
    }

    public void setEstatus_Cobrador(String estatus_Cobrador) {
        this.estatus_Cobrador = estatus_Cobrador;
    }

    @Override
    public String toString() {
        return "Cobrador{" + "codigo_Cobrador=" + codigo_Cobrador + ", nombre_Cobrador=" + nombre_Cobrador + ", estatus_Cobrador=" + estatus_Cobrador + '}';
    }

  
  
    
    
    
}
