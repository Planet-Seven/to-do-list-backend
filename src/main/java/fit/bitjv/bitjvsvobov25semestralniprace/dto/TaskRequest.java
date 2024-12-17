package fit.bitjv.bitjvsvobov25semestralniprace.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class TaskRequest {
    private String name;
    private LocalDate deadline;
    private boolean isDone;
    private Long categoryId;
    private Set<Long> tagIds;
}
