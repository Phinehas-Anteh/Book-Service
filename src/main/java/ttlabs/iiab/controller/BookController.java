package ttlabs.iiab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ttlabs.iiab.domain.request.BookByTitleRequest;
import ttlabs.iiab.domain.request.BookRequest;
import ttlabs.iiab.domain.response.BookResponse;
import ttlabs.iiab.domain.response.BookStatusResponse;
import ttlabs.iiab.service.BookService;

@Controller
@RequestMapping("api/v1/")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list-of-books")
    public ResponseEntity<BookResponse> getListOfBooks() {
        return new ResponseEntity<>(bookService.getListOfBooks(), HttpStatus.OK);
    }

    @PostMapping("/create-book")
    public ResponseEntity<BookStatusResponse> addBook(@RequestBody BookRequest bookRequest) {
        return new ResponseEntity<>(new BookStatusResponse(bookService.addBook(bookRequest)), HttpStatus.CREATED);
    }

    @GetMapping("/list-of-books/{author}")
    public ResponseEntity<BookResponse> getBookByAuthor(@PathVariable("author") String author) {
        return new ResponseEntity<>(bookService.getBookByAuthor(author), HttpStatus.OK);
    }

    @DeleteMapping("/remove-book-by-title")
    public ResponseEntity<BookStatusResponse> deleteBookByTitle(@RequestBody BookByTitleRequest request) {
        return new ResponseEntity<>(new BookStatusResponse(bookService.deleteBookByTitle(request.getTitle())), HttpStatus.OK);
    }
}
