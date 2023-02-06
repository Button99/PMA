package com.koumpis.pma.repositories;

import com.koumpis.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    @Override
    List<Project> findAll();

    @Query(nativeQuery = true, value="SELECT stage as label, COUNT(*) as cc FROM project GROUP BY stage")
    public List<ChartData> getProjectStatus();
}
