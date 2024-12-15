package fit.bitjv.bitjvsvobov25semestralniprace.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
public class UpdateTaskRequest {
    private Long taskId;
    private String name;
    private Instant deadline;
    private Long categoryId;
    private Boolean isDone;
    //private Set<Long> tagsIds;
}
