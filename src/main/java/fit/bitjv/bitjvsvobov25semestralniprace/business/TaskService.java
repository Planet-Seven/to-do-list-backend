package fit.bitjv.bitjvsvobov25semestralniprace.business;

import fit.bitjv.bitjvsvobov25semestralniprace.dto.CreateTaskRequest;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.TaskResponse;
import fit.bitjv.bitjvsvobov25semestralniprace.entity.Task;
import fit.bitjv.bitjvsvobov25semestralniprace.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component()
public class TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper mapper;

    public TaskService(TaskRepository taskRepository, ModelMapper mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    public TaskResponse createTask(CreateTaskRequest request) {
        Task task = mapper.map(request, Task.class);
        taskRepository.save(task);
        return mapper.map(task, TaskResponse.class);
    }

    public TaskResponse getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        return mapper.map(task, TaskResponse.class);
    }
}
