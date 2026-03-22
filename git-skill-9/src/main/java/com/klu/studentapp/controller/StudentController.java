package com.klu.studentapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.studentapp.exception.InvalidInputException;
import com.klu.studentapp.exception.StudentNotFoundException;
import com.klu.studentapp.model.Student;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {

        int studentId;

        try {
            studentId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Student ID must be a number");
        }

        if (studentId != 1) {
            throw new StudentNotFoundException("Student with ID " + studentId + " not found");
        }

        return new Student(1, "Rahul", "CSE");
    }
}