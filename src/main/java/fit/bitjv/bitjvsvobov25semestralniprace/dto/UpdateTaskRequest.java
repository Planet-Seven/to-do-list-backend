package fit.bitjv.bitjvsvobov25semestralniprace.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTaskRequest {
    private Long taskId;
    private String name;
    private Date deadline;
    private Long categoryId;
    private Boolean isDone;
    private Set<Long> tagIds;
}
