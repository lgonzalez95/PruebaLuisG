/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.RegistroCursos;
import Modelo.RegistroEstudiantes;
import Modelo.RegistroMatricula;
import Vista.PanelBotonesMatricula;
import Vista.PanelMatricula;
import Vista.VentanaMatricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Luis
 */
public class ControladorMatricula implements ActionListener {

   private  VentanaMatricula ventanaMatricula;
   private  RegistroCursos registroCursos;
    private RegistroEstudiantes registroEstudiantes;
    private PanelMatricula panelMatricula;
    private RegistroMatricula registroMatricula;

    public ControladorMatricula(RegistroMatricula registroMatricula, VentanaMatricula ventanaMatricula, RegistroCursos registroCursos, RegistroEstudiantes registroEstudiantes, PanelMatricula panelMatricula) {
        this.ventanaMatricula = ventanaMatricula;
        this.registroCursos = registroCursos;
        this.registroEstudiantes = registroEstudiantes;
        this.panelMatricula = panelMatricula;
        this.registroMatricula = registroMatricula;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesMatricula.BOTON_BUSCAR)) {
            if (!panelMatricula.getCarnet().equalsIgnoreCase("")) {
                if (registroEstudiantes.verificarEstudiante(panelMatricula.getCarnet()) == true) {
                    panelMatricula.consultaEstudiante(registroEstudiantes);
                    panelMatricula.desHabilitarCarnet();
                } else {
                    panelMatricula.msjEstNoEncontrado();
                    panelMatricula.borrarTxt();
                }
            } else {
                panelMatricula.msjDigiteCarntet();
                panelMatricula.borrarTxt();
            }
        }

        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesMatricula.BOTON_MATRICULAR)) {
            if (!panelMatricula.retornarNombre().equalsIgnoreCase("")) {
                if (panelMatricula.verificarComboVacio()==false) {
                    //
                    if (registroMatricula.verificarCantidadMatricula(panelMatricula.getCarnet(), panelMatricula.retornarCursoSeleccionado()) == true) {
                        registroMatricula.setMatricula(panelMatricula.retornarMatricula(registroCursos));
                        panelMatricula.msjMatriculaConsolidada();
                        panelMatricula.habilitarCarnet();
                        panelMatricula.borrarTxt();
                    } else {
                        panelMatricula.msjYaEstaEnElCurso();
                        panelMatricula.habilitarCarnet();
                        panelMatricula.borrarTxt();
                    }
                } else {
                    panelMatricula.msjNoHayCursos();
                }

            } else {
                panelMatricula.msjRealiceBusqueda();
            }
        }
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesMatricula.BOTON_CANCELAR)) {
            panelMatricula.borrarTxt();
            panelMatricula.habilitarCarnet();
            ventanaMatricula.setVisible(false);
        }
    }

}
