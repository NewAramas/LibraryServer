package com.library.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="books")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "books_to_authors",
            joinColumns = { @JoinColumn(name = "book_Id", referencedColumnName = "id"), },
            inverseJoinColumns = { @JoinColumn(name = "author_id", referencedColumnName = "id") }
    )
    private List<Author> authors;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lang_id")
    private Language language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
