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
public class Bodega {

     String PKcodigoBodega;
    String nombreBodega;
    String estatusBodega;

    public String getPKcodigoBodega() {
        return PKcodigoBodega;
    }

    public void setPKcodigoBodega(String PKcodigoBodega) {
        this.PKcodigoBodega = PKcodigoBodega;
    }

    public String getNombreBodega() {
        return nombreBodega;
    }

    public void setNombreBodega(String nombreBodega) {
        this.nombreBodega = nombreBodega;
    }

    public String getEstatusBodega() {
        return estatusBodega;
    }

    public void setEstatusBodega(String estatusBodega) {
        this.estatusBodega = estatusBodega;
    }

    @Override
    public String toString() {
        return "Bodega{" + "PKcodigoBodega=" + PKcodigoBodega + ", nombreBodega=" + nombreBodega + ", estatusBodega=" + estatusBodega + '}';
    }

    

   

}
