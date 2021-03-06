/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Cursos;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class PanelDatosCurso extends javax.swing.JPanel {

    /**
     * Creates new form PanelDatosCurso
     */
    public PanelDatosCurso() {
        initComponents();
    }

    public boolean verificarEntero() {
        try {
            Integer.parseInt(getCreditos());
            return true;
        } catch (NumberFormatException variable) {
            return false;
        }
    }

    public String getNombre() {
        return jtNombre.getText();
    }

    public String getSiglas() {
        return jtSiglas.getText();
    }

    public String getCreditos() {
        return jtCreditos.getText();
    }

    public void borrarTxt() {
        jtNombre.setText("");
        jtSiglas.setText("");
        jtCreditos.setText("");
    }

    public void msjAgregadoExito() {
        JOptionPane.showMessageDialog(null, "El curso se agregó exitosamente");
    }

    public void msjCursoYaRegistrado() {
        JOptionPane.showMessageDialog(null, "Ya existe un curso con esta sigla", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public void msjPedirTodosDatos() {
        JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos del curso", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public Cursos getCurso() {
        Cursos cursos = new Cursos(jtNombre.getText(), jtSiglas.getText(), Integer.parseInt(jtCreditos.getText()));
        return cursos;
    }

    public void noEsEntero() {
        JOptionPane.showMessageDialog(null, "Ingrese créditos válidos", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public boolean verificarDatos() {
        boolean variable = false;
        if (!jtNombre.getText().equalsIgnoreCase("")
                & !jtCreditos.getText().equalsIgnoreCase("")
                & !jtSiglas.getText().equalsIgnoreCase("")) {
            variable = true;
        }
        return variable;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbRegistrarCurso = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jlSiglas = new javax.swing.JLabel();
        jlCreditos = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jtSiglas = new javax.swing.JTextField();
        jtCreditos = new javax.swing.JTextField();

        lbRegistrarCurso.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lbRegistrarCurso.setText("Registrar curso");

        jlNombre.setText("Nombre");

        jlSiglas.setText("Siglas");

        jlCreditos.setText("Créditos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(137, Short.MAX_VALUE)
                .addComponent(lbRegistrarCurso)
                .addGap(134, 134, 134))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jlSiglas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                    .addComponent(jlCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtSiglas, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbRegistrarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSiglas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtSiglas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtCreditos))
                .addGap(0, 14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlCreditos;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlSiglas;
    private javax.swing.JTextField jtCreditos;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtSiglas;
    private javax.swing.JLabel lbRegistrarCurso;
    // End of variables declaration//GEN-END:variables
}
