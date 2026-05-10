package com.kanban.controller;

import com.kanban.entity.Project;
import com.kanban.entity.User;
import com.kanban.service.ProjectService;
import com.kanban.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    private final UserService userService;

    @PostMapping
    public Project createProject(@RequestBody Project project, Authentication auth) {
        User user = userService.findByUsername(auth.getName());
        return projectService.createProject(project.getTitle(), user);
    }

    @GetMapping
    public List<Project> getMyProjects(Authentication auth) {
        User user = userService.findByUsername(auth.getName());
        return projectService.getMyProjects(user);
    }

    @PostMapping("/{projectId}/members")
    public void addMember(@PathVariable Long projectId, @RequestParam String nickname) {
        projectService.addMember(projectId, nickname);
    }
}
