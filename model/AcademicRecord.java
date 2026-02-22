package model;

/*
Clase: AcademicRecord
Responsabilidad:
Representar el vínculo académico entre un estudiante,
una materia y un tetramestre específico,
incluyendo la evaluación obtenida.
*/

public class AcademicRecord {

    // Estudiante al que pertenece el registro
    private Student student;

    // Materia evaluada
    private Subject subject;

    // Tetramestre en el que se cursó la materia
    private Semester semester;

    // Evaluación aplicada a la materia
    private Evaluation evaluation;

    /*
    Constructor.
    Crea un registro académico asociando estudiante,
    materia, semestre y evaluación.
    */
    public AcademicRecord(Student student,
                          Subject subject,
                          Semester semester,
                          Evaluation evaluation) {

        this.student = student;
        this.subject = subject;
        this.semester = semester;
        this.evaluation = evaluation;
    }

    /*
    Devuelve la calificación final calculada
    a partir de la evaluación asociada.
    */
    public double getFinalGrade() {
        return evaluation.calculateFinalGrade();
    }

    /*
    Devuelve el estudiante asociado al registro.
    */
    public Student getStudent() {
        return student;
    }

    /*
    Devuelve la materia evaluada.
    */
    public Subject getSubject() {
        return subject;
    }

    /*
    Devuelve el tetramestre correspondiente.
    */
    public Semester getSemester() {
        return semester;
    }
}