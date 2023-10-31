package nl.lilianetop.spring6.repositories;

import nl.lilianetop.spring6.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
