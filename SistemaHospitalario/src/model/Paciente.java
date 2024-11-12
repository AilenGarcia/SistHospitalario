package model;

import enums.EGenero;
import enums.ETipoSangre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Paciente extends Persona {
    private Integer edad;
    private ETipoSangre tipoSangre;
    private ArrayList<String> enfermedades;
    private HashMap<Integer, String> historiaClinica;
    private int cantIngresos;
    private boolean altaBaja;

    public Paciente(String nombre, String apellido, String dni, String email, EGenero genero, Integer edad, ETipoSangre tipoSangre, ArrayList<String> enfermedades,  boolean altaBaja) {
        super(nombre, apellido, dni, email, genero);
        this.edad = edad;
        this.tipoSangre = tipoSangre;
        this.enfermedades = enfermedades;
        this.historiaClinica = new HashMap<>();
        this.cantIngresos = 0;
        this.altaBaja = altaBaja;
    }

    public Paciente() {
        this.edad = (Integer) 0;
        this.tipoSangre = ETipoSangre.CERONEGATIVO;
        this.altaBaja = false;
        this.historiaClinica = new HashMap<>();
        this.cantIngresos = 0;
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

    public ArrayList<String> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(ArrayList<String> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public boolean isAltaBaja() { return altaBaja; }

    public void setAltaBaja(boolean altaBaja) { this.altaBaja = altaBaja; }

    @Override
    public String toString() {
        return "Paciente{" +
                "edad=" + edad +
                ", tipoSangre=" + tipoSangre +
                ", enfermedades=" + enfermedades +
                ", historiaClinica=" + historiaClinica +
                '}';
    }
    public boolean agregarAHistoriaClinica(String tratamiento) {
        if (tratamiento == null || tratamiento.isEmpty()) {
            return false;
        }

        historiaClinica.put(cantIngresos++, tratamiento);
        return true;
    }

    public HashMap<Integer, String> getHistoriaClinica() {
        return historiaClinica;
    }
}
