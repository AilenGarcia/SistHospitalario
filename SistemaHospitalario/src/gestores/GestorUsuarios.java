package gestores;

import enums.ETipoEmpleado;
import enums.Especialidad;
import exception.NotFoundException;
import model.Usuario;
import repository.UsuarioRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestorUsuarios implements GestorBasic<Usuario>{
    UsuarioRepository repository = new UsuarioRepository();
    List<Usuario> listadoUsuarios = new ArrayList<>();
    public boolean agregar(Usuario usuario) throws NotFoundException {
        if(!listadoUsuarios.contains(usuario)){
            throw new NotFoundException("No se encontro el usuario");
        }else{
            return listadoUsuarios.add(usuario);
        }
    }

    public boolean eliminar(Usuario usuario) throws NotFoundException {
        if(!listadoUsuarios.contains(usuario)){
            throw new NotFoundException("No se encontro el usuario para eliminar");
        }else{
            return listadoUsuarios.remove(usuario);
        }
    }

    public Usuario modificar(Usuario usuario) {
        return null;
    } //COMPLETAR

    public boolean buscar(Usuario usuario) throws NotFoundException {
        if(listadoUsuarios.contains(usuario)){
            return true;
        }else{
            throw new NotFoundException("No se encontro el usuario");
        }
    }

    public HashMap<ETipoEmpleado, Especialidad> ingresar(Usuario user) throws NotFoundException{
        listadoUsuarios = repository.leer();
        HashMap<ETipoEmpleado, Especialidad> credenciales = new HashMap<>();
        for (Usuario usuario : listadoUsuarios) {
            if (usuario.getMatricula().equals(user.getMatricula())
                && usuario.getPassword().equals(user.getPassword())) {
                credenciales.put(usuario.getRol(), usuario.getEspecialidad());
                return credenciales;
            }
        }
        throw new NotFoundException("Usuario no encontrado");
    }

}
