package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/books")
public class BooksApp {

    @Autowired // bir nesne vasıtasıyla başka bir nesnenin bağımlılıklarının sağlandığı bir tekniktir
    BookService bookService;

    // verileri goruntulemek icin
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getBookes();
    }

    // id'e gore
    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id) {
        Optional<Book> bookOptional = bookService.bookRepository.findById(id);
        if (bookOptional.isPresent()) { // bulunan kitap optional nesnesinde olup olmadıgına bakar.
            return bookOptional.get();
        }
        return null;
    }

    // veri kaydetmek icin
    @PostMapping
    public Book addBook(@RequestBody Book book){
        bookService.books(book);
        return book;
    }

    // veri güncellemek icin
    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book updateBook, @PathVariable int id){
        Optional<Book> bookOptional = bookService.bookRepository.findById(id);
        if (bookOptional.isPresent()) { // kitabın optional nesnesinde olup olmadığını kontrol eder.
            Book book = bookOptional.get(); // optional nesnesinde ise onu al.
            book.setName(updateBook.getName()); // isim set et
            book.setId(updateBook.getId());  // id set et
            return bookService.bookRepository.save(book); // güncellenen kitabı veritabanına kaydeder.
        }
        return null;
    }

    // veri silmek icin
    @DeleteMapping("/{id}")
    public Book deleteBook (@PathVariable int id){
        bookService.bookRepository.deleteById(id); // verilen id degerine sahip veriyi veritabanından siler.
        return null;
    }
}

// http://localhost:8080/api/books