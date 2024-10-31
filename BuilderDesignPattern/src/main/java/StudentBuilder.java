import java.util.List;

public abstract class StudentBuilder {

    public int rollNumber;

    public int age;

    public String firstName;

    public String lastName;

    public String fatherName;

    public List<String> subjects;

    public StudentBuilder addRollNumber(int rollNumber){
        this.rollNumber = rollNumber;
        return this;
    }

    public StudentBuilder addAge(int age){
        this.age = age;
        return this;
    }

    public StudentBuilder addFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public StudentBuilder addLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public StudentBuilder addFatherName(String fatherName){
        this.fatherName = fatherName;
        return this;
    }

    abstract public StudentBuilder addSubjects(List<String> subjects);

    public Student build(){
        return new Student(this);
    }
}
