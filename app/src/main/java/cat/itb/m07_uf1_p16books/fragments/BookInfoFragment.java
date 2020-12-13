package cat.itb.m07_uf1_p16books.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import cat.itb.m07_uf1_p16books.R;
import cat.itb.m07_uf1_p16books.models.Book;
import cat.itb.m07_uf1_p16books.models.BooksViewModel;

public class BookInfoFragment extends Fragment {
    private TextView textViewTitle, textViewRating;
    private EditText editTextTitle, editTextAuthor;
    private Spinner spinnerStatus;
    private RatingBar ratingBar;
    private Button buttonConfirm, buttonCancel;
    private Book book;
    private boolean editing = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book_info, container, false);

        textViewTitle = view.findViewById(R.id.textViewAppTitle);
        textViewRating = view.findViewById(R.id.textViewRating);
        editTextTitle = view.findViewById(R.id.editTextTitle);
        editTextAuthor = view.findViewById(R.id.editTextAuthor);
        spinnerStatus = view.findViewById(R.id.spinnerStatus);
        ratingBar = view.findViewById(R.id.ratingBar);
        buttonConfirm = view.findViewById(R.id.buttonConfirm);
        buttonCancel = view.findViewById(R.id.buttonCancel);

        buttonCancel.setOnClickListener(
                v -> Navigation.findNavController(view).navigate(R.id.action_bookInfoFragment_to_bookListFragment));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.status, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStatus.setAdapter(adapter);
        spinnerStatus.setOnItemSelectedListener(new spinnerItemSelected());

        if (getArguments() != null) {
            book = getArguments().getParcelable("book");
            if (book != null) {
                editing = true;
                setBookInfoInFragment(book);
            } else {
                book = new Book();
            }
        } else {
            book = new Book();
        }

        buttonConfirm.setOnClickListener(this::confirmClicked);

        return view;
    }

    private void confirmClicked(View view) {
        String title = editTextTitle.getText().toString(),
                author = editTextAuthor.getText().toString(),
                status = spinnerStatus.getSelectedItem().toString();
        float rating = ratingBar.getRating();

        if (title.isEmpty()) {
            sout(R.string.empty_title);
        } else if (author.isEmpty()) {
            sout(R.string.empty_author);
        } else {
            book.setTitle(title);
            book.setAuthor(author);
            book.setStatus(status);
            if (book.getStatus().equals("Read")) {
                book.setScore(rating);
            }

            if (!editing) {
                BooksViewModel.add(book);
            }
            Navigation.findNavController(view).navigate(R.id.action_bookInfoFragment_to_bookListFragment);
        }
    }

    private void sout(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show();
    }

    private void sout(int text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show();
    }

    private void setBookInfoInFragment(Book b) {
        editTextTitle.setText(b.getTitle());
        editTextAuthor.setText(b.getAuthor());

        switch (book.getStatus()) {
            case "Want to read":
                spinnerStatus.setSelection(0);
                break;
            case "Reading":
                spinnerStatus.setSelection(1);
                break;
            case "Read":
                spinnerStatus.setSelection(2);
                break;
        }

        ratingBar.setRating(book.getScore());
        textViewTitle.setText(b.getTitle());
    }

    class spinnerItemSelected implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if (position == 2) {
                ratingBar.setEnabled(true);
                ratingBar.setVisibility(View.VISIBLE);
                textViewRating.setVisibility(View.VISIBLE);
            } else {
                ratingBar.setEnabled(false);
                ratingBar.setVisibility(View.INVISIBLE);
                textViewRating.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
