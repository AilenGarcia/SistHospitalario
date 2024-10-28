package gestores;

import exception.NotFoundException;
import model.Usuario;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios implements GestorBasic<Usuario>{
    List<Usuario> listadoUsuarios = new ArrayList<>();
    public boolean crear(Usuario usuario) {
        return false;
    }

    public boolean eliminar(Usuario usuario) {
        return false;
    }

    public Usuario buscar(Usuario usuario) throws NotFoundException {
        if(listadoUsuarios.contains(usuario)){
            return usuario;
        }else{
            throw new NotFoundException("No se encontro el usuario");
        }
    }

    public Usuario modificar(Usuario usuario) {
        return null;
    }

}
