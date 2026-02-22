import model.*;
import service.*;

import java.util.List;
import java.util.Scanner;

public class Main {

public static void main(String[] args) {

Scanner scanner = new Scanner(System.in);

StudentService studentService = new StudentService();
AcademicService academicService = new AcademicService();

// Crear estudiante
Student student = new Student(
"Miguel Angel",
null,
"Valles",
"Olivares",
37,
"Masculino",
"Mexicano",
"MTY",
"528140473087",
"528131112746"
);

studentService.registerStudent(student);

// 1️ Preguntar tetramestre
System.out.print("Ingrese el número de tetramestre (1-9): ");
int semesterNumber = scanner.nextInt();

Semester semester = new Semester(semesterNumber);
academicService.addSemester(semester);
academicService.enrollStudentInSemester(semester, student);

// 2️ Mostrar materias disponibles
List<Subject> subjects = academicService.getSubjectsBySemester(semesterNumber);

System.out.println("\nMaterias disponibles:");
for (int i = 0; i < subjects.size(); i++) {
System.out.println((i + 1) + ". " + subjects.get(i).getName());
}

System.out.print("Seleccione una materia (número): ");
int subjectChoice = scanner.nextInt();

Subject selectedSubject = subjects.get(subjectChoice - 1);

// 3️ Pedir calificaciones
double projects = readGrade(scanner, "Proyectos: ");
double homework = readGrade(scanner, "Tareas: ");
double activities = readGrade(scanner, "Actividades: ");
double partial1 = readGrade(scanner, "Examen Parcial 1: ");
double partial2 = readGrade(scanner, "Examen Parcial 2: ");
double finalExam = readGrade(scanner, "Examen Final: ");


Evaluation evaluation;

try {
evaluation = new Evaluation(
projects,
homework,
activities,
partial1,
partial2,
finalExam
);
} catch (IllegalArgumentException e) {
System.out.println("Error: " + e.getMessage());
scanner.close();
return;
}


academicService.registerEvaluation(
student,
selectedSubject,
semester,
evaluation
);

studentService.addAcademicRecord(
new AcademicRecord(student, selectedSubject, semester, evaluation)
);

double average = studentService.calculateStudentAverage(student);

System.out.println("\n===== RESULTADO =====");
System.out.println("Alumno: " + student.getFullName());
System.out.println("Materia: " + selectedSubject.getName());
System.out.printf("Promedio general: %.2f%n", average);

scanner.close();
}
private static double readGrade(Scanner scanner, String message) {

while (true) {
System.out.print(message);

if (scanner.hasNextDouble()) {
double value = scanner.nextDouble();

if (value >= 0 && value <= 100) {
return value;
} else {
System.out.println("La calificación debe estar entre 0 y 100.");
}

} else {
System.out.println("Entrada inválida. Debe ingresar un número.");
scanner.next(); // limpiar entrada inválida
}
}
}

}
