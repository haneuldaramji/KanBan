package com.kanban.repository;

import com.kanban.entity.KanbanTask;
import com.kanban.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<KanbanTask, Long> {
    List<KanbanTask> findByProjectId(Long projectId);
}
