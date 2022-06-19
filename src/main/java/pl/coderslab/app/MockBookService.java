package pl.coderslab.app;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MockBookService implements BookService{

    private List<Book> books;
    private static Long nextId = 4L;

    public static void setNextId(long nextId) {
        MockBookService.nextId = nextId;
    }



    public MockBookService(){
        books= new ArrayList<>();
        books.add(new Book(1L, "12512512", "Start a fire", "Pizgacz", "PWN", "romans"));
        books.add(new Book(2L, "152214124", "Maly ksiaze", "antoni di saintexuper", "MG", "filozofia"));
        books.add(new Book(3L, "1251241412", "gwiazdy nadzieji", "i.m dark", "PWN", "romans"));
    }

    @Override
    public void add(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return books.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void update(Book book) {
        if (this.getBookById(book.getId()).isPresent()){
            int indexOf = books.indexOf(this.getBookById(book.getId()).get());
            books.set(indexOf, book);
        }
    }

    @Override
    public void delete(Long id) {
        if (getBookById(id).isPresent()){
            books.remove(this.getBookById(id).get());
        }
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


}
