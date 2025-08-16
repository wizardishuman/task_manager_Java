package com.example.taskmanager.repo;

import com.example.taskmanager.model.Priority;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface TaskRepo extends CrudRepository<Task,Integer> {
    List<Task> findByUserAndPriority(User user, Priority priority);
    List<Task> findByUser(User user);
}
