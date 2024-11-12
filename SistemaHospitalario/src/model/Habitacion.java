package model;

import enums.EPisoHospital;

public class Habitacion {
    private boolean disponible;
    private int numeroDeHabitacion;
    private EPisoHospital piso;
    private Paciente ocupante;
    //AGREGAR CONTADOR PARA VER SI MANEJAMOS LA DISPPONIBILIDAD CON ESO

    public Habitacion(boolean disponible, int numeroDeHabitacion, EPisoHospital piso, Paciente ocupante) {
        this.disponible = disponible;
        this.numeroDeHabitacion = numeroDeHabitacion;
        this.piso = piso;
        this.ocupante = ocupante;
    }
    public Habitacion() {
        this.disponible = false;
        this.numeroDeHabitacion = 0;
        this.piso = EPisoHospital.PISO1;
        this.ocupante = null;
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

    public Paciente getOcupante() {
        return ocupante;
    }

    public void setOcupante(Paciente ocupante) {
        this.ocupante = ocupante;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "disponible=" + disponible +
                ", numeroDeHabitacion=" + numeroDeHabitacion +
                ", piso=" + piso +
                ", ocupante=" + ocupante +
                '}';
    }
}
