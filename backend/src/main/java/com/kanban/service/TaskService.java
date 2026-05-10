package com.kanban.service;

import com.kanban.entity.KanbanTask;
import com.kanban.entity.Project;
import com.kanban.repository.ProjectRepository;
import com.kanban.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public KanbanTask createTask(Long projectId, String content) {
        Project project = projectRepository.findById(projectId).orElseThrow();
        KanbanTask task = KanbanTask.builder()
                .content(content)
                .status(KanbanTask.TaskStatus.TODO)
                .project(project)
                .build();
        return taskRepository.save(task);
    }

    public List<KanbanTask> getTasks(Long projectId) {
        return taskRepository.findByProjectId(projectId);
    }

    public KanbanTask updateStatus(Long taskId, KanbanTask.TaskStatus status) {
        KanbanTask task = taskRepository.findById(taskId).orElseThrow();
        task.setStatus(status);
        return taskRepository.save(task);
    }
}
