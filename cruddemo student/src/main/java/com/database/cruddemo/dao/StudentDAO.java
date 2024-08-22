package com.database.cruddemo.dao;

import com.database.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findByID(int id);
    List<Student> findAll();
    List<Student>findByLastName(String lastName);
    void update(Student theStudent);
    void delete(Integer id);
    int deleteAll();
}
