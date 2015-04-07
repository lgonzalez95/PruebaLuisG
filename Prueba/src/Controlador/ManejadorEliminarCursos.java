/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.RegistroCursos;
import Vista.PanelBotonesEliminar;
import Vista.PanelBusquedaCurso;
import Vista.VentanaEliminarCursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Luis
 */
public class ManejadorEliminarCursos implements ActionListener {

    private VentanaEliminarCursos ventanaEliminarCursos;
    private PanelBusquedaCurso panelBusquedaCurso;
    private RegistroCursos registroCursos;
    private boolean busco = false;

    public ManejadorEliminarCursos(VentanaEliminarCursos ventanaEliminarCursos, PanelBusquedaCurso panelBusquedaCurso, RegistroCursos registroCursos) {
        this.ventanaEliminarCursos = ventanaEliminarCursos;
        this.panelBusquedaCurso = panelBusquedaCurso;
        this.registroCursos = registroCursos;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesEliminar.BOTON_BUSCAR)) {
            if (!panelBusquedaCurso.getSiglas().equalsIgnoreCase("")) {
                if (registroCursos.verificarCurso(panelBusquedaCurso.getSiglas()) == true) {
                    panelBusquedaCurso.establecerCreditos(registroCursos.retornarCreditos(panelBusquedaCurso.getSiglas()));
                    panelBusquedaCurso.establecerNombre(registroCursos.retornarNombre(panelBusquedaCurso.getSiglas()));
                    busco = true;
                    panelBusquedaCurso.desHabilitarSiglas();
                    panelBusquedaCurso.deshabilitarNombreCreditos();
                } else {
                    panelBusquedaCurso.msjCursoNoEncontrado();
                    panelBusquedaCurso.borrarTxt();
                }
            } else {
                panelBusquedaCurso.msjRealiceBusqueda();
            }
        }
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesEliminar.BOTON_ELIMINAR)) {
            if (busco == true) {
                if (registroCursos.verificarCurso(panelBusquedaCurso.getSiglas()) == true) {
                    registroCursos.eliminarCurso(panelBusquedaCurso.getSiglas());
                    panelBusquedaCurso.msjEliminarExitoso();
                    panelBusquedaCurso.borrarTxt();
                    panelBusquedaCurso.habilitarNombreCreditos();
                    panelBusquedaCurso.habilitarSiglas();
                } else {
                    panelBusquedaCurso.msjCursoNoEncontrado();
                }
            } else {
                panelBusquedaCurso.msjRealiceBusqueda();
            }
        }
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesEliminar.BOTON_CANCELAR)) {
            ventanaEliminarCursos.setVisible(false);
            panelBusquedaCurso.habilitarNombreCreditos();
            panelBusquedaCurso.habilitarSiglas();
            panelBusquedaCurso.borrarTxt();
        }
    }
}
