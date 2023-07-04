package com.kodluyoruz.bookstoreappdemo.Repository;

import com.kodluyoruz.bookstoreappdemo.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//Generic programlama
// DRY
@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {


    Optional<Book> getByTitle(String title);


    // Refflection
    // JPQL Java ve Sql in
/*    @Query("FROM Book b where b.title=:title")
    Book basligaGoreGetir(String title);*/

}
