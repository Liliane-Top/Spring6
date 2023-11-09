package nl.lilianetop.spring6.services;

import nl.lilianetop.spring6.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
