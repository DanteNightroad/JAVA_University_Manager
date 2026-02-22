package model;

/*
Clase: Student
Responsabilidad:
Representar la información personal básica de un estudiante
dentro del sistema académico.
*/

public class Student {

    // Datos personales principales
    private String firstName;
    private String middleName;      // Puede ser null (opcional)
    private String lastName;
    private String motherLastName;

    // Información demográfica
    private int age;
    private String gender;
    private String nationality;

    // Información de contacto
    private String address;
    private String homePhone;
    private String mobilePhone;

    /*
    Constructor.
    Inicializa los datos personales y de contacto del estudiante.
    */
    public Student(String firstName,
                   String middleName,
                   String lastName,
                   String motherLastName,
                   int age,
                   String gender,
                   String nationality,
                   String address,
                   String homePhone,
                   String mobilePhone) {

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.motherLastName = motherLastName;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
        this.address = address;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
    }

    /*
    Devuelve el nombre completo del estudiante.
    Considera que el segundo nombre puede ser opcional.
    */
    public String getFullName() {

        return firstName + " " +
               (middleName != null ? middleName + " " : "") +
               lastName + " " +
               motherLastName;
    }
}