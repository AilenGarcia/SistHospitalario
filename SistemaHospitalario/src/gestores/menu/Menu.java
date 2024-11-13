package gestores.menu;

import enums.ETipoEmpleado;
import enums.Especialidad;
import exception.NotFoundException;
import gestores.GestorUsuarios;
import model.Usuario;

import javax.lang.model.util.ElementScanner6;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    GestorUsuarios gestorUsuario = new GestorUsuarios();
    HashMap<ETipoEmpleado, Especialidad> rol = null;

    public HashMap<ETipoEmpleado, Especialidad> menuPrincipal() {
        int opcion;
        HashMap<ETipoEmpleado, Especialidad> rol = null;

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
                    System.out.println("Ingrese su matricula:");
                    var matricula = scanner.nextLine();
                    System.out.println("Ingrese su contraseña:");
                    var password = scanner.nextLine();

                    usuario.setMatricula(matricula);
                    usuario.setPassword(password);

                    try {
                        rol = gestorUsuario.ingresar(usuario);
                        if (rol != null && !rol.isEmpty()) {
                            System.out.println("Ingreso exitoso. Bienvenido!");
                        }
                    } catch (NotFoundException e) {
                        System.err.println("Error: " + e.getMessage());
                        rol = null; // Aseguramos que rol sea nulo si el usuario no es encontrado
                    }
                    break;

                case 2:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Ingrese un numero valido...");
            }
        } while (opcion != 2 && (rol == null || rol.isEmpty()));

        return rol;
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
