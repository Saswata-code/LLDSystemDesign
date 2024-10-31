public class Client {
    public static void main(String[] args){
        Director director1 = new Director(new EngineeringStudentBuilder());
        Student enggStudent = director1.createStudent();
        System.out.println(enggStudent.toString());

        Director director2 = new Director(new MBAStudentBuilder());
        Student mbaStudent = director2.createStudent();
        System.out.println(mbaStudent.toString());
    }
}
