package gestores;

import exception.NotFoundException;
import model.Habitacion;
import model.Paciente;

public class GestorInternacion {
    public void verPacientesPorHabitacion(Habitacion habitacion) throws NotFoundException {
        if(habitacion.getOcupantes().isEmpty()){
           throw new NotFoundException("No se encontraron pacientes en la habitacion");
        }else{
            System.out.println("Pacientes de la habitacion " + habitacion.getNumeroDeHabitacion() + ": ");
            for(Paciente p : habitacion.getOcupantes()){
                System.out.println(p);
            }
        }
    }

    public boolean llamarEnfermera(){
        System.out.println("Se aviso a enfermeria, por favor aguarde");
        return true;
    }
}
