package com.kodluyoruz.bookstoreappdemo.Repository;

import com.kodluyoruz.bookstoreappdemo.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Generic programlama
// DRY
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    Book getById(int id);

}
