package Project.bookity.Controller;

import Project.bookity.Entity.BookEntity;
import Project.bookity.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/getbooks")
    @ResponseBody
    public List<BookEntity> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/search")
    @ResponseBody
    public List<BookEntity> getBooksBy(@RequestParam String input, @RequestParam String category) {
      return bookService.getBooksBy(input, category);
    }
}