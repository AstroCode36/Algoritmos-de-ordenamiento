import java.util.Scanner;

/**
 * Clase principal con menú de selección para ejecutar diferentes programas.
 * 
 * @author Estudiante
 * @date 2025-10-31
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===========================================");
        System.out.println("  SISTEMA DE ALGORITMOS DE ORDENAMIENTO");
        System.out.println("===========================================\n");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Ejecutar programa interactivo (ingresar sus propias palabras)");
        System.out.println("2. Ejecutar ejemplos de prueba automáticos");
        System.out.println("3. Salir");
        System.out.print("\nIngrese su opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        System.out.println(); // Línea en blanco para separar
        
        if (opcion == 1) {
            // Ejecutar el programa interactivo
            AlgoritmosOrdenamiento.main(new String[0]);
        } else if (opcion == 2) {
            // Ejecutar los ejemplos de prueba
            EjemplosPrueba.main(new String[0]);
        } else if (opcion == 3) {
            System.out.println("¡Hasta luego!");
        } else {
            System.out.println("Opción inválida. Por favor, ejecute el programa nuevamente.");
        }
        
        scanner.close();
    }
}