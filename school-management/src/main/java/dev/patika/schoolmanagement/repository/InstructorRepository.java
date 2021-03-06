package dev.patika.schoolmanagement.repository;

import dev.patika.schoolmanagement.entity.Instructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Integer> {
    List<Instructor> findByNameContaining(String name);
    //List<Instructor> findFirst3BySalaryGreaterThan(double salary);

    void deleteInstructorByName(String name);
}
