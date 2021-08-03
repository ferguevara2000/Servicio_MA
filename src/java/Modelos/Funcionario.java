package Modelos;

public class Funcionario {

    private String id_persona, nombre, apellido;
    private int numActivos;

    public Funcionario() {
    }

    public Funcionario(String ci, String nombre, String apellido, int numActivos) {
        this.id_persona = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numActivos = numActivos;
    }

    public String getCi() {
        return id_persona;
    }

    public void setCi(String ci) {
        this.id_persona = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumActivos() {
        return numActivos;
    }

    public void setNumActivos(int numActivos) {
        this.numActivos = numActivos;
    }

    @Override
    public String toString() {
        return "Cedula: " + this.id_persona
                + "\nNombre: " + this.nombre + " " + this.apellido
                + "\nN° Activos: " + this.numActivos;
    }
}
