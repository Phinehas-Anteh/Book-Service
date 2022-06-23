package ttlabs.iiab.service;

import ttlabs.iiab.domain.request.BookRequest;
import ttlabs.iiab.domain.response.BookResponse;
import ttlabs.iiab.domain.response.BookStatusResponse;

public interface BookService {
    BookResponse getListOfBooks();
    BookStatusResponse addBook(BookRequest bookRequest);
    BookResponse getBookByAuthor(String name);
    BookStatusResponse deleteBookByTitle(String title);
}
