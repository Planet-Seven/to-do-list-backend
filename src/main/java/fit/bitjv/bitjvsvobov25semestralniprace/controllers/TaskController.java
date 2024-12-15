package fit.bitjv.bitjvsvobov25semestralniprace.controllers;

import fit.bitjv.bitjvsvobov25semestralniprace.business.TaskService;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.CreateTaskRequest;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.TaskResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tasks")
public class TaskController {
    private final TaskService taskService;

    TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public TaskResponse createTask(CreateTaskRequest request){
        return taskService.createTask(request);
    }
}
