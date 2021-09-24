/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;
/**
 * 
 * @author  Santiago Martinez Diaz
 */

public class Concepto {
 
   private String Id_Concepto;
   private String Nombre_Concepto;
   private String Descripcion_Concepto;
   private String Estatus_Concepto;

    public Concepto() {
    }

    public Concepto(String Id_Concepto, String Nombre_Concepto, String Descripcion_Concepto, String Estatus_Concepto) {
        this.Id_Concepto = Id_Concepto;
        this.Nombre_Concepto = Nombre_Concepto;
        this.Descripcion_Concepto = Descripcion_Concepto;
        this.Estatus_Concepto = Estatus_Concepto;
    }

    public String getId_Concepto() {
        return Id_Concepto;
    }

    public void setId_Concepto(String Id_Concepto) {
        this.Id_Concepto = Id_Concepto;
    }

    public String getNombre_Concepto() {
        return Nombre_Concepto;
    }

    public void setNombre_Concepto(String Nombre_Concepto) {
        this.Nombre_Concepto = Nombre_Concepto;
    }

    public String getDescripcion_Concepto() {
        return Descripcion_Concepto;
    }

    public void setDescripcion_Concepto(String Descripcion_Concepto) {
        this.Descripcion_Concepto = Descripcion_Concepto;
    }

    public String getEstatus_Concepto() {
        return Estatus_Concepto;
    }

    public void setEstatus_Concepto(String Estatus_Concepto) {
        this.Estatus_Concepto = Estatus_Concepto;
    }

    @Override
    public String toString() {
        return "Concepto{" + "Id_Concepto=" + Id_Concepto + ", Nombre_Concepto=" + Nombre_Concepto + ", Descripcion_Concepto=" + Descripcion_Concepto + ", Estatus_Concepto=" + Estatus_Concepto + '}';
    }
   
   
}
