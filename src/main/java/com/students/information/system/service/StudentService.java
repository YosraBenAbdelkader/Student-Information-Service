package com.students.information.system.service;

import com.students.information.system.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student findByStudentNumber(long studentNumber);

    Student findByEmail(String email);

    List<Student> findAllByOrderByGpa();

    Student saveOrUpdateStudent(Student student);

    void deleteStudent(String id);
    void deleteStudentById(String id);
}
