package dev.patika.schoolmanagement.controller;

import dev.patika.schoolmanagement.entity.Instructor;
import dev.patika.schoolmanagement.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {
    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> findAll(){
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/instructors")
    public Instructor saveInstructor(@RequestBody Instructor instructor){
        return instructorService.save(instructor);
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable int id){
        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/instructors")
    public Instructor updateInstructor(@RequestBody Instructor instructor){
        return instructorService.update(instructor);
    }
    @DeleteMapping("/instructors/{id}")
    public String deleteInstructorById(@PathVariable int id){
        instructorService.deleteById(id);
        return "Deleted id:" + id;
    }

    @DeleteMapping("/instructors")
    public ResponseEntity<String> deleteInstructorByEntity(@RequestBody Instructor instructor) {
        Instructor foundInstructor = instructorService.findById(instructor.getId());
        if (foundInstructor != null) {
            instructorService.delete(instructor);
            return new ResponseEntity<>("Deleted instructor: " + foundInstructor, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Instructor with id: " + instructor.getId() + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findInstructorByNameContaining/{name}")
    public List<Instructor> getInstructorsWithNameContaining(@PathVariable String name){
        return instructorService.findByName(name);
    }

    @GetMapping("/deleteInstructorByName/{name}")
    public String deleteInstructorByName(@PathVariable String name){
        instructorService.deleteInstructorByName(name);
        return "Instructor deleted with name: "+ name;
    }

    @GetMapping("/findFirst3InstructorBySalary")
    public List<?> getFirst3InstructorBySalary(){
        return instructorService.findFirst3BySalary();
    }
}
