package gestores.menu;

import exception.NotFoundException;
import gestores.GestorUsuarios;
import model.Usuario;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    GestorUsuarios gestorUsuario = new GestorUsuarios();
    String rol = "";
    public String menuPrincipal(){
        int opcion;

        do {
            System.out.println("BIENVENIDO \n" +
                    "Que desea hacer? \n" +
                    "1) Ingresar \n" +
                    "2) Salir del programa");
            opcion = scanner.nextInt();
            scanner.nextLine();

            Usuario usuario = new Usuario();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese su matricula");
                    var matricula = scanner.nextLine();
                    System.out.println("Ingrese su contrasenia");
                    var password = scanner.nextLine();
                    usuario.setMatricula(matricula);
                    usuario.setPassword(password);
                    try {
                        rol = gestorUsuario.ingresar(usuario);
                    } catch (NotFoundException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Saliendo del programa...... \n");
                    break;
                default:
                    System.out.println("Ingrese un numero valido... \n");
            }
        }while(opcion !=2 && rol.isEmpty());
        return rol.isEmpty() ? "" : rol;
    }

    public void menuMedico(){
        int opcion;

        do {
            System.out.println("Que desea hacer? \n" +
                    "1) Ingresar \n" +
                    "2) Salir del programa");
            opcion = scanner.nextInt();
            scanner.nextLine();

            Usuario usuario = new Usuario();

            switch (opcion) {
                case 1:
                    //METODOS QUE PUEDE HACER UN MEDICO
                    break;
                case 2:
                    System.out.println("Saliendo del programa......");
                    break;
                default:
                    System.out.println("Ingrese un numero valido...");
            }
        }while(opcion !=2);
    }

}
