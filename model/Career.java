package model;

/*
Clase: Career
Responsabilidad:
Representar una carrera académica dentro del sistema,
incluyendo su nombre y el conjunto de materias que la conforman.
*/

import java.util.List;

public class Career {

    // Nombre oficial de la carrera (Ingeniería, Licenciatura, etc.)
    private String name;

    // Materias que forman parte del plan de estudios
    private List<Subject> subjects;

    /*
    Constructor.
    Inicializa el nombre de la carrera y su plan de estudios asociado.
    */
    public Career(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    /*
    Devuelve el nombre de la carrera.
    */
    public String getName() {
        return name;
    }

    /*
    Devuelve la lista de materias que pertenecen a la carrera.
    */
    public List<Subject> getSubjects() {
        return subjects;
    }
}