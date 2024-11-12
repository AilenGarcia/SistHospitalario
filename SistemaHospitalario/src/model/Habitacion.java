package model;

import enums.EPisoHospital;
import exception.NoSePudoAgregarException;
import exception.NotFoundException;

import java.util.ArrayList;

public class Habitacion {
    private boolean disponible;
    private int numeroDeHabitacion;
    private EPisoHospital piso;
    private int capacidadMax;
    private ArrayList<Paciente> ocupantes;

    public Habitacion(boolean disponible, int numeroDeHabitacion, EPisoHospital piso) {
        this.disponible = disponible;
        this.numeroDeHabitacion = numeroDeHabitacion;
        this.piso = piso;
        this.ocupantes = new ArrayList<>();
    }
    public Habitacion() {
        this.disponible = false;
        this.numeroDeHabitacion = 0;
        this.piso = EPisoHospital.PISO1;
        this.ocupantes = new ArrayList<>();
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getNumeroDeHabitacion() {
        return numeroDeHabitacion;
    }

    public void setNumeroDeHabitacion(int numeroDeHabitacion) {
        this.numeroDeHabitacion = numeroDeHabitacion;
    }

    public EPisoHospital getPiso() {
        return piso;
    }

    public void setPiso(EPisoHospital piso) {
        this.piso = piso;
    }

    public void agregarPaciente(Paciente paciente) throws NoSePudoAgregarException {
        if(ocupantes.size()<capacidadMax){
            ocupantes.add(paciente);
        }else {
            throw new NoSePudoAgregarException("La habitacion esta ocupada al maximo");
        }
    }

    public void darAltaPaciente(Paciente paciente) throws NotFoundException {
        if(ocupantes.contains(paciente)){
            ocupantes.remove(paciente);
        }else{
            throw new NotFoundException("No se encontro el paciente indicado");
        }
    }

    public ArrayList<Paciente> getOcupantes() {
        return ocupantes;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "disponible=" + disponible +
                ", numeroDeHabitacion=" + numeroDeHabitacion +
                ", piso=" + piso +
                ", ocupante=" + ocupantes +
                '}';
    }
}
