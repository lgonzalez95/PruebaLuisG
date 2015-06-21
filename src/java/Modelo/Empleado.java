/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Luis
 */
@ManagedBean
@RequestScoped
public class Empleado {
    private String nombre;
    private String cedula;
    private String telefono;
    private double salarioBase;
    private String puesto;
    private String tipoTrabajo;
    private int cantidadHoras;
    private int cantidadHorasExtras;
    private String asignacion;
    private String duracion;
    private int montoAsignacion;
    
    /**
     * Creates a new instance of Empleado
     */
    public Empleado() {
    }

    public int getMontoAsignacion() {
        return montoAsignacion;
    }

    public void setMontoAsignacion(int montoAsignacion) {
        this.montoAsignacion = montoAsignacion;
    }
    

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    

    public String getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }
    

    public int getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(int cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public int getCantidadHorasExtras() {
        return cantidadHorasExtras;
    }

    public void setCantidadHorasExtras(int cantidadHorasExtras) {
        this.cantidadHorasExtras = cantidadHorasExtras;
    }
    

    public String getTipoTrabajo() {
        return tipoTrabajo;
    }

    public void setTipoTrabajo(String tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    
    
}
