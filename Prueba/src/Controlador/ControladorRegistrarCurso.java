/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.RegistroCursos;
import Vista.PanelBotonesConfirmar;
import Vista.PanelDatosCurso;
import Vista.VentanaRegistroCurso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Luis
 */
public class ControladorRegistrarCurso implements ActionListener {

    private VentanaRegistroCurso ventanaRegistroCurso;
    private RegistroCursos registroCursos;
    private PanelDatosCurso panelDatosCurso;

    /**
     *
     * @param ventanaRegistroCurso
     * @param registroCursos
     * @param panelDatosCurso
     */
    public ControladorRegistrarCurso(VentanaRegistroCurso ventanaRegistroCurso, RegistroCursos registroCursos, PanelDatosCurso panelDatosCurso) {
        this.ventanaRegistroCurso = ventanaRegistroCurso;
        this.registroCursos = registroCursos;
        this.panelDatosCurso = panelDatosCurso;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesConfirmar.BOTON_ACEPTAR)) {
            if (panelDatosCurso.verificarDatos() == true) {
                if (panelDatosCurso.verificarEntero() == true) {
                    if (registroCursos.verificarCurso(panelDatosCurso.getSiglas()) == false) {
                        registroCursos.setCursos(panelDatosCurso.getCurso());
                        panelDatosCurso.msjAgregadoExito();
                        panelDatosCurso.borrarTxt();
                    } else {
                        panelDatosCurso.msjCursoYaRegistrado();
                        panelDatosCurso.borrarTxt();
                    }
                } else {
                    panelDatosCurso.noEsEntero();
                }
            } else {
                panelDatosCurso.msjPedirTodosDatos();
            }
        }
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesConfirmar.BOTON_CANCELAR)) {
            panelDatosCurso.borrarTxt();
            ventanaRegistroCurso.setVisible(false);
        }

    }

}
