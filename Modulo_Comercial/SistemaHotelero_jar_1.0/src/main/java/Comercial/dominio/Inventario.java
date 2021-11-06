/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.dominio;

/**
 *
 * @author Diana
 */
public class Inventario {
    String PK_codigo_inventario;
    String PK_codigo_producto;
    String PK_codigo_bodega;
    String PK_codigo_existencia;
    String PK_codigo_linea;
    String PK_codigo_marca;
    String PK_codigo_unidad;
    String estatus_inventario;

    
    public void setPK_codigo_inventario(String PK_codigo_inventario) {
        this.PK_codigo_inventario = PK_codigo_inventario;
    }

    public void setPK_codigo_producto(String PK_codigo_producto) {
        this.PK_codigo_producto = PK_codigo_producto;
    }

    public void setPK_codigo_bodega(String PK_codigo_bodega) {
        this.PK_codigo_bodega = PK_codigo_bodega;
    }

    public void setPK_codigo_existencia(String PK_codigo_existencia) {
        this.PK_codigo_existencia = PK_codigo_existencia;
    }

    public void setPK_codigo_linea(String PK_codigo_linea) {
        this.PK_codigo_linea = PK_codigo_linea;
    }

    public void setPK_codigo_marca(String PK_codigo_marca) {
        this.PK_codigo_marca = PK_codigo_marca;
    }

    public void setPK_codigo_unidad(String PK_codigo_unidad) {
        this.PK_codigo_unidad = PK_codigo_unidad;
    }

    public void setEstatus_inventario(String estatus_inventario) {
        this.estatus_inventario = estatus_inventario;
    }

    public String getPK_codigo_inventario() {
        return PK_codigo_inventario;
    }

    public String getPK_codigo_producto() {
        return PK_codigo_producto;
    }

    public String getPK_codigo_bodega() {
        return PK_codigo_bodega;
    }

    public String getPK_codigo_existencia() {
        return PK_codigo_existencia;
    }

    public String getPK_codigo_linea() {
        return PK_codigo_linea;
    }

    public String getPK_codigo_marca() {
        return PK_codigo_marca;
    }

    public String getPK_codigo_unidad() {
        return PK_codigo_unidad;
    }

    public String getEstatus_inventario() {
        return estatus_inventario;
    }
    
    @Override
    public String toString() {
        return "Inventario{" + "PK_codigo_inventario=" + PK_codigo_inventario + ", PK_codigo_producto=" + PK_codigo_producto + ", PK_codigo_bodega=" + PK_codigo_bodega + ", PK_codigo_existencia=" + PK_codigo_existencia + ", PK_codigo_linea=" + PK_codigo_linea + ", PK_codigo_marca=" + PK_codigo_marca + ", PK_codigo_unidad=" + PK_codigo_unidad + ", estatus_inventario=" + estatus_inventario + '}';
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    
}
