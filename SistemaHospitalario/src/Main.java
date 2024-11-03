import gestores.menu.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        String rol = menu.menuPrincipal();
        if(rol.equals("medico")){
            menu.menuMedico();
        }
    }
}