package sk.lukassauer.projectmanagement.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sk.lukassauer.projectmanagement.dto.ChartData;
import sk.lukassauer.projectmanagement.dto.EmployeeProject;
import sk.lukassauer.projectmanagement.entities.Project;

import java.util.List;

public interface IProjectRepository extends CrudRepository<Project, Long> {

    @Override
    List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT stage as label, COUNT(*) as quantity "+
    "FROM project " +
    "GROUP BY stage")
    List<ChartData> projectsStage();
}
