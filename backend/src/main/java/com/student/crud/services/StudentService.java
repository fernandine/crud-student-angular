package com.student.crud.services;

import com.student.crud.Dto.StudentDto;
import com.student.crud.domain.Student;
import com.student.crud.repositories.StudentRepository;
import com.student.crud.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;


    public List<StudentDto> findAll() {
        List<Student> list = repository.findAll();
        return list.stream().map(x -> new StudentDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public StudentDto findById(Long id) {
        Optional<Student> obj = repository.findById(id);
        Student student = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new StudentDto(student);

    }

    @Transactional
    public StudentDto insert(StudentDto dto) {
        Student entity = new Student();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAge(dto.getAge());
        entity.setGender(dto.getGender());
        entity = repository.save(entity);
        return new StudentDto(entity);
    }

    @Transactional
    public StudentDto update(Long id, StudentDto dto) {
        Student entity = repository.getReferenceById(id);
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAge(dto.getAge());
        entity.setGender(dto.getGender());
        entity = repository.save(entity);
        return new StudentDto(entity);

    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
