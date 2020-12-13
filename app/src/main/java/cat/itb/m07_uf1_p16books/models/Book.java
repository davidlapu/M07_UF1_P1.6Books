package cat.itb.m07_uf1_p16books.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private String title, author, status;
    private float score;

    public Book(String title, String author, String status) {
        this.title = title;
        this.author = author;
        this.status = status;
    }

    public Book(String title, String author, String status, float score) {
        this.title = title;
        this.author = author;
        this.status = status;
        this.score = score;
    }

    protected Book(Parcel in) {
        title = in.readString();
        author = in.readString();
        status = in.readString();
        score = in.readFloat();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(author);
        dest.writeString(status);
        dest.writeFloat(score);
    }
}
