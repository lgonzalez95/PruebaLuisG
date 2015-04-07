/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Luis
 */
public class Matricula {
    private String fecha;
    private String nombreEstudiante;
    private String carnetEstudiante;
    private String nombreCurso;
    private String siglasCurso;
    private int creditosCurso;

    public Matricula(String fecha, String nombreEstudiante, String carnetEstudiante, String nombreCurso, String siglasCurso, int creditosCurso) {
        this.fecha = fecha;
        this.nombreEstudiante = nombreEstudiante;
        this.carnetEstudiante = carnetEstudiante;
        this.nombreCurso = nombreCurso;
        this.siglasCurso = siglasCurso;
        this.creditosCurso = creditosCurso;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getCarnetEstudiante() {
        return carnetEstudiante;
    }

    public void setCarnetEstudiante(String carnetEstudiante) {
        this.carnetEstudiante = carnetEstudiante;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getSiglasCurso() {
        return siglasCurso;
    }

    public void setSiglasCurso(String siglasCurso) {
        this.siglasCurso = siglasCurso;
    }

    public int getCreditosCurso() {
        return creditosCurso;
    }

    public void setCreditosCurso(int creditosCurso) {
        this.creditosCurso = creditosCurso;
    }

    @Override
    public String toString() {
        return "Fecha " + fecha + "\nEstudiante " + nombreEstudiante + "\nCarnet del estudiante=" + carnetEstudiante + "\nMatriculado en " + nombreCurso + "\nSiglas del curso=" + siglasCurso + "\nCreditos de curso=" + creditosCurso+"\n";
    }
    
    
}
