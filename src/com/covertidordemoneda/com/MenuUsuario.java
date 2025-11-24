package com.covertidordemoneda.com;

import java.io.IOException;
import java.util.Scanner;

public class MenuUsuario {
    private final ServicioDeConversion servicioDeConversion;
    private final Scanner scanner;

    public MenuUsuario(ServicioDeConversion servicioDeConversion) {
        this.servicioDeConversion = servicioDeConversion;
        this.scanner = new Scanner(System.in);
    }

    //Metodo para mostrar opciones al usuario
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            menuOpciones();
            System.out.print("Seleccione una opción (1-8): ");
            // Validar que el usuario ingrese un entero
            while (!scanner.hasNextInt()) {
                System.out.print("Por favor ingrese un número entre 1 y 8: ");
                scanner.next(); // descartar entrada inválida
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> convertir(scanner, "USD", "ARS");
                case 2 -> convertir(scanner, "ARS", "USD");
                case 3 -> convertir(scanner, "USD", "BRL");
                case 4 -> convertir(scanner, "BRL", "USD");
                case 5 -> convertir(scanner, "USD", "COP");
                case 6 -> convertir(scanner, "COP", "USD");
                case 7 -> convertir(scanner, "CAD", "COP");
                case 8 -> System.out.println("Saliendo... Gracias por usar el conversor.");
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }

            System.out.println(); // línea en blanco para separar iteraciones

        } while (opcion != 8);
        scanner.close();
    }
    public void menuOpciones(){
        System.out.println("=== Conversor de Monedas ===");
        System.out.println("1. USD → ARS");
        System.out.println("2. ARS → USD");
        System.out.println("3. USD → BRL");
        System.out.println("4. BRL → USD");
        System.out.println("5. USD → COP");
        System.out.println("6. COP → USD");
        System.out.println("7. CAD → COP");
        System.out.println("8. Salir");
    }

    //Metodo para covertir tipo de moneda y cantidad del usuario
    public void convertir (Scanner scanner, String monedaBase, String monedaDestino){
        System.out.printf("Ingrese la cantidad en %s: ", monedaBase);
        while (!this.scanner.hasNextDouble()) {
            System.out.println("Por favor ingrese un número válido: ");
            this.scanner.next();
        }
        double cantidad = this.scanner.nextDouble();

        try {
            double resultado = servicioDeConversion.convertir(monedaBase,monedaDestino, cantidad);
            System.out.printf("El valor ingresado de: " + cantidad + " " + monedaBase + " corresponde a: " + resultado + " " + monedaDestino);
        } catch (IllegalArgumentException e){
            System.err.println("Error: " + e.getMessage());
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al obtener la tasa de cambio: " + e.getMessage());
        }
    }
}
