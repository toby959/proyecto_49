
package universidadgrupo49.Vistas;

import java.awt.Color;
import java.awt.Container;
import universidadgrupo49.AccesoADatos.AlumnoData;
import universidadgrupo49.AccesoADatos.InscripcionData;
import universidadgrupo49.AccesoADatos.MateriaData;

import universidadgrupo49.Entidades.Alumno;
import universidadgrupo49.Entidades.Inscripcion;
import universidadgrupo49.Entidades.Materia;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Usuario
 */
public class FormularioDeInscripcion extends javax.swing.JInternalFrame {

    
    private List<Materia> listaMat;
    private List<Alumno> listaAlu;
    
    private InscripcionData inscrData;
    private MateriaData matData;
    private AlumnoData aluData;
    
    
    private DefaultTableModel modelo;
    
    
    public FormularioDeInscripcion() { // dentro constructor 
        initComponents();
        
        aluData = new AlumnoData();
        boolean estado = false;        // inicializo variable estado-*-
        listaAlu = aluData.listarAlumnos(estado);
        modelo = new DefaultTableModel();
        
        inscrData = new InscripcionData();
        matData = new MateriaData();
        
        cargaAlumnos();
        armarCabeceraTabla(); 

       JInternalFrame internalFrame = new JInternalFrame();     //
       Container contentPane = internalFrame.getContentPane();  //
       contentPane.setBackground(new Color(121, 148, 52));      //cambio color 
       this.add(internalFrame);                                 //  fondo
    }

                 // METODO CARGA ALUMNOS    
    
    private void cargaAlumnos() {
    AlumnoData alumnoData = new AlumnoData(); // instancia AlumnoData
    List<Alumno> listaAlumnos = alumnoData.listarAlumnos(true); // recupera todos los Alumnos
    cboxAlumno.removeAllItems(); // limpia comboBox
           
    for (Alumno alumno : listaAlumnos) {
        cboxAlumno.addItem(alumno); // agrega cada Alumno al comboBox-*-
    }
}
    
                 // METODO ARMAR CABECERA TABLA             
    
    private void armarCabeceraTabla(){
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("ID");                             //
        filaCabecera.add("Nombre");                         //titulos tabla-*-
        filaCabecera.add("Año");                            //
        
        for (Object rec : filaCabecera) {
            modelo.addColumn(rec);
        }
        
        jTableMaterias.setModel(modelo);
    }
    
                 // METODO BORRAR FILA TABLA
    
    private void borrarFilaTabla(){
        
        int indice = modelo.getRowCount() -1;
        
        for (int i = indice; i >= 0; i--) {
            modelo.removeRow(i);
            
        }
    }
    
                // METODO MATERIAS NO INSCRIPTAS
    
    private void cargaDatosNoInscriptas(){
        //borrarFilaTabla();
        Alumno selec = (Alumno) cboxAlumno.getSelectedItem();
        listaMat = inscrData.obtenerMateriasNoCursadas(selec.getIdAlumno());
        for (Materia materia : listaMat) {
            modelo.addRow(new Object[] {materia.getIdMateria(), materia.getNombre(), materia.getAnio()});
        }
    }
    
    
                // METODO MATERIAS INSCRIPTAS
    
    private void cargaDatosInscriptas(){
        //borrarFilaTabla();
        Alumno selec = (Alumno) cboxAlumno.getSelectedItem();
        List <Materia> lista = inscrData.obtenerMateriasCursadas(selec.getIdAlumno());
              
        for (Materia materia : lista) {
            modelo.addRow(new Object[] {materia.getIdMateria(), materia.getNombre(), materia.getAnio()});
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboxAlumno = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        radioNoInscriptas = new javax.swing.JRadioButton();
        radioInscriptas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMaterias = new javax.swing.JTable();
        jBAInscribir = new javax.swing.JButton();
        btnInscribir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setResizable(true);

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel2.setText("Formulario de Inscripcion");

        jLabel3.setText("Seleccione un alumno:");

        cboxAlumno.setBackground(new java.awt.Color(4, 82, 110));
        cboxAlumno.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setText("Listado de Materias");

        radioNoInscriptas.setText("Materias No Inscriptas");
        radioNoInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNoInscriptasActionPerformed(evt);
            }
        });

        radioInscriptas.setText("Materias Inscriptas");
        radioInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioInscriptasActionPerformed(evt);
            }
        });

        jTableMaterias.setBackground(new java.awt.Color(7, 185, 250));
        jTableMaterias.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jTableMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre ", "Año"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(jTableMaterias);

        jBAInscribir.setBackground(new java.awt.Color(224, 9, 78));
        jBAInscribir.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jBAInscribir.setForeground(new java.awt.Color(0, 0, 0));
        jBAInscribir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadgrupo49/recursos/basura.png"))); // NOI18N
        jBAInscribir.setText("Anular Inscripción");
        jBAInscribir.setEnabled(false);
        jBAInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAInscribirActionPerformed(evt);
            }
        });

        btnInscribir.setBackground(new java.awt.Color(35, 153, 67));
        btnInscribir.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnInscribir.setForeground(new java.awt.Color(0, 0, 0));
        btnInscribir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadgrupo49/recursos/agregar-usuario.png"))); // NOI18N
        btnInscribir.setText("Inscribir");
        btnInscribir.setEnabled(false);
        btnInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscribirActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/universidadgrupo49/recursos/salida.png"))); // NOI18N
        jButton1.setText("Salir");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInscribir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBAInscribir)
                                .addGap(47, 47, 47)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioInscriptas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radioNoInscriptas))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jLabel2)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboxAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioInscriptas)
                    .addComponent(radioNoInscriptas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInscribir)
                            .addComponent(jBAInscribir)
                            .addComponent(jButton1))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

                   // MATERIAS INSCRIPTAS
    
    private void radioInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioInscriptasActionPerformed
       
           borrarFilaTabla();
           radioNoInscriptas.setSelected(false);
           cargaDatosInscriptas();
           jBAInscribir.setEnabled(true);
           btnInscribir.setEnabled(false);
    }//GEN-LAST:event_radioInscriptasActionPerformed

                   // MATERIAS NO INSCRIPTAS
    
    private void radioNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNoInscriptasActionPerformed
      
           borrarFilaTabla();
           radioInscriptas.setSelected(false);
           cargaDatosNoInscriptas();
           jBAInscribir.setEnabled(false);
           btnInscribir.setEnabled(true);
                    
    }//GEN-LAST:event_radioNoInscriptasActionPerformed

    private void btnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirActionPerformed
    
        int filaSect = jTableMaterias.getSelectedRow();
        if (filaSect!= -1) {
                         // casteamos 
            Alumno a = (Alumno)cboxAlumno.getSelectedItem(); // devuelve Object
                           // casteamos  
            int idMateria = (Integer)modelo.getValueAt(filaSect, 0);
                                   // casteamos    
            String nombreMateria = (String)modelo.getValueAt(filaSect, 1);
                       // casteamos                
            int anio = (Integer)modelo.getValueAt(filaSect, 2);
            
            Materia mat = new Materia(idMateria, nombreMateria, anio, true);
            
            Inscripcion ins = new Inscripcion(a,mat,0);
            
            inscrData.guardarInscripcion(ins);
            borrarFilaTabla();
        
    }//GEN-LAST:event_btnInscribirActionPerformed
    }
    private void jBAInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAInscribirActionPerformed
        
           int filaSect = jTableMaterias.getSelectedRow();
           if (filaSect!= -1) {
                         // casteamos 
           Alumno a = (Alumno)cboxAlumno.getSelectedItem(); // devuelve Object
                         // casteamos  
           int idMateria = (Integer)modelo.getValueAt(filaSect, 0);
       
           inscrData.borrarInscripcionMateriaAlumno(a.getIdAlumno(), idMateria);
           borrarFilaTabla();
          
    }//GEN-LAST:event_jBAInscribirActionPerformed
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
         dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInscribir;
    private javax.swing.JComboBox<Alumno> cboxAlumno;
    private javax.swing.JButton jBAInscribir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMaterias;
    private javax.swing.JRadioButton radioInscriptas;
    private javax.swing.JRadioButton radioNoInscriptas;
    // End of variables declaration//GEN-END:variables
}
