import java.util.Scanner;

/**
 * Programa principal que implementa diversos algoritmos de ordenamiento y búsqueda
 * para arreglos de Strings (palabras).
 * 
 * @author Estudiante
 * @date 2025-10-31
 */
public class AlgoritmosOrdenamiento {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("  ALGORITMOS DE ORDENAMIENTO Y BÚSQUEDA");
        System.out.println("===========================================\n");
        
        // Solicitar el tamaño del arreglo al usuario
        System.out.print("Ingrese el tamaño del arreglo: ");
        int tamaño = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        
        // Crear y llenar el arreglo
        String[] palabras = new String[tamaño];
        System.out.println("\nIngrese las palabras:");
        for (int i = 0; i < tamaño; i++) {
            System.out.print("Palabra " + (i + 1) + ": ");
            palabras[i] = scanner.nextLine();
        }
        
        // Mostrar menú de algoritmos de ordenamiento
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n===========================================");
            System.out.println("  MENÚ DE ALGORITMOS DE ORDENAMIENTO");
            System.out.println("===========================================");
            System.out.println("1. Ordenamiento por Selección");
            System.out.println("2. Ordenamiento por Inserción");
            System.out.println("3. Ordenamiento Burbuja");
            System.out.println("4. Ordenamiento por Mezcla (Merge Sort)");
            System.out.println("5. Ordenamiento Rápido (Quick Sort)");
            System.out.println("6. Salir");
            System.out.print("\nSeleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            
            // Crear una copia del arreglo original para ordenar
            String[] arregloCopia = palabras.clone();
            
            switch (opcion) {
                case 1:
                    System.out.println("\n--- Ordenamiento por Selección ---");
                    ordenamientoSeleccion(arregloCopia);
                    mostrarArreglo(arregloCopia);
                    realizarBusquedaBinaria(arregloCopia);
                    break;
                case 2:
                    System.out.println("\n--- Ordenamiento por Inserción ---");
                    ordenamientoInsercion(arregloCopia);
                    mostrarArreglo(arregloCopia);
                    realizarBusquedaBinaria(arregloCopia);
                    break;
                case 3:
                    System.out.println("\n--- Ordenamiento Burbuja ---");
                    ordenamientoBurbuja(arregloCopia);
                    mostrarArreglo(arregloCopia);
                    realizarBusquedaBinaria(arregloCopia);
                    break;
                case 4:
                    System.out.println("\n--- Ordenamiento por Mezcla (Merge Sort) ---");
                    ordenamientoMezcla(arregloCopia, 0, arregloCopia.length - 1);
                    mostrarArreglo(arregloCopia);
                    realizarBusquedaBinaria(arregloCopia);
                    break;
                case 5:
                    System.out.println("\n--- Ordenamiento Rápido (Quick Sort) ---");
                    ordenamientoRapido(arregloCopia, 0, arregloCopia.length - 1);
                    mostrarArreglo(arregloCopia);
                    realizarBusquedaBinaria(arregloCopia);
                    break;
                case 6:
                    continuar = false;
                    System.out.println("\n¡Gracias por usar el programa!");
                    break;
                default:
                    System.out.println("\nOpción inválida. Intente nuevamente.");
            }
        }
        
        scanner.close();
    }
    
    /**
     * ALGORITMO DE ORDENAMIENTO POR SELECCIÓN
     * 
     * Complejidad Temporal: O(n²)
     * - Mejor caso: O(n²) - Siempre realiza todas las comparaciones
     * - Caso promedio: O(n²)
     * - Peor caso: O(n²)
     * 
     * Explicación: Este algoritmo divide el arreglo en dos partes: ordenada y desordenada.
     * En cada iteración, busca el elemento más pequeño en la parte desordenada y lo
     * coloca al final de la parte ordenada. Realiza n-1 pasadas, y en cada pasada
     * hace comparaciones lineales, resultando en complejidad cuadrática.
     * 
     * @param arreglo Arreglo de Strings a ordenar
     */
    public static void ordenamientoSeleccion(String[] arreglo) {
        int n = arreglo.length;
        
        // Recorrer todo el arreglo
        for (int i = 0; i < n - 1; i++) {
            // Encontrar el índice del elemento mínimo en la parte desordenada
            int indiceMinimo = i;
            
            // Buscar el elemento más pequeño en el resto del arreglo
            for (int j = i + 1; j < n; j++) {
                // Comparar lexicográficamente las palabras
                if (arreglo[j].compareToIgnoreCase(arreglo[indiceMinimo]) < 0) {
                    indiceMinimo = j;
                }
            }
            
            // Intercambiar el elemento mínimo encontrado con el primer elemento
            // de la parte desordenada
            if (indiceMinimo != i) {
                String temp = arreglo[i];
                arreglo[i] = arreglo[indiceMinimo];
                arreglo[indiceMinimo] = temp;
            }
        }
    }
    
    /**
     * ALGORITMO DE ORDENAMIENTO POR INSERCIÓN
     * 
     * Complejidad Temporal: O(n²)
     * - Mejor caso: O(n) - Cuando el arreglo ya está ordenado
     * - Caso promedio: O(n²)
     * - Peor caso: O(n²) - Cuando el arreglo está en orden inverso
     * 
     * Explicación: Similar a cómo ordenamos cartas en la mano. Construye el arreglo
     * ordenado insertando un elemento a la vez en su posición correcta. Es eficiente
     * para arreglos pequeños o casi ordenados, pero su complejidad cuadrática lo hace
     * ineficiente para conjuntos de datos grandes.
     * 
     * @param arreglo Arreglo de Strings a ordenar
     */
    public static void ordenamientoInsercion(String[] arreglo) {
        int n = arreglo.length;
        
        // Comenzar desde el segundo elemento (índice 1)
        for (int i = 1; i < n; i++) {
            // Guardar el elemento actual que se va a insertar
            String elementoActual = arreglo[i];
            int j = i - 1;
            
            // Mover los elementos mayores que elementoActual una posición adelante
            // para hacer espacio para la inserción
            while (j >= 0 && arreglo[j].compareToIgnoreCase(elementoActual) > 0) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            
            // Insertar el elemento en su posición correcta
            arreglo[j + 1] = elementoActual;
        }
    }
    
    /**
     * ALGORITMO DE ORDENAMIENTO BURBUJA
     * 
     * Complejidad Temporal: O(n²)
     * - Mejor caso: O(n) - Con optimización, cuando el arreglo ya está ordenado
     * - Caso promedio: O(n²)
     * - Peor caso: O(n²)
     * 
     * Explicación: Compara pares de elementos adyacentes repetidamente e intercambia
     * los que están en el orden incorrecto. Los elementos más grandes "burbujean"
     * hacia el final del arreglo. Aunque simple de implementar, es uno de los
     * algoritmos más ineficientes para grandes conjuntos de datos.
     * 
     * @param arreglo Arreglo de Strings a ordenar
     */
    public static void ordenamientoBurbuja(String[] arreglo) {
        int n = arreglo.length;
        boolean intercambio;
        
        // Realizar múltiples pasadas por el arreglo
        for (int i = 0; i < n - 1; i++) {
            intercambio = false;
            
            // En cada pasada, comparar elementos adyacentes
            for (int j = 0; j < n - i - 1; j++) {
                // Si el elemento actual es mayor que el siguiente, intercambiar
                if (arreglo[j].compareToIgnoreCase(arreglo[j + 1]) > 0) {
                    String temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                    intercambio = true;
                }
            }
            
            // Si no hubo intercambios, el arreglo ya está ordenado
            // (optimización para mejor caso)
            if (!intercambio) {
                break;
            }
        }
    }
    
    /**
     * ALGORITMO DE ORDENAMIENTO POR MEZCLA (MERGE SORT)
     * 
     * Complejidad Temporal: O(n log n)
     * - Mejor caso: O(n log n)
     * - Caso promedio: O(n log n)
     * - Peor caso: O(n log n)
     * 
     * Explicación: Es un algoritmo de "divide y conquista". Divide recursivamente
     * el arreglo en mitades hasta tener subarreglos de un elemento, luego los
     * mezcla ordenadamente. La división toma O(log n) niveles y cada nivel
     * requiere O(n) operaciones para mezclar, resultando en O(n log n).
     * Es estable y predecible, pero requiere espacio adicional O(n).
     * 
     * @param arreglo Arreglo de Strings a ordenar
     * @param izquierda Índice inicial del subarreglo
     * @param derecha Índice final del subarreglo
     */
    public static void ordenamientoMezcla(String[] arreglo, int izquierda, int derecha) {
        // Caso base: si hay más de un elemento
        if (izquierda < derecha) {
            // Encontrar el punto medio del arreglo
            int medio = izquierda + (derecha - izquierda) / 2;
            
            // Ordenar recursivamente la primera mitad
            ordenamientoMezcla(arreglo, izquierda, medio);
            
            // Ordenar recursivamente la segunda mitad
            ordenamientoMezcla(arreglo, medio + 1, derecha);
            
            // Mezclar las dos mitades ordenadas
            mezclar(arreglo, izquierda, medio, derecha);
        }
    }
    
    /**
     * Método auxiliar para mezclar dos subarreglos ordenados.
     * Combina arreglo[izquierda...medio] y arreglo[medio+1...derecha]
     * 
     * @param arreglo Arreglo que contiene los subarreglos
     * @param izquierda Índice inicial del primer subarreglo
     * @param medio Índice final del primer subarreglo
     * @param derecha Índice final del segundo subarreglo
     */
    private static void mezclar(String[] arreglo, int izquierda, int medio, int derecha) {
        // Calcular tamaños de los dos subarreglos a mezclar
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;
        
        // Crear arreglos temporales
        String[] arregloIzq = new String[n1];
        String[] arregloDer = new String[n2];
        
        // Copiar datos a los arreglos temporales
        for (int i = 0; i < n1; i++) {
            arregloIzq[i] = arreglo[izquierda + i];
        }
        for (int j = 0; j < n2; j++) {
            arregloDer[j] = arreglo[medio + 1 + j];
        }
        
        // Mezclar los arreglos temporales de vuelta al arreglo original
        int i = 0, j = 0;
        int k = izquierda;
        
        while (i < n1 && j < n2) {
            // Comparar elementos y copiar el menor al arreglo original
            if (arregloIzq[i].compareToIgnoreCase(arregloDer[j]) <= 0) {
                arreglo[k] = arregloIzq[i];
                i++;
            } else {
                arreglo[k] = arregloDer[j];
                j++;
            }
            k++;
        }
        
        // Copiar elementos restantes de arregloIzq, si hay alguno
        while (i < n1) {
            arreglo[k] = arregloIzq[i];
            i++;
            k++;
        }
        
        // Copiar elementos restantes de arregloDer, si hay alguno
        while (j < n2) {
            arreglo[k] = arregloDer[j];
            j++;
            k++;
        }
    }
    
    /**
     * ALGORITMO DE ORDENAMIENTO RÁPIDO (QUICK SORT)
     * 
     * Complejidad Temporal: O(n log n) en promedio, O(n²) en peor caso
     * - Mejor caso: O(n log n) - Cuando el pivote divide el arreglo en partes iguales
     * - Caso promedio: O(n log n)
     * - Peor caso: O(n²) - Cuando el pivote siempre es el menor o mayor elemento
     * 
     * Explicación: También usa "divide y conquista". Selecciona un elemento "pivote"
     * y particiona el arreglo de modo que elementos menores al pivote estén a la
     * izquierda y mayores a la derecha. Luego aplica recursivamente el mismo proceso
     * a las particiones. En promedio es muy eficiente O(n log n) y no requiere
     * espacio adicional significativo, aunque en el peor caso puede degradarse a O(n²).
     * 
     * @param arreglo Arreglo de Strings a ordenar
     * @param bajo Índice inicial del subarreglo
     * @param alto Índice final del subarreglo
     */
    public static void ordenamientoRapido(String[] arreglo, int bajo, int alto) {
        // Caso base: si hay más de un elemento
        if (bajo < alto) {
            // Encontrar el índice de partición
            // El pivote está ahora en su posición correcta
            int indicePivote = particionar(arreglo, bajo, alto);
            
            // Ordenar recursivamente los elementos antes del pivote
            ordenamientoRapido(arreglo, bajo, indicePivote - 1);
            
            // Ordenar recursivamente los elementos después del pivote
            ordenamientoRapido(arreglo, indicePivote + 1, alto);
        }
    }
    
    /**
     * Método auxiliar para particionar el arreglo alrededor de un pivote.
     * Coloca el pivote en su posición correcta y organiza elementos menores
     * a la izquierda y mayores a la derecha.
     * 
     * @param arreglo Arreglo a particionar
     * @param bajo Índice inicial
     * @param alto Índice final (se usa como pivote)
     * @return Índice de la posición final del pivote
     */
    private static int particionar(String[] arreglo, int bajo, int alto) {
        // Elegir el último elemento como pivote
        String pivote = arreglo[alto];
        
        // Índice del elemento más pequeño, indica la posición correcta
        // del pivote encontrada hasta ahora
        int i = bajo - 1;
        
        // Recorrer todos los elementos y compararlos con el pivote
        for (int j = bajo; j < alto; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (arreglo[j].compareToIgnoreCase(pivote) <= 0) {
                i++;
                // Intercambiar arreglo[i] y arreglo[j]
                String temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }
        
        // Intercambiar el pivote con el elemento en la posición i+1
        // para colocar el pivote en su posición correcta
        String temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[alto];
        arreglo[alto] = temp;
        
        return i + 1;
    }
    
    /**
     * ALGORITMO DE BÚSQUEDA BINARIA
     * 
     * Complejidad Temporal: O(log n)
     * - Mejor caso: O(1) - Cuando el elemento está en el medio
     * - Caso promedio: O(log n)
     * - Peor caso: O(log n)
     * 
     * Explicación: Es un algoritmo eficiente que requiere que el arreglo esté
     * ordenado. Divide repetidamente el espacio de búsqueda a la mitad comparando
     * el elemento buscado con el elemento medio. Si son iguales, se encontró;
     * si el buscado es menor, busca en la mitad izquierda; si es mayor, en la
     * derecha. Reduce el problema a la mitad en cada paso, logrando O(log n).
     * 
     * @param arreglo Arreglo ordenado donde buscar
     * @param palabraBuscada Palabra a buscar
     * @return Índice de la palabra si se encuentra, -1 si no está
     */
    public static int busquedaBinaria(String[] arreglo, String palabraBuscada) {
        int izquierda = 0;
        int derecha = arreglo.length - 1;
        
        // Mientras haya un espacio de búsqueda válido
        while (izquierda <= derecha) {
            // Calcular el índice del elemento medio
            int medio = izquierda + (derecha - izquierda) / 2;
            
            // Comparar la palabra del medio con la palabra buscada
            int comparacion = arreglo[medio].compareToIgnoreCase(palabraBuscada);
            
            // Si se encontró la palabra en el medio
            if (comparacion == 0) {
                return medio;
            }
            
            // Si la palabra buscada es mayor, ignorar la mitad izquierda
            if (comparacion < 0) {
                izquierda = medio + 1;
            }
            // Si la palabra buscada es menor, ignorar la mitad derecha
            else {
                derecha = medio - 1;
            }
        }
        
        // Si llegamos aquí, la palabra no está en el arreglo
        return -1;
    }
    
    /**
     * Método para mostrar el arreglo ordenado.
     * 
     * @param arreglo Arreglo a mostrar
     */
    private static void mostrarArreglo(String[] arreglo) {
        System.out.println("\nArreglo ordenado:");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println((i + 1) + ". " + arreglo[i]);
        }
    }
    
    /**
     * Método para realizar la búsqueda binaria interactiva.
     * Solicita al usuario una palabra y busca en el arreglo ordenado.
     * 
     * @param arreglo Arreglo ordenado donde buscar
     */
    private static void realizarBusquedaBinaria(String[] arreglo) {
        System.out.print("\n¿Desea buscar una palabra? (s/n): ");
        String respuesta = scanner.nextLine();
        
        if (respuesta.equalsIgnoreCase("s")) {
            System.out.print("Ingrese la palabra a buscar: ");
            String palabraBuscada = scanner.nextLine();
            
            int resultado = busquedaBinaria(arreglo, palabraBuscada);
            
            if (resultado != -1) {
                System.out.println("\n✓ Palabra encontrada en la posición: " + (resultado + 1));
            } else {
                System.out.println("\n✗ Palabra no encontrada en el arreglo.");
            }
        }
    }
}
