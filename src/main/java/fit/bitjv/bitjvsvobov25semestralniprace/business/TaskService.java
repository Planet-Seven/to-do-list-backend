package fit.bitjv.bitjvsvobov25semestralniprace.business;

import fit.bitjv.bitjvsvobov25semestralniprace.dto.CreateTaskRequest;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.TaskResponse;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.UpdateTaskRequest;
import fit.bitjv.bitjvsvobov25semestralniprace.entity.Tag;
import fit.bitjv.bitjvsvobov25semestralniprace.entity.Task;
import fit.bitjv.bitjvsvobov25semestralniprace.exceptions.TagNotFound;
import fit.bitjv.bitjvsvobov25semestralniprace.exceptions.TaskNotFound;
import fit.bitjv.bitjvsvobov25semestralniprace.repository.CategoryRepository;
import fit.bitjv.bitjvsvobov25semestralniprace.repository.TagRepository;
import fit.bitjv.bitjvsvobov25semestralniprace.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component()
public class TaskService {
    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;
    private final ModelMapper mapper;

    public TaskService(
            TaskRepository taskRepository,
            CategoryRepository categoryRepository,
            TagRepository tagRepository,
            ModelMapper mapper) {

        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
        this.tagRepository = tagRepository;
        this.mapper = mapper;
    }

    public TaskResponse createTask(CreateTaskRequest request) {
        Task task = mapper.map(request, Task.class);

        Set<Tag> tags = new HashSet<>();
        for (Long id : request.getTagIds())
            tags.add(tagRepository.findById(id).orElseThrow(()-> new TagNotFound("")));
        task.setTags(tags);

        taskRepository.save(task);
        return mapper.map(task, TaskResponse.class);
    }

    public TaskResponse updateTask(UpdateTaskRequest request) {
        Task task = mapper.map(request, Task.class);

        Set<Tag> tags = new HashSet<>();
        for (Long id : request.getTagIds())
            tags.add(tagRepository.findById(id).orElseThrow(()-> new TagNotFound("")));
        task.setTags(tags);

        taskRepository
                .findById(request.getTaskId())
                .orElseThrow(() -> new TaskNotFound(""));
        taskRepository.save(task);
        return mapper.map(task, TaskResponse.class);
    }

    public TaskResponse getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        return mapper.map(task, TaskResponse.class);
    }

    public List<TaskResponse> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map((Task task)->mapper.map(task, TaskResponse.class))
                .collect(Collectors.toList());
    }

    public List<TaskResponse> getMissedTasks() {
        List<Task> tasks = taskRepository.findMissedTasks();
        return tasks.stream()
                .map((Task task)->mapper.map(task, TaskResponse.class))
                .collect(Collectors.toList());
    }

    public void deleteTaskById(Long id) {
        taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFound(""));
        taskRepository.deleteById(id);
    }
}
