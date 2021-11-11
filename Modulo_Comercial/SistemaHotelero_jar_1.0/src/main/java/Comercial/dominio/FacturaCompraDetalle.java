/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comercial.dominio;
import Comercial.datos.*;
import Comercial.dominio.Proveedor;
import Comercial.datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author SipaqueRitaMaria
 */
public class FacturaCompraDetalle {
int correlativo;
int PK_Codigo_Factura;
String PK_codigo_producto;
String PK_codigo_bodega;
String Cantidad_detalle; 
String Costo_detalle; 
int Total_detalle; 

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public int getPK_Codigo_Factura() {
        return PK_Codigo_Factura;
    }

    public void setPK_Codigo_Factura(int PK_Codigo_Factura) {
        this.PK_Codigo_Factura = PK_Codigo_Factura;
    }

    public String getPK_codigo_producto() {
        return PK_codigo_producto;
    }

    public void setPK_codigo_producto(String PK_codigo_producto) {
        this.PK_codigo_producto = PK_codigo_producto;
    }

    public String getPK_codigo_bodega() {
        return PK_codigo_bodega;
    }

    public void setPK_codigo_bodega(String PK_codigo_bodega) {
        this.PK_codigo_bodega = PK_codigo_bodega;
    }

    public String getCantidad_detalle() {
        return Cantidad_detalle;
    }

    public void setCantidad_detalle(String Cantidad_detalle) {
        this.Cantidad_detalle = Cantidad_detalle;
    }

    public String getCosto_detalle() {
        return Costo_detalle;
    }

    public void setCosto_detalle(String Costo_detalle) {
        this.Costo_detalle = Costo_detalle;
    }

    public int getTotal_detalle() {
        return Total_detalle;
    }

    public void setTotal_detalle(int Total_detalle) {
        this.Total_detalle = Total_detalle;
    }

   
  
    }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

