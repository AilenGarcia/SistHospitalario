import enums.ETipoEmpleado;
import enums.Especialidad;
import gestores.menu.Menu;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        HashMap<ETipoEmpleado, Especialidad> rol = menu.menuPrincipal();

        if(rol.containsKey(ETipoEmpleado.MEDICO)){
            menu.menuMedico();
        }
    }
}