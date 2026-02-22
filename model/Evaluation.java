package model;

/*
Clase: Evaluation
Responsabilidad:
Representar el conjunto de calificaciones obtenidas por un estudiante
en una materia específica y calcular su promedio final ponderado.
*/

public class Evaluation {

    // Componentes de evaluación
    private double projects;
    private double homework;
    private double activities;
    private double partialExam1;
    private double partialExam2;
    private double finalExam;

    /*
    Constructor.
    Valida que todas las calificaciones se encuentren dentro del rango permitido (0–100).
    */
    public Evaluation(double projects,
                      double homework,
                      double activities,
                      double partialExam1,
                      double partialExam2,
                      double finalExam) {

        this.projects = validateGrade(projects);
        this.homework = validateGrade(homework);
        this.activities = validateGrade(activities);
        this.partialExam1 = validateGrade(partialExam1);
        this.partialExam2 = validateGrade(partialExam2);
        this.finalExam = validateGrade(finalExam);
    }

    /*
    Valida que una calificación esté dentro del rango válido.
    */
    private double validateGrade(double grade) {

        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Las calificaciones deben estar entre 0 y 100.");
        }

        return grade;
    }

    /*
    Calcula la calificación final ponderada de la materia.
    La distribución está basada en el esquema definido por el sistema.
    */
    public double calculateFinalGrade() {

        return (projects * 0.2) +
               (homework * 0.2) +
               (activities * 0.1) +
               (partialExam1 * 0.1) +
               (partialExam2 * 0.1) +
               (finalExam * 0.3);
    }
}