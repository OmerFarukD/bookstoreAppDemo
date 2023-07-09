package com.kodluyoruz.bookstoreappdemo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column
    private String categoryName;


    @ManyToMany(mappedBy = "categories",fetch = FetchType.EAGER)
    private List<Book> books;
}
