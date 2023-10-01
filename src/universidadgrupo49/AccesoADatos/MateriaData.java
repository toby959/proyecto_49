/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadgrupo49.AccesoADatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadgrupo49.Entidades.Materia;

/**
 *
 * @author Usuario
 */
public class MateriaData {
    
    private Connection con = null;
    
    public MateriaData () {
        con = Conexion.getConexion();
    }
    
    public void guardarMateria (Materia materia) {
        String sql = "INSERT INTO materia (nombre, anio, estado) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
//            if (rs.next()) {
//                materia.setIdMateria(rs.getInt(1));
//                JOptionPane.showMessageDialog(null, "Materia añadida correctamente.");  
//            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla" + ex.getMessage());
        }
    }
    
    public void modificarMateria (Materia materia){
        String sql = "UPDATE materia SET nombre=?, anio=? WHERE idMateria=?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setInt(3, materia.getIdMateria());
            int cargado = ps.executeUpdate();
            
            if (cargado == 1) {
                JOptionPane.showMessageDialog(null, "Materia modificada correctamente.");
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla" + ex.getMessage());
        }
        
    }
    
    public void eliminarMateria(int id){
        
        String sql ="UPDATE materia SET estado = 0 WHERE idMateria=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1,id);
            int cargado = ps.executeUpdate();
            
            if(cargado == 1){
                JOptionPane.showMessageDialog(null, "Materia eliminada correctamente.");
            }else{
                JOptionPane.showMessageDialog(null, "Fallo la eliminacion.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla materia"+ex.getMessage());
        }
    }
    
    public Materia buscarMateria(int id, boolean estado){

        Materia materia= null;
        String sql= "SELECT idMateria, nombre, anio, estado FROM materia WHERE idMateria = ? AND estado = ?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setBoolean(2, estado);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                materia = new Materia();
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materia.setEstado(estado);
//                JOptionPane.showMessageDialog(null, "Materia fue encontrada correctamente.");/se comento la linea para que no salga la vista
            } else { 
                JOptionPane.showMessageDialog(null, "Materia no fue encontrada.");   
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla materia"+ex.getMessage());
        }
        return materia;
    }
    
    public List<Materia> listarMaterias(boolean estado){
    List<Materia> materias=new ArrayList<>();   
    String sql="SELECT * FROM materia WHERE estado=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setBoolean(1, estado);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                Materia materia=new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
    //    26-09  materia.setEstado(estado);
                materia.setEstado(rs.getBoolean("estado"));
                materias.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al acceder a la tabla materia"+ex.getMessage());
        }
    return materias;
    } 
}
