package com.alalib.library.repositories;

import com.alalib.library.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByNameContainingIgnoreCase(String name);
    List<Book> findTop6ByOrderByTotalScoreDesc();
}
