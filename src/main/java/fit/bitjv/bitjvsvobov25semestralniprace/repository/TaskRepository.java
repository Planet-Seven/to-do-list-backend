package fit.bitjv.bitjvsvobov25semestralniprace.repository;

import fit.bitjv.bitjvsvobov25semestralniprace.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}