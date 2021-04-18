package com.github.jeffreymzd.redi2read.repositories;

import com.github.jeffreymzd.redi2read.models.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jeffreymzd on 4/18/21
 */
@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, String> {
}
