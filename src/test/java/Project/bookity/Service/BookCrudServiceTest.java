package Project.bookity.Service;

import Project.bookity.Entity.BookEntity;
import com.bookity.project.candidate.arda.onur.persistence.repository.BookRepository;
import com.bookity.project.candidate.arda.onur.service.BookCrudService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class BookCrudServiceTest {
    @InjectMocks
    BookCrudService bookCrudService;
    @Mock
    BookRepository bookRepository;

    @Test
    void getAllBooks() {

        List<BookEntity> list = Arrays.asList(
                new BookEntity("1234567890", "Book One", "Fiction","32"),
                new BookEntity("0987654321", "Book Two", "Non-Fiction","32")

        );
        when(bookRepository.findAll()).thenReturn(list);
      assertEquals(list, list);
    }
    @Test
    void getBooksBy() {

        List<BookEntity> listByName = Arrays.asList(
                new BookEntity("1234567890", "Book One", "Fiction", "32")
        );
        List<BookEntity> listByIsbn = Arrays.asList(
                new BookEntity("0987654321", "Book Two", "Non-Fiction", "32")
        );
        List<BookEntity> listByCategory = Arrays.asList(
                new BookEntity("1234567890", "Book One", "Fiction", "32"),
                new BookEntity("0987654321", "Book Two", "Non-Fiction", "32")
        );

        when(bookRepository.findByName("Book One")).thenReturn(listByName);
        when(bookRepository.findByIsbn("0987654321")).thenReturn(listByIsbn);
        when(bookRepository.findByCategory("Fiction")).thenReturn(listByCategory);

        List<BookEntity> resultByName = bookCrudService.getBooksBy("Book One", "NAME");
        assertEquals(1, resultByName.size());
        assertEquals("1234567890", resultByName.get(0).getIsbn());


        List<BookEntity> resultByIsbn = bookCrudService.getBooksBy("0987654321", "ISBN");
        assertEquals(1, resultByIsbn.size());
        assertEquals("0987654321", resultByIsbn.get(0).getIsbn());


        List<BookEntity> resultByCategory = bookCrudService.getBooksBy("Fiction", "CATEGORY");
        assertEquals(2, resultByCategory.size());
    }
}
