import java.util.Arrays;

public class Director {

    StudentBuilder studentBuilder;

    public Director(StudentBuilder studentBuilder){
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent(){

        if(studentBuilder instanceof EngineeringStudentBuilder){
            return createEngineeringStudent();
        }
        else if(studentBuilder instanceof MBAStudentBuilder){
            return createMBAStudent();
        }
        return null;
    }

    public Student createEngineeringStudent(){
        return studentBuilder.addRollNumber(79).addAge(26).addFirstName("Saswata").addLastName("Mukherjee").addSubjects(Arrays.asList("DSA","LLD","HLD")).build();

    }

    public Student createMBAStudent(){
        return studentBuilder.addRollNumber(80).addAge(28).addFirstName("Ram").addSubjects(Arrays.asList("Economics","GST","Tax")).build();
    }
}
