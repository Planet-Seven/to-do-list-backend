package fit.bitjv.bitjvsvobov25semestralniprace.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class UpdateTaskRequest {
    private long id;
    private String name;
    private Instant deadline;
    private Long categoryId;
    //private Set<Long> tagsIds;
}
