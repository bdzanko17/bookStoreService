package com.example.book;

import com.example.book.model.Author;
import com.example.book.model.Book;
import com.example.book.model.EntityInput.BookEntityInput;
import com.example.book.repository.AuthorRepository;
import com.example.book.repository.BookRepository;
import com.example.book.service.impl.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

@SpringBootApplication
@EnableJpaAuditing
public class BookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

    @Bean
    CommandLineRunner init(AuthorRepository authorRepository, BookService bookService) {
        return args -> {
            Stream.of("Haris", "Edin", "Almedina", "Merjema").forEach(name -> {
                Author author = new Author(name);
                authorRepository.save(author);

            });
//            authorRepository.findAll().forEach(System.out::println);
//            ArrayList<Long> lista =new ArrayList<Long>(Arrays.asList(1l));
//            BookEntityInput book = new BookEntityInput("dozivljaj misa  sisa",  "komedija",lista);
//            bookService.saveBook(book);
        };

    }

}
