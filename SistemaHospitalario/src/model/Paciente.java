package model;

import enums.EGenero;
import enums.ETipoSangre;

import java.util.ArrayList;

public class Paciente extends Persona {
    private Integer edad;
    private ETipoSangre tipoSangre;
    private Integer numeroIngreso; //CONTADOR DE INGESOS
    private ArrayList<String> enfermedades;
    private ArrayList<String> historiaClinica;
    private Usuario medicoCabecera; //VER SI USUARIO Y MEDICO SON DOS CLASES SEPARADAS
    private boolean altaBaja;
    private Habitacion habitacion;

    public Paciente(String nombre, String apellido, Integer dni, String email, EGenero genero, Integer edad, ETipoSangre tipoSangre, Integer numeroIngreso, ArrayList<String> enfermedades, ArrayList<String> historiaClinica, Usuario medicoCabecera, boolean altaBaja, Habitacion habitacion) {
        super(nombre, apellido, dni, email, genero);
        this.edad = edad;
        this.tipoSangre = tipoSangre;
        this.numeroIngreso = numeroIngreso;
        this.enfermedades = enfermedades;
        this.historiaClinica = historiaClinica;
        this.medicoCabecera = medicoCabecera;
        this.altaBaja = altaBaja;
        this.habitacion = habitacion;
    }

    public Paciente() {
        this.edad = (Integer) 0;
        this.tipoSangre = ETipoSangre.CERONEGATIVO;
        this.numeroIngreso = (Integer) 0;
        this.altaBaja = false;
        this.habitacion = null;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public ETipoSangre getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(ETipoSangre tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public Integer getNumeroIngreso() {
        return numeroIngreso;
    }

    public void setNumeroIngreso(Integer numeroIngreso) {
        this.numeroIngreso = numeroIngreso;
    }

    public ArrayList<String> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(ArrayList<String> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public ArrayList<String> getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(ArrayList<String> historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public Usuario getMedicoCabecera() {
        return medicoCabecera;
    }

    public void setMedicoCabecera(Usuario medicoCabecera) {
        this.medicoCabecera = medicoCabecera;
    }

    public boolean isAltaBaja() { return altaBaja; }

    public void setAltaBaja(boolean altaBaja) { this.altaBaja = altaBaja; }

    public Habitacion getHabitacion() { return habitacion; }

    public void setHabitacion(Habitacion habitacion) { this.habitacion = habitacion;}

    @Override
    public String toString() {
        return "Paciente{" +
                "edad=" + edad +
                ", tipoSangre=" + tipoSangre +
                ", numeroIngreso=" + numeroIngreso +
                ", enfermedades=" + enfermedades +
                ", historiaClinica=" + historiaClinica +
                ", medicoCabecera=" + medicoCabecera +
                '}';
    }
    public void ingresarHistoriaClinica(String historia){
        historiaClinica.add(historia);
    }



}
