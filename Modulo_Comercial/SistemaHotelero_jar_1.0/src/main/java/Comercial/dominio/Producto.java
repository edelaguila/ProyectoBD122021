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
public class Producto {
    String PKcodigoProducto;
    String linea;
    String nombreProducto;
    String descripcionProducto;
    String precioProducto;
    String costoProducto;
    String estatusProducto;
    String lineaProducto;
    String marcaProducto;
    String bodegaProducto;
    String unidadProducto;

    public String getPKcodigoProducto() {
        return PKcodigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public String getPrecioProducto() {
        return precioProducto;
    }

    public String getCostoProducto() {
        return costoProducto;
    }

    public String getEstatusProducto() {
        return estatusProducto;
    }

    public String getLineaProducto() {
        return lineaProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public String getBodegaProducto() {
        return bodegaProducto;
    }

    public String getUnidadProducto() {
        return unidadProducto;
    }

    public void setPKcodigoProducto(String PKcodigoProducto) {
        this.PKcodigoProducto = PKcodigoProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public void setPrecioProducto(String precioProducto) {
        this.precioProducto = precioProducto;
    }

    public void setCostoProducto(String costoProducto) {
        this.costoProducto = costoProducto;
    }

    public void setEstatusProducto(String estatusProducto) {
        this.estatusProducto = estatusProducto;
    }

    public void setLineaProducto(String lineaProducto) {
        this.lineaProducto = lineaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public void setBodegaProducto(String bodegaProducto) {
        this.bodegaProducto = bodegaProducto;
    }

    public void setUnidadProducto(String unidadProducto) {
        this.unidadProducto = unidadProducto;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    @Override
    public String toString() {
        return "Producto{" + "PKcodigoProducto=" + PKcodigoProducto +
                ", linea=" + linea + ", nombreProducto=" + nombreProducto +
                ", descripcionProducto=" + descripcionProducto + ", precioProducto=" + 
                precioProducto + ", costoProducto=" + costoProducto + ", estatusProducto=" + 
                estatusProducto + ", lineaProducto=" + lineaProducto + ", marcaProducto=" +
                marcaProducto + ", bodegaProducto=" + bodegaProducto + ", unidadProducto=" +
                unidadProducto + '}';
    }
}
