package universidadgrupo49.AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadgrupo49.Entidades.Alumno;

public class AlumnoData {

    private Connection con = null; //declaracion de con tipo conexion

    public AlumnoData() { //aca se inicializamos

        con = Conexion.getConexion();  //aca se conecta la alumnodata con la bd
    }

    public void guardarAlumno(Alumno alumno) {

        String sql = "INSERT INTO alumno (dni,apellido,nombre,fechaNacimiento, estado)"
                + "VALUES(?,?,?,?,?)"; // le enviamos a bd el mensaje de lo que vamos a cargar

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno añadido con exito!!!");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error a acceder a la tablaa de alumno" + ex.getMessage());
        }
    }

    public void modificarAlumno(Alumno alumno) {

        String sql = "UPDATE alumno SET dni=?, apellido=?, nombre=?, fechaNacimiento=? WHERE idAlumno="+alumno.getIdAlumno()+"";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
//            ps.setInt(5, alumno.getIdAlumno());
            int cargado = ps.executeUpdate();
            if (cargado == 1) {
                JOptionPane.showMessageDialog(null, "Alumno modificado con exito!");
            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla" + ex.getMessage());
        }
    }

    public void eliminarAlumno(int id) {

        try {
            //DELETE 
            String sql = "UPDATE  alumno SET estado =0 WHERE idAlumno =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            if (fila == 1) {

                JOptionPane.showMessageDialog(null, "Se eliminó el alumno.");
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar alumno: " + e.getMessage());
        }
    }

//    Método eliminar fisicaente
//    public void eliminarAlumnoPorDni(int dni) {
//        try {
//            PreparedStatement ps = con.prepareStatement("DELETE FROM alumno WHERE dni = ?");
//            ps.setInt(1, dni);
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println("Error al eliminar alumno: " + ex.getMessage());
//        }
//    }
    public Alumno buscarAlumnoId(int id, boolean estado) {

        String sql = "SELECT dni, apellido, nombre, fechaNacimiento, estado FROM alumno WHERE idAlumno = ? AND estado = ?";
        // La busqueda permite al usuario elegir si quiere buscar entre los alumnos activos o inactivos.
        Alumno alumno = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setBoolean(2, estado);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno" + e.getMessage());
        }
        return alumno;
    }

    public Alumno buscarAlumnoDNI(int dni, boolean estado) {
        String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento, estado FROM alumno WHERE dni = ? AND estado = ?";
        // La busqueda permite al usuario elegir si quiere buscar entre los alumnos activos o inactivos.
        Alumno alumno = null;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ps.setBoolean(2, estado);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(dni);
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno" + ex.getMessage());

        }
        return alumno;
    }

    public List<Alumno> listarAlumnos(boolean estado) {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumno WHERE estado = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, estado);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));

                alumnos.add(alumno);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno" + ex.getMessage());
        }
        return alumnos;
    }

}
