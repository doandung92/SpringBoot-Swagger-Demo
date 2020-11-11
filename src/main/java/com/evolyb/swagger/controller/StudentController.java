package com.evolyb.swagger.controller;

import com.evolyb.swagger.model.Student;
import com.evolyb.swagger.repository.StudentRepository;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Open API Documentation at http://localhost:8080/swagger-ui.html

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    @ApiOperation(value = "Find All Students",
            notes = "Get All Students"
    )
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find Student By Id",
            notes = "Provide an Id to find Student",
            response = Student.class
    )
    public Student findById(@ApiParam(value="ID value of Student", required = true) @PathVariable("id") Long id){
        return studentRepository.findById(id).orElse(null);
    }

    @PostMapping
    @ApiOperation(value = "Add New Student"
    )
    public Student addNewStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }
}
