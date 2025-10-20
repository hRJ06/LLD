package Iterator_Design_Pattern;

import java.util.Iterator;

public class Client {
    public static void main(String[] args) {
        BookCollection collection = new BookCollection();
        collection.addBook(new Book("C++"));
        collection.addBook(new Book("Java"));
        collection.addBook(new Book("Python"));
        Iterator<Book> iterator = collection.createIterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book);
        }
    }
}
