/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.RegistroEstudiantes;
import Vista.PanelBotonesEliminar;
import Vista.PanelBusquedaEstudiante;
import Vista.VentanaEliminarEstudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Luis
 */
public class ControladorEliminarEstudiante implements ActionListener {

    private RegistroEstudiantes registroEstudiantes;
    private VentanaEliminarEstudiante ventanaEliminar;
    private PanelBusquedaEstudiante panelBusquedaEstudiante;

    public ControladorEliminarEstudiante(RegistroEstudiantes registroEstudiante, VentanaEliminarEstudiante ventanaElimina, PanelBusquedaEstudiante panelBusquedaEstudiant) {
        ventanaEliminar = ventanaElimina;
        panelBusquedaEstudiante = panelBusquedaEstudiant;
        registroEstudiantes = registroEstudiante;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesEliminar.BOTON_BUSCAR)) {
            if (!panelBusquedaEstudiante.getCarnet().equalsIgnoreCase("")) {
                if (registroEstudiantes.verificarEstudiante(panelBusquedaEstudiante.getCarnet()) == true) {
                    panelBusquedaEstudiante.establecerNombre(registroEstudiantes.retornarNombre(panelBusquedaEstudiante.getCarnet()));
                    panelBusquedaEstudiante.deshabilitarJtext();
                } else {
                    panelBusquedaEstudiante.msjEstNoEncontrado();
                    panelBusquedaEstudiante.borrarTxt();
                }
            } else {
                panelBusquedaEstudiante.msjDigiteCarnet();
                panelBusquedaEstudiante.borrarTxt();
            }
        }
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesEliminar.BOTON_ELIMINAR)) {
            if (registroEstudiantes.verificarEstudiante(panelBusquedaEstudiante.getCarnet()) == true) {
                registroEstudiantes.eliminarEstudiante(panelBusquedaEstudiante.getCarnet());
                panelBusquedaEstudiante.msjEliminado();
                panelBusquedaEstudiante.borrarTxt();
                panelBusquedaEstudiante.habilitarNombre();
            } else {
                panelBusquedaEstudiante.msjNoEntrado();
                panelBusquedaEstudiante.borrarTxt();
            }
        }
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesEliminar.BOTON_CANCELAR)) {
            ventanaEliminar.setInvisible();
            panelBusquedaEstudiante.borrarTxt();
            panelBusquedaEstudiante.habilitarNombre();
        }
    }

}
