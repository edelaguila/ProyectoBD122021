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
public class Transporte {
    
    int PKcodigoTransporte;
    String nombreTransporte;
    String tipoTransporte;
    String estatusTransporte;

    public int getPKcodigoTransporte() {
        return PKcodigoTransporte;
    }

    public String getNombreTransporte() {
        return nombreTransporte;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public String getEstatusTransporte() {
        return estatusTransporte;
    }

    public void setPKcodigoTransporte(int PKcodigoTransporte) {
        this.PKcodigoTransporte = PKcodigoTransporte;
    }

    public void setNombreTransporte(String nombreTransporte) {
        this.nombreTransporte = nombreTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public void setEstatusTransporte(String estatusTransporte) {
        this.estatusTransporte = estatusTransporte;
    }
    
    
    
    
    
    
    
}
