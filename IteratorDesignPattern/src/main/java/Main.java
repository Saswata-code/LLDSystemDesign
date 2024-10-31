import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> bookList = Arrays.asList(new Book(150,"Science"),
                                            new Book(200,"Math"),
                                            new Book(130,"Geo"),
                                            new Book(90,"Phy"),
                                            new Book(210,"Chem")
                                            );

        Library library = new Library(bookList);
        Iterator iterator = library.createIterator();

        while(iterator.hasNext()){
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }
    }
}
