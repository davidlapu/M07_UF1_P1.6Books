package cat.itb.m07_uf1_p16books.models;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class BooksViewModel extends ViewModel {
    private static final List<Book> bookList = new ArrayList<>();

    public BooksViewModel() {
        bookList.add(new Book("title", "author", "Want to read"));
        bookList.add(new Book("title1", "author1", "Reading"));
        bookList.add(new Book("title2", "author2", "Read", 5));
        bookList.add(new Book("title3", "author3", "Want to read"));
        bookList.add(new Book("title4", "author4", "Reading"));
        bookList.add(new Book("title5", "author5", "Read"));
    }

    public static void add(Book book) {
        bookList.add(book);
    }

    public List<Book> getBookList() {
        return bookList;
    }
}
