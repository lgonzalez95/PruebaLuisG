/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.RegistroEstudiantes;
import Vista.PanelConsultarEstudiantes;
import Vista.VentanaConsultarEstudiantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Luis
 */
public class ControladorConsultarEstudiantes implements ActionListener {

    private RegistroEstudiantes registroEstudiantes;
    private VentanaConsultarEstudiantes ventanaConsultarEstudiante;
    private PanelConsultarEstudiantes panelConsultarEstudiante;

    public ControladorConsultarEstudiantes(RegistroEstudiantes registroEstudiantes, VentanaConsultarEstudiantes ventanaConsultarEstudiante, PanelConsultarEstudiantes panelConsultarEstudiante) {
        this.registroEstudiantes = registroEstudiantes;
        this.ventanaConsultarEstudiante = ventanaConsultarEstudiante;
        this.panelConsultarEstudiante = panelConsultarEstudiante;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equalsIgnoreCase(PanelConsultarEstudiantes.BOTON_CONSULTAR_ESTUDIANTE)) {
            if (!panelConsultarEstudiante.getCarnet().equalsIgnoreCase("")) {
                if (registroEstudiantes.verificarEstudiante(panelConsultarEstudiante.getCarnet()) == true) {
                    panelConsultarEstudiante.consultaEstudiante(registroEstudiantes);
                } else {
                    panelConsultarEstudiante.msjNoEntrado();
                }
            } else {
                panelConsultarEstudiante.msjDigiteCarnet();
            }
        }
        if (evento.getActionCommand().equalsIgnoreCase(PanelConsultarEstudiantes.BOTON_CONSULTAR_ESTUDIANTES)) {
            if (panelConsultarEstudiante.getCarnet().equalsIgnoreCase("")) {
                if (registroEstudiantes.verificarArrayVacio() == false) {
                    panelConsultarEstudiante.consultaEstudiantes(registroEstudiantes);
                } else {
                    panelConsultarEstudiante.msjArrayVacio();
                }
            } else {
                panelConsultarEstudiante.msjBorraCarnet();
            }
        }
        if (evento.getActionCommand().equalsIgnoreCase(PanelConsultarEstudiantes.BOTON_BORRAR_DATOS)) {
            panelConsultarEstudiante.borrarDatos();
        }
        if (evento.getActionCommand().equalsIgnoreCase(PanelConsultarEstudiantes.BOTON_CANCELAR)) {
            panelConsultarEstudiante.borrarDatos();
            ventanaConsultarEstudiante.setVisible(false);
        }
    }

}
