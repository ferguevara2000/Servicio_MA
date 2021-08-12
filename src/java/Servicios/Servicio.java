package Servicios;

import Controlador.Controlador;
import Modelos.Activos;
import Modelos.Administrador;
import Modelos.Funcionario;
import Modelos.Validacion;
import java.sql.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author FerGuevara
 */
@WebService(serviceName = "Servicio")
public class Servicio {

    Controlador con = new Controlador();

    @WebMethod(operationName = "listaFuncionarios")
    public List<Funcionario> listaFuncionarios() {
        try {
            return con.obtenerFuncionario();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Web service operation
     *
     * @param ci
     * @return
     */
    @WebMethod(operationName = "ListaActivosFuncionario")
    public List<Activos> ListaActivosFuncionario(@WebParam(name = "ci") String ci) {

        try {
            return con.obtenerActivosFuncionario(ci);
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Web service operation
     *
     * @param cedula
     * @param nombre
     * @param fecha
     * @return
     */
    @WebMethod(operationName = "guardarValidacion")
    public String guardarValidacion(@WebParam(name = "nombre") String nombre, @WebParam(name = "cedula") String cedula, @WebParam(name = "fecha") String fecha) {
        try {
            return con.guardarValidacion(nombre, cedula, fecha);
        } catch (Exception e) {
            System.err.println(e);
            return ""+e;
        }
    }

    /**
     * Web service operation
     * @param cedula
     * @return 
     */
    @WebMethod(operationName = "listaAdministradores")
    public List<Administrador> listaAdministradores(@WebParam(name = "cedula")String cedula) {
        try {
            return con.listaAdmin(cedula);
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Web service operation
     * @param val
     * @return 
     */
    @WebMethod(operationName = "listaValidacion")
    public List<Funcionario> listaValidacion(@WebParam(name = "val") String val) {
        try {
            return con.listaValidacion(val);
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "ListaValidaciones")
    public List<Validacion> ListaValidaciones() {
        try {
            return con.nombreValidacion();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
    
    

}
