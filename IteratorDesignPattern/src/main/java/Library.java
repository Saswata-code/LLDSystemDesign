import java.util.List;

public class Library implements Aggregate{
    List<Book> bookList;

    public Library(List<Book> bookList){
        this.bookList = bookList;
    }
    @Override
    public Iterator createIterator() {
       return new BookIterator(bookList);
    }
}
