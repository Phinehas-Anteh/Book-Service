package ttlabs.iiab.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import ttlabs.iiab.domain.Book;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    default boolean existsByAuthorAndTitle(String author, String title) {
        return findAll().stream().anyMatch(book -> book.getAuthor().equals(author) && book.getTitle().equals(title));
    }

    boolean existsByAuthor(String name);

    default List<Book> findBookByAuthor(String author) {
        return findAll().stream().filter(book -> book.getAuthor().equals(author)).toList();
    }

    @Modifying
    @Transactional
    void deleteByTitle(String title);

    boolean existsByTitle(String title);
}
