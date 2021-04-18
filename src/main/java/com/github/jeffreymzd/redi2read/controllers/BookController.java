package com.github.jeffreymzd.redi2read.controllers;

import com.github.jeffreymzd.redi2read.models.Book;
import com.github.jeffreymzd.redi2read.models.Category;
import com.github.jeffreymzd.redi2read.repositories.BookRepository;
import com.github.jeffreymzd.redi2read.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jeffreymzd on 4/18/21
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @GetMapping
    public ResponseEntity<Map<String, Object>> all( //
                                                    @RequestParam(defaultValue = "0") Integer page, //
                                                    @RequestParam(defaultValue = "10") Integer size //
    ) {
        Pageable paging = PageRequest.of(page, size);
        Page<Book> pagedResult = bookRepository.findAll(paging);
        List<Book> books = pagedResult.hasContent() ? pagedResult.getContent() : Collections.emptyList();
        Map<String, Object> response = new HashMap<>();
        response.put("books", books);
        response.put("page", pagedResult.getNumber());
        response.put("pages", pagedResult.getTotalPages());
        response.put("total", pagedResult.getTotalElements());
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/categories")
    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{isbn}")
    public Book get(@PathVariable("isbn") String isbn) {
        return bookRepository.findById(isbn).get();
    }
}
