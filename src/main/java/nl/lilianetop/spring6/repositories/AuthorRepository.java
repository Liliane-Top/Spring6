package nl.lilianetop.spring6.repositories;

import nl.lilianetop.spring6.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
