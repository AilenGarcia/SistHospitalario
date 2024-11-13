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
import java.util.HashMap;

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
            aux.put("TipoDeSangre",p.getTipoSangre());
            aux.put("Enfermedades",p.getEnfermedades());
            aux.put("HistoriaClinica",p.getHistoriaClinica());

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
            aux.setDni(s.getString("Dni"));
            aux.setEmail(s.getString("Email"));
            aux.setGenero((EGenero) s.get("Genero"));
            aux.setEdad(s.getInt("Edad"));
            aux.setTipoSangre((ETipoSangre) s.get("TipoDeSangre"));
            aux.setEnfermedades((ArrayList<String>) s.get("Enfermedades"));
            aux.setHistoriaClinica((HashMap<Integer, String>) s.get("HistoriaClinica"));
        } catch (JSONException u){
            System.out.println("ERROR EN EL PASAJE DE DATOS");
        }
        return aux;
    }


}
