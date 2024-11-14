package gestores.menu;

import enums.ETipoEmpleado;
import enums.Especialidad;
import exception.AccionIlegalException;
import exception.ElementoDuplicadoException;
import exception.NotFoundException;
import gestores.GestorMedicoPaciente;
import gestores.GestorUsuarios;
import model.Paciente;
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

    public void menuMedico() throws NotFoundException, ElementoDuplicadoException, AccionIlegalException {
        int opcion;
        int opcionMedico;
        int cerrarMenuSecundario = 0;
        do {
            System.out.println("Que desea hacer? \n" +
                    "1) Ingresar \n" +
                    "2) Salir del programa");
            opcion = scanner.nextInt();
            scanner.nextLine();

            Usuario usuario = new Usuario();
            Paciente aux = new Paciente();
            GestorMedicoPaciente gestorMedicoPaciente = new GestorMedicoPaciente();

            try {
                switch (opcion) {
                    case 1:
                        System.out.println("Ingresando al sistema . . . . \n \n");

                        do {
                            System.out.println("Ingrese 1 para agregar un paciente: \n" +
                                    "Ingrese 2 para eliminar un paciente: \n" +
                                    "Ingrese 3 para buscar un paciente: \n" +
                                    "Ingrese 4 para modificar un paciente: \n" +
                                    "Ingrese 5 para pedirle un estudio a un paciente: \n" +
                                    "Ingrese 6 para derivar a un paciente: \n" +
                                    "Ingrese 7 para solicitarle medicamentos a un paciente: \n");

                            opcionMedico = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Ingrese el DNI del paciente: \n");
                            String dniPaciente = scanner.nextLine();

                            switch (opcionMedico) {
                                case 1:
                                    aux = gestorMedicoPaciente.buscarByDNI(dniPaciente);
                                    gestorMedicoPaciente.agregar(aux);
                                    break;

                                case 2:
                                    aux = gestorMedicoPaciente.buscarByDNI(dniPaciente);
                                    gestorMedicoPaciente.eliminar(aux);
                                    break;

                                case 3:
                                    aux = gestorMedicoPaciente.buscarByDNI(dniPaciente);
                                    gestorMedicoPaciente.buscar(aux);
                                    break;

                                case 4:
                                    aux = gestorMedicoPaciente.buscarByDNI(dniPaciente);
                                    gestorMedicoPaciente.modificar(aux);
                                    break;

                                case 5:
                                    System.out.println("Ingrese el estudio solicitado: \n");
                                    String estudio = scanner.nextLine();
                                    gestorMedicoPaciente.pedirEstudio(estudio, dniPaciente);
                                    break;

                                case 6:
                                    System.out.println("Ingrese la especialidad a la que desea derivar: \n");
                                    Especialidad derivada = Especialidad.valueOf(scanner.nextLine());
                                    gestorMedicoPaciente.derivar(dniPaciente, derivada, usuario.getEspecialidad());
                                    break;

                                case 7:
                                    System.out.println("Ingrese el medicamento que desea recetar: \n");
                                    System.out.println(gestorMedicoPaciente.solicitarMedicamento());
                                    break;

                                default:
                                    System.out.println("Ingrese una opcion valida");
                                    break;
                            }

                            System.out.println("Si desea continuar en el menú secundario, ingrese 1, de lo contrario ingrese otro numero \n");
                            cerrarMenuSecundario = scanner.nextInt();
                            scanner.nextLine();
                        } while (cerrarMenuSecundario == 1);

                        break;

                    case 2:
                        System.out.println("Saliendo del programa......");
                        break;

                    default:
                        System.out.println("Ingrese un numero valido...");
                        break;
                }
            } catch (ElementoDuplicadoException f) {
                System.out.println(f.getMessage());
            } catch (AccionIlegalException e) {
                System.out.println(e.getMessage());
            } catch (NotFoundException n) {
                System.out.println(n.getMessage());
            }
        } while (opcion != 2);
    }

}
