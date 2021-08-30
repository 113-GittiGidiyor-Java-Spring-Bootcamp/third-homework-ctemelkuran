package dev.patika.schoolmanagement.repository;

import dev.patika.schoolmanagement.entity.PermanentInstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermanentInstructorRepository extends CrudRepository<PermanentInstructor, Integer> {

//    @Query("Select i.name FROM Instructor i where PermanentInstructor.id = Instructor.id")
//    List<?> findTop3ByFixedSalary();
}
