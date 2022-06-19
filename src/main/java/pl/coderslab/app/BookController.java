package pl.coderslab.app;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController{

   private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L, "12315212", "Male kobietki",
                "Luisa Ancot", "MG", "piekna");
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }


    @PostMapping
    public void addBook(@RequestBody Book book){
        bookService.add(book);
    }



    @GetMapping("/{id}")
    @ResponseBody
    public Book getBook(@PathVariable Long id){
        return this.bookService.getBookById(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Entity not found"
            );
        });
    }

    @PutMapping
    @ResponseBody
    public void updateBook(@RequestBody Book book){
        bookService.update(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.delete(id);
    }

}
