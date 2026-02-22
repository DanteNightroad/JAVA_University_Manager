package service;

/*
Clase: StudentService
Responsabilidad:
Gestionar el registro de estudiantes dentro del sistema
y calcular su desempeño académico a partir de evaluaciones registradas.
*/

import model.Student;
import model.AcademicRecord;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    // Estudiantes registrados en el sistema
    private List<Student> students;

    // Registros académicos asociados a los estudiantes
    private List<AcademicRecord> records;

    /*
    Constructor.
    Inicializa las estructuras internas necesarias
    para almacenar estudiantes y evaluaciones.
    */
    public StudentService() {
        this.students = new ArrayList<>();
        this.records = new ArrayList<>();
    }

    /*
    Registra un nuevo estudiante en el sistema.
    */
    public void registerStudent(Student student) {
        students.add(student);
    }

    /*
    Busca un estudiante por su nombre completo.
    La comparación no distingue entre mayúsculas y minúsculas.
    */
    public Student findStudentByName(String fullName) {

        for (Student s : students) {
            if (s.getFullName().equalsIgnoreCase(fullName)) {
                return s;
            }
        }

        return null;
    }

    /*
    Agrega un registro académico generado
    como resultado de una evaluación.
    */
    public void addAcademicRecord(AcademicRecord record) {
        records.add(record);
    }

    /*
    Calcula el promedio general del estudiante
    considerando todas las materias evaluadas.
    */
    public double calculateStudentAverage(Student student) {

        double total = 0;
        int count = 0;

        for (AcademicRecord record : records) {
            if (record.getStudent().equals(student)) {
                total += record.getFinalGrade();
                count++;
            }
        }

        // Evita división entre cero si no existen registros
        if (count == 0) {
            return 0;
        }

        return total / count;
    }

    /*
    Devuelve la lista completa de estudiantes registrados.
    */
    public List<Student> getAllStudents() {
        return students;
    }
}