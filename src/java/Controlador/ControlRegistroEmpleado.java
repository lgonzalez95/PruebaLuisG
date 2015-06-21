/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.RegistroEmpleado;
import java.io.File;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Luis
 */
@ManagedBean
@RequestScoped
public class ControlRegistroEmpleado {

    @ManagedProperty(value = "#{empleado}")
    private Empleado empleado;
    private String cedula;

    /**
     * Creates a new instance of ControlRegistroEmpleado
     */
    public ControlRegistroEmpleado() {
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public RegistroEmpleado getRegistro() {
        File file = new File("empleado.xml");
        RegistroEmpleado registroEmpleado = null;
        if (file.exists()) {
            registroEmpleado = RegistroEmpleado.abrirDocumento("empleado.xml");
        } else {
            registroEmpleado = RegistroEmpleado.crearDocumento("empleado.xml");
        }
        return registroEmpleado;
    }

    public String agregarEmpleado() {
        RegistroEmpleado registroEmpleado = this.getRegistro();
        registroEmpleado.agregarEmpleado(empleado);
        return "sesionAdministrador";
    }

    public void buscar() {
        RegistroEmpleado registroEmpleado = this.getRegistro();
        registroEmpleado.buscarEmpleado(getCedula(), empleado);
    }

    public String modificar() {

        RegistroEmpleado registroEmpleado = this.getRegistro();
        registroEmpleado.modificarEmpleado(empleado, getCedula());
        return "sesionAdministrador";
    }

    public String eliminar() {

        RegistroEmpleado registroEmpleado = this.getRegistro();
        registroEmpleado.eliminar(registroEmpleado.buscarEmpleado2(cedula), empleado, this);
        return "sesionAdministrador";
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

}
