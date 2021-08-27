package dev.patika.schoolmanagement.service;


import dev.patika.schoolmanagement.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

// Business Logic is created around the Service
@Service
public class CourseService implements BaseService<Course>{

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public Course findById(int id) {
        return null;
    }

    @Override
    public Course save(Course object) {
        return null;
    }

    @Override
    public Course update(Course object) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(Course object) {

    }
}
