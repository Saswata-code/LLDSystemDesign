import java.util.List;

public class BookIterator implements Iterator{
    List<Book> bookList;
    int index = 0;

    public BookIterator(List<Book> bookList){
        this.bookList = bookList;
    }
    @Override
    public boolean hasNext() {
        return index < this.bookList.size();
    }

    @Override
    public Object next() {
        if(this.hasNext()){
            return bookList.get(index++);
        }
        return null;
    }
}
