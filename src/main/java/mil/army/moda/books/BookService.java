package mil.army.moda.books;

import org.springframework.stereotype.Service;

// business logic:
// where you do things like traditional functions.
// i.e. if book is overdue, send an email to the customer

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

}
