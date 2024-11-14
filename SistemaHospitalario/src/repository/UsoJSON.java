package repository;

import enums.EGenero;
import enums.ETipoSangre;
import enums.Especialidad;
import gestores.GestorMedicoPaciente;
import gestores.GestorUsuarios;
import model.Empleado;
import model.Habitacion;
import model.Paciente;
import model.Usuario;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class UsoJSON {

    //Metodo para pasar pacientes a un archivo JSON
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

    //Metodo para conseguir pacientes desde un archivo JSON
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

    //Metodo para pasar usuarios a un archivo JSON
    public static JSONObject pasarUsuarioAJSON (Usuario u){
        JSONObject aux = new JSONObject();
        try {
            aux.put("Nombre",u.getNombre());
            aux.put("Apellido",u.getApellido());
            aux.put("Dni",u.getDni());
            aux.put("Email", u.getEmail());
            aux.put("Genero",u.getGenero());
            aux.put("Matricula",u.getMatricula());
            aux.put("Password",u.getPassword());
            aux.put("Rol",u.getRol());
            aux.put("Especialidad",u.getEspecialidad());

        }catch (JSONException e){
            System.out.println("ERROR EN EL PASAJE DE DATOS");
        }
        return aux;
    }

    //Metodo para conseguir usuarios desde un archivo JSON
    public static Usuario pasarDeJSONAusuario (JSONObject l){
        Usuario aux = new Usuario();
        try{
            aux.setNombre(l.getString("Nombre"));
            aux.setApellido(l.getString("Apellido"));
            aux.setDni(l.getString("Dni"));
            aux.setEmail(l.getString("Email"));
            aux.setGenero((EGenero) l.get("Genero"));
            aux.setMatricula(l.getString("Matricula"));
            aux.setPassword( l.getString("Password"));
            aux.setRol((Empleado) l.get("Rol"));
            aux.setEspecialidad((Especialidad) l.get("Especialidad"));
        } catch (JSONException u){
            System.out.println("ERROR EN EL PASAJE DE DATOS");
        }
        return aux;
    }

    //REVISAR LAS SIGUIENTES FUNCIONES Y LLAMARLAS DONDE SEA NECESARIO (en gestores o donde haga falta)

    public static void guardarListasEnJSON(GestorMedicoPaciente gestorPacientes, GestorUsuarios gestorUsuarios, String archivoDestino) {
        JSONObject data = new JSONObject();
        JSONArray pacientesArray = new JSONArray();
        JSONArray usuariosArray = new JSONArray();

        for (Paciente p : gestorPacientes.getListadoPacientes()) {
            pacientesArray.put(pasarPacienteAJSON(p));
        }
        data.put("pacientes", pacientesArray);

        for (Usuario u : gestorUsuarios.getListadoUsuarios()) {
            usuariosArray.put(pasarUsuarioAJSON(u));
        }
        data.put("usuarios", usuariosArray);

        try (FileWriter file = new FileWriter(archivoDestino)) {
            file.write(data.toString(4));
            System.out.println("Datos guardados exitosamente en el archivo JSON.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos en el archivo JSON: " + e.getMessage());
        }
    }

    public static void cargarListasDesdeJSON(GestorMedicoPaciente gestorPacientes, GestorUsuarios gestorUsuarios, String archivoOrigen) {
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(archivoOrigen)));
            JSONObject data = new JSONObject(contenido);

            JSONArray pacientesArray = data.getJSONArray("pacientes");
            for (int i = 0; i < pacientesArray.length(); i++) {
                JSONObject pacienteJSON = pacientesArray.getJSONObject(i);
                Paciente paciente = pasarDeJSONAPaciente(pacienteJSON);
                gestorPacientes.getListadoPacientes().add(paciente);
            }

            JSONArray usuariosArray = data.getJSONArray("usuarios");
            for (int i = 0; i < usuariosArray.length(); i++) {
                JSONObject usuarioJSON = usuariosArray.getJSONObject(i);
                Usuario usuario = pasarDeJSONAusuario(usuarioJSON);
                gestorUsuarios.getListadoUsuarios().add(usuario);
            }

            System.out.println("Datos cargados exitosamente desde el archivo JSON.");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
        }
    }
}
