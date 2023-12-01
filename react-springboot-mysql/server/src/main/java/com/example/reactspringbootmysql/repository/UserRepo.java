package com.example.reactspringbootmysql.repository;
import com.example.reactspringbootmysql.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
