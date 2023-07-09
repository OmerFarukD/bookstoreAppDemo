package com.kodluyoruz.bookstoreappdemo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Integer authorId;

    @Column
    private String authorName;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> books;
}
