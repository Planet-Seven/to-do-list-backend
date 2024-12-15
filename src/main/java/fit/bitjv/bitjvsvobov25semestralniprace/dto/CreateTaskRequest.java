package fit.bitjv.bitjvsvobov25semestralniprace.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class CreateTaskRequest {
    private String name;
    private Instant deadline;
    private Long categoryId;
    private List<Long> tagIds;
}
