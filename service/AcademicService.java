package service;

/*
Clase: AcademicService
Responsabilidad:
Gestionar la estructura académica del sistema:
- Catálogo oficial de materias
- Administración de semestres
- Registro de evaluaciones académicas
*/

import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AcademicService {

    // Semestres creados dentro del sistema
    private List<Semester> semesters;

    // Registros académicos generados a partir de evaluaciones
    private List<AcademicRecord> academicRecords;

    // Catálogo general de materias organizadas por tetramestre
    private List<Subject> subjectCatalog;

    /*
    Constructor principal.
    Inicializa las estructuras internas y carga el plan académico.
    */
    public AcademicService() {
        this.semesters = new ArrayList<>();
        this.academicRecords = new ArrayList<>();
        this.subjectCatalog = new ArrayList<>();
        initializeSubjects();
    }

    /*
    Carga el plan académico completo organizado por tetramestres.
    Funciona como catálogo base del sistema.
    */
    private void initializeSubjects() {

        // Tetramestre 1
        subjectCatalog.add(new Subject("Matemáticas Básicas", 1, 8));
        subjectCatalog.add(new Subject("Introducción a la Programación", 1, 8));
        subjectCatalog.add(new Subject("Lógica Matemática", 1, 6));
        subjectCatalog.add(new Subject("Comunicación Oral y Escrita", 1, 6));
        subjectCatalog.add(new Subject("Fundamentos de Ingeniería", 1, 6));
        subjectCatalog.add(new Subject("Álgebra Lineal", 1, 8));

        // Tetramestre 2
        subjectCatalog.add(new Subject("Cálculo Diferencial", 2, 8));
        subjectCatalog.add(new Subject("Programación Orientada a Objetos", 2, 8));
        subjectCatalog.add(new Subject("Arquitectura de Computadoras", 2, 6));
        subjectCatalog.add(new Subject("Probabilidad y Estadística", 2, 6));
        subjectCatalog.add(new Subject("Base de Datos I", 2, 8));
        subjectCatalog.add(new Subject("Ética Profesional", 2, 4));

        // Tetramestre 3
        subjectCatalog.add(new Subject("Cálculo Integral", 3, 8));
        subjectCatalog.add(new Subject("Estructuras de Datos", 3, 8));
        subjectCatalog.add(new Subject("Base de Datos II", 3, 8));
        subjectCatalog.add(new Subject("Sistemas Operativos", 3, 8));
        subjectCatalog.add(new Subject("Física", 3, 6));
        subjectCatalog.add(new Subject("Redes I", 3, 6));

        // Tetramestre 4
        subjectCatalog.add(new Subject("Programación Web", 4, 8));
        subjectCatalog.add(new Subject("Ecuaciones Diferenciales", 4, 8));
        subjectCatalog.add(new Subject("Redes II", 4, 6));
        subjectCatalog.add(new Subject("Ingeniería de Software", 4, 8));
        subjectCatalog.add(new Subject("Investigación de Operaciones", 4, 6));
        subjectCatalog.add(new Subject("Métodos Numéricos", 4, 6));

        // Tetramestre 5
        subjectCatalog.add(new Subject("Inteligencia Artificial", 5, 8));
        subjectCatalog.add(new Subject("Compiladores", 5, 8));
        subjectCatalog.add(new Subject("Administración de Proyectos", 5, 6));
        subjectCatalog.add(new Subject("Seguridad Informática", 5, 6));
        subjectCatalog.add(new Subject("Desarrollo Móvil", 5, 8));
        subjectCatalog.add(new Subject("Electrónica Digital", 5, 6));

        // Tetramestre 6
        subjectCatalog.add(new Subject("Machine Learning", 6, 8));
        subjectCatalog.add(new Subject("Sistemas Distribuidos", 6, 8));
        subjectCatalog.add(new Subject("Auditoría de Sistemas", 6, 6));
        subjectCatalog.add(new Subject("Arquitectura de Software", 6, 8));
        subjectCatalog.add(new Subject("Emprendimiento Tecnológico", 6, 6));
        subjectCatalog.add(new Subject("Computación en la Nube", 6, 8));

        // Tetramestre 7
        subjectCatalog.add(new Subject("Big Data", 7, 8));
        subjectCatalog.add(new Subject("DevOps", 7, 6));
        subjectCatalog.add(new Subject("Robótica", 7, 6));
        subjectCatalog.add(new Subject("Simulación", 7, 6));
        subjectCatalog.add(new Subject("Blockchain", 7, 6));
        subjectCatalog.add(new Subject("Optativa I", 7, 6));

        // Tetramestre 8
        subjectCatalog.add(new Subject("Ciencia de Datos", 8, 8));
        subjectCatalog.add(new Subject("Ciberseguridad Avanzada", 8, 8));
        subjectCatalog.add(new Subject("IoT", 8, 6));
        subjectCatalog.add(new Subject("Optativa II", 8, 6));
        subjectCatalog.add(new Subject("Gestión Empresarial", 8, 6));
        subjectCatalog.add(new Subject("Proyecto Integrador I", 8, 8));

        // Tetramestre 9
        subjectCatalog.add(new Subject("Proyecto Integrador II", 9, 8));
        subjectCatalog.add(new Subject("Residencia Profesional", 9, 12));
        subjectCatalog.add(new Subject("Seminario de Investigación", 9, 6));
        subjectCatalog.add(new Subject("Legislación Informática", 9, 6));
        subjectCatalog.add(new Subject("Optativa III", 9, 6));
        subjectCatalog.add(new Subject("Ética en IA", 9, 6));
    }

    /*
    Devuelve las materias correspondientes a un tetramestre específico.
    Incluye validación para evitar valores fuera de rango.
    */
    public List<Subject> getSubjectsBySemester(int semesterNumber) {

        if (semesterNumber < 1 || semesterNumber > 9) {
            throw new IllegalArgumentException("El tetramestre debe estar entre 1 y 9.");
        }

        List<Subject> result = new ArrayList<>();

        for (Subject s : subjectCatalog) {
            if (s.getSemester() == semesterNumber) {
                result.add(s);
            }
        }

        return result;
    }

    /*
    Devuelve el catálogo completo en modo solo lectura
    para evitar modificaciones externas.
    */
    public List<Subject> getAllSubjects() {
        return Collections.unmodifiableList(subjectCatalog);
    }

    /*
    Registra un nuevo semestre en el sistema y asigna
    automáticamente las materias correspondientes.
    */
    public void addSemester(Semester semester) {

        if (semester.getNumber() < 1 || semester.getNumber() > 9) {
            throw new IllegalArgumentException("Tetramestre inválido.");
        }

        semesters.add(semester);

        List<Subject> subjects = getSubjectsBySemester(semester.getNumber());
        for (Subject s : subjects) {
            semester.addSubject(s);
        }
    }

    /*
    Inscribe un estudiante dentro de un semestre determinado.
    */
    public void enrollStudentInSemester(Semester semester, Student student) {
        semester.enrollStudent(student);
    }

    /*
    Registra formalmente una evaluación académica
    vinculando estudiante, materia y semestre.
    */
    public void registerEvaluation(Student student,
                                   Subject subject,
                                   Semester semester,
                                   Evaluation evaluation) {

        AcademicRecord record =
                new AcademicRecord(student, subject, semester, evaluation);

        academicRecords.add(record);
    }

    /*
    Devuelve todos los registros académicos generados.
    */
    public List<AcademicRecord> getAcademicRecords() {
        return Collections.unmodifiableList(academicRecords);
    }
}