package com.github.jeffreymzd.redi2read.repositories;

import com.github.jeffreymzd.redi2read.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jeffreymzd on 4/13/21
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {

    User findFirstByEmail(String email);

}
