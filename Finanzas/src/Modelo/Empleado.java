/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
/**
 *
 * @author OtakuGT
 */
public class Empleado {
    private int id_empleado;
    private String nombre_empleado;
    private String apellido_empleado;
    private int dpi_empleado;
    private String correo_empleado;
    private String puesto_empleado;
    private int estado_empleado;
    private String fcontrato_empleado;

    public Empleado() {
    }

    @Override
    public String toString() {
        return "Empleado{" + "id_empleado=" + id_empleado + ", nombre_empleado=" + nombre_empleado + ", apellido_empleado=" + apellido_empleado + ", dpi_empleado=" + dpi_empleado + ", correo_empleado=" + correo_empleado + ", puesto_empleado=" + puesto_empleado + ", estado_empleado=" + estado_empleado + ", fcontrato_empleado=" + fcontrato_empleado + '}';
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellido_empleado() {
        return apellido_empleado;
    }

    public void setApellido_empleado(String apellido_empleado) {
        this.apellido_empleado = apellido_empleado;
    }

    public int getDpi_empleado() {
        return dpi_empleado;
    }

    public void setDpi_empleado(int dpi_empleado) {
        this.dpi_empleado = dpi_empleado;
    }

    public String getCorreo_empleado() {
        return correo_empleado;
    }

    public void setCorreo_empleado(String correo_empleado) {
        this.correo_empleado = correo_empleado;
    }

    public String getPuesto_empleado() {
        return puesto_empleado;
    }

    public void setPuesto_empleado(String puesto_empleado) {
        this.puesto_empleado = puesto_empleado;
    }

    public int getEstado_empleado() {
        return estado_empleado;
    }

    public void setEstado_empleado(int estado_empleado) {
        this.estado_empleado = estado_empleado;
    }

    public String getFcontrato_empleado() {
        return fcontrato_empleado;
    }

    public void setFcontrato_empleado(String fcontrato_empleado) {
        this.fcontrato_empleado = fcontrato_empleado;
    }

    public Empleado(int id_empleado, String nombre_empleado, String apellido_empleado, int dpi_empleado, String correo_empleado, String puesto_empleado, int estado_empleado, String fcontrato_empleado) {
        this.id_empleado = id_empleado;
        this.nombre_empleado = nombre_empleado;
        this.apellido_empleado = apellido_empleado;
        this.dpi_empleado = dpi_empleado;
        this.correo_empleado = correo_empleado;
        this.puesto_empleado = puesto_empleado;
        this.estado_empleado = estado_empleado;
        this.fcontrato_empleado = fcontrato_empleado;
    }
}
