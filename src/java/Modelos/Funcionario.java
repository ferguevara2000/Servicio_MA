package Modelos;

public class Funcionario {

    private String id_persona, nombre, apellido;

    public Funcionario() {
    }

    public Funcionario(String ci, String nombre, String apellido) {
        this.id_persona = ci;
        this.nombre = nombre;
        this.apellido = apellido;
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


    @Override
    public String toString() {
        return "Cedula: " + this.id_persona
                + "\nNombre: " + this.nombre + " " + this.apellido;
    }
}
