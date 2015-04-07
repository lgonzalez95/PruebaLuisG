/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.RegistroCursos;
import Vista.PanelConsultarCursos;
import Vista.VentanaConsultarCursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Luis
 */
public class ControladorConsultaCursos implements ActionListener{
    private RegistroCursos registroCursos;
    private PanelConsultarCursos panelConsultarCursos;
    private VentanaConsultarCursos ventanaConsultarCursos;

    public ControladorConsultaCursos(RegistroCursos registroCursos, PanelConsultarCursos panelConsultarCursos, VentanaConsultarCursos ventanaConsultarCursos) {
        this.registroCursos = registroCursos;
        this.panelConsultarCursos = panelConsultarCursos;
        this.ventanaConsultarCursos = ventanaConsultarCursos;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent evento) {
       if(evento.getActionCommand().equalsIgnoreCase(PanelConsultarCursos.BOTON_CONSULTAR_SIGLA)){
            if(!panelConsultarCursos.getSiglas().equalsIgnoreCase("")){
                if(registroCursos.verificarCurso(panelConsultarCursos.getSiglas())==true){
                    panelConsultarCursos.consultaCurso(registroCursos);
                }else{
                    panelConsultarCursos.msjCursoNoEncontrado();
                }
            }else{
                panelConsultarCursos.msjIngreseSiglas();
            }
       }
       if(evento.getActionCommand().equalsIgnoreCase(PanelConsultarCursos.BOTON_CONSULTAR_CURSOS)){
            if(panelConsultarCursos.getSiglas().equalsIgnoreCase("")){
                if(registroCursos.verificarArrayVacio()==false){
                    panelConsultarCursos.consultaCursos(registroCursos);
                }else{
                    panelConsultarCursos.msjArrayVacio();
                }
            }else{
                panelConsultarCursos.msjBorraSiglas();
            }
       }
       if(evento.getActionCommand().equalsIgnoreCase(PanelConsultarCursos.BOTON_BORRAR)){
            panelConsultarCursos.BorrarTxt();
       }
       if(evento.getActionCommand().equalsIgnoreCase(PanelConsultarCursos.BOTON_CANCELAR)){
           panelConsultarCursos.BorrarTxt();
           ventanaConsultarCursos.setVisible(false);
       }
    }
    
}
