# Algoritmos de Ordenamiento y Búsqueda en Java

## Descripción del Proyecto

Este programa implementa 5 algoritmos de ordenamiento y búsqueda binaria para arreglos de palabras (Strings) en Java. El usuario puede definir el tamaño del arreglo, llenarlo con palabras, elegir un algoritmo de ordenamiento y luego realizar búsquedas binarias.

## Algoritmos Implementados

### Algoritmos de Ordenamiento

1. **Ordenamiento por Selección**
   - Complejidad: O(n²)
   - Busca el elemento mínimo y lo coloca en su posición

2. **Ordenamiento por Inserción**
   - Complejidad: O(n²) en promedio, O(n) en mejor caso
   - Construye el arreglo ordenado insertando elementos uno por uno

3. **Ordenamiento Burbuja**
   - Complejidad: O(n²)
   - Compara elementos adyacentes e intercambia los desordenados

4. **Ordenamiento por Mezcla (Merge Sort)**
   - Complejidad: O(n log n)
   - Divide el arreglo recursivamente y mezcla las partes ordenadas

5. **Ordenamiento Rápido (Quick Sort)**
   - Complejidad: O(n log n) en promedio, O(n²) en peor caso
   - Particiona el arreglo alrededor de un pivote recursivamente

### Algoritmo de Búsqueda

- **Búsqueda Binaria**
  - Complejidad: O(log n)
  - Busca eficientemente en arreglos ordenados dividiendo el espacio de búsqueda

## Cómo Ejecutarlo

### VS Code
F5 en el archivo java

### IntelliJ
Click al run

## Proceso del programa

1. Al iniciar, el programa solicitará el tamaño del arreglo
2. Ingrese cada palabra cuando se le solicite
3. Seleccione un algoritmo de ordenamiento del menú (1-5)
4. El programa mostrará el arreglo ordenado
5. Opcionalmente, puede realizar una búsqueda binaria de una palabra
6. Puede probar diferentes algoritmos con el mismo arreglo
7. Seleccione la opción 6 para salir

## 📁 Estructura de directorios

```
Dani/src
│
├── 💻 CÓDIGO FUENTE
│   ├── AlgoritmosOrdenamiento.java    ⭐ Programa principal interactivo
│   └── EjemplosPrueba.java            ⭐ Programa de ejemplos automáticos
│
└── 📖 DOCUMENTACIÓN
    └──README.md                       ⭐ Inicio - Descripción general
```

## Ejemplo de Uso

```
===========================================
  ALGORITMOS DE ORDENAMIENTO Y BÚSQUEDA
===========================================

Ingrese el tamaño del arreglo: 5

Ingrese las palabras:
Palabra 1: manzana
Palabra 2: banana
Palabra 3: cereza
Palabra 4: durazno
Palabra 5: uva

===========================================
  MENÚ DE ALGORITMOS DE ORDENAMIENTO
===========================================
1. Ordenamiento por Selección
2. Ordenamiento por Inserción
3. Ordenamiento Burbuja
4. Ordenamiento por Mezcla (Merge Sort)
5. Ordenamiento Rápido (Quick Sort)
6. Salir

Seleccione una opción: 4

--- Ordenamiento por Mezcla (Merge Sort) ---

Arreglo ordenado:
1. banana
2. cereza
3. durazno
4. manzana
5. uva

¿Desea buscar una palabra? (s/n): s
Ingrese la palabra a buscar: cereza

✓ Palabra encontrada en la posición: 2
```

## Stack
- **Lenguaje**: Java

## Complejidad Temporal - Resumen

| Algoritmo | Mejor Caso | Caso Promedio | Peor Caso |
|-----------|------------|---------------|-----------|
| Selección | O(n²) | O(n²) | O(n²) |
| Inserción | O(n) | O(n²) | O(n²) |
| Burbuja | O(n) | O(n²) | O(n²) |
| Mezcla | O(n log n) | O(n log n) | O(n log n) |
| Rápido | O(n log n) | O(n log n) | O(n²) |
| Búsqueda Binaria | O(1) | O(log n) | O(log n) |

## Notas Importantes

- La búsqueda binaria **requiere** que el arreglo esté ordenado
- El programa crea una copia del arreglo original para cada ordenamiento
- Los algoritmos Merge Sort y Quick Sort son recursivos
- Todos los algoritmos están implementados como métodos estáticos
- Las comparaciones de strings son case-insensitive para mejor usabilidad

## Autor

Desarrollado por Daniel Guzman.

## Licencia

Licencia MIT