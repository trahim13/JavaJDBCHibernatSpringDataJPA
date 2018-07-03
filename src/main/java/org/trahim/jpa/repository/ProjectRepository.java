package org.trahim.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trahim.jpa.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
