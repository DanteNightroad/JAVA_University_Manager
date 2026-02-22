package model;

/*
Clase: Subject
Responsabilidad:
Representar una materia dentro del plan académico,
incluyendo su nombre, tetramestre y número de créditos.
*/

public class Subject {

    // Nombre oficial de la materia
    private String name;

    // Número de tetramestre al que pertenece
    private int semester;

    // Cantidad de créditos académicos
    private int credits;

    /*
    Constructor.
    Inicializa los datos básicos de la materia.
    */
    public Subject(String name, int semester, int credits) {
        this.name = name;
        this.semester = semester;
        this.credits = credits;
    }

    /*
    Devuelve el nombre de la materia.
    */
    public String getName() {
        return name;
    }

    /*
    Devuelve el tetramestre al que pertenece la materia.
    */
    public int getSemester() {
        return semester;
    }

    /*
    Devuelve la cantidad de créditos asignados.
    */
    public int getCredits() {
        return credits;
    }

    /*
    Representación textual de la materia.
    Útil para interfaces o impresión en consola.
    */
    @Override
    public String toString() {
        return name + " (Tetra " + semester + ")";
    }
}