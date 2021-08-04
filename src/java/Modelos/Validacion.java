
package Modelos;

public class Validacion {
    
    String ci,nombre,estado;

    public Validacion() {
    }

    public Validacion(String ci, String nombre, String estado) {
        this.ci = ci;
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
