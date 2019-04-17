package com.library.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="authors")
public class Author {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "books_to_authors",
            joinColumns = { @JoinColumn(name = "author_id", referencedColumnName = "id"), },
            inverseJoinColumns = { @JoinColumn(name = "book_id", referencedColumnName = "id") }
    )
    private List<Book> books;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
