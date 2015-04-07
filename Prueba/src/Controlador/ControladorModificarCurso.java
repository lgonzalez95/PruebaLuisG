/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.RegistroCursos;
import Vista.PanelBotonesModificar;
import Vista.PanelBusquedaCurso;
import Vista.VentanaModificarCurso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Luis
 */
public class ControladorModificarCurso implements ActionListener {

    private VentanaModificarCurso ventanaModificarCurso;
    private PanelBusquedaCurso panelBusquedaCurso;
    private RegistroCursos registroCursos;
    private boolean busco = false;

    public ControladorModificarCurso(VentanaModificarCurso ventanaModificarCurso, PanelBusquedaCurso panelBusquedaCurso, RegistroCursos registroCursos) {
        this.ventanaModificarCurso = ventanaModificarCurso;
        this.panelBusquedaCurso = panelBusquedaCurso;
        this.registroCursos = registroCursos;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesModificar.BOTON_BUSCAR)) {
            if (!panelBusquedaCurso.getSiglas().equalsIgnoreCase("")) {
                if (registroCursos.verificarCurso(panelBusquedaCurso.getSiglas()) == true) {
                    panelBusquedaCurso.establecerNombre(registroCursos.retornarNombre(panelBusquedaCurso.getSiglas()));
                    panelBusquedaCurso.establecerCreditos(registroCursos.retornarCreditos(panelBusquedaCurso.getSiglas()));
                    panelBusquedaCurso.desHabilitarSiglas();
                    busco = true;
                } else {
                    panelBusquedaCurso.msjCursoNoEncontrado();
                    panelBusquedaCurso.borrarTxt();
                }
            } else {
                panelBusquedaCurso.msjDigiteSiglas();
                panelBusquedaCurso.borrarTxt();
            }
        }
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesModificar.BOTON_MODIFICAR)) {
            if (registroCursos.verificarCurso(panelBusquedaCurso.getSiglas()) == true) {
                if (busco == true) {
                    if (panelBusquedaCurso.busquedaRealizada() == true) {
                        if (panelBusquedaCurso.verificarEntero() == true) {
                            registroCursos.modificarNombre(panelBusquedaCurso.getSiglas(), panelBusquedaCurso.getNombre(), Integer.parseInt(panelBusquedaCurso.getCreditos()));
                            panelBusquedaCurso.msjModificadoExitoso();
                            panelBusquedaCurso.borrarTxt();
                            panelBusquedaCurso.habilitarSiglas();
                            busco = false;
                        } else {
                            panelBusquedaCurso.msjNoEsEntero();

                        }
                    } else {
                        panelBusquedaCurso.ingreseDatos();
                    }
                } else {
                    panelBusquedaCurso.msjRealiceBusqueda();
                }
            } else {
                panelBusquedaCurso.msjDigiteSiglas();
                panelBusquedaCurso.borrarTxt();
            }
        }

        if (evento.getActionCommand()
                .equalsIgnoreCase(PanelBotonesModificar.BOTON_CANCELAR)) {
            panelBusquedaCurso.borrarTxt();
            busco = false;
            ventanaModificarCurso.setVisible(false);
        }
    }

}
