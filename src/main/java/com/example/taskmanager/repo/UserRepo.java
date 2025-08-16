package com.example.taskmanager.repo;

import com.example.taskmanager.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
