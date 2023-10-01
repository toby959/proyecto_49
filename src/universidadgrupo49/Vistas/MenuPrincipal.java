
package universidadgrupo49.Vistas;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;


import universidadgrupo49.Entidades.Materia;


public class MenuPrincipal extends javax.swing.JFrame {

    public static List<Materia> materias = new ArrayList<>();
   
    
    public MenuPrincipal() {
     
        initComponents();
        this.setLocationRelativeTo(null);  // centrar pantalla
        this.setResizable(false);  // desactivar redimensionamiento
            
    }

     
     
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        ImageIcon icono = new ImageIcon(getClass().getResource("/universidadgrupo49/recursos/campus_ULP.jpg"));
        Image ulpImagen = icono.getImage();
        jdEscritorio = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){

                g.drawImage(ulpImagen,0,0,getWidth(), getHeight(),this);
            }

        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMFormAlumno = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMFormMateria = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMInscripciones = new javax.swing.JMenuItem();
        jMNotas = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMAlumnosPorMateria = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jdEscritorio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jdEscritorio.setPreferredSize(new java.awt.Dimension(1024, 600));
        jdEscritorio.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jdEscritorioAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jdEscritorioLayout = new javax.swing.GroupLayout(jdEscritorio);
        jdEscritorio.setLayout(jdEscritorioLayout);
        jdEscritorioLayout.setHorizontalGroup(
            jdEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1018, Short.MAX_VALUE)
        );
        jdEscritorioLayout.setVerticalGroup(
            jdEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 594, Short.MAX_VALUE)
        );

        jMenu1.setText("Alumno");

        jMFormAlumno.setText("Formulario de Alumno");
        jMFormAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMFormAlumnoActionPerformed(evt);
            }
        });
        jMenu1.add(jMFormAlumno);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Materia");

        jMFormMateria.setText("Formulario de Materia");
        jMFormMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMFormMateriaActionPerformed(evt);
            }
        });
        jMenu2.add(jMFormMateria);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Administración");

        jMInscripciones.setText("Manejo de Inscripciones");
        jMInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMInscripcionesActionPerformed(evt);
            }
        });
        jMenu5.add(jMInscripciones);

        jMNotas.setText("Manipulación de Notas");
        jMNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMNotasActionPerformed(evt);
            }
        });
        jMenu5.add(jMNotas);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Consultas");

        jMAlumnosPorMateria.setText("Alumnos por Materia");
        jMAlumnosPorMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMAlumnosPorMateriaActionPerformed(evt);
            }
        });
        jMenu6.add(jMAlumnosPorMateria);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jdEscritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jdEscritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMFormAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMFormAlumnoActionPerformed
        
        
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        AlumnoVista al = new AlumnoVista(); // instraciamos el objeto
        al.setVisible(true);
        al.getContentPane().setBackground(new Color(121, 148, 52)); // modificamos el color de fondo
        jdEscritorio.add(al);
        jdEscritorio.moveToFront(al);
      
     
      
    }//GEN-LAST:event_jMFormAlumnoActionPerformed

    private void jMFormMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMFormMateriaActionPerformed
        
        
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        MateriaVista mv = new MateriaVista(); // instraciamos el objeto
        mv.setVisible(true);
        mv.getContentPane().setBackground(new Color(121, 148, 52)); // modificamos el color de fondo
        jdEscritorio.add(mv);
        jdEscritorio.moveToFront(mv);
    }//GEN-LAST:event_jMFormMateriaActionPerformed

    private void jMInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMInscripcionesActionPerformed
        
        
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        FormularioDeInscripcion fi = new FormularioDeInscripcion();
        fi.setVisible(true);
        fi.getContentPane().setBackground(new Color(121, 148, 52)); // modificamos el color de fondo
        jdEscritorio.add(fi);
        jdEscritorio.moveToFront(fi);
    }//GEN-LAST:event_jMInscripcionesActionPerformed

    private void jMNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMNotasActionPerformed
        
        
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        CargaDeNotasVista cg = new CargaDeNotasVista();
        cg.setVisible(true);
        cg.getContentPane().setBackground(new Color(121, 148, 52)); // modificamos el color de fondo
        jdEscritorio.add(cg);
        jdEscritorio.moveToFront(cg);
    }//GEN-LAST:event_jMNotasActionPerformed

    private void jMAlumnosPorMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMAlumnosPorMateriaActionPerformed
        
        
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        ConsultaAlumnoPorMateriaVista vm = new ConsultaAlumnoPorMateriaVista();
        vm.setVisible(true);
        vm.getContentPane().setBackground(new Color(121, 148, 52)); // modificamos el color de fondo
        jdEscritorio.add(vm);
        jdEscritorio.moveToFront(vm);
    }//GEN-LAST:event_jMAlumnosPorMateriaActionPerformed

    private void jdEscritorioAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jdEscritorioAncestorAdded
        
  //El código es un método de manejo de eventos en Java Swing. Se llama cuando el
  //antepasado de un componente se agrega al contenedor. Este método lo genera 
  //automáticamente NetBeans IDE cuando se crea y agrega un nuevo JFrame al proyecto.
  
    }//GEN-LAST:event_jdEscritorioAncestorAdded

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMAlumnosPorMateria;
    private javax.swing.JMenuItem jMFormAlumno;
    private javax.swing.JMenuItem jMFormMateria;
    private javax.swing.JMenuItem jMInscripciones;
    private javax.swing.JMenuItem jMNotas;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JDesktopPane jdEscritorio;
    // End of variables declaration//GEN-END:variables
}
