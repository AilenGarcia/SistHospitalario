package gestores;

import exception.NoSePudoAgregarException;
import exception.NotFoundException;
import model.Paciente;

import java.util.ArrayList;

public class GestorMedicoPaciente implements GestorBasic<Paciente> {
    private ArrayList<Paciente> listadoPacientes;

    //INGRESAR PACIENTE
    @Override
    public boolean agregar(Paciente p1) {
        try{
            if(listadoPacientes.contains(p1)){
                throw new NoSePudoAgregarException("No se pudo agregar al paciente porque ya existe en la lista de este medico");
            } else {
                listadoPacientes.add(p1);
                return true;
            }
        } catch (NoSePudoAgregarException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminar(Paciente paciente) {
        return false;
    }

    @Override
    public Paciente buscar(Paciente paciente) throws NotFoundException {
        return null;
    }

    //MODIFICAR PACIENTE
    @Override
    public Paciente modificar(Paciente paciente) {
        return null;
    }

    //PEDIR ESTUDIO


    //DERIVAR (DEBE PODER HACERLO SOLAMENTE SI EL MEDICO ES CLINICO, VERIFICAR)

    //AGREGAR TRATAMIENTO AL PACIENTE (CREAR ATRIBUTO TRATAMIENTO EN PACIENTE O AGREGAR COMO STRING EN HISTORIA CLINICA?)

    //SOLICITAR MEDICAMENTO
    public boolean solicitarMedicamento(){
        System.out.println("Se aviso a farmacia, por favor aguarde");
        return true;
    }

    //ALTA BAJA PACIENTE BOOLEAN


    //VER PACIENTE (BUSCAR POR DNI)
    public Paciente buscarByDNI(String dni){
       for(Paciente p: listadoPacientes){
           if(p.getDni().equals(dni)){
               return p;
           }
       }
       return null;
    }

    //VER POR HABITACION, MOSTRAR TODOS LOS PACIENTES QUE HAYA EN ELLA

    //LLAMAR ENFERMERA BOOLEAN
    public boolean llamarEnfermera(){
        System.out.println("Se aviso a enfermeria, por favor aguarde");
        return true;
    }
}
