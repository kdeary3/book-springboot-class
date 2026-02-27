package mil.army.moda.books;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookService bookService;

    @Test
    void shouldSaveNewBook() {
        // Arrange
        Book book = new Book("Hobbit", "Tokin", true, 800, "123-434", 30);
        Book savedBook = new Book("Hobbit", "Tokin", true, 800, "123-434", 30);
        savedBook.setId(1L);

        when(bookRepository.save(book)).thenReturn(savedBook) ;
        Book result = bookService.saveBook(book);

        assertThat(result.getId()).isEqualTo(1L);

        verify(bookRepository).save(book);

    }

}