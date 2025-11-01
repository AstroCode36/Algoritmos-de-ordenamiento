/**
 * Clase con ejemplos y casos de prueba para los algoritmos de ordenamiento.
 * Esta clase demuestra el uso de cada algoritmo con diferentes conjuntos de datos.
 */
public class EjemplosPrueba {
    
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("  EJEMPLOS DE ALGORITMOS DE ORDENAMIENTO");
        System.out.println("===========================================\n");
        
        // Ejemplo 1: Arreglo pequeño de frutas
        System.out.println("EJEMPLO 1: Frutas");
        System.out.println("-----------------");
        String[] frutas = {"manzana", "banana", "cereza", "durazno", "uva"};
        probarAlgoritmos(frutas);
        
        // Ejemplo 2: Arreglo con palabras repetidas
        System.out.println("\nEJEMPLO 2: Palabras con repetición");
        System.out.println("----------------------------------");
        String[] palabras = {"perro", "gato", "perro", "ave", "pez"};
        probarAlgoritmos(palabras);
        
        // Ejemplo 3: Arreglo ya ordenado (mejor caso para algunos algoritmos)
        System.out.println("\nEJEMPLO 3: Arreglo ya ordenado");
        System.out.println("-----------------------------");
        String[] ordenado = {"alfa", "beta", "delta", "gamma", "omega"};
        probarAlgoritmos(ordenado);
        
        // Ejemplo 4: Arreglo en orden inverso (peor caso para algunos algoritmos)
        System.out.println("\nEJEMPLO 4: Arreglo en orden inverso");
        System.out.println("-----------------------------------");
        String[] inverso = {"zorro", "vaca", "tigre", "oso", "abeja"};
        probarAlgoritmos(inverso);
        
        // Ejemplo 5: Búsqueda binaria
        System.out.println("\nEJEMPLO 5: Búsqueda Binaria");
        System.out.println("--------------------------");
        String[] animales = {"leon", "elefante", "jirafa", "mono", "zebra"};
        demostrarBusquedaBinaria(animales);
    }
    
    /**
     * Prueba todos los algoritmos de ordenamiento con un arreglo dado.
     */
    private static void probarAlgoritmos(String[] arreglo) {
        System.out.println("Arreglo original: " + arrayToString(arreglo));
        
        // Probar Ordenamiento por Selección
        String[] copia1 = arreglo.clone();
        AlgoritmosOrdenamiento.ordenamientoSeleccion(copia1);
        System.out.println("Selección:        " + arrayToString(copia1));
        
        // Probar Ordenamiento por Inserción
        String[] copia2 = arreglo.clone();
        AlgoritmosOrdenamiento.ordenamientoInsercion(copia2);
        System.out.println("Inserción:        " + arrayToString(copia2));
        
        // Probar Ordenamiento Burbuja
        String[] copia3 = arreglo.clone();
        AlgoritmosOrdenamiento.ordenamientoBurbuja(copia3);
        System.out.println("Burbuja:          " + arrayToString(copia3));
        
        // Probar Ordenamiento por Mezcla
        String[] copia4 = arreglo.clone();
        AlgoritmosOrdenamiento.ordenamientoMezcla(copia4, 0, copia4.length - 1);
        System.out.println("Mezcla:           " + arrayToString(copia4));
        
        // Probar Ordenamiento Rápido
        String[] copia5 = arreglo.clone();
        AlgoritmosOrdenamiento.ordenamientoRapido(copia5, 0, copia5.length - 1);
        System.out.println("Rápido:           " + arrayToString(copia5));
    }
    
    /**
     * Demuestra el funcionamiento de la búsqueda binaria.
     */
    private static void demostrarBusquedaBinaria(String[] arreglo) {
        System.out.println("Arreglo original: " + arrayToString(arreglo));
        
        // Primero ordenar el arreglo
        AlgoritmosOrdenamiento.ordenamientoRapido(arreglo, 0, arreglo.length - 1);
        System.out.println("Arreglo ordenado: " + arrayToString(arreglo));
        
        // Buscar elementos que existen
        String[] buscar = {"jirafa", "zebra", "elefante", "tigre"};
        System.out.println("\nBúsquedas:");
        for (String palabra : buscar) {
            int resultado = AlgoritmosOrdenamiento.busquedaBinaria(arreglo, palabra);
            if (resultado != -1) {
                System.out.println("✓ '" + palabra + "' encontrada en posición " + (resultado + 1));
            } else {
                System.out.println("✗ '" + palabra + "' no encontrada");
            }
        }
    }
    
    /**
     * Convierte un arreglo a String para facilitar la visualización.
     */
    private static String arrayToString(String[] arreglo) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arreglo.length; i++) {
            sb.append(arreglo[i]);
            if (i < arreglo.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
