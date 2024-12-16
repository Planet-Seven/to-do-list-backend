package fit.bitjv.bitjvsvobov25semestralniprace.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="task_id", nullable = false)
    private Long taskId;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="deadline")
    private Date deadline;

    @Column(name="is_done", nullable = false)
    private boolean isDone;

    @ManyToOne(cascade = {CascadeType.DETACH}, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToMany(cascade = {CascadeType.DETACH})
    @JoinTable(name = "Task_tags",
            joinColumns = @JoinColumn(name = "task_task_id"),
            inverseJoinColumns = @JoinColumn(name = "tags_tag_id"))
    private Set<Tag> tags = new LinkedHashSet<>();
}
