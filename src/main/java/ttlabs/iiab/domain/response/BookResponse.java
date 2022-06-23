package ttlabs.iiab.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import ttlabs.iiab.domain.BookDto;

import java.util.List;

@Data
@AllArgsConstructor
public class BookResponse {
    List<BookDto> listOfBook;
}
