package ttlabs.iiab.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BookByTitleRequest {
    private String author;
    private String title;
}
