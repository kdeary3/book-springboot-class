package mil.army.moda.books;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void shouldSaveABook() {
        // Arrange
        Book book = new Book("Clean Code", "Bob", true, 200, "123-L3045", 10);
        // Act
        Book savedBook = bookRepository.save(book);
        Optional<Book> foundBook = bookRepository.findById(savedBook.getId()) ;
        // Assert
        assertThat(foundBook).isPresent() ;
        assertThat(foundBook.get()).isEqualTo(savedBook);
    }

}