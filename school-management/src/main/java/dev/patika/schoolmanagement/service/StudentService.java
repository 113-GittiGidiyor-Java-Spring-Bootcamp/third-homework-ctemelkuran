package dev.patika.schoolmanagement.service;


import dev.patika.schoolmanagement.entity.Student;
import dev.patika.schoolmanagement.entity.Student;
import dev.patika.schoolmanagement.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements BaseService<Student>{


    private final StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Iterable<Student> studentIterable = studentRepository.findAll();
        studentIterable.iterator().forEachRemaining(studentList::add);
        return studentList;
    }

    @Override
    @Transactional(readOnly = true) // for find methods; readOnly increases the performance
    public Student findById(int id) {
        return studentRepository.findById(id).get();
    }


    @Override
    @Transactional
    public Student save(Student object) {
        return studentRepository.save(object);
    }

    @Override
    public Student update(Student object) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void delete(Student object) {

    }

    @Override
    public List<Student> findByName(String name) {
        return studentRepository.findByNameContaining(name);
    }

}
