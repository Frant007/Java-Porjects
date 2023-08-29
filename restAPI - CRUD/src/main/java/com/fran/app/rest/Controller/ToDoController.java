package com.fran.app.rest.Controller;

import com.fran.app.rest.Model.Task;
import com.fran.app.rest.Repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {
    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping("/")
    public String holaMundo() {
        return "Hola mundo!";
    }

    @GetMapping("/tasks")
    public List<Task> getTask() {
        return toDoRepository.findAll();
    }

    @PostMapping("/savetask")
    public String saveTask(@RequestBody Task task) {
        toDoRepository.save(task);
        return "save task";
    }

    @PutMapping("/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task task) {
        Task updatedTask = toDoRepository.findById(id).get();
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());
        toDoRepository.save(updatedTask);
        return "Updated Task";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable long id) {
        Task deletedTask = toDoRepository.findById(id).get();
        toDoRepository.delete(deletedTask);
        return "Deleted Task";
    }
}
