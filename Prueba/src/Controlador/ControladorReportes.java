/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.RegistroMatricula;
import Vista.PanelBotonesConfirmar;
import Vista.PanelReportes;
import Vista.VentanaReportes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Luis
 */
public class ControladorReportes implements ActionListener {

    private RegistroMatricula registroMatricula;
    private VentanaReportes ventanaReportes;
    private PanelReportes panelReportes;

    public ControladorReportes(RegistroMatricula registroMatricula, VentanaReportes ventanaReportes, PanelReportes panelReportes) {
        this.registroMatricula = registroMatricula;
        this.ventanaReportes = ventanaReportes;
        this.panelReportes = panelReportes;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesConfirmar.BOTON_ACEPTAR)) {
            if (!panelReportes.getCarnet().equalsIgnoreCase("")) {
                if (registroMatricula.verificarMatricula(panelReportes.getCarnet()) == true) {
                    panelReportes.setCreditos(registroMatricula.mostrarCreditosMatriculados(panelReportes.getCarnet()));
                    panelReportes.setDatosJtextArea(registroMatricula.mostrarCursosMatriculados(panelReportes.getCarnet()));
                    panelReportes.setNombre(registroMatricula.retornarNombre(panelReportes.getCarnet()));
                } else {
                    panelReportes.msjNoTieneMatricula();
                }
            } else {
                panelReportes.msjDigiteCarnet();
            }
        }
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesConfirmar.BOTON_CANCELAR)) {

            ventanaReportes.setVisible(false);
        }
    }

}
