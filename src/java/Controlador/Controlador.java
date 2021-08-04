package Controlador;

import Configuracion.Conexion;
import Modelos.Activos;
import Modelos.Funcionario;
import Modelos.Validacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Controlador {

    Conexion con = new Conexion();
    Connection conexion = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Funcionario> obtenerFuncionario() {
        try {
            String sql = "SELECT DISTINCT validacion.id_persona,persona.nombre,persona.apellido FROM validacion "
                    + "INNER JOIN persona on validacion.id_persona = persona.cedula WHERE estado='ok'";
            List<Funcionario> lista = new ArrayList<>();
            conexion = con.conectar();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Funcionario func = new Funcionario(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        1);
                lista.add(func);
            }
            return lista;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }

    public List<Activos> obtenerActivosFuncionario(String ci) {
        try {
            List<Activos> lista = new ArrayList<>();
            String sql = "SELECT persona.cedula, activos.nombre FROM validacion "
                    + "INNER JOIN activos on validacion.id_activo = activos.id_activo "
                    + "INNER JOIN persona on validacion.id_persona = persona.cedula "
                    + "WHERE id_persona = " + ci + "";

            Activos act = null;

            conexion = con.conectar();
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                act = new Activos(rs.getString(1), rs.getString(2));
                lista.add(act);
            }
            return lista;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public int guardarFuncionario(String cedula, String nombre, String estado) {

        conexion = con.conectar();
        try {
            ps = conexion.prepareStatement("insert into val_funcionarios values (?,?,?)");
            ps.setString(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, estado);
            int n = ps.executeUpdate();
            if (n > 0) {
                actualizarEstadoFuncionario(cedula);
                return n;
            } else {
                return n;
            }
        } catch (Exception e) {
            System.err.println(e);
            return 0;
        }

    }

    private void actualizarEstadoFuncionario(String idPersona) {
        try {
            conexion = con.conectar();
            ps = conexion.prepareStatement("UPDATE `validacion` SET `estado` = 'revision' "
                    + "WHERE `validacion`.`id_persona` = " + idPersona + "");
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public List<Validacion> mostrarValidaciones(){
        try {
            List<Validacion> lista = new ArrayList<>();
            conexion = con.conectar();
            ps = conexion.prepareStatement("select * from val_funcionarios");
            rs = ps.executeQuery();
            while (rs.next()) {
                Validacion val = new Validacion(rs.getString(1), rs.getString(2), rs.getString(3));
                lista.add(val);
            }
            return lista;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
}
