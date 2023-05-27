package mx.uv.demoREST;

public class Persona {
    public String nombre;
    public String apodo;
    public int edad;

    public Persona(String nombre, String apodo, int edad) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}