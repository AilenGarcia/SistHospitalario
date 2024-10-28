package gestores;

import exception.NotFoundException;

public interface GestorBasic<T>{
    boolean crear(T t);
    boolean eliminar(T t);
    T buscar(T t) throws NotFoundException;
    T modificar(T t);

}
