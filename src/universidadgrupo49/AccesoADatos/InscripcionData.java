package universidadgrupo49.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;
import universidadgrupo49.Entidades.Alumno;
import universidadgrupo49.Entidades.Inscripcion;
import universidadgrupo49.Entidades.Materia;

public class InscripcionData {

    private Connection con = null;
    private MateriaData md;
    private AlumnoData ad;

    public InscripcionData() {
        con = Conexion.getConexion();
        md = new MateriaData();
        ad = new AlumnoData();
    }

    public void guardarInscripcion(Inscripcion insc) {

        String sql = "INSERT INTO inscripcion (idAlumno,idMateria,nota) VALUES (?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getAlumno().getIdAlumno());
            ps.setInt(2, insc.getMateria().getIdMateria());
            ps.setDouble(3, insc.getNota());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion registrada");
            } else {
                JOptionPane.showMessageDialog(null, "No se registro la inscripcion");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion" + ex.getMessage());
        }

    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {

        String sql = "DELETE FROM inscripcion WHERE idAlumno=? AND idMateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int carga = ps.executeUpdate();
            if (carga == 1) {
                JOptionPane.showMessageDialog(null, "Inscripcion borrada con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo borrar la inscripción");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo ingresar a la tabla" + ex.getMessage());
        }

    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        String sql = "UPDATE inscripcion SET nota=? WHERE idAlumno=? AND idMateria=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int fila = ps.executeUpdate();

            if (fila > 0) {
//                JOptionPane.showMessageDialog(null, "Nota actualizada"); SE COMENTA LINEA PORQUE ES SOLO PARA PROBAR.
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar la nota");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion" + ex.getMessage());
        }
    }

    public List<Inscripcion> obtenerInscripciones() {

        List<Inscripcion> inscripciones = new ArrayList<>();

        String sql = "SELECT idInscripcion,idAlumno,idMateria,nota FROM inscripcion";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Inscripcion insc = new Inscripcion();

                insc.setIdInscripcion(rs.getInt("idInscripcion"));

                Alumno alu = ad.buscarAlumnoId(rs.getInt("idAlumno"), true);

                Materia mat = md.buscarMateria(rs.getInt("idMateria"), true);
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                inscripciones.add(insc);
            }
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "No se pudo ingresar a la tabla inscripción " + ex.getMessage());
        }
        return inscripciones;
    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {
        List<Inscripcion> inscripcionesPorAlumno = new ArrayList<>();

        String sql = "SELECT idInscripcion,idAlumno,idMateria,nota FROM inscripcion WHERE idAlumno = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                Alumno alu = ad.buscarAlumnoId(rs.getInt("idAlumno"), true);
                Materia mat = md.buscarMateria(rs.getInt("idMateria"), true);
                insc.setAlumno(alu);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                inscripcionesPorAlumno.add(insc);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo ingresar a la tabla inscripción " + ex.getMessage());
        }

        return inscripcionesPorAlumno;
    }
    
    public List<Materia> obtenerMateriasCursadas (int idAlumno){
        List<Materia> materiasCursadas = new ArrayList<>();
        
        String sql= "SELECT inscripcion.idMateria, nombre, anio FROM inscripcion, materia "
                + "WHERE inscripcion.idMateria = materia.idMateria AND inscripcion.idAlumno = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Materia mat = new Materia();
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnio(rs.getInt("anio"));
                materiasCursadas.add(mat);   
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo ingresar a la tabla inscripción " + ex.getMessage());
        }
        return materiasCursadas;
    }
    
    public List<Materia> obtenerMateriasNoCursadas (int idAlumno){
        List<Materia> materiasNoCursadas = new ArrayList<>();
        
        String sql= "SELECT idMateria, nombre, anio FROM materia "
                + "WHERE estado=1 AND idMateria not in (SELECT idMateria FROM inscripcion WHERE idAlumno=?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Materia mat = new Materia();
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnio(rs.getInt("anio"));
                materiasNoCursadas.add(mat);   
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo ingresar a la tabla inscripción " + ex.getMessage());
        }
        return materiasNoCursadas;
    }
    
    
    public List<Alumno> obtenerAlumnosXMateria (int idMateria) {
        
        List<Alumno>  alumnosMateria = new ArrayList<>();
        String sql = "SELECT a.idAlumno, dni, nombre, apellido, fechaNacimiento, estado "
                + "FROM inscripcion i,alumno a WHERE i.idAlumno = a.idAlumno AND idMateria = ? AND a.estado = 1";
        
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("FechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                alumnosMateria.add(alumno);
                               
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo ingresar a la tabla materia" + ex.getMessage());
        }
        
        
        return alumnosMateria;
    } 
    
    
}


