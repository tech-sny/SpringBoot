package life.care.health.azure.Education;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EducationRepository extends JpaRepository<Education,Long>{

    @Query("select m from Education m")
    List<Education> findProjects();
    
}
