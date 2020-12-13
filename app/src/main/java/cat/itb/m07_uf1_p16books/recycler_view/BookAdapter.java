package cat.itb.m07_uf1_p16books.recycler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cat.itb.m07_uf1_p16books.R;
import cat.itb.m07_uf1_p16books.fragments.BookListFragmentDirections;
import cat.itb.m07_uf1_p16books.models.Book;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder>{
    List<Book> bookList;

    public BookAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book b = bookList.get(position);
        holder.bind(b);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewTitle, textViewStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewStatus = itemView.findViewById(R.id.textViewStatus);

            itemView.setOnClickListener(v -> {
                NavDirections navDirections = BookListFragmentDirections.actionBookListFragmentToBookInfoFragment().setBook(bookList.get(getAdapterPosition()));
                Navigation.findNavController(v).navigate(navDirections);
            });
        }

        public void bind(Book book) {
            textViewTitle.setText(book.getTitle());
            textViewStatus.setText(book.getStatus());
        }

    }
}
