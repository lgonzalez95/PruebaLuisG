/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Estudiante;
import Modelo.RegistroEstudiantes;
import Vista.PanelBotonesConfirmar;
import Vista.PanelDatosEstudiante;
import Vista.VentanaRegistroEstudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Luis
 */
public class ControladorRegistrarEstudiantes implements ActionListener {

   private  VentanaRegistroEstudiante ventanaRegistro;
   private  PanelDatosEstudiante panelDatosEstudiante;
   private  RegistroEstudiantes registroEstudiantes;

    public ControladorRegistrarEstudiantes(RegistroEstudiantes registroEstudiante, VentanaRegistroEstudiante ventanaRegistr, PanelDatosEstudiante panelD) {
        ventanaRegistro = ventanaRegistr;
        panelDatosEstudiante = panelD;
        registroEstudiantes = registroEstudiante;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesConfirmar.BOTON_ACEPTAR)) {
            if (!panelDatosEstudiante.getNombre().equalsIgnoreCase("")
                    && !panelDatosEstudiante.getCarnet().equalsIgnoreCase("")) {

                if (registroEstudiantes.verificarEstudiante(panelDatosEstudiante.getCarnet()) == false) {
                    Estudiante estudiante;
                    estudiante = new Estudiante(panelDatosEstudiante.getNombre(), panelDatosEstudiante.getCarnet());
                    registroEstudiantes.setEstudiante(estudiante);
                    panelDatosEstudiante.msjAgregadoExito();
                    panelDatosEstudiante.borrarTxt();
                } else {
                    panelDatosEstudiante.msjEstYaRegistrado();
                    panelDatosEstudiante.borrarTxt();
                }
            } else {
                panelDatosEstudiante.msjPedirTodosDatos();
            }
        }
        if (evento.getActionCommand().equalsIgnoreCase(PanelBotonesConfirmar.BOTON_CANCELAR)) {
            ventanaRegistro.setInvisible();
            panelDatosEstudiante.borrarTxt();
        }
    }

}
