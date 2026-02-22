package model;

/*
Clase: Teacher
Responsabilidad:
Representar a un docente dentro del sistema
y gestionar las materias que tiene asignadas.
*/

import java.util.ArrayList;
import java.util.List;

public class Teacher {

    // Nombre completo del docente
    private String name;

    // Materias asignadas al docente (máximo 3 por tetramestre)
    private List<Subject> assignedSubjects;

    /*
    Constructor.
    Inicializa el nombre del docente y su lista de materias asignadas.
    */
    public Teacher(String name) {
        this.name = name;
        this.assignedSubjects = new ArrayList<>();
    }

    /*
    Asigna una materia al docente.
    Se limita a un máximo de tres materias.
    */
    public void assignSubject(Subject subject) {

        if (assignedSubjects.size() < 3) {
            assignedSubjects.add(subject);
        } else {
            System.out.println("No se pueden asignar más de 3 materias.");
        }
    }

    /*
    Devuelve el nombre del docente.
    */
    public String getName() {
        return name;
    }

    /*
    Devuelve la lista de materias asignadas.
    */
    public List<Subject> getAssignedSubjects() {
        return assignedSubjects;
    }
}