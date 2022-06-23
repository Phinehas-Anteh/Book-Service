package ttlabs.iiab.service;

import org.springframework.stereotype.Service;
import ttlabs.iiab.converter.BookToBookDtoConverter;
import ttlabs.iiab.domain.Book;
import ttlabs.iiab.domain.request.BookRequest;
import ttlabs.iiab.domain.response.BookResponse;
import ttlabs.iiab.exception.BookDoesNotExistByAuthorException;
import ttlabs.iiab.respository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse getListOfBooks() {
        return new BookResponse(bookRepository.findAll().stream().map(BookToBookDtoConverter::convertBookToBookDto).toList());
    }

    @Override
    public String addBook(BookRequest bookRequest) {
        if (bookRepository.existsByAuthorAndTitle(bookRequest.getAuthor(), bookRequest.getTitle())) {
            return "Book already exists";
        }
        bookRepository.save(new Book(bookRequest));
        return "Book has been added";
    }

    @Override
    public BookResponse getBookByAuthor(String name) {
        if (bookRepository.existsByAuthor(name)) {
            return new BookResponse(bookRepository.findBookByAuthor(name).stream().map(BookToBookDtoConverter::convertBookToBookDto).toList());
        }
        throw new BookDoesNotExistByAuthorException(name);
    }

    @Override
    public String deleteBookByTitle(String title) {
        if (bookRepository.existsByTitle(title)) {
            bookRepository.deleteByTitle(title);
            return "Book has been deleted";
        }
        return "Book can not be found for it to be deleted";
    }
}
