package dev.patika.schoolmanagement.controller;

import dev.patika.schoolmanagement.entity.Instructor;
import dev.patika.schoolmanagement.entity.Student;
import dev.patika.schoolmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
     StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // GET All Students
    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable int id){
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        return studentService.update(student);
    }

    // DELETE by writing the id to URL
    @DeleteMapping("/students/{id}")
    public String deleteStudentById(@PathVariable int id){
        studentService.deleteById(id);
        return "Deleted id:" + id;
    }
    // DELETE by giving the entity
    @DeleteMapping("/students")
    public ResponseEntity<String> deleteStudentByEntity(@RequestBody Student student) {
        Student foundStudent = studentService.findById(student.getId());
        if (foundStudent != null) {
            studentService.delete(student);
            return new ResponseEntity<>("Deleted student: " + foundStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Student with id: " + student.getId() + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findStudentByNameContaining/{name}")
    public List<Student> getStudentsWithNameContaining(@PathVariable String name){
        return studentService.findByName(name);
    }

    @GetMapping("/getStudentGendersWithGrouping")
    public List<?> getStudentGendersWithGrouping(){
        return studentService.getGendersWithGrouping();
    }

    @GetMapping("/deleteStudentByName/{name}")
    public String deleteStudentByName(@PathVariable String name){
        studentService.deleteStudentByName(name);
        return "Student deleted with name: "+ name;
    }
}
