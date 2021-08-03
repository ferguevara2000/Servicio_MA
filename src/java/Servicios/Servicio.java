package Servicios;

import Controlador.Controlador;
import Modelos.Activos;
import Modelos.Funcionario;
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
     * @param cedula
     * @param nombre
     * @param estado
     * @return 
     */
    @WebMethod(operationName = "guardarValidacion")
    public int guardarValidacion(@WebParam(name = "cedula") String cedula, @WebParam(name = "nombre") String nombre, @WebParam(name = "estado") String estado) {
        try {
            return con.guardarFuncionario(cedula, nombre, estado);
        } catch (Exception e) {
            System.err.println(e);
            return 0;
        }
    }



    


}
