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
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

//        authorRepository.save(ericSaved);
//        authorRepository.save(rodSaved);

        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("O'Reilly");
        publisher1.setAddress("Kalverstraat 15");
        publisher1.setCity("Amsterdam");
        publisher1.setState("Noord-Holland");
        publisher1.setZip("1015KP");

        Publisher savedPublisher = publisherRepository.save(publisher1);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());


    }
}










