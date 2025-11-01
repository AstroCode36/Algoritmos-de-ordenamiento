# CHEAT SHEET - Algoritmos de Ordenamiento y Búsqueda

## Resumen Rápido de Complejidades

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                    ALGORITMOS DE ORDENAMIENTO                               │
├──────────────────┬─────────────┬──────────────┬─────────────┬─────┬────────┤
│    Algoritmo     │ Mejor Caso  │ Caso Promedio│  Peor Caso  │Space│Estable │
├──────────────────┼─────────────┼──────────────┼─────────────┼─────┼────────┤
│ Selección        │   O(n²)     │    O(n²)     │    O(n²)    │ O(1)│   No   │
│ Inserción        │   O(n)      │    O(n²)     │    O(n²)    │ O(1)│   Sí   │
│ Burbuja          │   O(n)      │    O(n²)     │    O(n²)    │ O(1)│   Sí   │
│ Mezcla           │ O(n log n)  │  O(n log n)  │  O(n log n) │ O(n)│   Sí   │
│ Rápido           │ O(n log n)  │  O(n log n)  │    O(n²)    │O(log│   No   │
│                  │             │              │             │  n) │        │
├──────────────────┴─────────────┴──────────────┴─────────────┴─────┴────────┤
│                     ALGORITMO DE BÚSQUEDA                                   │
├──────────────────┬─────────────┬──────────────┬─────────────┬─────┬────────┤
│ Búsqueda Binaria │   O(1)      │   O(log n)   │   O(log n)  │ O(1)│   -    │
└──────────────────┴─────────────┴──────────────┴─────────────┴─────┴────────┘
```

## Comparación de Crecimiento

```
Para n = 100 elementos:

O(1)      →          1 operación         ⬛
O(log n)  →         ~7 operaciones       ⬛⬛⬛⬛⬛⬛⬛
O(n)      →        100 operaciones       ⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛ (x10)
O(n log n)→       ~700 operaciones       ⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛ (x70)
O(n²)     →     10,000 operaciones       ⬛⬛⬛⬛⬛⬛⬛⬛⬛⬛ (x1000)


Para n = 1,000 elementos:

O(1)      →             1 operación
O(log n)  →           ~10 operaciones
O(n)      →         1,000 operaciones
O(n log n)→        ~10,000 operaciones
O(n²)     →     1,000,000 operaciones  ← ¡Un millón!
```

## Cuándo Usar Cada Algoritmo

```
┌────────────────────────────────────────────────────────────────────┐
│                   GUÍA DE SELECCIÓN DE ALGORITMO                   │
├────────────────────────────────────────────────────────────────────┤
│                                                                    │
│  ARREGLOS PEQUEÑOS (n < 50)                                       │
│  ═══════════════════════════                                       │
│  ✓ Inserción        → Simple y eficiente                          │
│  ✓ Selección        → Pocos intercambios                          │
│  ✓ Burbuja          → Fácil de entender                           │
│                                                                    │
│  ARREGLOS MEDIANOS (50 < n < 1000)                                │
│  ═════════════════════════════════                                 │
│  ✓ Quick Sort       → Mejor rendimiento general                   │
│  ✓ Merge Sort       → Si necesitas estabilidad                    │
│                                                                    │
│  ARREGLOS GRANDES (n > 1000)                                      │
│  ═══════════════════════════                                       │
│  ✓ Quick Sort       → Rápido in-place                             │
│  ✓ Merge Sort       → Predecible O(n log n)                       │
│                                                                    │
│  ARREGLOS CASI ORDENADOS                                          │
│  ═══════════════════════                                           │
│  ✓ Inserción        → O(n) en mejor caso                          │
│  ✓ Burbuja          → Con optimización, detecta orden             │
│                                                                    │
│  NECESITAS ESTABILIDAD                                            │
│  ══════════════════════                                            │
│  ✓ Merge Sort       → Siempre estable                             │
│  ✓ Inserción        → Estable                                     │
│  ✓ Burbuja          → Estable                                     │
│                                                                    │
│  MEMORIA LIMITADA                                                 │
│  ═════════════════                                                 │
│  ✓ Quick Sort       → O(log n) espacio                            │
│  ✓ Inserción        → O(1) espacio                                │
│  ✗ Merge Sort       → Requiere O(n) espacio                       │
│                                                                    │
└────────────────────────────────────────────────────────────────────┘
```

## Visualización de Algoritmos

### Ordenamiento por Selección
```
Paso:  1         2         3         4         5
      [5 2 8 1] [1 2 8 5] [1 2 8 5] [1 2 5 8] [1 2 5 8]
       ↓ Busca   ↓ Busca   ↓ Busca   ↓ Busca    LISTO
       mínimo    mínimo    mínimo    mínimo

Idea: Busca el mínimo y lo coloca en su posición
```

### Ordenamiento por Inserción
```
Inicio:     [5 | 2 8 1]
Inserta 2:  [2 5 | 8 1]
Inserta 8:  [2 5 8 | 1]
Inserta 1:  [1 2 5 8 |]

Idea: Construye la parte ordenada insertando uno a uno
```

### Ordenamiento Burbuja
```
Pasada 1: [5 2 8 1] → [2 5 1 8]  (8 "burbujea" al final)
Pasada 2: [2 5 1 8] → [2 1 5 8]  (5 va a su lugar)
Pasada 3: [2 1 5 8] → [1 2 5 8]  (2 va a su lugar)

Idea: Elementos grandes "burbujean" hacia el final
```

### Ordenamiento por Mezcla
```
Divide:        [5 2 8 1]
              /          \
          [5 2]          [8 1]
          /    \         /    \
        [5]    [2]     [8]    [1]

Mezcla:       [2 5]          [1 8]
              \             /
               [1 2 5 8]

Idea: Divide y conquista - divide en mitades y mezcla ordenado
```

### Ordenamiento Rápido
```
[5 2 8 1 3]  pivote=3
     ↓
[2 1] 3 [5 8]  (menores | pivote | mayores)
  ↓       ↓
 [1 2]   [5 8]  (aplicar recursivamente)
     ↓
[1 2 3 5 8]

Idea: Particiona alrededor de un pivote recursivamente
```

### Búsqueda Binaria
```
Buscar 5 en: [1 2 3 5 8 9]

Paso 1: medio = 3, buscar en [5 8 9]
Paso 2: medio = 8, buscar en [5]
Paso 3: medio = 5, ¡encontrado!

Total: 3 comparaciones (vs 4 en búsqueda lineal)

Idea: Divide el espacio de búsqueda a la mitad
```

## Características Principales

```
┌──────────────────────────────────────────────────────────────────┐
│                    CARACTERÍSTICAS CLAVE                         │
├──────────────────┬───────────┬──────────┬───────────┬───────────┤
│    Algoritmo     │ In-Place  │ Estable  │ Adaptativo│  Recursivo│
├──────────────────┼───────────┼──────────┼───────────┼───────────┤
│ Selección        │    Sí     │    No    │    No     │    No     │
│ Inserción        │    Sí     │    Sí    │    Sí     │    No     │
│ Burbuja          │    Sí     │    Sí    │    Sí     │    No     │
│ Mezcla           │    No     │    Sí    │    No     │    Sí     │
│ Rápido           │    Sí     │    No    │    No     │    Sí     │
└──────────────────┴───────────┴──────────┴───────────┴───────────┘

Definiciones:
• In-Place:   No requiere memoria adicional significativa
• Estable:    Mantiene el orden relativo de elementos iguales
• Adaptativo: Se adapta a datos parcialmente ordenados
• Recursivo:  Usa recursión en su implementación
```

## Número de Operaciones

```
ALGORITMOS O(n²):
──────────────────
n = 10   →     100 operaciones
n = 50   →   2,500 operaciones
n = 100  →  10,000 operaciones
n = 500  → 250,000 operaciones

ALGORITMOS O(n log n):
──────────────────────
n = 10   →      33 operaciones  (↓ 67%)
n = 50   →     282 operaciones  (↓ 89%)
n = 100  →     664 operaciones  (↓ 93%)
n = 500  →   4,482 operaciones  (↓ 98%)

¡La diferencia crece exponencialmente!
```

## Pseudocódigo Simplificado

### Selección
```
para i = 0 hasta n-1:
    encontrar el mínimo en [i...n-1]
    intercambiar con posición i
```

### Inserción
```
para i = 1 hasta n-1:
    elemento = arreglo[i]
    insertar elemento en su lugar en [0...i-1]
```

### Burbuja
```
para i = 0 hasta n-1:
    para j = 0 hasta n-i-1:
        si arreglo[j] > arreglo[j+1]:
            intercambiar
```

### Mezcla
```
si arreglo tiene más de 1 elemento:
    dividir en dos mitades
    ordenar recursivamente cada mitad
    mezclar las dos mitades ordenadas
```

### Rápido
```
si bajo < alto:
    pivote = particionar(arreglo, bajo, alto)
    ordenar(arreglo, bajo, pivote-1)
    ordenar(arreglo, pivote+1, alto)
```

### Búsqueda Binaria
```
izq = 0, der = n-1
mientras izq <= der:
    medio = (izq + der) / 2
    si arreglo[medio] == buscado:
        retornar medio
    si arreglo[medio] < buscado:
        izq = medio + 1
    sino:
        der = medio - 1
retornar -1 (no encontrado)
```

## Tips de Implementación

```
┌─────────────────────────────────────────────────────────────────┐
│                        CONSEJOS PRÁCTICOS                       │
├─────────────────────────────────────────────────────────────────┤
│                                                                 │
│  1. SIEMPRE comenta tu código explicando cada paso             │
│                                                                 │
│  2. Usa nombres de variables descriptivos:                     │
│     ✓ indiceMinimo, elementoActual                             │
│     ✗ i, j, k (excepto para contadores simples)                │
│                                                                 │
│  3. Maneja casos especiales:                                   │
│     • Arreglo vacío                                            │
│     • Arreglo de un elemento                                   │
│     • Todos elementos iguales                                  │
│                                                                 │
│  4. Para búsqueda binaria:                                     │
│     • DEBE estar ordenado primero                              │
│     • Usa (izq + der) / 2 o izq + (der - izq) / 2              │
│                                                                 │
│  5. Para evitar overflow en Quick Sort:                        │
│     • Considera límite de recursión                            │
│     • Cambia a otro algoritmo para subarreglos pequeños        │
│                                                                 │
│  6. Prueba con diferentes tipos de datos:                      │
│     • Ya ordenados                                             │
│     • Orden inverso                                            │
│     • Aleatorios                                               │
│     • Con duplicados                                           │
│                                                                 │
└─────────────────────────────────────────────────────────────────┘
```

## Errores Comunes

```
❌ EVITA:
────────
1. No verificar que el arreglo esté ordenado antes de búsqueda binaria
2. Índices fuera de rango (off-by-one errors)
3. Comparar strings con == en lugar de .equals() o .compareTo()
4. No manejar casos base en recursión
5. Modificar el arreglo mientras se itera

✓ BUENAS PRÁCTICAS:
──────────────────
1. Validar entrada del usuario
2. Usar constantes para números mágicos
3. Separar lógica en métodos pequeños
4. Documentar complejidad temporal
5. Probar con casos extremos
```

## Fórmulas Útiles

```
COMPLEJIDAD TEMPORAL:
─────────────────────
• O(1):         Constante    → Acceso directo
• O(log n):     Logarítmica  → División repetida por 2
• O(n):         Lineal       → Un bucle simple
• O(n log n):   Loglineal    → Divide y conquista eficiente
• O(n²):        Cuadrática   → Dos bucles anidados
• O(2ⁿ):        Exponencial  → Recursión sin memorización

NÚMERO DE COMPARACIONES:
────────────────────────
• Selección:  n(n-1)/2        = O(n²)
• Inserción:  n(n-1)/2 (peor) = O(n²)
• Burbuja:    n(n-1)/2        = O(n²)
• Mezcla:     n log₂(n)       = O(n log n)
• Binaria:    log₂(n)         = O(log n)

ALTURA DE ÁRBOL:
────────────────
• Mezcla/Rápido:  log₂(n) niveles de recursión
```
