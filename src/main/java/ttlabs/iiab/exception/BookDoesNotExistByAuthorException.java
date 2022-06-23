package ttlabs.iiab.exception;

public class BookDoesNotExistByAuthorException extends RuntimeException {
    public BookDoesNotExistByAuthorException(String author) {
        super(String.format("%s does not exist", author));
    }
}
