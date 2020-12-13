package cat.itb.m07_uf1_p16books.models;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class BooksViewModel extends ViewModel {
    private static final List<Book> bookList = new ArrayList<>();

    public BooksViewModel() {
        bookList.add(new Book("Title", "Author", "Want to read"));
        bookList.add(new Book("Title1", "Author1", "Reading"));
        bookList.add(new Book("Title2", "Author2", "Read", 5));
        bookList.add(new Book("Title3", "Author3", "Want to read"));
        bookList.add(new Book("Title4", "Author4", "Reading"));
        bookList.add(new Book("Title5", "Author5", "Read"));
    }

    public static void add(Book book) {
        bookList.add(book);
    }

    public List<Book> getBookList() {
        return bookList;
    }
}
