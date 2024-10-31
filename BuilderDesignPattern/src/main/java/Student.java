import java.util.List;

public class Student {

    public int rollNumber;

    public int age;

    public String firstName;

    public String lastName;

    public String fatherName;

    public List<String> subjects;

    public Student(StudentBuilder studentBuilder){
        this.rollNumber = studentBuilder.rollNumber;
        this.age = studentBuilder.age;
        this.firstName = studentBuilder.firstName;
        this.lastName = studentBuilder.lastName;
        this.fatherName = studentBuilder.fatherName;
        this.subjects = studentBuilder.subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", subjects=" + subjects.get(0) + " ," + subjects.get(1) + " ," + subjects.get(2) +
                '}';
    }
}
