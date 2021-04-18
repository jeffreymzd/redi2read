package com.github.jeffreymzd.redi2read.repositories;

import com.github.jeffreymzd.redi2read.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jeffreymzd on 4/18/21
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, String> {
}
