/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class RegistroEstudiantes {

    private ArrayList<Estudiante> arrayEstudiantes;

    public RegistroEstudiantes() {
        arrayEstudiantes = new ArrayList();
    }

    public void setEstudiante(Estudiante estudiante) {
        arrayEstudiantes.add(estudiante);
    }

    public String getInformacion() {
        String datos = "";
        for (Estudiante estudiante : arrayEstudiantes) {
            datos += estudiante.toString() + "\n\n";
        }
        return datos;
    }

    public boolean verificarEstudiante(String carnet) {
        boolean encontro = false;
        for (int contador = 0; contador < arrayEstudiantes.size(); contador++) {
            if (carnet.equalsIgnoreCase(arrayEstudiantes.get(contador).getCarnet())) {
                encontro = true;
            }

        }
        return encontro;
    }

    public String retornarNombre(String carnet) {
        String encontro = "";
        for (int contador = 0; contador < arrayEstudiantes.size(); contador++) {
            if (carnet.equalsIgnoreCase(arrayEstudiantes.get(contador).getCarnet())) {
                encontro = arrayEstudiantes.get(contador).getNombre();
            }
        }
        return encontro;
    }

    public void modificarNombre(String carnet, String nombre) {
        for (int contador = 0; contador < arrayEstudiantes.size(); contador++) {
            if (carnet.equalsIgnoreCase(arrayEstudiantes.get(contador).getCarnet())) {
                arrayEstudiantes.get(contador).setNombre(nombre);
            }
        }
    }

    public void eliminarEstudiante(String carnet) {
        for (int contador = 0; contador < arrayEstudiantes.size(); contador++) {
            if (carnet.equalsIgnoreCase(arrayEstudiantes.get(contador).getCarnet())) {
                arrayEstudiantes.remove(contador);
            }

        }
    }

    public String retornarEstudiante(String carnet) {
        String encontro = "";
        for (int contador = 0; contador < arrayEstudiantes.size(); contador++) {
            if (carnet.equalsIgnoreCase(arrayEstudiantes.get(contador).getCarnet())) {
                encontro = arrayEstudiantes.get(contador).toString() + "\n";
            }
        }
        return encontro;
    }

    public boolean verificarArrayVacio() {
        boolean variable = false;
        if (arrayEstudiantes.isEmpty()) {
            variable = true;
        }

        return variable;
    }

    public int retornarTamano() {
        int tamano = 0;
        tamano = arrayEstudiantes.size();
        return tamano;
    }

    public String retornarNombreCombo(int contador) {
        String encontro = "";
        encontro = arrayEstudiantes.get(contador).getNombre();
        return encontro;
    }
}
