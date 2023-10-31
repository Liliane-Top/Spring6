package nl.lilianetop.spring6.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String isbn;
    @ManyToMany(mappedBy = "books")
    //    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
    //        inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

}
