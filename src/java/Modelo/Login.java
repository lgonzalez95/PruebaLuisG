/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Luis
 */
@ManagedBean
@RequestScoped
public class Login {
    private String usuario;
    private String contraseña;

    /**
     * Creates a new instance of Login
     */
    public Login() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public String verificarLogueo(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Inicio de sesion realizado", ""));
        if(getUsuario().equalsIgnoreCase("admin")&& getContraseña().equalsIgnoreCase("adminin")){
         return "sesionAdministrador";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
        }
        
        return "index";
    }
}
