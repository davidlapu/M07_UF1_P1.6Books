package cat.itb.m07_uf1_p16books.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import cat.itb.m07_uf1_p16books.R;
import cat.itb.m07_uf1_p16books.models.BooksViewModel;
import cat.itb.m07_uf1_p16books.recycler_view.BookAdapter;

public class BookListFragment extends Fragment {
    private RecyclerView recyclerView;
    private BooksViewModel booksViewModel;
    private FloatingActionButton floatingActionButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        booksViewModel = new ViewModelProvider(requireActivity()).get(BooksViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_book_list, container, false);

        recyclerView = v.findViewById(R.id.recyclerViewBooks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        BookAdapter bookAdapter = new BookAdapter(booksViewModel.getBookList());
        recyclerView.setAdapter(bookAdapter);

        floatingActionButton = v.findViewById(R.id.floatingActionButton);

        return v;
    }
}
