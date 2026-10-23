package ejemplo1;

import java.util.Scanner;

public class main {

    public static void mostrarMenuRec(PatioAutos patio, Scanner scanner) {
        System.out.println("\n===========================");
        System.out.println("   MENU PATIO DE AUTOS");
        System.out.println("===========================");
        System.out.println("1. Registrar vehiculo");
        System.out.println("2. Dar de baja vehiculo (Retirar)");
        System.out.println("3. Listar vehiculos");
        System.out.println("4. Salir");
        System.out.print("Elija una opcion: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion == 4) {
            System.out.println("Cerrando el programa. Hasta luego!");
            return;
        }

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el modelo: ");
                String modelo = scanner.nextLine();
                System.out.print("Ingrese la marca: ");
                String marca = scanner.nextLine();
                System.out.print("Ingrese el precio: ");
                double precio = scanner.nextDouble();
                System.out.print("Ingrese el kilometraje: ");
                int km = scanner.nextInt();
                scanner.nextLine();

                Vehiculo nuevoVehiculo = new Vehiculo(modelo, marca, precio);
                nuevoVehiculo.km = km;

                if (patio.agregarVehiculo(nuevoVehiculo)) {
                    System.out.println("Vehiculo registrado exitosamente!");
                } else {
                    System.out.println("Error: El patio de autos esta lleno.");
                }
                break;

            case 2:
                System.out.print("Ingrese el modelo del vehiculo a dar de baja: ");
                String modeloBaja = scanner.nextLine();
                if (patio.retirarVehiculo(modeloBaja)) {
                    System.out.println("Vehiculo dado de baja correctamente!");
                } else {
                    System.out.println("No se encontro ningun vehiculo con ese modelo.");
                }
                break;

            case 3:
                System.out.println(patio.listarVehiculos());
                break;

            default:
                System.out.println("Opcion invalida. Intente de nuevo.");
                break;
        }

        mostrarMenuRec(patio, scanner);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatioAutos patio = new PatioAutos(5);

        mostrarMenuRec(patio, scanner);

        scanner.close();
    }
}