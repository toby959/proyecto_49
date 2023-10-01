package universidadgrupo49.Vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import universidadgrupo49.AccesoADatos.AlumnoData;
import universidadgrupo49.Entidades.Alumno;

public class AlumnoVista extends javax.swing.JInternalFrame {

    private AlumnoData ad = new AlumnoData();  // creamos variable de tipo 'AlumnoData'
    private Alumno alumno = null;               // inicializamos el alumno.

    public AlumnoVista() {
        initComponents();
        
//        ImageIcon ImageIcon = new ImageIcon("/universidadgrupo49.recursos/editar.png");   // Agrega un icono personalizado-*-
//        Icon icon = null;
   
//    ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("/recursos/editar.png"));



     //   UIManager.put("OptionPane.background", Color.blue);

     //   JOptionPane.showMessageDialog(null,"<html><p style=\" color: red; font: 35px; \" >Bienvenidos!!!</p></html>" , "ULP San Luis", JOptionPane.PLAIN_MESSAGE); //Mensaje saludo-*-  
                                          //"Bienvenidos!!"
      
                                          
                                         
//          JOptionPane optionPane = new JOptionPane();
//          JPanel panel = new JPanel();
//          panel.setBackground(Color.blue);

         
                  // PRUEBA  TUNNING JOPTIONPANE
                                    
        Color customColor = new Color(121, 148, 52); // custom color en RGB
                      
        JOptionPane optionPane = new JOptionPane();
        JPanel panel = new JPanel();
        Font customFont = new Font("Roboto", Font.BOLD, 26); 
        panel.setBackground(customColor);
        
        
        JLabel label = new JLabel("Bienvenidos!!!");
        
        label.setForeground(Color.black);
        
        label.setFont(customFont); // fuente custom etiqueta-*-
        panel.add(label);
        optionPane.setMessage(panel);
        optionPane.setMessageType(JOptionPane.PLAIN_MESSAGE);
        optionPane.setIcon(UIManager.getIcon("OptionPane.informationIcon")); // establezca el icono-*-
        ImageIcon icono = new ImageIcon(getClass().getResource("../recursos/ulp.png"));
        optionPane.setIcon(icono);
        JDialog dialog = optionPane.createDialog("ULP San Luis");
        dialog.setVisible(true);          

                  // --------------------------------
         
          
                                          
                
            // PROBLEMA PARA CUBRIR TODAS LAS CAJAS-*-
//          Color customColor = new Color(66, 212, 85); // red color in RGB
//          UIManager.put("OptionPane.background", customColor);
//          JOptionPane.showMessageDialog(null, "Welcome to my app!", "My App", JOptionPane.PLAIN_MESSAGE);
                                          
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jLAlumno = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFDocumento = new javax.swing.JTextField();
        jTFApellido = new javax.swing.JTextField();
        jTFNombre = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jDCFechaNacim = new com.toedter.calendar.JDateChooser();
        jBLimpiar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jRBEstado = new javax.swing.JRadioButton();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setClosable(true);
        setResizable(true);
        setVisible(true);

        jLAlumno.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLAlumno.setText("Alumno");

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setText("Documento");

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setText("Apellido");

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setText("Estado");

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setText("Fecha de Nacimiento");

        jTFDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFDocumentoKeyPressed(evt);
            }
        });

        jBBuscar.setBackground(new java.awt.Color(41, 84, 171));
        jBBuscar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jBBuscar.setForeground(new java.awt.Color(0, 0, 0));
        jBBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadgrupo49/recursos/lupa.png"))); // NOI18N
        jBBuscar.setText("Buscar");
        jBBuscar.setToolTipText("Ingresar DNI y Estado.");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jBLimpiar.setBackground(new java.awt.Color(157, 161, 158));
        jBLimpiar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jBLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        jBLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadgrupo49/recursos/escoba.png"))); // NOI18N
        jBLimpiar.setText("Limpiar pantalla");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

        jBEliminar.setBackground(new java.awt.Color(224, 9, 78));
        jBEliminar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jBEliminar.setForeground(new java.awt.Color(0, 0, 0));
        jBEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadgrupo49/recursos/basura.png"))); // NOI18N
        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBGuardar.setBackground(new java.awt.Color(35, 153, 67));
        jBGuardar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jBGuardar.setForeground(new java.awt.Color(0, 0, 0));
        jBGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadgrupo49/recursos/guardar-datos.png"))); // NOI18N
        jBGuardar.setText("Guardar / Modificar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jRBEstado.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jRBEstado.setSelected(true);
        jRBEstado.setText("Activo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jBLimpiar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLAlumno)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(jBGuardar))
                    .addComponent(jRBEstado)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jDCFechaNacim, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTFNombre, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTFApellido, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jTFDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jBBuscar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLAlumno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jRBEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDCFechaNacim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBLimpiar)
                    .addComponent(jBEliminar)
                    .addComponent(jBGuardar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // BOTON BUSCAR            
    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed

        try {
            int dni = Integer.parseInt(jTFDocumento.getText());
            boolean estado = jRBEstado.isSelected();
            alumno = ad.buscarAlumnoDNI(dni, estado);

            jTFApellido.setText(alumno.getApellido());
            jTFNombre.setText(alumno.getNombre());
            Date date = Date.from(alumno.getFechaNacimiento().atStartOfDay(ZoneId.systemDefault()).toInstant());
            jDCFechaNacim.setDate(date);

        } catch (NumberFormatException nbe) {
            JOptionPane.showMessageDialog(this, "Debe ingresar números en el campo DNI.");
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(this, "El alumno que busca no existe.");
        }
    }//GEN-LAST:event_jBBuscarActionPerformed

    // BOTON LIMPIAR PANTALLA 
    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed

        jTFDocumento.setText("");
        jTFApellido.setText("");
        jTFNombre.setText("");
        jRBEstado.setSelected(true);
        jDCFechaNacim.setDate(null);
        alumno = null; // inicializamos-*-
    }//GEN-LAST:event_jBLimpiarActionPerformed

    // BOTON GUARDAR
    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed

        try {
            int dni = Integer.parseInt(jTFDocumento.getText());
            String nombre = jTFNombre.getText();
            String apellido = jTFApellido.getText();

        
         if (nombre.isEmpty() || apellido.isEmpty()) {
             JOptionPane.showInternalMessageDialog(this, "No puede haber campos vacíos!!");
             return; //Sale del metodo
         }      //  Arroja Error id duplicado -*- 
         
         
            Date date = jDCFechaNacim.getDate();
            LocalDate fechaNac = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            Boolean estado = jRBEstado.isSelected();

            if (alumno == null) {
                alumno = new Alumno(dni, apellido, nombre, fechaNac, estado);
                ad.guardarAlumno(alumno);

            } else {
                alumno.setDni(dni);
                alumno.setApellido(apellido);
                alumno.setNombre(nombre);
                alumno.setFechaNacimiento(fechaNac);
                alumno.setEstado(jRBEstado.isSelected());
                ad.modificarAlumno(alumno);
            }
            jBLimpiar.doClick();
        } catch (NumberFormatException nbe) {
            JOptionPane.showMessageDialog(this, "Debe ingresar números en el campo DNI.");
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(this, "Verifique que no falte ningun dato.");
        }
    }//GEN-LAST:event_jBGuardarActionPerformed

    // BOTON ELIMINAR
    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        
        try {
            ad.eliminarAlumno(alumno.getIdAlumno());
            jBLimpiar.doClick();
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un alumno.");
        }
    }//GEN-LAST:event_jBEliminarActionPerformed

    // EVENTO DE TECLADO PARA CAPTURAR LA TECLA ENTERN EN EL CAMPO DNI. ACCIONA EL BOTON BUSCAR.
    private void jTFDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFDocumentoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jBBuscar.doClick();
        }
    }//GEN-LAST:event_jTFDocumentoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBLimpiar;
    private com.toedter.calendar.JDateChooser jDCFechaNacim;
    private javax.swing.JLabel jLAlumno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRBEstado;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JTextField jTFApellido;
    private javax.swing.JTextField jTFDocumento;
    private javax.swing.JTextField jTFNombre;
    // End of variables declaration//GEN-END:variables
}
