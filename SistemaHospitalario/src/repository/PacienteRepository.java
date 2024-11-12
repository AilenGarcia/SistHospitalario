package repository;

import enums.EGenero;
import enums.ETipoSangre;
import model.Habitacion;
import model.Paciente;
import model.Usuario;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class PacienteRepository extends UsoJSON {
    //EXTRACCION Y GUARDADO DE JSON
    public ArrayList<Paciente> leer(){
        ArrayList<Paciente> auxPaciente = new ArrayList<>();
        try{
            FileReader file = new FileReader("pacientes.json");
            JSONArray array = new JSONArray(new JSONTokener(file));
            for (int i = 0; i < array.length(); i++) {
                JSONObject auxJson = array.getJSONObject(i);
                Paciente aux = new Paciente();
                aux.setNombre(auxJson.getString("Nombre"));
                aux.setApellido(auxJson.getString("Apellido"));
                aux.setApellido(auxJson.getString("Apellido"));
                aux.setDni(auxJson.getInt("Dni"));
                aux.setEmail(auxJson.getString("Email"));
                aux.setGenero((EGenero) auxJson.get("Genero"));
                aux.setEdad(auxJson.getInt("Edad"));
                aux.setNumeroIngreso(auxJson.getInt("NumeroIngreso"));
                aux.setTipoSangre((ETipoSangre) auxJson.get("TipoDeSangre"));
                aux.setEnfermedades((ArrayList<String>) auxJson.get("Enfermedades"));
                aux.setHabitacion((Habitacion) auxJson.get("Habitacion"));
                aux.setHistoriaClinica((ArrayList<String>) auxJson.get("HistoriaClinica"));
                aux.setMedicoCabecera((Usuario) auxJson.get("MedicoCabedera"));

            }
        }catch(JSONException e){
            System.out.println("Error al pasaje de datos");
        }catch (FileNotFoundException e){
            System.out.println("No se pudo leer el archivo");
            throw new RuntimeException(e);
        }
        return auxPaciente;
    }
}
