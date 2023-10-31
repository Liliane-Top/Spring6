package nl.lilianetop.spring6.repositories;

import nl.lilianetop.spring6.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
