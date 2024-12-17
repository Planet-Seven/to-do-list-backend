package fit.bitjv.bitjvsvobov25semestralniprace.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class TaskRequest {
    private String name;
    private Date deadline;
    private Boolean isDone = false;
    private Long categoryId;
    private Set<Long> tagIds;
}
