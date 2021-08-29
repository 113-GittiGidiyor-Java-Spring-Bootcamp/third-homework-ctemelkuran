package dev.patika.schoolmanagement.repository;

import dev.patika.schoolmanagement.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
    List<Course> findByCourseNameContaining(String s);

    void deleteCourseByCourseName(String name);
}
