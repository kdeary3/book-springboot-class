package mil.army.moda.books;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    MockMvc mockMVC;
    @Autowired
    ObjectMapper objectMapper = new ObjectMapper();

    @MockitoBean
    BookService bookService;

    @Test
    void shouldSaveNewBook() throws Exception {

        Book book = new Book("Hobbit", "Tokin", true, 800, "123-434", 30);
        book.setId(1L);
        String bookJson = objectMapper.writeValueAsString(book);
        when(bookService.saveBook(any(Book.class))).thenReturn(book) ;

        mockMVC.perform(post("/api/books/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1)) ;
    }

}