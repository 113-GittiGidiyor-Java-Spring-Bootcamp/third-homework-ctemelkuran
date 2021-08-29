package dev.patika.schoolmanagement.controller;

import dev.patika.schoolmanagement.entity.Course;
import dev.patika.schoolmanagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {
    // No business logic in Controller
    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findAll(){
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/courses")
    public Course saveCourse(@RequestBody Course course){
        return courseService.save(course);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable int id){
        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return courseService.update(course);
    }

    @DeleteMapping("/courses/{id}")
    public String deleteCourseById(@PathVariable int id){
        courseService.deleteById(id);
        return "Deleted...";
    }
    @DeleteMapping("/courses")
    public ResponseEntity<String> deleteCourseByEntity(@RequestBody Course course) {
        Course foundCourse = courseService.findById(course.getId());
        if (foundCourse != null) {
            courseService.delete(course);
            return new ResponseEntity<>("Deleted course: " + foundCourse, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Course with id: " + course.getId() + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findCourseByNameContaining/{name}")
    public List<Course> getCoursesWithNameContaining(@PathVariable String name){
        return courseService.findByName(name);
    }
    @GetMapping("/deleteCourseByName/{name}")
    public String deleteCourseByName(@PathVariable String name){
        courseService.deleteCourseByName(name);
        return "Course deleted with name: "+ name;
    }
}
