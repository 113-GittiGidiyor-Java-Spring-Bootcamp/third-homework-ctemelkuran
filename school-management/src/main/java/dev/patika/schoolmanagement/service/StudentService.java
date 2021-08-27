package dev.patika.schoolmanagement.service;


import dev.patika.schoolmanagement.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements BaseService<Student>{

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public Student save(Student object) {
        return null;
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
}
