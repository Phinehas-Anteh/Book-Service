package ttlabs.iiab.domain.request;

import lombok.Data;

@Data
public class BookRequest {
    private String author;
    private String title;
    private int year;
}
