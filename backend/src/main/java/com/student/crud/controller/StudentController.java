package com.student.crud.controller;

import com.student.crud.Dto.StudentDto;
import com.student.crud.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> findAll() {
        List<StudentDto> list = studentService.findAll();
        return ResponseEntity.ok().body(list);

        @GetMapping("/{id}")
        public ResponseEntity<StudentDto> findById(@PathVariable Long id) {
        StudentDto dto = studentService.findById(id);
        return ResponseEntity.ok().body(dto);
        }

    }
    @PostMapping
    public ResponseEntity<StudentDto> insert(@ResponseBody StudentDto dto) {
        dto = studentService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> update(@PathVariable Long id, @ResponseBody StudentDto dto) {
        dto = studentService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }
    @DeleteMapping"/{id}")
    public ResponseEntity<StudentDto> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
