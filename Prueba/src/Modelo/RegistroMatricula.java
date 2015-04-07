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
public class RegistroMatricula {
    private ArrayList<Matricula> arrayMatricula;

    public RegistroMatricula() {
        arrayMatricula = new ArrayList();
    }

    public void setMatricula(Matricula matricula) {
        arrayMatricula.add(matricula);
    }
    public String getInformacion() {
        String datos = "";
        for (Matricula matricula : arrayMatricula) {
            datos += matricula.toString() + "\n\n";
        }
        return datos;
    }

    public boolean verificarMatricula(String carnet) {
        boolean encontro = false;
        for (int contador = 0; contador < arrayMatricula.size(); contador++) {
            if (carnet.equalsIgnoreCase(arrayMatricula.get(contador).getCarnetEstudiante())) {
                encontro = true;
            }

        }
        return encontro;
    }
    
    public boolean verificarCantidadMatricula(String carnet,String nombreCurso){
        boolean puedeMatricular=true;
        int contador=0;
        for (int i = 0; i < arrayMatricula.size(); i++) {
            if(carnet.equalsIgnoreCase(arrayMatricula.get(i).getCarnetEstudiante())&
               nombreCurso.equalsIgnoreCase(arrayMatricula.get(i).getNombreCurso())){
                contador++;
            }
            if(contador>=1){
                puedeMatricular=false;
            }
        }
        return puedeMatricular;
    }
    public String mostrarCursosMatriculados(String carnet) {
        String datos="";
        for (int contador = 0; contador < arrayMatricula.size(); contador++) {
            if (carnet.equalsIgnoreCase(arrayMatricula.get(contador).getCarnetEstudiante())) {
                datos+="Curso: "+arrayMatricula.get(contador).getNombreCurso() +"\nCreditos: "+arrayMatricula.get(contador).getCreditosCurso()+"\nSiglas: "+arrayMatricula.get(contador).getSiglasCurso()+"\n\n";
            }

        }
        return datos;
    }
    public int mostrarCreditosMatriculados(String carnet) {
        int creditos=0;
        for (int contador = 0; contador < arrayMatricula.size(); contador++) {
            if (carnet.equalsIgnoreCase(arrayMatricula.get(contador).getCarnetEstudiante())) {
                creditos+=arrayMatricula.get(contador).getCreditosCurso();
            }

        }
        return creditos;
    }
     public String retornarNombre(String carnet) {
        String encontro = "";
        for (int contador = 0; contador < arrayMatricula.size(); contador++) {
            if (carnet.equalsIgnoreCase(arrayMatricula.get(contador).getCarnetEstudiante())) {
                encontro = arrayMatricula.get(contador).getNombreEstudiante();
            }
        }
        return encontro;
    }
}
