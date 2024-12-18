package Project.bookity.DatabaseConfig;


import com.bookity.project.candidate.arda.onur.persistence.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Configuration
public class DatabaseConfig {
    private static DataSource dataSource;
    private final String  url = "jdbc:postgresql://localhost:5432/postgres";
    private final String  driver = "org.postgresql.Driver";
    private final String  username = "postgres";
    private final String password = "postgres";
    @Autowired
    @Lazy
    private BookRepository bookRepository;

    @Bean
    public DataSource getDatabase(){
        if(dataSource == null){
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.driverClassName(driver);
            dataSourceBuilder.url(url);
            dataSourceBuilder.username(username);
            dataSourceBuilder.password(password);
            dataSource = dataSourceBuilder.build();
        }
        return  dataSource;
    }
    @Bean
    public String createBooks(){
        String path = "src/main/resources/V1_0_1__insert_book.sql";
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String ISBN = parts[0].trim();
                    String NAME= parts[1].trim();
                    String CATEGORY = parts[2].trim();
                    String IMAGESURL = parts[3].trim();
                    Book book = new Book();
                    book.setIsbn(ISBN);
                    book.setBookName(NAME);
                    book.setCategory(CATEGORY);
                    book.setImageUrl(IMAGESURL);
                    bookRepository.save(book);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return "Books created";
    }
}
