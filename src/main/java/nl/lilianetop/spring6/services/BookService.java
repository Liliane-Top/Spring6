package nl.lilianetop.spring6.services;

import nl.lilianetop.spring6.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
