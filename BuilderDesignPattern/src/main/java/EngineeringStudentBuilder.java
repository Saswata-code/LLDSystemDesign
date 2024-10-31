import java.util.List;

public class EngineeringStudentBuilder extends StudentBuilder{

    public StudentBuilder addSubjects(List<String> subjects){
        this.subjects = subjects;
        return this;
    }
}
