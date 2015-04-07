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
public class RegistroCursos {

    private ArrayList<Cursos> arrayCursos;

    public RegistroCursos() {
        arrayCursos = new ArrayList();
    }

    public void setCursos(Cursos cursos) {
        arrayCursos.add(cursos);
    }

    public String getInformacion() {
        String datos = "";
        for (Cursos cursos : arrayCursos) {
            datos += cursos.toString() + "\n\n";
        }
        return datos;
    }

    public boolean verificarCurso(String siglas) {
        boolean encontro = false;
        for (int contador = 0; contador < arrayCursos.size(); contador++) {
            if (siglas.equalsIgnoreCase(arrayCursos.get(contador).getSiglas())) {
                encontro = true;
            }

        }
        return encontro;
    }

    public void modificarNombre(String siglas, String nombre, int creditos) {
        for (int contador = 0; contador < arrayCursos.size(); contador++) {
            if (siglas.equalsIgnoreCase(arrayCursos.get(contador).getSiglas())) {
                arrayCursos.get(contador).setNombre(nombre);
                arrayCursos.get(contador).setCreditos(creditos);
            }
        }
    }

    public String retornarNombre(String siglas) {
        String encontro = "";
        for (int contador = 0; contador < arrayCursos.size(); contador++) {
            if (siglas.equalsIgnoreCase(arrayCursos.get(contador).getSiglas())) {
                encontro = arrayCursos.get(contador).getNombre();
            }
        }
        return encontro;
    }

    public String retornarCreditos(String siglas) {
        String encontro = "";
        for (int contador = 0; contador < arrayCursos.size(); contador++) {
            if (siglas.equalsIgnoreCase(arrayCursos.get(contador).getSiglas())) {
                encontro = Integer.toString(arrayCursos.get(contador).getCreditos());
            }
        }
        return encontro;
    }

    public int retornarCreditosNombre(String nombre) {
        int encontro = 0;
        for (int contador = 0; contador < arrayCursos.size(); contador++) {
            if (nombre.equalsIgnoreCase(arrayCursos.get(contador).getNombre())) {
                encontro = arrayCursos.get(contador).getCreditos();
            }
        }
        return encontro;
    }

    public String retornarSiglas(String nombre) {
        String encontro = "";
        for (int contador = 0; contador < arrayCursos.size(); contador++) {
            if (nombre.equalsIgnoreCase(arrayCursos.get(contador).getNombre())) {
                encontro = arrayCursos.get(contador).getSiglas();
            }
        }
        return encontro;
    }

    public void eliminarCurso(String siglas) {
        for (int contador = 0; contador < arrayCursos.size(); contador++) {
            if (siglas.equalsIgnoreCase(arrayCursos.get(contador).getSiglas())) {
                arrayCursos.remove(contador);
            }

        }
    }

    public String retornarCurso(String siglas) {
        String encontro = "";
        for (int contador = 0; contador < arrayCursos.size(); contador++) {
            if (siglas.equalsIgnoreCase(arrayCursos.get(contador).getSiglas())) {
                encontro = arrayCursos.get(contador).toString() + "\n";
            }
        }
        return encontro;
    }

    public boolean verificarArrayVacio() {
        boolean variable = false;
        if (arrayCursos.isEmpty()) {
            variable = true;
        }

        return variable;
    }

    public int retornarTamano() {
        int tamano = 0;
        tamano = arrayCursos.size();
        return tamano;
    }

    public String retornarCursoCombo(int contador) {
        String encontro = "";
        encontro = arrayCursos.get(contador).getNombre();
        return encontro;
    }
}
