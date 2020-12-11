package cat.itb.m07_uf1_p16books.models;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class BooksViewModel extends ViewModel {
    private final List<Book> bookList = new ArrayList<>();

    public BooksViewModel() {
        bookList.add(new Book("title", "author", "status"));
        bookList.add(new Book("title", "author", "status"));
        bookList.add(new Book("title", "author", "status"));
        bookList.add(new Book("title", "author", "status"));
        bookList.add(new Book("title", "author", "status"));
        bookList.add(new Book("title", "author", "status"));
    }

    public void add(Book book) {
        bookList.add(book);
    }

    public List<Book> getBookList() {
        return bookList;
    }
}
