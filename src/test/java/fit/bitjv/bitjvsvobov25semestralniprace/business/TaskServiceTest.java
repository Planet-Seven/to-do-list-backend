package fit.bitjv.bitjvsvobov25semestralniprace.business;

import fit.bitjv.bitjvsvobov25semestralniprace.dto.TaskResponse;
import fit.bitjv.bitjvsvobov25semestralniprace.entity.Task;
import fit.bitjv.bitjvsvobov25semestralniprace.exceptions.TagNotFound;
import fit.bitjv.bitjvsvobov25semestralniprace.exceptions.TaskNotFound;
import fit.bitjv.bitjvsvobov25semestralniprace.repository.CategoryRepository;
import fit.bitjv.bitjvsvobov25semestralniprace.repository.TagRepository;
import fit.bitjv.bitjvsvobov25semestralniprace.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private TagRepository tagRepository;

    @Mock
    private CategoryRepository categoryRepository;


    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        // Arrange: Create a task and mock the repository
        taskService = new TaskService(taskRepository, categoryRepository, tagRepository, new ModelMapper());
    }

    @Test
    void testGetTaskById() {
        Task task = new Task();
        task.setName("Task 1");
        task.setTaskId(1L);

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        TaskResponse taskResponse = taskService.getTaskById(1L);

        assertNotNull(taskResponse);
        assertEquals(1L, taskResponse.getTaskId());
        assertEquals("Task 1", taskResponse.getName());
    }

    @Test
    void testGetTaskById_TaskNotFound() {

        when(taskRepository.findById(999L)).thenReturn(Optional.empty());

        boolean thrown = false;

        try {
            taskService.getTaskById(999L);
        } catch (TaskNotFound e) {
            thrown = true;
        }
        assertTrue(thrown);

    }
}