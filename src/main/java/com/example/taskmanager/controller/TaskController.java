package com.example.taskmanager.controller;
import com.example.taskmanager.model.Priority;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.User;
import com.example.taskmanager.model.UserPrinciple;
import com.example.taskmanager.service.TaskService;
import com.example.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;
    @RequestMapping("/tasks")
    public List<Task> getTasks(@AuthenticationPrincipal UserPrinciple userPrinciple){
          String name=  userPrinciple.getUsername();
          return taskService.getTasks(name);
    }
    @RequestMapping("/priority/{priority}")
    public List<Task>  getTaskByPriority(@PathVariable("priority")Priority priority, @AuthenticationPrincipal UserPrinciple userPrinciple){
        String name=  userPrinciple.getUsername();
        return taskService.getTasksByPriority(priority,name);
    }
    @RequestMapping(value = "/tasks",method = RequestMethod.POST)
   public void create(@AuthenticationPrincipal UserPrinciple userPrinciple, @RequestBody Task task){
        String name=userPrinciple.getUsername();
        taskService.create(name, task);
   }
    @RequestMapping(value = "/tasks/{id}",method = RequestMethod.PUT)
    public  void updateTasks(@PathVariable int id,@RequestBody Task task){
        taskService.update(id,task);
    }
    @RequestMapping(value = "/tasks/{id}",method = RequestMethod.DELETE)
    public  void delete(@PathVariable int id,@RequestBody Task task){
        taskService.delete(id,task);
    }
}