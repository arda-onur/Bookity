package Project.bookity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.bookity.project.candidate.arda.onur"})
@EnableJpaRepositories(basePackages = {"com.bookity.project.candidate.arda.onur.persistence.repository"})
@EntityScan("com.bookity.project.candidate.arda.onur")
public class BookityApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookityApplication.class, args);
    }
}
