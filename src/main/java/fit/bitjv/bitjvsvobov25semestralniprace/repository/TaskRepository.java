package fit.bitjv.bitjvsvobov25semestralniprace.repository;

import fit.bitjv.bitjvsvobov25semestralniprace.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t WHERE t.deadline <= current_timestamp ORDER BY t.deadline ASC")
    List<Task> findMissedTasks();
}