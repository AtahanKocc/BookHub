package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getBookes() { // kitapların listesini dondurur.
        return bookRepository.findAll(); // kitapların listesini almak icin kullanıldı.
    }
    public void books (Book book){
        bookRepository.save(book); // kitapları ekliyoruz.
    }
    public void deleteBook (Book book){
        bookRepository.delete(book);
    }
}

// veritabanı islemleri bu sınıf icinde yapılır.