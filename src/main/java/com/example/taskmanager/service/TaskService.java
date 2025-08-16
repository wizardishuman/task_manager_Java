package com.example.taskmanager.service;

import com.example.taskmanager.model.Priority;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.User;
import com.example.taskmanager.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepo taskRepo;
    @Autowired
    UserService userService;
    public List<Task> getTasks(String name) {
        User user=userService.getUserByName(name);
       Iterable<Task>  data=taskRepo.findByUser(user);
       List<Task> list=new ArrayList<>();
       data.forEach(list::add);
        return list;
    }
    public List<Task> getTasksByPriority(Priority priority, String name) {
        User user=userService.getUserByName(name);
        Iterable<Task>  data=taskRepo.findByUserAndPriority(user,priority);
        List<Task> list=new ArrayList<>();
        data.forEach(list::add);
        return list;
    }
    @Transactional
    public void create(String name, Task task) {
        User user=userService.getUserByName(name);
        task.setUser(user);
        taskRepo.save(task);
    }
  @Transactional
    public void update(int id, Task task) {
       Optional<Task> data= taskRepo.findById(id);
       if (data.isPresent()){
           Task existingtask=data.get();
           Task existingTask= data.get();
           Optional.ofNullable(task.getName()).ifPresent(existingTask::setName);
           Optional.ofNullable(task.getDescription()).ifPresent(existingTask::setDescription);
           Optional.ofNullable(task.getStatus()).ifPresent(existingTask::setStatus);
           Optional.ofNullable(task.getPriority()).ifPresent(existingTask::setPriority);
       }
    }
    @Transactional
    public void delete(int id, Task task) {
        Optional<Task> data= taskRepo.findById(id);
        if (data.isPresent()){
            taskRepo.deleteById(id);
        }
    }
}
