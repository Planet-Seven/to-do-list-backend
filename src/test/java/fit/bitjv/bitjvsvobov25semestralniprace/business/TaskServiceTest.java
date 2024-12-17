package fit.bitjv.bitjvsvobov25semestralniprace.business;

import fit.bitjv.bitjvsvobov25semestralniprace.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.modelmapper.ModelMapper;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private TaskRepository tagRepository;

    @Mock
    private TaskRepository categoryRepository;

    @Mock
    private CategoryService categoryService;

    @Mock
    private TagService tagService;

    private TaskService taskService;

    @BeforeEach
    void setUp() {
       // MockitoAnnotations.openMocks(this);
       // taskService = new TaskService(taskRepository, categoryRepository, tagRepository, new ModelMapper());
    }

    @Test
    void testCreateTask() {
    }
}