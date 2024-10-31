import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {

    String directoryName;

    List<FileSystem> fileSystems;

    public Directory(String directoryName){
        this.directoryName = directoryName;
        fileSystems = new ArrayList<>();
    }

    public void add(FileSystem fileSystem){
        fileSystems.add(fileSystem);
    }

    @Override
    public void ls() {
        for(FileSystem fileSystem : fileSystems){
            System.out.println("The directory Name is: "+ directoryName);
            fileSystem.ls();
        }
    }
}
