package dev.patika.schoolmanagement.repository;

import dev.patika.schoolmanagement.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    List<Student> findByNameContaining(String s);
}
