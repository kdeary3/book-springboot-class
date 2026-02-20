package mil.army.moda.books;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private long id;
    private String title ;
    private String author ;
    private boolean isCheckedOut ;
    private int pageCount ;
    private String isbn ;
    private int chapterCount ;

    public Book(String title, String author, boolean isCheckedOut, int pageCount, String isbn, int chapterCount) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = isCheckedOut;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.chapterCount = chapterCount;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setChapterCount(int chapterCount) {
        this.chapterCount = chapterCount;
    }

    // Getters
    public long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }
    public int getPageCount() {
        return pageCount;
    }
    public String getIsbn() {
        return isbn;
    }
    public int getChapterCount() {
        return chapterCount;
    }
}
