package com.example.demo.repositories;

import com.example.demo.models.Child;
import com.example.demo.models.Country;
import org.springframework.data.repository.CrudRepository;


public interface ChildRepository extends CrudRepository<Child, Long> {

}


