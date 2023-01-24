package com.example.Spring.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.Spring.Entity.Demo;

public interface DemoRepository extends CrudRepository<Demo,Long>{
    
}
