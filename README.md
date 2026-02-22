# Sistema de Gestión Universitaria

Proyecto desarrollado en Java como aplicación académica para la gestión básica de:

- Estudiantes
- Materias
- Tetramestres
- Evaluaciones
- Cálculo de promedios

El sistema permite registrar evaluaciones y calcular automáticamente el promedio final ponderado de cada materia.

---

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes:

- `model` → Contiene las clases del dominio (Student, Subject, Semester, etc.)
- `service` → Contiene la lógica de negocio (StudentService, AcademicService)
- `UniversityUI` → Interfaz gráfica
- `Main` y `Main2` → Puntos de entrada del sistema

---

## Modos de Ejecución

El sistema puede ejecutarse de dos maneras:

### 1. Modo Consola

Archivo: `Main`

Ejecuta el sistema utilizando entrada y salida por consola.
Permite ingresar datos manualmente desde la terminal.
java Main
---

### 2. Modo Interfaz Gráfica

Archivo: `Main2`

Inicia la aplicación con una interfaz gráfica basada en Swing.
Permite seleccionar tetramestre, materia e ingresar evaluaciones de forma visual.

java Main2
---

## Requisitos

- Java JDK 17 o superior
- Compilación mediante: javac model/.java service/.java *.java
  

---

## Funcionalidades Principales

- Validación de calificaciones (0–100)
- Cálculo ponderado del promedio final
- Organización por tetramestres
- Asignación automática de materias por semestre
- Interfaz gráfica interactiva

---

## Autor:
Miguel Angel Valles Olivares

Proyecto académico desarrollado como práctica de Programación Orientada a Objetos.
