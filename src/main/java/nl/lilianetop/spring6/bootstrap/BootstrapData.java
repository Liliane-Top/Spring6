package nl.lilianetop.spring6.bootstrap;

import lombok.AllArgsConstructor;
import nl.lilianetop.spring6.domain.Author;
import nl.lilianetop.spring6.domain.Book;
import nl.lilianetop.spring6.domain.Publisher;
import nl.lilianetop.spring6.repositories.AuthorRepository;
import nl.lilianetop.spring6.repositories.BookRepository;
import nl.lilianetop.spring6.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) {

        //Create an author
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");
        //Create a book
        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        // Save the author to the DB
        Author ericSaved = authorRepository.save(eric);
        // Save the book to the DB
        Book dddSaved = bookRepository.save(ddd);

        //Create an author
        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        //Create a book
        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

        //Save the author to the DB
        Author rodSaved = authorRepository.save(rod);
        //Save the book to the DB
        Book noEJBSaved = bookRepository.save(noEJB);

        //Connect the book to an author
        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        //Connect the author to a book
        noEJBSaved.getAuthors().add(rodSaved);
        dddSaved.getAuthors().add(ericSaved);

        //Create a publisher
        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("O'Reilly");
        publisher1.setAddress("Kalverstraat 15");
        publisher1.setCity("Amsterdam");
        publisher1.setState("Noord-Holland");
        publisher1.setZip("1015KP");

        //Save the Publisher to the DB
        Publisher savedPublisher = publisherRepository.save(publisher1);

        //Connect the book to a publisher
        noEJB.setPublisher(publisher1);
        ddd.setPublisher(publisher1);

        //Connect publisher to a book? not require as the connection is already
        //established so no need for bidirectional connection

        //Save the update authors and book which have now the connections
        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());


    }
}










