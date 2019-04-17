package com.library.controller;
import com.library.converter.BookConverter;
import com.library.dto.BookDTO;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/books")
    public List<BookDTO> getBooks() {
        List<BookDTO> listBookDTO = new ArrayList<>();
        bookRepository.findAll().forEach(book->{
            listBookDTO.add(BookConverter.convert(book));
        });
        return listBookDTO;
    }
}
