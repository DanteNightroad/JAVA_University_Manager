package model;

/*
Clase: Semester
Responsabilidad:
Representar un tetramestre dentro del sistema académico,
incluyendo las materias y estudiantes asociados.
*/

import java.util.ArrayList;
import java.util.List;

public class Semester {

    // Número de tetramestre (1 al 9)
    private int number;

    // Materias asignadas al tetramestre
    private List<Subject> subjects;

    // Estudiantes inscritos en el tetramestre
    private List<Student> students;

    /*
    Constructor.
    Inicializa el número del tetramestre y las listas internas.
    */
    public Semester(int number) {
        this.number = number;
        this.subjects = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    /*
    Devuelve el número del tetramestre.
    */
    public int getNumber() {
        return number;
    }

    /*
    Agrega una materia al tetramestre.
    */
    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    /*
    Inscribe un estudiante en el tetramestre.
    */
    public void enrollStudent(Student student) {
        students.add(student);
    }

    /*
    Devuelve la lista de materias asignadas.
    */
    public List<Subject> getSubjects() {
        return subjects;
    }

    /*
    Devuelve la lista de estudiantes inscritos.
    */
    public List<Student> getStudents() {
        return students;
    }
}