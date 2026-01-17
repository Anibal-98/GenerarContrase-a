package clave;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Pedir tamaño del array
        System.out.print("¿Cuántas contraseñas quieres generar? ");
        int tamaño = sc.nextInt();

        // Pedir longitud de las contraseñas
        System.out.print("¿Longitud de cada contraseña? ");
        int longitud = sc.nextInt();

        // Crear arrays
        Password[] listaPasswords = new Password[tamaño];
        boolean[] fuertes = new boolean[tamaño];

        // Llenar arrays
        for (int i = 0; i < tamaño; i++) {
            listaPasswords[i] = new Password(longitud);
            fuertes[i] = listaPasswords[i].EsFuerte();
        }

        // Mostrar resultados
        System.out.println("RESULTADOS:");
        for (int i = 0; i < tamaño; i++) {
            System.out.println(listaPasswords[i].getContraseña() + "  →  Fuerte: " + fuertes[i]);
        }

        sc.close();
    }
}

