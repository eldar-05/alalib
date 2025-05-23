package com.alalib.library.controllers;

import com.alalib.library.models.Book;
import com.alalib.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String index(Model model) {
    List<Book> popularBooks = bookRepository.findTop6ByOrderByTotalScoreDesc();
    model.addAttribute("popularBooks", popularBooks);
    return "index";
}

    @GetMapping("/search")
    public String searchBooks(@RequestParam("query") String query, Model model) {
        List<Book> books = bookRepository.findByNameContainingIgnoreCase(query);
        model.addAttribute("books", books);
        model.addAttribute("query", query); // чтобы показать поисковый запрос
        return "results"; // результат будет показан в results.html
    }
    

}
