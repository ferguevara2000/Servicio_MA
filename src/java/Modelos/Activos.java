
package Modelos;

public class Activos {
    
    private String id_activo, nombre;

    public Activos() {
    }

    public Activos(String idActivo, String nombre) {
        this.id_activo = idActivo;
        this.nombre = nombre;
    }

    public String getIdActivo() {
        return id_activo;
    }

    public void setIdActivo(String idActivo) {
        this.id_activo = idActivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return "ID: " + this.id_activo +
                "\nNombre: " + this.nombre;
    }
}
