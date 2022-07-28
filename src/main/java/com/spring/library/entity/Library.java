package com.spring.library.entity;



import javax.persistence.*;

@Entity
@Table(name="library")
public class Library {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  int id;
    private String bookTitle;
    private String author;
    private String publisher;
    private String releaseDate;

    public Library() {
    }

    public Library(int id, String bookTitle, String author, String publisher, String releaseDate) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    @Override
    public String toString() {
        return "Library [id=" + id + ", bookTitle=" + bookTitle + ", Author=" + author + ", Publisher=" + publisher +",releaseDate=" +releaseDate+"]";
    }




}
