package dev.patika.schoolmanagement.service;


import dev.patika.schoolmanagement.entity.Course;
import dev.patika.schoolmanagement.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

// Business Logic is created around the Service
@Service
@RequiredArgsConstructor
public class CourseService implements BaseService<Course>{

    // final is for best practice
    private final CourseRepository courseRepository;

    // Constructor injection, final access modifier injected with the constructor
    // This is not needed if @RequiredArgsConstructor is used
/*    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }*/

    @Override
    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();
        Iterable<Course> courseIterable = courseRepository.findAll();
        courseIterable.iterator().forEachRemaining(courseList::add);
        return courseList;
    }

    @Override
    @Transactional(readOnly = true) // for find methods; readOnly increases the performance
    public Course findById(int id) {
        return courseRepository.findById(id).get();
    }


    @Override
    @Transactional
    public Course save(Course object) {
        return courseRepository.save(object);
    }

    @Override
    @Transactional
    public Course update(Course object) {
        return courseRepository.save(object);
    }

    @Override
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void delete(Course object) {
        courseRepository.delete(object);
    }

    @Override
    public List<Course> findByName(String name) {
        return courseRepository.findByCourseNameContaining(name);
    }

    @Transactional
    public void deleteCourseByName(String name){
        courseRepository.deleteCourseByCourseName(name);
    };
}
