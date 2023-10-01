/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo49.Vistas;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidadgrupo49.AccesoADatos.AlumnoData;
import universidadgrupo49.AccesoADatos.InscripcionData;
import universidadgrupo49.Entidades.Alumno;
import universidadgrupo49.Entidades.Inscripcion;

/**
 *
 * @author Juan Manuel
 */
public class CargaDeNotasVista extends javax.swing.JInternalFrame {

    private AlumnoData ad = new AlumnoData();
    private Alumno alumno = null;

    private InscripcionData ins = new InscripcionData();
    private List<Inscripcion> inscripciones = new ArrayList<>();

    private DefaultTableModel modelo;

    public CargaDeNotasVista() {
        initComponents();

        modelo = new DefaultTableModel();

        armarCabeceraTabla();
    }

    private void armarCabeceraTabla() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("Código");                             //
        filaCabecera.add("Nombre");                         //titulos tabla-*-
        filaCabecera.add("Nota");                            //

        for (Object rec : filaCabecera) {
            modelo.addColumn(rec);
        }

        jTListaInscripciones.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTListaInscripciones = new javax.swing.JTable();
        jBSalir = new javax.swing.JButton();
        jTFDni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jBBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jBModificarNota = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel1.setText("Carga de Notas");

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setText("Buscar Alumno");

        jTListaInscripciones.setBackground(new java.awt.Color(7, 185, 250));
        jTListaInscripciones.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jTListaInscripciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Nota"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTListaInscripciones);

        jBSalir.setBackground(new java.awt.Color(0, 204, 204));
        jBSalir.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jBSalir.setForeground(new java.awt.Color(0, 0, 0));
        jBSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadgrupo49/recursos/salida.png"))); // NOI18N
        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jTFDni.setBackground(new java.awt.Color(7, 185, 250));
        jTFDni.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jTFDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFDniKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setText("DNI:");

        jBBuscar.setBackground(new java.awt.Color(41, 84, 171));
        jBBuscar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jBBuscar.setForeground(new java.awt.Color(0, 0, 0));
        jBBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadgrupo49/recursos/lupa.png"))); // NOI18N
        jBBuscar.setText("Buscar");
        jBBuscar.setToolTipText("Ingrese el DNI del Alumno");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setText("Inscripciones:");

        jBModificarNota.setBackground(new java.awt.Color(35, 153, 67));
        jBModificarNota.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jBModificarNota.setForeground(new java.awt.Color(0, 0, 0));
        jBModificarNota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadgrupo49/recursos/editar.png"))); // NOI18N
        jBModificarNota.setText("Modificar nota");
        jBModificarNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificarNotaActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(157, 161, 158));
        jButton1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadgrupo49/recursos/escoba.png"))); // NOI18N
        jButton1.setText("Limpiar Pantalla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBModificarNota)
                        .addGap(52, 52, 52)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBSalir))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTFDni, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBBuscar))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jBBuscar))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBModificarNota)
                    .addComponent(jButton1)
                    .addComponent(jBSalir))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void borrarFilaTabla() {

        int indice = modelo.getRowCount() - 1;

        for (int i = indice; i >= 0; i--) {
            modelo.removeRow(i);

        }
    }
    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed

        try {
            borrarFilaTabla();
            int dni = Integer.parseInt(jTFDni.getText());
            alumno = ad.buscarAlumnoDNI(dni, true);
            if (alumno != null) {

                inscripciones = ins.obtenerInscripcionesPorAlumno(alumno.getIdAlumno());
                for (Inscripcion inscrip : inscripciones) {
                    modelo.addRow(new Object[]{inscrip.getMateria().getIdMateria(), inscrip.getMateria().getNombre(), inscrip.getNota()});
                }
//                JOptionPane.showMessageDialog(this, "Alumno encontrado");
            } else {
                JOptionPane.showMessageDialog(this, "Alumno no encontrado");
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Solo se aceptan números en el campo DNI");
        }


    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jBModificarNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificarNotaActionPerformed
        int filaSect = jTListaInscripciones.getSelectedRow();
        double nuevaNota = 0;
        try {
            int idMateria = (Integer) modelo.getValueAt(filaSect, 0);
            while (nuevaNota <= 0 || nuevaNota > 10) {
                nuevaNota = Double.parseDouble(JOptionPane.showInputDialog(this, "Ingrese la nueva nota"));
                if (nuevaNota <= 0 || nuevaNota > 10) {
                    JOptionPane.showMessageDialog(this, "Ingrese una nota válida");
                    
                } else {
                    ins.actualizarNota(alumno.getIdAlumno(), idMateria, nuevaNota);
                    jBBuscar.doClick();
                    JOptionPane.showMessageDialog(this, "La nueva nota es: " + nuevaNota);

                }

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Debe elegir una materia");
        }

    }//GEN-LAST:event_jBModificarNotaActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jTFDniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDniKeyPressed
                                        
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jBBuscar.doClick();
        }    }//GEN-LAST:event_jTFDniKeyPressed

             // LIMPIAR PANTALLA DNI- JTABLE -*-
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        limpiarPantalla();
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBModificarNota;
    private javax.swing.JButton jBSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFDni;
    private javax.swing.JTable jTListaInscripciones;
    // End of variables declaration//GEN-END:variables


public void limpiarPantalla() {
        jTFDni.setText("");
      //  jTListaInscripciones.setText(""); 
        DefaultTableModel model = (DefaultTableModel) jTListaInscripciones.getModel();
        model.setRowCount(0);
        
    }

}
