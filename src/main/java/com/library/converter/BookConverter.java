package com.library.converter;

import com.library.dto.BookDTO;
import com.library.entity.Author;
import com.library.entity.Book;

import java.util.List;

public class BookConverter {

    public static BookDTO convert(Book book){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setLanguage(book.getLanguage().getName());
        bookDTO.setAuthors(getNameAuthor(book.getAuthors()));


        return bookDTO;
    }

    private static  String getNameAuthor(List<Author>  listAuthors){
        String fullNameAuthor ="";
        for (Author author: listAuthors) {
            fullNameAuthor += author.getFirstName()+" "+ author.getSecondName()+"; ";
        }
        return fullNameAuthor;
    }
}
