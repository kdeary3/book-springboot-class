package mil.army.moda.books;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService ;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

}
