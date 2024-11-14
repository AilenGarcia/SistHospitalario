import enums.ETipoEmpleado;
import enums.Especialidad;
import exception.AccionIlegalException;
import exception.ElementoDuplicadoException;
import exception.NotFoundException;
import gestores.menu.Menu;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        HashMap<ETipoEmpleado, Especialidad> rol = menu.menuPrincipal();

        if (rol.containsKey(ETipoEmpleado.MEDICO)) {
            try {
                menu.menuMedico();
            } catch (ElementoDuplicadoException f) {
                System.out.println(f.getMessage());
            } catch (AccionIlegalException e) {
                System.out.println(e.getMessage());
            } catch (NotFoundException n) {
                System.out.println(n.getMessage());
            }
        }
    }
}