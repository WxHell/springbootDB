package com.database.cruddemo.dao;

import com.database.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);
    Student findByID(int id);
}
