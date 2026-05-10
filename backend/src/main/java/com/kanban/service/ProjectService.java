package com.kanban.service;

import com.kanban.entity.Project;
import com.kanban.entity.User;
import com.kanban.repository.ProjectRepository;
import com.kanban.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public Project createProject(String title, User owner) {
        Project project = Project.builder()
                .title(title)
                .owner(owner)
                .build();
        return projectRepository.save(project);
    }

    public List<Project> getMyProjects(User user) {
        return projectRepository.findByOwnerOrMembersContaining(user, user);
    }

    @Transactional
    public void addMember(Long projectId, String nickname) {
        Project project = projectRepository.findById(projectId).orElseThrow();
        User user = userRepository.findByNickname(nickname).orElseThrow();
        project.getMembers().add(user);
    }
}
