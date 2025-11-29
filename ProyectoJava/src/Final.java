import java.util.Scanner;

public class Final {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean estadoMenu = true;

        String[] pacientes = new String[20];
        String[] medicos = new String[10];
        String[] consultas = new String[50];

        int itPacientes = 0;
        int itMedicos = 0;
        int itConsulta = 0;

        int opcionMenu;
        String usuario;
        String contra;

        do {

            System.out.println("¡Bienvenido a Pa ti' Salud!");
            System.out.println("¿Eres administrador o paciente?");
            System.out.println("1. Administrador");
            System.out.println("2. Paciente");
            System.out.println("3. Salir");
            opcionMenu = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcionMenu) {

                // ADMINISTRADOR
                case 1 -> {

                    System.out.println("Ingresa las credenciales de administrador");
                    System.out.println("Ingresa el usuario");
                    usuario = sc.nextLine();
                    System.out.println("Ingresa la contraseña");
                    contra = sc.nextLine();

                    if (usuario.equals("admin") && contra.equals("admin")) {

                        boolean estadoAdmin = true;

                        do {
                            System.out.println("Selecciona una opción del menú");
                            System.out.println("1. Registrar a un paciente");
                            System.out.println("2. Registrar a un nuevo médico");
                            System.out.println("3. Agendar una cita médica");
                            System.out.println("4. Ver pacientes registrados");
                            System.out.println("5. Ver médicos registrados");
                            System.out.println("6. Ver consultas registradas");
                            System.out.println("7. Eliminar pacientes");
                            System.out.println("8. Eliminar médicos");
                            System.out.println("9. Eliminar consultas");
                            System.out.println("10. Salir del sistema");

                            int opcion = sc.nextInt();
                            sc.nextLine();

                            switch (opcion) {

                                // REGISTRAR PACIENTE
                                case 1 -> {
                                    System.out.println("Ingresa el nombre del paciente");
                                    String nombre = sc.nextLine();
                                    System.out.println("Ingresa el apellido del paciente");
                                    String apellido = sc.nextLine();
                                    System.out.println("Ingresa la edad del paciente");
                                    int edad = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Ingresa el documento del paciente");
                                    String documentoPaciente = sc.nextLine();
                                    System.out.println("Ingresa el sexo del paciente (F o M)");
                                    char sexo = sc.nextLine().charAt(0);
                                    System.out.println("Ingresa el peso del paciente en kilogramos");
                                    int peso = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Ingresa la eps que tiene el paciente");
                                    String eps = sc.nextLine();

                                    pacientes[itPacientes] = nombre + " " + apellido + ", " + edad + ", " +
                                            documentoPaciente + ", " + sexo + ", " + peso + ", " + eps;

                                    itPacientes++;

                                    System.out.println("Registro exitoso, vuelves al menú principal");
                                }

                                // REGISTRAR MÉDICO
                                case 2 -> {
                                    System.out.println("Ingresa el nombre del médico");
                                    String nombre = sc.nextLine();
                                    System.out.println("Ingresa el apellido del médico");
                                    String apellido = sc.nextLine();
                                    System.out.println("Ingresa el documento del médico");
                                    String documentoMedico = sc.nextLine();
                                    System.out.println("Ingresa el sexo del usuario (F o M)");
                                    char sexo = sc.nextLine().charAt(0);
                                    System.out.println("Ingresa la especialización del médico");
                                    String especializacion = sc.nextLine();

                                    medicos[itMedicos] = nombre + " " + apellido + ", " + documentoMedico + ", " + sexo + ", " + especializacion;

                                    itMedicos++;

                                    System.out.println("Registro exitoso, vuelves al menú principal");
                                }

                                // AGENDAR CITA
                                case 3 -> {
                                    if (itPacientes == 0) {
                                        System.out.println("No hay pacientes registrados");
                                    } else if (itMedicos == 0) {
                                        System.out.println("No hay médicos registrados");
                                    } else {

                                        System.out.println("Ingresa la fecha de la cita (DD-MM-AAAA)");
                                        String fechaCita = sc.nextLine();
                                        System.out.println("Ingresa la hora de la cita HH:MM");
                                        String horaCita = sc.nextLine();
                                        System.out.println("Ingresa el documento del paciente");
                                        String documentoPaciente = sc.nextLine();
                                        System.out.println("Ingresa el documento del médico");
                                        String documentoMedico = sc.nextLine();

                                        String pacienteSeleccionado = "";
                                        String medicoSeleccionado = "";

                                        for (int i = 0; i < itPacientes; i++) {
                                            if (pacientes[i] != null && pacientes[i].contains(documentoPaciente)) {
                                                pacienteSeleccionado = pacientes[i];
                                                break;
                                            }
                                        }

                                        for (int i = 0; i < itMedicos; i++) {
                                            if (medicos[i] != null && medicos[i].contains(documentoMedico)) {
                                                medicoSeleccionado = medicos[i];
                                                break;
                                            }
                                        }

                                        consultas[itConsulta] =
                                                "IdConsulta: AB" + itConsulta + ", " + fechaCita + ", " + horaCita +
                                                        ", " + pacienteSeleccionado + ", " + medicoSeleccionado;

                                        itConsulta++;

                                        System.out.println("Información de la cita registrada:");
                                        System.out.println(consultas[itConsulta - 1]);
                                    }
                                }

                                // VER PACIENTES
                                case 4 -> {
                                    if (itPacientes == 0) {
                                        System.out.println("No hay pacientes registrados");
                                    } else {
                                        for (int i = 0; i < itPacientes; i++) {
                                            System.out.println(pacientes[i]);
                                        }
                                    }
                                }

                                // VER MÉDICOS
                                case 5 -> {
                                    if (itMedicos == 0) {
                                        System.out.println("No hay médicos registrados");
                                    } else {
                                        for (int i = 0; i < itMedicos; i++) {
                                            System.out.println(medicos[i]);
                                        }
                                    }
                                }

                                // VER CONSULTAS
                                case 6 -> {
                                    if (itConsulta == 0) {
                                        System.out.println("No hay consultas registradas");
                                    } else {
                                        for (int i = 0; i < itConsulta; i++) {
                                            System.out.println(consultas[i]);
                                        }
                                    }
                                }

                                // ELIMINAR PACIENTE
                                case 7 -> {
                                    if (itPacientes == 0) {
                                        System.out.println("No hay pacientes registrados");
                                    } else {

                                        System.out.println("Ingresa el documento del paciente a eliminar:");
                                        String documentoPaciente = sc.nextLine();

                                        boolean existe = false;

                                        for (int i = 0; i < itPacientes; i++) {
                                            if (pacientes[i] != null && pacientes[i].contains(documentoPaciente)) {
                                                pacientes[i] = "- Paciente eliminado";
                                                System.out.println("El paciente ha sido eliminado");
                                                existe = true;
                                                break;
                                            }
                                        }

                                        if (!existe) System.out.println("No existe el paciente");
                                    }
                                }

                                // ELIMINAR MÉDICO
                                case 8 -> {
                                    if (itMedicos == 0) {
                                        System.out.println("No hay médicos registrados");
                                    } else {

                                        System.out.println("Ingresa el documento del médico a eliminar:");
                                        String documentoMedico = sc.nextLine();

                                        boolean existe = false;

                                        for (int i = 0; i < itMedicos; i++) {
                                            if (medicos[i] != null && medicos[i].contains(documentoMedico)) {
                                                medicos[i] = "- Médico eliminado";
                                                System.out.println("El médico ha sido eliminado");
                                                existe = true;
                                                break;
                                            }
                                        }

                                        if (!existe) System.out.println("No existe el médico");
                                    }
                                }

                                // ELIMINAR CONSULTA
                                case 9 -> {
                                    if (itConsulta == 0) {
                                        System.out.println("No hay consultas registradas");
                                    } else {

                                        System.out.println("Ingresa el ID de la consulta (AB#):");
                                        String idConsulta = sc.nextLine();

                                        boolean existe = false;

                                        for (int i = 0; i < itConsulta; i++) {
                                            if (consultas[i] != null && consultas[i].contains(idConsulta)) {
                                                consultas[i] = "- Consulta eliminada";
                                                System.out.println("La consulta ha sido eliminada");
                                                existe = true;
                                                break;
                                            }
                                        }

                                        if (!existe) System.out.println("No existe la consulta");
                                    }
                                }

                                // SALIR ADMIN
                                case 10 -> {
                                    System.out.println("Gracias por utilizar nuestro sistema");
                                    estadoAdmin = false;
                                }

                                default -> System.out.println("Opción inválida");
                            }

                        } while (estadoAdmin);

                    } else {
                        System.out.println("Datos incorrectos, vuelves al menú principal");
                    }

                } // fin case 1 administrador

                // PACIENTE
                case 2 -> {
                    boolean estadoPaciente = true;

                    System.out.println("Bienvenido al portal de pacientes");
                    System.out.println("Ingresa tu documento:");
                    String documentoPaciente = sc.nextLine();

                    do {
                        System.out.println("Selecciona una opción:");
                        System.out.println("1. Ver médicos registrados");
                        System.out.println("2. Ver consultas registradas");
                        System.out.println("3. Ver mis citas pendientes");
                        System.out.println("4. Salir");

                        int opcionPaciente = sc.nextInt();
                        sc.nextLine();

                        switch (opcionPaciente) {

                            case 1 -> {
                                if (itMedicos == 0) {
                                    System.out.println("No hay médicos registrados");
                                } else {
                                    for (int i = 0; i < itMedicos; i++) {
                                        System.out.println(medicos[i]);
                                    }
                                }
                            }

                            case 2 -> {
                                if (itConsulta == 0) {
                                    System.out.println("No hay consultas registradas");
                                } else {
                                    for (int i = 0; i < itConsulta; i++) {
                                        System.out.println(consultas[i]);
                                    }
                                }
                            }

                            case 3 -> {
                                boolean existe = false;
                                System.out.println("Tus citas pendientes:");

                                for (int i = 0; i < itConsulta; i++) {
                                    if (consultas[i] != null && consultas[i].contains(documentoPaciente)) {
                                        System.out.println(consultas[i]);
                                        existe = true;
                                    }
                                }

                                if (!existe) System.out.println("No tienes citas pendientes");
                            }

                            case 4 -> {
                                System.out.println("Saliendo del portal de pacientes...");
                                estadoPaciente = false;
                            }

                            default -> System.out.println("Opción inválida");
                        }

                    } while (estadoPaciente);

                } // fin case 2 paciente

                case 3 -> {
                    System.out.println("Gracias por utilizar nuestro sistema");
                    estadoMenu = false;
                }

                default -> System.out.println("Opción inválida");
            }

        } while (estadoMenu);

    }
}
