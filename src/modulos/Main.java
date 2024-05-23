package modulos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ConexionBD conexionBD = new ConexionBD();
        Actualizar actualizar = new Actualizar();
        Eliminar eliminar = new Eliminar();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una operación:");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Actualizar usuario");
            System.out.println("3. Eliminar usuario");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1 -> {
                    // Agregar usuario
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el correo electrónico: ");
                    String correoElectronico = scanner.nextLine();
                    System.out.print("Ingrese la contraseña: ");
                    String contrasena = scanner.nextLine();

                    boolean isInserted = conexionBD.agregarUsuario(nombre, correoElectronico, contrasena);
                    if (isInserted) {
                        System.out.println("Nuevo usuario creado exitosamente.");
                    } else {
                        System.out.println("Error al crear el usuario.");
                    }
                }
                case 2 -> {
                    // Actualizar usuario
                    System.out.print("Ingrese el ID del usuario a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea
                    System.out.println("Seleccione el dato a actualizar:");
                    System.out.println("1. Nombre");
                    System.out.println("2. Correo electrónico");
                    System.out.println("3. Contraseña");
                    int subOpcionActualizar = scanner.nextInt();
                    scanner.nextLine();  

                    switch (subOpcionActualizar) {
                        case 1 -> {
                            System.out.print("Ingrese el nuevo nombre: ");
                            String nuevoNombre = scanner.nextLine();
                            boolean isNameUpdated = actualizar.actualizarNombre(idActualizar, nuevoNombre);
                            if (isNameUpdated) {
                                System.out.println("Nombre del usuario actualizado exitosamente.");
                            } else {
                                System.out.println("Error al actualizar el nombre del usuario.");
                            }
                    }
                        case 2 -> {
                            System.out.print("Ingrese el nuevo correo electrónico: ");
                            String nuevoCorreo = scanner.nextLine();
                            boolean isEmailUpdated = actualizar.actualizarCorreo(idActualizar, nuevoCorreo);
                            if (isEmailUpdated) {
                                System.out.println("Correo electrónico del usuario actualizado exitosamente.");
                            } else {
                                System.out.println("Error al actualizar el correo electrónico del usuario.");
                            }
                    }
                        case 3 -> {
                            System.out.print("Ingrese la nueva contraseña: ");
                            String nuevaContrasena = scanner.nextLine();
                            boolean isPasswordUpdated = actualizar.actualizarContrasena(idActualizar, nuevaContrasena);
                            if (isPasswordUpdated) {
                                System.out.println("Contraseña del usuario actualizada exitosamente.");
                            } else {
                                System.out.println("Error al actualizar la contraseña del usuario.");
                            }
                    }
                        default -> System.out.println("Opción inválida.");
                    }
                }
                case 3 -> {
                    // Eliminar usuario
                    System.out.print("Ingrese el ID del usuario a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea
                    boolean isDeleted = eliminar.eliminarUsuario(idEliminar);
                    if (isDeleted) {
                        System.out.println("Usuario eliminado exitosamente.");
                    } else {
                        System.out.println("Error al eliminar el usuario.");
                    }
                }
                case 4 -> {
                    // Salir
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }
}
