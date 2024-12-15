package fit.bitjv.bitjvsvobov25semestralniprace.controllers;

import fit.bitjv.bitjvsvobov25semestralniprace.business.TaskService;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.CreateTaskRequest;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.TaskResponse;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.UpdateTaskRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping
    public TaskResponse updateTask(UpdateTaskRequest request){
        return taskService.updateTask(request);
    }

    @GetMapping
    public List<TaskResponse> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{taskId}")
    public TaskResponse getTask(@PathVariable Long taskId){
        return taskService.getTaskById(taskId);
    }

    @GetMapping("/missed")
    public List<TaskResponse> getMissedTasks(){
        return taskService.getMissedTasks();
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId){
        taskService.deleteTaskById(taskId);
    }
}
