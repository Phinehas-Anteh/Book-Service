package ttlabs.iiab.service;

import ttlabs.iiab.domain.request.BookRequest;
import ttlabs.iiab.domain.response.BookResponse;

public interface BookService {
    BookResponse getListOfBooks();
    String addBook(BookRequest bookRequest);
    BookResponse getBookByAuthor(String name);
    String deleteBookByTitle(String title);
}
