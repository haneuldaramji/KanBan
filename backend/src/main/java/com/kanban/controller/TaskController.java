package com.kanban.controller;

import com.kanban.entity.KanbanTask;
import com.kanban.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/{projectId}")
    public KanbanTask createTask(@PathVariable Long projectId, @RequestBody KanbanTask task) {
        return taskService.createTask(projectId, task.getContent());
    }

    @GetMapping("/{projectId}")
    public List<KanbanTask> getTasks(@PathVariable Long projectId) {
        return taskService.getTasks(projectId);
    }

    @PatchMapping("/{taskId}/status")
    public KanbanTask updateStatus(@PathVariable Long taskId, @RequestParam KanbanTask.TaskStatus status) {
        return taskService.updateStatus(taskId, status);
    }
}
