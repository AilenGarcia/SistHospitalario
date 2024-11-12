package repository;

import enums.EGenero;
import enums.ETipoSangre;
import enums.Especialidad;
import model.Habitacion;
import model.Paciente;
import model.Usuario;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UsoJSON {

    public static JSONObject pasarPacienteAJSON (Paciente p){
        JSONObject aux = new JSONObject();
        try {
            aux.put("Nombre",p.getNombre());
            aux.put("Apellido",p.getApellido());
            aux.put("Dni",p.getDni());
            aux.put("Email", p.getEmail());
            aux.put("Genero",p.getGenero());
            aux.put("Edad",p.getEdad());
            aux.put("NumeroIngreso",p.getNumeroIngreso());
            aux.put("TipoDeSangre",p.getTipoSangre());
            aux.put("Enfermedades",p.getEnfermedades());
            aux.put("Habitacion",p.getHabitacion());
            aux.put("Habitacion",p.getHistoriaClinica());
            aux.put("MedicoCabecera", p.getMedicoCabecera());

        }catch (JSONException e){
            System.out.println("ERROR EN EL PASAJE DE DATOS");
        }
        return aux;
    }

    public static Paciente pasarDeJSONAPaciente (JSONObject s){
        Paciente aux = new Paciente();
        try{
            aux.setNombre(s.getString("Nombre"));
            aux.setApellido(s.getString("Apellido"));
            aux.setDni(s.getInt("Dni"));
            aux.setEmail(s.getString("Email"));
            aux.setGenero((EGenero) s.get("Genero"));
            aux.setEdad(s.getInt("Edad"));
            aux.setNumeroIngreso(s.getInt("NumeroIngreso"));
            aux.setTipoSangre((ETipoSangre) s.get("TipoDeSangre"));
            aux.setEnfermedades((ArrayList<String>) s.get("Enfermedades"));
            aux.setHabitacion((Habitacion) s.get("Habitacion"));
            aux.setHistoriaClinica((ArrayList<String>) s.get("HistoriaClinica"));
            aux.setMedicoCabecera((Usuario) s.get("MedicoCabedera"));

        } catch (JSONException u){
            System.out.println("ERROR EN EL PASAJE DE DATOS");
        }
        return aux;
    }

    /*public JSONObject pasarUsuarioAJSON (Usuario x){
        JSONObject aux = new JSONObject();
        try{
            aux.put("Matricula",x.getMatricula());
            aux.put("Pasword",x.getPassword());
            aux.put("Rol",x.getRol());
            aux.put("Especialidad",x.getEspecialidad());
            aux.put("ListadoPacientes", x.getListadoPacientes());

        }catch (JSONException y){
            System.out.println("ERROR EN EL PASAJE DE DATOS");
        }
        return aux;
    }

    public static Usuario pasarDeJSONAUsuario(JSONObject f){
        Usuario aux = new Usuario();
        try{
            aux.setMatricula(f.getString("Matricula"));
            aux.setPassword(f.getString("Pasword"));
            aux.setRol(f.getString("Rol"));
            aux.setEspecialidad((Especialidad) f.get("Especialidad"));
            aux.setListadoPacientes((ArrayList<Paciente>) f.get("ListadoPacientes"));
        }catch (JSONException t){
            System.out.println("ERROR EN EL PASAJE DE DATOS");
        }
        return aux;
    }*/



}
