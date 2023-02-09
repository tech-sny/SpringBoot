package life.care.health.azure.About;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AboutRepository extends JpaRepository<About,Long>{

    @Query("select m from About m")
    List<About> findProjects();
    
}
