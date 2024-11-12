package gestores;

import enums.Especialidad;
import exception.AccionIlegalException;
import exception.ElementoDuplicadoException;
import exception.NotFoundException;
import model.Paciente;

import java.util.ArrayList;

public class GestorMedicoPaciente implements GestorBasic<Paciente> {
    private ArrayList<Paciente> listadoPacientes;

    @Override
    public boolean agregar(Paciente p1) throws ElementoDuplicadoException {
            if(listadoPacientes.contains(p1)){
                throw new ElementoDuplicadoException("No se pudo agregar al paciente porque ya existe en la lista de este medico");
            } else {
                listadoPacientes.add(p1);
                return true;
            }
    }

    @Override
    public boolean eliminar(Paciente paciente) throws NotFoundException {
        if(!listadoPacientes.contains(paciente)){
            throw new NotFoundException("No se encontro el paciencia a eliminar");
        } else{
            return listadoPacientes.remove(paciente);
        }
    }

    @Override
    public boolean buscar(Paciente p) throws NotFoundException {
            if(!listadoPacientes.contains(p)){
                throw new NotFoundException("No se encontro el paciente");
            }else {
                return true;
            }
    }

    //MODIFICAR PACIENTE
    @Override
    public Paciente modificar(Paciente paciente) {
        return null;
    }

    public void pedirEstudio(String estudio, String dni) throws NotFoundException {
        Paciente p = buscarByDNI(dni);
        System.out.println("El estudio : " + estudio + " fue pedido para "+ p.getNombre());
    }

    public boolean derivar(String dni, Especialidad especialidadADerivar, Especialidad especialidadMedico) throws AccionIlegalException, NotFoundException {
        if(especialidadMedico.equals(Especialidad.CLINICO)){
            throw new AccionIlegalException("Solo puede derivar un medico clinico");
        }else{
            Paciente p = buscarByDNI(dni);
            System.out.println("El paciente: "+p.getNombre() +"fue derivado a " + especialidadADerivar);
            return true;
        }
    }

    public boolean solicitarMedicamento(){
        System.out.println("Se aviso a farmacia, por favor aguarde");
        return true;
    }

    public Paciente buscarByDNI(String dni) throws NotFoundException {
        for (Paciente p : listadoPacientes){
            if(p.getDni().equals(dni)){
                return p;
            }
        }
        throw new NotFoundException("No se encontro el paciente");
    }

}
