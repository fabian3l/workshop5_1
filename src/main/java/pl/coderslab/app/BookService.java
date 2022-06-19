package pl.coderslab.app;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks();
    void add(Book book);
    Optional<Book> getBookById(Long id);
    void update(Book book);
    void delete(Long id);
}
