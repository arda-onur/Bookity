package Project.bookity;

import com.bookity.project.candidate.arda.onur.controller.BookCrudRestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookityApplicationTests {
    @Autowired
    BookCrudRestController bookCrudRestController;

    @Test
    void shouldLoadApplicationContextWithBookCrudRestController() {
        assertThat(this.bookCrudRestController)
            .isNotNull();
    }
}
