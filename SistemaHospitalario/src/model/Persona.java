package model;

import enums.EGenero;

import java.util.Objects;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private Integer dni;
    private String email;
    private EGenero genero;

    public Persona(String nombre, String apellido, Integer dni, String email, EGenero genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.genero = genero;
    }
    public Persona() {
        this.nombre = "Nodefinido";
        this.apellido = "Nodefinido";
        this.dni = (Integer) 0;
        this.email = "Nodefinido@gmail.com";
        this.genero = EGenero.NOBINARIO;
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

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EGenero getGenero() {
        return genero;
    }

    public void setGenero(EGenero genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", email='" + email + '\'' +
                ", genero=" + genero +
                '}';
    }
}
