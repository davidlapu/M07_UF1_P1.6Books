package cat.itb.m07_uf1_p16books.models;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class BooksViewModel extends ViewModel {
    private final List<Book> bookList = new ArrayList<>();

    public void add(Book book) {
        bookList.add(book);
    }

}
