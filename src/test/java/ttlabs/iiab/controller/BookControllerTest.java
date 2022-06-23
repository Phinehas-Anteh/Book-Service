package ttlabs.iiab.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = BookController.class)
@ExtendWith(SpringExtension.class)
class BookControllerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getListOfBooks() {
    }

    @Test
    void addBook() {
    }

    @Test
    void getBookByAuthor() {
    }

    @Test
    void deleteBookByTitle() {
    }
}