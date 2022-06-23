package ttlabs.iiab.converter;

import ttlabs.iiab.domain.Book;
import ttlabs.iiab.domain.BookDto;

public class BookToBookDtoConverter {

    public static BookDto convertBookToBookDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .title(book.getTitle())
                .year(book.getYear())
                .build();
    }
}
