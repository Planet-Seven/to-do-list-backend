package fit.bitjv.bitjvsvobov25semestralniprace.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
public class CreateTaskRequest {
    private String name;
    private Instant deadline;
    private Long categoryId;
    private Set<Long> tagIds;
}
