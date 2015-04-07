/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.PanelBusquedaEstudiante;
import Vista.VentanaModificarEstudiante;
import Modelo.RegistroEstudiantes;
import Vista.PanelBotonesModificar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Luis
 */
public class ControladorModificarEstudiante implements ActionListener {

    private VentanaModificarEstudiante VentanaModificar;
    private PanelBusquedaEstudiante panelBusquedaEstudiante;
    private RegistroEstudiantes registroEstudiantes;

    public ControladorModificarEstudiante(RegistroEstudiantes registroEstudiante, VentanaModificarEstudiante ventanaModif, PanelBusquedaEstudiante panelBusqueda) {
        VentanaModificar = ventanaModif;
        panelBusquedaEstudiante = panelBusqueda;
        registroEstudiantes = registroEstudiante;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesModificar.BOTON_BUSCAR)) {
            if (!panelBusquedaEstudiante.getCarnet().equalsIgnoreCase("")) {

                if (registroEstudiantes.verificarEstudiante(panelBusquedaEstudiante.getCarnet()) == true) {
                    panelBusquedaEstudiante.establecerNombre(registroEstudiantes.retornarNombre(panelBusquedaEstudiante.getCarnet()));
                    panelBusquedaEstudiante.deshabilitarCarnet();
                } else {
                    panelBusquedaEstudiante.msjEstNoEncontrado();
                    panelBusquedaEstudiante.borrarTxt();
                }
            } else {
                panelBusquedaEstudiante.msjDigiteCarnet();
            }
        }
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesModificar.BOTON_MODIFICAR)) {
            if (registroEstudiantes.verificarEstudiante(panelBusquedaEstudiante.getCarnet()) == true) {
                registroEstudiantes.modificarNombre(panelBusquedaEstudiante.getCarnet(), panelBusquedaEstudiante.getNombre());
                panelBusquedaEstudiante.msjModificadoExitoso();
                panelBusquedaEstudiante.habilitarCarnet();
                panelBusquedaEstudiante.borrarTxt();
            } else {
                panelBusquedaEstudiante.msjDigiteCarnet();
            }

        }
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesModificar.BOTON_CANCELAR)) {
            panelBusquedaEstudiante.borrarTxt();
            panelBusquedaEstudiante.habilitarCarnet();
            VentanaModificar.setInvisible();
        }

    }

}
