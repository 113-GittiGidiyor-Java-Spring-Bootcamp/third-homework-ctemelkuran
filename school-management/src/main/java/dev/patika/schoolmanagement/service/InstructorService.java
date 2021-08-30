package dev.patika.schoolmanagement.service;

import dev.patika.schoolmanagement.entity.Instructor;
import dev.patika.schoolmanagement.entity.Instructor;
import dev.patika.schoolmanagement.repository.InstructorRepository;
import dev.patika.schoolmanagement.repository.PermanentInstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService implements BaseService<Instructor>{

    private final InstructorRepository instructorRepository;
    private final PermanentInstructorRepository permanentInstructorRepository;

    @Override
    public List<Instructor> findAll() {
        List<Instructor> instructorList = new ArrayList<>();
        Iterable<Instructor> instructorIterable = instructorRepository.findAll();
        instructorIterable.iterator().forEachRemaining(instructorList::add);
        return instructorList;
    }

    @Override
    @Transactional(readOnly = true) // for find methods; readOnly increases the performance
    public Instructor findById(int id) {
        return instructorRepository.findById(id).get();
    }


    @Override
    @Transactional
    public Instructor save(Instructor object) {
        return instructorRepository.save(object);
    }

    @Override
    public Instructor update(Instructor object) {
        return instructorRepository.save(object);
    }

    @Override
    public void deleteById(int id) {
        instructorRepository.deleteById(id);
    }

    @Override
    public void delete(Instructor object) {
        instructorRepository.delete(object);
    }

    @Override
    public List<Instructor> findByName(String name) {
        return instructorRepository.findByNameContaining(name);
    }

    @Transactional
    public void deleteInstructorByName(String name){
        instructorRepository.deleteInstructorByName(name);
    };

//    @Override
//    public List<?> findFirst3BySalary(){
//        return permanentInstructorRepository.findTop3ByFixedSalary();
//    }
}
