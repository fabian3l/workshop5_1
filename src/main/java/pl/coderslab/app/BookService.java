package pl.coderslab.app;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks();
    Optional<Book> getBookById(Long id);
    void add(Book book);
    void update(Book book);
    void delete(Long id);
}
