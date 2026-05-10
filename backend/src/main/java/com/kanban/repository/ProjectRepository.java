package com.kanban.repository;

import com.kanban.entity.Project;
import com.kanban.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByOwnerOrMembersContaining(User owner, User member);
}
