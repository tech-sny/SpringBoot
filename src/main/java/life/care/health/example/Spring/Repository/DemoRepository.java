package life.care.health.example.Spring.Repository;

import org.springframework.data.repository.CrudRepository;

import life.care.health.example.Spring.Entity.Demo;

public interface DemoRepository extends CrudRepository<Demo,Long>{
    
}
