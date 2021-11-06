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

    public void setPKcodigoProducto(String PKcodigoProducto) {
        this.PKcodigoProducto = PKcodigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(String precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(String costoProducto) {
        this.costoProducto = costoProducto;
    }

    public String getEstatusProducto() {
        return estatusProducto;
    }

    public void setEstatusProducto(String estatusProducto) {
        this.estatusProducto = estatusProducto;
    }

    public String getLineaProducto() {
        return lineaProducto;
    }

    public void setLineaProducto(String lineaProducto) {
        this.lineaProducto = lineaProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getBodegaProducto() {
        return bodegaProducto;
    }

    public void setBodegaProducto(String bodegaProducto) {
        this.bodegaProducto = bodegaProducto;
    }

    public String getUnidadProducto() {
        return unidadProducto;
    }

    public void setUnidadProducto(String unidadProducto) {
        this.unidadProducto = unidadProducto;
    }

    @Override
    public String toString() {
        return "Producto{" + "PKcodigoProducto=" + PKcodigoProducto + ", nombreProducto=" + nombreProducto + ", descripcionProducto=" + descripcionProducto + ", precioProducto=" + precioProducto + ", costoProducto=" + costoProducto + ", estatusProducto=" + estatusProducto + ", lineaProducto=" + lineaProducto + ", marcaProducto=" + marcaProducto + ", bodegaProducto=" + bodegaProducto + ", unidadProducto=" + unidadProducto + '}';
    }

    
}
