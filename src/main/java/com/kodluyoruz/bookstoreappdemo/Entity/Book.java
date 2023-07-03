package com.kodluyoruz.bookstoreappdemo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String authorName;

    @Column
    private  String category;

    @Column
    private double price;

    @Column
    private int unitInStock;


}
