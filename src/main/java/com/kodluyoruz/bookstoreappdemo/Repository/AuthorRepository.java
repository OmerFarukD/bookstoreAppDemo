package com.kodluyoruz.bookstoreappdemo.Repository;

import com.kodluyoruz.bookstoreappdemo.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
