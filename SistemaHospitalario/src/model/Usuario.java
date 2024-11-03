package model;

import enums.Especialidad;

import java.util.ArrayList;
import java.util.Objects;

public class Usuario{
    private String matricula;
    private String password;
    private String rol;
    private Especialidad especialidad;
    //agergar arraylist<Paciente>

    public Usuario(String matricula, String password) {
        this.matricula = matricula;
        this.password = password;
    }
    public Usuario() {}

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(matricula, usuario.matricula) && Objects.equals(password, usuario.password) && Objects.equals(rol, usuario.rol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula, password, rol);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "matricula='" + matricula + '\'' +
                ", password='" + password + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
