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

     int PKcodigoBodega;
    String nombreBodega;
    String estatusBodega;

    public int getPKcodigoBodega() {
        return PKcodigoBodega;
    }

    public String getNombreBodega() {
        return nombreBodega;
    }

    public String getEstatusBodega() {
        return estatusBodega;
    }

    public void setPKcodigoBodega(int PKcodigoBodega) {
        this.PKcodigoBodega = PKcodigoBodega;
    }

    public void setNombreBodega(String nombreBodega) {
        this.nombreBodega = nombreBodega;
    }

    public void setEstatusBodega(String estatusBodega) {
        this.estatusBodega = estatusBodega;
    }

   

}
