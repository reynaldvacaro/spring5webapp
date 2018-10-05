package guru.springframework.spring5webapp.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    private String publisher;

    @ManyToMany
    @JoinTable(name="author_book",joinColumns = {@JoinColumn(name="book_id")},
        inverseJoinColumns = {@JoinColumn(name="author_id")})
    private Set<Author> authors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return getId().equals(book.getId());

    }

    @Override
    public String toString() {
        return "Book{" +
                "publisher='" + publisher + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
