package Project.bookity;

import com.bookity.project.candidate.arda.onur.controller.BookCrudRestController;
import com.bookity.project.candidate.arda.onur.persistence.repository.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookityApplicationTests {
    @Autowired
    BookCrudRestController bookCrudRestController;

    @Test
    void contextLoads() {
        assertThat(this.bookCrudRestController).isNotNull();
    }
}
