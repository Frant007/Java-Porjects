package com.fran.app.rest.Repository;

import com.fran.app.rest.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Task, Long> {
}
