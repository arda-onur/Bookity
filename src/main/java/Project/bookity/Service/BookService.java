package Project.bookity.Service;

import Project.bookity.Entity.BookEntity;
import Project.bookity.Repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final static Logger logger = LoggerFactory.getLogger(BookService.class);
    @Autowired
  private BookRepository bookRepository;

    public List<BookEntity> getAllBooks(){
        logger.info("Getting all Books");
        return bookRepository.findAll();
    }



    public List<BookEntity> getBooksBy(String input,String category) {
        logger.info("Getting Books {} {}",category,input);
        if ("NAME".equals(category)) {
            return bookRepository.findByName(input);
        } else if ("ISBN".equals(category)) {
            return bookRepository.findByIsbn(input);
        } else
            return bookRepository.findByCategory(input);
        }

    }

