package life.care.health.azure.Project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepository extends JpaRepository<Project,Long>{

    @Query("select m from Project m")
    List<Project> findProjects();
    
}
