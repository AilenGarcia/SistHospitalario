package repository;

import enums.ETipoEmpleado;
import model.Usuario;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class UsuarioRepository {
    public ArrayList<Usuario> leer(){
        ArrayList<Usuario> arrayUsuario = new ArrayList<>();
        try{
            FileReader file = new FileReader("usuarios.json");
            JSONArray array = new JSONArray(new JSONTokener(file));
            for(int i=0; i<array.length(); i++){
                JSONObject auxJson = array.getJSONObject(i);
                Usuario auxUsu = new Usuario();
                auxUsu.setMatricula((String) auxJson.get("matricula"));
                auxUsu.setPassword((String) auxJson.get("password"));
                String rolString = auxJson.getString("rol");
                try {
                    auxUsu.setRol(ETipoEmpleado.valueOf(rolString.toUpperCase()));
                } catch (IllegalArgumentException e) {
                    System.out.println("Rol no válido en el JSON: " + rolString);
                }
                arrayUsuario.add(auxUsu);
            }
        }catch(JSONException e){
            System.out.println("Error al pasaje de datos");
        }catch (FileNotFoundException e){
            System.out.println("No se pudo leer el archivo");
            throw new RuntimeException(e);
        }
        return arrayUsuario;
    }
}