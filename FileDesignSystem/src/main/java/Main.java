
public class Main {
    public static void main(String[] args){

        Directory comedyDirectory = new Directory("Comedy Directory");
        comedyDirectory.add(new File("Dhamaal"));

        Directory movieDirectory = new Directory("Movie Directory");
        movieDirectory.add(comedyDirectory);
        movieDirectory.add(new File("Rajneeti"));

        movieDirectory.ls();


    }
}
