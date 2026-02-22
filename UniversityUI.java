import model.*;
import service.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/*
Clase: UniversityUI
Responsabilidad:
Proveer la interfaz gráfica del sistema universitario.
Permite seleccionar tetramestre, materia,
ingresar evaluaciones y calcular el promedio final.
*/

public class UniversityUI extends JFrame {

    // Servicios principales del sistema
    private AcademicService academicService;
    private StudentService studentService;

    // Estudiante actual en evaluación
    private Student student;

    // Componentes de selección
    private JComboBox<Integer> semesterBox;
    private JComboBox<String> subjectBox;

    // Campos de captura de calificaciones
    private JTextField projectsField;
    private JTextField homeworkField;
    private JTextField activitiesField;
    private JTextField partial1Field;
    private JTextField partial2Field;
    private JTextField finalField;

    // Etiqueta donde se muestra el resultado final
    private JLabel resultLabel;

    /*
    Constructor.
    Inicializa servicios, estudiante y construye la interfaz.
    */
    public UniversityUI() {

        academicService = new AcademicService();
        studentService = new StudentService();

        student = new Student(
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

        configureWindow();
        createMenu();
        buildInterface();

        setVisible(true);
    }

    /*
    Configuración general de la ventana principal.
    */
    private void configureWindow() {
        setTitle("Sistema de Gestión Universitaria");
        setSize(850, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /*
    Construye la barra de menú superior.
    */
    private void createMenu() {

        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Sistema");

        JMenuItem clear = new JMenuItem("Limpiar");
        clear.addActionListener(e -> clearFields());

        JMenuItem exit = new JMenuItem("Salir");
        exit.addActionListener(e -> System.exit(0));

        menu.add(clear);
        menu.addSeparator();
        menu.add(exit);

        bar.add(menu);
        setJMenuBar(bar);
    }

    /*
    Construye la estructura visual principal de la interfaz.
    */
    private void buildInterface() {

        setLayout(new BorderLayout(15, 15));

        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        leftPanel.setBackground(new Color(245, 247, 250));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        semesterBox = new JComboBox<>();
        for (int i = 1; i <= 9; i++) {
            semesterBox.addItem(i);
        }
        semesterBox.addActionListener(this::loadSubjects);

        subjectBox = new JComboBox<>();

        projectsField = createField();
        homeworkField = createField();
        activitiesField = createField();
        partial1Field = createField();
        partial2Field = createField();
        finalField = createField();

        int y = 0;

        addRow(leftPanel, gbc, y++, "Tetramestre:", semesterBox);
        addRow(leftPanel, gbc, y++, "Materia:", subjectBox);

        JLabel section = new JLabel("Evaluaciones");
        section.setFont(new Font("Segoe UI", Font.BOLD, 15));
        section.setHorizontalAlignment(SwingConstants.CENTER);
        section.setForeground(new Color(33, 150, 243));

        gbc.gridx = 0;
        gbc.gridy = y++;
        gbc.gridwidth = 2;
        leftPanel.add(section, gbc);
        gbc.gridwidth = 1;

        addRow(leftPanel, gbc, y++, "Proyectos:", projectsField);
        addRow(leftPanel, gbc, y++, "Tareas:", homeworkField);
        addRow(leftPanel, gbc, y++, "Actividades:", activitiesField);
        addRow(leftPanel, gbc, y++, "Parcial 1:", partial1Field);
        addRow(leftPanel, gbc, y++, "Parcial 2:", partial2Field);
        addRow(leftPanel, gbc, y++, "Final:", finalField);

        JButton calculate = new JButton("Calcular Promedio");
        calculate.setBackground(new Color(33, 150, 243));
        calculate.setForeground(Color.WHITE);
        calculate.setFocusPainted(false);
        calculate.addActionListener(this::calculateGrade);

        JButton clear = new JButton("Limpiar");
        clear.addActionListener(e -> clearFields());

        gbc.gridx = 0;
        gbc.gridy = y;
        leftPanel.add(calculate, gbc);

        gbc.gridx = 1;
        leftPanel.add(clear, gbc);

        y++;

        resultLabel = new JLabel("Promedio: ");
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        resultLabel.setForeground(new Color(0, 128, 0));

        gbc.gridx = 0;
        gbc.gridy = y;
        gbc.gridwidth = 2;
        leftPanel.add(resultLabel, gbc);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(new CompoundBorder(
                new TitledBorder("Datos del Alumno"),
                new EmptyBorder(15, 15, 15, 15)
        ));
        rightPanel.setBackground(new Color(230, 240, 255));

        rightPanel.add(createStudentLabel("Nombre: " + student.getFullName()));
        rightPanel.add(createStudentLabel("Edad: 37"));
        rightPanel.add(createStudentLabel("Género: Masculino"));
        rightPanel.add(createStudentLabel("Nacionalidad: Mexicano"));
        rightPanel.add(createStudentLabel("Dirección: MTY"));
        rightPanel.add(createStudentLabel("Teléfono Casa: 528140473087"));
        rightPanel.add(createStudentLabel("Celular: 528131112746"));

        add(leftPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);

        loadSubjects(null);
    }

    /*
    Agrega una fila de etiqueta + campo dentro del GridBagLayout.
    */
    private void addRow(JPanel panel, GridBagConstraints gbc, int y, String labelText, JComponent field) {

        gbc.gridx = 0;
        gbc.gridy = y;
        panel.add(new JLabel(labelText), gbc);

        gbc.gridx = 1;
        panel.add(field, gbc);
    }

    /*
    Crea un campo de texto estándar.
    */
    private JTextField createField() {
        return new JTextField();
    }

    /*
    Carga dinámicamente las materias según el tetramestre seleccionado.
    */
    private void loadSubjects(ActionEvent e) {

        subjectBox.removeAllItems();

        int semesterNumber = (int) semesterBox.getSelectedItem();
        List<Subject> subjects = academicService.getSubjectsBySemester(semesterNumber);

        for (Subject s : subjects) {
            subjectBox.addItem(s.getName());
        }
    }

    /*
    Valida que el campo contenga un número entre 0 y 100.
    Cambia el color del campo según el resultado.
    */
    private double validateField(JTextField field) throws Exception {

        try {
            double value = Double.parseDouble(field.getText());

            if (value < 0 || value > 100) {
                field.setBackground(new Color(255, 200, 200));
                throw new Exception();
            }

            field.setBackground(new Color(200, 255, 200));
            return value;

        } catch (Exception ex) {
            field.setBackground(new Color(255, 200, 200));
            throw new Exception();
        }
    }

    /*
    Procesa el cálculo del promedio final.
    */
    private void calculateGrade(ActionEvent e) {

        try {

            int semesterNumber = (int) semesterBox.getSelectedItem();
            Semester semester = new Semester(semesterNumber);

            academicService.addSemester(semester);
            academicService.enrollStudentInSemester(semester, student);

            String subjectName = (String) subjectBox.getSelectedItem();
            Subject selectedSubject = null;

            for (Subject s : academicService.getSubjectsBySemester(semesterNumber)) {
                if (s.getName().equals(subjectName)) {
                    selectedSubject = s;
                    break;
                }
            }

            double projects = validateField(projectsField);
            double homework = validateField(homeworkField);
            double activities = validateField(activitiesField);
            double partial1 = validateField(partial1Field);
            double partial2 = validateField(partial2Field);
            double finalExam = validateField(finalField);

            Evaluation evaluation = new Evaluation(
                    projects,
                    homework,
                    activities,
                    partial1,
                    partial2,
                    finalExam
            );

            academicService.registerEvaluation(student, selectedSubject, semester, evaluation);
            studentService.addAcademicRecord(
                    new AcademicRecord(student, selectedSubject, semester, evaluation)
            );

            double average = studentService.calculateStudentAverage(student);
            resultLabel.setText(String.format("Promedio: %.2f", average));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Revise los campos marcados en rojo.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
    Limpia todos los campos de captura.
    */
    private void clearFields() {

        projectsField.setText("");
        homeworkField.setText("");
        activitiesField.setText("");
        partial1Field.setText("");
        partial2Field.setText("");
        finalField.setText("");

        projectsField.setBackground(Color.WHITE);
        homeworkField.setBackground(Color.WHITE);
        activitiesField.setBackground(Color.WHITE);
        partial1Field.setBackground(Color.WHITE);
        partial2Field.setBackground(Color.WHITE);
        finalField.setBackground(Color.WHITE);

        resultLabel.setText("Promedio: ");
    }

    /*
    Crea una etiqueta formateada para mostrar datos del alumno.
    */
    private JLabel createStudentLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        label.setBorder(new EmptyBorder(5, 0, 5, 0));
        return label;
    }
}