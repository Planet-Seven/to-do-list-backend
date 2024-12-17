package fit.bitjv.bitjvsvobov25semestralniprace.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class TaskResponse {
    private Long taskId;
    private String name;
    private LocalDate deadline;
    private boolean isDone;
    private CategoryResponse category;
    private Set<TagResponse> tags;
}
